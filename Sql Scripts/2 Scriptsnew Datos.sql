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
INSERT INTO alumno VALUES(25,'1','Sebastian',' ','Orrego','Aguayo','s.orregoa@alumnos.duoc.cl','14460-03');
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
-- Se encarga de saber si la fecha de envio fue enviado 1 vez (RF8)
INSERT INTO estado_correo VALUES(1,'ENVIADO 1 VEZ');
INSERT INTO estado_correo VALUES(2,'ENVIADO 2 VEZ');
-- Se encarga de controlar de formal general la inasistencia (RF7)
INSERT INTO estado_inasistencia VALUES(0,'subido');
INSERT INTO estado_inasistencia VALUES(1,'Enviado a los Alumnos');
INSERT INTO estado_inasistencia VALUES(2,'Justificado por alumno');
INSERT INTO estado_inasistencia VALUES(3,'Revisado por Docente');
--  Se encarga de controlar el estado de la Justificacion si ha respondido el alumno (RF6)
INSERT INTO estado_justificativo VALUES(0,'No Justificado');
INSERT INTO estado_justificativo VALUES(1,'Justificado');

-- Motivos de la Justificacion
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