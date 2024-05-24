package fdsprojectteam.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseCommand {
    private String purchaseId;
    private String cardId;
    private String customerId;
    private String countryId;
    private String purchasePrice;
    private String ipAddress;
}
