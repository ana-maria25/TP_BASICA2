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

    // ----- Métodos que implementaremos después -----

    /**
     * Entrena a la criatura identificada por nombre.
     * La implementación concreta depende de las reglas por tipo de criatura
     * (Salvaje/Domesticada/Ancestral). Lanzará FaltaDeMaestriaException si el
     * maestro no tiene la maestría requerida para el tipo de entrenamiento.
     *
     * Dejo la firma ya lista para usar en los tests: implementaremos la lógica
     * cuando tengamos la API de Criatura.
     */
    public void entrenar(String nombreCriatura) throws FaltaDeMaestriaException {
        // TODO: implementar reglas de entrenamiento según tipo de criatura
        // (Depende de métodos públicos de Criatura: p.ej. aumentarEnergia, getTipo, etc.)
        throw new UnsupportedOperationException("Método entrenar aún no implementado");
    }

    /**
     * Intenta pacificar una criatura inestable. La solución debe ser polimórfica:
     * cada tipo de criatura deberá ofrecer su propia forma de pacificarse.
     *
     * Implementación pendiente hasta disponer de la interfaz pública de Criatura.
     */
    public void pacificar(String nombreCriatura) {
        // TODO: implementar pacificación usando el comportamiento polimórfico de Criatura
        throw new UnsupportedOperationException("Método pacificar aún no implementado");
    }

    /**
     * Devuelve cuántas criaturas registradas tienen transformaciones aplicadas.
     * Lo implementaremos cuando sepamos cómo se representan las transformaciones en Criatura.
     */
    public int cantidadCriaturasTransformadas() {
        // TODO: requerirá consultar un método de Criatura (p.ej. tieneTransformaciones())
        throw new UnsupportedOperationException("Método cantidadCriaturasTransformadas aún no implementado");
    }

    // Métodos de utilidad que pueden usarse en tests/reportes
    public Map<String, Criatura> getMapaCriaturas() {
        return Collections.unmodifiableMap(criaturas);
    }
}
