package fdsprojectteam.mapper;

import fdsprojectteam.domain.CardDTO;
import fdsprojectteam.domain.CountryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PaymentMapper {
    CardDTO cardSelectOne(String cardNum);

    CountryDTO countrySelectOne(Long ipAddress);

    void errorCountUpdate(Map<String, Object> map);

    void tradingHaltUpdate(CardDTO cardDTO);
}
