package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeathClaimDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class DeathClaimListService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    public void execute(Model model){
        DeathClaimDTO deathClaimDTO = new DeathClaimDTO();
        List<DeathClaimDTO> list = deathClaimMapper.allSelect(deathClaimDTO);
        model.addAttribute("dtos", list);
    }
}
