INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(1,'programador1', 'prog1', 'programador@prog.com', 'avatar1');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(2,'programador2', 'prog2', 'programador@prog.com', 'avatar2');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(3,'programador3', 'prog3', 'programador@prog.com', 'avatar3');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(4,'programador4', 'prog4', 'programador@prog.com', 'avatar4');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(5,'programador5', 'prog5', 'programador@prog.com', 'avatar5');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(6,'programador6', 'prog6', 'programador@prog.com', 'avatar6');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(7,'programador7', 'prog7', 'programador@prog.com', 'avatar7');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(8,'programador8', 'prog8', 'programador@prog.com', 'avatar8');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(9,'programador9', 'prog9', 'programador@prog.com', 'avatar9');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(10,'programador10', 'prog10', 'programador@prog.com', 'avatar10');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(11,'programador11', 'prog11', 'programador@prog.com', 'avatar11');
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar)
VALUES(12,'programador12', 'prog12', 'programador@prog.com', 'avatar12');

INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(1, 'proyecto1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(2, 'proyecto2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(3, 'proyecto3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(4, 'proyecto4', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 4, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(5, 'proyecto5', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 5, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(6, 'proyecto6', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 6, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(7, 'proyecto7', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 7, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(8, 'proyecto8', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 8, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(9, 'proyecto9', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 9, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(10, 'proyecto10', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 10, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(11, 'proyecto11', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 11, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, programador, coste)
VALUES(12, 'proyecto12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 12, 0.0);

INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(1,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 1, 1);
INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(2,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 2, 2);
INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(3,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 1, 1);
INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(4,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 3, 4);
INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(5,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 4, 5);