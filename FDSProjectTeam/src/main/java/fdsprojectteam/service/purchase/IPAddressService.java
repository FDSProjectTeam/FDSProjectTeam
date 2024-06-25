package fdsprojectteam.service.purchase;

import fdsprojectteam.command.PurchaseCommand;
import fdsprojectteam.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IPAddressService {

    private final PaymentMapper paymentMapper;

    public void execute(String ipAddress, String customerId) {
        String[] octets = ipAddress.split("\\."); // IPv4 주소를 옥텟으로 분리
        long result = 0;
        for(int i = 0; i < octets.length; i++){
            result |= (Long.parseLong(octets[i]) << (24 - (i * 8))); // 옥텟을 변환하여 결합
        }

        Map<String, Object> map = new HashMap<>();
        map.put("ipAddress", result);
        map.put("customerId", customerId);
        paymentMapper.ipAgreeInsert(map);
    }
}
