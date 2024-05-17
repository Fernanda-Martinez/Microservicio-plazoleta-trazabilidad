package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.application.dto.request.GetTrazaRequestDto;
import com.pragma.powerup.application.dto.response.CrearTrazaResponseDto;
import com.pragma.powerup.application.dto.response.GetTrazaResponseDto;

public interface ITrazaHandler {

    CrearTrazaResponseDto crear(CrearTrazaRequestDto request);

    GetTrazaResponseDto obtener(GetTrazaRequestDto request);
}
