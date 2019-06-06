import java.util.Scanner;
public class ejercicio8{
    /**
     *  Calcula el área de un triangulo/rectangulo/cuadrado
     * 
     * @param base
     * @param altura
     * @param flag 0 triangulo // 1 cuadrado-rectangulo
     * @return area
     */
    public static int area(int base, int altura, int flag){
        int area = 0;
        switch (flag){
            case 0:
                area = base * altura / 2;
                break;
            case 1:
                area = base * altura;
                break;
            default:
                System.out.println("Error: Valor de la bandera inesperado.");
                break;
        }
        return area;
    }

    /**
     * Calcula el area de un circulo.
     * @param radio
     * @return area
     */
    public static double areaC(int radio){
        double area = Math.PI * Math.pow(radio, 2);
        return area;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int res, base, altura, radio;
        do{
            System.out.println("---------------------------");
            System.out.println("1. Area tirangulo");
            System.out.println("2. Area rectangulo");
            System.out.println("3. Area cuadrado");
            System.out.println("4. Area ciruclo");
            System.out.println("5. Salir");
            System.out.println("---------------------------");

            System.out.println("\nIntroduce un numero [1-5]:");
            do{
                res = Integer.parseInt(sc.nextLine());
                if(res > 5 || res < 1) System.out.println("Opcion incorrecta!");
            }while(res > 5 || res < 1);

            switch(res){
                case 1:
                    System.out.println("Introduce la base del triangulo: ");
                    base = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce la altura del triangulo: ");
                    altura = Integer.parseInt(sc.nextLine());

                    System.out.printf("\nEl area del triangulo es: %d\n", area(base, altura, 0));
                    break;
                case 2:
                    System.out.println("Introduce la base del rectangulo: ");
                    base = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce la altura del rectangulo: ");
                    altura = Integer.parseInt(sc.nextLine());

                    System.out.printf("\nEl area del rectangulo es: %d\n", area(base, altura, 1));
                    break;
                case 3:
                    System.out.println("Introduce el lado del cuadrado: ");
                    base = Integer.parseInt(sc.nextLine());

                    System.out.printf("\nEl area del cuadrado es: %d\n", area(base, base, 1));
                    break;
                case 4:
                    System.out.println("Introduce el radio del circulo: ");
                    radio = Integer.parseInt(sc.nextLine());

                    System.out.printf("\nEl area del ciruclo es: %.0f\n", areaC(radio));
                    break;
                case 5:
                    // EXIT
                    break;
                default:
                    System.out.println("Error: Opcion inesperada!");
                    break;
            }

        }while(res != 5);
    }
}