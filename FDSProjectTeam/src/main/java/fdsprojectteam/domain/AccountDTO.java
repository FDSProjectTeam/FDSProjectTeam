package fdsprojectteam.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("account")
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	String accountNum;
	String accmemNum;
	Date accountDate;
}
