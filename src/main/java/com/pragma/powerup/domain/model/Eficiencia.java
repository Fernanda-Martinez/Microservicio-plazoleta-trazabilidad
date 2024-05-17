package com.pragma.powerup.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Eficiencia {
    int idPedido;
    double minutos;
    double horas;
}
