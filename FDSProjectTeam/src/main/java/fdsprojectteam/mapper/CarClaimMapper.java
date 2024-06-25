package fdsprojectteam.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import fdsprojectteam.command.CarClaimCommand;
import fdsprojectteam.domain.CarClaimDTO;

@Mapper
public interface CarClaimMapper {
	public void carClaimInsert(CarClaimDTO dto);
	List<CarClaimDTO> findSimilarClaims(@Param("memCarNumber") String memCarNumber
									, @Param("claimSituation") String claimSituation);
	List<CarClaimDTO> findRecentClaims(@Param("memCarNumber") String memCarNumber
									, @Param("claimAccidentDate") Date claimAccidentDate);
	List<CarClaimCommand> getChartData();
}
