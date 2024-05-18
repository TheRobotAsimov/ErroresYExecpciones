package ep1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*

    INTEGRANTES:
    - Mario Burgos Gorostieta
    - Isa�as Garc�a Mendoza

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
                // Mostrar el men�
                System.out.println("Men�:");
                System.out.println("1. Validaci�n de printf");
                System.out.println("2. Estructura de Control de archivo");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opci�n: ");

                // Leer la opci�n del usuario
                option = scanner.nextInt();

                // Ejecutar la opci�n seleccionada
                switch (option) {
                    case 1:
                        System.out.println("Ha seleccionado la opci�n de Validaci�n de printf.");
                        validarPrintf();
                        break;
                    case 2:
                        System.out.println("Ha seleccionado la opci�n de Estructura de Control de archivo.");
                        estructuraControl();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opci�n no v�lida, por favor seleccione una opci�n v�lida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un n�mero entero.");
                scanner.next(); // Limpiar el buffer del scanner
            }

            System.out.println(); // L�nea en blanco para mejor presentaci�n

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