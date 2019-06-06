import java.util.Scanner;
public class ejercicio14{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		float dinero;
		String res;
		char letra;

        // Nota para Curro: Fallaba el bucle de salida -> Solucionado.

		do{
			System.out.println("Introduce la cantidad a convertir: ");
			do{
				dinero = Float.parseFloat(sc.nextLine());
				if(dinero < 0){
					System.out.println("No se admiten valores negativos.");
				}
			}while(dinero < 0);
	
		
			do{
				System.out.println("¿Convertir a EUR o a GBP?: E/G");
				res = sc.nextLine().toUpperCase();
				letra = res.charAt(0);

				if(letra != 'E' && letra != 'G'){
					System.out.println("Opción inválida, prueba otra vez:");
				}			
			
			}while(letra != 'E' && letra != 'G');

			switch (letra){
				case 'E':
					System.out.printf("%.2f GBP a EUR -> %.2f\n", dinero, dinero / 0.88);
					break;

				case 'G':
					System.out.printf("%.2f EUR a GBP -> %.2f\n", dinero, dinero * 0.88);
					break;
			
				default:
					System.out.println("Opcion incorrecta");
					break;
			}
			do{
				System.out.println("¿Continuar? S/N");
				res = sc.nextLine().toUpperCase();
				letra = res.charAt(0);

                if(letra != 'N' && letra != 'S'){
                    System.out.println("Opcion incorrecta.");
                }
			}while(letra != 'N' && letra != 'S');
			
	
		}while(letra != 'N');
	 
	}
}
