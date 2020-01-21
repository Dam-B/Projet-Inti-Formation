CREATE SCHEMA IF NOT EXISTS adopt_a_pet ;
USE adopt_a_pet ;

CREATE TABLE adoption (
  idadoption int(11) NOT NULL AUTO_INCREMENT,
  iduser int(11) NOT NULL,
  idpet int(11) NOT NULL,
  date_demande datetime NOT NULL,
  validation_profile tinyint(4) NOT NULL,
  validation_paiement tinyint(4) NOT NULL,
  PRIMARY KEY (idadoption)
) ;

CREATE TABLE centre (
  idcentre int(11) NOT NULL AUTO_INCREMENT,
  iduser int(11) ,
  name varchar(45) NOT NULL,
  deptid int(11) NOT NULL,
  tel varchar(45) DEFAULT NULL,
  city varchar(45) DEFAULT NULL,
  postal_code varchar(45) DEFAULT NULL,
  PRIMARY KEY (idcentre)
) ;

CREATE TABLE departement (
  deptid int(11) NOT NULL AUTO_INCREMENT,
  departement_code int(11) NOT NULL,
  name varchar(45) NOT NULL,
  PRIMARY KEY (deptid)
) ;

CREATE TABLE historique (
  idhistorique int(11) NOT NULL AUTO_INCREMENT,
  idpet int(11) NOT NULL,
  iduser int(11) NOT NULL,
  deptid int(11) NOT NULL,
  debut_sejour datetime NOT NULL,
  fin_sejour datetime DEFAULT NULL,
  PRIMARY KEY (idhistorique)
) ;

CREATE TABLE individual (
  idindvidual INT(11) NOT NULL AUTO_INCREMENT,
  iduser int(11) NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  mail varchar(45) NOT NULL,
  tel varchar(45) NOT NULL,
  adress varchar(45) DEFAULT NULL,
  city varchar(45) DEFAULT NULL,
  postal_code int(11) NOT NULL,
  PRIMARY KEY (idindvidual)
) ;

CREATE TABLE paiement (
  idpaiement int(11) NOT NULL AUTO_INCREMENT,
  idadoption int(11) NOT NULL,
  PRIMARY KEY (idpaiement)
) ;

CREATE TABLE title (
  idtitle int(11) NOT NULL AUTO_INCREMENT,
  title varchar(45) NOT NULL,
  PRIMARY KEY (idtitle)
) ;

CREATE TABLE transfert (
  idtransfert int(11) NOT NULL AUTO_INCREMENT,
  idpet int(11) NOT NULL,
  iduser int(11) NOT NULL,
  new_id_user int(11) NOT NULL,
  PRIMARY KEY (idtransfert)
) ;

CREATE TABLE categorie (
  idcat int(11) NOT NULL AUTO_INCREMENT,
  categorie varchar(45) NOT NULL,
  PRIMARY KEY (idcat)
) ;


CREATE TABLE user (
  iduser int(11) NOT NULL AUTO_INCREMENT,
  idpet int(11),
  deptid int(11) NOT NULL,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  idtitle int(11) NOT NULL,
  date_creation datetime DEFAULT NULL,
  date_fermeture datetime DEFAULT NULL,
  PRIMARY KEY (iduser)
) ;

CREATE TABLE pet (
  idpet int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  idcat int(11) NOT NULL,
  race varchar(45) DEFAULT NULL,
  age varchar(45) DEFAULT NULL,
  iduser int(11) NOT NULL,
  deptid int(11) NOT NULL,
  PRIMARY KEY (idpet)
) ;
Alter table adoption
add constraint iduser_user_adoption_idx
foreign key (iduser)
references user (iduser)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table adoption
add constraint idpet_pet_adoption_idx
foreign key(idpet)
references pet (idpet)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

Alter table centre
add constraint iduser_user_centre_idx
foreign key (iduser)
references user (iduser)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table centre
add constraint deptid_departement_centre_idx
foreign key (deptid)
references departement (deptid)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

Alter table historique
add constraint idpet_idx
foreign key (idpet)
references pet (idpet)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table historique
add constraint deptid_idx
foreign key (deptid)
references departement (deptid)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table historique
add constraint iduser_user_historique_idx
foreign key (iduser)
REFERENCES user (iduser)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

Alter table individual
add constraint iduser_user_individual_idx
foreign key (iduser)
REFERENCES user (iduser)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

Alter table paiement
add CONSTRAINT idadoption_adoption_paiement
FOREIGN KEY (idadoption)
REFERENCES adopt_a_pet.adoption (idadoption)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

Alter table transfert
add CONSTRAINT idpet_pet_transfert
FOREIGN KEY (idpet)
REFERENCES pet (idpet)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table transfert
add CONSTRAINT iduser_user_transfert
FOREIGN KEY (iduser)
REFERENCES user (iduser)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table transfert
add CONSTRAINT newiduser_user_transfert
FOREIGN KEY (new_id_user)
REFERENCES user (iduser)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

Alter table user
add CONSTRAINT deptid_departement_user
FOREIGN KEY (deptid)
REFERENCES departement (deptid)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table user
add CONSTRAINT idpet_pet_user
FOREIGN KEY (idpet)
REFERENCES pet (idpet)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table user
add CONSTRAINT idtitle_title_user
FOREIGN KEY (idtitle)
REFERENCES title (idtitle)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

Alter table pet
add CONSTRAINT idcat_categorie_pet
FOREIGN KEY (idcat)
REFERENCES categorie (idcat)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
Alter table pet
add CONSTRAINT iduser_user_pet
FOREIGN KEY (iduser)
REFERENCES user (iduser)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
ALTER TABLE `adopt_a_pet`.`pet` 
ADD CONSTRAINT `deptid_departement_pet`
  FOREIGN KEY (`deptid`)
  REFERENCES `adopt_a_pet`.`departement` (`deptid`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;