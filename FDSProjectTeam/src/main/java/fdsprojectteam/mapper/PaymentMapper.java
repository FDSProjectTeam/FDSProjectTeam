package fdsprojectteam.mapper;

import fdsprojectteam.domain.CardDTO;
import fdsprojectteam.domain.CountryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    CardDTO cardSelectOne(String cardNum);

    CountryDTO countrySelectOne(Long ipAddress);
}
