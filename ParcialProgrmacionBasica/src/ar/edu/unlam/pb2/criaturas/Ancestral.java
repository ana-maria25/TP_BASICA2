package ar.edu.unlam.pb2.criaturas;
import ar.edu.unlam.pb2.criaturas.EnergiaDesbordadaException;

public class Ancestral extends Criatura {

	protected Ancestral(String nombre, Integer nivelEnergia, AfinidadElemental afinidadElemental,
			Comportamiento comportamiento) {
		super(nombre, nivelEnergia, afinidadElemental, comportamiento);
		
		 // Regla: nunca menos de 100
        if (this.nivelEnergia < 100) {
            this.nivelEnergia = 100;
        }
	}
	
	//se agregan logica a entrenamiento

	@Override
	public Integer entrenar() {
		int aumento = 25; // estable por defecto

        // Si el entrenamiento es extremo, se vuelve inestable
        if (aumento > 30) {
            this.comportamiento = Comportamiento.INESTABLE;
        }

        this.aumentarEnergia(aumento);

        // Regla obligatoria: nunca menos de 100
        if (this.nivelEnergia < 100) {
            this.nivelEnergia = 100;
        }

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
