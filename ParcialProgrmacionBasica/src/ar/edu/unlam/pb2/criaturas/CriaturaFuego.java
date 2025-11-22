package ar.edu.unlam.pb2.criaturas;

public class CriaturaFuego extends Criatura {

    public CriaturaFuego(String nombre, Integer nivelEnergia, Comportamiento comportamiento) {
        super(nombre, nivelEnergia, AfinidadElemental.FUEGO, comportamiento);
    }

    @Override
    public Integer entrenar() {
        // lógica simple de entrenamiento
        this.nivelEnergia += 5;
        return this.nivelEnergia;
    }
}
