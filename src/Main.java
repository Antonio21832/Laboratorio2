import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
//Antnio Molina 26878
//Clase principal del programa
public class Main {
    //Scanner que permite leer los datos ingresados por el usuario
    private static Scanner teclado = new Scanner(System.in);
    //Objeto que representa el caso actual
    private static Caso caso = null;
    //Metodo principal donde inicia la ejecucion del programa
    public static void main(String[] args) {
        //Solicita la informacion del caso al iniciar
        nuevoCaso();
        //Variable que guarda la opcion seleccionada
        int opcion = 0;
        //Mantiene el menu activo hasta seleccionar salir
        while (opcion != 13) {
            //Muestra el menu principal
            System.out.println("AGENCIA DE DETECTIVES");
            System.out.println("CASO: " + caso.getNombreCaso());
            System.out.println("1. Nuevo caso");
            System.out.println("2. Registrar ubicacion");
            System.out.println("3. Consultar ubicaciones");
            System.out.println("4. Consultar una ubicacion");
            System.out.println("5. Modificar ubicacion");
            System.out.println("6. Descartar ubicacion");
            System.out.println("7. Registrar pista");
            System.out.println("8. Consultar pistas");
            System.out.println("9. Buscar pista");
            System.out.println("10. Modificar pista");
            System.out.println("11. Eliminar pista");
            System.out.println("12. Mostrar reporte de investigacion");
            System.out.println("13. Salir");
         try {
                //Solicita una opcion
                System.out.print("Seleccione una opcion: ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                //Ejecuta la opcion seleccionada
                if (opcion == 1) {
                    nuevoCaso();
                }
                else if (opcion == 2) {
                    registrarUbicacion();
                }
                else if (opcion == 3) {
                    consultarUbicaciones();
                }
                else if (opcion == 4) {
                    consultarUbicacion();
                }
                else if (opcion == 5) {
                    modificarUbicacion();
                }
                else if (opcion == 6) {
                    descartarUbicacion();
                }
                else if (opcion == 7) {
                    registrarPista();
                }
                else if (opcion == 8) {
                    consultarPistas();
                }
                else if (opcion == 9) {
                    buscarPista();
                }
                else if (opcion == 10) {
                    modificarPista();
                }
                else if (opcion == 11) {
                    eliminarPista();
                }
                else if (opcion == 12) {
                    mostrarReporte();
                }
                else if (opcion == 13) {
                    System.out.println("Programa finalizado.");
                }
                else {
                    System.out.println("Opcion no valida.");
                }
            }
            //Controla cuando se ingresa texto en lugar de un numero
            catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numerico.");
                //Limpia la entrada incorrecta
                teclado.nextLine();
            }
        }
    }
    //Metodo que crea un nuevo caso
    public static void nuevoCaso() {
        //Solicita el nombre del caso
        System.out.print("Ingrese el nombre del caso: ");
        String nombre = teclado.nextLine();
        //Solicita el codigo
        System.out.print("Ingrese el codigo de identificacion: ");
        String codigo = teclado.nextLine();
        //Solicita el detective responsable
        System.out.print("Ingrese el detective responsable: ");
        String detective = teclado.nextLine();
        //Crea un nuevo caso
        //Las ubicaciones y pistas comienzan vacias
        caso = new Caso(nombre, codigo, detective);
        System.out.println("Caso creado correctamente.");
    }
    //Metodo que registra una nueva ubicacion
    public static void registrarUbicacion() {
        try {
            //Solicita la posicion
            System.out.print("Ingrese la posicion del arreglo (0-4): ");
            int posicion = teclado.nextInt();
            teclado.nextLine();
            //Valida que la posicion exista
            if (posicion < 0 || posicion >= 5) {
                System.out.println("La posicion debe estar entre 0 y 4.");
                return;
            }
            //Verifica que la posicion se encuentre disponible
            if (caso.obtenerUbicacion(posicion) != null) {
                System.out.println("La posicion ya contiene una ubicacion.");
                return;
            }
            //Solicita el codigo
            System.out.print("Ingrese el codigo: ");
            String codigo = teclado.nextLine();
            //Solicita el nombre
            System.out.print("Ingrese el nombre: ");
            String nombre = teclado.nextLine();
            //Solicita la direccion
            System.out.print("Ingrese la direccion o descripcion: ");
            String direccion = teclado.nextLine();
            //Solicita el nivel de riesgo
            System.out.print("Ingrese el nivel de riesgo (1-10): ");
            int riesgo = teclado.nextInt();
            teclado.nextLine();
            //Solicita el estado
            System.out.print("Ingrese el estado: ");
            String estado = teclado.nextLine();
            //Crea la ubicacion
            //El constructor valida el nivel de riesgo
            Ubicacion ubicacion = new Ubicacion(codigo,nombre,direccion,riesgo,estado);
            //Registra la ubicacion
            boolean registrada = caso.registrarUbicacion(posicion, ubicacion);
            if (registrada == true) {
                System.out.println("Ubicacion registrada correctamente.");
            }
            else {
                System.out.println("No se pudo registrar la ubicacion.");
            }
        }
        //Controla entradas numericas incorrectas
        catch (InputMismatchException e) {
            System.out.println("Se ingreso un dato numerico incorrecto.");
            teclado.nextLine();
        }
        //Controla un nivel de riesgo invalido
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //Este bloque se ejecuta siempre
        finally {
            System.out.println("Proceso de registro de ubicacion finalizado.");
        }
    }
    //Metodo que muestra todas las ubicaciones registradas
    public static void consultarUbicaciones() {
        //Obtiene el arreglo
        Ubicacion[] ubicaciones = caso.getUbicaciones();
        //Variable que indica si se encontro alguna ubicacion
        boolean encontrada = false;
        //Variable que controla el ciclo
        int i = 0;
        //Recorre las cinco posiciones
        while (i < ubicaciones.length) {
            //Verifica que la posicion no contenga null
            if (ubicaciones[i] != null) {
                encontrada = true;
                System.out.println("Posicion del arreglo: " + i);
                mostrarUbicacion(ubicaciones[i]);
            }
            i = i + 1;
        }
        //Se ejecuta si todas las posiciones contienen null
        if (encontrada == false) {
            System.out.println("No hay ubicaciones registradas.");
        }
    }
    //Metodo que consulta una ubicacion especifica
    public static void consultarUbicacion() {
        try {
            //Solicita la posicion
            System.out.print(
"Ingrese la posicion del arreglo (0-4): ");
            int posicion = teclado.nextInt();
            teclado.nextLine();
            //Valida los limites
            if (posicion < 0 || posicion >= 5) {
                System.out.println("Posicion no valida.");
                return;
            }
            //Obtiene la ubicacion
            Ubicacion ubicacion = caso.obtenerUbicacion(posicion);
            //Verifica si la posicion esta vacia
            if (ubicacion == null) {
                System.out.println("La posicion se encuentra vacia.");
            }
            else {
                mostrarUbicacion(ubicacion);
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Debe ingresar una posicion numerica.");
            teclado.nextLine();
        }
    }
    //Metodo que modifica una ubicacion
    public static void modificarUbicacion() {
        try {
            //Solicita la posicion
            System.out.print("Ingrese la posicion de la ubicacion: ");
            int posicion = teclado.nextInt();
            teclado.nextLine();
            //Valida la posicion
            if (posicion < 0 || posicion >= 5) {
                System.out.println("Posicion no valida.");
                return;
            }
            //Verifica que exista una ubicacion
            if (caso.obtenerUbicacion(posicion) == null) {
                System.out.println("No existe una ubicacion en esa posicion.");
                return;
            }
            //Solicita el nuevo riesgo
            System.out.print("Ingrese el nuevo nivel de riesgo (1-10): ");
            int riesgo = teclado.nextInt();
            teclado.nextLine();
            //Solicita el nuevo estado
            System.out.print("Ingrese el nuevo estado: ");
            String estado = teclado.nextLine();
            //Intenta modificar la ubicacion
            boolean modificada = caso.modificarUbicacion(posicion, riesgo, estado);
            if (modificada == true) {
                System.out.println("Ubicacion modificada correctamente.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Se ingreso un dato numerico incorrecto.");
            teclado.nextLine();
        }
        //El setter de riesgo puede generar esta excepcion
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    //Metodo que descarta una ubicacion
    public static void descartarUbicacion() {
        try {
            //Solicita la posicion
            System.out.print("Ingrese la posicion de la ubicacion: ");
            int posicion = teclado.nextInt();
            teclado.nextLine();
            //Valida los limites
            if (posicion < 0 || posicion >= 5) {
                System.out.println("Posicion no valida.");
                return;
            }
            //Intenta descartar la ubicacion
            boolean descartada =
                    caso.descartarUbicacion(posicion);
            if (descartada == true) {
                System.out.println("Ubicacion descartada correctamente.");
            }
            else {
                System.out.println("La posicion se encuentra vacia.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Debe ingresar una posicion numerica.");
            teclado.nextLine();
        }
    }
    //Metodo que registra una nueva pista
    public static void registrarPista() {
        try {
            //Solicita el codigo
            System.out.print("Ingrese el codigo de la pista: ");
            String codigo = teclado.nextLine();
            //Verifica que el codigo no este repetido
            if (caso.buscarPista(codigo) != null) {
                System.out.println("Ya existe una pista con ese codigo.");
                return;
            }
            //Solicita la descripcion
            System.out.print("Ingrese la descripcion: ");
            String descripcion = teclado.nextLine();
            //Solicita el tipo de evidencia
            System.out.print("Ingrese el tipo de evidencia: ");
            String tipo = teclado.nextLine();
            //Solicita la importancia
            System.out.print("Ingrese el nivel de importancia (1-10): ");
            int importancia = teclado.nextInt();
            //Solicita la confiabilidad
            System.out.print("Ingrese el nivel de confiabilidad (0-100): ");
            int confiabilidad = teclado.nextInt();
            teclado.nextLine();
            //Crea la pista
            //El constructor valida los niveles
            Pista pista = new Pista(codigo,descripcion,tipo,importancia,confiabilidad);
            //Registra la pista
            boolean registrada = caso.registrarPista(pista);
            if (registrada == true) {
                System.out.println("Pista registrada correctamente.");
            }
            else {
                System.out.println("No se pudo registrar la pista.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Se ingreso un dato numerico incorrecto.");
            teclado.nextLine();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    //Metodo que muestra todas las pistas
    public static void consultarPistas() {
        //Obtiene el ArrayList
        ArrayList<Pista> pistas = caso.getPistas();
        //Verifica que existan pistas
        if (pistas.size() > 0) {
            int i = 0;
            //Recorre todas las pistas
            while (i < pistas.size()) {
                mostrarPista(pistas.get(i));
                i = i + 1;
            }
        }
        else {
            System.out.println("No hay pistas registradas.");
        }
    }
    //Metodo que busca una pista por su codigo
    public static void buscarPista() {
        //Solicita el codigo
        System.out.print("Ingrese el codigo de la pista: ");
        String codigo = teclado.nextLine();
        //Busca la pista
        Pista pista = caso.buscarPista(codigo);
        //Verifica si existe
        if (pista != null) {
            mostrarPista(pista);
        }
        else {
            System.out.println("La pista no se encuentra registrada.");
        }
    }
    //Metodo que modifica una pista
    public static void modificarPista() {
        try {
            //Solicita el codigo
            System.out.print("Ingrese el codigo de la pista: ");
            String codigo = teclado.nextLine();
            //Verifica que exista
            if (caso.buscarPista(codigo) == null) {
                System.out.println("La pista no se encuentra registrada.");
                return;
            }
            //Solicita la nueva descripcion
            System.out.print("Ingrese la nueva descripcion: ");
            String descripcion = teclado.nextLine();
            //Solicita el nuevo tipo
            System.out.print("Ingrese el nuevo tipo de evidencia: ");
            String tipo = teclado.nextLine();
            //Solicita la nueva importancia
            System.out.print("Ingrese el nuevo nivel de importancia (1-10): ");
            int importancia = teclado.nextInt();
            //Solicita la nueva confiabilidad
            System.out.print("Ingrese el nuevo nivel de confiabilidad (0-100): ");
            int confiabilidad = teclado.nextInt();
            teclado.nextLine();
            //Modifica la pista
            boolean modificada =
                    caso.modificarPista(codigo,descripcion,tipo,importancia,confiabilidad);
            if (modificada == true) {
                System.out.println("Pista modificada correctamente.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Se ingreso un dato numerico incorrecto.");
            teclado.nextLine();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    //Metodo que elimina una pista
    public static void eliminarPista() {
        //Solicita el codigo
        System.out.print("Ingrese el codigo de la pista: ");
        String codigo = teclado.nextLine();
        //Intenta eliminar la pista
        boolean eliminada = caso.eliminarPista(codigo);
        if (eliminada == true) {
            System.out.println("Pista eliminada correctamente.");
        }
        else {
            System.out.println("La pista no se encuentra registrada.");
        }
    }
    //Metodo que muestra el reporte de investigacion
    public static void mostrarReporte() {
        //Muestra la informacion general del caso
        System.out.println("REPORTE DE INVESTIGACION");
        System.out.println("Caso: " + caso.getNombreCaso());
        System.out.println("Codigo: " + caso.getCodigoIdentificacion());
        System.out.println("Detective: " + caso.getDetectiveResponsable());
        //Muestra informacion de las ubicaciones
        System.out.println("Ubicaciones registradas: " + caso.cantidadUbicaciones());
        System.out.println("Espacios disponibles: " + caso.espaciosDisponibles());
        //Obtiene la ubicacion de mayor riesgo
        Ubicacion mayorRiesgo = caso.ubicacionMayorRiesgo();
        //Verifica que exista una ubicacion
        if (mayorRiesgo != null) {
            System.out.println("Ubicacion con mayor riesgo:");
            mostrarUbicacion(mayorRiesgo);
        }
        else {
            System.out.println("No hay ubicaciones para calcular el mayor riesgo.");
        }
        //Muestra la cantidad de pistas
        System.out.println("Pistas registradas: " + caso.cantidadPistas());
        //Verifica que existan pistas
        if (caso.cantidadPistas() > 0) {
            //Obtiene la pista de mayor importancia
            Pista mayorImportancia = caso.pistaMayorImportancia();
            //Obtiene la pista de mayor confiabilidad
            Pista mayorConfiabilidad = caso.pistaMayorConfiabilidad();
            System.out.println("Pista con mayor importancia:");
            mostrarPista(mayorImportancia);
            System.out.println("Pista con mayor confiabilidad:");
            mostrarPista(mayorConfiabilidad);
            //Muestra el promedio de importancia
            System.out.println("Promedio del nivel de importancia: " + caso.promedioImportancia());
        }
        else {
            System.out.println("No hay pistas para realizar los calculos.");
        }
    }
    //Metodo auxiliar que muestra una ubicacion
    public static void mostrarUbicacion(Ubicacion ubicacion) {
        System.out.println("Codigo: " + ubicacion.getCodigo());
        System.out.println("Nombre: " + ubicacion.getNombre());
        System.out.println("Direccion: " + ubicacion.getDireccion());
        System.out.println("Nivel de riesgo: " + ubicacion.getNivelRiesgo());
        System.out.println("Estado: " + ubicacion.getEstado());
    }
    //Metodo auxiliar que muestra una pista
    public static void mostrarPista(Pista pista) {
        System.out.println("Codigo: " + pista.getCodigo());
        System.out.println("Descripcion: " + pista.getDescripcion());
        System.out.println("Tipo de evidencia: " + pista.getTipoEvidencia());
        System.out.println("Nivel de importancia: " + pista.getNivelImportancia());
        System.out.println("Nivel de confiabilidad: " + pista.getNivelConfiabilidad());
    }
}