package com.pragma.powerup.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class Traza {
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
