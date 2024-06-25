package fdsprojectteam.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseCommand {
    private String purchaseId;
    private String customerId;
    private Integer purchasePrice;
    private String cardNum;
    private String expiryYear;
    private String expiryMonth;
    private String ipAddress;
}
