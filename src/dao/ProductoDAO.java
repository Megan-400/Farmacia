package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Producto;

/**
 *
 * @author Cassandra
 */
public class ProductoDAO
{

    public static boolean insertarProducto(Producto producto)
    {
        String sql = "INSERT INTO Producto (id_producto, nombre, fecha_vencimiento, via_admin, reg_sanitario, efectos_sec, advertencia, cant_almacen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, producto.getId_producto());
            pstmt.setString(2, producto.getNombre());
            pstmt.setDate(3, (Date) producto.getFecha_vencimiento());
            pstmt.setString(4, producto.getVia_admin());
            pstmt.setString(5, producto.getReg_sanitario());
            pstmt.setString(6, producto.getEfectos_sec());
            pstmt.setString(7, producto.getAdvertencia());
            pstmt.setInt(8, producto.getCant_almacen());

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
