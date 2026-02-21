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
                    System.out.print("Matricula: ");
                    String matricula = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = leerEntero(sc);

                    System.out.print("Carrera: ");
                    String carrera = sc.nextLine();

                    // Instanciación (new) + constructor
                    Alumno a = new Alumno(matricula, nombre, edad, carrera);

                    boolean ok = gestor.agregar(a);
                    System.out.println(ok ? "Alumno registrado." : "Ya existe esa matricula.");
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
                    Alumno alumno = gestor.buscarPorMatricula(m);
                    
                    if (m.isEmpty()) {
                        System.out.println("Matricula invalida: no puede estar vacia.");
                        break;
                    }
                    if (alumno == null) {
                        System.out.println("Matricula invalida: no existe ese alumno.");
                        break; // sale del case sin pedir más datos
                    }

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Nueva edad: ");
                    int nuevaEdad = leerEntero(sc);

                    System.out.print("Nueva carrera: ");
                    String nuevaCarrera = sc.nextLine();

                    boolean ok = gestor.actualizar(m, nuevoNombre, nuevaEdad, nuevaCarrera);
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