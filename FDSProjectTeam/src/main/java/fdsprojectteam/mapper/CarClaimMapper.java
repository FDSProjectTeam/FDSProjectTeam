package fdsprojectteam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import fdsprojectteam.domain.CarClaimDTO;

@Mapper
public interface CarClaimMapper {
	public void carClaimInsert(CarClaimDTO dto);
	List<CarClaimDTO> findSimilarClaims(@Param("claimSituation") String claimSituation);
	
	List<CarClaimDTO> findRecentClaims(Map<String, Object> params);

}
