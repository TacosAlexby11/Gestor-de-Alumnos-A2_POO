/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_alumnos;

/**
 *
 * @author alons
 */
public class AlumnoPresencial extends Alumno{
    private String aula;
    private String edificio;
    public AlumnoPresencial(String matricula, String nombre, int edad, String carrera, String aula, String edificio) {
        super(matricula, nombre, edad, carrera);
        this.aula = aula;
        this.edificio = edificio;
    }
    
    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }
    
    public String info(){
            return super.info() + "| Aula: " + aula +
                   "| Edificio: " + edificio;
    }
}
    
