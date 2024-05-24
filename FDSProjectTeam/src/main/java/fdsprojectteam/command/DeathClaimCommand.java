package fdsprojectteam.command;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DeathClaimCommand {
    String claimNum;
    String claimContent;
    String subName;
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
}
