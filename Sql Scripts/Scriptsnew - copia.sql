DROP DATABASE IF EXISTS instituto;


CREATE Database instituto;

use instituto;

CREATE TABLE alumno (
    rut_alumno   INT NULL,
    dv_alumno    VARCHAR(1),
    pnombre      VARCHAR(30),
    snombre      VARCHAR(30),
    appaterno    VARCHAR(30),
    apmaterno    VARCHAR(30),
    email        VARCHAR(50),
    id_carrera   VARCHAR(30) NOT NULL
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( rut_alumno );

CREATE TABLE carrera (
    id_carrera       VARCHAR(30) NOT NULL,
    nombre_carrera   VARCHAR(300),
    rut_director     INT NOT NULL
);

ALTER TABLE carrera ADD CONSTRAINT carrera_pk PRIMARY KEY ( id_carrera );

CREATE TABLE control_usuario (
    id_control        INT NOT NULL AUTO_INCREMENT,
    usuario           VARCHAR(30),
    clave             VARCHAR(30),
    rut_usuario       INT,
    id_tipo_usuario   INT NOT NULL,
    PRIMARY KEY (id_control)
);

CREATE TABLE coordinador (
    rut_coordinador   INT NOT NULL,
    dv_coordinador    VARCHAR(1),
    pnombre           VARCHAR(30),
    snombre           VARCHAR(30),
    appaterno         VARCHAR(30),
    apmaterno         VARCHAR(30),
    email             VARCHAR(50)
);

ALTER TABLE coordinador ADD CONSTRAINT coordinador_pk PRIMARY KEY ( rut_coordinador );

CREATE TABLE detalle_seccion (
	id_detalle_seccion INT NOT NULL AUTO_INCREMENT,
    id_seccion   	   VARCHAR(30),
    rut_alumno   	   INT,
    anio               INT,
    semestre           INT,
    PRIMARY KEY(id_detalle_seccion)
);


CREATE TABLE director (
    rut_director   INT NOT NULL,
    dv_director    VARCHAR(1),
    pnombre        VARCHAR(30),
    snombre        VARCHAR(30),
    appaterno      VARCHAR(30),
    apmaterno      VARCHAR(30),
    email          VARCHAR(50)
);

ALTER TABLE director ADD CONSTRAINT director_pk PRIMARY KEY ( rut_director );

CREATE TABLE docente (
    rut_docente   INT NOT NULL,
    dv_docente    VARCHAR(1),
    pnombre       VARCHAR(30),
    snombre       VARCHAR(30),
    appaterno     VARCHAR(30),
    apmaterno     VARCHAR(30),
    email         VARCHAR(50)
);

ALTER TABLE docente ADD CONSTRAINT docente_pk PRIMARY KEY ( rut_docente );

CREATE TABLE estado_correo (
    id_estadoc       INT NOT NULL,
    nombre_estadoc   VARCHAR(30)
);

ALTER TABLE estado_correo ADD CONSTRAINT estado_correo_pk PRIMARY KEY ( id_estadoc );

CREATE TABLE estado_inasistencia (
    id_estadoi       INT NOT NULL,
    nombre_estadoi   VARCHAR(30)
);

ALTER TABLE estado_inasistencia ADD CONSTRAINT estado_inasistencia_pk PRIMARY KEY ( id_estadoi );

CREATE TABLE estado_justificativo (
    id_estadoj       INT NOT NULL,
    nombre_estadoj   VARCHAR(30)
);

ALTER TABLE estado_justificativo ADD CONSTRAINT estado_justificativo_pk PRIMARY KEY ( id_estadoj );

CREATE TABLE inasistencia (
    id_inasistencia   INT NOT NULL AUTO_INCREMENT,
    rut_alumno        INT NOT NULL,
    id_seccion    VARCHAR(30) NOT NULL,
    fecha             DATE,
    id_estadoi        INT NOT NULL,
    PRIMARY KEY (id_inasistencia)
);

CREATE TABLE justificacion (
    id_inasistencia   INT NOT NULL,
    fecha_envio                    DATE,
    id_motivo                      INT NOT NULL,
    glosa                          VARCHAR(300),
    id_estadoj                     INT NOT NULL,
    id_estadoc                     INT NOT NULL,
    PRIMARY KEY (id_inasistencia)
);

CREATE TABLE motivo (
    id_motivo       INT NOT NULL,
    nombre_motivo   VARCHAR(100)
);

ALTER TABLE motivo ADD CONSTRAINT motivo_pk PRIMARY KEY ( id_motivo );

CREATE TABLE ramo (
    id_ramo       VARCHAR(30) NOT NULL,
    nombre_ramo   VARCHAR(100)
);

ALTER TABLE ramo ADD CONSTRAINT ramo_pk PRIMARY KEY ( id_ramo );

CREATE TABLE seccion (
    id_seccion    VARCHAR(30) NOT NULL,
    id_ramo       VARCHAR(30) NOT NULL,
    rut_docente   INT NOT NULL
);

ALTER TABLE seccion ADD CONSTRAINT seccion_pk PRIMARY KEY ( id_seccion );

CREATE TABLE tipo_usuario (
    id_tipo_usuario   INT NOT NULL,
    tipou_nombre      VARCHAR(30)
);

ALTER TABLE tipo_usuario ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY ( id_tipo_usuario );

ALTER TABLE alumno
    ADD CONSTRAINT alumno_carrera_fk FOREIGN KEY ( id_carrera )
        REFERENCES carrera ( id_carrera );

ALTER TABLE carrera
    ADD CONSTRAINT carrera_director_fk FOREIGN KEY ( rut_director )
        REFERENCES director ( rut_director );

ALTER TABLE control_usuario
    ADD CONSTRAINT cous_tius_fk FOREIGN KEY ( id_tipo_usuario )
        REFERENCES tipo_usuario ( id_tipo_usuario );

ALTER TABLE inasistencia
    ADD CONSTRAINT inasistencia_alumno_fk FOREIGN KEY ( rut_alumno )
        REFERENCES alumno ( rut_alumno );

ALTER TABLE inasistencia
    ADD CONSTRAINT inasistencia_estado_fk FOREIGN KEY ( id_estadoi )
        REFERENCES estado_inasistencia ( id_estadoi );

ALTER TABLE inasistencia
    ADD CONSTRAINT inasistencia_seccion_fk FOREIGN KEY ( id_seccion )
        REFERENCES seccion ( id_seccion );

ALTER TABLE justificacion
    ADD CONSTRAINT justificacion_correo_fk FOREIGN KEY ( id_estadoc )
        REFERENCES estado_correo ( id_estadoc );

ALTER TABLE justificacion
    ADD CONSTRAINT justificacion_estado_fk FOREIGN KEY ( id_estadoj )
        REFERENCES estado_justificativo ( id_estadoj );

ALTER TABLE justificacion
    ADD CONSTRAINT justificacion_inasistencia_fk FOREIGN KEY ( id_inasistencia )
        REFERENCES inasistencia ( id_inasistencia );

ALTER TABLE justificacion
    ADD CONSTRAINT justificacion_motivo_fk FOREIGN KEY ( id_motivo )
        REFERENCES motivo ( id_motivo );

ALTER TABLE seccion
    ADD CONSTRAINT seccion_docente_fk FOREIGN KEY ( rut_docente )
        REFERENCES docente ( rut_docente );

ALTER TABLE seccion
    ADD CONSTRAINT seccion_ramo_fk FOREIGN KEY ( id_ramo )
        REFERENCES ramo ( id_ramo );
-- director
INSERT INTO director VALUES(3001,'1','Carlos','Alberto','Orellana','Aguayo','controlinasistencia@gmail.com');
-- Carreras -- necesitan tener un director
INSERT INTO carrera VALUES('14460-03','ANALISTA PROGRAMADOR COMPUTACIONAL',3001);
-- docente
INSERT INTO docente VALUES(2001,'1','Gabriel','Alonso ','Parra ','Ovalle ','gabparraprofesor@gmail.com');
INSERT INTO docente VALUES(2002,'1','Cristian','Orlando','Garcia','Guitierrez','cris.garciaguprofesor@gmail.com');
INSERT INTO docente VALUES(2003,'1','Juan','Esteban','Harrys','Moure','j.harrysprofesor@gmail.com');
-- coordinador ADMINISTRADOR
INSERT INTO coordinador VALUES(4001,'1','Sebastian','','Orrego','Aguayo','controlinasistencia@gmail.com');
INSERT INTO coordinador VALUES(4002,'1','Benjamin','Elias','Mora','Torres','controlinasistencia@gmail.com');
-- alumnos de 10 - 28 (Acorde al excel)
INSERT INTO alumno VALUES(10,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(11,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(12,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(13,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(14,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(15,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(16,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(17,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(18,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(19,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(20,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(21,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(22,'1','Jack','Johnny','Sparow','Deep','car.orellanaa@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(23,'1','Steve','John','Rogers','Storm','s.orregoa@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(24,'1','Carlos','Alberto','Orellana','Aguayo','car.orellanaa@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(25,'1','Sebastian','Isaac','Orrego','Aguayo','s.orregoa@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(26,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(27,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(28,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(29,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');
INSERT INTO alumno VALUES(30,'1','Benjamin','Elias','Mora','Torres','b.morat@alumnos.duoc.cl','14460-03');

-- uSUARIO Y CLAVE DE LOS USUARIOS 
-- control de usuario login (RF3)
INSERT INTO tipo_usuario VALUES(1,'alumno');
INSERT INTO tipo_usuario VALUES(2,'docente');
INSERT INTO tipo_usuario VALUES(3,'director');
INSERT INTO tipo_usuario VALUES(4,'coordinador');
-- ACCESO coordinador
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('4001','1234',4001,4);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('4002','1234',4002,4);
-- ACCESO Docente
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('2001','1234',2001,2);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('2002','1234',2002,2);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('2003','1234',2003,2);
-- ACCESO director
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('3001','1234',3001,3);
-- ACCESO alumno
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('10','1234',10,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('11','1234',11,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('12','1234',12,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('13','1234',13,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('14','1234',14,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('15','1234',15,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('16','1234',16,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('17','1234',17,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('18','1234',18,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('19','1234',19,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('20','1234',20,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('21','1234',21,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('22','1234',22,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('23','1234',23,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('24','1234',24,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('25','1234',25,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('26','1234',26,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('27','1234',27,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('28','1234',28,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('29','1234',29,1);
INSERT INTO control_usuario (usuario,clave,rut_usuario,id_tipo_usuario) VALUES('30','1234',30,1);
-- Ramos asignaturas que imparten
INSERT INTO ramo VALUES('ASO4461','ADMINISTRACION DE SISTEMAS OPERATIVOS');
INSERT INTO ramo VALUES('DEJ4501','DESARROLLO EN JAVA');
INSERT INTO ramo VALUES('DEN4501','DESARROLLO EN .NET');
INSERT INTO ramo VALUES('INU411','INGLES INTERMEDIO II');
INSERT INTO ramo VALUES('PEI110','EMPRENDIMIENTO E INNOVACION');
INSERT INTO ramo VALUES('PFC040','DOCTRINA SOCIAL DE LA IGLESIA');
-- seccion que se crean por tener varios ramos ejemplo : DESARROLLO en JAva se hacen en dos clases diferentes
INSERT INTO seccion VALUES('ASO4461-002D','ASO4461',2001);
INSERT INTO seccion VALUES('DEJ4501-001','DEJ4501',2002);
INSERT INTO seccion VALUES('DEJ4501-002','DEJ4501',2002);
INSERT INTO seccion VALUES('DEJ4501-003','DEJ4501',2002);
INSERT INTO seccion VALUES('PEI110-030D','PEI110',2001);
INSERT INTO seccion VALUES('ASO4461-001D','ASO4461',2003);

-- Crea un curos con X alumnos dentro de 1 id de seccion
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',10,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',11,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',12,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',13,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',14,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',15,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',16,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',17,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',18,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',19,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',20,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',21,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',22,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',23,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',24,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',25,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',26,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',27,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',28,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',29,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('DEJ4501-001',30,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',10,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',11,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',12,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',13,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',14,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',15,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',16,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',17,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',18,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',19,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',20,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',21,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',22,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',23,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',24,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',25,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',26,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',27,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',28,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',29,2017,2);
INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('PEI110-030D',30,2017,2);

-- Se encarga de saber si la fecha de envio fue enviado 1 vez (RF8)
INSERT INTO estado_correo VALUES(1,'ENVIADO 1 VEZ');
INSERT INTO estado_correo VALUES(2,'ENVIADO 2 VEZ');
-- Se encarga de controlar de formal general la inasistencia (RF7)
INSERT INTO estado_inasistencia VALUES(0,'Subido');
INSERT INTO estado_inasistencia VALUES(1,'Enviado a los Alumnos');
INSERT INTO estado_inasistencia VALUES(2,'Justificado por alumno');
INSERT INTO estado_inasistencia VALUES(3,'Revisado por Docente');
--  Se encarga de controlar el estado de la Justificacion si ha respondido el alumno (RF6)
INSERT INTO estado_justificativo VALUES(0,'No Justificado');
INSERT INTO estado_justificativo VALUES(1,'Justificado');

-- Motivos de la Justificacion
INSERT INTO motivo VALUES (0,'');
INSERT INTO motivo VALUES (1,'Economicos');
INSERT INTO motivo VALUES (2,'Salud');
INSERT INTO motivo VALUES (3,'Laboral');
INSERT INTO motivo VALUES (4,'Tramite');
INSERT INTO motivo VALUES (5,'No entiendo la materia');
INSERT INTO motivo VALUES (6,'No le entiendo al profesor');
INSERT INTO motivo VALUES (7,'Me quede dormido');
INSERT INTO motivo VALUES (8,'Problemas familiares varios');
INSERT INTO motivo VALUES (9,'Problemas con el transporte');
INSERT INTO motivo VALUES (10,'Actividad extra-programatica del instituto');
INSERT INTO motivo VALUES (11,'Otros');

-- PARA REPORTE DE INASISTENCIAS 
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (11,'DEJ4501-001','2017-09-12',2);
INSERT Into justificacion values (1,'2017-11-18',7,'no dormi bien y me quede dormido',1,2);

INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (14,'DEJ4501-002','2017-09-05',2);
INSERT Into justificacion values (2,'2017-11-18',9,'no me paro la micro',1,2);

INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (18,'PEI110-030D','2017-07-08',2);
INSERT Into justificacion values (3,'2017-11-18',6,'el profesor es muy loco para enseñar',1,2);

INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (20,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (4,'2017-11-18',8,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (10,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (5,'2017-11-18',1,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (12,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (6,'2017-11-18',2,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (13,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (7,'2017-11-18',3,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (14,'DEJ4501-002','2017-07-08',3);
INSERT Into justificacion values (8,'2017-11-18',5,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (21,'DEJ4501-002','2017-07-08',3);
INSERT Into justificacion values (9,'2017-11-18',6,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (24,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (10,'2017-11-18',5,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (25,'DEJ4501-002','2017-07-08',3);
INSERT Into justificacion values (11,'2017-11-18',1,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (26,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (12,'2017-11-18',2,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (27,'DEJ4501-002','2017-07-08',3);
INSERT Into justificacion values (13,'2017-11-18',2,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (28,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (14,'2017-11-18',3,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (29,'DEJ4501-002','2017-07-08',3);
INSERT Into justificacion values (15,'2017-11-18',4,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (17,'DEJ4501-002','2017-07-08',3);
INSERT Into justificacion values (16,'2017-11-18',3,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (18,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (17,'2017-11-18',1,'el profesor es muy loco para enseñar',1,2);
INSERT INTO inasistencia (rut_alumno,id_seccion, fecha, id_estadoi) VALUES (15,'PEI110-030D','2017-07-08',3);
INSERT Into justificacion values (18,'2017-11-18',2,'el profesor es muy loco para enseñar',1,2);
