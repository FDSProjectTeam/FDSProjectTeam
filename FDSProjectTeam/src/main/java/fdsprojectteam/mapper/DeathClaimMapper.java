package fdsprojectteam.mapper;

import fdsprojectteam.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeathClaimMapper {
    public List<DeathClaimDTO> allSelect(DeathClaimSearchAndPageDTO sepDTO);
    public int deathClaimCount(String searchWord);
    public List<DeathClaimCountDTO> selectCount();
    public List<DeathClaimPlaceCountDTO> selectPlaceCount();
    public DeathClaimDTO selectOne(String claimNum);
    public void insertDenied(DeniedListDTO deniedListDTO);
    public String generateDeniedNum();
    public List<DeniedListCountDTO> selectDeniedList();
    public String generateReportNum();
    public void insertReport(DeathClaimReportDTO deathClaimReportDTO);
    public List<DeathClaimReportDTO> allSelectReport();
}
