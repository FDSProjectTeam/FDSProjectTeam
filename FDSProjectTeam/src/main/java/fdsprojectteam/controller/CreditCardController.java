package fdsprojectteam.controller;

import fdsprojectteam.service.purchase.PurchaseAutoNumSelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CreditCardController {

    private final PurchaseAutoNumSelectService purchaseAutoNumSelectService;

    @GetMapping("creditCard")
    public String creditCard(Model model){
        purchaseAutoNumSelectService.execute(model);
        return "thymeleaf/purchase/creditCard";
    }
}
