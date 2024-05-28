package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("card")
public class CardDTO {
    private String cardId;
    private String coustomerId;
    private String cardNum;
    private Date expiryDate;
    private String issueCountry;
}
