import java.util.Scanner;
import java.lang.InterruptedException;
public class ejercicio20{
	public static void main(String args[]) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int n;
	
		System.out.println("¿Cuantas lineas quieres mostrar?");
		n = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < i; j++){
				System.out.print("*");
                Thread.sleep(10);
			}
			System.out.print("\n"); 
		}
	}
}
