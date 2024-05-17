package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.response.GetEficienteResponseDto;
import com.pragma.powerup.application.handler.IEficienciaHandler;
import com.pragma.powerup.application.mapper.IEficienciaResponseMapper;
import com.pragma.powerup.domain.api.IEficienciaPedidoServicePort;
import com.pragma.powerup.domain.model.Eficiencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EficienciaHandler implements IEficienciaHandler {

    private final IEficienciaPedidoServicePort eficienciaPedidoServicePort;
    private final IEficienciaResponseMapper eficienciaResponseMapper;

    @Override
    public GetEficienteResponseDto obtener(int idPedido) {

        Eficiencia eficiencia = eficienciaPedidoServicePort.obtener(idPedido);

        return eficienciaResponseMapper.toDto(eficiencia);
    }
}
