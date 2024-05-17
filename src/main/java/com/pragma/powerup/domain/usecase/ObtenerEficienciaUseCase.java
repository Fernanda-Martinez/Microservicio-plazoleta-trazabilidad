package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IEficienciaPedidoServicePort;
import com.pragma.powerup.domain.model.Eficiencia;
import com.pragma.powerup.domain.spi.IEficienciaPedidoPersistencePort;

public class ObtenerEficienciaUseCase implements IEficienciaPedidoServicePort {

    private final IEficienciaPedidoPersistencePort eficienciaPedidoPersistencePort;

    public ObtenerEficienciaUseCase(IEficienciaPedidoPersistencePort eficienciaPedidoPersistencePort) {
        this.eficienciaPedidoPersistencePort = eficienciaPedidoPersistencePort;
    }

    @Override
    public Eficiencia obtener(int idPedido) {
        return eficienciaPedidoPersistencePort.obtener(idPedido);
    }
}
