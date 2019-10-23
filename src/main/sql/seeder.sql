CREATE DATABASE customerdb;

use customerdb;

CREATE TABLE customer(
    id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    email VARCHAR (35),
    PRIMARY KEY (id)
);

DROP TABLE customer;
