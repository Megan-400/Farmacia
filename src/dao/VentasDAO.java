package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Ventas;

/**
 *
 * @author Cassandra
 */
public class VentasDAO
{
    public static boolean insertarVentas(Ventas venta)
    {
        String sql = "INSERT INTO Ventas (id_venta, id_producto, id_vendedor, id_cliente, id_pago, fecha_compra) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, venta.getId_venta());
            pstmt.setInt(2, venta.getId_producto());
            pstmt.setInt(3, venta.getId_vendedor());
            pstmt.setInt(4, venta.getId_cliente());
            pstmt.setInt(5, venta.getId_pago());
            pstmt.setDate(6, (Date) venta.getFecha_compra());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar el producto: " + e.getMessage());
            return false;
        }
    }
}
