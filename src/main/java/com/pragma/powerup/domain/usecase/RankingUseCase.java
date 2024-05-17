package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRankingServicePort;
import com.pragma.powerup.domain.model.Ranking;
import com.pragma.powerup.domain.spi.IRankingPersistencePort;

public class RankingUseCase implements IRankingServicePort {

    private final IRankingPersistencePort rankingPersistencePort;

    public RankingUseCase(IRankingPersistencePort rankingPersistencePort) {
        this.rankingPersistencePort = rankingPersistencePort;
    }

    @Override
    public Ranking rankear(int idEmpleado) {
        return rankingPersistencePort.rankear(idEmpleado);
    }
}
