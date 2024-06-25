package fdsprojectteam.service.deathClaim;

import fdsprojectteam.command.DeathClaimReportCommand;
import fdsprojectteam.domain.DeathClaimReportDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeathClaimReportWriteService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    public void execute(DeathClaimReportCommand deathClaimReportCommand){
        DeathClaimReportDTO dto = new DeathClaimReportDTO();
        String reportNum = deathClaimMapper.generateReportNum();
        dto.setReportNum(reportNum);
        dto.setReportSubject(deathClaimReportCommand.getReportSubject());
        dto.setReportContent(deathClaimReportCommand.getReportContent());
        deathClaimMapper.insertReport(dto);
    }
}
