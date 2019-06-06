import java.util.Scanner;
public class ejercicio3{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int C;
		
		String res;
		char letra;

		System.out.printf("Introduce temperatura en Cº: \n");
		C = Integer.parseInt(sc.nextLine());

		do{
			System.out.println("¿Convertir a Farenheit o a Kelvin? F/K");
			res = sc.nextLine().toUpperCase();
			letra = res.charAt(0);

			if(letra!='F' && letra!='K'){
				System.out.println("Respuesta no valida.");
			}
			
			
		}while(letra!='F' && letra!='K');

		if(letra == 'F'){
			System.out.printf("\nLa temperatura en Farenheit es: %d. \n", C + 273);
		}
		else {
			System.out.printf("\nLa temperatura en Kelvin es: %.1f. \n", 1.8 * (float)C + 32);
		}
	}
}
