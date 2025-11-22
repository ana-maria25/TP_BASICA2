package ar.edu.unlam.pb2.criaturas;


public class TransformacionAgua extends Transformacion {

    public TransformacionAgua(Criatura original) {
        super(original);
    }

    @Override
    public Integer getNivelEnergia() {
        return original.getNivelEnergia() + 20; // bonus por transformación
    }

    @Override
    public Comportamiento getComportamiento() {
        return original.getComportamiento();
    }

    @Override
    public Integer entrenar() {
        return getNivelEnergia() + 5;
    }
}

