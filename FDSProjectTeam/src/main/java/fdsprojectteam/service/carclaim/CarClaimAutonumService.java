package fdsprojectteam.service.carclaim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fdsprojectteam.command.CarClaimCommand;
import fdsprojectteam.mapper.CarClaimAutoNumMapper;

@Service
public class CarClaimAutonumService {
	@Autowired
	CarClaimAutoNumMapper carClaimAutoNumMapper;
	public void execute(Model model) {
		String claimNumber = carClaimAutoNumMapper.autoNum("carclaim","claim_number", "ccn");
		CarClaimCommand carClaimCommand = new CarClaimCommand();
		carClaimCommand.setClaimNumber(claimNumber);
		model.addAttribute("carClaimCommand" ,carClaimCommand);
	}
}
