package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.application.dto.response.CrearTrazaResponseDto;
import com.pragma.powerup.application.handler.ITrazaHandler;
import com.pragma.powerup.application.mapper.ITrazaResponseMapper;
import com.pragma.powerup.domain.api.ITrazaServicePort;
import com.pragma.powerup.domain.model.Traza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TrazaHandler implements ITrazaHandler {

    private final ITrazaServicePort trazaServicePort;
    private final ITrazaResponseMapper trazaResponseMapper;
    @Override
    public CrearTrazaResponseDto crear(CrearTrazaRequestDto request) {
        Traza traza = trazaServicePort.crear(request);

        CrearTrazaResponseDto response = trazaResponseMapper.toResponse(traza);

        return response;
    }
}
