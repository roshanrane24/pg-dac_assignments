-- Creating car_hire db
DROP DATABASE IF EXISTS car_hire;
CREATE DATABASE car_hire;
USE car_hire;

-- Manufacturer Table
CREATE TABLE manufacturer (
    manufacturer_code INT PRIMARY KEY,
    manufacturer_name VARCHAR(20),
    manufacturer_details VARCHAR(25)
);

-- Model table
CREATE TABLE model (
    model_code INT PRIMARY KEY,
    daily_hire_rate DECIMAL(4,2),
    model_name VARCHAR(15),
    manufacturer_code INT
);

-- Vehicle Category
CREATE TABLE vehicle_category (
    vehicle_category_code INT PRIMARY KEY,
    vehicle_category_description VARCHAR(25)
);

-- Vehicle table
CREATE TABLE vehicle (
    reg_number VARCHAR(10) PRIMARY KEY,
    current_mileage DECIMAL(3,1),
    daily_hire_rate DECIMAL(4,2),
    date_mot_due DATE,
    engine_size INT,
    vehicle_category_code INT,
    model_code INT
);

-- Customer table
CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(25),
    customer_details VARCHAR(25),
    gender BINARY,
    email_address VARCHAR(25),
    phone_number INT(10),
    address_line_1 VARCHAR(25),
    address_line_2 VARCHAR(25),
    address_line_3 VARCHAR(25),
    town VARCHAR(10),
    county VARCHAR(10),
    country VARCHAR(10)
);

-- Booking Status table
CREATE TABLE booking_status (
    booking_status_code INT PRIMARY KEY,
    booking_status_decription VARCHAR(25)
);

-- Booking table
CREATE TABLE booking (
    booking_id INT PRIMARY KEY,
    date_from DATE,
    date_to DATE,
    confirmation_letter_dent_yn BINARY,
    payment_received_yn BINARY,
    booking_status_code INT,
    customer_id INT,
    reg_number VARCHAR(10)
);

