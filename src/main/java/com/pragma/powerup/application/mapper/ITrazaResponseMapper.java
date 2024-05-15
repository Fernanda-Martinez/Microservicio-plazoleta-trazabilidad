package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.CrearTrazaResponseDto;
import com.pragma.powerup.domain.model.Traza;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITrazaResponseMapper {

    CrearTrazaResponseDto toResponse(Traza traza);
}
