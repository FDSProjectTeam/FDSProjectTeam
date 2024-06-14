package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Alias("insured")
@AllArgsConstructor
@NoArgsConstructor
public class InsuredDTO {
    String insId;
    String insName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date insBirth;
    String insAddr;
    String insAddrDetail;
    Integer insPost;
    String insPhone;
    String insEmail;
    String insCaseHistory;
    String insBeneficiary;
    String insPrivity;
    String insBenPhone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date insContractDate;
}
