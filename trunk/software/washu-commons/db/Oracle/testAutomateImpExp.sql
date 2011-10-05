#This file has been used for junit testing of AutomateImport for oracle databse.
#drop table CATISSUE_PERMISSIBLE_VALUE;
#drop table CATISSUE_CDE;
create table CATISSUE_PERMISSIBLE_VALUE (IDENTIFIER number(19,0) not null ,CONCEPT_CODE varchar(40),DEFINITION varchar2(500),PARENT_IDENTIFIER number(19,0),VALUE varchar(225),PUBLIC_ID varchar(30),primary key (IDENTIFIER));
create table CATISSUE_CDE (PUBLIC_ID varchar(30) not null,LONG_NAME varchar(200),DEFINITION varchar2(500),VERSION varchar(50),LAST_UPDATED date,primary key (PUBLIC_ID));
alter table CATISSUE_PERMISSIBLE_VALUE  add constraint FK57DDCE153B5435E foreign key (PARENT_IDENTIFIER) references CATISSUE_PERMISSIBLE_VALUE;
alter table CATISSUE_PERMISSIBLE_VALUE  add constraint FK57DDCE1FC56C2B1 foreign key (PUBLIC_ID) references CATISSUE_CDE;