 import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apazgarcia
 */
public class Ejercicio10 {
    public static char letraDNI(int dni){
        String dni_letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letra = dni_letras.charAt(dni % 23); 
        return letra;
    }
    
    public static void main(String[] args){
        if(args.length != 0)
                System.out.printf("Letra del dni %s: %s", args[0], letraDNI(Integer.parseInt(args[0])));
        else{
            int ans;
            Scanner sc = new Scanner(System.in);
            do{
                System.out.println("1.- Obtener letra DNI");
                System.out.println("2.- Comprobar DNI");
                System.out.println("3.- Salir");

                do{
                    System.out.println("Introduce una opcion: ");
                    ans = Integer.parseInt(sc.nextLine());
                }while(ans < 1 || ans > 3);
                
                switch(ans){
                    case 1:
                            int dni = Integer.parseInt(sc.nextLine());
                            System.out.printf("%s\n", letraDNI(dni));
                            break;
                    case 2:
                            String dni_con_letra = sc.nextLine();
                            String letra = dni_con_letra.substring(8).toUpperCase();
                            String dni_sin_letra = dni_con_letra.substring(0,8);
                            
                            if(letraDNI(Integer.parseInt(dni_sin_letra)) == letra.charAt(0))
                                System.out.println("Dni correcto!");
                            else
                                System.out.printf("\nDni incorrecto, la letra correspondiente sería: %s\n", letraDNI(Integer.parseInt(dni_sin_letra)));
                            
                            break;
                }
            }while(ans != 3);
        }
    }
}
