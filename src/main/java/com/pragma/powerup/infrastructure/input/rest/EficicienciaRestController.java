package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.response.GetEficienteResponseDto;
import com.pragma.powerup.application.dto.response.RankingResponseDto;
import com.pragma.powerup.application.handler.IEficienciaHandler;
import com.pragma.powerup.application.handler.IRankingHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/eficiencia")
@RequiredArgsConstructor
public class EficicienciaRestController {

    private final IEficienciaHandler eficienciaHandler;
    private final IRankingHandler rankingHandler;

    @Operation(summary = "Obtiene la eficiencia de un pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Eficiencia obtenida", content = @Content),
            @ApiResponse(responseCode = "409", description = "Pedido no existe", content = @Content)
    })
    @PreAuthorize("hasRole('ROLE_propietario')")
    @GetMapping("/obtener")
    public ResponseEntity<GetEficienteResponseDto> obtener(@RequestParam int idPedido) {
        GetEficienteResponseDto response = eficienciaHandler.obtener(idPedido);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene un rank de tiempos del empleado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ranking obtenido", content = @Content),
            @ApiResponse(responseCode = "409", description = "Empleado no existe o no posee pedidos realizados", content = @Content)
    })
    @PreAuthorize("hasRole('ROLE_propietario')")
    @GetMapping("/rankear")
    public ResponseEntity<RankingResponseDto> rankear(@RequestParam int idEmpleado) {
        RankingResponseDto response = rankingHandler.rankear(idEmpleado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
