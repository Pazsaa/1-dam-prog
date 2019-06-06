import java.util.Scanner;
public class ejercicio2{
    /**
     * Año bisiesto
     * 
     * @param ano Año dado
     * @return true si el año es bisiesto, false si no.
     */
    public static boolean bisiesto(int ano){
        if(ano % 4 == 0 && ano % 100 !=0){
            return true;
        } 
        else if( ano % 400 == 0){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ano;
        do{
            System.out.println("Introduce un año.");
            ano = Integer.parseInt(sc.nextLine());
            if(ano != 0){
                if(bisiesto(ano)) System.out.println("Es bisiesto");
                else System.out.println("No es bisiesto");
            }
        }while(ano != 0);
    }
}