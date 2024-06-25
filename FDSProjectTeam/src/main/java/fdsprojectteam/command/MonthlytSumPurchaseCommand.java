package fdsprojectteam.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlytSumPurchaseCommand {
    private List<String> months;
    private List<Integer> sumPrices;
    private List<Integer> maxPrices;
    private List<Integer> purchaseCount;
    private List<String> days;
    private List<Integer> dailyCount;
}
