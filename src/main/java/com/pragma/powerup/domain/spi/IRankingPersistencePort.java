package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Ranking;

public interface IRankingPersistencePort {
    Ranking rankear(int idEmpleado);
}
