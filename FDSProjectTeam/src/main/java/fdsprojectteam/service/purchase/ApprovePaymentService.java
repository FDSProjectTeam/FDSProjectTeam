package fdsprojectteam.service.purchase;

import fdsprojectteam.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApprovePaymentService {

    private final PaymentMapper paymentMapper;

    public void execute(String customerId, String purchaseId, String cardId) {
        Map<String, Object> result = new HashMap<>();
        result.put("customerId", customerId);
        result.put("purchaseId", purchaseId);
        result.put("cardId", cardId);
        paymentMapper.purchaseStatusUpdate(result);
        paymentMapper.cardErrorCountUpdate(cardId);
    }
}
