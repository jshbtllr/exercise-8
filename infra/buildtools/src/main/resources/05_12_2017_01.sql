CREATE TABLE EMPLOYEE (
	EMPLOYEEID BIGINT,
	LASTNAME VARCHAR(50) NOT NULL,
	FIRSTNAME VARCHAR(50) NOT NULL,
	MIDDLENAME VARCHAR(50) default NULL,
	SUFFIX VARCHAR(30) default NULL,
	TITLE VARCHAR(30) default NULL,
	STREET VARCHAR(100) default NULL,
	BARANGAY VARCHAR(50) default NULL,
	CITY VARCHAR(30) default NULL,
	ZIPCODE VARCHAR(30) default NULL,
	COUNTRY VARCHAR(30) default NULL,
	BIRTHDAY DATE,
	GWA FLOAT(8),
	HIREDATE DATE,
	EMPLOYED BOOLEAN,
	PRIMARY KEY (EMPLOYEEID)
);

CREATE TABLE ROLES (
	ROLEID BIGINT,
	ROLECODE VARCHAR(10) NOT NULL,
	ROLENAME VARCHAR(50) NOT NULL,
	PRIMARY KEY (ROLEID, ROLECODE)
);

CREATE TABLE EMPLOYEEROLE (
	EMPLOYEEID BIGINT NOT NULL,
	ROLEID BIGINT NOT NULL,
	PRIMARY KEY (EMPLOYEEID, ROLEID),
	FOREIGN KEY (EMPLOYEEID) REFERENCES EMPLOYEE(EMPLOYEEID)
);

CREATE TABLE CONTACTINFO (
	CONTACTID BIGINT,
	CONTACTINFOTYPE VARCHAR(30) NOT NULL,
	CONTACTINFORMATION VARCHAR(100) NOT NULL,
	EMPLOYEEID BIGINT NOT NULL,
	PRIMARY KEY (EMPLOYEEID, CONTACTID),
	FOREIGN KEY (EMPLOYEEID) REFERENCES EMPLOYEE(EMPLOYEEID)
);