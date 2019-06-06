import java.util.Scanner;
public class ejercicio9{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);		
		int n1, n2, temp;

		System.out.println("Introduce dos numeros: ");
		n1 = Integer.parseInt(sc.nextLine());
		n2 = Integer.parseInt(sc.nextLine());

		temp = n1;
		n1 = n2;
		n2 = temp;

		System.out.printf("n1 = %d // n2 = %d\n", n1, n2);
	}
}
