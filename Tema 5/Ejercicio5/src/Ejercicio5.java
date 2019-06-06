/**
 *
 * @author apazgarcia
 */
import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args){
        char continuar;
        
            Scanner sc = new Scanner(System.in);
            if(args.length == 0){ // Si no se le pasa ningun parametro por linea de comados.
                do{
                    System.out.println("Introduzca un año para comprobar sus ventas");
                    int ano = Integer.parseInt(sc.nextLine());
                    Ventas v = new Ventas(ano);

                    v.grafica();
                    System.out.printf("Media de ventas: %.1f\n", v.media());

                    System.out.println("¿Continuar? (y/n)");
                    continuar = sc.nextLine().charAt(0);
                }while(continuar == 'y');
            }
            else { // Si se le pasa el parametro por linea de comandos.
                Ventas v = new Ventas(Integer.parseInt(args[0]));
                v.grafica();
                System.out.printf("Media de ventas: %.1f\n", v.media());
            }
            
        
        
    }
}
