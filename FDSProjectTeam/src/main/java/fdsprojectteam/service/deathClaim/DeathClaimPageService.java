package fdsprojectteam.service.deathClaim;

import fdsprojectteam.domain.DeathClaimSearchAndPageDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class DeathClaimPageService {
    public DeathClaimSearchAndPageDTO execute(Integer limit, Integer page, String searchWord){
        Integer startRow =  ((page - 1) * limit) + 1 ; // 1 : 1,  2 : 11 , 3: 21
        Integer endRow = startRow + limit - 1;
        DeathClaimSearchAndPageDTO sepDTO = new DeathClaimSearchAndPageDTO();
        sepDTO.setStartRow(startRow);
        sepDTO.setEndRow(endRow);
        sepDTO.setSearchWord(searchWord);
        return sepDTO;
    }
    public void execute(Integer page, Integer count, Integer limit, Model model, String searchWord) {
        Integer limitPage = 10  ;
        Integer startPage =(int)((double) page / limitPage + 0.95 - 1) * limitPage + 1; // 1
        // 1 ~ 10 : 1, 11 ~ 20 : 11, 21 ~ 30 : 21,..., 91 ~ 100 : 91,
        Integer endPage = startPage + limitPage - 1;   // 10
        //  (double)21  / 10 = 2.1 + 0.95 = (int)3.05 = 3
        Integer maxPage = (int)((double)count /  limit  + 0.95); // 3;
        if(maxPage < endPage) endPage = maxPage;
        // maxPage가 0이되어서 endPage가 0이되는 것을 막기 위해서
        if(endPage == 0 ) endPage = 1;
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("page", page);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("count", count);
        model.addAttribute("maxPage", maxPage);
    }
}
