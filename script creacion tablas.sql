create database inasistencias;
use inasistencias;

create table docente(
	id_usuario int
);

create table alumno(
	id_usuario int,
    id_carrera varchar(10),
    anio_ingreso int
);

create table usuario(
	rut int,
    pass_usuario varchar(30),   
    nombre varchar(30),
    ap_paterno varchar(30),
    ap_materno varchar(30),    
    primary key (rut)
);

create table seccion(
	cod_ramo varchar(30),
    num_seccion int,
    jornada varchar(1),
    anio int,
    semestre int,
    id_docente int
);

create table inasistencia(
	id_inasistencia int,
	rut_alumno int,
    id_seccion int,
    fecha date,
    primary key(id_inasistencia)
);

create table justificacion(
	id_inasistencia int,
    id_motivo int,
    glosa varchar(255) -- para que el alumno se explaye ;) ;)
);

create table motivo(
	id_motivo int,
    desc_motivo varchar(30)
);

create table carrera(
	id_carrera int,
    nombre_carrera varchar(30),
    primary key (id_carrera)
);