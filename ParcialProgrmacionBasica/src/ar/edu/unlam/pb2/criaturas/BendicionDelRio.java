package ar.edu.unlam.pb2.criaturas;

public class BendicionDelRio extends Transformacion {

	private int energiaModificada;

    public BendicionDelRio(Criatura original) {
        super(original);

        int nueva = original.getNivelEnergia() * 2;
        if (nueva > 180) nueva = 180;

        this.energiaModificada = nueva;
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

