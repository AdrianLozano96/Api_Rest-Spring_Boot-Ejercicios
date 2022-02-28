INSERT INTO LOGIN(id, administrador, correo, contraseña, token)
VALUES(1, true, 'admin@admin.com', 'adminpass', 'admintoken');
INSERT INTO LOGIN(id, administrador, correo, contraseña, token)
VALUES(2, false, 'user@user.com', 'userpass', 'usertoken');

INSERT INTO PROGRAMADOR(id, nombre, salario, programador_login)
VALUES(1, 'progadmin', 1200.0, 1);
INSERT INTO PROGRAMADOR(id, nombre, salario, programador_login)
VALUES(2, 'proguser', 1200.0, 2);

INSERT INTO REPOSITORIO(id, nombre, url)
VALUES(1, 'repositorio 1', 'www.repo1@repo.com');
INSERT INTO REPOSITORIO(id, nombre, url)
VALUES(2, 'repositorio 2', 'www.repo2@repo.com');

INSERT INTO PROYECTO(id, descripcion, fecha, nombre, programador_id, repositorio_id)
VALUES(1, 'primer proyecto', CURRENT_TIMESTAMP, 'proyecto 1', 1, 1);
INSERT INTO PROYECTO(id, descripcion, fecha, nombre, programador_id, repositorio_id)
VALUES(2, 'segundo proyecto', CURRENT_TIMESTAMP, 'proyecto 2', 2, 2);