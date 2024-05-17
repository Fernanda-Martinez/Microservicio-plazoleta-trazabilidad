package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.Rank;
import lombok.Data;

import java.util.List;

@Data
public class RankingResponseDto {
    int idEmpleado;
    List<Rank> rankingMinutos;
    double tiempoMedio;
}
