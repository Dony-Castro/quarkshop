CREATE TABLE products
(
    id BIGINT IDENTITY(1,1) NOT NULL,
    name NVARCHAR(200) NOT NULL,
    description NVARCHAR(2000) NULL,
    price DECIMAL(18,2) NOT NULL,
    stock INT NOT NULL,

    CONSTRAINT PK_products
        PRIMARY KEY (id),

    CONSTRAINT CK_products_price
        CHECK (price > 0),

    CONSTRAINT CK_products_stock
        CHECK (stock >= 0)
);