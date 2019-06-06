import java.util.Scanner;
public class ejercicio12{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int N, suma = 0, sumaimp = 0;

        // Nota para Curro: Revisar entero;    
		System.out.println("Introduce la longitud de la serie de numeros: ");
		N = Integer.parseInt(sc.nextLine());

		for( int i = 0; i < N; i += 2){
            if(i % 2 == 0){			
                suma += i;
            }
		}
		System.out.printf("Suma de pares: %d\n", suma);
		suma = 0;
		
		for( int i = 0; i < N; i++){
			if(i % 2 != 0){
                sumaimp += i;
            }
		}
		System.out.printf("Suma de impares: %d\n", sumaimp);
		sumaimp = 0;
        suma = 0;
		
		for(int i = 0; i < N; i++){
            if(i % 2 == 0){
       			suma += i;
            }else{
                sumaimp += i;
            }		
        }
		System.out.printf("Suma par: %d // Suma de impares: %d en el mismo bucle. \n", suma, sumaimp);
	}
}
