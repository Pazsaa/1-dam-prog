import java.util.Scanner;
public class ejercicio13{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n, cant = 0, cantneg = 0;

		System.out.println("Introduce numeros, cuando acabes introduce 0: ");
		do {
			n = Integer.parseInt(sc.nextLine());
			
			if(n < 0) cantneg ++;
			if(n != 0) cant ++;			
		}while(n != 0);
	
		System.out.printf("Has introducido %d numeros negativos, de un total de %d numeros.\n", cantneg, cant);
	}
}
