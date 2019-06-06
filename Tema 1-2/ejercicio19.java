import java.util.Scanner;
public class ejercicio19{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n;

		System.out.println("¿Cuantos asteriscos quieres imprimir en diagonal? Usa un numero negativo para hacer la diagonal hacia la izquierda.");
		n = Integer.parseInt(sc.nextLine());

		/*for(int i = 0; i < n; i++){
			System.out.print("*");
		}*/
		

		if(n < 0){
			for(int i = n; i < 0; i++){
				for(int j = 0; j > i; j--){
					System.out.print(" ");
				}
				System.out.print("*\n");
			}
		}
		else{
			for(int i = 0; i < n; i++){
				for(int j = 0; j < i; j++){
					System.out.print(" ");
				}
				System.out.print("*\n");
			}
		}
		
	}
}
