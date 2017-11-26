-- MySQL Workbench Forward Engineering






SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sportclusters
-- -----------------------------------------------------

/*
drop table AUTHORITY;
drop table EVENT;
drop table EVENT_LOCATION;
drop table LOCATION;
drop table USER;
drop table USER_AUTHORITY;
drop table USER_EVENT;*/




-- -----------------------------------------------------
-- Schema sportclusters
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sportclusters` DEFAULT CHARACTER SET utf8 ;
USE `sportclusters` ;

-- -----------------------------------------------------
-- Table `sportclusters`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclusters`.`user` (
  `id` VARCHAR(36) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `firstname` VARCHAR(100) NULL,
  `lastname` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `enabled` TINYINT NULL,
  `lastpasswordresetdate` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `USER_USERNAME` (`USERNAME` ASC))
ENGINE = InnoDB
COMMENT = 'Bussiness key : [USERNAME]';


-- -----------------------------------------------------
-- Table `sportclusters`.`AUTHORITY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclusters`.`authority` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `AUTHORITY_NAME` (`NAME` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sportclusters`.`USER_AUTHORITY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclusters`.`user_authority` (
  `user_id` VARCHAR(36) NOT NULL,
  `authority_id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`user_id`, `authority_id`),
  INDEX `fk_USER_AUTHORITY_USER_idx` (`USER_ID` ASC),
  INDEX `fk_USER_AUTHORITY_AUTHORITY1_idx` (`AUTHORITY_ID` ASC),
  UNIQUE INDEX `USER_AUTHORITY_USER_AUTHORITY` (`USER_ID` ASC, `AUTHORITY_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sportclusters`.`LOCATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclusters`.`location` (
  `id` BINARY(16) NOT NULL,
  `latitude` FLOAT NOT NULL,
  `longitude` FLOAT NOT NULL,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Bussiness key: [LATITUDE, LONGITUDE]';


-- -----------------------------------------------------
-- Table `sportclusters`.`EVENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclusters`.`event` (
  `id` VARCHAR(36) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `max_players_number` INT NULL,
  `id_owner` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_EVENT_USER1_idx` (`ID_OWNER` ASC),
  UNIQUE INDEX `EVENT_OWNER_DATE` (`ID_OWNER` ASC, `START_DATE` ASC),
  CONSTRAINT `fk_EVENT_USER1`
    FOREIGN KEY (`ID_OWNER`)
    REFERENCES `sportclusters`.`user` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Bussiness key: [START_DATE, ID_OWNER]';


-- -----------------------------------------------------
-- Table `sportclusters`.`USER_EVENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclusters`.`user_event` (
  `id` VARCHAR(36) NOT NULL,
  `guestsnumber` INT NULL,
  `id_joined_user` VARCHAR(36) NOT NULL,
  `id_event` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_USER_EVENT_USER1_idx` (`ID_JOINED_USER` ASC),
  INDEX `fk_USER_EVENT_EVENT1_idx` (`ID_EVENT` ASC),
  UNIQUE INDEX `USER_EVENT_USER_EVENT` (`ID_JOINED_USER` ASC, `ID_EVENT` ASC))
ENGINE = InnoDB
COMMENT = 'For every event we store the joined users and for every user we can add a number of guests';


-- -----------------------------------------------------
-- Table `sportclusters`.`EVENT_LOCATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclusters`.`event_location` (
  `id` VARCHAR(36) NOT NULL,
  `id_location` VARCHAR(36) NOT NULL,
  `id_event` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_EVENT_LOCATION_LOCATION1_idx` (`ID_LOCATION` ASC),
  INDEX `fk_EVENT_LOCATION_EVENT1_idx` (`ID_EVENT` ASC),
  UNIQUE INDEX `EVENT_LOCATION_EVENT_LOCATION` (`ID_EVENT` ASC, `ID_LOCATION` ASC),
  CONSTRAINT `fk_EVENT_LOCATION_LOCATION1`
    FOREIGN KEY (`ID_LOCATION`)
    REFERENCES `sportclusters`.`location` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EVENT_LOCATION_EVENT1`
    FOREIGN KEY (`ID_EVENT`)
    REFERENCES `sportclusters`.`event` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
