package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Vendedor;

/**
 *
 * @author Cassandra
 */
public class VendedorDAO
{
    public static boolean insertarVendedor(Vendedor vendedor)
    {
        String sql = "INSERT INTO Vendedor (id_vendedor, nombre, domicilio, usuario, contrasenia, telefono, puesto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, vendedor.getId_vendedor());
            pstmt.setString(2, vendedor.getNombre());
            pstmt.setString(3, vendedor.getDomicilio());
            pstmt.setString(4, vendedor.getUsuario());
            pstmt.setString(5, vendedor.getContrasenia());
            pstmt.setString(5, vendedor.getTelefono());
            pstmt.setInt(5, vendedor.getPuesto());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar al cliente: " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizarVendedor(Vendedor vendedor)
    {
        String sql = "UPDATE Cliente SET nombre = ?, domicilio = ?, usuario = ?, contrasenia = ?, telefono = ?, puesto = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            pstmt.setString(1, vendedor.getNombre());
            pstmt.setString(2, vendedor.getDomicilio());
            pstmt.setString(3, vendedor.getUsuario());
            pstmt.setString(4, vendedor.getContrasenia());
            pstmt.setString(5, vendedor.getTelefono());
            pstmt.setInt(6, vendedor.getPuesto());

            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (Exception e)
        {
            System.out.println("Error al modificar los datos del cliente");
            return false;
        }
    }
    
    public void eliminarVendedor(int idVendedor)
    {
        String sql = "DELETE FROM Vendedor WHERE id_vendedor = ?";
        
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            pstmt.setInt(1, idVendedor);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Vendedor eliminado con exito.");
            } else
            {
                System.out.println("No se encontró el vendedor con el ID especificado.");
            }
        } catch (Exception e)
        {
            System.err.println("Error al eliminar al vendedor" + e.getMessage());
        }
    }

    public static List<Vendedor> listarVendedor()
    {
        List<Vendedor> listaVendedor = new ArrayList<>();
        String sql = "SELECT * FROM Vendedor";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next())
            {
                Vendedor vendedor = new Vendedor(
                        rs.getInt("id_vendedor"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("usuario"),
                        rs.getString("contrasenia"),
                        rs.getString("telefono"),
                        rs.getInt("puesto")
                );

                listaVendedor.add(vendedor);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar vendedor: " + e.getMessage());
        }
        return listaVendedor;
    }
}
