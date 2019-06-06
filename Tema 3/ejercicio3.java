import java.util.Scanner;

import jdk.nashorn.internal.runtime.Undefined;
public class ejercicio3{
    /**
     * Tangente
     * 
     * @param numero Ángulo en radianes
     * @return Tangente de numero
     */
    public static double tangente(double numero){
        return Math.sin(numero) / Math.cos(numero);
    }

    /**
     * Conversion grados->radianes
     * 
     * @param ang en grados
     * @return angulo en radianes
     */
    public static double deg_toRad(double ang){
        return ang * Math.PI /180;
    }

    public static char salida(){
        Scanner sc = new Scanner(System.in);
        String respuesta; char letra = ' ';
        do{
            respuesta = sc.nextLine().toUpperCase();
            letra = respuesta.charAt(0);
            if(letra != 'N' && letra != 'S')
                 System.out.println("Error!");
        }while(letra != 'N' && letra != 'S');
        
        return letra;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String respuesta; char letra = ' ';
        double ang;

        System.out.println("¿Quires trabajar en grados o en radianes? (G/R)");
        do{
            respuesta = sc.nextLine().toUpperCase();
            letra = respuesta.charAt(0);
            if(letra != 'G' && letra != 'R') 
                System.out.println("Error!");
        }while(letra != 'G' && letra != 'R');

        boolean grados = (letra == 'G');

        do{
            System.out.print("\u001b[2J\u001b[H"); 
            System.out.println("1.- Coseno del angulo");
            System.out.println("2.- Seno del angulo");
            System.out.println("3.- Tangente del angulo");
            System.out.println("4.- Salir");
            System.out.println("Seleccione una opción: ");

            int res = Integer.parseInt(sc.nextLine());

            switch(res){
                case 1:
                    System.out.println("Introduce un ángulo: ");
                    if(grados){
                         ang = deg_toRad(Double.parseDouble(sc.nextLine()));
                    }
                    else  ang = Double.parseDouble(sc.nextLine());
                    double cos = Math.cos(ang);
                    System.out.printf("El cosendo de %f es: %f", ang, cos);
                    System.out.println("\n¿Continuar?");
                    
                    salida();
                break;
                case 2:
                    System.out.println("Introduce un ángulo: ");
                    if(grados){
                        ang = deg_toRad(Double.parseDouble(sc.nextLine()));
                    }
                    else  ang = Double.parseDouble(sc.nextLine());
                    double sin = Math.sin(ang);
                    System.out.printf("El seno de %f es: %f", ang, sin);
                    System.out.println("\n¿Continuar?");
                    
                    salida();
                break;
                case 3:
                    System.out.println("Introduce un ángulo: ");
                    if(grados){
                        ang = deg_toRad(Double.parseDouble(sc.nextLine()));
                    }
                    else  ang = Double.parseDouble(sc.nextLine());
                    double tan = tangente(ang);
                    System.out.printf("La tangente de %f es: %f", ang, tan);
                    System.out.println("\n¿Continuar?");
                    
                    salida();
                break;
                case 4:
                    letra = 'N';
                    break;
                default:
                    letra = 'N';
                    break;
            }
          
        }while(letra == 'S');
    }
}