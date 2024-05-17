package estructuracontrol;

public class Logica {

    public Logica() {
    }
    
    //validar(textoArchivo, nombreestructura, estructura)
    public void validar(String nombreEstructura, String estructura, String textoArchivo) throws Exception{
        if(textoArchivo.equals(estructura)){
            System.out.println("Estructura " + nombreEstructura + " validada");
        } else {
            throw new Exception("Estructura " + nombreEstructura + " NO valida. Le falta parentesis o llaves o contiene texto demas");
        }
    }
}
