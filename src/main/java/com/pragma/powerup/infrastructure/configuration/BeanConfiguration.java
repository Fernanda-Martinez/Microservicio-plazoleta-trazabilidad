package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.ITrazaServicePort;
import com.pragma.powerup.domain.spi.ITrazaPersistencePort;
import com.pragma.powerup.domain.usecase.TrazaUseCase;
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

}