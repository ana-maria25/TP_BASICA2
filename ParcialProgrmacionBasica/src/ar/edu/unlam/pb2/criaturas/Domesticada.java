package ar.edu.unlam.pb2.criaturas;

public class Domesticada extends Criatura{

	protected Domesticada(String nombre, Integer nivelEnergia, AfinidadElemental afinidadElemental,
			Comportamiento comportamiento) {
		super(nombre, nivelEnergia, afinidadElemental, comportamiento);
	}

	@Override
	public Integer entrenar() {
		return null;
	}
	
	public String getNombre() { 
    	return this.nombre; 
    }
	
	public Integer getNivelEnergia() { 
    	return this.nivelEnergia; 
    }
	
	public AfinidadElemental getAfinidadElemental() { 
    	return this.afinidadElemental; 
    }
	
	public Comportamiento getComportamiento() { 
    	return this.comportamiento; 
    }

}
