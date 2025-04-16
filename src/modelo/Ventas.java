package modelo;

import java.util.Date;

/**
 *
 * @author Cassandra
 */
public class Ventas
{
    private int id_venta;
    private int id_producto;
    private int id_vendedor;
    private int id_cliente;
    private int id_pago;
    private Date fecha_compra;

    public Ventas()
    {
    }

    public Ventas(int id_venta, int id_producto, int id_vendedor, int id_cliente, int id_pago, Date fecha_compra)
    {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.id_vendedor = id_vendedor;
        this.id_cliente = id_cliente;
        this.id_pago = id_pago;
        this.fecha_compra = fecha_compra;
    }

    /**
     * @return the id_venta
     */
    public int getId_venta()
    {
        return id_venta;
    }

    /**
     * @param id_venta the id_venta to set
     */
    public void setId_venta(int id_venta)
    {
        this.id_venta = id_venta;
    }

    /**
     * @return the id_producto
     */
    public int getId_producto()
    {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto)
    {
        this.id_producto = id_producto;
    }

    /**
     * @return the id_vendedor
     */
    public int getId_vendedor()
    {
        return id_vendedor;
    }

    /**
     * @param id_vendedor the id_vendedor to set
     */
    public void setId_vendedor(int id_vendedor)
    {
        this.id_vendedor = id_vendedor;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente()
    {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente)
    {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_pago
     */
    public int getId_pago()
    {
        return id_pago;
    }

    /**
     * @param id_pago the id_pago to set
     */
    public void setId_pago(int id_pago)
    {
        this.id_pago = id_pago;
    }

    /**
     * @return the fecha_compra
     */
    public Date getFecha_compra()
    {
        return fecha_compra;
    }

    /**
     * @param fecha_compra the fecha_compra to set
     */
    public void setFecha_compra(Date fecha_compra)
    {
        this.fecha_compra = fecha_compra;
    }
    
    
}
