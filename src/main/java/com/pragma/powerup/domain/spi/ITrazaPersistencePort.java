package com.pragma.powerup.domain.spi;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.domain.model.Traza;

public interface ITrazaPersistencePort {
    Traza crear(CrearTrazaRequestDto requestDto);
}
