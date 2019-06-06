import java.util.Scanner;
public class ejercicio15{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String status = "", res;
		char letra;

		do{
			int intentos = 5;
			Integer numero = null, guess = null;	
			if(numero != null || guess != null){
				numero = null; guess = null;
			}		
			
			System.out.print("\u001b[2J\u001b[H"); 
			// Borra pantalla y va al inicio
			System.out.print("\u001b[1m"); 
			// Negrita (o cambio de color)
			System.out.println("-----------------");
			System.out.println( "<<<ADIVINA 100>>>");
			System.out.println("-----------------");
			System.out.print("\u001b[1m"); 
			// Negrita (o cambio de color)

			do {
				System.out.println("Jugador 1, introduce el número deseado: ");
				numero = Integer.parseInt(sc.nextLine());
				if(numero <= 0 || numero > 100){
					System.out.println("Introduce un numero entre 1-100:");
				}
			}while (numero <= 0 || numero > 100);
			System.out.print("\u001b[2J\u001b[H"); 
			// Borra pantalla y va al inicio
		
			do{
				if(intentos == 5){
					System.out.printf("Jugador 2, tienes %d intentos para adivinar el numero:\n", intentos);
				}
				else{
					System.out.printf("Jugador 2, el numero que has introducido (%d) es %s que el numero a adivinar, te quedan %d intentos: \n", 							guess, status, intentos);
				}
			
				do{
					guess = Integer.parseInt(sc.nextLine());
					if(guess <= 0 || guess > 100){
						System.out.println("Solo valen numeros entre 1 y 100. Intento no contado.");
					}
				}while(guess <= 0 || guess > 100);

				if(guess > numero){
					status = "mayor";
					--intentos;
				}
				else{
					status = "menor";
					--intentos;
				}
			
			}while(guess != numero && intentos > 0);

			if(guess == numero){
				System.out.printf("Enhorabuena, has adivinado el numero en %d intentos!!\n", 5 - intentos);
			}
			else{
				System.out.println("No has conseguido adivinar el número, más suerte la próxima vez.");
			}

			do{
				System.out.println("¿Volver a jugar? S/N");
				res = sc.nextLine().toUpperCase();
				letra = res.charAt(0);

				if(letra != 'S' && letra != 'N'){
					System.out.println("Opcion incorrecta.");
				}
			}while(letra != 'S' && letra != 'N');
		}while(letra != 'N');
	}
}
