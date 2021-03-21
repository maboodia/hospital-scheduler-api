INSERT INTO doctor (doctor_id, doctor_name) VALUES (doctor_id_seq.nextval, 'Purvi Shangvi');

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Muhamad Aboodia');
INSERT INTO schedule (schedule_id, doctor_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, doctor_id_seq.currval, patient_id_seq.currval, DATE_TRUNC('HOUR', sysdate) + INTERVAL '1' HOUR + INTERVAL '10' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Pei-Ying Chen');
INSERT INTO schedule (schedule_id, doctor_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, doctor_id_seq.currval, patient_id_seq.currval, DATE_TRUNC('HOUR', sysdate) + INTERVAL '1' HOUR + INTERVAL '20' MINUTE, sysdate);

INSERT INTO doctor (doctor_id, doctor_name) VALUES (doctor_id_seq.nextval, 'Limor Dekel');

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Emma Jones');
INSERT INTO schedule (schedule_id, doctor_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, doctor_id_seq.currval, patient_id_seq.currval, DATE_TRUNC('HOUR', sysdate) + INTERVAL '1' HOUR + INTERVAL '30' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Marco Reus');

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Xin Wang');

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Max Kruse');
INSERT INTO schedule (schedule_id, doctor_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, doctor_id_seq.currval, patient_id_seq.currval, DATE_TRUNC('HOUR', sysdate) + INTERVAL '1' HOUR + INTERVAL '60' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Bill Edwards');

INSERT INTO doctor (doctor_id, doctor_name) VALUES (doctor_id_seq.nextval, 'Amr Elhabal');

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Dean Smith');
INSERT INTO schedule (schedule_id, doctor_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, doctor_id_seq.currval, patient_id_seq.currval, DATE_TRUNC('HOUR', sysdate) + INTERVAL '1' HOUR + INTERVAL '80' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'El Nazeer Nazar');
INSERT INTO schedule (schedule_id, doctor_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, doctor_id_seq.currval, patient_id_seq.currval, DATE_TRUNC('HOUR', sysdate) + INTERVAL '1' HOUR + INTERVAL '90' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Chandana Devireddy');
INSERT INTO schedule (schedule_id, doctor_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, doctor_id_seq.currval, patient_id_seq.currval, DATE_TRUNC('HOUR', sysdate) + INTERVAL '1' HOUR + INTERVAL '100' MINUTE, sysdate);

COMMIT;