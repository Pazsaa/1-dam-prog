import java.util.Scanner;
public class ejercicio7{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int mayor = 0;
		int numeros [];
		numeros = new int[3];

		
		for(int i = 0; i < 3; i++){
			numeros [i] = Integer.parseInt(sc.nextLine());
		}

		if(numeros[0] < numeros[1]){
			if(numeros[1] < numeros[2]){
				mayor = numeros[2];
			}
			else{
				mayor = numeros[1];
			}
		}
		else if(numeros[0] > numeros[1]){
			if(numeros[0] > numeros[2]){
				mayor = numeros[0];
			}
			else{
				mayor = numeros[2];
			}	
		}
		else{
			mayor = numeros[0];
		}

		System.out.printf("El numero mayor es: %d\n", mayor);	
	}
}
	
