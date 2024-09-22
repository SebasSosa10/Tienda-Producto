package EAM.TiendaProducto.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Singleton para manejar la conexión con la base de datos MySQL.
 * Esta clase garantiza que solo exista una instancia de la conexión a la base de datos
 * en todo el ciclo de vida de la aplicación.
 */
public class DataBaseSingleton {

    // Instancia única de la clase DataBaseSingleton.
    private static DataBaseSingleton instance;

    // Objeto Connection que representa la conexión con la base de datos.
    private Connection connection;

    // Librería del conector MySQL.
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos.
    private static final String DATABASE = "TiendaProducto";

    // Dirección del host donde se encuentra la base de datos.
    private static final String HOSTNAME = "localhost";

    // Puerto para la conexión a la base de datos MySQL.
    private static final String PORT = "3306";

    // Usuario de la base de datos.
    private static final String USER = "root";

    // Contraseña del usuario de la base de datos.
    private static final String PASSWORD = "root";

    // URL completa de la base de datos, se desactiva el uso de SSL con "?useSSL=false".
    private static final String DATABASE_URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE + "?useSSL=false";

    /**
     * Constructor privado para evitar que otras clases creen instancias de DataBaseSingleton.
     * Aquí se establece la conexión con la base de datos.
     */
    private DataBaseSingleton() {
        try {
            // Se establece la conexión usando la URL, usuario y contraseña.
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Se imprime el error en caso de que falle la conexión.
            e.printStackTrace();
        }
    }

    /**
     * Método estático que devuelve la instancia única de DataBaseSingleton.
     * Si no existe una instancia, se crea una nueva.
     * @return La instancia única de DataBaseSingleton.
     */
    public static DataBaseSingleton getInstance() {
        if (instance == null){
            instance = new DataBaseSingleton();
        }
        return instance;
    }

    /**
     * Obtiene la conexión activa con la base de datos.
     * @return Objeto Connection que representa la conexión.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Cierra la conexión con la base de datos si está abierta.
     */
    public void closeConnection() {
        if (connection != null){
            try {
                // Se cierra la conexión.
                connection.close();
            } catch (SQLException e) {
                // Se imprime el error en caso de que falle al cerrar la conexión.
                e.printStackTrace();
            }
        } else {
            // Si no hay conexión, se informa al usuario.
            System.out.println("No se pudo establecer la conexión con la base de datos");
        }
    }
}
