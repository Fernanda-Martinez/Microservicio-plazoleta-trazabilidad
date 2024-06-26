package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.Traza;
import com.pragma.powerup.infrastructure.out.jpa.entity.TrazaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ITrazaEntityMapper {
    TrazaEntity toEntity(Traza traza);
    Traza toModel(TrazaEntity trazaEntity);
}
