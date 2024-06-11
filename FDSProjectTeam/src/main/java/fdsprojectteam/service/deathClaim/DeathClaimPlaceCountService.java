package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeathClaimPlaceCountDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeathClaimPlaceCountService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    public List<DeathClaimPlaceCountDTO> execute(){
        return deathClaimMapper.selectPlaceCount();
    }
}
