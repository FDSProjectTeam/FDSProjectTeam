package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("tradingHalt")
public class TradingHaltDTO {
    private String cardId;
    private String customerId;
    private Date haltedDate;
}
