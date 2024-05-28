package fdsprojectteam.service.deathClaim;

import fdsprojectteam.command.DeathClaimCommand;
import org.springframework.stereotype.Service;

@Service
public class DeathClaimWriteService {
    public void execute(DeathClaimCommand deathClaimCommand){
        // 연령 불일치
            // INSURED 테이블의 INS_BIRTH 컬럼과
            // DEATH_CLAIM 테이블의 CLAIM_BIRTH 컬럼 비교
            // 연령이 불일치하게 되면 지급 거부
        // 빠른 보험 청구
            // INSURED 테이블의 INS_DATE 컬럼과
            // DEATH_CLAIM 테이블의 CLAIM_DATE 컬럼 비교
            // 가입 1년이내로 청구시 빠른 보험 청구 시나리오에 의해 지급 거부
        // 기존 건강 상태 누락
            // INSURED 테이블의 INS_CASE_HISTORY 컬럼 확인
            // 없음일 경우
        // 가족관계 변조
            // 계약당시 보험금 수령인이 청구하지 않은 경우
            // INSURED 테이블의 INS_BENEFICIARY 컬럼과
            // DEATH_CLAIM 테이블의 CLAIM_NAME 컬럼 비교
    }
}
