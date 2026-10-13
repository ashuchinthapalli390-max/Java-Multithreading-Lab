CREATE DATABASE IF NOT EXISTS mydatabase;
USE mydatabase;
CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL
);
INSERT INTO users (id, username, email) VALUES
(1, 'johndoe', 'johndoe@example.com'),
(2, 'janedoe', 'janedoe@example.com'),
(3, 'alice', 'alice@example.com');
