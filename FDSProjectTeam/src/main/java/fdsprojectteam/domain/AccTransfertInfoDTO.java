package fdsprojectteam.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("transferInfo")
public class AccTransfertInfoDTO {
	String transferNum;
	String accmemNum;
	String accountNum;
	Integer incomePrice;
	Date incomeDate;
	Integer outcomePrice;
	Date outcomeDate;
	String transferContent;
}
