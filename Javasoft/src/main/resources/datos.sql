INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(1, 'proyecto1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(2, 'proyecto2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(3, 'proyecto3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(4, 'proyecto4', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(5, 'proyecto5', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(6, 'proyecto6', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(7, 'proyecto7', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(8, 'proyecto8', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(9, 'proyecto9', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(10, 'proyecto10', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(11, 'proyecto11', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);
INSERT INTO PROYECTO(id, nombre, fecha_inicio, fecha_fin, coste)
VALUES(12, 'proyecto12', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0.0);

INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar, proyecto)
VALUES(1,'programador1', 'prog1', 'programador@prog.com', 'avatar1', 1);
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar, proyecto)
VALUES(2,'programador2', 'prog2', 'programador@prog.com', 'avatar2', 2);
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar, proyecto)
VALUES(3,'programador3', 'prog3', 'programador@prog.com', 'avatar3', 3);
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar, proyecto)
VALUES(4,'programador4', 'prog4', 'programador@prog.com', 'avatar4', 4);
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar, proyecto)
VALUES(5,'programador5', 'prog5', 'programador@prog.com', 'avatar5', 5);
INSERT INTO PROGRAMADOR(id, nombre, username, correo, avatar, proyecto)
VALUES(6,'programador6', 'prog6', 'programador@prog.com', 'avatar6', 6);
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

INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(1,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 1, 1);
INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(2,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 2, 2);
INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(3,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 1, 3);
INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(4,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 3, 4);
INSERT INTO TAREA(id, fecha_inicio, fecha_fin, coste, programador, proyecto)
VALUES(5,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 80.0, 4, 5);