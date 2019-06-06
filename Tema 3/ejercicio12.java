import java.util.Random;
public class ejercicio12{
    /**
     *  Genera dos numeros aleatorios [1-6] y devuelve la suma de ambos.
     *  @return la suma de ambos numeros.
     */
    public static int tirada(){
        int min = 1; int max = 6;
        Random r = new Random();

        int dado1 = r.nextInt((max - min) + 1) + min;
        int dado2 = r.nextInt((max - min) + 1) + min;

        System.out.printf("\nDados: %d %d", dado1, dado2);
        return dado1 + dado2;
    }

    /**
     * Determina si el jugador/maquina gana o pierde.
     * Si no es ninguna de las dos, devuelve la puntuación.
     * @return 0 si el jugador actual gana / 1 si el jugador actual pierde / puntuacion si no es ninguna de las dos.
     */
    public static int comprobacion(int puntuacion){
        if(puntuacion == 7 || puntuacion == 11) return 0;
        else if(puntuacion == 2 || puntuacion == 3 || puntuacion == 12) return -1;
        else return puntuacion;
    }

    public static void main(String[] args){
        boolean gameOver = false;

        System.out.println("Tirando dados para jugador...");
        int j1 = tirada();
        System.out.println("");

        if(comprobacion(j1) == 0){
            System.out.println("Victoria J1!");
            gameOver = true;
        }
        else if(comprobacion(j1) == -1){
            System.out.println("CRAPS!");
            gameOver = true;
        }

        if(!gameOver){
            System.out.println("Tirando dados para maquina...");
            int j2 = tirada();
            System.out.println("");

            if(comprobacion(j2) == 2){
                System.out.println("Gana la maquina!");
            }
            else if(comprobacion(j2) == -1){
                System.out.println("CRAPS! Gana J1!");
            }
            else{
                if(j1 > j2) System.out.printf("\nGana el jugador! (%d > %d)", j1, j2);
                else System.out.printf("\nGana la maquina! (%d < %d)", j1, j2);
            }
    
        }
    }
}
