package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeathClaimCountDTO;
import fdsprojectteam.mapper.DeathClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeathClaimAnalyzeService {
    @Autowired
    DeathClaimMapper deathClaimMapper;
    // 통계 기반 FDS에 관한 서비스 입니다.
    // DB에 등록된 사망원인 자살, 교통사고, 자연사, 심장마비, 질병중에서 가장 많은 수를 가져옵니다.
    public void execute(Model model){
        List<DeathClaimCountDTO> list = deathClaimMapper.selectCount();

        // 초기값을 설정합니다.
        // 가장 많은 수의 사망원인에 변수
        String mostCauseOfDeath = null;
        Integer maxCount = 0;
        // 두번째로 많은 수의 사망원인 변수
        String secondCauseOfDeath = null;
        Integer secondMaxCount = 0;

        // 리스트를 반복하면서 가장 많은 수의 사망 원인을 찾습니다.
        for(DeathClaimCountDTO dto : list){
            if(dto.getTotalCount() > maxCount){
                secondMaxCount = maxCount;
                secondCauseOfDeath = mostCauseOfDeath;

                maxCount = dto.getTotalCount();
                mostCauseOfDeath = dto.getCauseOfDeath();
                // 두번째로 많은 사망 원인을 찾아서 변수에 대입함.
            } else if(dto.getTotalCount() > secondMaxCount){
                secondMaxCount = dto.getTotalCount();
                secondCauseOfDeath = dto.getCauseOfDeath();
            }
        }
        // Model 객체에 전달합니다.
        model.addAttribute("mostCauseOfDeath", mostCauseOfDeath);
        model.addAttribute("maxCount", maxCount);
        model.addAttribute("secondCauseOfDeath", secondCauseOfDeath);
        model.addAttribute("secondMaxCount", secondMaxCount);
        list.clear();
    }
}
