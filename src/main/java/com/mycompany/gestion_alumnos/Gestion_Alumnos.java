package com.mycompany.gestion_alumnos;

import java.util.Scanner;

public class Gestion_Alumnos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorAlumnos gestor = new GestorAlumnos();

        int opcion;

        do {
            System.out.println("\n===== GESTION DE ALUMNOS =====");
            System.out.println("1) Registrar alumno");
            System.out.println("2) Listar alumnos");
            System.out.println("3) Buscar por matricula");
            System.out.println("4) Actualizar alumno");
            System.out.println("5) Eliminar alumno");
            System.out.println("0) Salir");
            System.out.print("Elige una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.print("Opcion invalida. Intenta de nuevo: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar salto

            switch (opcion) {

                case 1 -> {
                    int tipo = 0;
                    do {
                        System.out.print("Escoge tipo de alumno: 1 Presencial | 2 En Linea: ");

                        if (sc.hasNextInt()) {
                            tipo = sc.nextInt();

                            if (tipo < 1 || tipo > 2) {
                                System.out.println("Opcion invalida. Solo se permite 1 o 2.");
                            }

                        } else {
                            System.out.println("Entrada invalida. Debes ingresar un numero.");
                            sc.next(); // limpia el valor incorrecto
                        }

                    } while (tipo < 1 || tipo > 2);
                    sc.nextLine(); 
                    if (tipo == 1){
                        System.out.print("Matricula: ");
                        String matricula = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = leerEntero(sc);

                        System.out.print("Carrera: ");
                        String carrera = sc.nextLine();
                        
                        System.out.print("Aula: ");
                        String aula = sc.nextLine();
                        
                        System.out.print("Edificio: ");
                        String edificio = sc.nextLine();
                        
                        Alumno a = new AlumnoPresencial(matricula, nombre, edad, carrera, aula, edificio);
                        boolean ok = gestor.agregar(a);
                        System.out.println(ok ? "Alumno registrado." : "Ya existe esa matricula.");
                    }
                    else
                    {
                        System.out.print("Matricula: ");
                        String matricula = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = leerEntero(sc);

                        System.out.print("Carrera: ");
                        String carrera = sc.nextLine();
                        
                        int plataforma;

                        do {
                            System.out.print("Que plataforma usara el alumno: 1. Google Meet | 2. Teams | 3. Zoom: ");
                            plataforma = sc.nextInt();
                        } while (plataforma < 1 || plataforma > 3);

                        sc.nextLine();

                        // Instanciación (new) + constructor
                        Alumno a = new AlumnoEnLinea(matricula, nombre, edad, carrera, plataforma);
                        boolean ok = gestor.agregar(a);
                        System.out.println(ok ? "Alumno registrado." : "Ya existe esa matricula.");
                    }
                    
                }

                case 2 -> gestor.listar();

                case 3 -> {
                    System.out.print("Matricula a buscar: ");
                    String m = sc.nextLine();

                    Alumno a = gestor.buscarPorMatricula(m);

                    if (a == null) System.out.println("No encontrado.");
                    else System.out.println("Encontrado: " + a.info());
                }

                case 4 -> {

                    System.out.print("Matricula a actualizar: ");
                    String m = sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Nueva edad: ");
                    int nuevaEdad = leerEntero(sc);

                    System.out.print("Nueva carrera: ");
                    String nuevaCarrera = sc.nextLine();

                    int tipo;

                    do {
                        System.out.print("Escoge tipo de alumno: 1 Presencial | 2 En Linea: ");
                        tipo = sc.nextInt();
                    } while (tipo < 1 || tipo > 2);

                    sc.nextLine();

                    String nuevaAula = null;
                    String nuevoEdificio = null;
                    int nuevaPlataforma = 0;

                    if (tipo == 1) {

                        System.out.print("Nueva aula: ");
                        nuevaAula = sc.nextLine();

                        System.out.print("Nuevo edificio: ");
                        nuevoEdificio = sc.nextLine();

                    } else {

                        do {
                            System.out.print("Que plataforma usara el alumno: 1 Google Meet | 2 Teams | 3 Zoom: ");
                            nuevaPlataforma = sc.nextInt();
                        } while (nuevaPlataforma < 1 || nuevaPlataforma > 3);

                        sc.nextLine();
                    }

                    boolean ok = gestor.actualizar(
                            m,
                            nuevoNombre,
                            nuevaEdad,
                            nuevaCarrera,
                            nuevaAula,
                            nuevoEdificio,
                            nuevaPlataforma,
                            tipo
                    );

                    System.out.println(ok ? "Actualizado correctamente." : "No existe esa matricula.");
                }


                case 5 -> {
                    System.out.print("Matricula a eliminar: ");
                    String m = sc.nextLine();
                    boolean ok = gestor.eliminar(m);
                    System.out.println(ok ? "Eliminado correctamente." : "No existe esa matricula.");
                }

                case 0 -> System.out.println("Saliendo...");

                default -> System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Valor invalido. Ingresa un numero: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // limpiar
        return val;
    }
}