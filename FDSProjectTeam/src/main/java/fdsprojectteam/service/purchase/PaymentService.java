package fdsprojectteam.service.purchase;

import fdsprojectteam.command.PurchaseCommand;
import fdsprojectteam.domain.CardDTO;
import fdsprojectteam.domain.CountryDTO;
import fdsprojectteam.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

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
        if (countryDTO != null) {
            if(cardDTO.getErrorCount() <= 5){
                if(countryDTO.getCountryCode() != cardDTO.getIssueCountry()) { // 고객의 결제 지역과 해당 카드의 발급 국가를 비교하여 불일치가 발생할 경우
                    int newErrorCount = cardDTO.getErrorCount() + 1;
                    Map<String, Object> map = new HashMap<>();
                    map.put("errorCount", newErrorCount);
                    map.put("cardNum", cardDTO.getCardNum());
                    paymentMapper.errorCountUpdate(map);

                    model.addAttribute("ipAddress", purchaseCommand.getIpAddress());
                    model.addAttribute("errorCount", newErrorCount);
                    answer = 2;
                }else {// 거래 성공
                    answer = 0;
                }
            }else { // 이상 거래 5회 초과시
                paymentMapper.tradingHaltUpdate(cardDTO);
                answer = 2;
            }
        }else {// IP정보가 잘못되었을때.
            answer = 1;
        }
        return answer;
    }
}
