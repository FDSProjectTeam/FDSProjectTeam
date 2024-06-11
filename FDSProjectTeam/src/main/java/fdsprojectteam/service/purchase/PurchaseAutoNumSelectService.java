package fdsprojectteam.service.purchase;

import fdsprojectteam.command.PurchaseCommand;
import fdsprojectteam.mapper.AutoNumMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PurchaseAutoNumSelectService {

    private final AutoNumMapper autoNumMapper;

    public void execute(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("tableName", "purchase");
        map.put("columnName", "purchase_id");
        map.put("sep", "pur");
        String purchaseId = autoNumMapper.autoNumSelect(map);
        PurchaseCommand purchaseCommand = new PurchaseCommand();
        purchaseCommand.setPurchaseId(purchaseId);

        model.addAttribute("purchaseCommand", purchaseCommand);
    }
}