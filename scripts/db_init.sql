/*
	SINIF:
		0: Superuser
		1: Bakici
		2: Musteri
*/

/* User_ TABLE AND INHERITING TABLES */
DROP TABLE IF EXISTS User_ CASCADE;
CREATE TABLE User_(
	user_id SERIAL,
	isim varchar(50) NOT NULL,
	email varchar(50) NOT NULL UNIQUE,
	sifre varchar(20) NOT NULL,
	sinif int NOT NULL,
	PRIMARY KEY(user_id)
);

	/* INHERITING TABLES */
	DROP TABLE IF EXISTS Superuser CASCADE;
	CREATE TABLE Superuser(
		su_id SERIAL,
		PRIMARY KEY(su_id)
	) INHERITS(User_);
	
	DROP TABLE IF EXISTS Musteri CASCADE;
	CREATE TABLE Musteri(
		musteri_id SERIAL,
		gecmis_alisveris int DEFAULT 0,
		PRIMARY KEY(musteri_id)
	) INHERITS(User_);
	
	DROP TABLE IF EXISTS Bakici CASCADE;
	CREATE TABLE Bakici(
		bakici_id SERIAL,
		gecmis_alisveris int DEFAULT 0,
		neg_referans int DEFAULT 0,
		poz_referans int DEFAULT 0,
		PRIMARY KEY(bakici_id)
	) INHERITS(User_);

/* END OF User_ TABLE AND INHERITING TABLES */

 
/*	ILAN
	ONE-TO-MANY 
*/

DROP TABLE IF EXISTS Ilan CASCADE;
CREATE TABLE Ilan(
	ilan_id SERIAL,
	bakici_id int, --FK
	aciklama varchar(100) NOT NULL,
	ucret float(2) NOT NULL,
	aktif bool DEFAULT true,
	PRIMARY KEY(ilan_id),
	
	CONSTRAINT fk_bakici_id
		FOREIGN KEY(bakici_id)
			REFERENCES Bakici(bakici_id)
				ON DELETE CASCADE
				ON UPDATE CASCADE
);

/*	MusteriXilan
	MANY-TO-MANY 
*/
DROP TABLE IF EXISTS MusteriXilan CASCADE;
CREATE TABLE MusteriXilan(
	alisveris_id SERIAL,
	ilan_id int, -- FK
	musteri_id int, -- FK
	odendi bool DEFAULT false,
	PRIMARY KEY(alisveris_id),
	
	CONSTRAINT fk_musteri_id
		FOREIGN KEY(musteri_id)
			REFERENCES Musteri(musteri_id)
				ON DELETE CASCADE
				ON UPDATE CASCADE,
	
	CONSTRAINT fk_ilan_id
		FOREIGN KEY(ilan_id)
			REFERENCES Ilan(ilan_id)
				ON DELETE CASCADE
				ON UPDATE CASCADE
);

/*
	Global Configuration Table
	for the web platform
*/
DROP TABLE IF EXISTS Config CASCADE;
CREATE TABLE Config(
	_option varchar(20) NOT NULL UNIQUE,
	_value varchar(20) NOT NULL DEFAULT 0,
	PRIMARY KEY(_option)
);
INSERT INTO Config(_option, _value) VALUES('komisyon', '25');

/*
	Login Event Logger Table
*/
DROP TABLE IF EXISTS login_log CASCADE;
CREATE TABLE login_log(
	login_id SERIAL,
	user_id int NOT NULL,
	tarih TIMESTAMP DEFAULT NOW(),
	ip_addr varchar(50) NOT NULL,
	PRIMARY KEY(login_id)
);

/*
	Table for holding document paths
*/
DROP TABLE IF EXISTS doc CASCADE;
CREATE TABLE doc(
	doc_id SERIAL,
	doc_path varchar(100) NOT NULL,
	PRIMARY KEY(doc_id)
); 

/*	Kazanc
	MusteriXilan / odendi == True
*/
DROP TABLE IF EXISTS Kazanc CASCADE;
CREATE TABLE Kazanc(
	kazanc_id SERIAL,
	alisveris_id int,
	komisyon int,
	referans bool DEFAULT false,
	PRIMARY KEY(kazanc_id),
	
	CONSTRAINT fk_alisveris_id
		FOREIGN KEY(alisveris_id)
			REFERENCES MusteriXilan(alisveris_id)
				ON DELETE CASCADE
				ON UPDATE CASCADE
);

/*
	Referans
	Kazanc / referans == True
*/
DROP TABLE IF EXISTS Referans CASCADE;
CREATE TABLE Referans(
	ref_id SERIAL,
	kazanc_id int,
	alisveris_id int,
	deger int NOT NULL,
	PRIMARY KEY(ref_id),
	
	CONSTRAINT fk_kazanc_id
		FOREIGN KEY(kazanc_id)
			REFERENCES Kazanc(kazanc_id), -- WHERE referans = TRUE
	
	CONSTRAINT fk_alisveris_id
		FOREIGN KEY(alisveris_id)
			REFERENCES MusteriXilan(alisveris_id)
);

/* Functions */
CREATE OR REPLACE FUNCTION kazanc_guncelle()
	RETURNS TRIGGER 
	AS
		$$
		DECLARE
			komisyon int = (SELECT _value FROM Config WHERE _option = 'komisyon');
		BEGIN		
			INSERT INTO Kazanc(komisyon, alisveris_id)
			VALUES(
				komisyon,
				OLD.alisveris_id
			);
			RETURN NEW;
		END;
		$$ LANGUAGE PLPGSQL;

/* Triggers */
CREATE OR REPLACE TRIGGER kazanc_guncelle_trigger
	AFTER UPDATE OF odendi ON MusteriXilan
	FOR EACH ROW
	WHEN (OLD.odendi = false AND NEW.odendi = true)
	EXECUTE FUNCTION kazanc_guncelle();

--CREATE OR REPLACE TRIGGER referans_guncelle_trigger
--	AFTER UPDATE OF referans ON Kazanc
--	FOR EACH ROW
--	WHEN (OLD.referans = false AND NEW.referans = true)
--	EXECUTE FUNCTION referans_guncelle();

/*
	---- TEST ----
*/

INSERT INTO Bakici(isim, email, sifre, sinif) VALUES('Ece', 'ece@mail.com', '12345', 1);
INSERT INTO Musteri(isim, email, sifre, sinif) VALUES('Hasan', 'hasan@mail.com', '12345', 2);
INSERT INTO Ilan(bakici_id, ucret, aciklama) VALUES(1, 120.99, 'asfasfdfaasf');
INSERT INTO MusteriXilan(ilan_id, musteri_id) VALUES(1, 1);
INSERT INTO MusteriXilan(ilan_id, musteri_id) VALUES(1, 1);

UPDATE MusteriXilan
	SET odendi = true
	WHERE alisveris_id = 2;

SELECT * FROM kazanc;