package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.application.dto.response.CrearTrazaResponseDto;
import com.pragma.powerup.application.handler.ITrazaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/traza")
@RequiredArgsConstructor
public class TrazaRestController {
    private final ITrazaHandler trazaHandler;

    @Operation(summary = "Agrega una nueva traza")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Traza creada", content = @Content),
            @ApiResponse(responseCode = "409", description = "La traza no pudo crearse", content = @Content)
    })
    @PostMapping("/crear")
    public ResponseEntity<CrearTrazaResponseDto> crear(@RequestBody CrearTrazaRequestDto requestDto) {
        CrearTrazaResponseDto response = trazaHandler.crear(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
