package ar.edu.unlam.pb2.criaturas;

public abstract class Transformacion extends Criatura {

    protected Criatura original;

    public Transformacion(Criatura original) {
        super(
            original.getNombre(),
            original.getNivelEnergia(),
            original.getAfinidadElemental(),
            original.getComportamiento()
        );
        this.original = original;
    }

    @Override
    public String getNombre() {
        return original.getNombre();
    }

    @Override
    public AfinidadElemental getAfinidadElemental() {
        return original.getAfinidadElemental();
    }

    @Override
    public abstract Integer getNivelEnergia();

    @Override
    public abstract Comportamiento getComportamiento();

}

