package ar.edu.unlam.pb2.criaturas;

public class LlamaInterna extends Transformacion {

	private Integer energiaModificada;
    private Comportamiento comportamientoModificado;

    public LlamaInterna(Criatura original) {
        super(original);

        if (original.getAfinidadElemental() == AfinidadElemental.FUEGO) {
            energiaModificada = original.getNivelEnergia() + 30;
            comportamientoModificado = original.getComportamiento();
        } else {
            energiaModificada = original.getNivelEnergia();
            comportamientoModificado = Comportamiento.INESTABLE;
        }
    }

    @Override
    public Integer getNivelEnergia() {
        return energiaModificada;
    }

    @Override
    public Comportamiento getComportamiento() {
        return comportamientoModificado;
    }

    @Override
    public Integer entrenar() {
        return original.entrenar();
    }
}
