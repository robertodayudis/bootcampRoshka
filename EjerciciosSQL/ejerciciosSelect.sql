-- Top clientes con más facturas

SELECT c.id, c.nombre, c.apellido, COUNT(f.id) AS cant_facturas
FROM cliente c
JOIN factura f ON f.cliente_id = c.id
GROUP BY c.id
ORDER BY cant_facturas DESC
LIMIT 10;

-- Top clientes que más gastaron
SELECT c.id, c.nombre, sum(fd.cantidad * p.precio) AS totalGastado
FROM cliente c
JOIN factura f ON f.cliente_id = c.id
JOIN factura_detalle fd ON f.id = fd.factura_id
JOIN producto p ON fd.producto_id = p.id
GROUP BY c.id, c.nombre
ORDER BY totalGastado DESC
LIMIT 10;

-- Top monedas más utilizadas
SELECT m.id, m.nombre, count(f.moneda_id) AS topMonedas
FROM moneda m
JOIN factura f ON f.moneda_id = m.id
GROUP BY m.id, m.nombre
ORDER BY topMonedas DESC
LIMIT 10;

-- Top proveedor de productos
-- Por cantidad de aparicion
SELECT pr.id, pr.nombre, count(p.proveedor_id) AS topProveedor
FROM proveedor pr
JOIN producto p ON pr.id = p.proveedor_id
GROUP BY pr.id, pr.nombre
ORDER BY topProveedor DESC
LIMIT 10;

-- Por cantidad de ganancia
SELECT pr.id, pr.nombre, cast(sum(fd.cantidad * p.precio) as int) AS topProveedor
FROM proveedor pr
JOIN producto p ON pr.id = p.proveedor_id
JOIN factura_detalle fd ON p.id = fd.producto_id
GROUP BY pr.id, pr.nombre
ORDER BY topProveedor DESC;

-- Por cantidad de productos
SELECT
    pr.id,
    pr.nombre,
    SUM(fd.cantidad) AS cantidad_vendida
FROM proveedor pr
JOIN producto p ON pr.id = p.proveedor_id
JOIN factura_detalle fd ON fd.producto_id = p.id
GROUP BY pr.id, pr.nombre
ORDER BY cantidad_vendida DESC
LIMIT 10;

-- Top proveedor de productos ================================ FIN

-- Productos más vendidos
SELECT p.id, p.nombre, sum(fd.cantidad) AS aparProd
FROM factura_detalle fd
JOIN producto p ON fd.producto_id = p.id
GROUP BY p.id, p.nombre
ORDER BY aparProd DESC
LIMIT 10;

-- Productos menos vendidos
SELECT p.id, p.nombre, sum(fd.cantidad) AS aparProd
FROM factura_detalle fd
         JOIN producto p ON fd.producto_id = p.id
GROUP BY p.id, p.nombre
ORDER BY aparProd ASC
LIMIT 10;

-- Consulta que muestre fecha de emisión de factura, nombre y apellido del cliente, nombres de productos de esa factura,
-- cantidades compradas, nombre de tipo de factura de una factura específica

SELECT f.fecha_emision, c.nombre, c.apellido, p.nombre, fd.cantidad, ft.nombre
FROM factura f
JOIN factura_detalle fd ON f.id = fd.factura_id
JOIN producto p ON fd.producto_id = p.id
JOIN cliente c ON f.cliente_id = c.id
JOIN factura_tipo ft ON f.factura_tipo_id = ft.id
GROUP BY f.fecha_emision, c.nombre, c.apellido, p.nombre, fd.cantidad, ft.nombre
ORDER BY cantidad desc;


-- Montos de facturas ordenadas según totales
SELECT f.id, cast(sum(fd.cantidad * p.precio) as int) AS totalFactura
FROM factura f
JOIN factura_detalle fd ON f.id = fd.factura_id
JOIN producto p ON fd.producto_id = p.id
GROUP BY f.id
ORDER BY totalFactura DESC
LIMIT 10;

-- Mostrar el iva 10% de los montos totales de facturas (suponer que todos los productos tienen IVA 10%)
SELECT
    f.id,
    cast(sum(fd.cantidad * p.precio) as int) AS totalFactura,
    cast((sum(fd.cantidad * p.precio)/11) as int) AS ivaDiez,
    cast(((sum(fd.cantidad * p.precio)/11)+sum(fd.cantidad * p.precio)) as int) AS totalIva
    FROM factura f
JOIN factura_detalle fd ON f.id = fd.factura_id
JOIN producto p ON fd.producto_id = p.id
GROUP BY f.id
ORDER BY totalFactura DESC
LIMIT 10;
