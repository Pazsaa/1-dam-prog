
import java.util.Random;

class Basicos2{
    public static char[][] randomArray(int N, int M){
        Random r = new Random();
        int max = 90; int min = 65;

        char[][] random = new char[N][M];
        for(int i = 0; i < random.length; i++){
            for(int j = 0; j < random[i].length; j++){
                random[i][j] = (char)(r.nextInt((max - min) + 1) + min);
            }
        }
        return random;
    }

    public static void mostrar(char[][] array){
        for(char[] letra: array){
            for(char l: letra){
                System.out.printf("%s, ", l);
            }
        }

        /*for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.printf("%s, ", array[i][j]);
            }
        }*/
    }

    public static char maximo(char[][] array){
        char max = array[0][0];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] > max)
                    max = array[i][j];
            }
        }
        return max;
    }

    public static char minimo(char[][] array){
        char min = array[0][0];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] < min)
                    min = array[i][j];
            }
        }
        return min;
    }

    public static boolean swap(char[][] array, int i, int j, int x, int z){
        if(i < 0 || j < 0 || x < 0 || z < 0) return false;
        if(i > array.length || j > array[i].length || x > array.length || z > array[x].length) return false;

        char temp = array[i][j];
        array[i][j] = array[x][z];
        array[x][z] = temp;

        return true;
    }
    public static void main(String[] args){
        char[][] random = randomArray(3, 4);
        mostrar(random);

        System.out.printf("\nMaximo: %s", maximo(random));
        System.out.printf("\nMinimo: %s", minimo(random));

        swap(random, 0,0 , 2,3);
        System.out.println();
        mostrar(random);
    }
}