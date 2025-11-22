package ar.edu.unlam.pb2.criaturas;

public abstract class Criatura {
	protected String nombre; 
	protected Integer nivelEnergia;
	protected AfinidadElemental afinidadElemental;
	protected Comportamiento comportamiento;
	
	protected Criatura(String nombre, Integer nivelEnergia, AfinidadElemental afinidadElemental, Comportamiento comportamiento) {
	this.nombre = nombre;
	this.nivelEnergia = nivelEnergia;
	this.afinidadElemental = afinidadElemental;
	this.comportamiento = comportamiento;
	}
	
	public abstract Integer entrenar();

	public String getNombre() {
		return nombre;
	}

	public Integer getNivelEnergia() {
		return nivelEnergia;
	}

	public AfinidadElemental getAfinidadElemental() {
		return afinidadElemental;
	}

	public Comportamiento getComportamiento() {
		return comportamiento;
	}
	
	
}

