CREATE DATABASE Farmacia;

USE Farmacia;

DROP DATABASE Farmacia;
Select * From Producto;

-- Tabla Cliente
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(15),
    edad INT
);

-- Tabla Producto
CREATE TABLE Producto (
    id_producto INT PRIMARY KEY,
    nombre VARCHAR(150),
    fecha_vencimiento DATE,
    via_admin VARCHAR(50),
    reg_sanitario VARCHAR(50),
    efectos_sec TEXT,
    advertencia TEXT,
    cant_almacen INT
);

-- Tabla Vendedor
CREATE TABLE Vendedor (
    id_vendedor INT PRIMARY KEY,
    nombre VARCHAR(100),
    domicilio VARCHAR(255),
    usuario VARCHAR(50),
    contrasenia VARCHAR(255),
    telefono VARCHAR(50),
    puesto VARCHAR(50)
);

-- Tabla Metodo_Pago
CREATE TABLE Metodo_Pago (
    id_pago INT PRIMARY KEY,
    tipo_pago VARCHAR(50)
);

-- Tabla Ventas_1
CREATE TABLE Ventas (
    id_venta INT PRIMARY KEY,
    id_producto INT,
    id_vendedor INT,
    id_cliente INT,
    id_pago INT,
    fecha DATE,
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
    FOREIGN KEY (id_vendedor) REFERENCES Vendedor(id_vendedor),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_pago) REFERENCES Metodo_Pago(id_pago)
);

-- Tabla Detalle_Venta
CREATE TABLE Detalle_Venta (
    id_detalle INT PRIMARY KEY,
    id_venta INT,
    id_producto INT,
    cantidad INT,
    precio_unitario DECIMAL(10,2),
    FOREIGN KEY (id_venta) REFERENCES Ventas(id_venta),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);
