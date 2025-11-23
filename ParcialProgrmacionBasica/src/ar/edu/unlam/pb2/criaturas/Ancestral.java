package ar.edu.unlam.pb2.criaturas;
import ar.edu.unlam.pb2.criaturas.EnergiaDesbordadaException;

public class Ancestral extends Criatura {

	protected Ancestral(String nombre, Integer nivelEnergia, AfinidadElemental afinidadElemental,
			Comportamiento comportamiento) {
		super(nombre, nivelEnergia, afinidadElemental, comportamiento);
		
		
        if (this.nivelEnergia < 100) {
            this.nivelEnergia = 100;
        }
	}
	
	@Override
	public Integer entrenar() {
		int aumento = 25; 

        if (aumento > 30) {
            this.comportamiento = Comportamiento.INESTABLE;
        }

        this.aumentarEnergia(aumento);

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
