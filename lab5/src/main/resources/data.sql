INSERT INTO user (id, email, password)
VALUES (1, 'cyrus', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO user (id, email, password)
VALUES (2, 'harry', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CLIENT');

INSERT INTO user_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, roles_id)
VALUES (2, 2);