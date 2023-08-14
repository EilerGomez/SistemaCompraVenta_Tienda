DROP DATABASE IF EXISTS Tienda;
CREATE DATABASE Tienda;
USE Tienda;

CREATE TABLE clientes(
id 	INT NOT NULL AUTO_INCREMENT,
telefono INT(8) NOT NULL,
nombre VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE facturas (
id INT NOT NULL AUTO_INCREMENT,
fecha DATETIME NOT NULL,
id_cliente INT NOT NULL,
total BOOLEAN NOT NULL,
PRIMARY KEY(id),
CONSTRAINT factura_id_cliente_fk
FOREIGN KEY (id_cliente)
REFERENCES clientes(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);

CREATE TABLE productos(
id INT NOT NULL AUTO_INCREMENT,
codigo INT NOT NULL,
nombre VARCHAR(40) NOT NULL,
precio BOOLEAN NOT NULL,
cantidad INT NOT NULL,
PRIMARY KEY(id,codigo)
);

CREATE TABLE proveedores(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
telefono INT(8) NOT NULL,
direccion VARCHAR(30),
ciudad VARCHAR(20),
email VARCHAR(50),
apuntes VARCHAR(150),
PRIMARY KEY(id,telefono)
);

CREATE TABLE prod_proveedor(
id INT NOT NULL AUTO_INCREMENT,
id_producto INT NOT NULL,
id_proveedor INT NOT NULL,
PRIMARY KEY(id),
CONSTRAINT id_producto_proveedor_fk
FOREIGN KEY (id_producto)
REFERENCES productos(id)
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT id_proveedor_producto_fk
FOREIGN KEY (id_proveedor)
REFERENCES proveedores(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);

CREATE TABLE ventas(
id INT NOT NULL AUTO_INCREMENT,
id_factura INT NOT NULL,
codigo_producto INT NOT NULL,
cantidad INT NOT NULL,
subtotal DOUBLE,
PRIMARY KEY(id),
CONSTRAINT venta_id_factura_fk
FOREIGN KEY (id_factura)
REFERENCES facturas(id)
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT codigo_producto_venta_fk
FOREIGN KEY (codigo_producto)
REFERENCES productos(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);

/*aqui empieza el mapeo físico de la creación del nuevo usuario*/
CREATE USER 'proyectoTienda'@'localhost' IDENTIFIED BY 'eiler123';
GRANT SELECT ON Tienda.* TO 'proyectoTienda'@'localhost';
GRANT DELETE ON Tienda.* TO 'proyectoTienda'@'localhost';
GRANT UPDATE ON Tienda.* TO 'proyectoTienda'@'localhost';
GRANT INSERT ON Tienda.* TO 'proyectoTienda'@'localhost';
/* EL PUERTO TIENE QUE SER: 3306*/

USE Tienda;