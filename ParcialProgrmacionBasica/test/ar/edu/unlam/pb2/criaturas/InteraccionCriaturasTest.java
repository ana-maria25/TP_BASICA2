package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class InteraccionCriaturasTest {
	

    private Criatura c1;
    private Criatura c2;
    private InteraccionStrategy interaccion;

    @Before
    public void setUp() {
        c1 = new CriaturaAgua("Aqua", 50, Comportamiento.TRANQUILA);
        c2 = new CriaturaFuego("Flama", 60, Comportamiento.TRANQUILA);
        interaccion = new InteraccionCriaturas();
    }

    @Test
    public void testAfinidadOpuestaVuelvenInestables() {
        interaccion.interactuar(c1, c2);
        assertTrue(c1.esInestable());
        assertTrue(c2.esInestable());
    }

    @Test 
    public void testAfinidadCompartidaGanaEnergia() {
        c2 = new CriaturaAgua("Agua2", 40, Comportamiento.TRANQUILA);
        interaccion.interactuar(c1, c2);

        assertEquals(Integer.valueOf(60), c1.getNivelEnergia()); 
        assertEquals(Integer.valueOf(50), c2.getNivelEnergia());
    }

    @Test
    public void testAncestralGanaMasEnergia() {
        c1 = new TransformacionAgua(new CriaturaAgua("AquaLegendaria", 50, Comportamiento.TRANQUILA));
        interaccion.interactuar(c1, c2);

        assertEquals(Integer.valueOf(70), c1.getNivelEnergia()); 
        assertEquals(Integer.valueOf(45), c2.getNivelEnergia()); 
    }

}

