--------------------------------------------------------
-- Archivo creado  - domingo-noviembre-20-2016   
--------------------------------------------------------
DROP TABLE "PTSERVICIOS"."CARACTERISTICAS" cascade constraints;
DROP TABLE "PTSERVICIOS"."SERVICIOS" cascade constraints;
--------------------------------------------------------
--  DDL for Table CARACTERISTICAS
--------------------------------------------------------

  CREATE TABLE "PTSERVICIOS"."CARACTERISTICAS" 
   (	"ID" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"VALOR" VARCHAR2(100 BYTE), 
	"ID_SERVICIOS" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SERVICIOS
--------------------------------------------------------

  CREATE TABLE "PTSERVICIOS"."SERVICIOS" 
   (	"NOMBRE" VARCHAR2(45 BYTE), 
	"DESCRIPCION" VARCHAR2(200 BYTE), 
	"IMAGEN" VARCHAR2(100 BYTE), 
	"ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence CARACTERISTICAS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PTSERVICIOS"."CARACTERISTICAS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into PTSERVICIOS.CARACTERISTICAS
SET DEFINE OFF;
Insert into PTSERVICIOS.CARACTERISTICAS (ID,NOMBRE,VALOR,ID_SERVICIOS) values ('1','23425345','23452345','4');
Insert into PTSERVICIOS.CARACTERISTICAS (ID,NOMBRE,VALOR,ID_SERVICIOS) values ('2','vvvv','vvvvv','3');
--------------------------------------------------------
--  DDL for Index TABLE1_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PTSERVICIOS"."TABLE1_PK" ON "PTSERVICIOS"."CARACTERISTICAS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger CARACTERISTICAS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PTSERVICIOS"."CARACTERISTICAS_TRG" 
BEFORE INSERT ON CARACTERISTICAS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT CARACTERISTICAS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "PTSERVICIOS"."CARACTERISTICAS_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table CARACTERISTICAS
--------------------------------------------------------

  ALTER TABLE "PTSERVICIOS"."CARACTERISTICAS" ADD CONSTRAINT "TABLE1_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PTSERVICIOS"."CARACTERISTICAS" MODIFY ("ID_SERVICIOS" NOT NULL ENABLE);
  ALTER TABLE "PTSERVICIOS"."CARACTERISTICAS" MODIFY ("VALOR" NOT NULL ENABLE);
  ALTER TABLE "PTSERVICIOS"."CARACTERISTICAS" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "PTSERVICIOS"."CARACTERISTICAS" MODIFY ("ID" NOT NULL ENABLE);