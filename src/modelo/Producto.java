package modelo;

import java.util.Date;

/**
 *
 * @author Cassandra
 */
public class Producto
{
    private int id_producto;
    private String nombre;
    private Date fecha_vencimiento;
    private String via_admin;
    private String reg_sanitario;
    private String efectos_sec;
    private String advertencia;
    private int cant_almacen;

    public Producto()
    {
    }

    public Producto(int id_producto, String nombre, Date fecha_vencimiento, String via_admin, String reg_sanitario, String efectos_sec, String advertencia, int cant_almacen)
    {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.fecha_vencimiento = fecha_vencimiento;
        this.via_admin = via_admin;
        this.reg_sanitario = reg_sanitario;
        this.efectos_sec = efectos_sec;
        this.advertencia = advertencia;
        this.cant_almacen = cant_almacen;
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
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the via_admin
     */
    public String getVia_admin()
    {
        return via_admin;
    }

    /**
     * @param via_admin the via_admin to set
     */
    public void setVia_admin(String via_admin)
    {
        this.via_admin = via_admin;
    }

    /**
     * @return the reg_sanitario
     */
    public String getReg_sanitario()
    {
        return reg_sanitario;
    }

    /**
     * @param reg_sanitario the reg_sanitario to set
     */
    public void setReg_sanitario(String reg_sanitario)
    {
        this.reg_sanitario = reg_sanitario;
    }

    /**
     * @return the efectos_sec
     */
    public String getEfectos_sec()
    {
        return efectos_sec;
    }

    /**
     * @param efectos_sec the efectos_sec to set
     */
    public void setEfectos_sec(String efectos_sec)
    {
        this.efectos_sec = efectos_sec;
    }

    /**
     * @return the advertencia
     */
    public String getAdvertencia()
    {
        return advertencia;
    }

    /**
     * @param advertencia the advertencia to set
     */
    public void setAdvertencia(String advertencia)
    {
        this.advertencia = advertencia;
    }

    /**
     * @return the cant_almacen
     */
    public int getCant_almacen()
    {
        return cant_almacen;
    }

    /**
     * @param cant_almacen the cant_almacen to set
     */
    public void setCant_almacen(int cant_almacen)
    {
        this.cant_almacen = cant_almacen;
    }

    /**
     * @return the fecha_vencimiento
     */
    public Date getFecha_vencimiento()
    {
        return fecha_vencimiento;
    }

    /**
     * @param fecha_vencimiento the fecha_vencimiento to set
     */
    public void setFecha_vencimiento(Date fecha_vencimiento)
    {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    
    
}
