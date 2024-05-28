package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("purchase")
public class PurchaseDTO {
    private String purchaseId;
    private String cardId;
    private String customerId;
    private String countryId;
    private Integer purchasePrice;
}
