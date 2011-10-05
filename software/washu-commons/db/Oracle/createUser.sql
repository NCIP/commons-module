create table CATISSUE_DEPARTMENT (
   IDENTIFIER number(19,0) not null ,
   NAME varchar(255) not null unique,
   primary key (IDENTIFIER)
);
create table CATISSUE_INSTITUTION (
   IDENTIFIER number(19,0) not null ,
   NAME varchar(255) not null unique,
   primary key (IDENTIFIER)
);
create table CATISSUE_CANCER_RESEARCH_GROUP (
   IDENTIFIER number(19,0) not null ,
   NAME varchar(255) not null unique,
   primary key (IDENTIFIER)
);

create table CATISSUE_ADDRESS (
   IDENTIFIER number(19,0) not null ,
   STREET varchar(255),
   CITY varchar(50),
   STATE varchar(50),
   COUNTRY varchar(50),
   ZIPCODE varchar(30),
   PHONE_NUMBER varchar(50),
   FAX_NUMBER varchar(50),
   primary key (IDENTIFIER)
);

create table CATISSUE_PASSWORD (
   IDENTIFIER number(19,0) not null ,
   PASSWORD varchar(255),
   UPDATE_DATE date,
   USER_ID number(19,0),
   primary key (IDENTIFIER)
);
create table CATISSUE_USER (
   IDENTIFIER number(19,0) not null ,
   EMAIL_ADDRESS varchar(255),
   FIRST_NAME varchar(255),
   LAST_NAME varchar(255),
   LOGIN_NAME varchar(255) not null unique,
   START_DATE date,
   ACTIVITY_STATUS varchar(50),
   DEPARTMENT_ID number(19,0),
   CANCER_RESEARCH_GROUP_ID number(19,0),
   INSTITUTION_ID number(19,0),
   ADDRESS_ID number(19,0),
   CSM_USER_ID number(19,0),
   STATUS_COMMENT varchar2(500),
   FIRST_TIME_LOGIN number(1,0) default 1,
   primary key (IDENTIFIER)
);
CREATE TABLE CSM_USER (
	USER_ID NUMBER(38) NOT NULL,
	LOGIN_NAME VARCHAR2(100) NOT NULL,
	FIRST_NAME VARCHAR2(100) NOT NULL,
	LAST_NAME VARCHAR2(100) NOT NULL,
	ORGANIZATION VARCHAR2(100),
	DEPARTMENT VARCHAR2(100),
	TITLE VARCHAR2(100),
	PHONE_NUMBER VARCHAR2(15),
	PASSWORD VARCHAR2(100),
	EMAIL_ID VARCHAR2(100),
	START_DATE DATE,
	END_DATE DATE,
	UPDATE_DATE DATE NOT NULL
);

CREATE TABLE JOB_DETAILS (
  IDENTIFIER NUMBER(38) NOT NULL,
  JOB_NAME varchar(255) NOT NULL,
  JOB_STATUS varchar(50) default NULL,
  TOTAL_RECORDS_COUNT NUMBER(20) default NULL,
  FAILED_RECORDS_COUNT NUMBER(20) default NULL,
  TIME_TAKEN NUMBER(20) default NULL,
  LOG_FILE blob,
  JOB_STARTED_BY NUMBER(20) default NULL,
  START_TIME NUMBER(20) default NULL,
  CURRENT_RECORDS_PROCESSED NUMBER(20) default NULL,

  PRIMARY KEY  (IDENTIFIER)
);

ALTER TABLE CSM_USER ADD CONSTRAINT PK_USER PRIMARY KEY (USER_ID);
ALTER TABLE CSM_USER ADD CONSTRAINT UQ_LOGIN_NAME UNIQUE (LOGIN_NAME);

insert into catissue_department values(1,'dept');
insert into catissue_institution  values(1,'inst');
insert into catissue_cancer_research_group  values(1,'crg');
insert into catissue_address (identifier,state,country,zipcode) values(1,null,null,null);
INSERT INTO CSM_USER (USER_ID,LOGIN_NAME,FIRST_NAME,LAST_NAME,ORGANIZATION,DEPARTMENT,TITLE,PHONE_NUMBER,PASSWORD,EMAIL_ID,START_DATE,END_DATE,UPDATE_DATE) VALUES (1,'admin@admin.com','admin@admin.com','admin@admin.com',NULL,NULL,NULL,NULL,'6c416f576765696c6e63316f326d3365','admin@admin.com',to_date('2005-08-30','yyyy-mm-dd'),NULL,to_date('2005-08-30','yyyy-mm-dd'));
insert into catissue_user (IDENTIFIER, ACTIVITY_STATUS, CSM_USER_ID, EMAIL_ADDRESS,LOGIN_NAME,FIRST_NAME,LAST_NAME) values (1,'Active',1,'admin@admin.com','admin@admin.com','Admin','Admin');
insert into catissue_password (IDENTIFIER,PASSWORD,UPDATE_DATE,USER_ID) values ( '1','6c416f576765696c6e63316f326d3365',NULL,'1');
UPDATE CSM_USER SET LOGIN_NAME='admin@admin.com',
					DEPARTMENT=1,
					EMAIL_ID='admin@admin.com',
					PASSWORD='${first.admin.encodedPassword}'
				WHERE USER_ID=1;

UPDATE catissue_user SET EMAIL_ADDRESS='admin@admin.com',
							LOGIN_NAME='admin@admin.com',
							DEPARTMENT_ID=1,
							INSTITUTION_ID=1,
							CANCER_RESEARCH_GROUP_ID=1,
							ADDRESS_ID=1
						WHERE
							IDENTIFIER = 1;


UPDATE catissue_password set PASSWORD='@@first.admin.encodedPassword@@',
							UPDATE_DATE=sysdate
						WHERE
							IDENTIFIER = 1;
commit;