-- Script SQL para la base de datos 'escuela'

CREATE DATABASE IF NOT EXISTS escuela;
USE escuela;

-- Creación de la tabla alumno según la consigna
CREATE TABLE IF NOT EXISTS alumno (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    edad INT NOT NULL
);

-- Registros de prueba iniciales
INSERT INTO alumno (nombre, apellido, edad) VALUES 
('Lucas', 'Gonzalez', 21),
('Mariana', 'Lopez', 19),
('Carlos', 'Rodriguez', 23);
