public class ejercicio11{
	public static void main(String args[]){
		// Numeros del 1 al 50		
		for(int i = 1; i <= 50; i++){
			System.out.printf("%d, ", i);
		}
		System.out.printf("\n");
		// Numeros del 50 al 1
		for(int i = 50; i >= 1; i--){
			System.out.printf("%d, ", i);
		}
		System.out.printf("\n");
		// Pares del 0 al 20
		for(int i = 0; i <= 20; i += 2){
			System.out.printf("%d, ", i);
		}
		System.out.printf("\n");
		// Impares del 90 al 130
		for(int i = 91; i < 130; i += 2){
			System.out.printf("%d, ", i);
		}
		System.out.printf("\n");
		// Multiplos de 5 entre 70 y 25
		for(int i = 70; i >= 25; i -= 5){
			System.out.printf("%d, ", i);
		}

	}
}
