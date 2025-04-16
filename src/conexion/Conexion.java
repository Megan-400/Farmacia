package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cassandra
 */
public class Conexion
{

    private static final String url = "jdbc:mysql://localhost:3306/Farmacia";
    private static final String usuario = "root";
    private static final String contraseña = "M22L10J08*e";

    public static Connection conectar()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e)
        {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
        return connection;
    }
}
