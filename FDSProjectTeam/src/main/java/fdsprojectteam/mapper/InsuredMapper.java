package fdsprojectteam.mapper;

import fdsprojectteam.domain.InsuredDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredMapper {
    public InsuredDTO selectOne(String insId);
}
