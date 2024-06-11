package fdsprojectteam.service.purchase;

import fdsprojectteam.domain.PurchaseDTO;
import fdsprojectteam.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseErrorListService {

    private final PaymentMapper paymentMapper;

    public void execute(Model model) {
        List<PurchaseDTO> list = paymentMapper.purchaseErrorSelect();
        model.addAttribute("list", list);
    }
}
