import java.util.Random;

class Basicos{
    /**
     * Devuelve un vector con N numeros aleatorios.
     * @param N Cantidad de numeros aleatorios.
     * @return  Vector
     */
    public static int[] randoms(int N){
        int[] numeros = new int[N];
        for(int i = 0; i < numeros.length; i++){
            Random r = new Random();
            int max = 5000; int min = 1000;
            numeros[i] = r.nextInt((max - min) + 1) + min;
        }
        return numeros;
    }

    /**
     * Muestra en pantalla los miembros de un array.
     * @param array
     */
    public static void mostrar(int[] array){
        for(int num: array){
            System.out.printf("%d, ", num);
        }
        System.out.println();
    }

    /**
     * Devuelve el numero más alto en un array.
     * @param array Array de numeros donde se quiere encontrar el maximo.
     * @return Valor maximo encontrado.
     */
    public static int maximo(int[] array){
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            if( array[i] > max) 
                max = array[i];
        }
        return max;
    }
    /**
     * Devuelve el número más bajo en un array.
     * @param array Array de numeros donde se quiere encontrar el minimo.
     * @return  Valor mínimo encontrado.
     */
    public static int minimo(int[] array){
        int min = array[0];
        for(int num: array){
            if(num < min)
                min = num;
        }
        return min;
    }

    /**
     * Intercambia los valores de dos posiciones de un array.
     * @param array Array en el que se quieren intercambiar valores.
     * @param i Primera posicion que se quiere intercambiar.
     * @param j Segunda posicion que se quiere intercambiar.
     * @return  True si no hay problemas de rango. False si los hay.
     */
    public static boolean swap(int[] array, int i, int j){
        if( i < 0 || j < 0) return false;
        if( i > array.length || j > array.length) return false;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return true;
    }

    public static void main(String[] args){
        int[] aleatorios = randoms(10);
        mostrar(aleatorios);
        System.out.printf("%d", maximo(aleatorios));
        System.out.println();
        System.out.printf("%d", minimo(aleatorios));
        System.out.println();
        swap(aleatorios, 0, 9);
        mostrar(aleatorios);
    }
}