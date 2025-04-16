package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Detalle_Venta;

/**
 *
 * @author Cassandra
 */
public class Detalle_VentaDAO
{
    public static boolean insertarDetalle_Venta(Detalle_Venta detalle_Venta)
    {
        String sql = "INSERT INTO Detalle_Venta (id_detalle, id_venta, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, detalle_Venta.getId_detalle());
            pstmt.setInt(2, detalle_Venta.getId_venta());
            pstmt.setInt(3, detalle_Venta.getId_producto());
            pstmt.setInt(4, detalle_Venta.getCantidad());
            pstmt.setDouble(5, detalle_Venta.getPrecio_unitario());

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
