package com.mycompany.gestion_alumnos;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorAlumnos {
    Scanner sc = new Scanner(System.in);
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

    public boolean actualizar(String matricula, String nombre, int edad, String carrera,
                              String aula, String edificio, int plataforma, int tipo) {

        for (int i = 0; i < alumnos.size(); i++) {

            Alumno a = alumnos.get(i);

            if (a.getMatricula().equals(matricula)) {

                Alumno nuevo;

                if (tipo == 1) {
                    // alumno presencial
                    nuevo = new AlumnoPresencial(matricula, nombre, edad, carrera, aula, edificio);
                } else {
                    // alumno en linea
                    nuevo = new AlumnoEnLinea(matricula, nombre, edad, carrera, plataforma);
                }

                alumnos.set(i, nuevo);
                return true;
            }
        }

        return false;
    }

    public boolean eliminar(String matricula) {
        Alumno a = buscarPorMatricula(matricula);
        if (a == null) return false;

        alumnos.remove(a);
        return true;
    }

}