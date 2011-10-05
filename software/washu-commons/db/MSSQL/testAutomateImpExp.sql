#This file has been used for junit testing of AutomateImport for mssql server databse.
IF EXISTS(SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'CATISSUE_PERMISSIBLE_VALUE') DROP TABLE CATISSUE_PERMISSIBLE_VALUE;
IF EXISTS(SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'CATISSUE_CDE') DROP TABLE CATISSUE_CDE;
create table CATISSUE_PERMISSIBLE_VALUE (
   IDENTIFIER bigint not null identity,
   CONCEPT_CODE varchar(40),
   DEFINITION varchar(500),
   PARENT_IDENTIFIER bigint,
   VALUE varchar(225),
   PUBLIC_ID varchar(30),
   primary key (IDENTIFIER)
);
create table CATISSUE_CDE (
   PUBLIC_ID varchar(30) not null,
   LONG_NAME varchar(200),
   DEFINITION varchar(500),
   VERSION varchar(50),
   LAST_UPDATED datetime,
   primary key (PUBLIC_ID)
);
alter table CATISSUE_PERMISSIBLE_VALUE  add constraint FK57DDCE153B5435E foreign key (PARENT_IDENTIFIER) references CATISSUE_PERMISSIBLE_VALUE  ;
alter table CATISSUE_PERMISSIBLE_VALUE  add constraint FK57DDCE1FC56C2B1 foreign key (PUBLIC_ID) references CATISSUE_CDE ;
