/*L
  Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/commons-module/LICENSE.txt for details.
L*/

Select SpecimenCollectionGroup_1.IDENTIFIER, SpecimenCollectionGroup_1.NAME, SpecimenCollectionGroup_1.CLINICAL_DIAGNOSIS, SpecimenCollectionGroup_1.CLINICAL_STATUS, SpecimenCollectionGroup_1.ACTIVITY_STATUS From catissue_specimen_coll_group SpecimenCollectionGroup_1 left join catissue_specimen Specimen_2 on (SpecimenCollectionGroup_1.IDENTIFIER=Specimen_2.SPECIMEN_COLLECTION_GROUP_ID) left join catissue_specimen Specimen_3 on (Specimen_2.IDENTIFIER=Specimen_3.PARENT_SPECIMEN_ID) Where (SpecimenCollectionGroup_1.NAME like 'X%') Or(SpecimenCollectionGroup_1.IDENTIFIER = ANY(Select Specimen_2.SPECIMEN_COLLECTION_GROUP_ID From catissue_specimen  Specimen_2 left join catissue_specimen Specimen_3 on (Specimen_2.IDENTIFIER=Specimen_3.PARENT_SPECIMEN_ID) where (Specimen_2.TYPE='RNA') Or(Specimen_3.TYPE='DNA'))) And(SpecimenCollectionGroup_1.IDENTIFIER = ANY(Select Specimen_2.SPECIMEN_COLLECTION_GROUP_ID From catissue_specimen  Specimen_2 where Specimen_2.AVAILABLE=1)) Or(Specimen_2.TYPE!='DNA')
Select Participant_1.ACTIVITY_STATUS, Participant_1.BIRTH_DATE, Participant_1.DEATH_DATE, Participant_1.ETHNICITY, Participant_1.FIRST_NAME, Participant_1.GENDER, Participant_1.IDENTIFIER, Participant_1.LAST_NAME, Participant_1.MIDDLE_NAME, Participant_1.GENOTYPE, Participant_1.SOCIAL_SECURITY_NUMBER, Participant_1.VITAL_STATUS From catissue_participant Participant_1 left join catissue_coll_prot_reg CollectionProtocolRegistr_2 on (Participant_1.IDENTIFIER=CollectionProtocolRegistr_2.PARTICIPANT_ID) left join catissue_specimen_coll_group SpecimenCollectionGroup_3 on (CollectionProtocolRegistr_2.IDENTIFIER=SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID) left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) Where (Participant_1.LAST_NAME like 's%') And((Specimen_4.TYPE='Fixed Tissue') Or(Specimen_4.TYPE='Fresh Tissue'))
Select Participant_1.ACTIVITY_STATUS, Participant_1.BIRTH_DATE, Participant_1.DEATH_DATE, Participant_1.ETHNICITY, Participant_1.FIRST_NAME, Participant_1.GENDER, Participant_1.IDENTIFIER, Participant_1.LAST_NAME, Participant_1.MIDDLE_NAME, Participant_1.GENOTYPE, Participant_1.SOCIAL_SECURITY_NUMBER, Participant_1.VITAL_STATUS From catissue_participant Participant_1 left join catissue_coll_prot_reg CollectionProtocolRegistr_2 on (Participant_1.IDENTIFIER=CollectionProtocolRegistr_2.PARTICIPANT_ID) left join catissue_specimen_coll_group SpecimenCollectionGroup_3 on (CollectionProtocolRegistr_2.IDENTIFIER=SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID) left join catissue_site Site_4 on (SpecimenCollectionGroup_3.SITE_ID=Site_4.IDENTIFIER) left join catissue_specimen Specimen_5 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_5.SPECIMEN_COLLECTION_GROUP_ID) Where ((Site_4.NAME='Site1') Or(Site_4.NAME='Site1')) And((Specimen_5.TYPE='Fixed Tissue') Or(Specimen_5.TYPE='Fresh Tissue'))
Select Participant_1.ACTIVITY_STATUS, Participant_1.BIRTH_DATE, Participant_1.DEATH_DATE, Participant_1.ETHNICITY, Participant_1.FIRST_NAME, Participant_1.GENDER, Participant_1.IDENTIFIER, Participant_1.LAST_NAME, Participant_1.MIDDLE_NAME, Participant_1.GENOTYPE, Participant_1.SOCIAL_SECURITY_NUMBER, Participant_1.VITAL_STATUS From catissue_participant Participant_1 left join catissue_coll_prot_reg CollectionProtocolRegistr_2 on (Participant_1.IDENTIFIER=CollectionProtocolRegistr_2.PARTICIPANT_ID) left join catissue_specimen_coll_group SpecimenCollectionGroup_3 on (CollectionProtocolRegistr_2.IDENTIFIER=SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID) left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) Where (CollectionProtocolRegistr_2.IDENTIFIER = ANY(Select SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID From catissue_specimen_coll_group  SpecimenCollectionGroup_3 left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) where (SpecimenCollectionGroup_3.CLINICAL_STATUS='New Diagnosis') And((Specimen_4.TYPE='DNA') Or(Specimen_4.TYPE='Fresh Tissue')))) And(CollectionProtocolRegistr_2.IDENTIFIER = ANY(Select SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID From catissue_specimen_coll_group  SpecimenCollectionGroup_3 left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) where (SpecimenCollectionGroup_3.CLINICAL_STATUS='Post-Operative') And((Specimen_4.TYPE='Fixed Tissue') Or(Specimen_4.TYPE='Fixed Tissue'))))
Select Participant_1.ACTIVITY_STATUS, Participant_1.BIRTH_DATE, Participant_1.DEATH_DATE, Participant_1.ETHNICITY, Participant_1.FIRST_NAME, Participant_1.GENDER, Participant_1.IDENTIFIER, Participant_1.LAST_NAME, Participant_1.MIDDLE_NAME, Participant_1.GENOTYPE, Participant_1.SOCIAL_SECURITY_NUMBER, Participant_1.VITAL_STATUS From catissue_participant Participant_1 left join catissue_coll_prot_reg CollectionProtocolRegistr_2 on (Participant_1.IDENTIFIER=CollectionProtocolRegistr_2.PARTICIPANT_ID) left join catissue_specimen_coll_group SpecimenCollectionGroup_3 on (CollectionProtocolRegistr_2.IDENTIFIER=SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID) left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) Where (CollectionProtocolRegistr_2.IDENTIFIER = ANY(Select SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID From catissue_specimen_coll_group  SpecimenCollectionGroup_3 left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) where (SpecimenCollectionGroup_3.CLINICAL_STATUS='New Diagnosis') And(SpecimenCollectionGroup_3.IDENTIFIER = ANY(Select Specimen_4.SPECIMEN_COLLECTION_GROUP_ID From catissue_specimen  Specimen_4 where Specimen_4.TYPE='DNA')) And(SpecimenCollectionGroup_3.IDENTIFIER = ANY(Select Specimen_4.SPECIMEN_COLLECTION_GROUP_ID From catissue_specimen  Specimen_4 where Specimen_4.TYPE='Milk')))) And(CollectionProtocolRegistr_2.IDENTIFIER = ANY(Select SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID From catissue_specimen_coll_group  SpecimenCollectionGroup_3 left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) where (SpecimenCollectionGroup_3.CLINICAL_STATUS='Post Operative') And(Specimen_4.TYPE='Fixed Tissue') Or(Specimen_4.TYPE='Fresh Tissue')))
Select Participant_1.ACTIVITY_STATUS, Participant_1.BIRTH_DATE, Participant_1.DEATH_DATE, Participant_1.ETHNICITY, Participant_1.FIRST_NAME, Participant_1.GENDER, Participant_1.IDENTIFIER, Participant_1.LAST_NAME, Participant_1.MIDDLE_NAME, Participant_1.GENOTYPE, Participant_1.SOCIAL_SECURITY_NUMBER, Participant_1.VITAL_STATUS From catissue_participant Participant_1 left join catissue_coll_prot_reg CollectionProtocolRegistr_2 on (Participant_1.IDENTIFIER=CollectionProtocolRegistr_2.PARTICIPANT_ID) left join catissue_specimen_coll_group SpecimenCollectionGroup_3 on (CollectionProtocolRegistr_2.IDENTIFIER=SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID) left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) left join catissue_specimen Specimen_5 on (Specimen_4.IDENTIFIER=Specimen_5.PARENT_SPECIMEN_ID) Where (Specimen_4.TYPE='Fixed Tissue') And(Specimen_5.TYPE='Milk')
Select Participant_1.ACTIVITY_STATUS, Participant_1.BIRTH_DATE, Participant_1.DEATH_DATE, Participant_1.ETHNICITY, Participant_1.FIRST_NAME, Participant_1.GENDER, Participant_1.IDENTIFIER, Participant_1.LAST_NAME, Participant_1.MIDDLE_NAME, Participant_1.GENOTYPE, Participant_1.SOCIAL_SECURITY_NUMBER, Participant_1.VITAL_STATUS From catissue_participant Participant_1 left join catissue_coll_prot_reg CollectionProtocolRegistr_2 on (Participant_1.IDENTIFIER=CollectionProtocolRegistr_2.PARTICIPANT_ID) left join catissue_specimen_coll_group SpecimenCollectionGroup_3 on (CollectionProtocolRegistr_2.IDENTIFIER=SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID) left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) left join catissue_specimen Specimen_5 on (Specimen_4.IDENTIFIER=Specimen_5.PARENT_SPECIMEN_ID) Where (Specimen_4.TYPE='Fixed Tissue') And(Specimen_5.TYPE='Amniotic Fluid')
Select Participant_1.ACTIVITY_STATUS, Participant_1.BIRTH_DATE, Participant_1.DEATH_DATE, Participant_1.ETHNICITY, Participant_1.FIRST_NAME, Participant_1.GENDER, Participant_1.IDENTIFIER, Participant_1.LAST_NAME, Participant_1.MIDDLE_NAME, Participant_1.GENOTYPE, Participant_1.SOCIAL_SECURITY_NUMBER, Participant_1.VITAL_STATUS From catissue_participant Participant_1 left join catissue_coll_prot_reg CollectionProtocolRegistr_2 on (Participant_1.IDENTIFIER=CollectionProtocolRegistr_2.PARTICIPANT_ID) left join catissue_specimen_coll_group SpecimenCollectionGroup_3 on (CollectionProtocolRegistr_2.IDENTIFIER=SpecimenCollectionGroup_3.COLLECTION_PROTOCOL_REG_ID) left join catissue_specimen Specimen_4 on (SpecimenCollectionGroup_3.IDENTIFIER=Specimen_4.SPECIMEN_COLLECTION_GROUP_ID) left join catissue_specimen_char SpecimenCharacteristics_5 on (Specimen_4.SPECIMEN_CHARACTERISTICS_ID=SpecimenCharacteristics_5.IDENTIFIER) Where (SpecimenCollectionGroup_3.IDENTIFIER = ANY(Select Specimen_4.SPECIMEN_COLLECTION_GROUP_ID From catissue_specimen  Specimen_4 left join catissue_specimen_char SpecimenCharacteristics_5 on (Specimen_4.SPECIMEN_CHARACTERISTICS_ID=SpecimenCharacteristics_5.IDENTIFIER) where (Specimen_4.TYPE='DNA' And Specimen_4.PATHOLOGICAL_STATUS='Malignant') And(SpecimenCharacteristics_5.TISSUE_SITE='Prostate Gland'))) And(SpecimenCollectionGroup_3.IDENTIFIER = ANY(Select Specimen_4.SPECIMEN_COLLECTION_GROUP_ID From catissue_specimen  Specimen_4 left join catissue_specimen_char SpecimenCharacteristics_5 on (Specimen_4.SPECIMEN_CHARACTERISTICS_ID=SpecimenCharacteristics_5.IDENTIFIER) where (Specimen_4.TYPE='DNA' And Specimen_4.PATHOLOGICAL_STATUS='Non-Malignant') And(SpecimenCharacteristics_5.TISSUE_SITE='Prostate Gland')))