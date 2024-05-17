package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.GetEficienteResponseDto;
import com.pragma.powerup.domain.model.Eficiencia;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEficienciaResponseMapper {

    GetEficienteResponseDto toDto(Eficiencia eficiencia);
}
