-- Product table
CREATE TABLE IF NOT EXISTS product (
    productId SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description TEXT,
    stock INT NOT NULL
);

