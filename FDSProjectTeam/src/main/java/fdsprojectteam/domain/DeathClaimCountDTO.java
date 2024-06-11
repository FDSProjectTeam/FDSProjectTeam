package fdsprojectteam.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("deathClaimCount")
public class DeathClaimCountDTO {
    String causeOfDeath;
    Integer totalCount;
}
