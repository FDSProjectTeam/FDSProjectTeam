package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeathClaimCountDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeathClaimCountService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    public List<DeathClaimCountDTO> execute(){
        return deathClaimMapper.selectCount();
    }
}
