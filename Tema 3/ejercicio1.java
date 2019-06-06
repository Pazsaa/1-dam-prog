import java.util.Scanner;
public class ejercicio1{
    /**
     * Espacios en blanco
     * 
     * @param n Cantidad de espacios a imprimir.
     */
    public static void lineas(int n){
        for(int i = 0; i < n; i++){
            System.out.print("\n");
        }
        return;
    }

    /**
     * Es positivo?
     * 
     * @param n Numero negativo/positivo
     * @return 'N' si es negativo o 0, 'P' si no lo es.
     */
    public static char numero(int n){

        char positivo =  n <= 0 ? 'N' : 'P';
        return positivo;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Introduce el numero de lineas en blanco: ");
        n = Integer.parseInt(sc.nextLine());
        lineas(n);

        System.out.println("Introduce un numero entero.");
        n = Integer.parseInt(sc.nextLine());
        System.out.println(numero(n));
    }
}