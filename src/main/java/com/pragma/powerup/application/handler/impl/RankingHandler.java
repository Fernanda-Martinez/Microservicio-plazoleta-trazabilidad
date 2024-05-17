package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.response.RankingResponseDto;
import com.pragma.powerup.application.handler.IRankingHandler;
import com.pragma.powerup.domain.api.IRankingServicePort;
import com.pragma.powerup.domain.model.Ranking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RankingHandler implements IRankingHandler {

    private final IRankingServicePort rankingServicePort;

    @Override
    public RankingResponseDto rankear(int idEmpleado) {
        Ranking ranking = rankingServicePort.rankear(idEmpleado);

        RankingResponseDto dto = new RankingResponseDto();

        dto.setIdEmpleado(ranking.getIdEmpleado());
        dto.setRankingMinutos(ranking.getRankingList());
        dto.setTiempoMedio(ranking.getTiempoMedio());
        return dto;
    }
}
