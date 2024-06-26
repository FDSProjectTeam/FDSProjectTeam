package fdsprojectteam.service.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fdsprojectteam.domain.AccTransfertInfoDTO;
import fdsprojectteam.mapper.AccountMapper;


@Service
public class AccountChartService {
	@Autowired
	AccountMapper accountMapper;
	public String execute(String accountNum) {
		List<AccTransfertInfoDTO> list = accountMapper.transferInfoList(accountNum);
//		String aa = "";
//		String bb = "";
		StringJoiner aa = new StringJoiner(", ");
		StringJoiner bb = new StringJoiner(", ");
		//평균구하기
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
		
		for(AccTransfertInfoDTO dto : list) {
			Integer income = dto.getIncomePrice();
			Integer outcome = dto.getOutcomePrice();
			String incomeDate = null;
			String outcomeDate = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			incomeDate = sdf.format(dto.getIncomeDate());
			outcomeDate = sdf.format(dto.getOutcomeDate());
			if (avgIncome > 0 && income > 0) {
				aa.add("[\"" + incomeDate + "\", " + income + ", \"blue\"]");
			} else if (avgOutcome > 0 && outcome > 0) {
				bb.add("[\"" + outcomeDate + "\", " + outcome + ", \"blue\"]");
			}
		}
		String result = "[[\"Data\", \"Value\", \"Style\"], " + aa.toString() + (aa.length() > 0 && bb.length() > 0 ? ", " : "") + bb.toString() + "]";
		System.out.println("Result: " + result);
		return result;
	}
		
}

