
/**
 *
 * @author apazgarcia
 */
import java.util.Random;
public class Ventas {
    int ano;
    int [] ventas = new int [12];
    
    /*-----------CONSTRUCTORS-------------*/
    public Ventas(int ano){
        this.ano = ano;
        
        Random r = new Random();
        int max = 1000; int min = 0;
        for(int i = 0; i < this.ventas.length; i++){
            ventas[i] = r.nextInt((max - min) + 1) + min;
        }
    }
    /*---------EOF CONSTRUCTORS----------*/
    
    /*-------------METHODS---------------*/
    /**
     * Calculates the average number of sales on the object's year.
     * @return Average, as double.
     */
    public double media(){
        double media = 0.0;
        for(int i = 0; i < this.ventas.length; i++){
            media += ventas[i];
        }
        return media / this.ventas.length;
    }
    
    /**
     * Displays a graphic representation of the obect's year sales by months.
     * Adding an aditional # every 100 sales per month.
     */
    public void grafica(){
        System.out.printf("Año %d:\n", this.ano);
        for(int i = 0; i < this.ventas.length; i++){
            System.out.printf("Mes %2d: (%4d) ", i + 1, this.ventas[i]);
            for(int j = this.ventas[i] / 100 + 1; j > 0; j --){
                System.out.printf("#");
            }
            System.out.println("");
        }
    }
    /*-----------EOF METHODS-------------*/
}
