create table DOCTOR
(
    ID         serial,
    DEPARTMENT varchar(255) not null,
    constraint DOCTOR_PK
        primary key (ID)
);

create table PATIENT
(
    ID         serial,
    FIRST_NAME varchar(40) not null,
    LAST_NAME  varchar(40) not null,
    DOCTOR_ID  integer,
    constraint PATIENT_PK
        primary key (ID),
    constraint PATIENT_DOCTOR_ID_FK
        foreign key (DOCTOR_ID) references DOCTOR (ID)
);

create table DISEASE
(
    ID           serial,
    DISEASE_NAME varchar(255) not null,
    PATIENT_ID   integer,
    constraint DISEASE_PK
        primary key (ID),
    constraint DISEASE_PATIENT_ID_FK
        foreign key (PATIENT_ID) references PATIENT (ID)
            on delete cascade
);

create table DOCUMENT_REPORT
(
    ID             serial,
    DOCTOR_ID      integer,
    ERROR          boolean,
    ERROR_MSG      varchar(255),
    SOURCE         varchar(40) not null,
    EXECUTION_TIME date,
    constraint DOCUMENT_REPORT_PK
        primary key (ID),
    constraint DOCUMENT_REPORT_DOCTOR_ID_FK
        foreign key (DOCTOR_ID) references DOCTOR (ID)
);
