package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.domain.model.Traza;
import com.pragma.powerup.domain.spi.ITrazaPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.TrazaEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.ITrazaEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.ITrazabilidadRepository;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class TrazaJpaAdapter implements ITrazaPersistencePort {

    private final ITrazabilidadRepository trazabilidadRepository;
    private final ITrazaEntityMapper trazaEntityMapper;

    @Override
    public Traza crear(CrearTrazaRequestDto requestDto) {

        TrazaEntity nuevaTraza = new TrazaEntity();
        nuevaTraza.setIdPedido(requestDto.getIdPepido());
        nuevaTraza.setIdCliente(requestDto.getIdCliente());
        nuevaTraza.setIdEmpleado(requestDto.getIdEmpleado());
        nuevaTraza.setCorreoCliente(requestDto.getCorreoCliente());
        nuevaTraza.setCorreoEmpleado(requestDto.getCorreoEmpleado());
        nuevaTraza.setEstadoNuevo(requestDto.getNuevoEstado());
        nuevaTraza.setFecha(new Date());

        List<TrazaEntity> traza = trazabilidadRepository.findByIdPedido(requestDto.getIdPepido());
        TrazaEntity objetoMasReciente = null;
        Date fechaMasReciente = null;

        for (TrazaEntity objeto : traza) {
            Date fechaActual = objeto.getFecha();
            if (fechaMasReciente == null || fechaActual.after(fechaMasReciente)) {
                fechaMasReciente = fechaActual;
                objetoMasReciente = objeto;
            }
        }

        nuevaTraza.setEstadoAnterior(objetoMasReciente.getEstadoAnterior() != null ? objetoMasReciente.getEstadoAnterior() : "");

        TrazaEntity response = trazabilidadRepository.save(nuevaTraza);

        Traza res = trazaEntityMapper.toModel(response);

        return res;
    }
}
