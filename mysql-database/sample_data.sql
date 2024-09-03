-- Use the stock_trading database
USE stock_trading;

-- Insert sample users
INSERT INTO user (username, email, password_hash) VALUES
('john_doe', 'john@example.com', 'hashed_password_1'),
('jane_smith', 'jane@example.com', 'hashed_password_2'),
('bob_johnson', 'bob@example.com', 'hashed_password_3'),
('alice_williams', 'alice@example.com', 'hashed_password_4'),
('charlie_brown', 'charlie@example.com', 'hashed_password_5');

-- Insert sample user_stock data
INSERT INTO user_stock (user_id, stock_symbol) VALUES
(1, 'AAPL'),
(1, 'GOOGL'),
(2, 'AMZN'),
(2, 'MSFT'),
(3, 'TSLA'),
(3, 'FB'),
(4, 'NVDA'),
(4, 'AMD'),
(5, 'INTC'),
(5, 'IBM');

-- Insert sample trade data
INSERT INTO trade (user_id, stock_symbol, trade_type, quantity, price, executed_at) VALUES
(1, 'AAPL', 'buy', 10, 150.75, '2023-01-15 10:30:00'),
(1, 'GOOGL', 'buy', 5, 2750.50, '2023-01-16 11:45:00'),
(2, 'AMZN', 'buy', 8, 3300.25, '2023-01-17 09:15:00'),
(2, 'MSFT', 'sell', 15, 305.60, '2023-01-18 14:20:00'),
(3, 'TSLA', 'buy', 20, 850.75, '2023-01-19 10:00:00'),
(3, 'FB', 'sell', 12, 330.20, '2023-01-20 15:30:00'),
(4, 'NVDA', 'buy', 30, 225.50, '2023-01-21 11:00:00'),
(4, 'AMD', 'buy', 50, 92.30, '2023-01-22 13:45:00'),
(5, 'INTC', 'sell', 25, 55.80, '2023-01-23 10:20:00'),
(5, 'IBM', 'buy', 15, 140.25, '2023-01-24 14:10:00'),
(1, 'AAPL', 'sell', 5, 155.50, '2023-01-25 09:30:00'),
(2, 'AMZN', 'sell', 3, 3350.75, '2023-01-26 11:20:00'),
(3, 'TSLA', 'buy', 10, 875.25, '2023-01-27 15:00:00'),
(4, 'NVDA', 'sell', 15, 230.80, '2023-01-28 10:45:00'),
(5, 'IBM', 'sell', 7, 142.50, '2023-01-29 13:30:00');