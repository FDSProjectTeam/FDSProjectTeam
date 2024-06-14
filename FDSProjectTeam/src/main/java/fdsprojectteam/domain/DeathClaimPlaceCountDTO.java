package fdsprojectteam.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("deathClaimPlaceCount")
public class DeathClaimPlaceCountDTO {
    String placeOfDeath;
    Integer placeOfDeathCount;
}
