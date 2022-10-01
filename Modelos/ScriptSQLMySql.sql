create database alphaRural;

use alphaRural;

CREATE TABLE Apoiador  (
email VARCHAR(40),
dataNasc DATETIME,
nome VARCHAR(50),
telefone VARCHAR(11),
tipoDoacao text,
telContato VARCHAR(11),
id_Apoiador INTEGER PRIMARY KEY
);

CREATE TABLE Acesso (
id_acesso INTEGER PRIMARY KEY,
email VARCHAR(30),
senha VARCHAR(6)
);

CREATE TABLE Relacao1 (
id_acesso INTEGER,
id_Apoiador INTEGER,
FOREIGN KEY(id_acesso) REFERENCES Acesso (id_acesso),
FOREIGN KEY(id_Apoiador) REFERENCES Apoiador  (id_Apoiador)
);
