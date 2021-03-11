CREATE TABLE patient (
    patient_id    INTEGER       NOT NULL PRIMARY KEY,
    patient_name  VARCHAR(64)   NOT NULL
);

create sequence patient_id_seq;

CREATE TABLE schedule (
    schedule_id     INTEGER     NOT NULL PRIMARY KEY,
    patient_id      INTEGER     NOT NULL,
    start_date      TIMESTAMP   NOT NULL,
    requested_on    TIMESTAMP   NOT NULL
);

create sequence schedule_id_seq;