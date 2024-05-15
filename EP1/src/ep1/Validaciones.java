package ep1;

public final class Validaciones {

    public Validaciones(){
    }
    
    public void validacion(String texto) throws Exception{
        validacion1(texto);
        validacion2(texto);
    }
    
    public void validacion1(String texto) throws Exception {
        if(texto.endsWith(");"))
            return;
        throw new Exception("No termina bien");
    }
    
    public void validacion2(String texto) throws Exception {
        if(texto.contains("%"))
            throw new Exception("Tiene un %");
    }
}
