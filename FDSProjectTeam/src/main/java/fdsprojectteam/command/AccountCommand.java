package fdsprojectteam.command;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AccountCommand {
	String accountNum;
	String accmemNum;
	String accmemName;
}
