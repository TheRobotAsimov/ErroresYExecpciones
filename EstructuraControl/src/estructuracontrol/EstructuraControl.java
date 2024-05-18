package estructuracontrol;

import java.io.IOException;

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
        Logica log = new Logica();
        String textoArchivo;
        
        textoArchivo = repo.getTextoArchivo();
            if(textoArchivo.contains("do")){
                textoArchivo = textoArchivo.replaceAll("\\s", "");
                log.validar("Do-While", "do{}while();", textoArchivo);
            } else if(textoArchivo.contains("while")){
                textoArchivo = textoArchivo.replaceAll("\\s", "");
                log.validar("While", "while(){}", textoArchivo);
            } else {
                throw new Exception("Estructura no reconocida");
            }
            
            System.out.println(textoArchivo);
    }
}
