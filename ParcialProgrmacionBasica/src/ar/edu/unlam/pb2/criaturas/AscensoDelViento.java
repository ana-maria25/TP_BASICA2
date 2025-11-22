package ar.edu.unlam.pb2.criaturas;

public class AscensoDelViento extends Transformacion {

	public AscensoDelViento(Criatura original) {
        super(original);
    }

    @Override
    public AfinidadElemental getAfinidadElemental() {
        return AfinidadElemental.AIRE;
    }

    @Override
    public Integer getNivelEnergia() {
        return original.getNivelEnergia();
    }

    @Override
    public Comportamiento getComportamiento() {
        return original.getComportamiento();
    }

    @Override
    public Integer entrenar() {
        return original.entrenar();
    }
}