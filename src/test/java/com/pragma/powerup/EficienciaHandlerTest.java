package com.pragma.powerup;

import com.pragma.powerup.application.dto.response.GetEficienteResponseDto;
import com.pragma.powerup.application.handler.impl.EficienciaHandler;
import com.pragma.powerup.application.mapper.IEficienciaResponseMapper;
import com.pragma.powerup.domain.api.IEficienciaPedidoServicePort;
import com.pragma.powerup.domain.model.Eficiencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EficienciaHandlerTest {
    @Mock
    private IEficienciaPedidoServicePort eficienciaPedidoServicePort;

    @Mock
    private IEficienciaResponseMapper eficienciaResponseMapper;
    @InjectMocks
    private EficienciaHandler eficienciaHandler;

    @BeforeEach
    public void setUp() {

        eficienciaHandler = new EficienciaHandler(
                eficienciaPedidoServicePort,
                eficienciaResponseMapper
        );
    }

    @Test
    void testObtenerEficiencia() {

        int idPedido = 1;
        Eficiencia eficiencia = new Eficiencia();

        eficiencia.setIdPedido(idPedido);
        eficiencia.setMinutos(60);
        eficiencia.setHoras(1);

        GetEficienteResponseDto responseDto = new GetEficienteResponseDto();
        responseDto.setIdPedido(idPedido);
        responseDto.setMinutos(60);
        responseDto.setHoras(1);

        when(eficienciaPedidoServicePort.obtener(idPedido)).thenReturn(eficiencia);
        when(eficienciaResponseMapper.toDto(eficiencia)).thenReturn(responseDto);

        GetEficienteResponseDto result = eficienciaHandler.obtener(idPedido);

        assertEquals(responseDto, result);
    }
}

