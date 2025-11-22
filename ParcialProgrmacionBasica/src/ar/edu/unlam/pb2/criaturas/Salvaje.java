package ar.edu.unlam.pb2.criaturas;

import ar.edu.unlam.pb2.criaturas.EnergiaDesbordadaException;

public class Salvaje extends Criatura{
	
	protected Salvaje(String nombre, Integer nivelEnergia, AfinidadElemental afinidadElemental,
			Comportamiento comportamiento) {
		super(nombre, nivelEnergia, afinidadElemental, comportamiento);
		// TODO Auto-generated constructor stub
	}
	
	
	
	//se agrega logica al entrenamiento

	@Override
	public Integer entrenar() {
		
		// Aumento impredecible (TP deja libertad)
        int aumento = 20;

        this.aumentarEnergia(aumento);

        if (this.nivelEnergia > 200) {
            throw new EnergiaDesbordadaException(
                "La criatura salvaje excedió el límite de energía permitido."
            );
        }

        return this.nivelEnergia;
    }
		
	
	}
	
	

