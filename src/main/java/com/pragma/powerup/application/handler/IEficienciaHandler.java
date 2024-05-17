package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.response.GetEficienteResponseDto;

public interface IEficienciaHandler {
    GetEficienteResponseDto obtener(int idPedido);
}
