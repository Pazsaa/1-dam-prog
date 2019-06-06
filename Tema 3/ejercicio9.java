import java.util.Scanner;
public class ejercicio9{
    /**
     * Calcula el factorial de un número dado.
     * @param n entero
     * @return resultado.
     */
                                                        /*public static double factorial(int n){
                                                            double resultado = 1;
                                                            for(int i = n; i > 0; i--){
                                                                resultado *= i;
                                                            }
                                                            return resultado;
                                                        }*/
    public static double factorial(int n){ 
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    /**
     *  Calcula y devuelve un binomio de Newton
     * @param n entero
     * @param m entero
     * @return resultado decimal
     */
    public static double newtonBin(int n, int m){
        return factorial(m) / (factorial(n) * factorial(m - n));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m, n;
        
        do{
            System.out.println("Introduce variable n: ");
            n = Integer.parseInt(sc.nextLine());
            System.out.println("Introduce variable m: ");
            m = Integer.parseInt(sc.nextLine());

            if((m < 1 || n < 1) || m < n){
                System.out.println("Error, valores de n/m invalidos. (N y M > 0) (M >= N)");
            }

        }while((m < 1 || n < 1) || (m < n));

        System.out.printf("\nEl resultado del binomio de Newton para m(%d) y n(%d) es: %.2f\n", m, n, newtonBin(n, m));
    }
}