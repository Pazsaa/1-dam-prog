import java.util.Scanner;
public class ejercicio2{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n1, n2;
		
		System.out.printf("Introduce el primer numero:\n");
		n1 = Integer.parseInt(sc.nextLine());
		System.out.printf("Introduce el segundo numero:\n");
		n2 = Integer.parseInt(sc.nextLine());

		if (n1 > n2)
             System.out.printf("%d es mayor que %d.\n", n1, n2);
		else if (n2 > n1) 
            System.out.printf("%d es menor que %d.\n", n1, n2);
		else 
            System.out.printf("%d es igual que %d.\n", n1, n2);		
	}
}
