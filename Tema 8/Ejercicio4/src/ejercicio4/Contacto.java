package ejercicio4;

/**
 *
 * @author Alberto
 */
public class Contacto implements java.io.Serializable {
    public String nombre;
    public String email;
    public int telefono;
    
    public Contacto(String nombre, int telefono, String email){
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
}
