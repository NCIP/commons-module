/*L
  Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/commons-module/LICENSE.txt for details.
L*/

#This file has been used for junit testing of AutomateImport for mysql databse.
drop table if exists CATISSUE_PERMISSIBLE_VALUE;
drop table if exists CATISSUE_CDE;
create table CATISSUE_CDE (
   PUBLIC_ID varchar(30) not null,
   LONG_NAME varchar(200),
   DEFINITION text,
   VERSION varchar(50),
   LAST_UPDATED date,
   primary key (PUBLIC_ID)
);

create table CATISSUE_PERMISSIBLE_VALUE (
   IDENTIFIER bigint not null auto_increment,
   CONCEPT_CODE varchar(40),
   DEFINITION text,
   PARENT_IDENTIFIER bigint,
   VALUE varchar(225),
   PUBLIC_ID varchar(30),
   primary key (IDENTIFIER)
);
alter table CATISSUE_PERMISSIBLE_VALUE add index FK57DDCE153B5435E (PARENT_IDENTIFIER), add constraint FK57DDCE153B5435E foreign key (PARENT_IDENTIFIER) references CATISSUE_PERMISSIBLE_VALUE (IDENTIFIER);
alter table CATISSUE_PERMISSIBLE_VALUE add index FK57DDCE1FC56C2B1 (PUBLIC_ID), add constraint FK57DDCE1FC56C2B1 foreign key (PUBLIC_ID) references CATISSUE_CDE (PUBLIC_ID);
