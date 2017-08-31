#Test

Database: Mysql.


// use below comment to create db.table structure in Mysql database.

CREATE TABLE `Item`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `date_created` DATETIME NULL,
  PRIMARY KEY (`id`));
