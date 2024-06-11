package fdsprojectteam.domain;

import lombok.Data;

@Data
public class CarClaimResponseDTO {
    private boolean success; // 클레임 처리의 성공 여부를 저장하는 필드입니다.
    private String message; // 클레임 처리 결과에 대한 추가 정보를 저장하는 필드입니다.
    private CarClaimDTO carClaimDTO; // 클레임에 관한 정보를 저장하는 객체입니다.

}
