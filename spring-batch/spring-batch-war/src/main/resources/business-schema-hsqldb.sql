DROP TABLE  LEAD_INPUTS IF EXISTS;
DROP TABLE  LEAD_INPUTS_SEQ IF EXISTS;

CREATE TABLE LEAD_INPUTS (
	ID BIGINT IDENTITY,
	DATA LONGVARCHAR
);
CREATE TABLE LEAD_INPUTS_SEQ (
	ID BIGINT IDENTITY
);
INSERT INTO LEAD_INPUTS_SEQ (ID) VALUES (0);