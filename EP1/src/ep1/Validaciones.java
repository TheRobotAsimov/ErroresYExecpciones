package ep1;

public final class Validaciones {

    public Validaciones() {
    }

    public void validacion(String texto) throws Exception {
        validacionPrintf(texto);
        validacionParentesis1(texto);
        validacionComillas1(texto);
        //validacionComillas2(texto);
        validacionFin(texto);
        int numFormatos = contarFormatos(texto);
        System.out.println(numFormatos);
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

public void validacionComillas2(String texto) throws Exception {
    int i = texto.length() - 1; // Empieza desde la última posición de la cadena
    while (i >= 0) {
        char currentChar = texto.charAt(i);
        if (currentChar == '"') {
            // Verifica si la comilla no está seguida inmediatamente por un paréntesis de cierre
            if (i + 1 < texto.length() && texto.charAt(i + 1) != ')') {
                return; // La comilla es la última y no está seguida por un paréntesis de cierre
            }
        }
        i--; // Avanza hacia la izquierda en la cadena
    }
    // Si llegamos aquí, significa que no se encontró ninguna comilla que cumpla con la condición
    throw new Exception("Error de caracter \" al final de la sentencia");
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

}