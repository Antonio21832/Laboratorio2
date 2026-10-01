import java.util.ArrayList;

//Antonio Molina 26878
//Clase que representa y administra un caso de investigacion
public class Caso {
    //Datos generales del caso
    private String nombreCaso; //Nombre del caso
    private String codigoIdentificacion; //Codigo que identifica el caso
    private String detectiveResponsable; //Nombre del detective responsable
    //Arreglo basico que almacena un maximo de 5 ubicaciones
    private Ubicacion[] ubicaciones;
    //ArrayList que almacena dinamicamente las pistas encontradas
    private ArrayList<Pista> pistas;
    //Constructor que inicializa la informacion del caso
    public Caso(String nombreCaso, String codigoIdentificacion, String detectiveResponsable) {
        //Asigna los datos generales del caso
        this.nombreCaso = nombreCaso;
        this.codigoIdentificacion = codigoIdentificacion;
        this.detectiveResponsable = detectiveResponsable;
        //Crea el arreglo con espacio para 5 ubicaciones
        //Todas las posiciones comienzan con null
        this.ubicaciones = new Ubicacion[5];
        //Crea el ArrayList vacio de pistas
        this.pistas = new ArrayList<Pista>();
    }
    //Metodo que devuelve el nombre del caso
    public String getNombreCaso() {
        return nombreCaso;
    }
    //Metodo que devuelve el codigo de identificacion
    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }
    //Metodo que devuelve el detective responsable
    public String getDetectiveResponsable() {
        return detectiveResponsable;
    }
    //Metodo que devuelve el arreglo de ubicaciones
    public Ubicacion[] getUbicaciones() {
        return ubicaciones;
    }
    //Metodo que devuelve el ArrayList de pistas
    public ArrayList<Pista> getPistas() {
        return pistas;
    }
    //Metodo que registra una ubicacion en una posicion del arreglo
    public boolean registrarUbicacion(int posicion, Ubicacion ubicacion) {
        //Verifica que la posicion se encuentre dentro del arreglo
        if (posicion >= 0 && posicion < ubicaciones.length) {
            //Verifica que la posicion se encuentre disponible
            if (ubicaciones[posicion] == null) {
                //Guarda la ubicacion en la posicion indicada
                ubicaciones[posicion] = ubicacion;
                //Indica que se registro correctamente
                return true;
            }
            //La posicion ya contiene una ubicacion
            else {
                return false;
            }
        }
        //La posicion no existe
        else {
            return false;
        }
    }
    //Metodo que obtiene una ubicacion utilizando su posicion
    public Ubicacion obtenerUbicacion(int posicion) {
        //Verifica que la posicion exista
        if (posicion >= 0 && posicion < ubicaciones.length) {
            //Devuelve la ubicacion
            //Puede devolver null si la posicion esta vacia
            return ubicaciones[posicion];
        }
        //Si la posicion no existe devuelve null
        else {
            return null;
        }
    }
    //Metodo que modifica el riesgo y estado de una ubicacion
    public boolean modificarUbicacion(int posicion, int riesgo, String estado) {
        //Obtiene la ubicacion de la posicion indicada
        Ubicacion ubicacion = obtenerUbicacion(posicion);
        //Verifica que exista una ubicacion
        if (ubicacion != null) {
            //Modifica el nivel de riesgo
            //El setter genera IllegalArgumentException si es invalido
            ubicacion.setNivelRiesgo(riesgo);
            //Modifica el estado
            ubicacion.setEstado(estado);
            //Indica que se realizo la modificacion
            return true;
        }
        //No existe una ubicacion en esa posicion
        else {
            return false;
        }
    }
    //Metodo que descarta una ubicacion
    public boolean descartarUbicacion(int posicion) {
        //Verifica que la posicion exista
        if (posicion >= 0 && posicion < ubicaciones.length) {
            //Verifica que la posicion tenga una ubicacion
            if (ubicaciones[posicion] != null) {
                //Elimina la referencia colocando null
                ubicaciones[posicion] = null;
                //Indica que se descarto correctamente
                return true;
            }
            //La posicion ya se encuentra vacia
            else {
                return false;
            }
        }
        //La posicion no existe
        else {
            return false;
        }
    }
    //Metodo que registra una nueva pista
    public boolean registrarPista(Pista pista) {
        //Busca si ya existe una pista con el mismo codigo
        Pista encontrada = buscarPista(pista.getCodigo());
        //Verifica que el codigo no este repetido
        if (encontrada == null) {
            //Agrega la pista al ArrayList
            pistas.add(pista);
            //Indica que se registro correctamente
            return true;
        }
        //El codigo ya se encuentra registrado
        else {
            return false;
        }
    }
    //Metodo que busca una pista utilizando su codigo
    public Pista buscarPista(String codigo) {
        //Variable que guarda la pista encontrada
        Pista encontrada = null;
        //Variable que controla el ciclo
        int i = 0;
        //Recorre el ArrayList mientras no encuentre la pista
        while (i < pistas.size() && encontrada == null) {
            //Obtiene la pista de la posicion actual
            Pista pista = pistas.get(i);
            //Compara el codigo de la pista
            if (pista.getCodigo().equals(codigo)) {
                //Guarda la pista encontrada
                encontrada = pista;
            }
            //Aumenta el contador
            i = i + 1;
        }
        //Devuelve la pista o null si no existe
        return encontrada;
    }
    //Metodo que modifica una pista previamente registrada
    public boolean modificarPista(String codigo, String descripcion,  String tipoEvidencia, int nivelImportancia,  int nivelConfiabilidad) {
        //Busca la pista utilizando su codigo
        Pista pista = buscarPista(codigo);
        //Verifica que la pista exista
        if (pista != null) {
            //Modifica la descripcion
            pista.setDescripcion(descripcion);
            //Modifica el tipo de evidencia
            pista.setTipoEvidencia(tipoEvidencia);
            //Modifica el nivel de importancia
            //Puede generar IllegalArgumentException
            pista.setNivelImportancia(nivelImportancia);
            //Modifica el nivel de confiabilidad
            //Puede generar IllegalArgumentException
            pista.setNivelConfiabilidad(nivelConfiabilidad);
            //Indica que se modifico correctamente
            return true;
        }
        //La pista no existe
        else {
            return false;
        }
    }
    //Metodo que elimina una pista del ArrayList
    public boolean eliminarPista(String codigo) {
        //Busca la pista utilizando su codigo
        Pista pista = buscarPista(codigo);
        //Verifica que la pista exista
        if (pista != null) {
            //Elimina la pista del ArrayList
            pistas.remove(pista);
            //Indica que se elimino correctamente
            return true;
        }
        //La pista no existe
        else {
            return false;
        }
    }
    //Metodo que cuenta las ubicaciones registradas
    public int cantidadUbicaciones() {
        //Variable que guarda la cantidad
        int cantidad = 0;
        //Variable que controla el ciclo
        int i = 0;
        //Recorre todo el arreglo
        while (i < ubicaciones.length) {
            //Cuenta solamente las posiciones que no tienen null
            if (ubicaciones[i] != null) {
                cantidad = cantidad + 1;
            }
            //Aumenta el contador
            i = i + 1;
        }
        //Devuelve la cantidad encontrada
        return cantidad;
    }
    //Metodo que calcula los espacios disponibles del arreglo
    public int espaciosDisponibles() {
        //Variable que guarda la cantidad de espacios vacios
        int cantidad = 0;
        //Variable que controla el ciclo
        int i = 0;
        //Recorre todo el arreglo
        while (i < ubicaciones.length) {
            //Cuenta las posiciones que contienen null
            if (ubicaciones[i] == null) {
                cantidad = cantidad + 1;
            }
            //Aumenta el contador
            i = i + 1;
        }
        //Devuelve la cantidad de espacios disponibles
        return cantidad;
    }
    //Metodo que encuentra la ubicacion con mayor riesgo
    public Ubicacion ubicacionMayorRiesgo() {
        //Variable que guarda la ubicacion de mayor riesgo
        Ubicacion mayor = null;
        //Variable que controla el ciclo
        int i = 0;
        //Recorre todas las posiciones del arreglo
        while (i < ubicaciones.length) {
            //Verifica que la posicion no contenga null
            if (ubicaciones[i] != null) {
                //Si todavia no existe una mayor, guarda la actual
                if (mayor == null) {
                    mayor = ubicaciones[i];
                }
                //Compara los niveles de riesgo
                else if (ubicaciones[i].getNivelRiesgo() > mayor.getNivelRiesgo()) {
                    //Guarda la nueva ubicacion de mayor riesgo
                    mayor = ubicaciones[i];
                }
            }
            //Aumenta el contador
            i = i + 1;
        }
        //Devuelve la ubicacion o null si no existen ubicaciones
        return mayor;
    }
    //Metodo que devuelve la cantidad de pistas registradas
    public int cantidadPistas() {
        return pistas.size();
    }
    //Metodo que encuentra la pista con mayor importancia
    public Pista pistaMayorImportancia() {
        //Variable que guarda la pista encontrada
        Pista mayor = null;
        //Verifica que existan pistas
        if (pistas.size() > 0) {
            //Toma la primera pista como la de mayor importancia
            mayor = pistas.get(0);
            //Comienza a revisar desde la segunda pista
            int i = 1;
            //Recorre las demas pistas
            while (i < pistas.size()) {
                //Obtiene la pista actual
                Pista actual = pistas.get(i);
                //Compara los niveles de importancia
                if (actual.getNivelImportancia() > mayor.getNivelImportancia()) {
                    //Guarda la nueva pista de mayor importancia
                    mayor = actual;
                }
                //Aumenta el contador
                i = i + 1;
            }
        }
        //Devuelve la pista o null si el ArrayList esta vacio
        return mayor;
    }
    //Metodo que encuentra la pista con mayor confiabilidad
    public Pista pistaMayorConfiabilidad() {
        //Variable que guarda la pista encontrada
        Pista mayor = null;
        //Verifica que existan pistas
        if (pistas.size() > 0) {
            //Toma la primera pista como la de mayor confiabilidad
            mayor = pistas.get(0);
            //Comienza a revisar desde la segunda pista
            int i = 1;
            //Recorre las demas pistas
            while (i < pistas.size()) {
                //Obtiene la pista actual
                Pista actual = pistas.get(i);
                //Compara los niveles de confiabilidad
                if (actual.getNivelConfiabilidad() > mayor.getNivelConfiabilidad()) {
                    //Guarda la nueva pista de mayor confiabilidad
                    mayor = actual;
                }
                //Aumenta el contador
                i = i + 1;
            }
        }

        //Devuelve la pista o null si no existen pistas
        return mayor;
    }
    //Metodo que calcula el promedio de importancia de las pistas
    public double promedioImportancia() {
        //Verifica que existan pistas registradas
        if (pistas.size() > 0) {
            //Variable que acumula los niveles de importancia
            int suma = 0;
            //Variable que controla el ciclo
            int i = 0;
            //Recorre todas las pistas
            while (i < pistas.size()) {
                //Suma la importancia de la pista actual
                suma = suma + pistas.get(i).getNivelImportancia();
                //Aumenta el contador
                i = i + 1;
            }
            //Calcula y devuelve el promedio
            return (double) suma / pistas.size();
        }
        //Si no existen pistas devuelve 0
        else {
            return 0;
        }
    }
}