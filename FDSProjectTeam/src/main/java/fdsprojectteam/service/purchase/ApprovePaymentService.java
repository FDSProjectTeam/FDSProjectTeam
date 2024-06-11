package fdsprojectteam.service.purchase;

import fdsprojectteam.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApprovePaymentService {

    private final PaymentMapper paymentMapper;

    public void execute(String customerId, String purchaseId, String cardId) {
    }
}
