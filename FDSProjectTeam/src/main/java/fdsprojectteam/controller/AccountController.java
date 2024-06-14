package fdsprojectteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fdsprojectteam.command.AccountCommand;
import fdsprojectteam.service.account.AccountChartService;
import fdsprojectteam.service.account.AccountResultService;



@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	AccountResultService accountResultService;
	@Autowired
	AccountChartService accountChartService;
	
	@GetMapping("accountCheck")
	public String account() {
		return "thymeleaf/account/accountForm";
	}
	@PostMapping("accountCheck")
	public String accountCheck(Model model, @RequestParam("accountNum")String accountNum, 
								@RequestParam("accmemName")String accmemName, 
								@RequestParam("accmemNum")String accmemNum) {
		accountResultService.execute(model, accountNum, accmemName, accmemNum);
		return "thymeleaf/account/accountResult";
	}
	@GetMapping("accountChart")
    public String accountChart(@RequestParam("accountNum") String accountNum, Model model) {
        String chartData = accountChartService.execute(accountNum);
        model.addAttribute("chartData", chartData);
        return "thymeleaf/account/accountChart";
    }
	
}
