CREATE TABLE patient (
    patient_id    INTEGER       NOT NULL PRIMARY KEY,
    patient_name  VARCHAR(64)   NOT NULL
);

create sequence patient_id_seq;

CREATE TABLE doctor (
    doctor_id    INTEGER       NOT NULL PRIMARY KEY,
    doctor_name  VARCHAR(64)   NOT NULL
);

create sequence doctor_id_seq;

CREATE TABLE schedule (
    schedule_id     INTEGER     NOT NULL PRIMARY KEY,
    doctor_id      INTEGER     NOT NULL,
    patient_id      INTEGER     NOT NULL,
    start_date      TIMESTAMP   NOT NULL,
    requested_on    TIMESTAMP   NOT NULL
);

create sequence schedule_id_seq;