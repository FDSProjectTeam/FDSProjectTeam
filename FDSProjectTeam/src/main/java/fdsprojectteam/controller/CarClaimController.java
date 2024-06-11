package fdsprojectteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fdsprojectteam.command.CarClaimCommand;
import fdsprojectteam.service.carclaim.CarClaimWriteService;

@Controller
public class CarClaimController {
	@Autowired
	CarClaimWriteService carClaimWriteService;
	
	@GetMapping("carClaim")
	public String carClaimForm(Model model) {
		return "thymeleaf/carClaim/carClaimForm";
	}
    @PostMapping("carClaimWrite")
    public String carClaim(CarClaimCommand carClaimCommand, Model model) {
        List<String> resultMessages = carClaimWriteService.execute(carClaimCommand, model);
        model.addAttribute("resultMessages", resultMessages);
     // 클레임 처리 결과 설정

        return "thymeleaf/carClaim/carClaimResult";
	}
}
