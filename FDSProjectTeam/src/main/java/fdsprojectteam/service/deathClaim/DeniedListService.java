package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeniedListCountDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeniedListService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    public List<DeniedListCountDTO> execute(){
        return deathClaimMapper.selectDeniedList();
    }
}
