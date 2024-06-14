package fdsprojectteam.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("accmember")
@AllArgsConstructor
@NoArgsConstructor
public class AccMemberDTO {
	String accmemNum;
	String accmemName;
	String accmemAddr;
	String accmemDetail;
	String accmemPost;
	String accmemTel;
	Date accmemBirth;
}
