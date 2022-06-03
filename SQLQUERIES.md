# JavaGUIDataBase

SQL DATABASE QUERIES

		CREATING TABLES 

CREATE TABLE employee (
  emp_id INT PRIMARY KEY,
  first_name VARCHAR(40),
  last_name VARCHAR(40),
  phone INT,
  reservation_id INT
 );
  
  
 CREATE TABLE reservation (
  reservation_id INT PRIMARY KEY,
  client_egn INT,
  emp_id INT,
  reservation_date DATE
 );
  
  
  ALTER TABLE employee
  ADD FOREIGN KEY(reservation_id)
  REFERENCES reservation(reservation_id)
  ON DELETE SET NULL
  
  
 CREATE TABLE client (
  client_egn INT PRIMARY KEY,
  age INT,
  client_fName VARCHAR(40),
  client_lName VARCHAR(40),
  reservation_id INT
 );
  
  
 ALTER TABLE client
 ADD FOREIGN KEY(reservation_id)
 REFERENCES reservation(reservation_id)
 ON DELETE SET NULL
	
	
 ALTER TABLE reservation
 ADD FOREIGN KEY(client_egn)
 REFERENCES client(client_egn)
 ON DELETE SET NULL
 
 
 ALTER TABLE reservation
 ADD FOREIGN KEY(emp_id)
 REFERENCES employee(emp_id)
 ON DELETE SET NULL
	
	
CREATE TABLE room (
 room_number INT PRIMARY KEY,
 room_type VARCHAR(10),
 floors INT,
 accommodation_number INT
);
 
CREATE TABLE accommodation (
 accommodation_number INT PRIMARY KEY,
 client_egn INT,
 room_number INT
);
 ALTER TABLE room
 ADD FOREIGN KEY(accommodation_number)
 REFERENCES accommodation(accommodation_number);
 ON DELETE SET NULL;
 
 ALTER TABLE accommodation
 ADD FOREIGN KEY(client_egn)
 REFERENCES client(client_egn)
 ON DELETE SET NULL
 
 
 ALTER TABLE accommodation
 ADD FOREIGN KEY(room_number)
 REFERENCES room(room_number)
 ON DELETE SET NULL
 
 
		INSERTING VALUES INTO TABLES
		
		
INSERT INTO employee VALUES (01, 'Ivan', 'Marinov', 088435623, NULL);
INSERT INTO client VALUES(0234512321, 23, 'Toni', 'Montana', NULL);
INSERT INTO reservation VALUES(01, 0234512321, 01, '1992-04-06');
UPDATE employee
SET reservation_id = 01
WHERE emp_id = 01;

UPDATE client
SET reservation_id = 01
WHERE client_egn =0234512321

INSERT INTO accommodation VALUES(001, 0234512321, NULL);
INSERT INTO room VALUES(101, 'OneRoom', 1, NULL);
UPDATE accommodation
SET room_number = 101
WHERE accommodation_number = 001;

UPDATE room
SET accommodation_number = 001
WHERE room_number = 101;

*******************************************************************************

INSERT INTO employee VALUES (02, 'Sasho', 'Kolev', 088425633, NULL);
INSERT INTO client VALUES(0134512323, 18, 'Pati', 'Draganov', NULL);
INSERT INTO reservation VALUES(02, 0134512323, 02, '2020-04-06');
UPDATE employee
SET reservation_id = 02
WHERE emp_id = 02;

UPDATE client
SET reservation_id = 02
WHERE client_egn =0134512323



INSERT INTO accommodation VALUES(11, 0134512323, NULL);
INSERT INTO room VALUES(102, 'TwoRoom', 1, NULL);
UPDATE accommodation
SET room_number = 102
WHERE accommodation_number = 11;

UPDATE room
SET accommodation_number = 11
WHERE room_number = 102;

*********************************************************************************

INSERT INTO client VALUES(0734312328, 47, 'Peter', 'Grey', NULL);
INSERT INTO client VALUES(0614312328, 42, 'Viktoria', 'Grey', NULL);
INSERT INTO client VALUES(0343123288, 19, 'Franchesca', 'Grey', NULL);
INSERT INTO reservation VALUES(03, 0734312328, 01, '2022-04-06');
UPDATE client
SET reservation_id = 02
WHERE client_egn =0734312328;

UPDATE client
SET reservation_id = 02
WHERE client_egn =0614312328;

UPDATE client
SET reservation_id = 02
WHERE client_egn =0343123288;


INSERT INTO accommodation VALUES(003, 0734312328, NULL);
INSERT INTO room VALUES(202, 'Family', 0, NULL);
UPDATE accommodation
SET room_number = 202
WHERE accommodation_number = 12;

UPDATE room
SET accommodation_number = 12;
WHERE room_number = 202;
