package fdsprojectteam.controller;

import fdsprojectteam.command.DeathClaimCommand;
import fdsprojectteam.domain.DeathClaimDTO;
import fdsprojectteam.service.deathClaim.DeathClaimAutoNumService;
import fdsprojectteam.service.deathClaim.DeathClaimDetailService;
import fdsprojectteam.service.deathClaim.DeathClaimListService;
import fdsprojectteam.service.deathClaim.DeathClaimWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Controller
@RequestMapping("deathClaim")
public class DeathClaimController {
    @Autowired
    DeathClaimAutoNumService deathClaimAutoNumService;
    @Autowired
    DeathClaimWriteService deathClaimWriteService;
    @Autowired
    DeathClaimListService deathClaimListService;
    @Autowired
    DeathClaimDetailService deathClaimDetailService;
    @GetMapping("deathClaimWrite")
    public String deathClaimForm(Model model){
        deathClaimAutoNumService.execute(model);
        return "thymeleaf/deathClaim/deathClaimForm";
    }
    @PostMapping("deathClaimWrite")
    public String deathClaimWrite(@Validated DeathClaimCommand deathClaimCommand, BindingResult result, Model model) throws Exception {
        if(result.hasErrors()){
            return "thymeleaf/deathClaim/deathClaimForm";
        }
        deathClaimWriteService.execute(deathClaimCommand, model);
        return "thymeleaf/deathClaim/deathClaimResult";
    }
    @RequestMapping("deathClaimList")
    public String deathClaimList(Model model){
        deathClaimListService.execute(model);
        return "thymeleaf/deathClaim/deathClaimList";
    }
    @PostMapping("deathClaimDetail")
    @ResponseBody
    public DeathClaimDTO deathClaimDetail(String claimNum, Model model){
        DeathClaimDTO dto = deathClaimDetailService.execute(claimNum, model);
        return dto;
    }
}
