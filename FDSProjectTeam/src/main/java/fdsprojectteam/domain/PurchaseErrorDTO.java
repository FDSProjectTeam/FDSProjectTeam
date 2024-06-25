package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("purchaseError")
public class PurchaseErrorDTO {
    private PurchaseDTO purchaseDTO;
    private CustomersDTO customersDTO;
    private CardDTO cardDTO;
}
