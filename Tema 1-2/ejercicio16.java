import java.util.Scanner;
public class ejercicio16{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int numero, suma = 0;

		String res;
		char letra;

		for(int i = 5; i <= 100; i+=5){
			System.out.printf("%d", i);
            suma += i;
			if(i < 100){
				System.out.print(", ");
			}
		}
        System.out.printf("\nSuma de los multiplos de 5: %d", suma);
            
		do {
            suma = 0;

			System.out.println("\nIntroduce un numero entre 1 y 50: ");
            do{			
                numero = Integer.parseInt(sc.nextLine());
            }while(numero < 1 || numero > 50);

			for(int i = numero; i <= 100; i+= numero){
				System.out.printf("%d", i);
                suma += i;
				if(i <= (100 - numero)){
					System.out.print(", ");
				}
			}
            System.out.printf("\nLa suma de los multiplos de %d entre 1 y 100 es: %d", numero, suma);
			System.out.println("");

			do{
				System.out.println("¿Repetir? S/N");
				res = sc.nextLine().toUpperCase();
				letra = res.charAt(0);
			
				if(letra != 'S' && letra != 'N'){
					System.out.println("Opcion incorrecta.");
				}
			}while(letra != 'S' && letra != 'N');
			
		}while(letra != 'N');
	}
}
