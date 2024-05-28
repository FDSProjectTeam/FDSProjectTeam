package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("country")
public class CountryDTO {
    private String countryId;
    private String countryCode;
    private String countryName;
    private Integer ipStartNum;
    private Integer ipEndNum;
}
