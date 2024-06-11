package fdsprojectteam.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CarClaimCommand {
	String claimNumber;
	String memCarNumber;
	String claimName;
	String claimCar;
	String claimTel;
	String claimlicenseNumber;
	String claimLicenseType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date claimAccidentDate;
	String claimLocation;
	String claimSituation;
	Integer claimCount;
	String claimHospital;
	String claimSignName;
	String claimAddr;
}
