package com.pragma.powerup.application.dto.response;

import lombok.Data;

@Data
public class CrearTrazaResponseDto {
    int id;
    int idEmpleado;
    int idPeido;
    String idCliente;
    String correoCliente;
    String correoEmpleado;
    String nuevoEstado;
}
