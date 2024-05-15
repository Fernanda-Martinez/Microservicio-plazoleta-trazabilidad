package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.application.dto.response.CrearTrazaResponseDto;

public interface ITrazaHandler {

    CrearTrazaResponseDto crear(CrearTrazaRequestDto request);
}
