package ep1;

import java.util.ArrayList;
import java.util.List;

public final class Validaciones {

    public Validaciones() {
    }

    public void validacion(String texto) throws Exception {
        validacionPrintf(texto);
        validacionParentesis1(texto);
        validacionComillas1(texto);
        validacionComillas2(texto);
        validacionFin(texto);
        validarVariables(texto);
    }

    public void validacionPrintf(String texto) throws Exception {
        if (texto.startsWith("printf")) {
            return;
        }
        throw new Exception("Sentencia printf erronea");
    }

    public void validacionParentesis1(String texto) throws Exception {
        if (texto.length() <= 6) {
            throw new Exception("Error de caracter ( al inicio de la sentencia");
        }
        if (texto.charAt(6) == '(') {
            return;
        }
        throw new Exception("Error de caracter ( al inicio de la sentencia");
    }

    public void validacionComillas1(String texto) throws Exception {
        if (texto.length() <= 7) {
            throw new Exception("Error de caracter \" al inicio de la sentencia");
        }
        if (texto.charAt(7) == '"') {
            return;
        }
        throw new Exception("Error de caracter \" al inicio de la sentencia");
    }

    public void validacionFin(String texto) throws Exception {
        if (texto.endsWith(");")) {
            return;
        }
        throw new Exception("Error de ; al finalizar la sentencia");
    }

    public int contarFormatos(String texto) throws Exception {
        int i = 8; // Empieza después de 'printf("'
        String aux = texto.substring(i);
        int contador = 0;
        int pos;

        do {
            pos = aux.indexOf('%');
            if (pos != -1) {
                if (pos + 1 < aux.length() && aux.substring(pos, pos + 2).matches("%[cdiouxefgansp]")) {
                    contador++;
                    aux = aux.substring(pos + 2); // Avanza después del formato válido
                } else {
                    throw new Exception("El indicador de formato '%' no esta acompañado de un formato valido");
                }
            }
        } while (pos != -1);

        return contador; // Devuelve el número de formatos encontrados
    }

    public void validarVariables(String texto) throws Exception {
        int numFormatos = contarFormatos(texto);

        // Encuentra la posición de la última comilla dentro del texto
        int comillas = texto.lastIndexOf('"');

        // Obtiene la parte después de la última comilla
        String aux = texto.substring(comillas + 1).trim();
        if (numFormatos > 0) {
            // Si hay al menos un formato, verifica la presencia de coma y variables
            if (!aux.contains(",")) {
                throw new Exception("Falta coma despues de las ultimas comillas");
            }

            // Separa las variables por comas y cuenta
            String[] variables = aux.split(",");
            for(String s:variables){
                System.out.println(s);
            }
            System.out.println(variables.length);
            if (variables.length-1 != numFormatos) {
                throw new Exception("Numero de variables no coincide con el numero de formatos");
            }
        }
    }
    
    public void validacionComillas2 (String texto) throws Exception{
        texto = texto.replaceAll("\\s", "");
        List<Integer> indices = busqueda(texto, '"');
        
        if(indices.size()%2 != 0){
            throw new Exception("No se estan cerrando correctamente las comillas");
        }
        if(texto.charAt(texto.lastIndexOf('"')+1) != ',' && texto.charAt(texto.lastIndexOf('"')+1) != ')'){
            throw new Exception("Ultima comilla incorrecta.");
        }
        
        Integer previo=0;
        
        for(Integer i:indices){
            if(i != indices.getFirst() && i != indices.getLast()){
                if(i != indices.get(1)){
                    if(i != previo+1){
                        throw new Exception("Comilla no se cierra correctamente");
                    }
                }
                    previo = i;
            }
        }
        
        if(texto.charAt(texto.lastIndexOf('"')+1) == ',' && contarFormatos(texto)<1){
            throw new Exception("Faltan formatos de argumentos");
        }
    }

    public List<Integer> busqueda(String texto, char simbolo){
        List<Integer> lista = new ArrayList<>();

        for(Integer i = 0; i < texto.length(); i++){
            if(texto.charAt(i) == simbolo){
                lista.add(i);
            }
        }

        return lista;
    }
    
    public void validarEstructuraControl(String nombreEstructura, String estructura, String textoArchivo) throws Exception{
        if(textoArchivo.equals(estructura)){
            System.out.println("Estructura " + nombreEstructura + " validada");
        } else {
            if(!textoArchivo.contains("(") || !textoArchivo.contains(")")){
                throw new Exception("Estructura " + nombreEstructura + " NO valida. Le falta parentesis");
            }
            if(!textoArchivo.contains("{") || !textoArchivo.contains("}")){
                throw new Exception("Estructura " + nombreEstructura + " NO valida. Le falta llaves");
            }
            if(textoArchivo.length() != estructura.length()){
                throw new Exception("Estructura " + nombreEstructura + " NO valida. Tiene caracteres adicionales");
            }
            throw new Exception("Estructura " + nombreEstructura + " NO valida");
        }
    }
}