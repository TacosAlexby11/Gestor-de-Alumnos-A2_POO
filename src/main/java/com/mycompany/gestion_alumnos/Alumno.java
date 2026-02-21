package com.mycompany.gestion_alumnos;

public class Alumno {

    private String matricula;
    private String nombre;
    private int edad;
    private String carrera;

    // Constructor
    public Alumno(String matricula, String nombre, int edad, String carrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    // Método para imprimir datos
    public String info() {
        return "Matricula: " + matricula +
               " | Nombre: " + nombre +
               " | Edad: " + edad +
               " | Carrera: " + carrera;
    }
}
