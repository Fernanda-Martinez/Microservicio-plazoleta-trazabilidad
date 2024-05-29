package com.pragma.powerup;

import com.pragma.powerup.application.dto.response.RankingResponseDto;
import com.pragma.powerup.application.handler.impl.RankingHandler;
import com.pragma.powerup.domain.api.IRankingServicePort;
import com.pragma.powerup.domain.model.Rank;
import com.pragma.powerup.domain.model.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RankingHandlerTest {

    @Mock
    private IRankingServicePort rankingServicePort;
    @InjectMocks
    private RankingHandler rankingHandler;

    @BeforeEach
    public void setUp() {
        rankingHandler = new RankingHandler(rankingServicePort);
    }

    @Test
    void testRankear() {

        int idEmpleado = 1;


        List<Rank> rankings = new ArrayList<>();
        Rank rank = new Rank();
        rank.setIdPedido(1);
        rank.setTiempoMinutos(3.45);
        rankings.add(rank);

        Rank rank2 = new Rank();
        rank2.setIdPedido(2);
        rank2.setTiempoMinutos(1.56);
        rankings.add(rank);

        Ranking ranking = new Ranking();
        ranking.setIdEmpleado(idEmpleado);
        ranking.setRankingList(rankings);
        ranking.setTiempoMedio(2.506);


        when(rankingServicePort.rankear(idEmpleado)).thenReturn(ranking);

        RankingResponseDto responseDto = rankingHandler.rankear(idEmpleado);

        assertEquals(idEmpleado, responseDto.getIdEmpleado());
        assertEquals(rankings, responseDto.getRankingMinutos());
        assertEquals(2.506, responseDto.getTiempoMedio());
    }
}


