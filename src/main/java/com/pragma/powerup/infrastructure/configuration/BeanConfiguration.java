package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IEficienciaPedidoServicePort;
import com.pragma.powerup.domain.api.IGetTrazaServicePort;
import com.pragma.powerup.domain.api.IRankingServicePort;
import com.pragma.powerup.domain.api.ITrazaServicePort;
import com.pragma.powerup.domain.spi.IEficienciaPedidoPersistencePort;
import com.pragma.powerup.domain.spi.IGetTrazaPersistencePort;
import com.pragma.powerup.domain.spi.IRankingPersistencePort;
import com.pragma.powerup.domain.spi.ITrazaPersistencePort;
import com.pragma.powerup.domain.usecase.GetTrazaUseCase;
import com.pragma.powerup.domain.usecase.ObtenerEficienciaUseCase;
import com.pragma.powerup.domain.usecase.RankingUseCase;
import com.pragma.powerup.domain.usecase.TrazaUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.EficicienciaJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.TrazaJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.ITrazaEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.ITrazabilidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITrazabilidadRepository trazabilidadRepository;
    private final ITrazaEntityMapper trazaEntityMapper;

    @Bean
    public ITrazaPersistencePort trazaPersistencePort() {
        return new TrazaJpaAdapter(trazabilidadRepository, trazaEntityMapper);
    }

    @Bean
    public ITrazaServicePort trazaServicePort() {
        return new TrazaUseCase(trazaPersistencePort());
    }

    @Bean
    public IGetTrazaPersistencePort getTrazaPersistencePort(){
        return new TrazaJpaAdapter(trazabilidadRepository, trazaEntityMapper);
    }

    @Bean
    public IGetTrazaServicePort getTrazaServicePort() {
        return new GetTrazaUseCase(getTrazaPersistencePort());
    }

    @Bean
    public IEficienciaPedidoPersistencePort eficienciaPedidoPersistencePort(){
        return new EficicienciaJpaAdapter(trazabilidadRepository);
    }

    @Bean
    public IEficienciaPedidoServicePort eficienciaPedidoServicePort(){
        return new ObtenerEficienciaUseCase(eficienciaPedidoPersistencePort());
    }

    @Bean
    IRankingPersistencePort rankingPersistencePort(){
        return new EficicienciaJpaAdapter(trazabilidadRepository);
    }

    @Bean
    IRankingServicePort rankingServicePort(){
        return new RankingUseCase(rankingPersistencePort());
    }

}