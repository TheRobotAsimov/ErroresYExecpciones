package estructuracontrol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*

    INTEGRANTES:
    - Mario Burgos Gorostieta
    - Isaías García Mendoza

    PRACTICA:
    EP1. Manejo de errores y excepciones

    FECHA:
    17/05/2024

*/

public class EstructuraControl {

    public static void main(String[] args) {
        String nombreArchivo = "./EstructuraDeControl.txt";
        Repositorio repo = new Repositorio(nombreArchivo);
        Logica log = new Logica();
        String textoArchivo;
        
        char letra;
        
        try {
            textoArchivo = repo.getTextoArchivo();
            letra = textoArchivo.charAt(0);
            switch (letra) {
                case 'w':
                    log.validarWhile(textoArchivo);
                    break;
                case 'd':
                    log.validarDoWhile(textoArchivo);
                    break;
                default:
                    System.out.println("Estructura no valida");
            }
            System.out.println(textoArchivo);
        } catch (IOException ex) {
            System.out.println("Problemas con archivo: "+ ex.getLocalizedMessage());
        }
    }
    
}
