package fdsprojectteam.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradingHaltCommand {
    private String cardId;
    private String customerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date haltDate;
}
