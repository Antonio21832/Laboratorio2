//Antonio Molina 26878
//Clase que representa una ubicacion de investigacion
public class Ubicacion {
    //Variables de instancia
    private String codigo; //Codigo que identifica la ubicacion
    private String nombre; //Nombre de la ubicacion
    private String direccion; //Direccion o descripcion del lugar
    private int nivelRiesgo; //Nivel de riesgo entre 1 y 10
    private String estado; //Estado actual de la ubicacion
    //Constructor que inicializa los datos de la ubicacion
    public Ubicacion(String codigo, String nombre, String direccion, int nivelRiesgo, String estado) {
        //Valida que el nivel de riesgo este entre 1 y 10
        if (nivelRiesgo < 1 || nivelRiesgo > 10) {
            throw new IllegalArgumentException("El nivel de riesgo debe estar entre 1 y 10.");
        }
        //Asigna los valores recibidos
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nivelRiesgo = nivelRiesgo;
        this.estado = estado;
    }
    //Metodo que devuelve el codigo
    public String getCodigo() {
        return codigo;
    }
    //Metodo que devuelve el nombre
    public String getNombre() {
        return nombre;
    }
    //Metodo que devuelve la direccion
    public String getDireccion() {
        return direccion;
    }
    //Metodo que devuelve el nivel de riesgo
    public int getNivelRiesgo() {
        return nivelRiesgo;
    }
    //Metodo que devuelve el estado
    public String getEstado() {
        return estado;
    }
    //Metodo que modifica el nivel de riesgo
    public void setNivelRiesgo(int nivelRiesgo) {
        //Valida nuevamente el nivel antes de modificarlo
        if (nivelRiesgo < 1 || nivelRiesgo > 10) {
            throw new IllegalArgumentException( "El nivel de riesgo debe estar entre 1 y 10.");
        }
        //Modifica el nivel de riesgo
        this.nivelRiesgo = nivelRiesgo;
    }
    //Metodo que modifica el estado
    public void setEstado(String estado) {
        this.estado = estado;
    }
}