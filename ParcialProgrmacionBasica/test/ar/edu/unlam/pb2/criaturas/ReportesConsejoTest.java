package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ReportesConsejoTest {

    private List<MaestroElemental> maestros;
    private ReportesConsejo reporte;

    private MaestroElemental maestro1;
    private MaestroElemental maestro2;

    private Criatura agua1;
    private Criatura fuego1;
    private Criatura tierra1;

    private Criatura transformada;

    @Before
    public void setUp() {
        reporte = new ReportesConsejo();
        maestros = new ArrayList<>();

       
        maestro1 = new MaestroElemental("Aelar", 30, AfinidadElemental.AGUA);
        maestro2 = new MaestroElemental("Fyra", 45, AfinidadElemental.FUEGO);

        
        agua1 = new Domesticada("Naiad", 120, AfinidadElemental.AGUA, Comportamiento.TRANQUILA);
        fuego1 = new Salvaje("Fenix", 150, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);
        tierra1 = new Ancestral("Golem", 180, AfinidadElemental.TIERRA, Comportamiento.TRANQUILA);

     
        transformada = new Transformacion(agua1) {
        	
            @Override
            public Integer getNivelEnergia() {
                return original.getNivelEnergia();
            }

            @Override
            public Comportamiento getComportamiento() {
                return original.getComportamiento();
            }

            @Override
            public Integer entrenar() {
                return original.entrenar();
            }
            
            @Override
            public String getNombre() {
                return original.getNombre() + " (Transformada)";
            }
        };

       
        maestro1.registrarCriatura(agua1);
        maestro1.registrarCriatura(transformada);

        maestro2.registrarCriatura(fuego1);
        maestro2.registrarCriatura(tierra1);

        maestros.add(maestro1);
        maestros.add(maestro2);
    }

 
    @Test
    public void testListarTodasCriaturas() {
        List<Criatura> todas = reporte.listarTodasCriaturas(maestros);

        assertEquals(4, todas.size());
        assertTrue(todas.contains(agua1));
        assertTrue(todas.contains(fuego1));
        assertTrue(todas.contains(tierra1));
        assertTrue(todas.contains(transformada));
    }

    @Test
    public void testListarTodasCriaturasListaVacia() {
        List<Criatura> todas = reporte.listarTodasCriaturas(new ArrayList<MaestroElemental>());
        assertTrue(todas.isEmpty());
    }

    @Test
    public void testCriaturaConMayorEnergia() {
        Criatura mayor = reporte.criaturaConMayorEnergia(maestros);

        assertNotNull(mayor);
        assertEquals("Golem", mayor.getNombre());
    }

    @Test
    public void testCriaturaConMayorEnergiaListaVacia() {
        Criatura mayor = reporte.criaturaConMayorEnergia(new ArrayList<MaestroElemental>());
        assertNull(mayor);
    }

    @Test
    public void testMaestroConMasTransformadas() {
        MaestroElemental max = reporte.maestroConMasTransformadas(maestros);

        assertNotNull(max);
        assertEquals("Aelar", max.getNombre());
    }

    @Test
    public void testMaestroConMasTransformadasListaVacia() {
        MaestroElemental max = reporte.maestroConMasTransformadas(new ArrayList<MaestroElemental>());
        assertNull(max);
    }

    @Test
    public void testMaestroConMasTransformadasEmpate() {
        Transformacion t2 = new Transformacion(fuego1) {
            @Override
            public Integer getNivelEnergia() {
                return original.getNivelEnergia();
            }
            @Override
            public Comportamiento getComportamiento() {
                return original.getComportamiento();
            }
            @Override
            public Integer entrenar() {
                return original.entrenar();
            }
        };

        maestro2.transformar("Fenix", t2);

        MaestroElemental max = reporte.maestroConMasTransformadas(maestros);

        assertNotNull(max);
        assertTrue(max.getNombre().equals("Aelar") || max.getNombre().equals("Fyra"));
    }

    @Test
    public void testCantidadPorAfinidad() {
        Map<AfinidadElemental, Integer> mapa = reporte.cantidadPorAfinidad(maestros);

        assertEquals(Integer.valueOf(2), mapa.get(AfinidadElemental.AGUA));
        assertEquals(Integer.valueOf(1), mapa.get(AfinidadElemental.FUEGO));
        assertEquals(Integer.valueOf(1), mapa.get(AfinidadElemental.TIERRA));

        assertNull(mapa.get(AfinidadElemental.AIRE));
    }

    @Test
    public void testCantidadPorAfinidadListaVacia() {
        Map<AfinidadElemental, Integer> mapa = reporte.cantidadPorAfinidad(new ArrayList<MaestroElemental>());
        assertTrue(mapa.isEmpty());
    }
}
