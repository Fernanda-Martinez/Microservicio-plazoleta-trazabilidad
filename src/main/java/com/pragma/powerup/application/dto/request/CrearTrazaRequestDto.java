package com.pragma.powerup.application.dto.request;

import lombok.Data;

@Data
public class CrearTrazaRequestDto {
    int idEmpleado;
    int idPepido;
    String idCliente;
    String correoCliente;
    String correoEmpleado;
    String nuevoEstado;

}
