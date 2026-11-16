-- WPATTERN FRAMEWORKS - HIBERNATE 4
-- PostgreSQL: criacao da estrutura
-- Execute uma vez em um banco vazio.

CREATE SEQUENCE categories_category_id_seq START WITH 1;
CREATE SEQUENCE products_product_id_seq START WITH 1;
CREATE SEQUENCE orders_order_id_seq START WITH 1;

CREATE TABLE categories (
    category_id INTEGER NOT NULL DEFAULT nextval('categories_category_id_seq'),
    category_name VARCHAR(15) NOT NULL,
    description TEXT,
    picture BYTEA,
    CONSTRAINT pk_categories PRIMARY KEY (category_id)
);
ALTER SEQUENCE categories_category_id_seq OWNED BY categories.category_id;

CREATE TABLE products (
    product_id INTEGER NOT NULL DEFAULT nextval('products_product_id_seq'),
    product_name VARCHAR(40) NOT NULL,
    supplier_id INTEGER,
    category_id INTEGER,
    quantity_per_unit VARCHAR(20),
    unit_price NUMERIC(10, 4) DEFAULT 0.0000,
    units_in_stock SMALLINT DEFAULT 0,
    units_on_order SMALLINT DEFAULT 0,
    reorder_level SMALLINT DEFAULT 0,
    discontinued BOOLEAN DEFAULT FALSE,
    CONSTRAINT pk_products PRIMARY KEY (product_id),
    CONSTRAINT fk_products_categories
        FOREIGN KEY (category_id) REFERENCES categories (category_id)
        ON DELETE SET NULL ON UPDATE CASCADE
);
ALTER SEQUENCE products_product_id_seq OWNED BY products.product_id;

CREATE TABLE orders (
    order_id INTEGER NOT NULL DEFAULT nextval('orders_order_id_seq'),
    customer_id VARCHAR(5),
    employee_id INTEGER,
    order_date TIMESTAMP,
    required_date TIMESTAMP,
    shipped_date TIMESTAMP,
    ship_via INTEGER,
    freight NUMERIC(10, 4) DEFAULT 0.0000,
    ship_name VARCHAR(40),
    ship_address VARCHAR(60),
    ship_city VARCHAR(15),
    ship_region VARCHAR(15),
    ship_postal_code VARCHAR(10),
    ship_country VARCHAR(15),
    CONSTRAINT pk_orders PRIMARY KEY (order_id)
);
ALTER SEQUENCE orders_order_id_seq OWNED BY orders.order_id;

CREATE TABLE order_details (
    order_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    unit_price NUMERIC(10, 4) NOT NULL DEFAULT 0.0000,
    quantity SMALLINT NOT NULL DEFAULT 1,
    discount DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    CONSTRAINT pk_order_details PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk_order_details_orders
        FOREIGN KEY (order_id) REFERENCES orders (order_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_order_details_products
        FOREIGN KEY (product_id) REFERENCES products (product_id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);
