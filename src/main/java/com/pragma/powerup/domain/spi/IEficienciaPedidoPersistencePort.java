package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Eficiencia;

public interface IEficienciaPedidoPersistencePort {

    Eficiencia obtener(int idPedido);
}
