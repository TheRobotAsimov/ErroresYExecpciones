package ep1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Repositorio {
    
    String nombreArchivo;
    String textoArchivo;

    public Repositorio(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        textoArchivo = "";
    }
    
    public void cargarDatos() throws IOException{
        File archivo = new File(nombreArchivo);
        Scanner sc = new Scanner(archivo);
        while(sc.hasNextLine()){
            textoArchivo += sc.nextLine();
        }
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getTextoArchivo() throws IOException {
        cargarDatos();
        return textoArchivo;
    }
    
}