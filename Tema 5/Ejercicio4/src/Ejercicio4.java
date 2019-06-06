/**
 * 
 * @author Alberto Paz
 */

public class Ejercicio4 {
    public static void main(String[] args){
        Texto t = new Texto();
        String string = "hola me llamo alberto";
        
       t.muestraEnLinea(string);
       System.out.println("");
       t.muestraCentrado(t.subCadena(string, 22, 7));
       System.out.println("");
       t.muestraCentrado(t.alReves(string));
       System.out.println("");
       System.out.printf("%s\n", t.pasoAMayusculas(string, "HOLA NIÑO!!!!! 12345 abzyzhehe _ hehehe_"));
    }
}
