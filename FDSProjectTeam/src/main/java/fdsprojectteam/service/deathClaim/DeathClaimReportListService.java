package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeathClaimReportDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class DeathClaimReportListService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    public List<DeathClaimReportDTO> execute(Model model){
        List<DeathClaimReportDTO> list = deathClaimMapper.allSelectReport();
        model.addAttribute("dtos", list);
        return list;
    }
}
