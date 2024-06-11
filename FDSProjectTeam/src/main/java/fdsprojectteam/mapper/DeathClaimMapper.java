package fdsprojectteam.mapper;

import fdsprojectteam.domain.DeathClaimCountDTO;
import fdsprojectteam.domain.DeathClaimDTO;
import fdsprojectteam.domain.DeathClaimPlaceCountDTO;
import fdsprojectteam.domain.DeathClaimSearchAndPageDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeathClaimMapper {
    public List<DeathClaimDTO> allSelect(DeathClaimSearchAndPageDTO sepDTO);
    public int deathClaimCount(String searchWord);
    public List<DeathClaimCountDTO> selectCount();
    public List<DeathClaimPlaceCountDTO> selectPlaceCount();
    public DeathClaimDTO selectOne(String claimNum);
}
