package fdsprojectteam.controller;

import fdsprojectteam.command.DeathClaimCommand;
import fdsprojectteam.service.deathClaim.DeathClaimAutoNumService;
import fdsprojectteam.service.deathClaim.DeathClaimListService;
import fdsprojectteam.service.deathClaim.DeathClaimWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("deathClaim")
public class DeathClaimController {
    @Autowired
    DeathClaimAutoNumService deathClaimAutoNumService;
    @Autowired
    DeathClaimWriteService deathClaimWriteService;
    @Autowired
    DeathClaimListService deathClaimListService;
    @GetMapping("deathClaimWrite")
    public String deathClaimForm(Model model){
        deathClaimAutoNumService.execute(model);
        return "thymeleaf/deathClaim/deathClaimForm";
    }
    @PostMapping("deathClaimWrite")
    public String deathClaimWrite(DeathClaimCommand deathClaimCommand){
        deathClaimWriteService.execute(deathClaimCommand);
        return "thymeleaf/deathClaim/deathClaimResult";
    }
    @RequestMapping("deathClaimList")
    public String deathClaimList(Model model){
        deathClaimListService.execute(model);
        return "thymeleaf/deathClaim/deathClaimList";
    }
}
