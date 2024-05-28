package fdsprojectteam.controller;

import fdsprojectteam.command.PurchaseCommand;
import fdsprojectteam.service.purchase.PaymentService;
import fdsprojectteam.service.purchase.PurchaseAutoNumSelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CreditCardController {

    private final PurchaseAutoNumSelectService purchaseAutoNumSelectService;
    private final PaymentService paymentService;

    @GetMapping("creditCard")
    public String creditCard(Model model){
        // purchaseAutoNumSelectService.execute(model);
        return "thymeleaf/purchase/creditCardForm";
    }

    @PostMapping("payment")
    public String payment(Model model, PurchaseCommand purchaseCommand){
        // request.getremoteaddr() : 입력한 사람의 ip주소를 받아오는 명령어
        paymentService.execute(purchaseCommand);
        return "";
    }
}
