-- Create the Database if it doesn't exist
CREATE DATABASE IF NOT EXISTS stock_trading;

-- Switch to the newly created database
USE stock_trading;

-- User table
CREATE TABLE IF NOT EXISTS user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP
);

-- Stock table
CREATE TABLE IF NOT EXISTS stock (
    stock_id INT AUTO_INCREMENT PRIMARY KEY,
    ticker VARCHAR(10) NOT NULL,
    company_name VARCHAR(100) NOT NULL,
    exchange VARCHAR(50) NOT NULL,
    UNIQUE KEY unique_stock (ticker, exchange)
);

-- User Stock table
CREATE TABLE IF NOT EXISTS user_stock (
    user_id INT NOT NULL,
    stock_id INT NOT NULL,
    allocated_amount DECIMAL(15, 2) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    last_updated TIMESTAMP,
    PRIMARY KEY (user_id, stock_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (stock_id) REFERENCES stock(stock_id)
);

-- Trade table
CREATE TABLE IF NOT EXISTS trade (
    trade_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    stock_id INT NOT NULL,
    trade_type ENUM('BUY', 'SELL') NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    time_executed TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (stock_id) REFERENCES stock(stock_id)
);