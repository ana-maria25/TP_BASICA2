package ar.edu.unlam.pb2.criaturas;


//SRP: solo representa a la criatura y sus atributos/métodos básicos.
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
	
	//METODO QUE UTILIZA MAESTRO: 
	
	//Un método para saber si son inestables
	public boolean esInestable() {
	    return this.comportamiento == Comportamiento.INESTABLE;
	}

	//Un método para pacificarlas
	public void pacificar() {
	    this.comportamiento = Comportamiento.TRANQUILA;
	}

	
	//Un método para modificar energía
	protected void aumentarEnergia(int cantidad) {
	    this.nivelEnergia += cantidad;
	}
	
	
	//agregamos para saber si una criatura esta transformada
	public boolean tieneTransformaciones() {
	    return this instanceof Transformacion;
	}

}

