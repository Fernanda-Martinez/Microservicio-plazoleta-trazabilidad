package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Traza")
public class TrazaEntity {
    @Id
    private int id;
    private int idPedido;
    private String idCliente;
    private String correoCliente;
    private Date fecha;
    private String estadoAnterior;
    private String estadoNuevo;
    private int idEmpleado;
    private String correoEmpleado;
}
