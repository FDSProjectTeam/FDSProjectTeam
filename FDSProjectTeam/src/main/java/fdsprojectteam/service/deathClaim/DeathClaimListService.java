package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeathClaimDTO;
import fdsprojectteam.domain.DeathClaimSearchAndPageDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class DeathClaimListService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    @Autowired
    DeathClaimPageService deathClaimPageService;
    public List<DeathClaimDTO> execute(String searchWord, Model model, Integer page){
        Integer limit = 10;
        DeathClaimSearchAndPageDTO sepDTO = deathClaimPageService.execute(limit, page, searchWord);
        DeathClaimSearchAndPageDTO deathClaimSearchAndPageDTO = new DeathClaimSearchAndPageDTO();
        List<DeathClaimDTO> list = deathClaimMapper.allSelect(sepDTO);
        Integer count = deathClaimMapper.deathClaimCount(searchWord);
        deathClaimPageService.execute(page, count, limit, model, searchWord);
        model.addAttribute("dtos", list);
        return list;
    }
}
