//Creacion de la tabla cliente
create table cliente (
id_cliente VARCHAR(20) PRIMARY key not null,
nombre VARCHAR(20) NOT NULL,
apellido VARCHAR(20) NOT NULL,
telefono VARCHAR(15) NOT NULL,
direccion VARCHAR (50) NOT NULL
);

//Creacion de la tabla producto
create table producto (
id_producto SERIAL PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
tipo_producto VARCHAR(50) NOT NULL
);

//Creacion de la tabla bodega
create table bodega(
id_bodega SERIAL PRIMARY KEY,
nombre_bodega VARCHAR(50) NOT NULL,
ubicacion VARCHAR(100) NOT NULL,
capacidad INT NOT NULL
);
//Creacion de la tabla puerto
create table puerto(
id_puerto SERIAL PRIMARY KEY,
nombre_puerto VARCHAR(50) NOT NULL,
ubicacion VARCHAR(100) NOT NULL,
capacidad INT NOT NULL
);

//Creacion de la tabla envio_terrestre
create table envio_terrestre(
id_envio SERIAL PRIMARY KEY,
placa_vehiculo VARCHAR(10) NOT NULL,
bodega_entrega INT,
id_cliente VARCHAR(20) NOT NULL,
cantidad_producto INT NOT NULL,
fecha_entrega TIMESTAMP NOT NULL,
precio_envio DECIMAL(10,2) NOT NULL,
fecha_registro TIMESTAMP NOT NULL,
numero_guia VARCHAR(10) NOT NULL,
tipo_producto INT NOT NULL,
price_total decimal (10,2),
descuento decimal (10, 2),
FOREIGN KEY (bodega_entrega) REFERENCES bodega (id_bodega)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
FOREIGN KEY (tipo_producto) REFERENCES producto(id_producto)
	ON DELETE NO ACTION
    ON UPDATE NO ACTION,
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION,

);
//Creacion de la tabla envio_maritimo
create table envio_maritimo(
id_envio SERIAL PRIMARY KEY,
numero_flota VARCHAR(10) NOT NULL,
puerto_entrega INT,
id_cliente VARCHAR(20) NOT NULL,
cantidad_producto INT NOT NULL,
fecha_entrega TIMESTAMP NOT NULL,
precio_envio DECIMAL(10,2) NOT NULL,
fecha_registro TIMESTAMP NOT NULL,
numero_guia VARCHAR(10) NOT NULL,
tipo_producto INT NOT NULL,
precio_total decimal (10,2),
descuento decimal (10, 2),
FOREIGN KEY (puerto_entrega) REFERENCES puerto (id_puerto)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
FOREIGN KEY (tipo_producto) REFERENCES producto(id_producto)
	ON DELETE NO ACTION
    ON UPDATE NO ACTION,
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
);

/Seguriidad
//Creacion de la tabla usuario
create table usuario (

nombre_usuario VARCHAR(30) NOT NULL PRIMARY KEY,
contrasena VARCHAR (100) NOT NULL,
correo VARCHAR(50) NOT NULL,
habilidato Boolean NOT NULL,
bloquedo Boolean NOT NULL,
);
//Creacionnde la tabla de roles
CREATE TABLE role (
    nombre_usuario VARCHAR(30) NOT NULL,
    role VARCHAR(20) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    PRIMARY KEY (nombre_usuario, role),
    FOREIGN KEY (nombre_usuario) REFERENCES usuario (nombre_usuario)
);