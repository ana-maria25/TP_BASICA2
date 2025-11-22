package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransformacionesTest {

	@Test
	public void queBendicionDelRioDupliqueEnergiaSinSuperar180() {
	    Criatura c = new Salvaje("Rok", 100, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);

	    c = new BendicionDelRio(c);

	    assertEquals(180, (int) c.getNivelEnergia());
	}
	
	@Test
	public void queLlamaInternaAumenteEnergiaCuandoEsDeFuego() {
	    Criatura c = new Salvaje("Rok", 70, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);

	    c = new LlamaInterna(c);

	    assertEquals(100, (int) c.getNivelEnergia());
	    assertEquals(Comportamiento.TRANQUILA, c.getComportamiento());
	}

	@Test
	public void queLlamaInternaVuelvaInestableSiNoEsDeFuego() {
	    Criatura c = new Salvaje("Rok", 70, AfinidadElemental.AGUA, Comportamiento.TRANQUILA);

	    c = new LlamaInterna(c);

	    assertEquals(70, (int) c.getNivelEnergia());
	    assertEquals(Comportamiento.INESTABLE, c.getComportamiento());
	}

	@Test
	public void queVinculoTerrestreAsegureEnergiaMinima50() {
	    Criatura c = new Salvaje("Rok", 20, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);

	    c = new VinculoTerrestre(c);

	    assertEquals(50, (int) c.getNivelEnergia());
	}

	@Test
	public void queAscensoDelVientoCambieAfinidadAAire() {
	    Criatura c = new Salvaje("Rok", 90, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);

	    c = new AscensoDelViento(c);

	    assertEquals(AfinidadElemental.AIRE, c.getAfinidadElemental());
	}

	@Test
	public void queLasTransformacionesSeEncadenenCorrectamente() {
	    Criatura c = new Salvaje("Rok", 60, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);

	    c = new BendicionDelRio(c);      // 60 → 120
	    c = new LlamaInterna(c);         // +30 → 150
	    c = new VinculoTerrestre(c);     // sigue 150
	    c = new AscensoDelViento(c);     // afinidad aire

	    assertEquals(150, (int) c.getNivelEnergia());
	    assertEquals(AfinidadElemental.AIRE, c.getAfinidadElemental());
	}

	@Test
	public void queMaestroCuenteCriaturasTransformadas() {
	    MaestroElemental m = new MaestroElemental("Ari", 40, AfinidadElemental.FUEGO);

	    Criatura c1 = new Salvaje("Rok", 80, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);
	    Criatura c2 = new Salvaje("Bok", 50, AfinidadElemental.AGUA, Comportamiento.TRANQUILA);

	    m.registrarCriatura(new BendicionDelRio(c1));  
	    m.registrarCriatura(new AscensoDelViento(c2)); 

	    assertEquals(2, m.cantidadCriaturasTransformadas());
	}

	@Test
	public void queSePuedaEntrenarUnaCriaturaTransformada() throws Exception {
	    MaestroElemental m = new MaestroElemental("Ari", 50, AfinidadElemental.FUEGO);

	    Criatura c = new Salvaje("Rok", 60, AfinidadElemental.FUEGO, Comportamiento.TRANQUILA);
	    c = new BendicionDelRio(c); // 120

	    m.registrarCriatura(c);

	    m.entrenar("Rok");

	    assertTrue(c.getNivelEnergia() > 120);
	}


}
