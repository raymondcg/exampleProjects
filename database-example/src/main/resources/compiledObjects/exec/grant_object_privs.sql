--liquibase formatted sql

--changeset Raymond:grant_object_privs dbms:oracle runAlways runOnChange:true splitStatements:false
BEGIN
	EXECUTE IMMEDIATE 'ALTER SESSION SET CURRENT_SCHEMA=${db.schema.name}';
	
	FOR r IN (SELECT object_name,object_type FROM all_objects WHERE owner = upper('${db.schema.name}') AND secondary = 'N' AND object_type IN ('TABLE', 'SEQUENCE', 'PROCEDURE','MATERIALIZED VIEW','PACKAGE') AND STATUS= 'VALID' ORDER BY object_type )
	LOOP
	
		IF r.object_type IN ('PROCEDURE','PACKAGE') THEN
			EXECUTE IMMEDIATE 'GRANT EXECUTE ON ' || r.object_name || ' TO ${db.role.execute}';
		ELSE
			EXECUTE IMMEDIATE 'GRANT SELECT ON ' || r.object_name || ' TO ${db.role.read-only}';
			EXECUTE IMMEDIATE 'GRANT SELECT ON ' || r.object_name || ' TO ${db.role.read-write}';
			
			IF r.object_type = 'TABLE' THEN
				EXECUTE IMMEDIATE 'GRANT DELETE, INSERT, SELECT, UPDATE ON ' || r.object_name || ' TO ${db.role.read-write}';
			END IF;
		END IF;
	END LOOP;
	
	EXECUTE IMMEDIATE 'ALTER SESSION SET CURRENT_SCHEMA=${db.user}';
END;
/