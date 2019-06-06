import java.util.Scanner;
public class ejercicio6 {
	public static void main(String args[]){		
		Scanner sc = new Scanner(System.in);
		String res;
		char letra;

		do{
			double numero, suma = 0, cont = 0;
			System.out.println("Introduce numeros para hacer la media, termina introduciendo 0: ");
	
			do{
				numero = Integer.parseInt(sc.nextLine());
				suma += numero;
                if(numero != 0){
                    cont++;
                }
				
			}while(numero != 0);

			System.out.printf("Media de todos los números introducidos: %f\n", suma / cont);
			System.out.printf("Repetir? y/n\n");

			do{
				res = sc.nextLine().toUpperCase();
				letra = res.charAt(0);
			}while(letra != 'N' && letra != 'Y');
			

		}while(letra != 'N');
	}
}
