

package ar.edu.unlam.pb2.criaturas;

public class CriaturaAgua extends Criatura {

    public CriaturaAgua(String nombre, Integer nivelEnergia, Comportamiento comportamiento) {
        super(nombre, nivelEnergia, AfinidadElemental.AGUA, comportamiento);
    }

    @Override
    public Integer entrenar() {
        // Lógica de entrenamiento simple para el test
        this.nivelEnergia += 5;
        return this.nivelEnergia;
    }
}

