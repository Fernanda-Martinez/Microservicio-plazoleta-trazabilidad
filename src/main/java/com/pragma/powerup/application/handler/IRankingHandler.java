package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.response.RankingResponseDto;

public interface IRankingHandler {
    RankingResponseDto rankear(int idEmpleado);
}
