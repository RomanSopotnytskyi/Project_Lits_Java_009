-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Cinemadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Cinemadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Cinemadb` DEFAULT CHARACTER SET utf8 ;
USE `Cinemadb` ;

-- -----------------------------------------------------
-- Table `Cinemadb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`user` (
  `iduser` INT NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `userStatus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`));


-- -----------------------------------------------------
-- Table `Cinemadb`.`userInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`userInfo` (
  `idUser` INT NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `age` INT NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_userInfo_user1_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_userInfo_user`
    FOREIGN KEY (`idUser`)
    REFERENCES `Cinemadb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemadb`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`movies` (
  `idMovie` INT NOT NULL AUTO_INCREMENT,
  `movieTitle` VARCHAR(45) NOT NULL,
  `movieYear` INT NOT NULL,
  `movieLength` VARCHAR(45) NOT NULL,
  `movieGenre` VARCHAR(45) NOT NULL,
  `movieTrailer` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idMovie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemadb`.`responseMovies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`responseMovies` (
  `idResponse` INT NOT NULL,
  `idUser` INT NOT NULL,
  `idMovies` INT NULL,
  `ratingMovies` INT NOT NULL,
  `feedbackAboutFilm` VARCHAR(500) NULL,
  INDEX `idUser_idx` (`idUser` ASC) VISIBLE,
  PRIMARY KEY (`idResponse`),
  INDEX `response_movies_idx` (`idMovies` ASC) VISIBLE,
  CONSTRAINT `response_user`
    FOREIGN KEY (`idUser`)
    REFERENCES `Cinemadb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `response_movies`
    FOREIGN KEY (`idMovies`)
    REFERENCES `Cinemadb`.`movies` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemadb`.`sessionSchedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`sessionSchedule` (
  `idsession` INT NOT NULL AUTO_INCREMENT,
  `dateSeassion` DATE NOT NULL,
  `sessionStartTtime` VARCHAR(15) NOT NULL,
  `idMovie` INT NOT NULL,
  PRIMARY KEY (`idsession`),
  INDEX `sessionSchedle_movies_idx` (`idMovie` ASC) VISIBLE,
  CONSTRAINT `sessionSchedle_movies`
    FOREIGN KEY (`idMovie`)
    REFERENCES `Cinemadb`.`movies` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemadb`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`ticket` (
  `idTicket` INT NOT NULL,
  `idUser` INT NOT NULL,
  `idSeassion` INT NOT NULL,
  `placeNumber` INT NULL,
  PRIMARY KEY (`idTicket`),
  INDEX `idSeassion_idx` (`idSeassion` ASC) VISIBLE,
  INDEX `ticket_user_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `idSeassion`
    FOREIGN KEY (`idSeassion`)
    REFERENCES `Cinemadb`.`sessionSchedule` (`idsession`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ticket_user`
    FOREIGN KEY (`idUser`)
    REFERENCES `Cinemadb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
