package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Eficiencia;
import com.pragma.powerup.domain.model.Rank;
import com.pragma.powerup.domain.model.Ranking;
import com.pragma.powerup.domain.spi.IEficienciaPedidoPersistencePort;
import com.pragma.powerup.domain.spi.IRankingPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.TrazaEntity;
import com.pragma.powerup.infrastructure.out.jpa.repository.ITrazabilidadRepository;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class EficicienciaJpaAdapter implements IEficienciaPedidoPersistencePort, IRankingPersistencePort {

    private final ITrazabilidadRepository trazabilidadRepository;

    @Override
    public Eficiencia obtener(int idPedido) {
        List<TrazaEntity> traza = trazabilidadRepository.findByIdPedido(idPedido);

        traza.sort((o1, o2) -> o1.getFecha().compareTo(o2.getFecha()));


        long milisegundos = 0;
        if(traza.size() > 1) {
            milisegundos = Math.abs(traza.get(0).getFecha().getTime() - traza.get(traza.size() - 1).getFecha().getTime());
        }

        double minutos = (double) milisegundos / (60 * 1000);
        double hora = minutos/60;

        Eficiencia res = new Eficiencia();
        res.setIdPedido(idPedido);
        res.setHoras(hora);
        res.setMinutos(minutos);

        return res;
    }

    @Override
    public Ranking rankear(int idEmpleado) {
        List<TrazaEntity> trazas = trazabilidadRepository.findByIdEmpleado(idEmpleado);

        List<Rank> listaTiempos = new ArrayList<>();

        Map<Integer, TrazaEntity> trazasFiltradas = new HashMap<>();
        for (TrazaEntity traza : trazas) {
            trazasFiltradas.putIfAbsent(traza.getIdPedido(), traza);
        }

        List<TrazaEntity> trazasFiltradasList = new ArrayList<>(trazasFiltradas.values());

        for(TrazaEntity entity: trazasFiltradasList){
            Eficiencia eficiencia = obtener(entity.getIdPedido());
            Rank rank = new Rank();
            rank.setIdPedido(entity.getIdPedido());
            rank.setTiempoMinutos(eficiencia.getMinutos());
            listaTiempos.add(rank);
        }

        listaTiempos.sort(Comparator.comparingDouble(Rank::getTiempoMinutos).reversed());


        double sum = 0.0;
        for(Rank rank: listaTiempos){
            sum += rank.getTiempoMinutos();
        }

        double media = sum / listaTiempos.size();

        Ranking response = new Ranking();
        response.setIdEmpleado(idEmpleado);
        response.setRankingList(listaTiempos);
        response.setTiempoMedio(media);

        return response;
    }
}
