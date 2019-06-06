import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio8{

    /**
     * Crea un objeto Videojuego atendiendo a los parametros introducidos por el usuario.
     * Lo diseñé utilizando el constructor de la clase Videojuego porque me pareció ahorrar espacio y tiempo, ya que no se ha pedido
     * la modificación de campos individualmente. Se modifican todos al crearse, luego, constructor.
     * 
     * Si se quisiera hacer de forma individual, se podría, los setters de la clase son funcionales.
     */
    public static Videojuego crearJuego(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del videojuego a añadir: ");
        String titulo = sc.nextLine();
        System.out.println("Introduce el nombre del fabricante: ");
        String fabricante = sc.nextLine();
        System.out.println("Introduce el año de lanzamiento: ");
        int ano_lanzamiento = Integer.parseInt(sc.nextLine());

        Videojuego v = new Videojuego(titulo, fabricante, ano_lanzamiento);
        return v;
    }

    /**
     * Muestra todos los elementos de la coleccion.
     * @param videojuegos Lista que se quiere mostrar.
     */
    public static void mostrarVideojuegos(ArrayList<Videojuego> videojuegos){
        System.out.println("\n\n=======================");
        System.out.println("Videojuegos en la lista");  
        System.out.println("=======================\n\n");

        int index = 1;
        for(Videojuego juego: videojuegos){
            System.out.printf("%d.=====================\n", index);
            System.out.printf("Titulo: %s\nFabricante: %s\nAño: %d\n", juego.titulo, juego.fabricante, juego.ano_lanzamiento);
            System.out.println("=======================\n\n");

            index++;
        }
    }

    /**
     * Busca y muestra los juegos cuyo titulo comienze por el string dado.
     * @param videojuegos Lista con la que se quiere trabajar.
     * @param frag Frag(mento) del titulo que se quiere buscar.
     */
    public static void mostrarVideojuegos(ArrayList<Videojuego> videojuegos, String frag){
        System.out.println("\n\n=======================");
        System.out.println("Videojuegos por titulo");  
        System.out.println("=======================\n\n");

        int index = 1;
        for(Videojuego juego: videojuegos){
            if(juego.titulo.startsWith(frag)){
                System.out.printf("%d.=====================\n", index);
                System.out.printf("Titulo: %s\nFabricante: %s\nAño: %d\n", juego.titulo, juego.fabricante, juego.ano_lanzamiento);
                System.out.println("=======================\n\n");
            }
            index++;
        }
    }

    /**
     * Muestra los videojuegos de la lista que se hayan lanzado en el año indicado.
     * @param videojuegos Lista con la que se quiere trabajar.
     * @param ano Año del que se quieren visualizar los juegos.
     */
    public static void mostrarVideojuegos(ArrayList<Videojuego> videojuegos, int ano){
        System.out.println("\n\n=======================");
        System.out.printf("\nVideojuegos del año %d", ano);  
        System.out.println("\n=======================\n\n");

        int index = 1;
        for(Videojuego juego: videojuegos){
            if(juego.ano_lanzamiento == ano){
                System.out.printf("%d.=====================\n", index);
                System.out.printf("Titulo: %s\nFabricante: %s\nAño: %d\n", juego.titulo, juego.fabricante, juego.ano_lanzamiento);
                System.out.println("=======================\n\n");
            }
            index++;
        }
    }

    /**
     * Elimina los juegos de la coleccion que coincidan con el año indicado. El bucle va a hacia atrás porque si iteras hacia .size desde 0, .size cambia cada vez que se borra.
     * Lo que resulta en perdida de elementos (se quedan sin borrar, porque i llega a .size antes de lo esperado);
     * @param videojuegos Lista de objetos que se quiere utilizar
     * @param ano Año del que se quiere borrar elementos.
     */
    public static void eliminarVideojuegosAno(ArrayList<Videojuego> videojuegos, int ano){
        int index = 0;

        for(int i = videojuegos.size() - 1; i >= 0; i--){
            if(videojuegos.get(i).ano_lanzamiento == ano){
                index ++;
                videojuegos.remove(i);
            }
        }
        System.out.printf("\nElminados %d videojuegos de la lista.\n", index);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Videojuego> videojuegos = new ArrayList<Videojuego>();
        
        /* Miembros predeterminados */
        Videojuego game = new Videojuego("Kingdom Hearts", "Square Enix", 2000);
        videojuegos.add(game);
        
        game = new Videojuego("Kingdom Hearts 2", "Square Enix", 2007);
        videojuegos.add(game);

        game = new Videojuego("Kingdom Hearts 3", "Square Enix", 2019);
        videojuegos.add(game);
        /* ----------------------- */

        int opcion;

        do{
            System.out.println("1.- Insertar nuevo juego");
            System.out.println("2.- Eliminar juego");
            System.out.println("3.- Comprobar juego (por titulo/fragmento del titulo");
            System.out.println("4.- Mostrar lista completa");
            System.out.println("5.- Mostrar juegos de un año");
            System.out.println("6.- Borrar juegos de un año");
            System.out.println("7.- Salir");

            do{
                System.out.println("\nIntroduce una opcion: ");
                opcion = Integer.parseInt(sc.nextLine());
            }while(opcion < 1 || opcion > 7);

            int ano;
            switch(opcion){
                case 1:
                    char respuesta; 
                    do{
                        System.out.println("Quieres introducirlo al principio o al final de la lista? p/f");
                        respuesta = sc.nextLine().charAt(0);
                    }while( respuesta != 'p' && respuesta != 'f');

                    if(respuesta == 'f')
                        videojuegos.add(crearJuego());
                    else
                        videojuegos.add(0, crearJuego());
                break;
                case 2:
                    mostrarVideojuegos(videojuegos);
                    int index;
                    do{
                        System.out.println("Qué videojuego quieres eliminar? (indice)");
                        index = Integer.parseInt(sc.nextLine());
                    }while(index < 1 || index > videojuegos.size());
                    videojuegos.remove(index - 1);
                break;
                case 3:
                    System.out.println("Introduce el principio del titulo que quieres confirmar: ");
                    String titulo = sc.nextLine();
                    mostrarVideojuegos(videojuegos, titulo.trim().toUpperCase());
                break;
                case 4:
                    mostrarVideojuegos(videojuegos);
                break;
                case 5:
                    System.out.println("De qué año quieres ver los juegos? ");
                    ano = Integer.parseInt(sc.nextLine());
                    mostrarVideojuegos(videojuegos, ano);
                break;
                case 6:
                    mostrarVideojuegos(videojuegos);
                    System.out.println("De qué año quieres borrar todos los juegos?");
                    ano = Integer.parseInt(sc.nextLine());
                    eliminarVideojuegosAno(videojuegos, ano);

            }
        }while(opcion != 7);
    }
}