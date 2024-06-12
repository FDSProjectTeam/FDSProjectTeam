package fdsprojectteam.controller;

import fdsprojectteam.command.MonthlytSumPurchaseCommand;
import fdsprojectteam.command.PurchaseCommand;
import fdsprojectteam.service.purchase.*;
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
    private final IPAddressService ipAddressService;
    private final IPBlockService ipBlockService;
    private final PurchaseErrorListService purchaseErrorListService;
    private final CustomerDetailService customerDetailService;
    private final ApprovePaymentService approvePaymentService;
    private final CancelPaymentService cancelPaymentService;

    @GetMapping("creditCard")
    public String creditCard(Model model){
        purchaseAutoNumSelectService.execute(model);
        return "thymeleaf/purchase/creditCardForm";
    }

    @PostMapping("payment")
    public String payment(Model model, PurchaseCommand purchaseCommand){
        // request.getremoteaddr() : 입력한 사람의 ip주소를 받아오는 명령어
        int i = paymentService.execute(purchaseCommand, model);
        // System.out.println(i);
        if (i == 0) {
            return "thymeleaf/purchase/creditCardSuccess";
        }else{
            model.addAttribute("errorCode", i);
            return "thymeleaf/purchase/creditCardFail";
        }
    }

    @GetMapping("ipAgree")
    public String ipAddress(Model model, String ipAddress, String customerId){
        ipAddressService.execute(ipAddress, customerId);
        return "thymeleaf/purchase/ipAgree";
    }

    @GetMapping("ipBlock")
    public String ipBlock(Model model, String ipAddress, String customerId){
        ipBlockService.execute(ipAddress, customerId);
        return "thymeleaf/purchase/ipBlock";
    }

    @GetMapping("pgAdmin")
    public String pgAdmin(Model model){
        purchaseErrorListService.execute(model);
        return "thymeleaf/purchase/pgAdmin";
    }

    @GetMapping("customerPage")
    public String customerPage(Model model, String customerId, String purchaseId, String cardId){
        MonthlytSumPurchaseCommand monthlytSumPurchaseCommand = customerDetailService.execute(model, customerId, purchaseId, cardId);
        model.addAttribute("monthlytAveragePurchaseCommand", monthlytSumPurchaseCommand);
        return "thymeleaf/purchase/customerPage";
    }

    @GetMapping("approvePayment")
    public String approvePayment(Model model, String customerId, String purchaseId, String cardId){
        approvePaymentService.execute(customerId, purchaseId, cardId);
        return "redirect:/customerPage?purchaseId=" + purchaseId + "&cardId=" + cardId + "&customerId=" + customerId;
    }

    @GetMapping("cancelPayment")
    public String cancelPayment(Model model, String customerId, String purchaseId, String cardId){
        cancelPaymentService.execute(customerId, purchaseId, cardId);
        return "redirect:/customerPage?purchaseId=" + purchaseId + "&cardId=" + cardId + "&customerId=" + customerId;
    }
}
