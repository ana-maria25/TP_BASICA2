package ar.edu.unlam.pb2.criaturas;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class MaestroElemental {

	private String nombre;
    private int nivelMaestria; // 1..50
    private AfinidadElemental afinidadPrincipal;
    private HashMap<String, Criatura> criaturas; // clave: nombre de criatura

    public MaestroElemental(String nombre, int nivelMaestria, AfinidadElemental afinidadPrincipal) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del maestro no puede ser vacío");
        }
        if (nivelMaestria < 1 || nivelMaestria > 50) {
            throw new IllegalArgumentException("Nivel de maestría debe estar entre 1 y 50");
        }
        if (afinidadPrincipal == null) {
            throw new IllegalArgumentException("Afinidad principal no puede ser nula");
        }

        this.nombre = nombre;
        this.nivelMaestria = nivelMaestria;
        this.afinidadPrincipal = afinidadPrincipal;
        this.criaturas = new HashMap<>();
    }

    // ----- Operaciones sobre criaturas -----

    /**
     * Registra (agrega o reemplaza) una criatura a cargo del maestro.
     * La clave es el nombre de la criatura (suponemos que Criatura tiene getNombre()).
     */
    public void registrarCriatura(Criatura criatura) {
        if (criatura == null) {
            throw new IllegalArgumentException("Criatura no puede ser nula");
        }
        String nombreCriatura = criatura.getNombre();
        if (nombreCriatura == null || nombreCriatura.trim().isEmpty()) {
            throw new IllegalArgumentException("La criatura debe tener un nombre válido");
        }
        criaturas.put(nombreCriatura, criatura);
    }

    /**
     * Devuelve la criatura registrada por nombre, o null si no existe.
     */
    public Criatura obtenerCriatura(String nombre) {
        return criaturas.get(nombre);
    }

    /**
     * Devuelve la colección inmutable de criaturas a cargo del maestro.
     */
    public Collection<Criatura> listarCriaturas() {
        return Collections.unmodifiableCollection(criaturas.values());
    }

    /**
     * Devuelve la cantidad de criaturas a cargo.
     */
    public int cantidadCriaturas() {
        return criaturas.size();
    }

    // ----- Getters básicos -----
    public String getNombre() {
        return nombre;
    }

    public int getNivelMaestria() {
        return nivelMaestria;
    }

    public AfinidadElemental getAfinidadPrincipal() {
        return afinidadPrincipal;
    }

    
    
    public void entrenar(String nombreCriatura) throws FaltaDeMaestriaException {
        Criatura criatura = criaturas.get(nombreCriatura);

        if (criatura == null) {
            throw new IllegalArgumentException("La criatura no existe: " + nombreCriatura);
        }

        // Regla arbitraria pero válida: se requiere nivel de maestría proporcional
        int maestriaRequerida = criatura.getNivelEnergia() / 10;

        if (this.nivelMaestria < maestriaRequerida) {
            throw new FaltaDeMaestriaException(
                "Maestría insuficiente para entrenar a " + criatura.getNombre()
            );
        }

        // Entrenamiento polimórfico según tipo: Salvaje / Domesticada / Ancestral
        criatura.entrenar();
    }

    
    public void pacificar(String nombreCriatura) {
        Criatura criatura = criaturas.get(nombreCriatura);

        if (criatura == null) {
            throw new IllegalArgumentException("La criatura no existe: " + nombreCriatura);
        }

        if (criatura.esInestable()) {
            criatura.pacificar();
        }
    }

    
    public int cantidadCriaturasTransformadas() {
        int total = 0;

        for (Criatura c : criaturas.values()) {
            if (c instanceof Transformacion) {
                total++;
            }
        }
        return total;
    }
    
    //reemplazar la criatura
    
    public void transformar(String nombreCriatura, Transformacion transformada) {
        if (!criaturas.containsKey(nombreCriatura)) {
            throw new IllegalArgumentException("La criatura no existe: " + nombreCriatura);
        }
        criaturas.put(nombreCriatura, transformada);
    }



    // Métodos de utilidad que pueden usarse en tests/reportes
    public Map<String, Criatura> getMapaCriaturas() {
        return Collections.unmodifiableMap(criaturas);
    }
}
