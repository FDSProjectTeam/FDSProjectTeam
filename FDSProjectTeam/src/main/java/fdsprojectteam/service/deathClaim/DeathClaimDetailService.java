package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeathClaimDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class DeathClaimDetailService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    public DeathClaimDTO execute(String claimNum, Model model){
        DeathClaimDTO dto = deathClaimMapper.selectOne(claimNum);
        model.addAttribute("dto", dto);
        return dto;
    }
}
