
CREATE Database instituto;

use instituto;

CREATE TABLE alumno (
    rut_alumno   INT NULL,
    dv_alumno    VARCHAR(1),
    pnombre      VARCHAR(30),
    snombre      VARCHAR(30),
    appaterno    VARCHAR(30),
    apmaterno    VARCHAR(30),
    email        VARCHAR(30),
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
    email             VARCHAR(30)
);

ALTER TABLE coordinador ADD CONSTRAINT coordinador_pk PRIMARY KEY ( rut_coordinador );

CREATE TABLE detalle_seccion (
    id_seccion   VARCHAR(30) NOT NULL,
    rut_alumno   INT NOT NULL,
    anio         INT,
    semestre     INT
);

ALTER TABLE detalle_seccion ADD CONSTRAINT detalle_seccion_pk PRIMARY KEY ( id_seccion,rut_alumno );

CREATE TABLE director (
    rut_director   INT NOT NULL,
    dv_director    VARCHAR(1),
    pnombre        VARCHAR(30),
    snombre        VARCHAR(30),
    appaterno      VARCHAR(30),
    apmaterno      VARCHAR(30),
    email          VARCHAR(30)
);

ALTER TABLE director ADD CONSTRAINT director_pk PRIMARY KEY ( rut_director );

CREATE TABLE docente (
    rut_docente   INT NOT NULL,
    dv_docente    VARCHAR(1),
    pnombre       VARCHAR(30),
    snombre       VARCHAR(30),
    appaterno     VARCHAR(30),
    apmaterno     VARCHAR(30),
    email         VARCHAR(30)
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
    id_estadoc                     INT NOT NULL
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

ALTER TABLE detalle_seccion
    ADD CONSTRAINT detalle_alumno_fk FOREIGN KEY ( rut_alumno )
        REFERENCES alumno ( rut_alumno );

ALTER TABLE detalle_seccion
    ADD CONSTRAINT detalle_seccion_fk FOREIGN KEY ( id_seccion )
        REFERENCES seccion ( id_seccion );

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

