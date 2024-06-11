package fdsprojectteam.controller;

import fdsprojectteam.command.DeathClaimCommand;
import fdsprojectteam.domain.DeathClaimCountDTO;
import fdsprojectteam.domain.DeathClaimDTO;
import fdsprojectteam.domain.DeathClaimPlaceCountDTO;
import fdsprojectteam.service.deathClaim.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    DeathClaimCountService deathClaimCountService;
    @Autowired
    DeathClaimPlaceCountService deathClaimPlaceCountService;
    @Autowired
    DeathClaimAnalyzeService deathClaimAnalyzeService;
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
    @GetMapping("deathClaimList")
    public String deathClaimList(@RequestParam(value = "searchWord", required = false) String searchWord
                                ,@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
                                ,@RequestParam(value = "item", required = false) String item
                                ,Model model){
        model.addAttribute("item", item);
        deathClaimListService.execute(searchWord, model, page);
        return "thymeleaf/deathClaim/deathClaimList";
    }
    @PostMapping("deathClaimCount")
    public @ResponseBody List<DeathClaimCountDTO> deathClaimCount() throws Exception{
        return deathClaimCountService.execute();
    }
    @PostMapping("deathClaimPlaceCount")
    public @ResponseBody List<DeathClaimPlaceCountDTO> deathClaimPlaceCount() throws Exception{
        return deathClaimPlaceCountService.execute();
    }
    @PostMapping("deathClaimDetail")
    @ResponseBody
    public DeathClaimDTO deathClaimDetail(@RequestParam(value = "claimNum") String claimNum, Model model){
        DeathClaimDTO dto = deathClaimDetailService.execute(claimNum, model);
        return dto;
    }
    // 사망보험 파트의 메인 페이지입니다.
    @GetMapping("deathClaimChart")
    public String deathClaimChart(Model model){
        deathClaimAnalyzeService.execute(model);
        return "thymeleaf/deathClaim/deathClaimChart";
    }
}
