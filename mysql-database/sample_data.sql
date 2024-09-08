-- Use the stock_trading database
USE stock_trading;

-- Insert into user table
INSERT INTO user (username, email, password_hash, created_at)
VALUES
('john_doe', 'john@example.com', 'hashed_password_1', NOW()),
('jane_doe', 'jane@example.com', 'hashed_password_2', NOW()),
('alice_smith', 'alice@example.com', 'hashed_password_3', NOW());

-- Insert into stock table
INSERT INTO stock (ticker, company_name, exchange)
VALUES
('AAPL', 'Apple Inc.', 'NASDAQ'),
('GOOGL', 'Alphabet Inc.', 'NASDAQ'),
('TSLA', 'Tesla Inc.', 'NASDAQ');

-- Insert into user_stock table
-- Each user owns all three stocks
INSERT INTO user_stock (user_id, stock_id, allocated_amount, quantity, price, last_updated)
VALUES
-- John Doe's holdings
(1, 1, 15000.00, 10, 1500.00, NOW()), -- John owns 10 shares of Apple at $1500 each
(1, 2, 12000.00, 3, 4000.00, NOW()), -- John owns 3 shares of Google at $4000 each
(1, 3, 10000.00, 2, 5000.00, NOW()), -- John owns 2 shares of Tesla at $5000 each

-- Jane Doe's holdings
(2, 1, 7500.00, 5, 1500.00, NOW()),  -- Jane owns 5 shares of Apple at $1500 each
(2, 2, 16000.00, 4, 4000.00, NOW()), -- Jane owns 4 shares of Google at $4000 each
(2, 3, 5000.00, 1, 5000.00, NOW()),  -- Jane owns 1 share of Tesla at $5000

-- Alice Smith's holdings
(3, 1, 3000.00, 2, 1500.00, NOW()),  -- Alice owns 2 shares of Apple at $1500 each
(3, 2, 20000.00, 5, 4000.00, NOW()), -- Alice owns 5 shares of Google at $4000 each
(3, 3, 25000.00, 5, 5000.00, NOW()); -- Alice owns 5 shares of Tesla at $5000 each

-- Insert into trade table
-- Each user makes three trades (one for each stock)
INSERT INTO trade (user_id, stock_id, trade_type, quantity, price, time_executed)
VALUES
-- John Doe's trades
(1, 1, 'BUY', 5, 1500.00, NOW()),   -- John buys 5 shares of Apple at $1500 each
(1, 2, 'SELL', 1, 4000.00, NOW()),  -- John sells 1 share of Google at $4000
(1, 3, 'BUY', 2, 5000.00, NOW()),   -- John buys 2 shares of Tesla at $5000 each

-- Jane Doe's trades
(2, 1, 'BUY', 3, 1500.00, NOW()),   -- Jane buys 3 shares of Apple at $1500 each
(2, 2, 'BUY', 2, 4000.00, NOW()),   -- Jane buys 2 shares of Google at $4000 each
(2, 3, 'SELL', 1, 5000.00, NOW()),  -- Jane sells 1 share of Tesla at $5000

-- Alice Smith's trades
(3, 1, 'SELL', 1, 1500.00, NOW()),  -- Alice sells 1 share of Apple at $1500
(3, 2, 'BUY', 3, 4000.00, NOW()),   -- Alice buys 3 shares of Google at $4000 each
(3, 3, 'SELL', 2, 5000.00, NOW());  -- Alice sells 2 shares of Tesla at $5000 each
