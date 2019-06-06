import java.util.Scanner;
class Fecha{
    private int dia, mes, ano;

    /*---------CONSTRUCTORS----------*/
    public Fecha(){};
    public Fecha(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    /*------END OF CONSTRUCTORS------*/

    /*-----------SETTERS-------------*/
    public void setDia(int dia){
        if(dia < 1 || dia > 31)
            dia = 1;
        this.dia = dia;
    }

    public void setMes(int mes){
        if(mes < 1 || mes > 12)
            mes = 1;
        this.mes = mes;
    }

    public void setAno(int ano){
        this.ano = ano;
    }
    /*--------END OF SETTERS---------*/

    /*-----------GETTERS-------------*/
    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }
    
    public int getAno(){
        return this.ano;
    }
    /*--------END OF SETTERS---------*/

    /*--------END OF SETTERS---------*/
    
    /**
     * Formatea la fecha en una cadena de texto. Valores numericos (flag = 1) / Valores a texto (flag = 0)
     * @param flag Booleano que controla el tipo de formato que se le dará a la fecha. (Texto/Numeros)
     * @return Cadena de texto resultante.
     */
    public String fechaFormateada(boolean flag){
        if(flag)
            return  this.dia + "/" + this.mes + "/" + this.ano;
        else{
            String mes = "";
            switch(this.mes){
                case 1:
                    mes = "enero";
                    break;
                case 2:
                    mes = "febrero";
                    break;
                case 3:
                    mes = "marzo";
                    break;
                case 4:
                    mes = "abril";
                    break;
                case 5:
                    mes = "mayo";
                    break;
                case 6:
                    mes = "junio";
                    break;
                case 7:
                    mes = "julio";
                    break;
                case 8:
                    mes = "agosto";
                    break;
                case 9:
                    mes = "septiembre";
                    break;
                case 10:
                    mes = "octubre";
                    break;
                case 11:
                    mes = "noviembre";
                    break;
                case 12:
                    mes = "diciembre";
                    break;
                default:
                    System.out.println("Error: mes inesperado!");
                    break;
            }
            return "" + this.dia + " de " + mes + " de " + this.ano;
        }
    }

    /**
     * Determina cuantos días tiene un mes dado. (31, 30 o 28);
     * @param mes Mes del que se quieren saber los dias.
     * @return Dias que tiene el mes dado.
     */
    public static int diasMes(int mes){
        int max = 0;
        switch(mes){
            case 2:
                max = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                max = 30;
                break;
            default:
                max = 31;
        }

        return max;
    }
    
    /**
     * Redondea un objeto Fecha al formato 1/01/XXXX. No actualiza los valores del objeto, solo cuenta cuantos días hay que restrarle para redondearlo.
     * @param a Objeto Fecha que se quiere redondear.
     * @param flag Booleano que determina si la fecha que se está dando es la primera (más pequeña) o no. Si lo es comprueba que el dia bisiesto no haya pasado, si ha pasado, resta 1. 
     * @return Numeros de dias restados para redondear la fecha.
     */
    public static int roundFecha(Fecha a, boolean flag){
        int dif = 0;
        for(int i = a.getDia(); i > 1; i--){
            dif++;
        }
        for(int i = a.getMes() - 1; i > 1; i--){
            dif += diasMes(i);
        }
        // AÑADIDO PARA QUE TENGA EN CUENTA SI LA FECHA ORIGEN YA HA PASADO EL DIA BISIESTO
        if(flag && bisiesto(a.getAno()) && (a.getMes() > 2 || (a.getMes() == 2 && a.getDia() >= 29)))
            dif--;
        
            
        return dif;
    }

    /** 
     * Determina si un año dado es bisiesto o no.
     * @param ano Año que se quiere averiguar si es bisiesto o no.
     * @return true Cuando el año es bisiesto.
     * @return false Cuando el año no es bisiesto.
     */
    public static boolean bisiesto(int ano){
        if(ano % 4 == 0 && ano % 100 !=0){
            return true;
        } 
        else if( ano % 400 == 0){
            return true;
        }
        return false;
    }

    /**
     * Calcula la diferencia en años o días (dependiendo de la bandera) entre dos fechas (Objetos Fecha)
     * @param a Objeto Fecha para la primera fecha.
     * @param b Objeto Fecha para la segunda fecha.
     * @param flag Booleano que determina si se quiere obtener la diferencia en años o en días.
     * @return La diferencia entre ambas fechas, ya sea en años o en días. 
     */
    public static int diferencia(Fecha a, Fecha b, boolean flag){
        int diferencia;
        if(flag){ // Diferencia en dias
            if(a.getAno() > b.getAno()){
                diferencia = roundFecha(a, true) + (-roundFecha(b, false)) + ((a.getAno() - b.getAno()) * 365);
                // ^ Dias que hicieron falta para redondear *a* menos los días que hicieron falta para redondear *b*
                // Mas 365 por cada año restante.
                for(int i = a.getAno(); i > b.getAno(); i--){
                    if(bisiesto(i)) diferencia++; // Aumenta la diferencia en 1 por cada año bisiesto entre ambas fechas (incluyendolas).
                }     
            } 
            else{
                diferencia = -roundFecha(a, false) + roundFecha(b, true) + ((b.getAno() - a.getAno()) * 365);
                for(int i = b.getAno(); i > a.getAno(); i--){
                    if(bisiesto(i)) diferencia++;  // Aumenta la diferencia en 1 por cada año bisiesto entre ambas fechas (incluyendolas).
                }      
            }
        }else{ // Diferencia en años.
            if(a.getAno() > b.getAno())
                diferencia = a.getAno() - b.getAno();
            else
                diferencia = b.getAno() - a.getAno();
        }
        
        return diferencia;
    }
}

public class Ejercicio2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el día, mes y año de la primera fecha. (Separados por enter)");
        int dia = Integer.parseInt(sc.nextLine());
        int mes = Integer.parseInt(sc.nextLine());
        int ano = Integer.parseInt(sc.nextLine());

        Fecha primera = new Fecha(dia, mes, ano);

        System.out.println("Introduce el día, mes y año de la segunda fecha. (Separados por enter)");
        dia = Integer.parseInt(sc.nextLine());
        mes = Integer.parseInt(sc.nextLine());
        ano = Integer.parseInt(sc.nextLine());

        Fecha segunda = new Fecha(dia, mes, ano);

        System.out.printf("\nLa primera fecha es %s", primera.fechaFormateada(true));
        System.out.printf("\nLa segunda fecha es %s", segunda.fechaFormateada(false));

        System.out.printf("\nHay una diferencia de %d años entre ambas fechas.", Fecha.diferencia(primera, segunda, false));

        System.out.printf("\nHay una diferencia de %d dias entre ambas fechas.", Fecha.diferencia(primera, segunda, true));

    }
}