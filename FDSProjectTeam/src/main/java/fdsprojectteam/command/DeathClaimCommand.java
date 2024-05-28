package fdsprojectteam.command;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DeathClaimCommand {
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
