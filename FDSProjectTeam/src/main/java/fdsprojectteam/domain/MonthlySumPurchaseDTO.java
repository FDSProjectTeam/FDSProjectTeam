package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("monthlyAveragePurchase")
public class MonthlySumPurchaseDTO {
    private String month;
    private Integer sumPrice;
    private Integer maxPrice;
}
