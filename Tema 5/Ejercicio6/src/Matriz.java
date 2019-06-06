/**
 *
 * @author apazgarcia
 */

import java.util.Random;

public class Matriz {
    int [][] matriz;
    
    public Matriz(int n){
        this.matriz = new int [n][n];
        
        Random r = new Random();
        int max = 10; int min = 0;
        
        for(int i = 0; i < this.matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = r.nextInt((max - min) + 1) + min;
            }
        }
    }
    
    /**
     * Displays the matrix's values, by rows and columns.
     */
    public void mostrar(){
        for(int i = 0; i < this.matriz.length; i++){
            for(int j = 0; j < this.matriz[i].length; j++){
                System.out.printf("%d, ", this.matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Adds every value inside the matrix.
     * @return Final value, as integer.
     */
    public int suma(){
        int suma = 0;
        for(int i = 0; i < this.matriz.length; i++){
            for(int j = 0; j < this.matriz[i].length; j++){
                suma += this.matriz[i][j];
            }
        }
        return suma;
    }
    
    /**
     * Adds either the values of the diagonal, or every value but the diagonal. Depending on the flag.
     * @param diagonal If set to true, returns the result of adding the values of the diagonal. If set to false returns the adition of every other value in the matrix.
     * @return Final value, as integer.
     */
    public int suma(boolean diagonal){
        int suma = 0;
        for(int i = 0; i < this.matriz.length; i++){
                suma += matriz[i][i];
        }
        
        if(diagonal){
            return suma;
        }
        else{
            return this.suma() - suma;
        }
    }
    
    /**
     * Adds every value on a given row.
     * @param row Row number inside of the matrix.
     * @return Final value, as integer. If there's a range error returns -1.
     */
    public int suma(int row){
       if(row < 0 || row >= this.matriz.length)
           return -1;
       
       int suma = 0;
       for(int j = 0; j < this.matriz[row].length; j++){
           suma += this.matriz[row][j];
       }
       return suma;
   }
}
