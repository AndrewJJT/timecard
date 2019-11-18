-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema TimeCard
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `TimeCard`;
-- -----------------------------------------------------
-- Schema TimeCard
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TimeCard` DEFAULT CHARACTER SET utf8 ;
USE `TimeCard` ;

-- -----------------------------------------------------
-- Table `TimeCard`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TimeCard`.`role` (
  `RoleId` INT NOT NULL AUTO_INCREMENT,
  `RoleDesc` NVARCHAR(255) NOT NULL,
  PRIMARY KEY (`RoleId`),
  UNIQUE INDEX `RoleId_UNIQUE` (`RoleId` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TimeCard`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TimeCard`.`user` (
  `UserId` INT NOT NULL AUTO_INCREMENT,
  `Fname` NVARCHAR(255) NOT NULL,
  `Lname` NVARCHAR(255) NOT NULL,
  `UserName` NVARCHAR(255) NOT NULL,
  `UserPassword` NVARCHAR(255) NOT NULL,
  `RoleId` INT NOT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE INDEX `UserId_UNIQUE` (`UserId` ASC) VISIBLE,
  INDEX `fk_user_role1_idx` (`RoleId` ASC) VISIBLE,
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`RoleId`)
    REFERENCES `TimeCard`.`role` (`RoleId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TimeCard`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TimeCard`.`status` (
  `StatusId` INT NOT NULL AUTO_INCREMENT,
  `StatusDesc` NVARCHAR(255) NOT NULL,
  UNIQUE INDEX `StatusId_UNIQUE` (`StatusId` ASC) VISIBLE,
  PRIMARY KEY (`StatusId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TimeCard`.`timesheet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TimeCard`.`timesheet` (
  `TimeSheetId` INT NOT NULL AUTO_INCREMENT,
  `MondayHours` FLOAT NULL,
  `TuesdayHours` FLOAT NULL,
  `WednesdayHours` FLOAT NULL,
  `ThursdayHours` FLOAT NULL,
  `FridayHours` FLOAT NULL,
  `SaturdayHours` FLOAT NULL,
  `SundayHours` FLOAT NULL,
  `WeekEndingAt` DATE NOT NULL,
  `UserId` INT NOT NULL,
  `StatusId` INT NOT NULL,
  PRIMARY KEY (`TimeSheetId`),
  UNIQUE INDEX `TimeSheetId_UNIQUE` (`TimeSheetId` ASC) VISIBLE,
  INDEX `fk_timesheet_user_idx` (`UserId` ASC) VISIBLE,
  INDEX `fk_timesheet_status1_idx` (`StatusId` ASC) VISIBLE,
  CONSTRAINT `fk_timesheet_user`
    FOREIGN KEY (`UserId`)
    REFERENCES `TimeCard`.`user` (`UserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_timesheet_status1`
    FOREIGN KEY (`StatusId`)
    REFERENCES `TimeCard`.`status` (`StatusId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `Role` (`RoleDesc`) VALUES (N'Employee');
INSERT INTO `Role` (`RoleDesc`) VALUES (N'Manager');

INSERT INTO `Status` (`StatusDesc`) VALUES (N'Saved');
INSERT INTO `Status` (`StatusDesc`) VALUES (N'Submitted');
INSERT INTO `Status` (`StatusDesc`) VALUES (N'Approved');
INSERT INTO `Status` (`StatusDesc`) VALUES (N'Denied');

--  Populate User table 
INSERT INTO `User` (`Fname`,`Lname`,`UserName`,`UserPassword`,`RoleId`) VALUES (N'Andrew','Tan','AndrewTan','AndrewPassword','1');
INSERT INTO `User` (`Fname`,`Lname`,`UserName`,`UserPassword`,`RoleId`) VALUES (N'Patrick','Walsh','PatrickWalsh','PatrickWalshPassword','2');


-- Populate Time Sheet table
INSERT INTO `TimeSheet` (`MondayHours`,`TuesdayHours`,`WednesdayHours`,`ThursdayHours`,`FridayHours`,`SaturdayHours`,`SundayHours`,`WeekEndingAt`,`StatusId`,`UserId`) VALUES (N'40','40','40','40','40','0','0','2019-11-10','1','1');
