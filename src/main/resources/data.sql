INSERT INTO patient (patient_id, patient_name)
VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '10' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '20' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '30' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '40' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '50' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '60' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '70' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '80' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '90' MINUTE, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate + INTERVAL '100' MINUTE, sysdate);

COMMIT;