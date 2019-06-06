public class Videojuego{
    public String titulo;
    public String fabricante;
    public int ano_lanzamiento;

    public Videojuego(String titulo, String fabricante, int ano_lanzamiento){
        this.titulo = titulo.toUpperCase();
        this.fabricante = fabricante.toUpperCase();
        this.ano_lanzamiento = ano_lanzamiento >= 0 ? ano_lanzamiento : 2000;
    }

    /* SETTERS */
    public void setTitulo(String titulo){
        this.titulo = titulo.toUpperCase();
    }

    public void setFabricante(String fabricante){
        this.fabricante = fabricante.toUpperCase();
    }

    public void setAnoLanzamiento(int ano_lanzamiento){
        this.ano_lanzamiento = ano_lanzamiento >= 0 ? ano_lanzamiento : 2000;
    }
}