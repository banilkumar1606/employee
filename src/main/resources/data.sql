DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS Transaction_Status;
CREATE TABLE employee (
  emp_id INT PRIMARY KEY,
  emp_name VARCHAR(250) NOT NULL,
  emp_age INT(2) NOT NULL
);

INSERT INTO employee (emp_id, emp_name, emp_age) VALUES
  (1,'Anil', 28),
  (2,'Bill', 30),
  (3,'Folrunsho', '35');
  
  
CREATE TABLE Transaction_Status (
  transactionid VARCHAR(250)  PRIMARY KEY,
  status VARCHAR(250) NOT NULL
);