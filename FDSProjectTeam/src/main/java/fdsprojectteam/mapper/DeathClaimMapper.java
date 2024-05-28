package fdsprojectteam.mapper;

import fdsprojectteam.domain.DeathClaimDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeathClaimMapper {
    public List<DeathClaimDTO> allSelect(DeathClaimDTO deathClaimDTO);
}
