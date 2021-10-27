-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hospital_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hospital_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospital_db` DEFAULT CHARACTER SET utf8 ;
USE `hospital_db` ;

-- -----------------------------------------------------
-- Table `hospital_db`.`procedure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`procedure` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`procedure` (
  `code` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `cost` REAL NULL,
  PRIMARY KEY (`code`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`department` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`department` (
  `departmentid` INT NOT NULL,
  `name` VARCHAR(25) NULL,
  `head` INT NULL,
  PRIMARY KEY (`departmentid`),
  UNIQUE INDEX `departmentid_UNIQUE` (`departmentid` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`physician`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`physician` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`physician` (
  `employeeid` INT NOT NULL,
  `name` VARCHAR(25) NULL,
  `position` VARCHAR(15) NULL,
  `ssn` INT NULL,
  PRIMARY KEY (`employeeid`),
  UNIQUE INDEX `employeeid_UNIQUE` (`employeeid` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`affiliated_with`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`affiliated_with` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`affiliated_with` (
  `physician` INT NOT NULL,
  `department` INT NOT NULL,
  `primaryaffiliation` TINYINT NULL,
  PRIMARY KEY (`physician`, `department`),
  INDEX `fk_aw_dept_idx` (`department` ASC) VISIBLE,
  CONSTRAINT `fk_aw_dept`
    FOREIGN KEY (`department`)
    REFERENCES `hospital_db`.`department` (`departmentid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aw_phy`
    FOREIGN KEY (`physician`)
    REFERENCES `hospital_db`.`physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `hospital_db`.`trained_in`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`trained_in` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`trained_in` (
  `physician` INT NOT NULL,
  `treatment` INT NOT NULL,
  `certificationdate` DATE NULL,
  `certificationexpires` DATE NULL,
  PRIMARY KEY (`physician`, `treatment`),
  INDEX `fk_ti_pro_idx` (`treatment` ASC) VISIBLE,
  CONSTRAINT `fk_ti_phy`
    FOREIGN KEY (`physician`)
    REFERENCES `hospital_db`.`physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ti_pro`
    FOREIGN KEY (`treatment`)
    REFERENCES `hospital_db`.`procedure` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`patient` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`patient` (
  `ssn` INT NOT NULL,
  `name` VARCHAR(25) NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(10) NULL,
  `insuaranceid` INT NULL,
  `pcp` INT NULL,
  PRIMARY KEY (`ssn`),
  INDEX `fk_pat_phy_idx` (`pcp` ASC) VISIBLE,
  UNIQUE INDEX `ssn_UNIQUE` (`ssn` ASC) VISIBLE,
  CONSTRAINT `fk_pat_phy`
    FOREIGN KEY (`pcp`)
    REFERENCES `hospital_db`.`physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `hospital_db`.`medication`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`medication` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`medication` (
  `code` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `brand` VARCHAR(45) NULL,
  `description` VARCHAR(55) NULL,
  PRIMARY KEY (`code`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
  CONSTRAINT `CHK_brand`
    CHECK (brand IN ("CIPLA", "GSK")))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`nurse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`nurse` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`nurse` (
  `employeeid` INT NOT NULL,
  `name` VARCHAR(25) NULL,
  `position` VARCHAR(15) NULL,
  `resgistered` TINYINT NULL,
  `ssn` INT NULL,
  PRIMARY KEY (`employeeid`),
  UNIQUE INDEX `employeeid_UNIQUE` (`employeeid` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`appointment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`appointment` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`appointment` (
  `appointmentid` INT NOT NULL,
  `patient` INT NULL,
  `prepnurse` INT NULL,
  `physician` INT NULL,
  `start_dt_time` TIMESTAMP(1) NULL,
  `end_dt_time` TIMESTAMP(1) NULL,
  `examinationroom` VARCHAR(45) NULL,
  PRIMARY KEY (`appointmentid`),
  INDEX `fk_app_pat_idx` (`patient` ASC) VISIBLE,
  INDEX `fk_app_nr_idx` (`prepnurse` ASC) VISIBLE,
  INDEX `fk_app_phy_idx` (`physician` ASC) VISIBLE,
  UNIQUE INDEX `appointmentid_UNIQUE` (`appointmentid` ASC) VISIBLE,
  CONSTRAINT `fk_app_pat`
    FOREIGN KEY (`patient`)
    REFERENCES `hospital_db`.`patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_app_nr`
    FOREIGN KEY (`prepnurse`)
    REFERENCES `hospital_db`.`nurse` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_app_phy`
    FOREIGN KEY (`physician`)
    REFERENCES `hospital_db`.`physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CHK_ap_date`
    CHECK (`start_dt_time` < `end_dt_time`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`prescribes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`prescribes` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`prescribes` (
  `physician` INT NOT NULL,
  `patient` INT NOT NULL,
  `medication` INT NOT NULL,
  `date` TIMESTAMP(1) NOT NULL,
  `appointment` INT NULL,
  `dose` VARCHAR(255) NULL,
  PRIMARY KEY (`physician`, `patient`, `medication`, `date`),
  INDEX `fk_pre_pat_idx` (`patient` ASC) VISIBLE,
  INDEX `fk_pre_med_idx` (`medication` ASC) VISIBLE,
  INDEX `fk_pre_app_idx` (`appointment` ASC) VISIBLE,
  CONSTRAINT `fk_pre_phy`
    FOREIGN KEY (`physician`)
    REFERENCES `hospital_db`.`physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pre_pat`
    FOREIGN KEY (`patient`)
    REFERENCES `hospital_db`.`patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pre_med`
    FOREIGN KEY (`medication`)
    REFERENCES `hospital_db`.`medication` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pre_app`
    FOREIGN KEY (`appointment`)
    REFERENCES `hospital_db`.`appointment` (`appointmentid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CHK_date_in_past`
    CHECK (`date` < SYSDATE()))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`block`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`block` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`block` (
  `blockfloor` INT NOT NULL,
  `blockcode` INT NOT NULL,
  PRIMARY KEY (`blockfloor`, `blockcode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`room` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`room` (
  `roomnumber` INT NOT NULL,
  `roomtype` VARCHAR(20) NULL,
  `blockfloor` INT NULL,
  `blockcode` INT NULL,
  `unavailable` TINYINT NULL,
  PRIMARY KEY (`roomnumber`),
  INDEX `fk_rm_blk_idx` (`blockfloor` ASC, `blockcode` ASC) VISIBLE,
  UNIQUE INDEX `roomnumber_UNIQUE` (`roomnumber` ASC) VISIBLE,
  CONSTRAINT `fk_rm_blk`
    FOREIGN KEY (`blockfloor` , `blockcode`)
    REFERENCES `hospital_db`.`block` (`blockfloor` , `blockcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`stay`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`stay` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`stay` (
  `stayid` INT NOT NULL,
  `patient` INT NULL,
  `room` INT NULL,
  `start_time` TIMESTAMP(1) NULL,
  `end_time` TIMESTAMP(1) NULL,
  PRIMARY KEY (`stayid`),
  INDEX `fk_st_pat_idx` (`patient` ASC) VISIBLE,
  INDEX `fk_st_rm_idx` (`room` ASC) VISIBLE,
  UNIQUE INDEX `stayid_UNIQUE` (`stayid` ASC) VISIBLE,
  CONSTRAINT `fk_st_pat`
    FOREIGN KEY (`patient`)
    REFERENCES `hospital_db`.`patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_st_rm`
    FOREIGN KEY (`room`)
    REFERENCES `hospital_db`.`room` (`roomnumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`undergoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`undergoes` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`undergoes` (
  `patient` INT NOT NULL,
  `procedure` INT NOT NULL,
  `stay` INT NOT NULL,
  `date` TIMESTAMP(1) NOT NULL,
  `physician` INT NULL,
  `assistingnurse` INT NULL,
  PRIMARY KEY (`patient`, `procedure`, `stay`, `date`),
  INDEX `fk_ug_pro_idx` (`procedure` ASC) VISIBLE,
  INDEX `fk_ug_st_idx` (`stay` ASC) VISIBLE,
  INDEX `fk_ug_phy_idx` (`physician` ASC) VISIBLE,
  INDEX `fk_ug_nr_idx` (`assistingnurse` ASC) VISIBLE,
  CONSTRAINT `fk_ug_pat`
    FOREIGN KEY (`patient`)
    REFERENCES `hospital_db`.`patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ug_pro`
    FOREIGN KEY (`procedure`)
    REFERENCES `hospital_db`.`procedure` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ug_st`
    FOREIGN KEY (`stay`)
    REFERENCES `hospital_db`.`stay` (`stayid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ug_phy`
    FOREIGN KEY (`physician`)
    REFERENCES `hospital_db`.`physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ug_nr`
    FOREIGN KEY (`assistingnurse`)
    REFERENCES `hospital_db`.`nurse` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_db`.`on_call`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital_db`.`on_call` ;

CREATE TABLE IF NOT EXISTS `hospital_db`.`on_call` (
  `nurse` INT NOT NULL,
  `blockfloor` INT NOT NULL,
  `blockcode` INT NOT NULL,
  `oncallstart` TIMESTAMP(1) NOT NULL,
  `oncallend` TIMESTAMP(1) NOT NULL,
  PRIMARY KEY (`nurse`, `blockfloor`, `blockcode`, `oncallstart`, `oncallend`),
  INDEX `fk_oc_blk_idx` (`blockfloor` ASC, `blockcode` ASC) VISIBLE,
  CONSTRAINT `fk_oc_nr`
    FOREIGN KEY (`nurse`)
    REFERENCES `hospital_db`.`nurse` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_oc_blk`
    FOREIGN KEY (`blockfloor` , `blockcode`)
    REFERENCES `hospital_db`.`block` (`blockfloor` , `blockcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CHK_oc_time`
    CHECK (`oncallstart` < ADDTIME(`oncallend`, '08:00:00')))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
