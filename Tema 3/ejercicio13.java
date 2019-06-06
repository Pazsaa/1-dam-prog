import java.util.Scanner;
import java.util.Random;
import java.lang.InterruptedException;

public class ejercicio13{
    /**
     *  Establece las coordenadas iniciales del barco de la máquina.
     *  Adicionalmente, se usa para intentar encontrar el barco del jugador.
     *  @return las coordenadas generadas aleatoriamente, como un numero de 3 cifras. (Los primeros dos digitos son la fila, el tercero la columna.)
     */
    public static int CPU_setUP(boolean flag){
        Random r = new Random();
        int min = 65; int max = 75;
        int barcoCPU_1 = r.nextInt((max - min) + 1) + min;
        min = 1; max = 10;
        int barcoCPU_2 = r.nextInt((max - min) + 1) + min;

        String coordenada = barcoCPU_1 + "" + barcoCPU_2;
        return Integer.parseInt(coordenada);
    }

    /**
     *  Pide al jugador las coordenades iniciales para su barco.
     *  Adicionalmente, se usa para pedir las coordenadas de ataque al barco enemigo.
     *  @return las coordenadas generadas aleatoriamente, como un numero de 3 cifras. (Los primeros dos digitos son la fila, el tercero la columna.)
     */
    public static int setUP(){
        Scanner sc = new Scanner(System.in);
        
        String res; int fila; int columna;

        do{
            System.out.println("Jugador, introduce primera coordenada [A-J]");
            res = sc.nextLine().toUpperCase();
            fila = res.charAt(0);
        } while(fila < 65 || fila > 75);

        do{
            System.out.println("Jugador, introduce segunda coordenada [1-10]");
            columna = Integer.parseInt(sc.nextLine());
        } while(columna < 1 || columna > 10);

        String coordenada = fila + "" + columna;
        return Integer.parseInt(coordenada);
    }

    /**
     * Comprueba si las coordenadas introducidas concuerdan
     * con las coordenadas del barco enemigo.
     * @param c coordenadas del barco enemigo.
     * @param gc coordenadas proporcionadas por quien intenta atacar.
     */
    public static boolean check(int c, int gc){
        if(gc == c) {
            return true;
        }  
        else{
            return false;
        } 
    }
   

    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        String res; boolean gameOver = false;
        Random r = new Random();
        int min = 0; int max = 0;
        

        System.out.println("PREPARACION");
   
        int cpu = CPU_setUP(false);
        int player = setUP();

        do{
             System.out.print("\u001b[2J\u001b[H");
             System.out.println("ATAQUE");
             int ataque_j = setUP();
             if(check(cpu, ataque_j)){
                 gameOver = true;
                 System.out.println("Victoria del jugador!");
             }
             else{
                 System.out.println("AGUA!");
                 System.out.println("\nTurno de la máquina...");
                 Thread.sleep(3000);
                 int ataque_m = CPU_setUP(false);

                 if(check(player, ataque_m)){
                     gameOver = true;
                     System.out.println("Victoria de la máquina!");
                 }else{
                     System.out.println("AGUA!");
                     Thread.sleep(2000);
                } 
               }
            }while(gameOver == false);
        }      
}