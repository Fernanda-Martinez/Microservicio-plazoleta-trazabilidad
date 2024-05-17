package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IGetTrazaServicePort;
import com.pragma.powerup.domain.model.Traza;
import com.pragma.powerup.domain.spi.IGetTrazaPersistencePort;

import java.util.List;

public class GetTrazaUseCase implements IGetTrazaServicePort {

    private final IGetTrazaPersistencePort getTrazaPersistencePort;

    public GetTrazaUseCase(IGetTrazaPersistencePort getTrazaPersistencePort) {
        this.getTrazaPersistencePort = getTrazaPersistencePort;
    }

    @Override
    public List<Traza> getTraza(int idPedido) {
        return getTrazaPersistencePort.getTraza(idPedido);
    }
}
