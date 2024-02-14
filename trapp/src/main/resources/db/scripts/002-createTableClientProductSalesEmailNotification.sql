-- Customers table
CREATE TABLE IF NOT EXISTS customer (
    customerId SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Sales table
CREATE TABLE IF NOT EXISTS sale (
    saleId SERIAL PRIMARY KEY,
    customerId INT,
    saleDate DATE,
    totalAmount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

-- SaleItems table
CREATE TABLE IF NOT EXISTS saleItems (
    saleId INT,
    productID INT,
    quantity INT,
    unitPrice DECIMAL(10, 2) NOT NULL,
    totalPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (saleId) REFERENCES sale(saleId),
    FOREIGN KEY (productId) REFERENCES product(productId)
);

-- EmailNotifications table
CREATE TABLE IF NOT EXISTS emailNotifications (
    notificationId SERIAL PRIMARY KEY,
    customerId INT,
    sentDate DATE,
    message TEXT,
    FOREIGN KEY (customerId) REFERENCES customer(customerId)
);