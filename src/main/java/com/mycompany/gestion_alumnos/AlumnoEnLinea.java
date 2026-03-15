/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_alumnos;


public class AlumnoEnLinea extends Alumno{
    
    private int plataforma;

    public AlumnoEnLinea(String matricula, String nombre, int edad, String carrera, int plataforma) {
        super(matricula, nombre, edad, carrera);
        this.plataforma = plataforma;
    }
    
    public void setPlataforma(int plataforma) {
    this.plataforma = plataforma;
}

    public String info(){
        
        String nombreplat= "";
        
        switch(plataforma){
            case 1: 
                nombreplat = "Google Meet";
                break;
             case 2: 
                nombreplat = "Teams";
                break;
              case 3: 
                nombreplat = "Zoom";
                break;
        }
        return super.info () + "| Tipo: En linea"+
                "| Plataforma: " + nombreplat;
    }
    
}
