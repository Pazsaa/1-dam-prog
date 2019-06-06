import java.util.Scanner;
import java.lang.InterruptedException;
class Geometria{
    public boolean figura;
    public int altura, base;

    /*---------CONSTRUCTORS----------*/
    public Geometria(){
        this.figura = false;
        this.altura = 2; 
        this.base = 2;
    }

    public Geometria(int altura, int base){
        this.figura = false;
        this.altura = altura;
        this.base = base;
    }

    public Geometria(boolean figura, int altura, int base){
        this.figura = figura;
        this.altura = altura;
        this.base = base;
    }
    /*------END OF CONSTRUCTORS------*/
    
    /**
     * Calcula el area de la figura geometrica.
     * @return area 
     */
    public int area(){
        if(figura)
            return this.base * this.altura;
        else
            return this.base * this.altura / 2;
    }
    /**
     * Calucla el perimetro de la figura geometrica.
     * @return perimetro
     */
    public int perimetro(){
        if(figura)
            return 2 * (this.base + this.altura);
        else
            return this.base + this.altura + this.hipotenusa();
    }
    /**
     * Calcula la hipotenusa de un triangulo rectanculo (tambien la diagonal de un rectangulo)
     * @return hipotenusa
     */
    public int hipotenusa(){
        return (int)Math.sqrt(Math.pow(this.altura, 2) + Math.pow(this.base, 2));
    }
}

public class Ejercicio1{
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        Geometria geo = new Geometria();
        int opcion;
        do{    
            System.out.println("\u001b[2J\u001b[H");
            System.out.println("1.- Cambiar figura");
            System.out.println("2.- Calcular area");
            System.out.println("3.- Calcular perimetro");
            System.out.println("4.- Calcular diagonal");
            System.out.println("5.- Salir");

            System.out.println("");
            System.out.println("Introduce la opción deseada:");

            do{
                opcion = Integer.parseInt(sc.nextLine());
                if(opcion < 1 || opcion > 5) System.out.println("Error, opcion invalida!");
            }while(opcion < 1 || opcion > 5);

            int res;
            switch(opcion){
                case 1:
                    System.out.println("Introduce 0 para triangulo, 1 para rectangulo:");
                    do{
                        res = Integer.parseInt(sc.nextLine());
                        if(res < 0 || res > 1 ) System.out.println("Error, opcion invalida");
                    }while(res < 0 || res > 1);
                    boolean figura = res != 0 ;

                    System.out.println("Introduce la altura de la figura:");
                    do{
                        res = Integer.parseInt(sc.nextLine());
                        if(res < 0 ) System.out.println("Error, valor invalido");
                    }while(res < 0);
                    int altura = res;

                    System.out.println("Introduce la base de la figura:");
                    do{
                        res = Integer.parseInt(sc.nextLine());
                        if(res < 0) System.out.println("Error, valor invalido");
                    }while(res < 0);
                    int base = res;

                    geo = new Geometria(figura, altura, base);
                    System.out.printf("Tu %s tiene una altura de %d y una base de %d", figura ? "rectangulo" : "triangulo", geo.altura, geo.base);
                    Thread.sleep(2000);
                    break;
                case 2:
                    System.out.printf("Tu figura tiene un area de %d", geo.area());
                    Thread.sleep(2000);
                    break;
                case 3:
                    System.out.printf("Tu figura tiene un perimetro de %d", geo.perimetro());
                    Thread.sleep(2000);
                    break;
                case 4:
                    System.out.printf("Tu figura tiene una diagonal de %d", geo.hipotenusa());
                    Thread.sleep(2000);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Error, valor inesperado!");
                    Thread.sleep(2000);
                    break;
            }
        }while(opcion != 5);
    }
}