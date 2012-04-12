
drop table if exists test_order;
drop table if exists test_person;
drop table if exists test_address;


CREATE TABLE `test_person` (                                  
            `IDENTIFIER` bigint(20) NOT NULL auto_increment,         
            `NAME` varchar(50) default NULL,                   
            `ADDRESS_ID` bigint,
            PRIMARY KEY  (`IDENTIFIER`)                              
          ) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;

CREATE TABLE `test_address` (                              
                `IDENTIFIER` bigint(20) NOT NULL auto_increment,         
                `STREET` varchar(255) not null unique,              
                PRIMARY KEY  (`IDENTIFIER`)                              
            ) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=latin1  ;


alter table test_person add index person_address_index (ADDRESS_ID), 
	add constraint person_address_index foreign key (ADDRESS_ID) references test_address (IDENTIFIER);



create table test_order (
	`IDENTIFIER` bigint(20) NOT NULL auto_increment,  
	 PERSON_ID BIGINT,
	 user_id	BIGINT,
	 primary key (IDENTIFIER)
)ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;


alter table test_order add index person_order_index 
	(PERSON_ID), add constraint person_order_index foreign key (PERSON_ID) references test_person (IDENTIFIER);


drop table if exists test_user;
drop table if exists test_table_hashed;

CREATE TABLE `test_user` (                                                                         
            `IDENTIFIER` bigint(20) NOT NULL auto_increment,                                                
            `EMAIL_ADDRESS` varchar(100) default NULL,                                                      
            `FIRST_NAME` varchar(50) default NULL,                                                          
            `LAST_NAME` varchar(50) default NULL,                                                           
            `ACTIVITY_STATUS` varchar(100) default NULL,                                                    
            PRIMARY KEY  (`IDENTIFIER`)                                                                 
          ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;                                                       

CREATE TABLE test_table_hashed (                    
                         IDENTIFIER bigint(20) NOT NULL ,        
                         AVAILABLE tinyint,                      
                         CREATED_ON_DATE DATE DEFAULT NULL,                    
                         COLLECTION_STATUS VARCHAR(50) DEFAULT NULL,           
                         PRIMARY KEY  (IDENTIFIER)                             
                       )  ;

drop table if exists person;

CREATE TABLE `person` (                             
          `identifier` bigint(20) NOT NULL auto_increment,  
          `first_name` char(50) default NULL,               
          `second_name` char(50) default NULL,              
          `age` bigint(20) default NULL,                    
          `isAvailable` bit(1) default NULL,                
          `birth_date` date NOT NULL,                       
          `address_id` bigint(20) default NULL,             
          `account_id` bigint(20) default NULL,             
          PRIMARY KEY  (`identifier`)                       
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1      ;



drop table if exists catissue_audit_event;
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

drop table if exists catissue_audit_event_log;
CREATE TABLE `catissue_audit_event_log` (                                                                          
                            `IDENTIFIER` bigint(20) NOT NULL auto_increment,                                                                 
                            `AUDIT_EVENT_ID` bigint(20) default NULL,                                                                        
                            PRIMARY KEY  (`IDENTIFIER`),                                                                                     
                            KEY `FK8BB672DF77F0B904` (`AUDIT_EVENT_ID`),                                                                     
                            CONSTRAINT `FK8BB672DF77F0B904` FOREIGN KEY (`AUDIT_EVENT_ID`) REFERENCES `catissue_audit_event` (`IDENTIFIER`)  
                          ) ENGINE=InnoDB ;

drop table if exists catissue_data_audit_event_log;
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


drop table if exists catissue_audit_event_details;
CREATE TABLE `catissue_audit_event_details` (                                                                              
                                `IDENTIFIER` bigint(20) NOT NULL auto_increment,                                                                         
                                `ELEMENT_NAME` varchar(150) default NULL,                                                                                
                               `PREVIOUS_VALUE` TEXT  default NULL,
                                `CURRENT_VALUE` TEXT  default NULL,                                                                           
                                `AUDIT_EVENT_LOG_ID` bigint(20) default NULL,                                                                            
                                PRIMARY KEY  (`IDENTIFIER`),                                                                                             
                                KEY `FK5C07745D34FFD77F` (`AUDIT_EVENT_LOG_ID`),                                                                         
                                CONSTRAINT `FK5C07745D34FFD77F` FOREIGN KEY (`AUDIT_EVENT_LOG_ID`) REFERENCES `catissue_audit_event_log` (`IDENTIFIER`)  
                              ) ENGINE=InnoDB ;

alter table test_order add index user_order_index 
	(user_id), add constraint user_order_index foreign key (user_id) references test_user (IDENTIFIER);

drop table if exists temp_table;
CREATE TABLE `temp_table` (              
              `Identifier` bigint(20) default NULL,  
              `Name` varchar(250) default NULL       
            ) ENGINE=InnoDB DEFAULT CHARSET=latin1  ; 


commit;
