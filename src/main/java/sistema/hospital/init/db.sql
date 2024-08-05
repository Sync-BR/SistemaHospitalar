CREATE SCHEMA `hospital` ;
CREATE TABLE `hospital`.`paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(65) NOT NULL,
  `Cpf` VARCHAR(11) NOT NULL,
  `Especialista` VARCHAR(45) NOT NULL,
  `Prioridade` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`, `Cpf`));


CREATE TABLE `hospital`.`medico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(250) NOT NULL,
  `especialidade` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `sala` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`, `cpf`));
