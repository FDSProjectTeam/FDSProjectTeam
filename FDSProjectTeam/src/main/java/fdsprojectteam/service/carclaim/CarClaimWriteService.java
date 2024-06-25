package fdsprojectteam.service.carclaim;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import fdsprojectteam.command.CarClaimCommand;
import fdsprojectteam.domain.CarClaimDTO;
import fdsprojectteam.mapper.CarClaimMapper;

@Service
public class CarClaimWriteService {
	@Autowired
	CarClaimMapper carClaimMapper;
	public List<String> execute(CarClaimCommand carClaimCommand, Model model) {
	    // 차량 정원 목록 (차량 번호 또는 모델명과 최대 탑승 인원을 매핑)
	    final Map<String, Integer> VEHICLE_CAPACITY = Map.of(
	        "현대 아반떼", 5,
	        "기아 K5", 5,
	        "도요타 캠리", 5,
	        "현대 팰리세이드", 7,
	        "혼다 파일럿", 7,
	        "포드 익스플로러", 7,
	        "기아 쏘렌토", 7, 
	        "현대 스타리아", 9,  
	        "기아 카니발", 9,
	        "포드 트랜싯", 9
	    );
	    // 7명 이상 태울 수 있는 차량 목록
	    final List<String> LARGE_CAPACITY_VEHICLES = List.of("현대 팰리세이드", "혼다 파일럿", "포드 익스플로러", "기아 쏘렌토", "현대 스타리아", "기아 카니발", "포드 트랜싯");
	    // 특정 대형 차량 차종 목록 (탐지 로직에 사용할)
	    final List<String> LARGE_VEHICLE_TYPES = List.of("현대 스타리아", "기아 카니발", "포드 트랜싯");
		// 클레임 데이터를 DTO로 변환
		CarClaimDTO dto = new CarClaimDTO();
		dto.setClaimAccidentDate(carClaimCommand.getClaimAccidentDate());
		dto.setClaimAddr(carClaimCommand.getClaimAddr());
		dto.setClaimCar(carClaimCommand.getClaimCar());
		dto.setClaimCount(carClaimCommand.getClaimCount());
		dto.setClaimHospital(carClaimCommand.getClaimHospital());
		dto.setClaimlicenseNumber(carClaimCommand.getClaimlicenseNumber());
		dto.setClaimLicenseType(carClaimCommand.getClaimLicenseType());
		dto.setClaimLocation(carClaimCommand.getClaimLocation());
		dto.setClaimName(carClaimCommand.getClaimName());
		dto.setClaimNumber(carClaimCommand.getClaimNumber());
		dto.setClaimSignName(carClaimCommand.getClaimSignName());
		dto.setClaimSituation(carClaimCommand.getClaimSituation());
		dto.setClaimTel(carClaimCommand.getClaimTel());
		dto.setMemCarNumber(carClaimCommand.getMemCarNumber());
		model.addAttribute("carClaimCommand", carClaimCommand);
        List<String> resultMessages = new ArrayList<>();
        if (dto.getClaimCount() >= 7) {
        	model.addAttribute("success", false);
            resultMessages.add("탑승자 인원수가 많아서 클레임이 보류되었습니다.");
        }
        if (LARGE_CAPACITY_VEHICLES.contains(dto.getClaimCar()) || dto.getClaimCount() >= 7) {
        	model.addAttribute("success", false);
        	resultMessages.add("해당 차량은 7명 이상 탑승할 수 있으므로 클레임이 보류되었습니다.");
        }
        Integer maxCapacity = VEHICLE_CAPACITY.get(dto.getClaimCar());
        if (maxCapacity != null && dto.getClaimCount() > maxCapacity) {
        	model.addAttribute("success", false);
            resultMessages.add("차량의 정원(" + maxCapacity + "명) 이상 인원이 탑승하여 클레임이 보류되었습니다.");
        }
        if (LARGE_VEHICLE_TYPES.contains(dto.getClaimCar())) {
        	model.addAttribute("success", false);
            resultMessages.add("해당 차량 차종(" + dto.getClaimCar() + ")은 대형 차량으로 클레임이 보류되었습니다.");
        }
        List<CarClaimDTO> recentClaims = carClaimMapper.findRecentClaims(dto.getMemCarNumber(), dto.getClaimAccidentDate());
        if (!recentClaims.isEmpty()) {
            model.addAttribute("success", false);
            resultMessages.add("최근 6개월 내에 사고가 재발하여 클레임이 보류되었습니다.");
        }
        List<CarClaimDTO> similarClaims = carClaimMapper.findSimilarClaims(dto.getMemCarNumber(), dto.getClaimSituation());
        if (!similarClaims.isEmpty()) {
            model.addAttribute("success", false);
            resultMessages.add("이전 사고와 비슷한 사고경위로 인해 클레임이 보류되었습니다.");
            return resultMessages;
        }
        if (resultMessages.isEmpty()) {
            carClaimMapper.carClaimInsert(dto);
            model.addAttribute("success", true);
            resultMessages.add("클레임이 성공적으로 처리되었습니다.");
        }
        return resultMessages;
    }
}






