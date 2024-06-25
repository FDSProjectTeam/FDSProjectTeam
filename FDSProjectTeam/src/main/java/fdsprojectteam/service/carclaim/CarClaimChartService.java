package fdsprojectteam.service.carclaim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdsprojectteam.command.CarClaimCommand;
import fdsprojectteam.mapper.CarClaimMapper;

@Service
public class CarClaimChartService {
    @Autowired
    CarClaimMapper carClaimMapper;


    public List<CarClaimCommand> getChartData() {
        List<CarClaimCommand> rawData = carClaimMapper.getChartData();
        List<CarClaimCommand> chartData = new ArrayList<>();

        for (int year = 2019; year <= 2025; year++) {
            boolean found = false;
            for (CarClaimCommand command : rawData) {
                if (command.getClaimYear() == year) {
                    chartData.add(command);
                    found = true;
                    break;
                }
            }
            if (!found) {
                CarClaimCommand command = new CarClaimCommand();
                command.setClaimYear(null);
                command.setClaimCount(0);
                chartData.add(command);
            }
        }

        return chartData;
    }
}