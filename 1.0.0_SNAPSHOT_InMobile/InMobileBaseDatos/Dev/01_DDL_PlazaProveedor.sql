/*Create Data Base*/
CREATE DATABASE IF NOT EXISTS db_restaurantinmobile;
/*usar base de datos*/
USE db_RestaurantInMobile;
#SET SQL_SAFE_UPDATES = 0;

DROP TABLE IF EXISTS tb_request_response;
/*Table For Save Request and Response From Web Service*/
CREATE TABLE tb_request_response(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	typeOperation VARCHAR(100),
	idUser INT,
	request LONGTEXT,
	response LONGTEXT,
	status INT,
	date_created TIMESTAMP DEFAULT NOW(),
	user_created INT
);

DROP TABLE IF EXISTS tb_user;
/*Table Restaurant*/
CREATE TABLE tb_user(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, /*Id de Insumos*/
	email VARCHAR(60),
	passwordUser VARCHAR(60),
	typeUser INT,
	status INT,
	date_created TIMESTAMP DEFAULT NOW(),
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);
#password = Pa55w0rd o 12345678
insert into tb_user (id,email,passwordUser,typeUser,status,user_created,user_updated) values(0,'admin@inmoble.pe','UdLdXVla3TJX5ovpja8EhQ==',0,4,0,0);

DROP TABLE IF EXISTS tb_restaurant;
/*Table Restaurant*/
CREATE TABLE tb_restaurant(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, /*Id de Insumos*/
	socialReason VARCHAR(200),/*Nombre del restaurante*/
	nameRestaurant VARCHAR(200),/*Nombre del restaurante*/
	RUCRestaurant VARCHAR(20),/*Nombre del restaurante*/
	addressRestaurant VARCHAR(200),/*Telefono del restaurante*/
	phoneRestaurant VARCHAR(20),/*Telefono del restaurante*/
	referenceRestaurant VARCHAR(200),/*Referencia del restaurante*/
	idDistrictRestaurant INT,/*Distrito del restaurante*/
	idProvinceRestaurant INT,/*Provincia del restaurante*/
	idDeparmentRestaurant INT,/*Departamento del restaurante*/
	idCategory INT,
	nameContact VARCHAR(200),
	lastNameContact VARCHAR(200),
	chargeContact VARCHAR(200),
	phoneContact VARCHAR(20),
	cellphoneContact VARCHAR(20),
	referenceContact VARCHAR(200),
	anexoContact VARCHAR(20),
	idUser INT,
	status INT,
	idImage INT,
	date_created TIMESTAMP DEFAULT NOW(),
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);
/*
Falta detalle de recepcion de pedidos
*/
ALTER TABLE tb_restaurant
ADD FOREIGN KEY (idUser)
REFERENCES tb_user(id);

DROP TABLE IF EXISTS tb_schedulerrestaurant;
/*Table Schedulers Restaurants*/
CREATE TABLE tb_schedulerrestaurant(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idRestaurant INT,
	dayOfWeek INT,
	specificHour VARCHAR(100),
	date_created TIMESTAMP DEFAULT NOW(),
	user_created INT
);

ALTER TABLE tb_schedulerrestaurant
ADD FOREIGN KEY (idRestaurant)
REFERENCES tb_restaurant(id);

DROP TABLE IF EXISTS tb_Provider;
/*Table Provider*/
CREATE TABLE tb_provider(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	socialReason varchar(200),
	nameProvider VARCHAR(200),/*Nombre del Proveedor*/
	RUCProvider VARCHAR(20),/*Ruc del Proveedor*/
	phoneProvider VARCHAR(200),/*Telefono del Proveedor*/
	referenceProvider varchar(200),
	addressProvider VARCHAR(200),/*Direccion del Proveedor*/
	idDistrictProvider INT,/*Distrito del Proveedor*/
	idProvinceProvider INT,
	idDeparmentProvider INT,
	idCategory INT,
	nameContact varchar(200) DEFAULT NULL,
	lastNameContact varchar(200) DEFAULT NULL,
	chargeContact varchar(200) DEFAULT NULL,
	phoneContact varchar(20) DEFAULT NULL,
	cellphoneContact varchar(20) DEFAULT NULL,
	referenceContact varchar(200) DEFAULT NULL,
	anexoContact varchar(20) DEFAULT NULL,
	idUser INT,
	status INT DEFAULT NULL,
	idImage INT DEFAULT NULL,
	idPlan INT DEFAULT NULL,
	date_created TIMESTAMP DEFAULT NOW(),
	date_updated timestamp NULL DEFAULT NULL,
	user_created INT DEFAULT NULL,
	user_updated INT DEFAULT NULL

);
ALTER TABLE tb_provider
ADD FOREIGN KEY (idUser)
REFERENCES tb_user(id);

DROP TABLE IF EXISTS tb_district_provider;
/*Table Provider*/
CREATE TABLE tb_district_provider(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idDistrict INT,
	idProvider INT
);

ALTER TABLE tb_district_provider
ADD FOREIGN KEY (idProvider)
REFERENCES tb_provider(id);

/*Table Image*/
CREATE TABLE tb_image(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	categoryImage VARCHAR(200),
	img LONGBLOB NULL,
	date_created TIMESTAMP DEFAULT NOW(),
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);
insert into tb_image(id,categoryImage) values ('0','DEFAULT_IMAGE');
commit;
ALTER TABLE tb_provider
ADD FOREIGN KEY (idImage)
REFERENCES tb_image(id);

ALTER TABLE tb_restaurant
ADD FOREIGN KEY (idImage)
REFERENCES tb_image(id);

DROP TABLE IF EXISTS tb_check_active_restaurant;
/*Table Check Active Restaurants*/
CREATE TABLE tb_check_active_restaurant(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idRestaurant INT,
	verificationSunat INT,
	verificationAddress INT,
	verificationUser INT,
	manualReception INT,
	training INT,
	idMemberShipPlan INT,
	status INT,
	date_created TIMESTAMP DEFAULT NOW(),
	user_created INT
);

ALTER TABLE tb_check_active_restaurant
ADD FOREIGN KEY (idRestaurant)
REFERENCES tb_restaurant(id);

DROP TABLE IF EXISTS tb_check_active_provider;
/*Table Check Active Provider*/
CREATE TABLE tb_check_active_provider(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idProvider INT,
	verificationSunat INT,
	verificationAddress INT,
	verificationUser INT,
	manualReception INT,
	training INT,
	idMemberShipPlan INT,
	status INT,
	date_created TIMESTAMP DEFAULT NOW(),
	user_created INT
);

ALTER TABLE tb_check_active_provider
ADD FOREIGN KEY (idMemberShipPlan)
REFERENCES tb_provider(id);

DROP TABLE IF EXISTS tb_PlanMenber;
/*Table Plan Members*/
CREATE TABLE tb_planmenber(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	valuePlanMenber varchar(200),
	status INT
);

ALTER TABLE tb_check_active_restaurant
ADD FOREIGN KEY (idMemberShipPlan)
REFERENCES tb_planmenber(id);

ALTER TABLE tb_check_active_provider
ADD FOREIGN KEY (idMemberShipPlan)
REFERENCES tb_planmenber(id);

#Insert into table Plan Member
insert into tb_planmenber (valuePlanMenber,status) values('3 Meses',1);
insert into tb_planmenber (valuePlanMenber,status) values('6 Meses',1);
insert into tb_planmenber (valuePlanMenber,status) values('12 Meses',1);
insert into tb_planmenber (valuePlanMenber,status) values('Free',1);

/*Table Contry*/
CREATE TABLE tb_country(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	countryName VARCHAR(100),
	countryId VARCHAR(20)
); 
/*Table Departments*/
CREATE TABLE tb_departments(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	departmentName VARCHAR(100),
	countryId int
); 
ALTER TABLE tb_departments
ADD FOREIGN KEY (countryId)
REFERENCES tb_country(id);

/*Table Province*/
CREATE TABLE tb_province(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	provinceName VARCHAR(200),
	departmentId int
);
ALTER TABLE tb_province
ADD FOREIGN KEY (departmentId)
REFERENCES tb_departments(id);

/*Table Districts*/
CREATE TABLE tb_district(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	districtName VARCHAR(200),
	provinceId int
);
ALTER TABLE tb_district
ADD FOREIGN KEY (provinceId)
REFERENCES tb_province(id);