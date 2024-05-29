package com.pragma.powerup;

import com.pragma.powerup.application.dto.request.CrearTrazaRequestDto;
import com.pragma.powerup.application.dto.request.GetTrazaRequestDto;
import com.pragma.powerup.application.dto.response.CrearTrazaResponseDto;
import com.pragma.powerup.application.dto.response.GetTrazaResponseDto;
import com.pragma.powerup.application.handler.impl.TrazaHandler;
import com.pragma.powerup.application.mapper.ITrazaResponseMapper;
import com.pragma.powerup.domain.api.IGetTrazaServicePort;
import com.pragma.powerup.domain.api.ITrazaServicePort;
import com.pragma.powerup.domain.model.Traza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrazaHandlerTest {

    @Mock
    private ITrazaServicePort trazaServicePort;
    @Mock
    private IGetTrazaServicePort getTrazaServicePort;
    @Mock
    private ITrazaResponseMapper trazaResponseMapper;
    @InjectMocks
    private TrazaHandler trazaHandler;

    @BeforeEach
    public void setUp() {

        trazaHandler = new TrazaHandler(
                trazaServicePort,
                getTrazaServicePort,
                trazaResponseMapper
        );
    }

    @Test
    void testCrear() {
        CrearTrazaRequestDto request = new CrearTrazaRequestDto();
        request.setCorreoEmpleado("empleado@gmail.com");
        request.setNuevoEstado("Listo");
        request.setCorreoCliente("cliente@gmail.com");
        request.setIdPedido(1);
        request.setIdCliente("2");

        Traza traza = new Traza();

        traza.setId(1);
        traza.setCorreoCliente("cliente@gmail.com");
        traza.setCorreoEmpleado("empleado@gmail.com");
        traza.setIdCliente("2");
        traza.setEstadoAnterior("En preparacion");
        traza.setEstadoNuevo("Listo");

        CrearTrazaResponseDto expectedResponse = new CrearTrazaResponseDto();
        expectedResponse.setId(1);
        expectedResponse.setCorreoCliente("cliente@gmail.com");
        expectedResponse.setCorreoEmpleado("empleado@gmail.com");
        expectedResponse.setIdCliente("2");
        expectedResponse.setEstadoAnterior("En preparacion");
        expectedResponse.setEstadoNuevo("Listo");

        when(trazaServicePort.crear(request)).thenReturn(traza);
        when(trazaResponseMapper.toResponse(traza)).thenReturn(expectedResponse);

        CrearTrazaResponseDto actualResponse = trazaHandler.crear(request);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testObtener() {
        GetTrazaRequestDto requestDto = new GetTrazaRequestDto();
        requestDto.setIdPedido(1);

        List<Traza> trazaList = new ArrayList<>();
        Traza traza = new Traza();

        traza.setId(1);
        traza.setCorreoCliente("cliente@gmail.com");
        traza.setCorreoEmpleado("empleado@gmail.com");
        traza.setIdCliente("2");
        traza.setEstadoAnterior("En preparacion");
        traza.setEstadoNuevo("Listo");
        trazaList.add(traza);

        Traza traza2 = new Traza();

        traza2.setId(1);
        traza2.setCorreoCliente("cliente@gmail.com");
        traza2.setCorreoEmpleado("empleado@gmail.com");
        traza2.setIdCliente("2");
        traza2.setEstadoAnterior("En preparacion");
        traza2.setEstadoNuevo("Listo");
        trazaList.add(traza2);


        when(getTrazaServicePort.getTraza(1)).thenReturn(trazaList);


        GetTrazaResponseDto actualResponse = trazaHandler.obtener(requestDto);
        GetTrazaResponseDto expectedResponse = new GetTrazaResponseDto();
        expectedResponse.setTraza(trazaList);

        assertEquals(expectedResponse, actualResponse);
    }


}


