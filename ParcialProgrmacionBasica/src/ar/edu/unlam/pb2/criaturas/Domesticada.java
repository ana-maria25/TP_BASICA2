package ar.edu.unlam.pb2.criaturas;

import ar.edu.unlam.pb2.criaturas.EnergiaDesbordadaException;

public class Domesticada extends Criatura{

	protected Domesticada(String nombre, Integer nivelEnergia, AfinidadElemental afinidadElemental,
			Comportamiento comportamiento) {
		super(nombre, nivelEnergia, afinidadElemental, comportamiento);
		 // Regla del TP: Domesticada nunca es inestable
        this.comportamiento = Comportamiento.TRANQUILA;
	}
	
	//se agregan logica a entrenamiento

	@Override
	public Integer entrenar() {
		 int aumento = 15;

	        this.aumentarEnergia(aumento);

	        // Nunca puede quedar inestable
	        this.comportamiento = Comportamiento.TRANQUILA;

	        return this.nivelEnergia;
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
