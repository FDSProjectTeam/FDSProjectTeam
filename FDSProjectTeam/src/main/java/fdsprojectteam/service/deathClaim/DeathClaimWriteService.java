package fdsprojectteam.service.deathClaim;

import fdsprojectteam.command.DeathClaimCommand;
import fdsprojectteam.domain.InsuredDTO;
import fdsprojectteam.mapper.InsuredMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class DeathClaimWriteService {
    @Autowired
    InsuredMapper insuredMapper;
    public void execute(DeathClaimCommand deathClaimCommand, Model model) throws Exception {
        String insId = deathClaimCommand.getInsId();
        InsuredDTO iDto = insuredMapper.selectOne(insId);
        Date claimBirthDate = deathClaimCommand.getClaimBirth();
        Date contractDate = iDto.getInsContractDate();
        long diffInMillies = Math.abs(claimBirthDate.getTime() - contractDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        //////////////////////////////////////////////////////////////////
        // 연령 불일치 (잠깐 보류)
        // 사망 보험 청구자의 연령이 사망 보험 계약 시 기재된 연령과 크게 다른 경우.
        //////////////////////////////////////////////////////////////////
        if(diffInDays < 365){ // 빠른 보험 청구
            // INSURED 테이블의 INS_DATE 컬럼과
            // DEATH_CLAIM 테이블의 CLAIM_DATE 컬럼 비교
            // 가입 1년이내로 청구시 빠른 보험 청구 시나리오에 의해 지급 거부
            model.addAttribute("denied", "빠른 보험 청구");
        } else if(iDto.getInsCaseHistory().isEmpty() || iDto.getInsCaseHistory().equals("없음")){ // 기존 건강 상태 누락
            // INSURED 테이블의 INS_CASE_HISTORY 컬럼 확인
            // 없음일 경우
            // 지급 거부
            model.addAttribute("denied", "기존 건강 상태 누락");
        } else if(!iDto.getInsBeneficiary().equals(deathClaimCommand.getClaimName())){ // 가족관계 변조 의심
            // 계약당시 보험금 수령인이 청구하지 않은 경우
            // INSURED 테이블의 INS_BENEFICIARY 컬럼과
            // DEATH_CLAIM 테이블의 CLAIM_NAME 컬럼 비교
            model.addAttribute("denied", "가족관계 변조 의심");
        } else if(deathClaimCommand.getCauseOfDeath().equals("자살")){ // 자살로 인한 사망
            model.addAttribute("denied", "자살로 인한 사망");
        } else if(deathClaimCommand.getCauseOfDeath().equals("감염병")){
            model.addAttribute("denied", "COVID-19 등 감염병으로 인한 사망");
        } else if(deathClaimCommand.getPlaceOfDeath().equals("실종")){
            model.addAttribute("denied", "피보험자 실종 상태");
        } else {
            // 모두 해당되지 않는다면
            // 지급 승인
            model.addAttribute("accepted", "지급 승인");
        }
        model.addAttribute("deathClaimCommand", deathClaimCommand);
        model.addAttribute("insName", iDto.getInsName());
    }
}
