DROP DATABASE IF EXISTS FinalHotel;

CREATE DATABASE FinalHotel;

USE FinalHotel;

DROP TABLE IF EXISTS Users;
CREATE TABLE Users(
    `id` INTEGER  AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(80) NOT NULL,
    `password` VARCHAR(80),

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Customers;
CREATE TABLE Customers(
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `first_name` VARCHAR(20) NOT NULL,
    `phone_number` VARCHAR(70),
    `country` ENUM('OUI', 'NON'),
    `customer_type` ENUM('CLIENTS PRIVÉS','CLIENTS AFFAIRES','CLIENTS GROUPES','VIP','AUTRES'),
    `fideletycard` ENUM('OUI', 'NON'),


    PRIMARY KEY (id)
);

/*la table service est la pour enregistrer les articles*/

DROP TABLE IF EXISTS Articles;
CREATE TABLE Articles(
    `id` INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `article_name` VARCHAR(100),
    `price` FLOAT
);

DROP TABLE IF EXISTS Purshases;
CREATE TABLE Purshases(
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `article_id` INTEGER NOT NULL,
    `customer_id` INTEGER NOT NULL,
    `quantity` INTEGER,
    `paid` ENUM('OUI','NON'), /* permet de savoir si le produit est payé où pas */

    PRIMARY KEY (id),
    FOREIGN KEY (article_id) REFERENCES Articles (id),
    FOREIGN KEY (customer_id) REFERENCES Customers (id)
);
DROP TABLE IF EXISTS Rooms;
CREATE TABLE Rooms(
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `number` VARCHAR(5) UNIQUE NOT NULL,
    `cleaning_status` ENUM('dirty','own'),
    `type` ENUM('ventilées','climatisées'),
    `caractéristique` ENUM('Simple','Double','Triple'),
    `situation` ENUM('vue édifice','vue mer','vue jardin','vue rue','vue montagne'),
    `price` FLOAT,
    
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS Reservations;
CREATE TABLE Reservations(
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `room_id` INTEGER NOT NULL,
    `customer_id` INTEGER NOT NULL,
    `entry_date` DATE,
    `exit_date` DATE,
    `paid` ENUM('OUI','NON'),
    
    PRIMARY KEY (id),
    FOREIGN KEY (room_id) REFERENCES Rooms (id),
    FOREIGN KEY (customer_id) REFERENCES Customers (id)
);

DROP TABLE IF EXISTS Bills;
CREATE TABLE BIlls(
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `customer_id` INTEGER NOT NULL,

    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Bill_purshases;
CREATE TABLE Bill_purshases(
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `bill_id` INTEGER NOT NULL,
    `purshase_id` INTEGER NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (bill_id) REFERENCES Bills (id),
    FOREIGN KEY (purshase_id) REFERENCES Purshases (id)
);

DROP TABLE IF EXISTS Bill_details;
CREATE TABLE Bill_details(
    `id` INTEGER AUTO_INCREMENT NOT NULL,
    `bill_id` INTEGER NOT NULL,
    `reservation_id` INTEGER NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (bill_id) REFERENCES Bills (id),
    FOREIGN KEY (reservation_id) REFERENCES Reservations (id)
);

INSERT INTO Users VALUES(1,'admin','1234');