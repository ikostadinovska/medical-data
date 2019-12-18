create table DOCTOR
(
    ID         integer        not null,
    DEPARTMENT VARCHAR2(255) not null,
    constraint DOCTOR_PK
        primary key (ID)
);

create table PATIENT
(
    ID         integer       not null,
    FIRST_NAME VARCHAR2(40) not null,
    LAST_NAME  VARCHAR2(40) not null,
    DOCTOR_ID  integer,
    constraint PATIENT_PK
        primary key (ID),
    constraint PATIENT_DOCTOR_ID_FK
        foreign key (DOCTOR_ID) references DOCTOR (ID)
);

create table DISEASE
(
    ID           integer        not null,
    DISEASE_NAME VARCHAR2(255) not null,
    PATIENT_ID   integer,
    constraint DISEASE_PK
        primary key (ID),
    constraint DISEASE_PATIENT_ID_FK
        foreign key (PATIENT_ID) references PATIENT (ID)
            on delete cascade
);

create table DOCUMENT_REPORT
(
    ID             integer       not null,
    DOCTOR_ID      integer,
    ERROR          boolean,
    ERROR_MSG      VARCHAR2(255),
    SOURCE         VARCHAR2(40) not null,
    EXECUTION_TIME DATETIME     not null,
    constraint DOCUMENT_REPORT_PK
        primary key (ID),
    constraint DOCUMENT_REPORT_DOCTOR_ID_FK
        foreign key (DOCTOR_ID) references DOCTOR (ID)
);


