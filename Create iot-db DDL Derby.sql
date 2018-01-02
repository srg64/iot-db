CREATE TABLE "APP"."HOST"
(
   ID bigint PRIMARY KEY NOT NULL,
   HOSTNAME varchar(255) NOT NULL,
   VERSION timestamp
)
;
CREATE TABLE "APP"."HOST_SENSOR"
(
   HOST_ID bigint NOT NULL,
   SENSORS_ID bigint NOT NULL,
   CONSTRAINT SQL170830145547980 PRIMARY KEY (HOST_ID,SENSORS_ID)
)
;
CREATE TABLE "APP"."HOST_SENSOR_DATA"
(
   HOST_ID bigint NOT NULL,
   SENSORDATA_ID bigint NOT NULL,
   CONSTRAINT SQL170830145547930 PRIMARY KEY (HOST_ID,SENSORDATA_ID)
)
;
CREATE TABLE "APP"."NAMESPACE"
(
   ID bigint PRIMARY KEY NOT NULL,
   NAMESPACENAME varchar(255) NOT NULL,
   VERSION timestamp
)
;
CREATE TABLE "APP"."NAMESPACE_SENSOR_DATA"
(
   NAMESPACE_ID bigint NOT NULL,
   SENSORDATA_ID bigint NOT NULL,
   CONSTRAINT SQL170830145547880 PRIMARY KEY (NAMESPACE_ID,SENSORDATA_ID)
)
;
CREATE TABLE "APP"."SENSOR"
(
   ID bigint PRIMARY KEY NOT NULL,
   HOSTNAME varchar(255) NOT NULL,
   SENSORNAME varchar(255) NOT NULL,
   SENSORTYPE varchar(255) NOT NULL,
   UNIT varchar(255) NOT NULL,
   VERSION timestamp,
   HOST_ID bigint
)
;
CREATE TABLE "APP"."SENSOR_DATA"
(
   ID bigint PRIMARY KEY NOT NULL,
   CREATEDAT timestamp NOT NULL,
   HOSTNAME varchar(255) NOT NULL,
   NAMESPACENAME varchar(255) NOT NULL,
   SENSORNAME varchar(255) NOT NULL,
   SENSORTYPE varchar(255) NOT NULL,
   UNIT varchar(50) NOT NULL,
   VALUE float(52) NOT NULL,
   VERSION timestamp,
   HOST_ID bigint,
   NAMESPACE_ID bigint,
   SENSOR_ID bigint
)
;
CREATE TABLE "APP"."SENSOR_SENSOR_DATA"
(
   SENSOR_ID bigint NOT NULL,
   SENSORDATA_ID bigint NOT NULL,
   CONSTRAINT SQL170830145548010 PRIMARY KEY (SENSOR_ID,SENSORDATA_ID)
)
;
CREATE TABLE "APP"."SEQUENCE"
(
   SEQ_NAME varchar(50) PRIMARY KEY NOT NULL,
   SEQ_COUNT decimal(15)
)
;
CREATE UNIQUE INDEX SQL170830145547761 ON "APP"."HOST"(ID)
;
CREATE UNIQUE INDEX SQL170830145547760 ON "APP"."HOST"(HOSTNAME)
;
ALTER TABLE "APP"."HOST_SENSOR"
ADD CONSTRAINT HSTSENSORSENSORSID
FOREIGN KEY (SENSORS_ID)
REFERENCES "APP"."SENSOR"(ID)
;
ALTER TABLE "APP"."HOST_SENSOR"
ADD CONSTRAINT HOST_SENSORHOST_ID
FOREIGN KEY (HOST_ID)
REFERENCES "APP"."HOST"(ID)
;
CREATE INDEX SQL170830150351300 ON "APP"."HOST_SENSOR"(SENSORS_ID)
;
CREATE INDEX SQL170830150351320 ON "APP"."HOST_SENSOR"(HOST_ID)
;
CREATE UNIQUE INDEX SQL170830145547980 ON "APP"."HOST_SENSOR"
(
  HOST_ID,
  SENSORS_ID
)
;
ALTER TABLE "APP"."HOST_SENSOR_DATA"
ADD CONSTRAINT HSTSNSRDATASNSRDTD
FOREIGN KEY (SENSORDATA_ID)
REFERENCES "APP"."SENSOR_DATA"(ID)
;
ALTER TABLE "APP"."HOST_SENSOR_DATA"
ADD CONSTRAINT HSTSENSORDATAHSTID
FOREIGN KEY (HOST_ID)
REFERENCES "APP"."HOST"(ID)
;
CREATE INDEX SQL170830150351250 ON "APP"."HOST_SENSOR_DATA"(HOST_ID)
;
CREATE UNIQUE INDEX SQL170830145547930 ON "APP"."HOST_SENSOR_DATA"
(
  HOST_ID,
  SENSORDATA_ID
)
;
CREATE INDEX SQL170830150351280 ON "APP"."HOST_SENSOR_DATA"(SENSORDATA_ID)
;
CREATE UNIQUE INDEX SQL170830145547141 ON "APP"."NAMESPACE"(ID)
;
CREATE UNIQUE INDEX SQL170830145547140 ON "APP"."NAMESPACE"(NAMESPACENAME)
;
ALTER TABLE "APP"."NAMESPACE_SENSOR_DATA"
ADD CONSTRAINT NMSPCSNSRDTSNSRDTD
FOREIGN KEY (SENSORDATA_ID)
REFERENCES "APP"."SENSOR_DATA"(ID)
;
ALTER TABLE "APP"."NAMESPACE_SENSOR_DATA"
ADD CONSTRAINT NMSPCSNSRDTANMSPCD
FOREIGN KEY (NAMESPACE_ID)
REFERENCES "APP"."NAMESPACE"(ID)
;
CREATE INDEX SQL170830150351230 ON "APP"."NAMESPACE_SENSOR_DATA"(SENSORDATA_ID)
;
CREATE INDEX SQL170830150351210 ON "APP"."NAMESPACE_SENSOR_DATA"(NAMESPACE_ID)
;
CREATE UNIQUE INDEX SQL170830145547880 ON "APP"."NAMESPACE_SENSOR_DATA"
(
  NAMESPACE_ID,
  SENSORDATA_ID
)
;
ALTER TABLE "APP"."SENSOR"
ADD CONSTRAINT FK_SENSOR_HOST_ID
FOREIGN KEY (HOST_ID)
REFERENCES "APP"."HOST"(ID)
;
CREATE INDEX SQL170830150351110 ON "APP"."SENSOR"(HOST_ID)
;
CREATE UNIQUE INDEX SQL170830145547800 ON "APP"."SENSOR"(ID)
;
CREATE UNIQUE INDEX SQL170830150351070 ON "APP"."SENSOR"
(
  HOSTNAME,
  SENSORNAME
)
;
ALTER TABLE "APP"."SENSOR_DATA"
ADD CONSTRAINT SENSORDATASENSORID
FOREIGN KEY (SENSOR_ID)
REFERENCES "APP"."SENSOR"(ID)
;
ALTER TABLE "APP"."SENSOR_DATA"
ADD CONSTRAINT SENSOR_DATAHOST_ID
FOREIGN KEY (HOST_ID)
REFERENCES "APP"."HOST"(ID)
;
ALTER TABLE "APP"."SENSOR_DATA"
ADD CONSTRAINT SNSORDATANMSPACEID
FOREIGN KEY (NAMESPACE_ID)
REFERENCES "APP"."NAMESPACE"(ID)
;
CREATE INDEX SQL170830150351170 ON "APP"."SENSOR_DATA"(SENSOR_ID)
;
CREATE UNIQUE INDEX SQL170830145547840 ON "APP"."SENSOR_DATA"(ID)
;
CREATE INDEX SQL170830150351190 ON "APP"."SENSOR_DATA"(NAMESPACE_ID)
;
CREATE INDEX SQL170830150351150 ON "APP"."SENSOR_DATA"(HOST_ID)
;
CREATE UNIQUE INDEX SQL170830150351090 ON "APP"."SENSOR_DATA"
(
  NAMESPACENAME,
  HOSTNAME,
  SENSORNAME,
  CREATEDAT
)
;
ALTER TABLE "APP"."SENSOR_SENSOR_DATA"
ADD CONSTRAINT SNSRSNSORDATASNSRD
FOREIGN KEY (SENSOR_ID)
REFERENCES "APP"."SENSOR"(ID)
;
ALTER TABLE "APP"."SENSOR_SENSOR_DATA"
ADD CONSTRAINT SNSRSNSRDTASNSRDTD
FOREIGN KEY (SENSORDATA_ID)
REFERENCES "APP"."SENSOR_DATA"(ID)
;
CREATE INDEX SQL170830150351360 ON "APP"."SENSOR_SENSOR_DATA"(SENSORDATA_ID)
;
CREATE UNIQUE INDEX SQL170830145548010 ON "APP"."SENSOR_SENSOR_DATA"
(
  SENSOR_ID,
  SENSORDATA_ID
)
;
CREATE INDEX SQL170830150351340 ON "APP"."SENSOR_SENSOR_DATA"(SENSOR_ID)
;
CREATE UNIQUE INDEX SQL170829174005290 ON "APP"."SEQUENCE"(SEQ_NAME)
;
