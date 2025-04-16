package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Metodo_Pago;

/**
 *
 * @author Cassandra
 */
public class Metodo_PagoDAO
{
    public static boolean insertarMetodo_Pago(Metodo_Pago metodo_Pago)
    {
        String sql = "INSERT INTO Metodo_Pago (id_pago, tipo_pago) VALUES (?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, metodo_Pago.getId_pago());
            pstmt.setString(2, metodo_Pago.getTipo_pago());            

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar al cliente: " + e.getMessage());
            return false;
        }
    }
}
