package fdsprojectteam.command;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DeathClaimCommand {
    String claimNum;
    @NotEmpty(message = "피보험자 번호를 입력해주세요.")
    String insId;
    @NotEmpty(message = "청구 내용을 입력해주세요.")
    String claimContent;
    @NotEmpty(message = "청구인 성명을 입력해주세요.")
    String claimName;
    @NotNull(message = "청구인 생년월일을 입력해주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date claimBirth;
    @NotEmpty(message = "주소를 입력해주세요.")
    String claimAddr;
    String claimAddrDetail;
    @NotNull(message = "우편번호를 입력해주세요.")
    Integer claimPost;
    @NotEmpty(message = "이메일을 입력해주세요.")
    String claimEmail;
    @NotEmpty(message = "사망 원인을 입력해주세요.")
    String causeOfDeath;
    @NotNull(message = "사망일을 입력해주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateOfDeath;
    @NotEmpty(message = "사망 장소를 입력해주세요.")
    String placeOfDeath;
    // @NotEmpty(message = "사망의 종류를 입력해주세요.")
    String typeOfDeath;
    @NotEmpty(message = "보험금 수령 계좌를 입력해주세요.")
    String beneficiaryAccount;
    @NotNull(message = "청구일을 입력해주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date claimDate;
}
