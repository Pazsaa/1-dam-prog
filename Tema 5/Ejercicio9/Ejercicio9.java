import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Ejercicio9{

    /**
     * Muestra los numeros de un arraylist.
     */
    public static void mostrarNumeros(ArrayList<Integer> numeros){
        int index = 0;
        for(Integer num: numeros){
            System.out.printf("%d", num);
            if(index < 5) System.out.printf(",");
            index ++;
        }
    }

    /**
     * Crea un ArrayList con 6 miembros (Enteros) aleatorios, entre 1 y 49
     * @return ArrayList resultante.
     */
    public static ArrayList<Integer> cpu(){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        Random r = new Random();

        for(int i = 0; i < 6; i++){
            numeros.add(r.nextInt(49) + 1);
        }
        return numeros;
    }

    /**
     * Transforma un string numérico separado por comas en un arraylist conformado por los mismos números.
     * @param numeros_str Cadena que contiene los numeros.
     * @return ArrayList de numeros enteros.
     */
    public static ArrayList<Integer> jugador(String numeros_str){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        String[] parts = numeros_str.split(",");

        for(int i = 0; i < parts.length; i++){
            numeros.add(Integer.parseInt(parts[i]));
        }

        return numeros;
    }

    /**
     * Muestra los numeros de jugador y cpu. Despues comprueba si los numeros del jugador coinciden con los del cpu, y si lo hacen los muestra por pantalla.
     */
    public static void check(ArrayList<Integer> numeros_jugador, ArrayList<Integer> numeros_cpu){
        System.out.printf("\n\nNumeros que escogió el ordenador: ");
        mostrarNumeros(numeros_cpu);
        System.out.printf("\nNumeros que escogió el jugador: ");
        mostrarNumeros(numeros_jugador);
        
        System.out.printf("\n\nAciertos: ");
        for(Integer jug: numeros_jugador){
            for(Integer cpu: numeros_cpu){
                if(cpu == jug)
                    System.out.printf(" %d ", jug);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char retry;

        do{
            System.out.println("PRIMITIVA");
            System.out.println("=========");

            System.out.println("Introduce tus 6 digitos, separados por coma (1,2,3,...) ");
            String numeros_str = sc.nextLine();
            ArrayList<Integer> jugador = jugador(numeros_str);
            ArrayList<Integer> cpu = cpu();

            check(jugador, cpu);
            System.out.println("\n¿Volver a jugar? s/n");
            retry = sc.nextLine().charAt(0);
        }while(retry != 'n');
    }
}