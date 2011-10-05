
DROP TABLE test_order cascade constraints;
DROP TABLE test_person cascade constraints;
DROP TABLE test_address cascade constraints;


CREATE TABLE test_person (                                  
            IDENTIFIER NUMBER(19,0) NOT NULL,         
            NAME varchar(50) default NULL,                   
            ADDRESS_ID NUMBER(19,0),
            PRIMARY KEY  (IDENTIFIER)                              
          );



CREATE TABLE test_address (                              
                IDENTIFIER NUMBER(19,0) NOT NULL ,         
                STREET varchar(255) not null unique,              
                PRIMARY KEY  (IDENTIFIER)                              
            ); 


ALTER TABLE test_person ADD constraint person_address_index foreign key (ADDRESS_ID) references test_address (IDENTIFIER);	



create table test_order (
	 IDENTIFIER NUMBER(19,0) NOT NULL,  
	 PERSON_ID NUMBER(19,0),
 	 USER_ID   NUMBER(19,0),
	 primary key (IDENTIFIER)
);


alter table test_order add constraint person_order_index foreign key (PERSON_ID) references test_person (IDENTIFIER);


DROP sequence 	PER_SEQ;	
DROP sequence 	Address_SEQ;	
DROP sequence 	ORDER_SEQ;	

create sequence PER_SEQ;
create sequence Address_SEQ;
create sequence ORDER_SEQ;

DROP TABLE TEST_USER cascade constraints;
DROP TABLE TEST_TABLE_HASHED cascade constraints;

CREATE TABLE TEST_USER (                                  
            IDENTIFIER NUMBER(19,0) NOT NULL,      
            EMAIL_ADDRESS VARCHAR(100) DEFAULT NULL,               
            FIRST_NAME VARCHAR(50) DEFAULT NULL,                   
            LAST_NAME VARCHAR(50) DEFAULT NULL,                    
            ACTIVITY_STATUS VARCHAR(100) DEFAULT NULL,
			primary key (IDENTIFIER)                              
          );
		  
DROP sequence 	USER_SEQ;	  
CREATE sequence USER_SEQ;		 


CREATE TABLE TEST_TABLE_HASHED (                    
                         IDENTIFIER NUMBER(19,0) NOT NULL ,        
                         AVAILABLE NUMBER(1,0),                      
                         CREATED_ON_DATE DATE DEFAULT NULL,                    
                         COLLECTION_STATUS VARCHAR(50) DEFAULT NULL,           
                         PRIMARY KEY  (IDENTIFIER)                             
                       )  ;
					   
drop table person;
DROP sequence person_seq;
CREATE sequence person_seq;	

CREATE TABLE person (                             
          identifier NUMBER(19,0) NOT NULL,  
          first_name VARCHAR(50) default NULL,               
          second_name VARCHAR(50) default NULL,              
          age NUMBER(19,0) default NULL,                    
          isAvailable NUMBER(1,0) default NULL,                
          birth_date date NOT NULL,                       
          address_id NUMBER(19,0) default NULL,             
          account_id NUMBER(19,0) default NULL,             
          PRIMARY KEY  (identifier)                       
        ) ;     



drop table catissue_audit_event;
CREATE TABLE catissue_audit_event (                                                                
                        IDENTIFIER number(19,0) not null ,                                                   
                        IP_ADDRESS varchar(20),                                                            
                        EVENT_TIMESTAMP date ,                                                           
                        USER_ID number(19,0),                                                                 
                        COMMENTS varchar2(500),                                                                                  
                        EVENT_TYPE varchar(200),                                                            
                        PRIMARY KEY  (IDENTIFIER)                                                                  
                        
                      ) ;

drop table catissue_audit_event_log;
CREATE TABLE catissue_audit_event_log (                                                                          
                            IDENTIFIER number(19,0) not null ,                                                              
                            AUDIT_EVENT_ID number(19,0),                                                                        
                            PRIMARY KEY  (IDENTIFIER),                                                                                     
                            CONSTRAINT FK8BB672DF77F0B904 FOREIGN KEY (AUDIT_EVENT_ID) REFERENCES catissue_audit_event (IDENTIFIER)  
                          );

drop table catissue_data_audit_event_log;
CREATE TABLE catissue_data_audit_event_log (                                                                               
                                 IDENTIFIER number(19,0) not null ,                                                                              
                                 OBJECT_IDENTIFIER number(19,0),                                                                               
                                 OBJECT_NAME varchar(50),                                                                                    
                                 PARENT_LOG_ID number(19,0),                                                                                   
                                 PRIMARY KEY  (IDENTIFIER),                                                                                               
                                 CONSTRAINT FK5C07745DC62F96A411 FOREIGN KEY (IDENTIFIER) REFERENCES catissue_audit_event_log (IDENTIFIER),         
                                 CONSTRAINT FK5C07745DC62F96A412 FOREIGN KEY (PARENT_LOG_ID) REFERENCES catissue_data_audit_event_log (IDENTIFIER)  
                               ) ;


drop table catissue_audit_event_details;
CREATE TABLE catissue_audit_event_details (                                                                              
                                IDENTIFIER number(19,0) not null ,                                                                        
                                ELEMENT_NAME varchar(150),                                                                                
                                PREVIOUS_VALUE CLOB,
                                CURRENT_VALUE CLOB,                                                                        
                                AUDIT_EVENT_LOG_ID number(19,0) ,                                                                            
                                PRIMARY KEY  (IDENTIFIER),                                                                                             
                                CONSTRAINT FK5C07745D34FFD77F FOREIGN KEY (AUDIT_EVENT_LOG_ID) REFERENCES catissue_audit_event_log (IDENTIFIER)  
                              ) ;

alter table test_order add constraint user_order_index foreign key (user_id) references test_user (IDENTIFIER);

drop table temp_table;
CREATE TABLE temp_table (              
              Identifier number(19,0),  
              Name varchar(250)     
            ); 

CREATE sequence CATISSUE_AUDIT_EVENT_PARAM_SEQ;
CREATE sequence CATISSUE_AUDIT_EVENT_DET_SEQ;
CREATE sequence CATISSUE_AUDIT_EVENT_LOG_SEQ;
CREATE sequence LOGIN_EVENT_PARAM_SEQ;


