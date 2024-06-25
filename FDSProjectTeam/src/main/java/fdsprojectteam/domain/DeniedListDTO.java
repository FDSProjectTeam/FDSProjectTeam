package fdsprojectteam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;

// 지급 거부 통계 페이지에 사용될 DTO입니다.
@Data
@Alias("deniedList")
@AllArgsConstructor
@NoArgsConstructor
public class DeniedListDTO {
    String deniedNum; // 지급거부 번호
    String claimNum; // 청구 번호
    String reasonForDenied; // 지급거부 이유
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date deniedDate; // 거부 날짜
}
