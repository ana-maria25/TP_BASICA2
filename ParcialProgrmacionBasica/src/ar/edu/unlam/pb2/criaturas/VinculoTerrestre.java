package ar.edu.unlam.pb2.criaturas;

public class VinculoTerrestre extends Transformacion {

	private int energiaModificada;

    public VinculoTerrestre(Criatura original) {
        super(original);

        energiaModificada = Math.max(50, original.getNivelEnergia());
    }

    @Override
    public Integer getNivelEnergia() {
        return energiaModificada;
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
