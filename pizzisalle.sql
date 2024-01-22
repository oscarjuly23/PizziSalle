DROP DATABASE IF EXISTS pizzisalle;
CREATE DATABASE pizzisalle;
USE pizzisalle;

DROP TABLE IF EXISTS Ingredient CASCADE;
CREATE TABLE Ingredient(
	id_ingredient	INT NOT NULL AUTO_INCREMENT,
	name			VARCHAR(255),
	PRIMARY KEY (id_ingredient)
);

DROP TABLE IF EXISTS Massa CASCADE;
CREATE TABLE Massa(
	id_massa		INT NOT NULL AUTO_INCREMENT,
	name			VARCHAR(255),
	PRIMARY KEY (id_massa)
);

DROP TABLE IF EXISTS Pizza CASCADE;
CREATE TABLE Pizza(
	id_pizza		INT NOT NULL AUTO_INCREMENT,
	name			VARCHAR(255),
	PRIMARY KEY (id_pizza)
);

DROP TABLE IF EXISTS PizzaItem CASCADE;
CREATE TABLE PizzaItem(
	id_pizza_item	INT NOT NULL AUTO_INCREMENT,
    	quantity	INT,
	id_ingredient	INT,
	id_pizza	INT,
	PRIMARY KEY (id_pizza_item),
    FOREIGN KEY(id_ingredient) REFERENCES Ingredient(id_ingredient),
    FOREIGN KEY(id_pizza) REFERENCES Pizza(id_pizza)
);

DROP TABLE IF EXISTS Drink CASCADE;
CREATE TABLE Drink(
	id_drink	INT NOT NULL AUTO_INCREMENT,
	name		VARCHAR(255),
	PRIMARY KEY (id_drink)
);

DROP TABLE IF EXISTS Delegation CASCADE;
CREATE TABLE Delegation(
	id_delegation	INT NOT NULL AUTO_INCREMENT,
    	name		VARCHAR(255),
	PRIMARY KEY (id_delegation)
);

DROP TABLE IF EXISTS Customer CASCADE;
CREATE TABLE Customer(
	id_customer	INT NOT NULL AUTO_INCREMENT,
	name		VARCHAR(255),
	surname1	VARCHAR(255),
	surname2	VARCHAR(255),
	phone_number	VARCHAR(255),
	address		VARCHAR(255),
	city		VARCHAR(255),
	PRIMARY KEY (id_customer)
);

DROP TABLE IF EXISTS COrder CASCADE;
CREATE TABLE COrder(
	id_order	INT NOT NULL AUTO_INCREMENT,
	datetime	datetime DEFAULT CURRENT_TIMESTAMP,
	id_customer	INT,
	id_delegation	INT,
	PRIMARY KEY (id_order),
    FOREIGN KEY(id_customer) REFERENCES Customer(id_customer),
    FOREIGN KEY(id_delegation) REFERENCES Delegation(id_delegation)
);

DROP TABLE IF EXISTS OrderItem CASCADE;
CREATE TABLE OrderItem(
	id_order_item	INT NOT NULL AUTO_INCREMENT,
    	id_pizza	INT,
	id_massa	INT,
	id_drink	INT,
	extra		VARCHAR(255),
	id_order	INT,
	PRIMARY KEY (id_order_item),
    FOREIGN KEY(id_pizza) REFERENCES Pizza(id_pizza),
    FOREIGN KEY(id_massa) REFERENCES Massa(id_massa),
    FOREIGN KEY(id_drink) REFERENCES Drink(id_drink),
    FOREIGN KEY(id_order) REFERENCES COrder(id_order)
);

INSERT INTO INGREDIENT (name) VALUES ('Tomaquet');
INSERT INTO INGREDIENT (name) VALUES ('Mozzarella');
INSERT INTO INGREDIENT (name) VALUES ('Pernil');
INSERT INTO INGREDIENT (name) VALUES ('Pinya');
INSERT INTO INGREDIENT (name) VALUES ('Pollastre');
INSERT INTO INGREDIENT (name) VALUES ('Bacon Crispy');
INSERT INTO INGREDIENT (name) VALUES ('Frankfurt');
INSERT INTO INGREDIENT (name) VALUES ('Bacon');
INSERT INTO INGREDIENT (name) VALUES ('Ou');
INSERT INTO INGREDIENT (name) VALUES ('Salsitxes');
INSERT INTO INGREDIENT (name) VALUES ('Ceba');
INSERT INTO INGREDIENT (name) VALUES ('Mini Burgers');
INSERT INTO INGREDIENT (name) VALUES ('Tonyina');
INSERT INTO INGREDIENT (name) VALUES ('Xoriço');
INSERT INTO INGREDIENT (name) VALUES ('Olives');
INSERT INTO INGREDIENT (name) VALUES ('Salsa BBQ');
INSERT INTO INGREDIENT (name) VALUES ('Cheddar');
INSERT INTO INGREDIENT (name) VALUES ('Roquefort');
INSERT INTO INGREDIENT (name) VALUES ('Tomaquet Natural');
INSERT INTO INGREDIENT (name) VALUES ('Anxoves');
INSERT INTO INGREDIENT (name) VALUES ('Gambes');
INSERT INTO INGREDIENT (name) VALUES ('Carn');
INSERT INTO INGREDIENT (name) VALUES ('Salsa Carbonara');
INSERT INTO INGREDIENT (name) VALUES ('Xampinyons');
INSERT INTO INGREDIENT (name) VALUES ('Pernil Salat');
INSERT INTO INGREDIENT (name) VALUES ('Brie');
INSERT INTO INGREDIENT (name) VALUES ('Emmental');
INSERT INTO INGREDIENT (name) VALUES ('Pepperoni');
INSERT INTO INGREDIENT (name) VALUES ('Pebrot');
INSERT INTO INGREDIENT (name) VALUES ('Carxofa');
INSERT INTO INGREDIENT (name) VALUES ('Formatge Cabra');
INSERT INTO INGREDIENT (name) VALUES ('Sobrassada');
INSERT INTO INGREDIENT (name) VALUES ('Mel');

INSERT INTO Massa(name) VALUES('Original');
INSERT INTO Massa(name) VALUES('Prima');
INSERT INTO Massa(name) VALUES('Gruixuda');

INSERT INTO Drink(name) VALUES('Aigua');
INSERT INTO Drink(name) VALUES('Refresc');
INSERT INTO Drink(name) VALUES('Cervesa');

INSERT INTO Pizza(name) VALUES('Margarida');
INSERT INTO Pizza(name) VALUES('Hawaiana');
INSERT INTO Pizza(name) VALUES('Bacon Crispy');
INSERT INTO Pizza(name) VALUES('Americana');
INSERT INTO Pizza(name) VALUES('Traviata');
INSERT INTO Pizza(name) VALUES('Burger');
INSERT INTO Pizza(name) VALUES('Castellera');
INSERT INTO Pizza(name) VALUES('Cowboy');
INSERT INTO Pizza(name) VALUES('Vaquera');
INSERT INTO Pizza(name) VALUES('Marinera');
INSERT INTO Pizza(name) VALUES('Bbq');
INSERT INTO Pizza(name) VALUES('Diablo');
INSERT INTO Pizza(name) VALUES('Carbonara');
INSERT INTO Pizza(name) VALUES('Serrana');
INSERT INTO Pizza(name) VALUES('4 formatges');
INSERT INTO Pizza(name) VALUES('Pepperoni');
INSERT INTO Pizza(name) VALUES('Vegetal');
INSERT INTO Pizza(name) VALUES('Barcelona');
INSERT INTO Pizza(name) VALUES('Girona');
INSERT INTO Pizza(name) VALUES('Tarragona');
INSERT INTO Pizza(name) VALUES('Lleida');
INSERT INTO Pizza(name) VALUES('6 formatges');
INSERT INTO Pizza(name) VALUES('Mallorquina');
INSERT INTO Pizza(name) VALUES('Carbonara Deluxe');

INSERT INTO Delegation(name) VALUES('Barcelona');
INSERT INTO Delegation(name) VALUES('Lleida');
INSERT INTO Delegation(name) VALUES('Tarragona');
INSERT INTO Delegation(name) VALUES('Girona');

-- Margarida --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,1);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,1);

-- Hawaiana -- 
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,2);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,2);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,3,2);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,4,2);

-- Bacon Crispy --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,3);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,3);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,3,3);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,5,3);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,6,3);

-- Americana -- 
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,4);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,4);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,7,4);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,4);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,9,4);

-- Traviata -- 
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,5);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,5);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,5);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,10,5);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,5);

-- Burger -- 
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,6);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,6);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,12,6);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,9,6);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,6);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,6);

-- Castellera -- 
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,7);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,7);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,7);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,13,7);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,14,7);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,15,7);

-- Cowboy -- 
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,8);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,8);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,16,8);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,17,8);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,18,8);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,8);

-- Vaquera --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,9);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,9);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,16,9);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,9);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,19,9);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,5,9);

-- Marinera -- 
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,10);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,10);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,13,10);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,20,10);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,21,10);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,4,10);

-- Bbq --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,11);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,11);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,16,11);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,22,11);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,11);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,5,11);

-- Diablo --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,12);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,12);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,3,12);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,22,12);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,12);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,5,12);

-- Carbonara --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,13);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,13);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,23,13);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,13);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,13);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,24,13);

-- Serrana --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,14);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,14);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,25,14);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,26,14);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,15,14);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,24,14);

-- 4 formatges --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,15);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(2,2,15);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,27,15);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,18,15);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,17,15);

-- Pepperoni -- 
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,16);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,16);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,28,16);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,3,16);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,22,16);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,16);

-- Vegetal --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,17);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,17);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,17);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,29,17);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,19,17);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,30,17);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,24,17);

-- Barcelona --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,18);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,18);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,18);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,22,18);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,26,18);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,3,18);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,15,18);

-- Girona --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,19);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,19);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,22,19);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,3,19);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,24,19);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,5,19);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,15,19);

-- Tarragona --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,20);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,20);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,13,20);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,21,20);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,20);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,3,20);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,15,20);

-- Lleida --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,21);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,21);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,16,21);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,22,21);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,5,21);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,24,21);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,15,21);

-- 6 formatges --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,22);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(2,2,22);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,31,22);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,26,22);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,27,22);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,18,22);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,17,22);

-- Mallorquina --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,23);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,23);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,31,23);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,27,23);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,17,23);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,26,23);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,32,23);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,15,23);

-- Carbonara Deluxe --
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,1,24);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,2,24);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,23,24);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,8,24);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,11,24);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,24,24);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,31,24);
INSERT INTO PizzaItem(quantity,id_ingredient,id_pizza) VALUES(1,33,24);

