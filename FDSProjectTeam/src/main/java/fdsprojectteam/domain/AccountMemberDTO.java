package fdsprojectteam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("accountMember")
public class AccountMemberDTO {
	AccMemberDTO accmemberDTO;
	AccountDTO accountDTO;
}
