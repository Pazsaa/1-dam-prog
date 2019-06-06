import java.util.Scanner;
import java.util.Random;
import java.lang.InterruptedException;
public class ejercicio7 {
    /**
     *  Determina qué numero es mayor, o si son iguales.
     * @param n1
     * @param n2
     * @return 0(n1), 1(iguales), 2(n2)
     */
    public static int mayorMenor(int n1, int n2){
        if(n1 > n2) return 0;
        if(n1 == n2) return 1;
        return 2;
    }
    /**
     * Controla el input numérico del/los usuarios
     * @return input
     */
    public static int userInput(){
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("Introduce un numero del 1 al 100!");
        do{
            input = Integer.parseInt(sc.nextLine());
            if(input < 1 || input > 100) System.out.println("Error, minimo 1 maximo 100!");
        }while(input < 1 || input > 100);

        return input;
    }
    /**
     * Determina el numero de la máquina cuando se juega en un solo jugador.
     * @return numero
     */
    public static int CPU_setUP(){
        Random r = new Random();
        int min = 1; int max = 100;

        int numero = r.nextInt((max - min) + 1 ) + min;
        System.out.printf("%d", numero);
        return numero;
    }

    public static void main(String[] args) throws InterruptedException{
        int intentos = 0; boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        int res;

        System.out.println("\u001b[2J\u001b[H");
        System.out.println("--ADIVINA 100--\n");
        System.out.println("1. SINGLE PLAYER");
        System.out.println("2. MULTI PLAYER");

        do{
            System.out.println("Introduce una opción: ");
            res = Integer.parseInt(sc.nextLine());
        }while(res < 1 || res > 2);
    
        if(res == 1 ){
            System.out.println("La máquina está eligiendo un numero...");
            int numero1 = CPU_setUP();
            Thread.sleep(1500);

            do{
                int numero2 = userInput();
                switch(mayorMenor(numero1, numero2)){
                    case 0:
                        System.out.printf("El numero que intentas adivinar es mayor que %d!\n", numero2);
                        intentos++;
                        break;
                    case 1:
                        intentos++;
                        System.out.printf("Victoria! En %d intentos!", intentos);
                        gameOver = true;
                        break;
                    case 2:
                        System.out.printf("El numero que intentas adivinar es menor que %d!\n", numero2);
                        intentos++;
                        break;
                    default:
                        System.out.println("Error, resultado inesperado!");
                }

                if(intentos >= 5){
                    System.out.println("Te has quedado sin intentos! Game Over");
                    gameOver = true;
                }
            } while(gameOver == false);
        }
        else{
            System.out.println("-Jugador 1-");
            int numero1 = userInput();
            Thread.sleep(1500); 
            System.out.print("\u001b[2J\u001b[H");      

            System.out.println("-Jugador 2-");
            do{
                int numero2 = userInput();
                switch(mayorMenor(numero1, numero2)){
                    case 0:
                        System.out.printf("El numero que intentas adivinar es mayor que %d!\n", numero2);
                        intentos++;
                        break;
                    case 1:
                        intentos++;
                        System.out.printf("Victoria! En %d intentos!", intentos);
                        gameOver = true;
                        break;
                    case 2:
                        System.out.printf("El numero que intentas adivinar es menor que %d!\n", numero2);
                        intentos++;
                        break;
                    default:
                        System.out.println("Error, resultado inesperado!");
                }

                if(intentos >= 5){
                    System.out.println("Te has quedado sin intentos! Game Over");
                    gameOver = true;
                }
            } while(gameOver == false);
        }
    }
}