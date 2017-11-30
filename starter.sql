CREATE SCHEMA `testdb` ;

CREATE TABLE `testdb`.`student` (
  `idstudent` INT NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  PRIMARY KEY (`idstudent`));
  
INSERT INTO student(idstudent, firstname, lastname) VALUES('8883331', 'Tyler', 'Reed');
INSERT INTO student(idstudent, firstname, lastname) VALUES('1234567', 'John', 'Carmack');
INSERT INTO student(idstudent, firstname, lastname) VALUES('8883331', 'Bjarne', 'Stroustrup');
INSERT INTO tstudent(idstudent, firstname, lastname) VALUES('8883331', 'Dennis', 'Ritchie');