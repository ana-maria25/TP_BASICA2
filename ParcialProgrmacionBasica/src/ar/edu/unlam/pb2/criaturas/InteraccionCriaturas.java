
package ar.edu.unlam.pb2.criaturas;


public class InteraccionCriaturas implements InteraccionStrategy {

    @Override
    public void interactuar(Criatura c1, Criatura c2) {
     
        if (c1.tieneTransformaciones() && !c2.tieneTransformaciones()) {
            c1.aumentarEnergia(20);
            c2.aumentarEnergia(-15);
        } else if (!c1.tieneTransformaciones() && c2.tieneTransformaciones()) {
            c2.aumentarEnergia(20);
            c1.aumentarEnergia(-15);
        }

        else if (c1.getAfinidadElemental() == c2.getAfinidadElemental()) {
            c1.aumentarEnergia(10);
            c2.aumentarEnergia(10);
        }

        else if (sonOpuestas(c1.getAfinidadElemental(), c2.getAfinidadElemental())) {
            c1.comportamiento = Comportamiento.INESTABLE;
            c2.comportamiento = Comportamiento.INESTABLE;
        }
    }

    private boolean sonOpuestas(AfinidadElemental a1, AfinidadElemental a2) {
        return (a1 == AfinidadElemental.AGUA && a2 == AfinidadElemental.FUEGO) ||
               (a1 == AfinidadElemental.FUEGO && a2 == AfinidadElemental.AGUA) ||
               (a1 == AfinidadElemental.AIRE && a2 == AfinidadElemental.TIERRA) ||
               (a1 == AfinidadElemental.TIERRA && a2 == AfinidadElemental.AIRE);
    }
}
