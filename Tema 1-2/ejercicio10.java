public class ejercicio10{
	public static void main(String args[]){
		int n = 0, suma = 0;

		while(suma < 10000){
			n++;
			suma += n;
		}

		System.out.printf("N = %d\n", n);
	}
}
