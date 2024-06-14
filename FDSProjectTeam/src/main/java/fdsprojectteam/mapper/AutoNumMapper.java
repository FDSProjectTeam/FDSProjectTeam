package fdsprojectteam.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface AutoNumMapper {
    String autoNumSelect(Map<String, String> map);
}
