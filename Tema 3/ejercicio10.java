import java.util.Scanner;
import java.util.Random;
public class ejercicio10{
    /**
     * @return 1, X o 2 dependiendo del numero aleatorio generado.
     */
    public static String quiniela(){
        int max = 100; int min = 1;
        Random r = new Random();
        int n = r.nextInt((max - min) + 1) + min; // Rango de min a max (incluidos)

        if(n <= 60) return "1";
        else if(n > 60 && n <= 85) return "X";
        else return "2";
    }

    public static void main(String[] args){
        int col = 14;
        System.out.printf("Partido %10s \n", "Resultado");
        for(int i = 0; i < col; i++){
            System.out.printf("%4d: %8s\n", i, quiniela());
        }
    }
}