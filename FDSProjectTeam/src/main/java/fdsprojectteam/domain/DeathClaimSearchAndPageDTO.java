package fdsprojectteam.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

// 청구서 목록 페이징 관련 DTO
@Data
@Alias("deathClaimSearchAndPage")
public class DeathClaimSearchAndPageDTO {
    Integer startRow;
    Integer endRow;
    String searchWord;
}
