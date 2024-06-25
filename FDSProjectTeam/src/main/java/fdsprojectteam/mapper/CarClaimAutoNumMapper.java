package fdsprojectteam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CarClaimAutoNumMapper {
    public String autoNum(@Param("tableName") String tableName
    					, @Param("columnName") String columnName
    					, @Param("sep") String sep);
}
