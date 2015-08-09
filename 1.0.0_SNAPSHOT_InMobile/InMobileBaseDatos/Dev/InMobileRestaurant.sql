/*Create Data Base*/
CREATE DATABASE db_RestaurantInMobile;
/*usar base de datos*/
USE db_RestaurantInMobile;
#SET SQL_SAFE_UPDATES = 0;
	
/*Table Restaurant*/
CREATE TABLE tb_User(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, /*Id de Insumos*/
	email VARCHAR(60),
	passwordUser VARCHAR(60),
	typeUser INT,
	status INT,
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);
#password = Pa55w0rd
insert into tb_User (id,email,passwordUser,typeUser,status,user_created,user_updated) values(0,'admin@inmoble.pe','UdLdXVla3TJX5ovpja8EhQ==',0,4,0,0);

/*Table Restaurant*/
CREATE TABLE tb_Restaurant(
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
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);
/*
Falta detalle de recepcion de pedidos
*/

CREATE TABLE tb_SchedulerRestaurant(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idRestaurant INT,
	dayOfWeek INT,
	specificHour VARCHAR(100),
	date_created TIMESTAMP,
	user_created INT
);

/*Table Provider*/
CREATE TABLE tb_Provider(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nameProvider VARCHAR(200),/*Nombre del Proveedor*/
	RUCProvider VARCHAR(20),/*Ruc del Proveedor*/
	phoneProvider VARCHAR(200),/*Telefono del Proveedor*/
	addressProvider VARCHAR(200),/*Direccion del Proveedor*/
	idDistrictProvide INT,/*Distrito del Proveedor*/
	idCategory INT,
	idImage INT,
	countStar INT,
	idUser INT,
	status INT,
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);

/*Table Product*/
CREATE TABLE tb_Product(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nameProduct VARCHAR(200),
	descriptionProduct VARCHAR(400),
	costPriceProduct DECIMAL(6,2) NOT NULL,/*Precio Costo*/
	salePriceProduct DECIMAL(6,2) NOT NULL,/*Precio Venta*/
	countProduct DECIMAL(6,2) NOT NULL,/*Cantidad de producto*/
	idSupplies INT,/*Insumo o Presentacion*/
	idImage INT,
	hasOfert INT,
	idOfert INT,
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);
/*ADICIONAL : Controlar stock en almacen para el proveedor de cualquier producto*/

/*Table Suplies*/
CREATE TABLE tb_Supplies(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, /*Id de Insumos*/
	nameInput VARCHAR(200),/*Nombre del insumo*/
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);

/*Table Relation between Provider and Product*/
CREATE TABLE tb_Provider_Product(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idProvider INT,
	idProduct INT
);

/*Table Category Provider*/
/*Estas categorias son para tanto para el proveedor como el restaurant??*/
CREATE TABLE tb_Category(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nameCategory VARCHAR(200),
	otherReference VARCHAR(400),
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);

/*Table Sub Category Provider*/
CREATE TABLE tb_SubCategoryProvider_1(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nameSubCategory VARCHAR(200),
	idCategory INT,
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);

/*Table Image*/
CREATE TABLE tb_Image(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	categoryImage VARCHAR(200),
	img LONGBLOB NULL,
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);
insert into tb_image (id,categoryImage) values ('0','DEFAULT_IMAGE');
commit;

/*Table Ofert*/
CREATE TABLE tb_Ofert(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	descriptionOfert VARCHAR(400),
	priceOfert DECIMAL(6,2) NOT NULL,/*Precio Oferta*/
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);

/*Table Operation*/
CREATE TABLE tb_Operation(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	typeOperation INT,/*Cotizaciono o pedido*/
	statusOperation INT,/*pendiente...etc*/
	idRestaurant INT,
	idProveedor INT,
	idNote INT,
	isUrgent INT,
	receptionDate VARCHAR(50),
	date_created TIMESTAMP,
	date_updated TIMESTAMP,
	user_created INT,
	user_updated INT
);

/*Table Detail Operation*/
CREATE TABLE tb_Detail_Operation(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idOperation INT,
	idProduct INT,
	costPriceProduct DECIMAL(6,2) NOT NULL,/*Precio Costo*/
	salePriceProduct DECIMAL(6,2) NOT NULL/*Precio Venta*/
);

/*Table Note*/
CREATE TABLE tb_Note(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	descriptionNote VARCHAR(400),
	status INT
);

CREATE TABLE tb_Request_Response(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	typeOperation VARCHAR(100),
	idUser INT,
	request LONGTEXT,
	response LONGTEXT,
	status INT,
	date_created TIMESTAMP,
	user_created INT
);
DROP TABLE IF EXISTS tb_check_active_restaurant;
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
	date_created TIMESTAMP,
	user_created INT
);

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
	date_created TIMESTAMP,
	user_created INT
);

CREATE TABLE tb_PlanMenber(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	valuePlanMenber varchar(200),
	status INT
);

insert into tb_PlanMenber (valuePlanMenber,status) values('3 Meses',1);
insert into tb_PlanMenber (valuePlanMenber,status) values('6 Meses',1);
insert into tb_PlanMenber (valuePlanMenber,status) values('12 Meses',1);
insert into tb_PlanMenber (valuePlanMenber,status) values('Free',1);
#select * from tb_PlanMenber;

CREATE TABLE tb_country(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	countryName VARCHAR(100),
	countryId VARCHAR(20)
); 
CREATE TABLE tb_departments(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	departmentName VARCHAR(100),
	countryId int
); 

CREATE TABLE tb_province(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	provinceName VARCHAR(200),
	departmentId int
);

CREATE TABLE tb_district(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	districtName VARCHAR(200),
	provinceId int
);

ALTER TABLE tb_Restaurant
ADD FOREIGN KEY (idUser)
REFERENCES tb_User(id);

ALTER TABLE tb_SchedulerRestaurant
ADD FOREIGN KEY (idRestaurant)
REFERENCES tb_Restaurant(id);

ALTER TABLE tb_Provider
ADD FOREIGN KEY (idUser)
REFERENCES tb_User(id);

ALTER TABLE tb_Product
ADD FOREIGN KEY (idSupplies)
REFERENCES tb_Supplies(id);

ALTER TABLE tb_Provider_Product
ADD FOREIGN KEY (idProvider)
REFERENCES tb_Provider(id);

ALTER TABLE tb_Provider_Product
ADD FOREIGN KEY (idProduct)
REFERENCES tb_Product(id);

ALTER TABLE tb_Provider
ADD FOREIGN KEY (idCategory)
REFERENCES tb_Category(id);

/*ALTER TABLE tb_SubCategoryProvider_1
ADD FOREIGN KEY (idCategory)
REFERENCES tb_CategoryProvider(id);
*/
ALTER TABLE tb_Provider
ADD FOREIGN KEY (idImage)
REFERENCES tb_Image(id);

ALTER TABLE tb_Product
ADD FOREIGN KEY (idImage)
REFERENCES tb_Image(id);

ALTER TABLE tb_Restaurant
ADD FOREIGN KEY (idImage)
REFERENCES tb_Image(id);

ALTER TABLE tb_Product
ADD FOREIGN KEY (idOfert)
REFERENCES tb_Ofert(id);

ALTER TABLE tb_Restaurant
ADD FOREIGN KEY (idDistrictRestaurant)
REFERENCES tb_District(id);

ALTER TABLE tb_Provider
ADD FOREIGN KEY (idDistrictProvide)
REFERENCES tb_District(id);

/*ALTER TABLE tb_Restaurant
ADD FOREIGN KEY (idNote)
REFERENCES tb_Note(id);*/

ALTER TABLE tb_check_active_restaurant
ADD FOREIGN KEY (idRestaurant)
REFERENCES tb_Restaurant(id);

ALTER TABLE tb_check_active_restaurant
ADD FOREIGN KEY (idRestaurant)
REFERENCES tb_Restaurant(id);

ALTER TABLE tb_check_active_restaurant
ADD FOREIGN KEY (idMemberShipPlan)
REFERENCES tb_PlanMenber(id);

ALTER TABLE tb_departments
ADD FOREIGN KEY (countryId)
REFERENCES tb_country(id);

ALTER TABLE tb_province
ADD FOREIGN KEY (departmentId)
REFERENCES tb_departments(id);

ALTER TABLE tb_district
ADD FOREIGN KEY (provinceId)
REFERENCES tb_province(id);

/*
drop table tb_country;
drop table tb_state;
drop table tb_city;
*/
/*
FALTA
**(OK) El restaurantero, podra seleccionar su fecha de pedido. (Ejemplo Lunes de 5 a 8) aqui seria un combo de Lunes a viernes y una caja de texto para poner la hora
**(OK) Relacion entre proveedor y producto
**(OK) tabla para soportar las presentaciones, Mantenimiento de presentacion por producto y por proveedor
**(OK) Relacion entre producto y tipo presentacion
**(OK) Marcar el pedido como urgente.
**(OK) En la tabla de recepcion de pedido tiene que ir un campo fecha de entraga.

**(OK) Tabla de notificaciones

**(OK) Tabla de sucursales que estara relacionada a restaurantero

tabla usuario y contraseña tiene que estar relacionada con proveedor y restaurantero

tabla de reques y response de servicios
*/