-- Switch to the stock_trading database
USE stock_trading;

-- Insert 1,000 users
DELIMITER //
CREATE PROCEDURE InsertUsers()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 1000 DO
        INSERT INTO user (username, email, password_hash, created_at)
        VALUES (CONCAT('user_', i), CONCAT('user_', i, '@example.com'), CONCAT('hashed_password_', i), NOW());
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

CALL InsertUsers();
DROP PROCEDURE InsertUsers;

-- Insert 1,000 stocks
DELIMITER //
CREATE PROCEDURE InsertStocks()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 1000 DO
        INSERT INTO stock (ticker, company_name, exchange)
        VALUES (CONCAT('STK', i), CONCAT('Company_', i), 'NASDAQ');
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

CALL InsertStocks();
DROP PROCEDURE InsertStocks;

-- Insert 50 stocks per user into the user_stock table (with batching)
DELIMITER //
CREATE PROCEDURE InsertUserStocks()
BEGIN
    DECLARE user_id INT DEFAULT 1;
    DECLARE batch_size INT DEFAULT 10; -- Number of users processed in one batch
    DECLARE max_stocks INT DEFAULT 50; -- Stocks per user
    DECLARE stock_id INT DEFAULT 1;

    START TRANSACTION;

    WHILE user_id <= 1000 DO
        SET stock_id = 1;
        WHILE stock_id <= max_stocks DO
            INSERT INTO user_stock (user_id, stock_id, allocated_amount, quantity, price, last_updated)
            VALUES (user_id, stock_id, RAND() * 10000, FLOOR(RAND() * 100) + 1, RAND() * 500, NOW());
            SET stock_id = stock_id + 1;
        END WHILE;

        SET user_id = user_id + 1;

        -- Commit after processing a batch of users
        IF MOD(user_id, batch_size) = 0 THEN
            COMMIT;
            START TRANSACTION;
        END IF;
    END WHILE;

    COMMIT; -- Final commit for remaining users
END //
DELIMITER ;

CALL InsertUserStocks();
DROP PROCEDURE InsertUserStocks;

-- Insert 100 trades per user into the trade table (with batching)
DELIMITER //
CREATE PROCEDURE InsertTrades()
BEGIN
    DECLARE user_id INT DEFAULT 1;
    DECLARE trade_count INT DEFAULT 1;
    DECLARE batch_size INT DEFAULT 10; -- Number of users processed in one batch
    DECLARE max_trades INT DEFAULT 100; -- Trades per user

    START TRANSACTION;

    WHILE user_id <= 1000 DO
        SET trade_count = 1;
        WHILE trade_count <= max_trades DO
            INSERT INTO trade (user_id, stock_id, trade_type, quantity, price, time_executed)
            VALUES (user_id, FLOOR(RAND() * 1000) + 1, 
                   IF(RAND() > 0.5, 'BUY', 'SELL'), 
                   FLOOR(RAND() * 100) + 1, RAND() * 500, NOW());
            SET trade_count = trade_count + 1;
        END WHILE;

        SET user_id = user_id + 1;

        -- Commit after processing a batch of users
        IF MOD(user_id, batch_size) = 0 THEN
            COMMIT;
            START TRANSACTION;
        END IF;
    END WHILE;

    COMMIT; -- Final commit for remaining users
END //
DELIMITER ;

CALL InsertTrades();
DROP PROCEDURE InsertTrades;
