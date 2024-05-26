package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.domain.model.Traza;
import com.pragma.powerup.domain.spi.IGetTrazaPersistencePort;
import com.pragma.powerup.domain.spi.ITrazaPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.TrazaEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.ITrazaEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.ITrazabilidadRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class TrazaJpaAdapter implements ITrazaPersistencePort, IGetTrazaPersistencePort {

    private final ITrazabilidadRepository trazabilidadRepository;
    private final ITrazaEntityMapper trazaEntityMapper;

    @Override
    public Traza crear(CrearTrazaRequestDto requestDto) {
        Random random = new Random();

        TrazaEntity nuevaTraza = new TrazaEntity();
        nuevaTraza.setId(random.nextInt());
        nuevaTraza.setIdPedido(requestDto.getIdPedido());
        nuevaTraza.setIdCliente(requestDto.getIdCliente());
        nuevaTraza.setIdEmpleado(requestDto.getIdEmpleado());
        nuevaTraza.setCorreoCliente(requestDto.getCorreoCliente());
        nuevaTraza.setCorreoEmpleado(requestDto.getCorreoEmpleado());
        nuevaTraza.setEstadoNuevo(requestDto.getNuevoEstado());
        nuevaTraza.setFecha(new Date());

        List<TrazaEntity> traza = trazabilidadRepository.findByIdPedido(requestDto.getIdPedido());
        TrazaEntity objetoMasReciente = null;
        Date fechaMasReciente = null;

        for (TrazaEntity objeto : traza) {
            Date fechaActual = objeto.getFecha();
            if (fechaMasReciente == null || fechaActual.after(fechaMasReciente)) {
                fechaMasReciente = fechaActual;
                objetoMasReciente = objeto;
            }
        }

        if(objetoMasReciente != null){
            nuevaTraza.setEstadoAnterior(objetoMasReciente.getEstadoNuevo());
        }else{
            nuevaTraza.setEstadoAnterior("");
        }

        TrazaEntity response = trazabilidadRepository.save(nuevaTraza);


        return trazaEntityMapper.toModel(response);
    }


    @Override
    public List<Traza> getTraza(int idPedido) {

        List<TrazaEntity> response = trazabilidadRepository.findByIdPedido(idPedido);

        if(response.isEmpty()){
            return Collections.emptyList();
        }

        List<Traza> res = new ArrayList<>();

        for(TrazaEntity entity: response){
            Traza traza = trazaEntityMapper.toModel(entity);
            res.add(traza);
        }

        return res;
    }
}
