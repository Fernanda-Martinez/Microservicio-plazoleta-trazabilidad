package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.application.dto.request.GetTrazaRequestDto;
import com.pragma.powerup.application.dto.response.CrearTrazaResponseDto;
import com.pragma.powerup.application.dto.response.GetTrazaResponseDto;
import com.pragma.powerup.application.handler.ITrazaHandler;
import com.pragma.powerup.application.mapper.ITrazaResponseMapper;
import com.pragma.powerup.domain.api.IGetTrazaServicePort;
import com.pragma.powerup.domain.api.ITrazaServicePort;
import com.pragma.powerup.domain.model.Traza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TrazaHandler implements ITrazaHandler {

    private final ITrazaServicePort trazaServicePort;
    private final IGetTrazaServicePort getTrazaServicePort;
    private final ITrazaResponseMapper trazaResponseMapper;
    @Override
    public CrearTrazaResponseDto crear(CrearTrazaRequestDto request) {
        Traza traza = trazaServicePort.crear(request);
        

        return trazaResponseMapper.toResponse(traza);
    }

    @Override
    public GetTrazaResponseDto obtener(GetTrazaRequestDto request) {
        List<Traza> traza = getTrazaServicePort.getTraza(request.getIdPedido());

        GetTrazaResponseDto response = new GetTrazaResponseDto();

        for(Traza item: traza){
            response.getTraza().add(item);
        }
        return response;
    }
}
