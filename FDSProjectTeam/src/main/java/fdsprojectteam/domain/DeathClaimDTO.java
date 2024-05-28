package fdsprojectteam.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Alias("deathClaim")
public class DeathClaimDTO {
    String claimNum;
    String claimContent;
    String insId;
    String claimName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date claimBirth;
    String claimAddr;
    String claimAddrDetail;
    Integer claimPost;
    String claimEmail;
    String causeOfDeath;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateOfDeath;
    String placeOfDeath;
    String typeOfDeath;
    String beneficiaryAccount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date claimDate;
}
