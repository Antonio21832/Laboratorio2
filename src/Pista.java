//Antonio Molina 26878
//Clase que representa una pista encontrada durante la investigacion
public class Pista {
    //Variables de instancia
    private String codigo; //Codigo que identifica la pista
    private String descripcion; //Descripcion de la pista
    private String tipoEvidencia; //Tipo de evidencia encontrada
    private int nivelImportancia; //Nivel de importancia entre 1 y 10
    private int nivelConfiabilidad; //Nivel de confiabilidad entre 0 y 100
    //Constructor que inicializa todos los datos de la pista
    public Pista(String codigo, String descripcion, String tipoEvidencia, int nivelImportancia, int nivelConfiabilidad) {
        //Valida el nivel de importancia
        if (nivelImportancia < 1 || nivelImportancia > 10) {
            throw new IllegalArgumentException("El nivel de importancia debe estar entre 1 y 10.");
        }
        //Valida el nivel de confiabilidad
        if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
            throw new IllegalArgumentException("El nivel de confiabilidad debe estar entre 0 y 100.");
        }
        //Asigna los valores recibidos
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoEvidencia = tipoEvidencia;
        this.nivelImportancia = nivelImportancia;
        this.nivelConfiabilidad = nivelConfiabilidad;
    }
    //Metodo que devuelve el codigo
    public String getCodigo() {
        return codigo;
    }
    //Metodo que devuelve la descripcion
    public String getDescripcion() {
        return descripcion;
    }
    //Metodo que devuelve el tipo de evidencia
    public String getTipoEvidencia() {
        return tipoEvidencia;
    }
    //Metodo que devuelve el nivel de importancia
    public int getNivelImportancia() {
        return nivelImportancia;
    }
    //Metodo que devuelve el nivel de confiabilidad
    public int getNivelConfiabilidad() {
        return nivelConfiabilidad;
    }
    //Metodo que modifica la descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //Metodo que modifica el tipo de evidencia
    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }
    //Metodo que modifica el nivel de importancia
    public void setNivelImportancia(int nivelImportancia) {
        //Valida el nuevo nivel de importancia
        if (nivelImportancia < 1 || nivelImportancia > 10) {
            throw new IllegalArgumentException("El nivel de importancia debe estar entre 1 y 10.");
        }
        //Modifica el nivel de importancia
        this.nivelImportancia = nivelImportancia;
    }
    //Metodo que modifica el nivel de confiabilidad
    public void setNivelConfiabilidad(int nivelConfiabilidad) {
        //Valida el nuevo nivel de confiabilidad
        if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
            throw new IllegalArgumentException("El nivel de confiabilidad debe estar entre 0 y 100.");
        }
        //Modifica el nivel de confiabilidad
        this.nivelConfiabilidad = nivelConfiabilidad;
    }
}