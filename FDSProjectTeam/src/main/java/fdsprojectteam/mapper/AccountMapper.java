package fdsprojectteam.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import fdsprojectteam.domain.AccTransfertInfoDTO;
import fdsprojectteam.domain.AccountDTO;
import fdsprojectteam.domain.AccountMemberDTO;

@Repository(value = "fdsprojectteam.mapper.AccountMapper")
public interface AccountMapper {
	public AccountMemberDTO accountMemberSelect(String accountNum, String accmemName, String accmemNum);
	public List<AccTransfertInfoDTO> transferInfoList(String accountNum);
}
