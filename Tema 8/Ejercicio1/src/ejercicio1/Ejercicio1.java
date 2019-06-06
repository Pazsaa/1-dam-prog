package ejercicio1;
/**
 *
 * @author Alberto
 */

import java.util.Scanner;
import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args){
       int res = ' ';
       File f = new File("C:\\Users\\Alberto\\Desktop\\PROGRAMMING\\Boletines JAVA\\Tema 8\\Ejercicio1.txt");
       Scanner sc = new Scanner(System.in);
       
       do{
           System.out.println("1.- Cambiar archivo a gestionar");
           System.out.println("2.- Crear archivo / sobreescribir");
           System.out.println("3.- Mostrar archivo");
           System.out.println("4.- Añadir contenido");
           System.out.println("5.- Borrar archivo");
           System.out.println("6.- Salir");
           
           try{
               res = Integer.parseInt(sc.nextLine());
           }
           catch(NumberFormatException e){
               System.out.println("Error, introduce un numero.");
           }
           
           switch(res){
               case 1:
                   System.out.println("Introduce la ruta del archivo que quieres utilizar: ");
                   String path = sc.nextLine();
                   
                   f = new File(path);
                   System.out.println("Ruta actualizada con éxito.");
                   break;
               case 2:
                   if(f.exists()){
                       System.out.println("El archivo especificado ya existe, ¿Desea reemplazarlo? [s/n]");
                       char r = sc.nextLine().charAt(0);
                       if(r == 's' || r == 'S')
                           try{
                               f.delete();
                               f.createNewFile();
                               System.err.println("Archivo sobreescrito.");
                           }catch(IOException e){
                               System.out.println("Error: " + e.getMessage());
                           }
                   }
                   else{
                       try{
                           f.createNewFile();
                           System.out.println("Archivo creado.");
                       }catch(IOException e){
                           System.err.println("Error: " + e.getMessage());
                       }
                   }
                   break;
               case 3:
                    String texto;
                    try(Scanner reader = new Scanner(f)){
                        while(reader.hasNext()){
                            texto = reader.nextLine();
                            System.out.println(texto);
                        }
                    }catch(IOException e){
                        System.err.println("Error: " + e.getMessage());
                    }
                    
                    break;
               case 4:
                   System.out.println("Introduce el texto a añadir: ");
                   String text2add = sc.nextLine();
                   
                   try(PrintWriter pw = new PrintWriter(new FileWriter(f, true))){
                       pw.println(text2add + "\n");
                       System.out.println("Texto añadido.");
                   }
                   catch(IOException e){
                       System.err.println("Error: " + e.getMessage());
                   }
                   break;
               case 5:
                   System.out.println("¿Seguro que quieres eliminar el archivo? [s/n]");
                   char r = sc.nextLine().charAt(0);
                   
                   if(r == 's' || r == 'S'){
                        f.delete();
                       System.out.println("Archivo borrado.");
                   }else
                       System.out.println("Abortado.");
                   
                   break;
               default:
                   if(res > 6 || res < 0)
                       System.out.println("Error, las opciones van del 1 al 6");
           }
           
       }while ( res != 6 );
    }
}
