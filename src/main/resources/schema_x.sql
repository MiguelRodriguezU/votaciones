DROP TABLE IF EXISTS candidate;  
CREATE TABLE candidate (  
	id INTEGER AUTO_INCREMENT  PRIMARY KEY,  
	names VARCHAR(50),  
	surnames VARCHAR(50),
	birthdate VARCHAR(10),
	proposal VARCHAR(100),
	politicalParty VARCHAR(50) 
);