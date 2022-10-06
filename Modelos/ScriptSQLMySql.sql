create database alpharural;

use alphaRural;

CREATE TABLE Apoiador(
dataNasc DATETIME,
nome VARCHAR(50),
telefone VARCHAR(11),
tipoDoacao text,
telContato VARCHAR(11),
email VARCHAR(30),
id_Apoiador INTEGER PRIMARY KEY auto_increment
);

show tables;

desc Apoiador;

select * from Apoiador;

