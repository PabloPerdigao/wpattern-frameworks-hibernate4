-- WPATTERN FRAMEWORKS - HIBERNATE 4
-- PostgreSQL: dados iniciais
-- Execute depois de 01-create-schema.sql, uma unica vez.

BEGIN;

INSERT INTO categories (category_id, category_name, description, picture) VALUES
(1, 'Beverages', 'Soft drinks, coffees, teas and other beverages.', NULL),
(2, 'Condiments', 'Sweet and savory sauces, relishes and seasonings.', NULL),
(3, 'Confections', 'Desserts, candies and sweet breads.', NULL),
(4, 'Dairy Products', 'Cheeses and other dairy products.', NULL),
(5, 'Grains/Cereals', 'Breads, crackers, pasta and cereal products.', NULL),
(6, 'Meat/Poultry', 'Prepared meats and poultry products.', NULL),
(7, 'Produce', 'Dried fruit, beans and fresh vegetables.', NULL),
(8, 'Seafood', 'Seafood products and fish.', NULL);

INSERT INTO products
(product_id, product_name, supplier_id, category_id, quantity_per_unit,
 unit_price, units_in_stock, units_on_order, reorder_level, discontinued)
VALUES
(1, 'Chai', 1, 1, '10 boxes x 20 bags', 18.0000, 39, 0, 10, FALSE),
(2, 'Chang', 1, 1, '24 - 12 oz bottles', 19.0000, 17, 40, 25, FALSE),
(3, 'Aniseed Syrup', 1, 2, '12 - 550 ml bottles', 10.0000, 13, 70, 25, FALSE),
(4, 'Chef Anton Cajun Seasoning', 2, 2, '48 - 6 oz jars', 22.0000, 53, 0, 0, FALSE),
(5, 'Chef Anton Gumbo Mix', 2, 2, '36 boxes', 21.3500, 0, 0, 0, TRUE),
(6, 'Grandmas Boysenberry Spread', 3, 2, '12 - 8 oz jars', 25.0000, 120, 0, 25, FALSE),
(7, 'Uncle Bobs Organic Dried Pears', 3, 7, '12 - 1 lb packages', 30.0000, 15, 0, 10, FALSE),
(8, 'Northwoods Cranberry Sauce', 3, 2, '12 - 12 oz jars', 40.0000, 6, 0, 0, FALSE),
(9, 'Mishi Kobe Niku', 4, 6, '18 - 500 g packages', 97.0000, 29, 0, 0, FALSE),
(10, 'Ikura', 5, 8, '12 - 200 ml jars', 31.0000, 31, 0, 0, FALSE),
(11, 'Queso Cabrales', 6, 4, '1 kg package', 21.0000, 22, 30, 30, FALSE),
(12, 'Queso Manchego La Pastora', 6, 4, '10 - 500 g packages', 38.0000, 86, 0, 0, FALSE),
(13, 'Konbu', 7, 8, '2 kg box', 6.0000, 24, 0, 5, FALSE),
(14, 'Tofu', 7, 7, '40 - 100 g packages', 23.2500, 35, 0, 0, FALSE),
(15, 'Genen Shouyu', 8, 2, '24 - 250 ml bottles', 15.5000, 39, 0, 5, FALSE),
(16, 'Pavlova', 9, 3, '32 - 500 g boxes', 17.4500, 29, 0, 10, FALSE);

INSERT INTO orders
(order_id, customer_id, employee_id, order_date, required_date, shipped_date,
 ship_via, freight, ship_name, ship_address, ship_city, ship_region,
 ship_postal_code, ship_country)
VALUES
(1001, 'ALFKI', 2, '2026-01-05 09:30:00', '2026-01-12 00:00:00', '2026-01-08 14:00:00', 1, 32.5000, 'Alfreds Futterkiste', 'Obere Str. 57', 'Berlin', NULL, '12209', 'Germany'),
(1002, 'ANATR', 3, '2026-01-08 10:15:00', '2026-01-15 00:00:00', '2026-01-10 16:30:00', 2, 18.7500, 'Ana Trujillo Emparedados', 'Avda. de la Constitucion 2222', 'Mexico City', NULL, '05021', 'Mexico'),
(1003, 'ANTON', 4, '2026-01-12 11:00:00', '2026-01-20 00:00:00', '2026-01-15 09:00:00', 1, 45.0000, 'Antonio Moreno Taqueria', 'Mataderos 2312', 'Mexico City', NULL, '05023', 'Mexico'),
(1004, 'AROUT', 2, '2026-01-18 13:20:00', '2026-01-25 00:00:00', '2026-01-21 10:30:00', 3, 27.8000, 'Around the Horn', '120 Hanover Sq.', 'London', NULL, 'WA1 1DP', 'UK'),
(1005, 'BERGS', 5, '2026-02-02 08:45:00', '2026-02-10 00:00:00', '2026-02-05 12:00:00', 2, 15.9000, 'Berglunds snabbkop', 'Berguvsvagen 8', 'Lulea', NULL, 'S-958 22', 'Sweden'),
(1006, 'BLAUS', 3, '2026-02-07 15:00:00', '2026-02-14 00:00:00', '2026-02-10 11:00:00', 1, 62.0000, 'Blauer See Delikatessen', 'Forsterstr. 57', 'Mannheim', NULL, '68306', 'Germany'),
(1007, 'BONAP', 4, '2026-02-15 09:10:00', '2026-02-22 00:00:00', '2026-02-18 14:20:00', 2, 22.5000, 'Bon app', '12 rue des Bouchers', 'Marseille', NULL, '13008', 'France'),
(1008, 'BOTTM', 5, '2026-02-20 16:40:00', '2026-02-28 00:00:00', NULL, 3, 35.7500, 'Bottom-Dollar Markets', '23 Tsawassen Blvd.', 'Tsawassen', 'BC', 'T2F 8M4', 'Canada');

INSERT INTO order_details (order_id, product_id, unit_price, quantity, discount) VALUES
(1001, 1, 18.0000, 10, 0.00),
(1001, 3, 10.0000, 5, 0.05),
(1002, 2, 19.0000, 8, 0.00),
(1002, 4, 22.0000, 4, 0.10),
(1003, 6, 25.0000, 6, 0.00),
(1003, 9, 97.0000, 2, 0.05),
(1004, 5, 21.3500, 12, 0.00),
(1004, 8, 40.0000, 3, 0.10),
(1005, 7, 30.0000, 5, 0.00),
(1005, 11, 21.0000, 8, 0.05),
(1006, 10, 31.0000, 4, 0.00),
(1006, 12, 38.0000, 3, 0.00),
(1007, 13, 6.0000, 15, 0.00),
(1007, 14, 23.2500, 6, 0.05),
(1008, 15, 15.5000, 10, 0.00),
(1008, 16, 17.4500, 7, 0.10);

-- Sincroniza as sequencias apos os IDs explicitos dos INSERTs.
SELECT setval('categories_category_id_seq',
              COALESCE(MAX(category_id), 1),
              MAX(category_id) IS NOT NULL)
FROM categories;

SELECT setval('products_product_id_seq',
              COALESCE(MAX(product_id), 1),
              MAX(product_id) IS NOT NULL)
FROM products;

SELECT setval('orders_order_id_seq',
              COALESCE(MAX(order_id), 1),
              MAX(order_id) IS NOT NULL)
FROM orders;

COMMIT;

-- Conferencia da quantidade de registros inseridos.
SELECT 'categories' AS tabela, COUNT(*) AS quantidade FROM categories
UNION ALL
SELECT 'products', COUNT(*) FROM products
UNION ALL
SELECT 'orders', COUNT(*) FROM orders
UNION ALL
SELECT 'order_details', COUNT(*) FROM order_details;
