
DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
Use Shop;

CREATE TABLE T_Articles(
	IdArticle int(4) PRIMARY KEY AUTO_INCREMENT,
	Description varchar(30) NOT NULL,
	Brand varchar(30) NOT NULL,
	UnitaryPrice float(8) NOT NULL)
	ENGINE = InnoDB; 
--1.4--
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Souris', 'Logitoch', 65);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Clavier', 'Microchard', 49.5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('System d''exploitation', 'Fenetres Vistouille',  150);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Tapis souris', 'Chapeau Bleu', 5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Cle USB 8 To', 'Syno', 8);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Laptop', 'PH', 1199);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('CD x 500', 'CETME', 250);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('DVD-R x 100', 'CETME', 99);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('DVD+R x 100', 'CETME', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Baterie Laptop', 'PH', 80);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Casque Audio', 'Syno', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('WebCam', 'Logitoch', 755);


CREATE TABLE T_Categories ( 
	IdCategory INT(4) PRIMARY KEY AUTO_INCREMENT,
	CatName VARCHAR(30) NOT NULL, 
	Description VARCHAR(30) NOT NULL
	);
INSERT INTO T_Categories (CatName, Description) VALUES('Materiel info', 'tout materiel');
INSERT INTO T_Categories (CatName, Description) VALUES('PC', 'Ordinateur portable');
INSERT INTO T_Categories (CatName, Description) VALUES('SmartPhone', 'Telephone de dernier generation');
INSERT INTO T_Categories (CatName, Description) VALUES('Logiciel', 'Tout logiciel');
 ALTER TABLE T_ARTICLES ADD COLUMN IdCategory INT(4);
ALTER TABLE T_articles ADD FOREIGN KEY(IdCategory) REFERENCES t_Categories(IdCategory);
	