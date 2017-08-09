DROP DATABASE IF EXISTS eshop;

CREATE DATABASE eshop;

USE eshop;

-- ----------------------------------------
-- Rank table
-- ----------------------------------------

CREATE TABLE rank (
	id			TINYINT			AUTO_INCREMENT,
	name		VARCHAR(20)		NOT NULL,
	score		INT				NOT NULL,
	discount	DECIMAL(3, 2)	NOT NULL,
	CONSTRAINT rank_pk PRIMARY KEY(id)
);

INSERT INTO rank(name, score, discount) VALUES('1 rank', 0, 0.90);
INSERT INTO rank(name, score, discount) VALUES('2 rank', 100, 0.85);
INSERT INTO rank(name, score, discount) VALUES('3 rank', 500, 0.80);
INSERT INTO rank(name, score, discount) VALUES('4 rank', 1000, 0.75);
INSERT INTO rank(name, score, discount) VALUES('5 rank', 5000, 0.70);

SELECT * FROM rank;

-- ----------------------------------------
-- Customer table
-- ----------------------------------------

CREATE TABLE customer (
	username		VARCHAR(20),
	password		VARCHAR(150)	NOT NULL,
	real_name		VARCHAR(20),
	gender			CHAR(1)			DEFAULT 'M',
	birthday		DATE,
	question		VARCHAR(50),
	answer			VARCHAR(50),
	rank_id			TINYINT			DEFAULT 1,
	score			INT				DEFAULT 0,
	mobile			VARCHAR(20),
	email			VARCHAR(50),
	province		VARCHAR(20),
	city			VARCHAR(40),
	county			VARCHAR(40),
	address			VARCHAR(100),
	zipcode			CHAR(6),
	CONSTRAINT customer_pk PRIMARY KEY(username),
	CONSTRAINT customer_rank_fk FOREIGN KEY(rank_id) REFERENCES rank(id)
);

INSERT INTO customer VALUES(
	'zhangsan',
	MD5('123456'),
	'Zhang San', 'M',
	'1994-02-19',
	'Favorite number', '2',
	1, 0,
	'13012345678',
	'zhangs@abc.com',
	'Tianjin', 'Tianjin', 'Nankai District',
	'Tianjin-Tianjin-Nankai District-No. 92 Weijin Road',
	'300072');

INSERT INTO customer VALUES(
	'guest',
	MD5('123456'),
	'Mr. Li', 'M',
	'1992-02-19',
	'Favorite number', '3',
	1, 0,
	'13112345678',
	'mrlee@abc.com',
	'Tianjin', 'Tianjin', 'Nankai District',
	'Tianjin-Tianjin-Nankai District-Tianjin University',
	'300072');

INSERT INTO customer VALUES(
	'abc',
	MD5('123456'),
	'Chen Xiaohong', 'M',
	'1993-02-19',
	'Mom''s name', 'Lily',
	1, 0,
	'13212345678',
	'chenxiaohong@abc.com',
	'Tianjin', 'Tianjin', 'Nankai District',
	'Tianjin-Tianjin-Nankai District-Tianjin University',
	'300072');

SELECT * FROM customer;

-- ----------------------------------------
-- User roles table
-- ----------------------------------------

CREATE TABLE user_roles (
	id			INT				AUTO_INCREMENT,
	username	VARCHAR(20)		NOT NULL,
	rolename	VARCHAR(20)		NOT NULL,
	CONSTRAINT user_roles_pk PRIMARY KEY(id),
	CONSTRAINT user_roles_fk FOREIGN KEY(username) REFERENCES customer(username)  
);

INSERT INTO user_roles VALUES (0, 'zhangsan', 'USER');
INSERT INTO user_roles VALUES (0, 'guest', 'USER');
INSERT INTO user_roles VALUES (0, 'abc', 'ADMIN');

SELECT * FROM user_roles;

-- ----------------------------------------
-- Login table
-- ----------------------------------------

CREATE TABLE login
(
	id			INT				AUTO_INCREMENT,
	username	VARCHAR(20)		NOT NULL,
	ip_addr		VARCHAR(15)		NOT NULL,
	login_time	DATETIME		NOT NULL,
	CONSTRAINT login_pk PRIMARY KEY(id),
	CONSTRAINT login_customer_fk FOREIGN KEY(username) REFERENCES customer(username)
);

INSERT INTO login VALUES (0, 'zhangsan', '127.0.0.1', CURRENT_TIMESTAMP);
INSERT INTO login VALUES (0, 'guest', '127.0.0.1', CURRENT_TIMESTAMP);
INSERT INTO login VALUES (0, 'abc', '127.0.0.1', CURRENT_TIMESTAMP);

SELECT * FROM login;

-- ----------------------------------------
-- Category table
-- ----------------------------------------

CREATE TABLE category
(
	id				INT				AUTO_INCREMENT,
	name			VARCHAR(20)		NOT NULL,
	description		VARCHAR(100),
	CONSTRAINT category_pk PRIMARY KEY(id)
);

INSERT INTO category VALUES (0, 'Apple', 'iPhone mobile phone');
INSERT INTO category VALUES (0, 'Samsung', 'Samsung mobile phone');
INSERT INTO category VALUES (0, 'Huawei', 'Huawei mobile phone');
INSERT INTO category VALUES (0, 'Lenovo', 'Lenovo laptop');

SELECT * FROM category;

-- ----------------------------------------
-- Product table
-- ----------------------------------------

CREATE TABLE product
(
	id				INT				AUTO_INCREMENT,
	category_id		INT				NOT NULL,
	image			VARCHAR(200),	
	name			VARCHAR(20)		NOT NULL,
	market_price	NUMERIC(20, 2)	NOT NULL, 				-- DECIMAL
	is_on_sale		BOOLEAN			DEFAULT 0	NOT NULL, 	-- TINYINT(1)
	discount		NUMERIC(3, 2)	DEFAULT 1,
	pub_date		DATE			NOT NULL,
	stock_count		INT				NOT NULL,
	sale_count		INT				DEFAULT 0	NOT NULL,
	summary			VARCHAR(100)	NOT NULL,
	detail			TEXT, 									-- CLOB Character Large OBject ; BLOB Binary Large OBject
	CONSTRAINT product_pk PRIMARY KEY(id),
	CONSTRAINT product_category_fk FOREIGN KEY(category_id) REFERENCES category(id)
);

INSERT INTO product VALUES(0, 1, '1.jpg', 'Apple iPhone 6',
	821.95, 0, 1, CURRENT_DATE, 10, 0, 'Apple iPhone 6, Gold, 64 GB', 'Built on 64-bit desktop-class architecture, the new A8 chip delivers more power, even while driving a larger display. Other Features include: Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi hotspot, Bluetooth: v4.0, A2DP, USB: v2.0, GPS: with A-GPS, GLONASS, Browser: HTML (Safari), Messaging: iMessage, SMS (threaded view), MMS, Email, Push Email, Built-in rechargeable lithium-ion Battery, Talktime: Up to 14 Hours (3G), Standby: Up to 250 Hours (3G)');
INSERT INTO product VALUES(0, 1, '2.jpg', 'iPhone 5',
	329.00, 1, 0.9, CURRENT_DATE, 5, 0, 'iPhone 5 16GB Black A1428 GSM FACTORY UNLOCKED', '4-inch Retina display A6 chip, iOS 6 and iCloud 8.0MP iSight camera All-new EarPods and improved audio Unlocked cell phones are compatible with GSM carriers like AT&T and T-Mobile as well as with GSM SIM cards (e.g. H20 and select prepaid carriers). Unlocked cell phones will not work with CDMA Carriers like Sprint, Verizon, Boost or Virgin.Packaging not sealed to verify content UPC# 85909-530175 Model Number# A1428');
INSERT INTO product VALUES(0, 2, '3.jpg', 'Samsung Note 4',
	729.99, 0, 1, CURRENT_DATE, 20, 0, 'Samsung Galaxy Note 4, Charcoal Black 32GB (Verizon Wireless)', 'Our 5.7-inch Quad HD Super AMOLED display features more pixels per inch than any other display we’ve made. That means images are clearer, brighter and more captivating than ever before. And now you can capture video in the same high resolution as the display so your personal videos look better than ever before.');
INSERT INTO product VALUES(0, 2, '4.jpg', 'Samsung Galaxy Grand',
	172.18, 1, 0.8, CURRENT_DATE, 15, 0, 'Samsung Galaxy Grand Prime G530H/DS Factory Unlocked Phone - Retail Packaging - Gray', 'The GALAXY Grand Prime has a 5 MP front camera with an ultra-wide view angle of 85 degrees. Other Features include: Wi-Fi 802.11 b/g/n, Wi-Fi Direct, Wi-Fi hotspot, Bluetooth: v4.0, A2DP, USB: micro USB v2.0, GPS: with A-GPS, Beidou, Browser: HTML5, Messaging: SMS (threaded view), MMS, Email, Push Mail, IM, Li-Ion 2600 mAh Battery, Talk time: (2G) / Up to 17 Hours (3G)');
INSERT INTO product VALUES(0, 3, '5.jpg', 'Huawei Ascend G7',
	425.00, 1, 0.9, CURRENT_DATE, 15, 0, 'Huawei Ascend G7 GSM Unlocked Smartphone 5.5 inch 2GB + 16GB', 'OS: Android 4.4, EMUI 3.0 CPU: MSM8916 Quad Core 1.2GHz Storage: RAM 2GB + ROM 16GB, TF card up to 32G (not included) Display: 5.5 inch IPS LTPS Screen Capacitive Screen 1280 x 720 pixels Camera: Front 5.0MP, Back 13MP AF BSI F2.0, with Flash) ');
INSERT INTO product VALUES(0, 3, '6.jpg', 'Huawei Ascend P6',
	161.99, 0, 1, CURRENT_DATE, 3, 0, 'Huawei Ascend P6 Unlocked smartphone 1.5GHz Quad core K3V2E 6.18mm Thickness', '6.18mm Thickness 1.5GHz Quad core K3V2E Android 4.2 ( Emotion UI 1.6 ) 1280*720 incell screen Packing Included Cell Phone Micro USB cable Charger Li Battery earphone');
INSERT INTO product VALUES(0, 4, '7.jpg', 'Lenovo Z50 Laptop',
	593.99, 0, 1, CURRENT_DATE, 50, 0, 'Lenovo Z50 Laptop Computer - 59436279 - Black - 4th Generation Intel Core', 'It''s about balance, not compromise. The IdeaPad Z Series Laptops are solid, stylish, portable PCs. If you''re looking for a laptop with a unique mix of entertainment features, modern style, and affordable pricing, look no further. Z Series laptops are ideal for study, entertainment, online chats, and everyday use. They run on powerful multi-core processors from Intel, so they deliver smart, efficient multitasking and reliable on-demand performance - just what you are looking for in an entertainment laptop. What''s more, Z Series laptops sport contemporary styling and come in a range of vivid, colorful designs. Whether you''re looking for an entertainment and social networking device or shopping for a laptop with the best multimedia features you can afford, the IdeaPad Z Series is a good choice.');
INSERT INTO product VALUES(0, 4, '8.jpg', 'Lenovo G50 15.6-Inch',
	339.99, 1, 0.9, CURRENT_DATE, 30, 0, 'Lenovo G50 15.6-Inch Laptop (Core i3, 6 GB, 500 GB)', 'The affordable Lenovo G50 notebook is less than 1" slim, but packed with features like an integrated DVD drive, the latest processor and HD graphics. Plus, stereo speakers coupled with Dolby audio certification make the G50 good for everyday multimedia applications while on the go or at home.');

SELECT * FROM product;

-- ----------------------------------------
-- Order status table
-- ----------------------------------------

CREATE TABLE order_status
(
	id			INT				AUTO_INCREMENT,
	name		VARCHAR(50)		NOT NULL,
	CONSTRAINT order_status_pk PRIMARY KEY(id)
);

INSERT INTO order_status VALUES (0, 'Not placing the order yet');
INSERT INTO order_status VALUES (0, 'Pending');
INSERT INTO order_status VALUES (0, 'Packing');
INSERT INTO order_status VALUES (0, 'Waiting for payment');
INSERT INTO order_status VALUES (0, 'Shipping');
INSERT INTO order_status VALUES (0, 'Completed');

SELECT * FROM order_status;

-- ----------------------------------------
-- Payment method table
-- ----------------------------------------

CREATE TABLE payment_method
(
	id			INT				AUTO_INCREMENT,
	name		VARCHAR(20)		NOT NULL,
	CONSTRAINT payment_method_pk PRIMARY KEY(id)
);

INSERT INTO payment_method VALUES (0, 'Cash on delivery');
INSERT INTO payment_method VALUES (0, 'Online payment');

SELECT * FROM payment_method;

-- ----------------------------------------
-- Send method table
-- ----------------------------------------

CREATE TABLE send_method
(
	id			INT				AUTO_INCREMENT,
	name		VARCHAR(20)		NOT NULL,
	CONSTRAINT send_method_pk PRIMARY KEY(id)
);

INSERT INTO send_method VALUES (0, 'Ordinary');
INSERT INTO send_method VALUES (0, 'Express');

SELECT * FROM send_method;

-- ----------------------------------------
-- Order table
-- ----------------------------------------

CREATE TABLE `orders`
(
	id					INT				AUTO_INCREMENT,
	customer_id			VARCHAR(20)		NOT NULL,
	status_id			INT				NOT NULL,
	price				NUMERIC(10, 2)	NOT NULL,
	payment_method_id	INT				NOT NULL,
	send_method_id		INT				NOT NULL,
	place_time			DATETIME		NOT NULL,
	send_time			DATETIME,
	invoice_title		VARCHAR(50)		NOT NULL,
	invoice_item		VARCHAR(20)		NOT NULL,
	CONSTRAINT order_pk PRIMARY KEY(id),
	CONSTRAINT order_customer_fk FOREIGN KEY(customer_id) REFERENCES customer(username),
	CONSTRAINT order_order_status_fk FOREIGN KEY(status_id) REFERENCES order_status(id),
	CONSTRAINT order_payment_method_fk FOREIGN KEY(payment_method_id) REFERENCES payment_method(id),
	CONSTRAINT order_send_method_fk FOREIGN KEY(send_method_id) REFERENCES send_method(id)
);

INSERT INTO `orders` VALUES (0, 'zhangsan',
	2, 1443.99, 1, 1, CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 1 DAY), 'Tianjin University', 'electronic products');

SELECT * FROM `orders`;

-- ----------------------------------------
-- Item table
-- ----------------------------------------

CREATE TABLE item
(
	id				INT					AUTO_INCREMENT,
	order_id		INT					NOT NULL,
	product_id		INT					NOT NULL,
	`count`			INT					DEFAULT 1		NOT NULL,
	price			NUMERIC(10, 2)		NOT NULL,
	CONSTRAINT item_pk PRIMARY KEY(id),
	CONSTRAINT item_order_fk FOREIGN KEY(order_id) REFERENCES `orders`(id),
	CONSTRAINT item_product_fk FOREIGN KEY(product_id) REFERENCES product(id)
);

INSERT INTO item VALUES(0, 1, 5, 2, 850.00);
INSERT INTO item VALUES(0, 1, 7, 1, 593.99);

SELECT * FROM item;
