# Prueba 3 JAVA
## Se solicita desarrollar un proyecto bajo la modalidad de **entrega por encargo** , según las consideraciones de diseño que serán  enunciadas más adelante. Para el desarrollo del proyecto, usted puede formar un grupo de trabajo de 2 a 3 personas.

## Para finalizar el proceso, cada grupo deberá realizar una presentación de máximo 10 minutos de duración, en donde se debe realizar una demostración de su sistema en vivo y una descripción técnica de los principales componentes. 

# Los entregables que deben acompañar la entrega formal son los siguientes: 
*	Presentación del sistema
*	Código fuente del proyecto

## El Encargo debe ser entregado dos semanas después de la entrega de la evaluación. Entregas posteriores, incompletas, con problemas de compilación o atrasadas no serán revisadas y se calificará con nota 1.0.  
## El tema del proyecto debe ser único en la sección de la asignatura.
## Además, se debe considerar un modelo de datos, el cual tenga un mínimo de **4 tablas**.

## En relación al producto entregado, el arquitecto ha solicitado que tenga presente las siguientes consideraciones de diseño:
*	Utilizar JSP como Vista 
*	Utilizar JSTL + EL para el despliegue de información
-	Utilizar Servlet como Controladores 
+	Utilizar Clases Java para el Modelo  
+	Control de Excepciones
+	Utilizar el Patrón DAO para el acceso a datos 
+	Utilizar API de Log para registrar la actividad del usuario y excepciones ocurridas en el sistema
+	Pool de conexiones
+	Base de datos a utilizar Mysql
+	Puede opcionalmente utilizar algún framework u otra tecnología vista en clases

## La revisión del programa estará separada en 2 partes, siendo la primera contra entrega. Esto significa que el grupo de estudiantes deberá ejecutar la aplicación y responder a las preguntas que el docente realice, donde el no responder a las preguntas indicará que el estudiante no realizó el programa, siendo evaluado con la nota mínima.

# En la segunda parte, el docente revisará que el programa cumpla con lo solicitado. 
## Problema:

El instituto “Los Especialistas”, han determinado que muchos de sus alumnos abandonan los ramos y en muchos casos, finalmente, la carrera.  Preocupados por esto han decidido acercarse a sus alumnos y averiguar el “por qué” de sus inasistencias, desde manera, mediante una alerta temprana, tratar de apoyar a los alumnos a avanzar en sus ramos y carreras.

En un estudio realizado, se envió correos a 100  alumnos preguntando el por qué de sus inasistencias y este fue el resultado:

### Tabla 1. Problemas de inasistencia
### Problema	Cantidad de alumnos
*       Económicos	15
+       Salud	15
+       Laboral	15
+       Trámites	5
+       No entiendo la materia	10
+       No le entiendo al profesor	10
+       Me quedé dormido	10
+       Problemas familiares varios	5
+       Problema con el transporte	10
+       Actividad extra programática del instituto 	5

    
# Requerimientos Funcionales
+ RF1	Cargar la tabla inasistencias desde un archivo de entrada de datos en Excel.
+ RF2	Login para controlar el ingreso de coordinador, profesor, alumno y director de carrera. (JSP, Servlet, log)
+ RF3	Menú con sistema claro de acceso a acciones según el perfil.  (JSP)
+ RF4	Enviar mails en “lotes”, a todos los alumnos que no tengas cerrado el proceso de “justificación” de inasistencia. (coordinador)
+ RF5	Justificar inasistencias, seleccionado una de las expuestas en la tabla1, Una justificación por cada inasistencia. (alumno)
+ RF6	Una vez justificada la inasistencia debe llegar una notificación (correo) al docente del ramo, así estará en conocimiento sobre      la situación de su alumno.
+ RF7	El docente debe dar un check a la lectura de cada justificación y guardar el estado, de esta manera cierra el ciclo y no será + enviada la inasistencia en un siguiente proceso.
+ RF8	Después de una semana de enviar los mails a los alumnos, se debe hacer un segundo envío, a todos los alumnos que no justificaron.
+ RF9	Revisar la fecha de justificación de los alumnos y si después de 3 días no ha sido cerrado el ciclo se debe reenviar un correo al docente insistiendo que haga el check del estado.
+ RF10	Crear los CRUD correspondientes según la tablas.  (DAO, servlet, Entity)
+ RF11	Reporte de alumnos con inasistencia justificadas, por pantalla. (JSTL )(director de carrera)
+ RF12	Reporte de inasistencias chequeadas por el docente, en PDF. ((JSTL )(director de carrera)
+ RF13	Reporte estadístico según la tabla 1, según los alumnos de un semestre específico.  (JSTL )(director de carrera)
+ RF14	Diseño de estructura de base de datos que dé solución a los requerimientos planteados y su script correspondiente.

# Requerimientos No Funcionales
* RNF1	El sistema debe ser WEB.
- RNF2	IDE de desarrollo NetBeans.
- RNF3	Motor de base de datos MySql
- RNF4	Página principal  y clara navegación entre páginas.
- RNF5	Diseño de páginas con Framework materialize.
- RNF6	Reportes en pantalla y en PDF.
