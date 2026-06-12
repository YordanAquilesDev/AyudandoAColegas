DROP DATABASE IF EXISTS empresa_muebles;
CREATE DATABASE empresa_muebles;
USE empresa_muebles;

-- =======================================================
-- 1. DATOS DE LA EMPRESA (Se usará para la factura)
-- =======================================================
CREATE TABLE datos_empresa (
                               id_empresa INT PRIMARY KEY AUTO_INCREMENT,
                               nombre_empresa VARCHAR(60),
                               ruc VARCHAR(11),
                               razon_social VARCHAR(50),
                               direccion VARCHAR(40),
                               telefono VARCHAR(9),
                               correo VARCHAR(40)
);

INSERT INTO datos_empresa (nombre_empresa, ruc, razon_social, direccion, telefono, correo) VALUES
    ('Hogar & Espacios S.A.C.', '20601234567', 'HOGAR Y ESPACIOS PERU S.A.C.', 'Av. Alfredo Mendiola 4500, Los Olivos', '987654321', 'contacto@hogaryespacios.com');

-- =======================================================
-- 2. CLIENTES (Se usará para la factura)
-- =======================================================
CREATE TABLE clientes (
                          id_cliente INT PRIMARY KEY AUTO_INCREMENT,
                          nombre VARCHAR(50),
                          dni VARCHAR(8)
);

INSERT INTO clientes (nombre, dni) VALUES
                                       ('Juan Pérez Gómez', '45781234'),
                                       ('María Rodriguez Flores', '70124589'),
                                       ('Carlos Mendoza Luna', '10457823');

-- =======================================================
-- 3. CATEGORIAS
-- =======================================================
CREATE TABLE categorias (
                            id_categoria INT PRIMARY KEY AUTO_INCREMENT,
                            nombre_categoria VARCHAR(60)
);

INSERT INTO categorias (nombre_categoria) VALUES
                                              ('Salas de Estar'),
                                              ('Comedores'),
                                              ('Dormitorios'),
                                              ('Oficina');

-- =======================================================
-- 4. OFERTAS
-- =======================================================
CREATE TABLE ofertas (
                         id_oferta INT PRIMARY KEY AUTO_INCREMENT,
                         precio_oferta DECIMAL(10,2) -- Cambiado de DOUBLE a DECIMAL para consistencia con montos monetarios
);

INSERT INTO ofertas (precio_oferta) VALUES
                                        (2699.00), -- Combo Sala Ideal
                                        (1000.00); -- Combo Home Office

-- =======================================================
-- 5. PRODUCTOS
-- =======================================================
CREATE TABLE productos (
                           id_producto INT PRIMARY KEY AUTO_INCREMENT,
                           descripcion VARCHAR(70),
                           precio DECIMAL(10,2), -- Cambiado a DECIMAL para evitar pérdida de precisión monetaria
                           id_categoria INT,
                           cantidad INT,
                           imagen_referencia TEXT,
                           FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

INSERT INTO productos (descripcion, precio, id_categoria, cantidad, imagen_referencia) VALUES
-- Salas
('Sofá Seccional Premium Tela Gris', 2499.00, 1, 10, 'https://images.unsplash.com/photo-1555041469-a586c61ea9bc?q=80&w=600'),
('Sillón Velvet Azul Nórdico', 850.00, 1, 15, 'https://images.unsplash.com/photo-1592078615290-033ee584e267?q=80&w=600'),
('Mesa de Centro Industrial Fierro y Madera', 450.00, 1, 8, 'https://images.unsplash.com/photo-1533090161767-e6ffed986c88?q=80&w=600'),
-- Comedores
('Mesa de Comedor Extensible Madera Roble', 1850.00, 2, 5, 'https://images.unsplash.com/photo-1577140917170-285929fb55b7?q=80&w=600'),
('Set x4 Sillas Eames Blancas', 399.00, 2, 20, 'https://images.unsplash.com/photo-1567538096630-e0c55bd6374c?q=80&w=600'),
-- Dormitorios
('Cama Queen Size con Cabecera Tapizada', 3120.00, 3, 4, 'https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?q=80&w=600'),
('Ropero Closet 6 Puertas Melamina Color Cedro', 1200.00, 3, 7, 'https://images.unsplash.com/photo-1595428774223-ef52624120d2?q=80&w=600'),
-- Oficina
('Escritorio Minimalista L-Shape Vidrio Templado', 650.00, 4, 12, 'https://images.unsplash.com/photo-1524758631624-e2822e304c36?q=80&w=600'),
('Silla Ergonómica Ejecutiva con Soporte Lumbar', 520.00, 4, 25, 'https://images.unsplash.com/photo-1580481072988-1ef3405ba0a3?q=80&w=600');

-- =======================================================
-- 6. FACTURA
-- =======================================================
CREATE TABLE factura (
                         id_factura INT PRIMARY KEY AUTO_INCREMENT,
                         id_cliente INT,
                         id_empresa INT,
                         monto DECIMAL(10,2),
                         fecha DATE,
                         metodo_pago VARCHAR(60),
                         FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
                         CONSTRAINT FKempresa FOREIGN KEY (id_empresa) REFERENCES datos_empresa(id_empresa) -- Inline para evitar el ALTER innecesario
);

INSERT INTO factura (id_cliente, id_empresa, monto, fecha, metodo_pago) VALUES
                                                                            (1, 1, 2898.00, '2026-06-11', 'Tarjeta de Crédito BCP'),
                                                                            (2, 1, 399.00, '2026-06-11', 'Transferencia PagoEfectivo');

-- =======================================================
-- 7. DETALLE FACTURAS
-- =======================================================
CREATE TABLE detalle_facturas (
                                  id_detalle_factura INT PRIMARY KEY AUTO_INCREMENT,
                                  id_factura INT,
                                  id_producto INT,
                                  cantidad INT,
                                  FOREIGN KEY (id_factura) REFERENCES factura(id_factura),
                                  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

INSERT INTO detalle_facturas (id_factura, id_producto, cantidad) VALUES
                                                                     (1, 1, 1),
                                                                     (1, 5, 1),
                                                                     (2, 5, 1);

-- =======================================================
-- 8. DETALLE OFERTA
-- =======================================================
CREATE TABLE detalle_oferta (
                                id_detalle_oferta INT PRIMARY KEY AUTO_INCREMENT,
                                id_oferta INT,
                                id_producto INT,
                                cantidad INT,
                                FOREIGN KEY (id_oferta) REFERENCES ofertas(id_oferta),
                                FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

INSERT INTO detalle_oferta (id_oferta, id_producto, cantidad) VALUES
                                                                  (1, 1, 1), -- Combo 1: 1x Sofá Seccional
                                                                  (1, 3, 1), -- Combo 1: 1x Mesa de Centro Industrial
                                                                  (2, 8, 1), -- Combo 2: 1x Escritorio Minimalista
                                                                  (2, 9, 1); -- Combo 2: 1x Silla Ergonómica

-- =======================================================
-- 9. TABLA DE USUARIOS
-- =======================================================
CREATE TABLE usuarios (
                          id_usuario INT PRIMARY KEY AUTO_INCREMENT,
                          user_name VARCHAR(80),
                          password_user VARCHAR(80)
);

INSERT INTO usuarios (user_name, password_user) VALUES
                                                    ('Admin', '123'),
                                                    ('Yordan', 'admin123');


-- =======================================================
-- 📊 SECCIÓN DE CONSULTAS / VERIFICACIÓN (Al final del script)
-- =======================================================

-- Consulta de Facturación detallada
SELECT
    c.nombre AS Cliente,
    c.dni AS DNI,
    p.descripcion AS Producto,
    p.precio AS Precio_Unitario,
    dt.cantidad AS Cantidad,
    f.monto AS Total_Factura,
    f.fecha AS Fecha_Emision,
    f.metodo_pago AS Metodo_Pago
FROM detalle_facturas dt
         JOIN productos p ON dt.id_producto = p.id_producto
         JOIN factura f ON dt.id_factura = f.id_factura
         JOIN clientes c ON f.id_cliente = c.id_cliente;