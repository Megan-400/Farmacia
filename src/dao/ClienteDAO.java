package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Cliente;

/**
 *
 * @author Cassandra
 */
public class ClienteDAO
{

    public static boolean insertarCliente(Cliente cliente)
    {
        String sql = "INSERT INTO Cliente (id_cliente, nombre, direccion, telefono, edad) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, cliente.getId_cliente());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getDireccion());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setInt(5, cliente.getEdad());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.err.println("Error al agregar al cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarCliente(Cliente cliente)
    {
        String sql = "UPDATE Cliente SET nombre = ?, direccion = ?, telefono = ?, edad = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(1, cliente.getDireccion());
            pstmt.setString(1, cliente.getTelefono());
            pstmt.setInt(1, cliente.getEdad());

            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (Exception e)
        {
            System.out.println("Error al modificar los datos del cliente");
            return false;
        }
    }
    
    public void eliminarCliente(int idCliente)
    {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            pstmt.setInt(1, idCliente);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Cliente eliminado con exito.");
            } else
            {
                System.out.println("No se encontró el cliente con el ID especificado.");
            }
        } catch (Exception e)
        {
            System.err.println("Error al eliminar al cliente" + e.getMessage());
        }
    }

    public static List<Cliente> listarCliente()
    {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next())
            {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getInt("edad")
                );

                listaCliente.add(cliente);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return listaCliente;
    }
    
    
}
