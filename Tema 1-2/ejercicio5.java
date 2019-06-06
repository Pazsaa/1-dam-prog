import java.util.Scanner;
public class ejercicio5{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		double n1, n2, res = 0;
		int opcion = 0;

		do{
			System.out.print("\u001b[2J\u001b[H"); 
			// Borra pantalla y va al inicio
			System.out.print("\u001b[1m"); 
			// Negrita (o cambio de color)
			System.out.println("----------------");
			if(opcion == 1)
				System.out.printf("Resultado de la última operación: %.2f\n", (float)res); // Muestra resultados.
			else if (opcion == 2)
				System.out.printf("Resultado de la última operación: %.4f\n", (float)res); // Muestra resultados;
			else
				System.out.printf("Resultado de la última operación: %d\n", (int)res); // Muestra resultados;
			System.out.println("----------------");	
			System.out.println("----------------");	
			System.out.println("Menu de opciones");
			System.out.print("\u001b[1m");
			// Normal
			System.out.println("1. Cuadrado");
			System.out.println("2. Inverso");
			System.out.println("3. Raiz");
			System.out.println("4. Salir");
			System.out.println("----------------\n\n");	
			System.out.println("Introduce la opcion deseada. \n");
			
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion){
				case 1:
					System.out.println("Numero: ");
					n1 = Integer.parseInt(sc.nextLine());
					
					res = n1 * n1; 
					break;
				
				case 2:
					System.out.println("Numero: ");

					do{
						n1 = Integer.parseInt(sc.nextLine());
					}while( n1 == 0);
					
					res = 1/n1;
					
					break;

				case 3:
					System.out.println("Numero: ");
					do{
						n1 = Integer.parseInt(sc.nextLine());
					}while (n1 < 0);

					res = Math.sqrt(n1);					

					break;
			
				default: 
					break;
			}
		}while(opcion != 4);
				
	}
}
