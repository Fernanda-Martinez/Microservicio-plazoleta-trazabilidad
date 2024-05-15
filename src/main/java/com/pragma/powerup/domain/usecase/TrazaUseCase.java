package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.domain.api.ITrazaServicePort;
import com.pragma.powerup.domain.model.Traza;
import com.pragma.powerup.domain.spi.ITrazaPersistencePort;

public class TrazaUseCase implements ITrazaServicePort {

    private final ITrazaPersistencePort trazaPersistencePort;

    public TrazaUseCase(ITrazaPersistencePort trazaPersistencePort) {
        this.trazaPersistencePort = trazaPersistencePort;
    }

    @Override
    public Traza crear(CrearTrazaRequestDto request) {
        return trazaPersistencePort.crear(request);
    }
}
