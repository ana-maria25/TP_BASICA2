package ar.edu.unlam.pb2.criaturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportesConsejo {

    public List<Criatura> listarTodasCriaturas(List<MaestroElemental> maestros) {
        List<Criatura> todas = new ArrayList<>();

        if (maestros == null) return todas;

        for (MaestroElemental m : maestros) {
            if (m != null) {
                todas.addAll(m.getMapaCriaturas().values());
            }
        }
        return todas;
    }

   
    public Criatura criaturaConMayorEnergia(List<MaestroElemental> maestros) {
        List<Criatura> todas = listarTodasCriaturas(maestros);

        if (todas.isEmpty()) return null;

        Criatura max = todas.get(0);
        for (Criatura c : todas) {
            if (c.getNivelEnergia() > max.getNivelEnergia()) {
                max = c;
            }
        }
        return max;
    }


    public MaestroElemental maestroConMasTransformadas(List<MaestroElemental> maestros) {
        if (maestros == null || maestros.isEmpty()) return null;

        MaestroElemental max = null;
        int mayorCantidad = 0;

        for (MaestroElemental m : maestros) {
            if (m != null) {
                int cant = m.cantidadCriaturasTransformadas();
                if (cant > mayorCantidad) {
                    mayorCantidad = cant;
                    max = m;
                }
            }
        }
        return max;
    }


    public Map<AfinidadElemental, Integer> cantidadPorAfinidad(List<MaestroElemental> maestros) {
        Map<AfinidadElemental, Integer> mapa = new HashMap<>();

        if (maestros == null) return mapa;

        for (MaestroElemental m : maestros) {
            if (m != null) {
                for (Criatura c : m.getMapaCriaturas().values()) {

                    AfinidadElemental afinidad = c.getAfinidadElemental();

                    mapa.put(
                        afinidad,
                        mapa.getOrDefault(afinidad, 0) + 1
                    );
                }
            }
        }
        return mapa;
    }
}
