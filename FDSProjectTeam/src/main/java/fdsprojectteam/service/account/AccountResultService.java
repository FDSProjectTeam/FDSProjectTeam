package fdsprojectteam.service.account;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fdsprojectteam.domain.AccTransfertInfoDTO;
import fdsprojectteam.domain.AccountMemberDTO;
import fdsprojectteam.mapper.AccountMapper;

@Service
public class AccountResultService {
	@Autowired
	AccountMapper accountMapper;
	public void execute(Model model, String accountNum, String accmemName, String accmemNum) {
		AccountMemberDTO amdto = accountMapper.accountMemberSelect(accountNum, accmemName, accmemNum);
		model.addAttribute("amdto", amdto);
		List<AccTransfertInfoDTO> list = new ArrayList<AccTransfertInfoDTO>();
		list = accountMapper.transferInfoList(accountNum);
		
		Integer incomeTotal = 0;
		Integer outcomeTotal = 0;
		Integer incomeCount = 0;
		Integer outcomeCount = 0;
		for(AccTransfertInfoDTO dto : list) {
			if(dto.getIncomePrice() > 0) {
				incomeTotal += dto.getIncomePrice();
				incomeCount++;
			}
			if(dto.getOutcomePrice() > 0) {
				outcomeTotal += dto.getOutcomePrice();
				outcomeCount++;
			}
		}
		Integer avgIncome = 0;
		Integer avgOutcome = 0;
		if(incomeCount > 10) {
			avgIncome = incomeTotal / incomeCount;
		}
		if(outcomeCount > 10) {
			avgOutcome = outcomeTotal / outcomeCount;
		}
		
		boolean avgincomDifferece = false;
        boolean avgOutcomDifferece = false;
        boolean sequenceFound = false;
        boolean cashOutAbnormal = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String previousDate = "";
		Integer dateCount = 0;
		Integer outcomeDateCount = 0;
		String cashoutDate = "";
		for(AccTransfertInfoDTO dto : list) {
			//1. 평균구하기
			if((dto.getIncomePrice() > avgIncome*200)) {
				avgincomDifferece = true;
			}if((dto.getOutcomePrice() > avgOutcome*200)) {
				avgOutcomDifferece = true;
			}
			
			//2. 같은날 큰 금액이 여러번 발생했을때
			String incomeDate = sdf.format(dto.getIncomeDate());
			String outcomeDate = sdf.format(dto.getOutcomeDate());
			//income
			if(dto.getIncomePrice() >= avgIncome) {
				if(incomeDate.equals(previousDate)) {
					dateCount++;
					if(dateCount >= 5) {
						sequenceFound = true;
					}
				}else {
					previousDate = incomeDate;
					dateCount = 1;
				}
			}else {
				dateCount = 0;	
			}
			//outcome
			if(dto.getOutcomePrice() >= avgOutcome) {
				if(outcomeDate.equals(previousDate)) {
					dateCount++;
					if(dateCount >= 5) {
						sequenceFound = true;
					}
				}else {
					previousDate = outcomeDate;
					dateCount = 1;
				}
			}else {
				dateCount = 0;
			}
			
			//3.현금인출이 많을때
			//현금인출이 200이상씩 같은날 2번이상 인출할때
			outcomeDate = sdf.format(dto.getOutcomeDate());
			if(dto.getOutcomePrice() >= 2000000 && dto.getTransferContent().equals("현금인출")) {
				if(outcomeDate.equals(cashoutDate)) {
					outcomeDateCount++;
					if(outcomeDateCount >= 2) {
						cashOutAbnormal = true;
					}
				}else {
					cashoutDate = outcomeDate;
					outcomeDateCount = 1;
				}
			}else {
				outcomeDateCount = 0;
			}
			
		}
		
		model.addAttribute("avgincomDifferece", avgincomDifferece);
        model.addAttribute("avgOutcomDifferece", avgOutcomDifferece);
        model.addAttribute("sequenceFound", sequenceFound);
        model.addAttribute("cashOutAbnormal", cashOutAbnormal);
	}
	
}
