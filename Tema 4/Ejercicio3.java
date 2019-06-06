import java.util.Scanner;
import java.lang.InterruptedException;
class Empleado{
    private String nombre, apellidos, dni;
    private int edad;
    private double salarioAnual, irpf;

    /*---------CONSTRUCTORS----------*/
    public Empleado(){
        this.nombre = ""; this.apellidos = ""; this.dni = "";
        this.edad = 0; this.salarioAnual = 0.0; this.irpf = 0.0;
    };
    public Empleado(String nombre, String apellidos, String dni, int edad, Double salarioAnual){
        this.nombre = nombre; this.apellidos = apellidos; this.dni = dni;
        this.edad = edad; this.salarioAnual = salarioAnual; this.irpf();
    }
    /*------END OF CONSTRUCTORS------*/

    /*-----------SETTERS-------------*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setSalarioAnual(double salarioAnual){
        this.salarioAnual = salarioAnual;
        irpf();
    }
    /*--------END OF SETTERS---------*/

    /*-----------GETTERS-------------*/
    public String getNombre(){
        return this.nombre;
    }

    public String getApellidos(){
        return this.apellidos;
    }
    
    public String getNombreCompleto(){
        return getNombre() + " " + getApellidos();
    }

    public String getDni(){
        return this.dni;
    }

    public int getEdad(){
        return this.edad;
    }

    public Double getSalarioAnual(){
        return this.salarioAnual;
    }

    public Double getIrpf(){
        return this.irpf;
    }
    /*--------END OF GETTERS---------*/

    /**
     * Calcula el IRPF en base al salario anual del objeto.
     */
    private void irpf(){ 
        if(this.salarioAnual < 6000)
            this.irpf = 7.5;
        else if(this.salarioAnual < 30000)
            this.irpf = 15.0;
        else 
            this.irpf = 20.0;
    }

    /**
     * Muestra todos los campos del objeto en pantalla.
     */
    public void mostrar(){
        System.out.printf("Nombre: %s\n", getNombreCompleto());
        System.out.printf("DNI: %s\n", getDni());
        System.out.printf("Edad: %d\n", getEdad());
        System.out.printf("Salario Anual: %.2f\n", getSalarioAnual());
        System.out.printf("IRPF: %.2f\n", getIrpf());
    }

    /**
     * Sobrecarga del anterior, permite mostrar un unico campo. Si el campo que se le da es incorrecto, mostrara todos.
     * @param choice Numero entero que corresponde al apartado concreto del objeto que se quiere mostrar.
     */
    public void mostrar(int choice){
        switch(choice){
            case 1:
                System.out.printf("Nombre: %s\n", getNombreCompleto());
                break;
            case 2:
                System.out.printf("DNI: %s\n", getDni());
                break;
            case 3:
                System.out.printf("Edad: %d\n", getEdad());
                break;
            case 4:
                System.out.printf("Salario Anual: %.2f // IRPF: %.2f \n", getSalarioAnual(), getIrpf());
                break;        
            default:
                mostrar();
                break;
        }
    }

    /**
     * Pide input al usuario para editar los campos del objeto mediante las funciones set.
     */
    public void editar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca su nombre: ");
        setNombre(sc.nextLine());
        System.out.println("Introduzca sus apellidos, separados por espacio: ");
        setApellidos(sc.nextLine());
        System.out.println("Introduzca su DNI: ");
        setDni(sc.nextLine());

        System.out.println("Introduzca su edad: ");
        setEdad(Integer.parseInt(sc.nextLine()));
        
        System.out.println("Introduzca su salario anual: ");
        setSalarioAnual(Double.parseDouble(sc.nextLine()));
    }

    /**
     * Calcula el pago a hacienda en base a salarioAnual y a irpf.
     * @return Cantidad de dinero pagada a haciend, como Double.
     */
    public double hacienda(){
        double hacienda = getSalarioAnual() * getIrpf() / 100;
        return hacienda;
    }

}

class Directivo{
    private String nombre, apellidos, dni, departamento;
    private float beneficios;

    /*---------CONSTRUCTORS----------*/
    public Directivo(){
        this.nombre = ""; this.apellidos = ""; this.dni = ""; this.departamento = "";
        this.beneficios = 0;
    }
    public Directivo(String nombre, String apellidos, String dni, String departamento, float beneficios){
        this.nombre = nombre; this.apellidos = apellidos; this.dni = dni; this.departamento = departamento;
        this.beneficios = beneficios;
    }
    /*------END OF CONSTRUCTORS------*/

    /*-----------SETTERS-------------*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento.toUpperCase();
    }

    public void setBeneficios(float beneficios){
        this.beneficios = beneficios;
    }
    /*--------END OF SETTERS---------*/

    /*-----------GETTERS-------------*/
    public String getNombre(){
        return this.nombre;
    }

    public String getApellidos(){
        return this.apellidos;
    }
    
    public String getNombreCompleto(){
        String nombreCompleto =  getNombre() + " " + getApellidos();
        return nombreCompleto;
    }

    public String getDni(){
        return this.dni;
    }

    public String getDepartamento(){
        return "\"" + this.departamento.toUpperCase() + "\"";
    }

    public float getBeneficios(){
        return this.beneficios;
    }
    /*--------END OF GETTERS---------*/

    /**
     * Muestra todos los campos del objeto en pantalla.
     */
    public void mostrar(){
        System.out.printf("Nombre: %s\n", getNombreCompleto());
        System.out.printf("DNI: %s\n", getDni());
        System.out.printf("Departamento: %s\n", getDepartamento());
        
        System.out.printf("Beneficios: %.2f\n", getBeneficios());
    }

    /**
     * Sobrecarga del anterior, permite mostrar un unico campo. Si el campo que se le da es incorrecto, mostrara todos.
     * @param choice Numero entero que corresponde al apartado concreto del objeto que se quiere mostrar.
     */
    public void mostrar(int choice){
        switch(choice){
            case 1:
                System.out.printf("Nombre: %s\n", getNombreCompleto());
                break;
            case 2:
                System.out.printf("DNI: %s\n", getDni());
                break;
            case 3:
                System.out.printf("Departamento: %s\n", getDepartamento());
                break;
            case 4:
                System.out.printf("Beneficios: %.2f", getBeneficios());
                break;        
            default:
                mostrar();
                break;
        }
    }

    /**
     * Pide input al usuario para editar los campos del objeto mediante las funciones set.
     */
    public void editar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca su nombre: ");
        setNombre(sc.nextLine());
        System.out.println("Introduzca sus apellidos, separados por espacio: ");
        setApellidos(sc.nextLine());
        System.out.println("Introduzca su DNI: ");
        setDni(sc.nextLine());
        System.out.println("Introduzca su departamento: ");
        setDepartamento(sc.nextLine());

        
        
        System.out.println("Introduzca sus beneficios: ");
        setBeneficios(Float.parseFloat(sc.nextLine()));
    }

    /**
     * Calcula las ganancias del Directivo en base a las ganancias de la empresa y a los beneficios del miembro.
     * @param g Double, ganancias de la empresa.
     * @return Double, ganancias del Directivo.
     */
    public double ganancias(double g){
        double ganancias;
        if(g > 0) 
            ganancias = g * this.beneficios / 100;
        else 
            ganancias = 0.0;

        return ganancias;
    }
}

class Empresa{
    private double ganancias;
    public Directivo d;
    public Empleado a, b;

    /*---------CONSTRUCTORS----------*/
    public Empresa(Directivo d, Empleado a, Empleado b){
        this.d = d;
        this.a = a; this.b = b;
    }
    public Empresa(Directivo d, Empleado a, Empleado b, double ganancias){
        this.d = d;
        this.a = a; this.b = b;
        this.ganancias = ganancias;
    }
    /*------END OF CONSTRUCTORS------*/

    /*-----------SETTERS-------------*/
    public void setGanancias(Double ganancias){
        this.ganancias = ganancias;
    }
    /*--------END OF SETTERS---------*/

    /*-----------GETTERS-------------*/
    public double getGanancias(){
        return this.ganancias;
    }
    /*--------END OF SETTERS---------*/
}

class Ejercicio3{
    /**
     * Submenús para la modificacion de datos tanto de directivos como de empleados.
     * @param e Objeto Empresa que se quiere modificar.
     */
    public static void modificarDatos(Empresa e){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\u001b[2J\u001b[H");
            System.out.println("---MODIFICAR DATOS---");
            System.out.println("1.- Modificar datos directivo");
            System.out.println("2.- Modificar datos empleado");
            System.out.println("3.- Volver al menu principal");
            choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    e.d.editar();
                    break;
                case 2:
                    System.out.println("\u001b[2J\u001b[H");
                    System.out.println("---MODIFICAR EMPLADOS---\n");
                    System.out.printf("1.- Modificar datos %s\n", e.a.getNombreCompleto());
                    System.out.printf("2.- Modificar datos %s\n", e.b.getNombreCompleto());
                    System.out.println("3.- Volver al menu \"MODIFICAR DATOS\"");
                    int subChoice = Integer.parseInt(sc.nextLine());

                    switch(subChoice){
                        case 1:
                            e.a.editar();
                            break;
                        case 2:
                            e.b.editar();
                            break;
                        default:
                            subChoice = 3;
                            break;
                    }
                case 3:
                    break;
                default:
                    System.out.println("Error: opcion inesperada");
                    break;
            }
        }while(choice != 3);
    }

    /**
     * Submenus para mostrar uno o todos los campos de los empleados de una empresa.
     * @param e Objeto empresa del que se quieren obtener datos.
     */
    public static void mostrarEmpleados(Empresa e) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\u001b[2J\u001b[H");
            System.out.println("---MOSTRAR DATOS EMPLEADOS---");
            System.out.println("1.- Mostrar todos los campos");
            System.out.println("2.- Mostrar campo unico");
            System.out.println("3.- Volver al menú principal");
            choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    System.out.println("\u001b[2J\u001b[H");
                    e.a.mostrar();
                    System.out.println("-----------------");
                    e.b.mostrar();
                    System.out.println("\nVolviendo al menú en 5 segundos...");
                    Thread.sleep(5000);
                    break;
                case 2:
                    System.out.println("\u001b[2J\u001b[H");
                    System.out.println("---MOSTRAR CAMPO UNICO---");
                    System.out.println("1.- Nombre completo");
                    System.out.println("2.- DNI");
                    System.out.println("3.- Edad");
                    System.out.println("4.- Salario anual e IRPF");
                    System.out.println("5.- Volver a \"MOSTRAR DATOS EMPLEADOS\"");
                    int subChoice = Integer.parseInt(sc.nextLine());

                    switch(subChoice){
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            System.out.println("\u001b[2J\u001b[H");
                            e.a.mostrar(subChoice);
                            System.out.println("-----------------");
                            e.b.mostrar(subChoice);
                            System.out.println("\nVolviendo al menú en 5 segundos...");
                            Thread.sleep(5000);
                            break;
                        case 5:
                            break;
                    }
            }
        }while(choice != 3);
    }

    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);

        Directivo d = new Directivo("Alberto", "Paz Garcia", "39492832S", "Pirotecnia", 25);
        Empleado a = new Empleado("Francisco", "Barcala Garcia", "333666S", 22, 20000.0);
        Empleado b = new Empleado("Alfonso", "Paz Garcia", "666333S", 21, 32000.0);

        Empresa e = new Empresa(d, a, b, 1000000.0);

        int choice;
        do{
            System.out.println("\u001b[2J\u001b[H");
            System.out.println("---MENU---");
            System.out.println("1.- Ver datos de los empleados");
            System.out.println("2.- Ver datos de los directivos");
            System.out.println("3.- Editar datos");
            System.out.println("4.- Pagar");
            System.out.println("5.- Cobrar");
            System.out.println("6.- Salir");
            choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:     //VER DATOS EMPLEADOS
                    mostrarEmpleados(e);
                    break;
                case 2:     //VER DATOS DIRECTIVO
                    System.out.println("\u001b[2J\u001b[H");
                    e.d.mostrar();
                    System.out.printf("\n\nGanancias reales en euros: %.2f€", e.d.ganancias(e.getGanancias()));
                    System.out.println("\nVolviendo al menu principal en 3 segundos...");
                    Thread.sleep(5000);
                    break;
                case 3:     //MODIFICAR DATOS
                    modificarDatos(e);
                    break;
                case 4:     //PAGAR
                    double salarioEmpleados = e.a.getSalarioAnual() + e.b.getSalarioAnual();
                    System.out.println("\u001b[2J\u001b[H");
                    System.out.printf("Se paga un total de %.2f a los empleados.\nGanancias previas: %.2f || Ganancias actuales: %.2f\n", salarioEmpleados, e.getGanancias(), e.getGanancias() - salarioEmpleados);
                    e.setGanancias(e.getGanancias() - salarioEmpleados);
                    System.out.println("\nVolviendo al menu principal en 3 segundos...");
                    Thread.sleep(5000);
                    break;
                case 5:     //COBRAR
                    System.out.println("\u001b[2J\u001b[H");
                    System.out.println("Intrdouzca la cantidad a cobrar: ");
                    double cobro = Double.parseDouble(sc.nextLine());
                    System.out.printf("Se ha registrado un cobro de %.2f.\nGanancias previas: %.2f || Ganancias actuales: %.2f\n", cobro, e.getGanancias(), e.getGanancias() + cobro);
                    e.setGanancias(e.getGanancias() + cobro);
                    System.out.println("\nVolviendo al menu principal en 3 segundos...");
                    Thread.sleep(5000);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error: opcion inesperada!");
                    break;
            }
        }while(choice != 6);
    }
}
