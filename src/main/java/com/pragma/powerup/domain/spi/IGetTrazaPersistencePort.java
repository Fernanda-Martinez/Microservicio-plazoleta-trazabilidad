package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Traza;

import java.util.List;

public interface IGetTrazaPersistencePort {
    List<Traza> getTraza(int idPedido);
}
