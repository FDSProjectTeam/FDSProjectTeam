package fdsprojectteam.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("deniedListCount")
public class DeniedListCountDTO {
    String reasonForDenied;
    Integer reasonCount;
}
