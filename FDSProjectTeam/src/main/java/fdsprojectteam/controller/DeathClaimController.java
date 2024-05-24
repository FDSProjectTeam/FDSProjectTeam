package fdsprojectteam.controller;

import fdsprojectteam.command.DeathClaimCommand;
import fdsprojectteam.service.DeathClaimAutoNumService;
import fdsprojectteam.service.DeathClaimWriteService;
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
}
