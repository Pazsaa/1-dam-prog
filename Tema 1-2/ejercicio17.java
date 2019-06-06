import java.util.Scanner;
public class ejercicio17{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int numero, cont;
		long resultado = 1;
	
		System.out.println("Introduce un numero para calcular su factorial: ");
		numero = Integer.parseInt(sc.nextLine());

		// Factorial con bucle for
		for(int i = numero; i > 1; i--){
			resultado *= i;
		}
		System.out.printf("El factorial mediante bucle for es igual a: %d\n", resultado);

		// Factorial con bucle while
		if(resultado > 1) resultado = 1;
		cont = numero;
		while(cont > 1){
			resultado *= cont;
			--cont;
		}
		System.out.printf("El factorial mediante bucle while es igual a: %d\n", resultado);

		// Factorial con bucle do while
		if(resultado > 1) resultado = 1;
		cont = numero;
		do{
            if(cont > 1){
			    resultado *= cont;
			    --cont;
            }
		}while(cont > 1);
		System.out.printf("El factorial mediante bucle do while es igual a: %d\n", resultado);
	}
}
