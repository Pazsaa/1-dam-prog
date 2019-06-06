import java.util.Scanner;
public class ejercicio4 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int opcion;
		int n1, n2, res = 0;

		
		do{	
			System.out.print("\u001b[2J\u001b[H"); 
			// Borra pantalla y va al inicio
			System.out.print("\u001b[1m"); 
			// Negrita (o cambio de color)
			System.out.println("----------------");
			System.out.printf("Resultado de la última operación: %d\n", res); // Muestra de resultados.
			System.out.println("----------------");
			System.out.print("\u001b[1m"); 
			// Negrita (o cambio de color)
			System.out.println("Menú de opciones");
			System.out.println("----------------");
			System.out.print("\u001b[0m"); 
			// Normal
			System.out.print("\u001b[0m"); 
			// Normal
			System.out.println("1.- Suma");
			System.out.println("2.- Resta");
			System.out.println("3.- Multiplicación");
			System.out.println("4.- División\n\n");
			System.out.println("5.- Salir\n\n");
			System.out.println("Teclee opción (1-5)");

			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion){
				case 1:
					System.out.println("Primer numero: ");
					n1 = Integer.parseInt(sc.nextLine());

					System.out.println("Segundo numero: ");
					n2 = Integer.parseInt(sc.nextLine());

					res = n1+n2;
					break;
				case 2: 
					System.out.println("Primer numero: ");
					n1 = Integer.parseInt(sc.nextLine());

					System.out.println("Segundo numero: ");
					n2 = Integer.parseInt(sc.nextLine());

					res = n1-n2;
					break;
				case 3: 
					System.out.println("Primer numero: ");
					n1 = Integer.parseInt(sc.nextLine());

					System.out.println("Segundo numero: ");
					n2 = Integer.parseInt(sc.nextLine());

					res = n1*n2;
					break;
				case 4:
					
					System.out.println("Primer numero: ");
					n1 = Integer.parseInt(sc.nextLine());
					
					do{
						System.out.println("Segundo numero: ");
						n2 = Integer.parseInt(sc.nextLine());
						if(n2 == 0){
							System.out.println("Introduce un divisor distinto de 0");
						}

					}while (n2 == 0);
					
					res = n1/n2;
					break;

				default:
					break;
			}
		}while (opcion != 5);		
			
		
	}
}
