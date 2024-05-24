package fdsprojectteam.service.deathClaim;

import fdsprojectteam.command.DeathClaimCommand;
import fdsprojectteam.command.PurchaseCommand;
import fdsprojectteam.mapper.AutoNumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeathClaimAutoNumService {
    @Autowired
    AutoNumMapper autoNumMapper;
    public void execute(Model model){
        Map<String, String> map = new HashMap<>();
        map.put("tableName", "DEATH_CLAIM");
        map.put("columnName", "CLAIM_NUM");
        map.put("sep", "DEC");
        String claimNum = autoNumMapper.autoNumSelect(map);
        DeathClaimCommand deathClaimCommand = new DeathClaimCommand();
        deathClaimCommand.setClaimNum(claimNum);

        model.addAttribute("deathClaimCommand", deathClaimCommand);
    }
}
