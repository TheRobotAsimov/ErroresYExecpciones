package ep1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*

    INTEGRANTES:
    - Mario Burgos Gorostieta
    - Isaías García Mendoza

    PRACTICA:
    EP1. Manejo de errores y excepciones

    FECHA:
    17/05/2024

*/

public class EP1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int option = -1; // Inicializar con un valor que no sea 0

        do {
            try {
                // Mostrar el menú
                System.out.println("Menú:");
                System.out.println("1. Validación de printf");
                System.out.println("2. Estructura de Control de archivo");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                // Leer la opción del usuario
                option = scanner.nextInt();

                // Ejecutar la opción seleccionada
                switch (option) {
                    case 1:
                        System.out.println("Ha seleccionado la opción de Validación de printf.");
                        validarPrintf();
                        break;
                    case 2:
                        System.out.println("Ha seleccionado la opción de Estructura de Control de archivo.");
                        estructuraControl();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida, por favor seleccione una opción válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número entero.");
                scanner.next(); // Limpiar el buffer del scanner
            }

            System.out.println(); // Línea en blanco para mejor presentación

        } while (option != 0);
    }
    
    public static void validarPrintf(){
        Scanner scanner = new Scanner(System.in);
        String texto;
        Validaciones comi = new Validaciones();
        
        System.out.println("Escribe: ");
        texto = scanner.nextLine();
        
        try {
            comi.validacion(texto);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Problems");
        }
    }
    
    public static void estructuraControl(){
        try {
            analizarEstructura();
        } catch (IOException ex) {
            System.out.println("Problemas con archivo: "+ ex.getMessage());
        } catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    public static void analizarEstructura() throws IOException, Exception{
        String nombreArchivo = "./EstructuraDeControl.txt";
        Repositorio repo = new Repositorio(nombreArchivo);
        Validaciones log = new Validaciones();
        String textoArchivo;
        
        textoArchivo = repo.getTextoArchivo();
            if(textoArchivo.contains("do")){
                textoArchivo = textoArchivo.replaceAll("\\s", "");
                log.validarEstructuraControl("Do-While", "do{}while();", textoArchivo);
            } else if(textoArchivo.contains("while")){
                textoArchivo = textoArchivo.replaceAll("\\s", "");
                log.validarEstructuraControl("While", "while(){}", textoArchivo);
            } else {
                throw new Exception("Estructura no reconocida");
            }
    }
}