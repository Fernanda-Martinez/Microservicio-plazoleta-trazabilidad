package com.pragma.powerup.domain.api;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.domain.model.Traza;

public interface ITrazaServicePort {
 Traza crear(CrearTrazaRequestDto request);
}
