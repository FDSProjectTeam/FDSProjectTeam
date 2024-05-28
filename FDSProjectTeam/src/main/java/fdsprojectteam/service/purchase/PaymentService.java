package fdsprojectteam.service.purchase;

import fdsprojectteam.command.PurchaseCommand;
import fdsprojectteam.domain.CardDTO;
import fdsprojectteam.domain.CountryDTO;
import fdsprojectteam.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public void execute(PurchaseCommand purchaseCommand) {
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
    }
}
