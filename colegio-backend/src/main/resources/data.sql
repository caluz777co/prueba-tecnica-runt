--INSERT COLEGIO 
INSERT INTO colegio (id, nombre) 
VALUES 
  (1, 'El colegio del Olimpo');
--INSERT PROFESORES 
INSERT INTO profesor (id, nombre) 
VALUES 
  (1, 'Némesis');
INSERT INTO profesor (id, nombre) 
VALUES 
  (2, 'Príapo');
INSERT INTO profesor (id, nombre) 
VALUES 
  (3, 'Iris');
--INSERT ESTUDIANTES 
INSERT INTO estudiante (id, nombre) 
VALUES 
  (1, 'Afrodita');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (2, 'Apolo');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (3, 'Ares');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (4, 'Artemisa');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (5, 'Atenea');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (6, 'Dionisio');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (7, 'Hefesto');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (8, 'Hera');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (9, 'Hermes');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (10, 'Hades');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (11, 'Poseidón');
INSERT INTO estudiante (id, nombre) 
VALUES 
  (12, 'Zeus');
--INSERT CURSOS 
INSERT INTO curso (id, grado, salon, colegio_id) 
VALUES 
  (1, '10', 'A', 1);
INSERT INTO curso (id, grado, salon, colegio_id) 
VALUES 
  (2, '10', 'B', 1);
INSERT INTO curso (id, grado, salon, colegio_id) 
VALUES 
  (3, '11', 'A', 1);
INSERT INTO curso (id, grado, salon, colegio_id) 
VALUES 
  (4, '11', 'B', 1);
--INSERT ASIGNATURAS 
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (1, 'Matemáticas', 1, 1);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (2, 'Matemáticas', 2, 1);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (3, 'Matemáticas', 3, 1);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (4, 'Matemáticas', 4, 1);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (5, 'Español', 1, 2);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (6, 'Español', 2, 2);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (7, 'Ingles básico', 1, 3);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (8, 'Ingles avanzado', 2, 3);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (9, 'Pre Icfes', 3, 1);
INSERT INTO asignatura (id, nombre, curso_id, profesor_id) 
VALUES 
  (10, 'Pre Icfes', 4, 1);
--INSERT ESTUDIANTE_ASIGNATRUA 
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (1, 1);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (2, 1);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (3, 1);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (1, 5);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (2, 5);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (3, 5);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (1, 7);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (2, 7);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (3, 7);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (4, 2);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (5, 2);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (6, 2);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (4, 6);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (5, 6);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (6, 6);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (4, 8);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (5, 8);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (6, 8);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (7, 3);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (8, 3);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (7, 9);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (8, 9);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (9, 4);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (10, 4);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (11, 4);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (12, 4);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (9, 10);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (10, 10);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (11, 10);
INSERT INTO estudiante_asignatura (estudiante_id, asignatura_id) 
VALUES 
  (12, 10);

