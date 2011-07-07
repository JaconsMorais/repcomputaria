SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';



CREATE SCHEMA IF NOT EXISTS `elearning` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

USE `elearning` ;



-- -----------------------------------------------------

-- Table `elearning`.`Usuario`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `elearning`.`Usuario` (

  `idUsuario` BIGINT NOT NULL AUTO_INCREMENT ,

  `login` VARCHAR(45) NOT NULL ,

  `senha` VARCHAR(45) NOT NULL ,

  `tipoUsuario` INT NULL ,

  PRIMARY KEY (`idUsuario`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `elearning`.`Pessoa`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `elearning`.`Pessoa` (

  `idPessoa` BIGINT NOT NULL ,

  `endereco` VARCHAR(45) NULL ,

  `telefone` VARCHAR(45) NULL ,

  PRIMARY KEY (`idPessoa`) ,

  INDEX `fk_Pessoa_Usuario1` (`idPessoa` ASC) ,

  CONSTRAINT `fk_Pessoa_Usuario1`

    FOREIGN KEY (`idPessoa` )

    REFERENCES `elearning`.`Usuario` (`idUsuario` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `elearning`.`Professor`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `elearning`.`Professor` (

  `idProfessor` BIGINT NOT NULL ,

  PRIMARY KEY (`idProfessor`) ,

  INDEX `fk_Professor_Pessoa1` (`idProfessor` ASC) ,

  CONSTRAINT `fk_Professor_Pessoa1`

    FOREIGN KEY (`idProfessor` )

    REFERENCES `elearning`.`Pessoa` (`idPessoa` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `elearning`.`Aluno`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `elearning`.`Aluno` (

  `idAluno` BIGINT NOT NULL ,

  PRIMARY KEY (`idAluno`) ,

  INDEX `fk_Aluno_Pessoa1` (`idAluno` ASC) ,

  CONSTRAINT `fk_Aluno_Pessoa1`

    FOREIGN KEY (`idAluno` )

    REFERENCES `elearning`.`Pessoa` (`idPessoa` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `elearning`.`Disciplina`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `elearning`.`Disciplina` (

  `idDisciplina` BIGINT NOT NULL AUTO_INCREMENT ,

  `idProfessor` BIGINT NOT NULL ,

  `nomeDisciplina` VARCHAR(45) NOT NULL ,

  `numNotas` INT NOT NULL ,

  `dataInicio` DATETIME NULL ,

  `dataFim` DATETIME NULL ,

  PRIMARY KEY (`idDisciplina`, `idProfessor`) ,

  INDEX `fk_Disciplina_Professor1` (`idProfessor` ASC) ,

  CONSTRAINT `fk_Disciplina_Professor1`

    FOREIGN KEY (`idProfessor` )

    REFERENCES `elearning`.`Professor` (`idProfessor` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `elearning`.`CriterioAvaliacao`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `elearning`.`CriterioAvaliacao` (

  `idCriterioAvaliacao` BIGINT NOT NULL AUTO_INCREMENT ,

  `idDisciplina` BIGINT NOT NULL ,

  `nome` VARCHAR(45) NOT NULL ,

  `peso` INT NOT NULL ,

  PRIMARY KEY (`idCriterioAvaliacao`, `idDisciplina`) ,

  INDEX `fk_CriterioAvaliacao_Disciplina1` (`idDisciplina` ASC) ,

  CONSTRAINT `fk_CriterioAvaliacao_Disciplina1`

    FOREIGN KEY (`idDisciplina` )

    REFERENCES `elearning`.`Disciplina` (`idDisciplina` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `elearning`.`Matricula`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `elearning`.`Matricula` (

  `idMatricula` BIGINT NOT NULL AUTO_INCREMENT ,

  `idDisciplina` BIGINT NOT NULL ,

  `idAluno` BIGINT NOT NULL ,

  `notaFinal` FLOAT NULL ,

  PRIMARY KEY (`idMatricula`, `idDisciplina`, `idAluno`) ,

  INDEX `fk_Disciplina_has_Aluno_Aluno1` (`idAluno` ASC) ,

  CONSTRAINT `fk_Disciplina_has_Aluno_Disciplina1`

    FOREIGN KEY (`idDisciplina` )

    REFERENCES `elearning`.`Disciplina` (`idDisciplina` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Disciplina_has_Aluno_Aluno1`

    FOREIGN KEY (`idAluno` )

    REFERENCES `elearning`.`Aluno` (`idAluno` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `elearning`.`Nota`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `elearning`.`Nota` (

  `idNota` BIGINT NOT NULL AUTO_INCREMENT ,

  `idMatricula` BIGINT NOT NULL ,

  `idCriterioAvaliacao` BIGINT NOT NULL ,

  `notaCriterio` FLOAT NULL ,

  PRIMARY KEY (`idNota`) ,

  INDEX `fk_Nota_Matricula1` (`idMatricula` ASC) ,

  CONSTRAINT `fk_CriterioAvaliacao_has_Aluno_CriterioAvaliacao1`

    FOREIGN KEY (`idCriterioAvaliacao` )

    REFERENCES `elearning`.`CriterioAvaliacao` (`idCriterioAvaliacao` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Nota_Matricula1`

    FOREIGN KEY (`idMatricula` )

    REFERENCES `elearning`.`Matricula` (`idMatricula` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;







SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

