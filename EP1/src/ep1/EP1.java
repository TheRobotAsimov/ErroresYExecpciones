package ep1;

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
        Scanner sc = new Scanner(System.in);
        String texto;
        Validaciones comi = new Validaciones();
        
        //System.out.print("printf(");
        texto = sc.nextLine();
        if(texto.charAt(0) == 'ñ')
        {
            System.out.println("eeeeñeeeee");
        }
        System.out.println(texto);
        /*try {
            comi.validacion(texto);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }
    
}