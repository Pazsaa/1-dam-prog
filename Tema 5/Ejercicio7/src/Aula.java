/**
 *
 * @author apazgarcia
 */
import java.util.Random;

public class Aula {
    private int [][] notas;
    private String [] alumnos;
    private String [] materias;
    
    public Aula(int n, int m, String[] materias, String[] alumnos){
        this.notas = new int[n][m];
        this.alumnos = alumnos;
        this.materias = materias;
        
       Random r = new Random();
       int max = 100; int min = 1;
       int range;
       for(int i = 0; i < notas.length; i++){
           for(int j = 0; j < notas[i].length; j++){
               range = r.nextInt((max - min) + 1 ) + min;
               // 0,1,2
               if(range > 0 && range < 6)
                   notas[i][j] = 0;
               if(range > 4 && range < 11)
                   notas[i][j] = 1;
               if(range > 9 && range < 16)
                   notas[i][j] = 2;
               
               // 3
               if(range > 14 && range < 26)
                   notas[i][j] = 3;
               
               // 4,5,6
               if(range > 24 && range < 41)
                   notas[i][j] = 4;
               if(range > 39 && range < 56)
                   notas[i][j] = 5;
               if(range > 54 && range < 71)
                   notas[i][j] = 6;
               
               // 7,8
               if(range > 69 && range < 81)
                   notas[i][j] = 7;
               if(range > 79 && range < 91)
                   notas[i][j] = 8;
               
               // 9, 10
               if(range > 89 && range < 96)
                   notas[i][j] = 9;
               if(range > 94 && range < 101)
                   notas[i][j] = 10;
           }
       }
    }
    
    /*----GETS----*/
    public int[][] getNotas(){
        return this.notas;
    }
    
    public String[] getAlumnos(){
        return this.alumnos;
    }
    
    public String[] getMaterias(){
        return this.materias;
    }
    
    /*----SETS----*/
    public void setNotas(int i, int j, int nota){
        this.notas[i][j] = nota;
    }
    
    /*----FUNC----*/
    
    /**
     * Calcula la media de todas las notas del Aula.
     * @return Media de las notas, como float.
     */
    public float mediaNotas(){
        float media = 0;
        for(int[] fila: this.notas){
            for(int n: fila){
                media += n;
            }
        }
        
        return media / this.notas.length;   
    }
    
    // ARREGALDO
    /**
     * Calcula la media de las notas de un alumno concreto.
     * @param alumno Alumno del que se quiere obtener la media, como indice.
     * @return  Media de las notas del alumno, como float.
     */
    public float mediaAlumno(int alumno){
        float media = 0;
        for(int j = 0; j < this.notas[alumno - 1].length; j++){
            media += this.notas[alumno][j];
        }
        
        return media / this.notas[alumno].length;
    }
    
    // ARREGALDO
    /**
     * Obtiene la nota media de una materia, pasada como indice numérico.
     * @param materia Referencia como numero entero a una materia.
     * @return Nota media de la materia, como float.
     */
    public float mediaMateria(int materia){
        float media = 0;
        
        for (int i = 0; i < this.notas.length; i++) {
            media += this.notas[i][materia - 1];
        }
        
        return media / this.alumnos.length;
    }
    
    // ARREGALDO
    /**
     * Obtiene la nota máxima de una materia.
     * @param materia Referencia como numero entero a una materia.
     * @return Nota maxima de la materia, como int.
     */
    public int notaMax(int materia){
        int max = 0;
        
        for (int i = 0; i < this.notas.length; i++){
            if(this.notas[i][materia] > max)
                max = this.notas[i][materia];
        }
        return max;
    }
    
    // ARREGALDO
    /**
     * Obtiene la nota minima de una materia.
     * @param materia Referencia como numero entero a una materia.
     * @return Nota minima de la materia, como int.
     */
    public int notaMin(int materia){
        int min = 10;
        
        for (int i = 0; i < this.notas.length; i++){
            if(this.notas[i][materia] < min)
                min = this.notas[i][materia];
        }
        return min;
    }
}
