-- Inserción de datos de prueba en la tabla producto
INSERT INTO producto (nombre, tipo_producto) VALUES
('Papa', 'Tubérculo'),
('Manzana', 'Fruta'),
('Leche', 'Lácteo');

-- Inserción de datos de prueba en la tabla bodega
INSERT INTO bodega (nombre_bodega, ubicacion, capacidad) VALUES
('Bodega Principal', 'Medellín, Colombia', 1000),
('Bodega Secundaria', 'Bogotá, Colombia', 800),
('Bodega de Reserva', 'Cali, Colombia', 1200);

-- Inserción de datos de prueba en la tabla puerto
INSERT INTO puerto (nombre_puerto, ubicacion, capacidad) VALUES
('Puerto de Cartagena', 'Cartagena, Colombia', 2000),
('Puerto de Buenaventura', 'Buenaventura, Colombia', 2500),
('Puerto de Barranquilla', 'Barranquilla, Colombia', 1800);
