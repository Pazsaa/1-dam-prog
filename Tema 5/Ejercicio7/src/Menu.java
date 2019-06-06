/**
 *
 * @author apazgarcia
 */
import java.util.Scanner;

public class Menu {
    String[] alumnos = {"Fran", "Alberto", "Ana", "Samu", "Pablo", "Sofia", "Silvia", "David", "Ulises", "Andrea", "Diego", "Rodrigo", "Pedro", "Sabrina", "Axel"};
    String[] materias = {"Matematicas", "Fisica", "Programacion", "Entornos"};
    public  Aula a = new Aula(15,4, materias, alumnos);
    
    /*----FUNC----*/
    public void mostrarMenu(){
        
        do{
            System.out.println("-- MENU AULA --");
            System.out.println("1.- Ver tabla de notas");
            System.out.println("2.- Ver notas de un alumno");
            System.out.println("3.- Ver notas de una materia");
            System.out.println("4.- Media global");
            System.out.println("5.- Media de un alumno");
            System.out.println("6.- Media de una materia");
            System.out.println("7.- Nota maxima de una materia");
            System.out.println("8.- Nota minima de una materia");
            System.out.println("9.- Modificar nota");
            System.out.println("10.- Salir");
        }while(eleccion());
    }
    
    public boolean eleccion(){
        int choice;
        Scanner sc = new Scanner(System.in);
        
        
        do{
            choice = Integer.parseInt(sc.nextLine());
            if(choice < 1 || choice > 10)
                System.out.println("Opción no reconocida, prueba otra vez:");
            
        }while(choice < 1 || choice > 10);
        
        int index = 0;
        switch(choice){
            case 1:
                mostrarNotas();
                break;
            case 2:
                mostrarAlumnos();
                System.out.println("\nIntroduce el alumno que quieres ver (Indice)");
                index = Integer.parseInt(sc.nextLine());
                notasAlumno(index);
                break;
            case 3:
                mostrarMaterias();
                System.out.println("Introduce la materia que quieres ver (Indice)");
                index = Integer.parseInt(sc.nextLine());
                notasMateria(index);
                break;
            case 4:
                System.out.printf("La media global de las notas es: %.1f", a.mediaNotas());
                break;
            case 5:
                mostrarAlumnos();
                System.out.println("Introduce el alumno del que quieres saber la media (Indice):");
                index = Integer.parseInt(sc.nextLine());
                System.out.printf("La media del alumno es: %.1f", a.mediaAlumno(index));
                break;
            case 6:
                mostrarMaterias();
                System.out.println("Introduce la materia de la que quieres saber la media (Indice):");
                index = Integer.parseInt(sc.nextLine());
                System.out.printf("La media del alumno es: %.1f", a.mediaMateria(index));
                break;
            case 7:
                mostrarMaterias();
                System.out.println("Introduce la materia de la que quieres saber la nota maxima:");
                index = Integer.parseInt(sc.nextLine());
                System.out.printf("La nota mas alta de la materia es: %d", a.notaMax(index));
                break;
            case 8:
                mostrarMaterias();
                System.out.println("Introduce la materia de la que quieres saber la nota minima:");
                index = Integer.parseInt(sc.nextLine());
                System.out.printf("La nota mas baja de la materia es: %d", a.notaMin(index));
                break;
            case 9:
                mostrarAlumnos();
                System.out.println("\nDe qué alumno quieres cambiar la nota?");
                int alumno = Integer.parseInt(sc.nextLine());
                mostrarMaterias();
                System.out.println("");
                System.out.println("De qué materia quieres cambiar la nota?");
                int materia = Integer.parseInt(sc.nextLine());
                System.out.println("Qué nota quieres introducir?");
                int nota = Integer.parseInt(sc.nextLine());
                cambiarNota(alumno, materia, nota);
                break;
            case 10:
                return false;
        }
        return true;
    }
    
    // ARREGALDO
    /**
     * Muestra la tabla notas del objeto Aula.
     */
    public void mostrarNotas(){
        int [][] notas = a.getNotas();
        String [] alumnos = a.getAlumnos();
        String [] materias = a.getMaterias();
        
        System.out.printf("%12s - %15s - %15s - %15s - %15s", "Alumnos", materias[0], materias[1], materias[2], materias[3]);
        for(int i = 0; i < notas.length; i++){
            System.out.printf("\n%2d.%7s", i+1, alumnos[i]);
            for(int j = 0; j < notas[i].length; j++){
                System.out.printf("%17d ", notas[i][j]);
            }
            System.out.println("");
        }
    }
    
    // ARREGALDO
    /**
     * Muestra las notas de un alumno
     * @param index Alumno que se quiere obtener nota
     */
    public void notasAlumno(int index){
        int [][] notas = a.getNotas();
        String [] alumnos = a.getAlumnos();
        String [] materias = a.getMaterias();
        
        if(index < 1 || index > alumnos.length + 1){
            System.out.println("Error");
        }
        else{
            System.out.printf("\n%30s - %15s - %15s - %15s", materias[0], materias[1], materias[2], materias[3]);
            System.out.printf("\n%2d. %7s", index, alumnos[index-1]);
            for(int j = 0; j < notas[index].length; j++){
                System.out.printf("%17d ", notas[index - 1][j]);
            }
            System.out.println("\n");
        }
    }
    
    // ARREGALDO
    /**
     * Muestra las notas de una materia
     * @param index Materia de la que se quieren ver las notas
     */
    public void notasMateria(int index){
        int[][] notas = a.getNotas();
        String [] alumnos = a.getAlumnos();
        String [] materias = a.getMaterias();
        
        System.out.printf("%25s", materias[index - 1]);
        for(int i = 0; i < notas.length; i++){
            System.out.printf("\n%2d. %7s: %8d ", i + 1, alumnos[i],  notas[i][index -1]);
        }
        System.out.println("\n");
    }
    
    // ARREGALDO
    /**
     * Cambia la nota de un alumno, en una materia.
     * @param alumno Indice del alumno que se quiere modificar.
     * @param materia Indice de la materia que se quiere modificar.
     * @param nota Nota nueva.
     * @return True si tiene exito, false si no.
     */
    public boolean cambiarNota(int alumno, int materia, int nota){
        int [][] notas = a.getNotas();
        if(alumno < 0 || materia < 0 || alumno >= notas.length || materia >= notas.length || nota < 0 || nota > 10){
            System.out.println("Error");
            return false;
        } 
        else{
            a.setNotas(alumno - 1, materia - 1, nota);
            return true;
        }   
    }
    
    /**
     * Muestra la lista de alumnos y su indice
     */
    public void mostrarAlumnos(){
        int contador = 0;
        String [] alumnos = a.getAlumnos();
        for(int i = 0; i < alumnos.length; i++){
            if(contador == 5){
                System.out.println("");
                contador = 0;
            }
            if(i < alumnos.length - 1 )
                System.out.printf("%d. %s, ", i + 1, alumnos[i]);
            else
                System.out.printf("%d. %s", i + 1, alumnos[i]);
            
            contador++;
        }
        System.out.println("");
    }
    
    /**
     * Muestra la lista de materias y su indice
     */
    public void mostrarMaterias(){
        String [] materias = a.getMaterias();
        for(int i = 0; i < materias.length; i++){
            if(i < materias.length - 1)
                System.out.printf("%d. %s, ", i + 1, materias[i]);
            else
                System.out.printf("%d. %s ", i + 1, materias[i]);
        }
        System.out.println("");
    }
}
