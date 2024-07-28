CREATE SCHEMA `hospital` ;
CREATE TABLE `hospital`.`paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(65) NOT NULL,
  `Cpf` VARCHAR(11) NOT NULL,
  `Especialista` VARCHAR(45) NOT NULL,
  `Prioridade` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`, `Cpf`));
