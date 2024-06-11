package fdsprojectteam.mapper;

import fdsprojectteam.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentMapper {
    CardDTO cardSelectOne(String cardNum);

    CountryDTO countrySelectOne(Long ipAddress);

    void errorCountUpdate(Map<String, Object> map);

    void tradingHaltUpdate(CardDTO cardDTO);

    TradingHaltDTO tradingHaltSelectOne(String cardNum);

    int avgPriceSelect(String cardId);

    void purchaseInsert(PurchaseDTO dto);

    int purchaseCount(String customerId);

    void cardErrorCountUpdate(String cardId);

    void ipAgreeInsert(Map<String, Object> map);

    void ipBlockInsert(Map<String, Object> map);

    IPBlockDTO ipBlockSelect(Map<String, Object> map);

    int ipBlockCount(long ipAddress);

    IPAgreeDTO ipAgreeSelect(Map<String, Object> map);

    List<PurchaseDTO> purchaseErrorSelect();

    List<MonthlySumPurchaseDTO> monthlyAveragePurchaseSelect(Map<String, Object> result);

    List<DailyPurchaseDTO> dailyPurchaseCountSelect(Map<String, Object> result);

    List<PurchaseErrorDTO> fraudPaymentSelect(Map<String, Object> result);
}
