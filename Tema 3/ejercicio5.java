import java.util.Scanner;
public class ejercicio5{
     /**
     * Potencia
     * 
     * @param base numero a elevar
     * @param exponente de la base
     * @return numero elevado
     */
    public static double potencia(double base, double exponente){
        double resultado;
        if(exponente < 0){
            base = 1/base;
            exponente = exponente * -1;
            resultado = base;
            exponente -= 2;
            for(int i = 0; i < exponente; i++){
                resultado *= base;
            }
            return resultado;
        }else {
            resultado = base;
            exponente --;
            for(int i = 0; i < exponente; i++){
                resultado *= base;
            }
            return resultado;
        }
    }
    /**
     * Muestra y suma los numeros de una sucesión geométrica
     * @param x  el numero que se elevará durante la sucesión
     * @param n  cantidad de numeros a mostrar en la sucesión
     */
    public static void sGeometrica(int x, int n){
        double resultado = 0;
        for(int i = 0; i <= n; i++){
            if(resultado != 0){
                resultado += potencia(x, i);
                System.out.printf("%.1f ", resultado);
            }
            else{
                resultado++;
                System.out.printf("%.1f ", resultado);
            } 
        }
        System.out.printf("\nResultado: %.1f\n", resultado);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce un numero: ");
        int x = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce la logintud de la serie");
        int n = Integer.parseInt(sc.nextLine());

        sGeometrica(x, n);
    }
}