INSERT INTO "APP"."HOST" (ID,HOSTNAME,VERSION) VALUES (2,'ssdhostname01',{ts '2017-08-30 15:04:56.567000'});
INSERT INTO "APP"."HOST" (ID,HOSTNAME,VERSION) VALUES (6,'hostname01',{ts '2017-08-30 15:05:03.787000'});
INSERT INTO "APP"."HOST" (ID,HOSTNAME,VERSION) VALUES (7,'hostname02',{ts '2017-08-30 15:05:03.907000'});


INSERT INTO "APP"."HOST_SENSOR" (HOST_ID,SENSORS_ID) VALUES (2,3);
INSERT INTO "APP"."HOST_SENSOR" (HOST_ID,SENSORS_ID) VALUES (6,8);
INSERT INTO "APP"."HOST_SENSOR" (HOST_ID,SENSORS_ID) VALUES (6,9);
INSERT INTO "APP"."HOST_SENSOR" (HOST_ID,SENSORS_ID) VALUES (7,10);
INSERT INTO "APP"."HOST_SENSOR" (HOST_ID,SENSORS_ID) VALUES (7,11);


INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (2,4);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (6,12);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (6,13);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (6,14);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (6,15);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (6,16);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (6,17);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (6,18);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (6,19);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (7,20);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (7,21);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (7,22);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (7,23);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (7,24);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (7,25);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (7,26);
INSERT INTO "APP"."HOST_SENSOR_DATA" (HOST_ID,SENSORDATA_ID) VALUES (7,27);


INSERT INTO "APP"."NAMESPACE" (ID,NAMESPACENAME,VERSION) VALUES (1,'ssdnamespace01',{ts '2017-08-30 15:04:56.578000'});
INSERT INTO "APP"."NAMESPACE" (ID,NAMESPACENAME,VERSION) VALUES (5,'namespace01',{ts '2017-08-30 15:05:04.790000'});


INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (1,4);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,12);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,13);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,14);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,15);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,16);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,17);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,18);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,19);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,20);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,21);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,22);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,23);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,24);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,25);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,26);
INSERT INTO "APP"."NAMESPACE_SENSOR_DATA" (NAMESPACE_ID,SENSORDATA_ID) VALUES (5,27);


INSERT INTO "APP"."SENSOR" (ID,HOSTNAME,SENSORNAME,SENSORTYPE,UNIT,VERSION,HOST_ID) VALUES (3,'ssdhostname01','ssdsensorname01','ssdsensortype01','ssdunit01',{ts '2017-08-30 15:04:56.634000'},2);
INSERT INTO "APP"."SENSOR" (ID,HOSTNAME,SENSORNAME,SENSORTYPE,UNIT,VERSION,HOST_ID) VALUES (8,'hostname01','sensorname01','sensortype01','unit01',{ts '2017-08-30 15:05:03.722000'},6);
INSERT INTO "APP"."SENSOR" (ID,HOSTNAME,SENSORNAME,SENSORTYPE,UNIT,VERSION,HOST_ID) VALUES (9,'hostname01','sensorname02','sensortype02','unit02',{ts '2017-08-30 15:05:03.790000'},6);
INSERT INTO "APP"."SENSOR" (ID,HOSTNAME,SENSORNAME,SENSORTYPE,UNIT,VERSION,HOST_ID) VALUES (10,'hostname02','sensorname03','sensortype01','unit01',{ts '2017-08-30 15:05:03.845000'},7);
INSERT INTO "APP"."SENSOR" (ID,HOSTNAME,SENSORNAME,SENSORTYPE,UNIT,VERSION,HOST_ID) VALUES (11,'hostname02','sensorname04','sensortype02','unit02',{ts '2017-08-30 15:05:03.910000'},7);


INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (4,{ts '1970-01-15 07:56:07.890000'},'ssdhostname01','ssdnamespace01','ssdsensorname01','ssdsensortype01','ssdunit01',1.0,{ts '2017-08-30 15:04:56.651000'},2,1,3);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (12,{ts '2017-08-30 15:04:03.524000'},'hostname01','namespace01','sensorname01','sensortype01','unit01',1.0,{ts '2017-08-30 15:05:03.933000'},6,5,8);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (13,{ts '2017-08-30 15:03:03.524000'},'hostname01','namespace01','sensorname01','sensortype01','unit01',2.0,{ts '2017-08-30 15:05:03.949000'},6,5,8);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (14,{ts '2017-08-30 15:02:03.524000'},'hostname01','namespace01','sensorname01','sensortype01','unit01',3.0,{ts '2017-08-30 15:05:03.957000'},6,5,8);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (15,{ts '2017-08-30 15:01:03.524000'},'hostname01','namespace01','sensorname01','sensortype01','unit01',4.0,{ts '2017-08-30 15:05:03.965000'},6,5,8);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (16,{ts '2017-08-30 15:00:03.524000'},'hostname01','namespace01','sensorname02','sensortype02','unit02',5.0,{ts '2017-08-30 15:05:03.972000'},6,5,9);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (17,{ts '2017-08-30 14:59:03.524000'},'hostname01','namespace01','sensorname02','sensortype02','unit02',6.0,{ts '2017-08-30 15:05:03.979000'},6,5,9);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (18,{ts '2017-08-30 14:58:03.524000'},'hostname01','namespace01','sensorname02','sensortype02','unit02',7.0,{ts '2017-08-30 15:05:03.990000'},6,5,9);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (19,{ts '2017-08-30 14:57:03.524000'},'hostname01','namespace01','sensorname02','sensortype02','unit02',8.0,{ts '2017-08-30 15:05:04.100000'},6,5,9);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (20,{ts '2017-08-30 14:56:03.524000'},'hostname02','namespace01','sensorname03','sensortype01','unit01',9.0,{ts '2017-08-30 15:05:04.100000'},7,5,10);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (21,{ts '2017-08-30 14:55:03.524000'},'hostname02','namespace01','sensorname03','sensortype01','unit01',10.0,{ts '2017-08-30 15:05:04.220000'},7,5,10);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (22,{ts '2017-08-30 14:54:03.524000'},'hostname02','namespace01','sensorname03','sensortype01','unit01',11.0,{ts '2017-08-30 15:05:04.360000'},7,5,10);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (23,{ts '2017-08-30 14:53:03.524000'},'hostname02','namespace01','sensorname03','sensortype01','unit01',12.0,{ts '2017-08-30 15:05:04.450000'},7,5,10);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (24,{ts '2017-08-30 14:52:03.524000'},'hostname02','namespace01','sensorname04','sensortype02','unit02',13.0,{ts '2017-08-30 15:05:04.530000'},7,5,11);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (25,{ts '2017-08-30 14:51:03.524000'},'hostname02','namespace01','sensorname04','sensortype02','unit02',14.0,{ts '2017-08-30 15:05:04.630000'},7,5,11);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (26,{ts '2017-08-30 14:50:03.524000'},'hostname02','namespace01','sensorname04','sensortype02','unit02',15.0,{ts '2017-08-30 15:05:04.720000'},7,5,11);
INSERT INTO "APP"."SENSOR_DATA" (ID,CREATEDAT,HOSTNAME,NAMESPACENAME,SENSORNAME,SENSORTYPE,UNIT,VALUE,VERSION,HOST_ID,NAMESPACE_ID,SENSOR_ID) VALUES (27,{ts '2017-08-30 14:49:03.524000'},'hostname02','namespace01','sensorname04','sensortype02','unit02',16.0,{ts '2017-08-30 15:05:04.830000'},7,5,11);


INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (3,4);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (8,12);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (8,13);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (8,14);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (8,15);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (9,16);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (9,17);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (9,18);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (9,19);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (10,20);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (10,21);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (10,22);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (10,23);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (11,24);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (11,25);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (11,26);
INSERT INTO "APP"."SENSOR_SENSOR_DATA" (SENSOR_ID,SENSORDATA_ID) VALUES (11,27);


INSERT INTO "APP"."SEQUENCE" (SEQ_NAME,SEQ_COUNT) VALUES ('SEQ_GEN',50);
