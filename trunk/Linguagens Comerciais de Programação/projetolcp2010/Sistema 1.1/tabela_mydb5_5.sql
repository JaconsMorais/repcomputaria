SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb2`;

-- -----------------------------------------------------
-- Table `mydb2`.`DadosPessoais`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb2`.`DadosPessoais` (
  `CPF` INT NOT NULL ,
  `Nome` VARCHAR(45) NULL ,
  `Telefone` INT NULL ,
  `Rua` VARCHAR(45) NULL ,
  `Bairro` VARCHAR(45) NULL ,
  `Cidade` VARCHAR(45) NULL ,
  `Estado` VARCHAR(20) NULL ,
  `CEP` INT NULL ,
  PRIMARY KEY (`CPF`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb2`.`DadosFuncionario` (
  `CPF` INT NOT NULL ,
  `empresa` VARCHAR(45) NULL ,
  `Rua` VARCHAR(45) NULL ,
  `Bairro` VARCHAR(45) NULL ,
  `CEP` INT NULL ,
  `Telefone` INT NULL ,
  `Cargo` VARCHAR(15) NULL ,
  `Tempo` INT NULL ,
  PRIMARY KEY (`CPF`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`funcionario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb2`.`funcionario` (
  `CPF` INT NOT NULL ,
  `DataAdmicao` DATE NULL ,
  `Cargo` VARCHAR(15) NULL ,
  `Salario` FLOAT NULL ,
  `DadosPessoais_CPF` INT NOT NULL ,
  PRIMARY KEY (`CPF`, `DadosPessoais_CPF`) ,
  INDEX `fk_funcionario_DadosPessoais` (`DadosPessoais_CPF` ASC) ,
  CONSTRAINT `fk_funcionario_DadosPessoais`
    FOREIGN KEY (`DadosPessoais_CPF` )
    REFERENCES `mydb2`.`DadosPessoais` (`CPF` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`DadosConjugais`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb2`.`DadosConjugais` (
  `CPF` INT NOT NULL ,
  `CPF_C` INT NULL ,
  `Nome_C` VARCHAR(45) NULL ,
  `EstCivil` VARCHAR(20) NULL ,
  `Filhos` INT NULL ,
  PRIMARY KEY (`CPF`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`Bens`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb2`.`Bens` (
  `CPF` INT NOT NULL ,
  `Casa` VARCHAR(20) NULL ,
  `Carro` VARCHAR(20) NULL ,
  `Banco` VARCHAR(45) NULL ,
  `ClienteDesde` INT NULL ,
  PRIMARY KEY (`CPF`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`Cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb2`.`Cliente` (
  `CPF` INT NOT NULL ,
  `DadosFuncionario_CPF` INT NOT NULL ,
  `DadosConjugais_CPF` INT NOT NULL ,
  `DadosPessoais_CPF` INT NOT NULL ,
  `Bens_CPF` INT NOT NULL ,
  PRIMARY KEY (`CPF`, `DadosFuncionario_CPF`, `DadosConjugais_CPF`, `DadosPessoais_CPF`, `Bens_CPF`) ,
  INDEX `fk_Cliente_DadosFuncionario` (`DadosFuncionario_CPF` ASC) ,
  INDEX `fk_Cliente_DadosConjugais` (`DadosConjugais_CPF` ASC) ,
  INDEX `fk_Cliente_DadosPessoais` (`DadosPessoais_CPF` ASC) ,
  INDEX `fk_Cliente_Bens` (`Bens_CPF` ASC) ,
  CONSTRAINT `fk_Cliente_DadosFuncionario`
    FOREIGN KEY (`DadosFuncionario_CPF` )
    REFERENCES `mydb2`.`DadosFuncionario` (`CPF` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_DadosConjugais`
    FOREIGN KEY (`DadosConjugais_CPF` )
    REFERENCES `mydb2`.`DadosConjugais` (`CPF` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_DadosPessoais`
    FOREIGN KEY (`DadosPessoais_CPF` )
    REFERENCES `mydb2`.`DadosPessoais` (`CPF` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_Bens`
    FOREIGN KEY (`Bens_CPF` )
    REFERENCES `mydb2`.`Bens` (`CPF` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
