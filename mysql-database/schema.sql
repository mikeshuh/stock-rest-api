-- Step 1: Create the Database if it doesn't exist
CREATE DATABASE IF NOT EXISTS stock_trading;

-- Step 2: Switch to the newly created database
USE stock_trading;

-- Step 3: Create the User Table if it doesn't exist
CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

-- Step 4: Create the User_Stock Table if it doesn't exist
CREATE TABLE IF NOT EXISTS stock (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    stock_symbol VARCHAR(10) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Step 5: Create the Trade Table if it doesn't exist
CREATE TABLE IF NOT EXISTS trade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    stock_symbol VARCHAR(10) NOT NULL,
    trade_type ENUM('buy', 'sell') NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    executed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Create indexes
CREATE INDEX idx_user_id_on_trade ON trade(user_id);
CREATE INDEX idx_user_id_on_stock ON stock(user_id);
