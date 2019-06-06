import java.util.Scanner;
import java.util.Random;

public class ejercicio11{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * Pide un numero, y comprueba si está dentro del rango deseado.
     * @return numero dentro del rango.
     */
    public static int nRango(){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do{
            n = Integer.parseInt(sc.nextLine());
            if(n < 1 || n > 20)
                System.out.println("Numero fuera de rango [1-20], introduce otro:");
        }
        while(n < 1 || n > 20);

        return n;
    }
    /**
     * 
     * @param n1 el numero que se quiere comparar con los demás
     * @param n2 segundo numero, si es 0 no se tiene en cuenta
     * @param n3 tercer numero, si es 0 no se tiene en cuenta
     * @return el numero comparado, actualizado si era igual a alguno de los demas.
     */
    public static int nVal(int n1, int n2, int n3){
        if(n2 == 0){
            return n1;
        }
        else if(n3 == 0){
            while(n2 == n1){
                System.out.println("No se te permite jugar con numeros iguales, escoge otro:");
                n1 = nRango();
            }
            return n1;
        }
        else{
            while(n2 == n1 || n3 == n1){
                System.out.println("No se te permite jugar con numeros iguales, escoge otro:");
                n1 = nRango();
            }
            return n1;
        }
    }

    /**
     * Genera dos numeros aleatorios, los compara con los 3 introducidos por el usuario
     * y devuelve una tabla de 20 numeros. Mostrando en verde las coincidencias usuario-maquina, en rojo
     * los escogidos por la máquina (sin acertar) y en azul los escogidos por el usuario (sin acertar)
     */
    public static void lotto(int x, int y, int z){
        int min = 1; int max = 20;
        Random r = new Random();

        int n1 = r.nextInt((max - min) + 1) + min;
        int n2 = r.nextInt((max - min) + 1) + min;

        int aciertos = 0;
        if(x == n1 || x == n2) aciertos++;
        if(y == n1 || y == n2) aciertos++;
        if(z == n2 || z == n2) aciertos++;

        System.out.println("---------------------------");
        for(int i = 1; i <= 20; i ++){
            
                if(i == x && (x == n1 || x == n2)) System.out.printf("%s%5d%s", ANSI_GREEN, i, ANSI_RESET);
                else if(i == y && (y == n1 || y == n2)) System.out.printf("%s%5d%s", ANSI_GREEN,  i, ANSI_RESET);
                else if(i == z && (z == n1 || z == n2)) System.out.printf("%s%5d%s", ANSI_GREEN,  i, ANSI_RESET);

                else if(i == x && (x != n1 && x != n2)) System.out.printf("%s%5d%s", ANSI_BLUE,  i, ANSI_RESET);
                else if(i == y && (y != n1 && y != n2)) System.out.printf("%s%5d%s", ANSI_BLUE,  i, ANSI_RESET);
                else if(i == z && (z != n1 && z != n2)) System.out.printf("%s%5d%s", ANSI_BLUE,  i, ANSI_RESET);

                else if(i == n1 || i == n2) System.out.printf("%s%5d%s", ANSI_RED , i , ANSI_RESET);

                else System.out.printf("%s%5d%s", "", i, "");
            
            if(i % 5 == 0) System.out.println("");
        }
        System.out.println("---------------------------");

        System.out.printf("\n\nLos numeros ganadores de la loteria han sido: %d %d", n1, n2);
        System.out.printf("\nHas tenido un total de %d aciertos!", aciertos);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x, y, z;

        System.out.println("Loteria primitiva [1-20]: ");
        System.out.print("Introduce tu primer numero: ");
        x = nRango();
        System.out.print("\nIntroduce tu segundo numero: ");
        y = nRango();
        y = nVal(y, x, 0);
        System.out.print("\nIntroduce tu tercer numero: ");
        z = Integer.parseInt(sc.nextLine());
        z = nVal(z, x, y);

        lotto(x, y, z);
    }
}