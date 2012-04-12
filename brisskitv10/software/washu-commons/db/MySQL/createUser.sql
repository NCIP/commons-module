--drop table if exists csm_user;
--drop table if exists catissue_password;
--drop table if exists catissue_user;
--drop table if exists CATISSUE_DEPARTMENT;
--drop table if exists CATISSUE_INSTITUTION;
--drop table if exists CATISSUE_CANCER_RESEARCH_GROUP;
--drop table if exists CATISSUE_ADDRESS;
--
--create table CATISSUE_DEPARTMENT (
--   IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
--   NAME VARCHAR(50) not null unique,
--   primary key (IDENTIFIER)
--);
--create table CATISSUE_INSTITUTION (
--   IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
--   NAME VARCHAR(50) not null unique,
--   primary key (IDENTIFIER)
--);
--create table CATISSUE_CANCER_RESEARCH_GROUP (
--   IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
--   NAME VARCHAR(50) not null unique,
--   primary key (IDENTIFIER)
--);
--create table CATISSUE_ADDRESS (
--   IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
--   STREET VARCHAR(50),
--   CITY VARCHAR(50),
--   STATE VARCHAR(50),
--   COUNTRY VARCHAR(50),
--   ZIPCODE VARCHAR(30),
--   PHONE_NUMBER VARCHAR(50),
--   FAX_NUMBER VARCHAR(50),
--   primary key (IDENTIFIER)
--);
--
--CREATE TABLE `csm_user` (
--            `USER_ID` bigint(20) NOT NULL auto_increment,
--            `LOGIN_NAME` varchar(100) NOT NULL default '',
--            `FIRST_NAME` varchar(100) NOT NULL default '',
--            `LAST_NAME` varchar(100) NOT NULL default '',
--            `ORGANIZATION` varchar(100) default NULL,
--            `DEPARTMENT` varchar(100) default NULL,
--            `TITLE` varchar(100) default NULL,
--            `PHONE_NUMBER` varchar(15) default NULL,
--            `PASSWORD` varchar(100) default NULL,
--            `EMAIL_ID` varchar(100) default NULL,
--            `START_DATE` date default NULL,
--            `END_DATE` date default NULL,
--            `UPDATE_DATE` date NOT NULL default '0000-00-00',
--            PRIMARY KEY  (`USER_ID`),
--            UNIQUE KEY `UQ_LOGIN_NAME` (`LOGIN_NAME`)
--          ) ENGINE=InnoDB;
--
--CREATE TABLE `catissue_user` (
--                 `IDENTIFIER` bigint(20) NOT NULL auto_increment,
--                 `EMAIL_ADDRESS` varchar(255) default NULL,
--                 `FIRST_NAME` varchar(255) default NULL,
--                 `LAST_NAME` varchar(255) default NULL,
--                 `LOGIN_NAME` varchar(255) NOT NULL,
--                 `START_DATE` date default NULL,
--                 `ACTIVITY_STATUS` varchar(50) default NULL,
--                 `DEPARTMENT_ID` bigint(20) default NULL,
--                 `CANCER_RESEARCH_GROUP_ID` bigint(20) default NULL,
--                 `INSTITUTION_ID` bigint(20) default NULL,
--                 `ADDRESS_ID` bigint(20) default NULL,
--                 `CSM_USER_ID` bigint(20) default NULL,
--                 `STATUS_COMMENT` text,
--                 `FIRST_TIME_LOGIN` bit(1) default '',
--                 PRIMARY KEY  (`IDENTIFIER`),
--                 UNIQUE KEY `LOGIN_NAME` (`LOGIN_NAME`),
--                 KEY `FKB025CFC71792AD22` (`INSTITUTION_ID`),
--                 KEY `FKB025CFC7FFA96920` (`CANCER_RESEARCH_GROUP_ID`),
--                 KEY `FKB025CFC76CD94566` (`ADDRESS_ID`),
--                 KEY `FKB025CFC7F30C2528` (`DEPARTMENT_ID`),
--                 KEY `INDX_USER_LNAME` (`LAST_NAME`),
--                 KEY `INDX_USER_FNAME` (`FIRST_NAME`),
--                 CONSTRAINT `FKB025CFC71792AD22` FOREIGN KEY (`INSTITUTION_ID`) REFERENCES `catissue_institution` (`IDENTIFIER`),
--                 CONSTRAINT `FKB025CFC76CD94566` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `catissue_address` (`IDENTIFIER`),
--                 CONSTRAINT `FKB025CFC7F30C2528` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `catissue_department` (`IDENTIFIER`),
--                 CONSTRAINT `FKB025CFC7FFA96920` FOREIGN KEY (`CANCER_RESEARCH_GROUP_ID`) REFERENCES `catissue_cancer_research_group` (`IDENTIFIER`)
--               ) ENGINE=InnoDB;
--CREATE TABLE `catissue_password` (
--                     `IDENTIFIER` bigint(20) NOT NULL auto_increment,
--                     `PASSWORD` varchar(255) default NULL,
--                     `UPDATE_DATE` date default NULL,
--                     `USER_ID` bigint(20) default NULL,
--                     PRIMARY KEY  (`IDENTIFIER`),
--                     KEY `FKDE1F38972206F20F` (`USER_ID`),
--                     CONSTRAINT `FKDE1F38972206F20F` FOREIGN KEY (`USER_ID`) REFERENCES `catissue_user` (`IDENTIFIER`)
--                   ) ENGINE=InnoDB ;
--
--insert into catissue_department values(1,'dept');
--insert into catissue_institution  values(1,'inst');
--insert into catissue_cancer_research_group  values(1,'crg');
--insert into catissue_address (identifier,state,country,zipcode) values(1,null,null,null);
--INSERT INTO `csm_user` VALUES (1,'admin@admin.com','Admin','Admin','','1','','','S03lnP7MVDk=','admin@admin.com','2005-08-30',NULL,'2008-01-21');
--insert into catissue_user (IDENTIFIER, ACTIVITY_STATUS, CSM_USER_ID, EMAIL_ADDRESS,LOGIN_NAME,FIRST_NAME,LAST_NAME) values (1,'Active',1,'admin@admin.com','admin@admin.com','Admin','Admin');
--insert into catissue_password (IDENTIFIER,PASSWORD,UPDATE_DATE,USER_ID) values ( '1','6c416f576765696c6e63316f326d3365',NULL,'1');
--UPDATE CSM_USER SET LOGIN_NAME='admin@admin.com',
--					DEPARTMENT=1,
--					EMAIL_ID='admin@admin.com',
--					PASSWORD='${first.admin.encodedPassword}'
--				WHERE USER_ID=1;
--
--UPDATE catissue_user SET EMAIL_ADDRESS='admin@admin.com',
--							LOGIN_NAME='admin@admin.com',
--							DEPARTMENT_ID=1,
--							INSTITUTION_ID=1,
--							CANCER_RESEARCH_GROUP_ID=1,
--							ADDRESS_ID=1
--						WHERE
--							IDENTIFIER = 1;
--
--
--UPDATE catissue_password set PASSWORD='xxits++sTge8j2uyHEABIQ==',
--						UPDATE_DATE=now()
--						WHERE
--							IDENTIFIER = 1;
--
--CREATE TABLE `catissue_audit_event` (
--                        `IDENTIFIER` bigint(20) NOT NULL auto_increment,
--                        `IP_ADDRESS` varchar(20) default NULL,
--                        `EVENT_TIMESTAMP` datetime default NULL,
--                        `USER_ID` bigint(20) default NULL,
--                        `COMMENTS` text,
--                        `EVENT_TYPE` varchar(200) default NULL,
--                        PRIMARY KEY  (`IDENTIFIER`),
--                        KEY `FKACAF697A2206F20F` (`USER_ID`),
--                        CONSTRAINT `FKACAF697A2206F20F` FOREIGN KEY (`USER_ID`) REFERENCES `catissue_user` (`IDENTIFIER`)
--                      ) ENGINE=InnoDB ;
--
-- CREATE TABLE `catissue_audit_event_log` (
--                            `IDENTIFIER` bigint(20) NOT NULL auto_increment,
--                            `AUDIT_EVENT_ID` bigint(20) default NULL,
--                            PRIMARY KEY  (`IDENTIFIER`),
--                            KEY `FK8BB672DF77F0B904` (`AUDIT_EVENT_ID`),
--                            CONSTRAINT `FK8BB672DF77F0B904` FOREIGN KEY (`AUDIT_EVENT_ID`) REFERENCES `catissue_audit_event` (`IDENTIFIER`)
--                          ) ENGINE=InnoDB ;
--
--CREATE TABLE `catissue_audit_event_details` (
--                                `IDENTIFIER` bigint(20) NOT NULL auto_increment,
--                                `ELEMENT_NAME` varchar(150) default NULL,
--                                `PREVIOUS_VALUE` varchar(150) default NULL,
--                                `CURRENT_VALUE` varchar(500) default NULL,
--                                `AUDIT_EVENT_LOG_ID` bigint(20) default NULL,
--                                PRIMARY KEY  (`IDENTIFIER`),
--                                KEY `FK5C07745D34FFD77F` (`AUDIT_EVENT_LOG_ID`),
--                                CONSTRAINT `FK5C07745D34FFD77F` FOREIGN KEY (`AUDIT_EVENT_LOG_ID`) REFERENCES `catissue_audit_event_log` (`IDENTIFIER`)
--                              ) ENGINE=InnoDB ;
--
--CREATE TABLE `catissue_data_audit_event_log` (
--                                 `IDENTIFIER` bigint(20) NOT NULL auto_increment,
--                                 `OBJECT_IDENTIFIER` bigint(20) default NULL,
--                                 `OBJECT_NAME` varchar(50) default NULL,
--                                 `PARENT_LOG_ID` bigint(20) default NULL,
--                                 PRIMARY KEY  (`IDENTIFIER`),
--                                 KEY `FK5C07745DC62F96A411` (`IDENTIFIER`),
--                                 KEY `FK5C07745DC62F96A412` (`PARENT_LOG_ID`),
--                                 CONSTRAINT `FK5C07745DC62F96A411` FOREIGN KEY (`IDENTIFIER`) REFERENCES `catissue_audit_event_log` (`IDENTIFIER`),
--                                 CONSTRAINT `FK5C07745DC62F96A412` FOREIGN KEY (`PARENT_LOG_ID`) REFERENCES `catissue_data_audit_event_log` (`IDENTIFIER`)
--                               ) ENGINE=InnoDB ;

drop table if exists test_order;
drop table if exists catissue_data_audit_event_log ;
drop table if exists catissue_audit_event_details ;
drop table if exists catissue_audit_event_log ;
drop table if exists catissue_audit_event ;
drop table if exists test_person;
drop table if exists test_address;
drop table if exists test_role;
drop table if exists test_user;
drop table if exists JOB_DETAILS;

CREATE TABLE `JOB_DETAILS` (
  `IDENTIFIER` bigint(20) NOT NULL auto_increment,
  `JOB_NAME` varchar(255) NOT NULL,
  `JOB_STATUS` varchar(50) default NULL,
  `TOTAL_RECORDS_COUNT` bigint(20) default NULL,
  `FAILED_RECORDS_COUNT` bigint(20) default NULL,
  `TIME_TAKEN` bigint(20) default NULL,
    `LOG_FILE` blob,
  `JOB_STARTED_BY` bigint(20) default NULL,
`START_TIME` bigint(20) default NULL,
`CURRENT_RECORDS_PROCESSED` bigint(20) default NULL,

  PRIMARY KEY  (`IDENTIFIER`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


CREATE TABLE `test_user` (
            `IDENTIFIER` bigint(20) NOT NULL auto_increment,
            `EMAIL_ADDRESS` varchar(100) default NULL,
            `FIRST_NAME` varchar(50) default NULL,
            `LAST_NAME` varchar(50) default NULL,
            `ACTIVITY_STATUS` varchar(100) default NULL,
            PRIMARY KEY  (`IDENTIFIER`)
          ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

insert into test_user (IDENTIFIER,EMAIL_ADDRESS,FIRST_NAME,LAST_NAME,ACTIVITY_STATUS)VALUES (1,"john@per.co.in","JOHN","REBER","Active");
insert into test_user (IDENTIFIER,EMAIL_ADDRESS,FIRST_NAME,LAST_NAME,ACTIVITY_STATUS)VALUES (2,"sri@per.co.in","srikanth",null,"Active");

create table `test_role` (
	`ROLE_ID` bigint(20) NOT NULL auto_increment,
	 USER_ID BIGINT,
	 primary key (ROLE_ID)
)ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;


alter table test_role add index user_role_index
	(USER_ID), add constraint user_role_index foreign key (USER_ID) references test_user (IDENTIFIER);

CREATE TABLE `test_address` (
                `IDENTIFIER` bigint(20) NOT NULL auto_increment,
                `STREET` varchar(255) not null unique,
                PRIMARY KEY  (`IDENTIFIER`)
            ) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=latin1  ;


CREATE TABLE `test_person` (
            `IDENTIFIER` bigint(20) NOT NULL auto_increment,
            `NAME` varchar(50) default NULL,
            `ADDRESS_ID` bigint,
            PRIMARY KEY  (`IDENTIFIER`)
          ) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;

alter table test_person add index person_address_index (ADDRESS_ID),
	add constraint person_address_index foreign key (ADDRESS_ID) references test_address (IDENTIFIER);


create table `test_order` (
	`ORDER_ID` bigint(20) NOT NULL auto_increment,
	 PERSON_ID BIGINT,
	 primary key (ORDER_ID)
)ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;


alter table test_order add index person_order_index
	(PERSON_ID), add constraint person_order_index foreign key (PERSON_ID) references test_person (IDENTIFIER);


CREATE TABLE `catissue_audit_event` (
                        `IDENTIFIER` bigint(20) NOT NULL auto_increment,
                        `IP_ADDRESS` varchar(20) default NULL,
                        `EVENT_TIMESTAMP` datetime default NULL,
                        `USER_ID` bigint(20) default NULL,
                        `COMMENTS` text,
                        `EVENT_TYPE` varchar(200) default NULL,
                        PRIMARY KEY  (`IDENTIFIER`),
                        KEY `FKACAF697A2206F20F` (`USER_ID`),
                        CONSTRAINT `FKACAF697A2206F20F` FOREIGN KEY (`USER_ID`) REFERENCES `test_person` (`IDENTIFIER`)
                      ) ENGINE=InnoDB ;


CREATE TABLE `catissue_audit_event_log` (
                            `IDENTIFIER` bigint(20) NOT NULL auto_increment,
                            `AUDIT_EVENT_ID` bigint(20) default NULL,
                            PRIMARY KEY  (`IDENTIFIER`),
                            KEY `FK8BB672DF77F0B904` (`AUDIT_EVENT_ID`),
                            CONSTRAINT `FK8BB672DF77F0B904` FOREIGN KEY (`AUDIT_EVENT_ID`) REFERENCES `catissue_audit_event` (`IDENTIFIER`)
                          ) ENGINE=InnoDB ;


CREATE TABLE `catissue_data_audit_event_log` (
                                 `IDENTIFIER` bigint(20) NOT NULL auto_increment,
                                 `OBJECT_IDENTIFIER` bigint(20) default NULL,
                                 `OBJECT_NAME` varchar(50) default NULL,
                                 `PARENT_LOG_ID` bigint(20) default NULL,
                                 PRIMARY KEY  (`IDENTIFIER`),
                                 KEY `FK5C07745DC62F96A411` (`IDENTIFIER`),
                                 KEY `FK5C07745DC62F96A412` (`PARENT_LOG_ID`),
                                 CONSTRAINT `FK5C07745DC62F96A411` FOREIGN KEY (`IDENTIFIER`) REFERENCES `catissue_audit_event_log` (`IDENTIFIER`),
                                 CONSTRAINT `FK5C07745DC62F96A412` FOREIGN KEY (`PARENT_LOG_ID`) REFERENCES `catissue_data_audit_event_log` (`IDENTIFIER`)
                               ) ENGINE=InnoDB ;



CREATE TABLE `catissue_audit_event_details` (
                                `IDENTIFIER` bigint(20) NOT NULL auto_increment,
                                `ELEMENT_NAME` varchar(150) default NULL,
                                `PREVIOUS_VALUE` varchar(150) default NULL,
                                `CURRENT_VALUE` varchar(500) default NULL,
                                `AUDIT_EVENT_LOG_ID` bigint(20) default NULL,
                                PRIMARY KEY  (`IDENTIFIER`),
                                KEY `FK5C07745D34FFD77F` (`AUDIT_EVENT_LOG_ID`),
                                CONSTRAINT `FK5C07745D34FFD77F` FOREIGN KEY (`AUDIT_EVENT_LOG_ID`) REFERENCES `catissue_audit_event_log` (`IDENTIFIER`)
                              ) ENGINE=InnoDB ;

commit;