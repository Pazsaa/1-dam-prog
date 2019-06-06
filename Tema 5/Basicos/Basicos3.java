import java.util.ArrayList;
import java.util.Random;

class Basicos3{
    public static ArrayList<Integer> random(int N){
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            Random r = new Random();
            int max = 5000; int min = 1000;
            randoms.add(r.nextInt((max - min) + 1 ) + min);
        }

        return randoms;
    }

    public static void mostrar(ArrayList<Integer> nums){
        for(Integer num: nums){
            System.out.printf("%d, ", num);
        }
        System.out.println();
    }

    public static int maximo(ArrayList<Integer> nums){
        int maximo = nums.get(0);
        for(Integer num: nums){
            if(num > maximo) maximo = num;
        }
        return maximo;
    }

    public static int minimo(ArrayList<Integer> nums){
        int minimo = nums.get(0);
        for(Integer num: nums){
            if(num < minimo) minimo = num;
        }
        return minimo;
    }

    public static boolean swap(ArrayList<Integer> nums, int i, int j){
        if(i < 0 || j < 0) return false;
        if(i > nums.size() || j > nums.size()) return false;

        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
        return true;
    }
    
    public static void main(String[] args){
        ArrayList<Integer> lista = random(10);
        mostrar(lista);

        System.out.printf("Maximo: %d", maximo(lista));
        System.out.println();
        System.out.printf("Minimo: %d", minimo(lista));
        System.out.println();
        
        if(swap(lista, 0, 9)) 
            mostrar(lista);

        
    }
}