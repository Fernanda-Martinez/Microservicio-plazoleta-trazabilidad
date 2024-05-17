package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Traza;

import java.util.List;

public interface IGetTrazaServicePort {
    List<Traza> getTraza(int idPedido);
}
