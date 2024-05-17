package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.TrazaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITrazabilidadRepository extends MongoRepository<TrazaEntity, Integer> {
    List<TrazaEntity> findByIdPedido(int idPedido);
    List<TrazaEntity> findByIdEmpleado(int idEmpleado);
}
