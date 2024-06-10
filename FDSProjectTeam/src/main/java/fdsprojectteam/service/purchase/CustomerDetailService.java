package fdsprojectteam.service.purchase;

import fdsprojectteam.command.MonthlytSumPurchaseCommand;
import fdsprojectteam.domain.MonthlySumPurchaseDTO;
import fdsprojectteam.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerDetailService {

    private final PaymentMapper  paymentMapper;

    public MonthlytSumPurchaseCommand execute(Model model, String customerId, String purchaseId, String cardId) {
        Map<String, Object> result = new HashMap<>();
        result.put("customerId", customerId);
        result.put("purchaseId", purchaseId);
        result.put("cardId", cardId);
        List<MonthlySumPurchaseDTO> purchases = paymentMapper.monthlyAveragePurchaseSelect(result);

        List<String> months = purchases.stream()
                .map(MonthlySumPurchaseDTO::getMonth)
                .map(month -> "\"" + month + "\"")
                .collect(Collectors.toList());

        List<Integer> sumPrices = purchases.stream()
                .map(MonthlySumPurchaseDTO::getSumPrice)
                .collect(Collectors.toList());

        List<Integer> maxPrices = purchases.stream()
                .map(MonthlySumPurchaseDTO::getMaxPrice)
                .collect(Collectors.toList());

        return new MonthlytSumPurchaseCommand(months, sumPrices, maxPrices);
    }
}
