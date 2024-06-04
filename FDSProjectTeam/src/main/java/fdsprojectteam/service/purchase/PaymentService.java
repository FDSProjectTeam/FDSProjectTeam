package fdsprojectteam.service.purchase;

import fdsprojectteam.command.PurchaseCommand;
import fdsprojectteam.domain.*;
import fdsprojectteam.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public int execute(PurchaseCommand purchaseCommand, Model model) {
        // 입력된 카드 정보들
        CardDTO cardDTO = paymentMapper.cardSelectOne(purchaseCommand.getCardNum());

        // 입력된 ip에대한 정보들
        String[] octets = purchaseCommand.getIpAddress().split("\\."); // IPv4 주소를 옥텟으로 분리
        long result = 0;
        for(int i = 0; i < octets.length; i++){
            result |= (Long.parseLong(octets[i]) << (24 - (i * 8))); // 옥텟을 변환하여 결합
        }
        // System.out.println(result);
        CountryDTO countryDTO = paymentMapper.countrySelectOne(result);
        // System.out.println(cardDTO.getCardId());
        // System.out.println(countryDTO.getCountryCode());

        int answer;
        /*
        answer = 0 => 결제 성공
        answer = 1 => 카드정지 페이지
        answer = 2 => 이상거래 페이지
         */
        if (countryDTO != null && cardDTO != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("ipAddress", result);
            map.put("customerId", purchaseCommand.getCustomerId());
            IPBlockDTO ipBlockDTO = paymentMapper.ipBlockSelect(map);
            int ipBlockCount = paymentMapper.ipBlockCount(result);
            if(cardDTO.getErrorCount() <= 5 && (ipBlockDTO == null || ipBlockCount <= 5)){
                int avgPrice = paymentMapper.avgPriceSelect(cardDTO.getCardId());
                int purchaseCount = paymentMapper.purchaseCount(purchaseCommand.getCustomerId());
                IPAgreeDTO ipAgreeDTO = paymentMapper.ipAgreeSelect(map);

                if(!Objects.equals(countryDTO.getCountryCode(), cardDTO.getIssueCountry()) && ipAgreeDTO == null) { // 고객의 결제 지역과 해당 카드의 발급 국가를 비교하여 불일치가 발생할 경우
                    updateErrorCount(cardDTO);

                    model.addAttribute("purchaseCommand", purchaseCommand);
                    model.addAttribute("errorMessage", "다른 국가에서 결제 시도가 있었습니다.");
                    answer = 2;
                }else if((avgPrice < 1000000 && purchaseCommand.getPurchasePrice() >= 1000000) ||
                        (avgPrice >= 1000000 && (avgPrice * 2 <= purchaseCommand.getPurchasePrice() && purchaseCommand.getPurchasePrice() <= 10000000))) {
                    updateErrorCount(cardDTO);

                    model.addAttribute("errorMessage", "비정상적인 거래금액입니다.");
                    answer = 2;
                }else if(purchaseCount > 30) {
                    updateErrorCount(cardDTO);

                    model.addAttribute("errorMessage", "비정상적인 거래 횟수입니다.");
                    answer = 2;
                }else {// 거래 성공
                    PurchaseDTO dto = new PurchaseDTO();
                    BeanUtils.copyProperties(purchaseCommand, dto);
                    dto.setCardId(cardDTO.getCardId());
                    dto.setCountryId(countryDTO.getCountryId());
                    paymentMapper.purchaseInsert(dto);
                    paymentMapper.cardErrorCountUpdate(cardDTO.getCardId());
                    answer = 0;
                }
            }else { // 이상 거래 5회 초과시, 차단된 ip이거나 다른 5명 이상의 사람이 차단한 ip일때
                paymentMapper.tradingHaltUpdate(cardDTO);

                model.addAttribute("errorMessage", "이상 거래 5회 초과로 카드 정지 되었습니다.");
                model.addAttribute("errorCount", cardDTO.getErrorCount());
                answer = 2;
            }
        }else {// IP정보가 잘못되었을때. 또는 거래 정지 카드일 경우.
            TradingHaltDTO tradingHaltDTO = paymentMapper.tradingHaltSelectOne(purchaseCommand.getCardNum());
            model.addAttribute("tradingHaltCommand", tradingHaltDTO);
            answer = 1;
        }
        return answer;
    }
    private void updateErrorCount(CardDTO cardDTO) {
        int newErrorCount = cardDTO.getErrorCount() + 1;
        Map<String, Object> map = new HashMap<>();
        map.put("errorCount", newErrorCount);
        map.put("cardNum", cardDTO.getCardNum());
        paymentMapper.errorCountUpdate(map);
    }
}
