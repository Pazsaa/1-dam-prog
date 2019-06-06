import java.util.Scanner;
public class ejercicio8{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int cantidad, numero;
        Integer max = null;

		System.out.println("Cuantos nueros quieres introducir?");
		cantidad = Integer.parseInt(sc.nextLine());
		System.out.println("----------------------------------");

		for(int i = 0; i < cantidad; i++){
			numero = Integer.parseInt(sc.nextLine());		
            if(max == null){
                max = numero;
            }
			if(numero > max){
				max = numero;
			}
		}
		System.out.printf("El mayor de los numeros es: %d \n", max);
	}
}
