INSERT INTO patient (patient_id, patient_name)
VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO schedule (schedule_id, patient_id, start_date, requested_on)
VALUES (schedule_id_seq.nextval, patient_id_seq.currval, sysdate, sysdate);

INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');
INSERT INTO patient (patient_id, patient_name) VALUES (patient_id_seq.nextval, 'Patient '||''||patient_id_seq.currval||'');

COMMIT;