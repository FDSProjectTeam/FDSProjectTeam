package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("customers")
public class CustomersDTO {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddr;
    private String customerAddrDetail;
    private String customerPost;
    private String customerCountry;
}
