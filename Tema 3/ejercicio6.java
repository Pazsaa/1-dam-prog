import java.util.Scanner;
public class ejercicio6{
    /**
     * Determina si un numero dado es primo o no.
     * @param n numero
     * @return true/false
     */
    public static boolean esPrimo(int n){
        for(int i = n; i > 0; i --){
            if(i != n && i != 1){
                if(n % i == 0) return false;
            }
        }
        return true;
    }
    
    /**
     * Muestra la cantidad escogida de numeros primos.
     * @param n cantidad
     */
    public static void nPrimos(int n){
        for(int i = 0; i <= n; i++){
            if(esPrimo(i))  System.out.print(i + " ");
        }
    }

    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);

       System.out.println("Introduce cuantos numeros primos quieres visualizar: ");
       int n = Integer.parseInt(sc.nextLine());

       nPrimos(n);
    }
}