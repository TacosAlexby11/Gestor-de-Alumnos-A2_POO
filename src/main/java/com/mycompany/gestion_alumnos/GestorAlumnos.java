package com.mycompany.gestion_alumnos;

import java.util.ArrayList;

public class GestorAlumnos {

    private ArrayList<Alumno> alumnos;

    // Constructor
    public GestorAlumnos() {
        alumnos = new ArrayList<>();
    }

    public boolean agregar(Alumno a) {
        if (buscarPorMatricula(a.getMatricula()) != null) {
            return false;
        }
        alumnos.add(a);
        return true;
    }

    public void listar() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        for (Alumno a : alumnos) {
            System.out.println(a.info());
        }
    }

    public Alumno buscarPorMatricula(String matricula) {
        for (Alumno a : alumnos) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                return a;
            }
        }
        return null;
    }

    public boolean actualizar(String matricula, String nuevoNombre, int nuevaEdad, String nuevaCarrera) {
        Alumno a = buscarPorMatricula(matricula);
        if (a == null) return false;

        a.setNombre(nuevoNombre);
        a.setEdad(nuevaEdad);
        a.setCarrera(nuevaCarrera);
        return true;
    }

    public boolean eliminar(String matricula) {
        Alumno a = buscarPorMatricula(matricula);
        if (a == null) return false;

        alumnos.remove(a);
        return true;
    }

}