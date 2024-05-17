package com.pragma.powerup.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Ranking {
    int idEmpleado;
    List<Rank> rankingList;
    double tiempoMedio;
}
