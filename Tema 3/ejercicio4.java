import java.util.Scanner;
public class ejercicio4{
    /**
     * Potencia
     * 
     * @param base numero a elevar
     * @param exponente de la base
     * @return numero elevado
     */
    public static double potencia(double base, double exponente){
        double resultado=1;
        if(exponente < 0){
            base = 1/base;
            exponente = exponente * -1;
           
            
        } 
             
            for(int i = 0; i < exponente; i++){
                resultado *= base;
            }
            return resultado;
         
    }

    /**
     *  N primeras potencias
     * 
     * @param num del que se quieren ver potencias
     * @param cantidad de potencias que se quieren ver
     */
    public static void nPotencias(double num, double cantidad){
        for(int i = 1; i <= cantidad; i++){
            System.out.println(potencia(num, i));
        }
    }
    
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       double base, exp;

       System.out.println("Introduce el número que quieres elevar: ");
       base = Double.parseDouble(sc.nextLine());
       System.out.println("Introduce el exponente: ");
       exp = Double.parseDouble(sc.nextLine());

       System.out.printf("%f elevado a %f es igual a: %f", base, exp, potencia(base, exp));

       System.out.println("\nIntroduce un numero: ");
       base = Double.parseDouble(sc.nextLine());
       System.out.println("Introduce el numero de potencias que quieres ver: ");
       exp = Double.parseDouble(sc.nextLine());

       nPotencias(base, exp);
    }
}