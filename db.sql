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
-- Table `Cinemadb`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`movies` (
  `id_movie` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `year` INT NULL,
  `length` VARCHAR(45) NULL,
  `genre` VARCHAR(45) NULL,
  `trailer` VARCHAR(200) NULL,
  PRIMARY KEY (`id_movie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemadb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `userstatus` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `age` INT NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`id_user`));


-- -----------------------------------------------------
-- Table `Cinemadb`.`response`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`response` (
  `id_response` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_movies` INT NOT NULL,
  `rating_movies` INT NULL,
  `feedback_about_film` VARCHAR(500) NULL,
  INDEX `idUser_idx` (`id_user` ASC) VISIBLE,
  PRIMARY KEY (`id_response`),
  INDEX `response_movies_idx` (`id_movies` ASC) VISIBLE,
  CONSTRAINT `response_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `Cinemadb`.`user` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `response_movies`
    FOREIGN KEY (`id_movies`)
    REFERENCES `Cinemadb`.`movies` (`id_movie`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemadb`.`seassion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`seassion` (
  `id_session` INT NOT NULL AUTO_INCREMENT,
  `id_movie` INT NOT NULL,
  `date_seassion` DATE NULL,
  `session_start_ttime` VARCHAR(15) NULL,
  PRIMARY KEY (`id_session`),
  INDEX `sessionSchedle_movies_idx` (`id_movie` ASC) VISIBLE,
  CONSTRAINT `session_movies`
    FOREIGN KEY (`id_movie`)
    REFERENCES `Cinemadb`.`movies` (`id_movie`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cinemadb`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cinemadb`.`ticket` (
  `id_ticket` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_seasson` INT NOT NULL,
  `place` INT NULL,
  `price` INT NULL,
  `type` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id_ticket`),
  INDEX `ticket_user_idx` (`id_user` ASC) VISIBLE,
  INDEX `ticket_seasson_idx` (`id_seasson` ASC) VISIBLE,
  CONSTRAINT `ticket_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `Cinemadb`.`user` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ticket_seasson`
    FOREIGN KEY (`id_seasson`)
    REFERENCES `Cinemadb`.`seassion` (`id_session`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
