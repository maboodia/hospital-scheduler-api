INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Muhamad Aboodia');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '10' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Pei-Ying Chen');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '20' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Emma Jones');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '30' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Marco Reus');
--INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '40' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Xin Wang');
--INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '50' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Max Kruse');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '60' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Bill Edwards');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '70' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Dean Smith');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '80' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'El Nazeer Nazar');
--INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '90' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Chandana Devireddy');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on) VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '100' MINUTE, sysdate);

COMMIT;