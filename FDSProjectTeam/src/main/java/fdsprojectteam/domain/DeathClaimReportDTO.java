package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Alias("deathClaimReport")
@AllArgsConstructor
@NoArgsConstructor
public class DeathClaimReportDTO {
    String reportNum;
    String reportSubject;
    String reportContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date reportDate;
}
