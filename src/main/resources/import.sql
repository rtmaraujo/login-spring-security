insert into usuario (id, nome, login, senha) values (null, 'Joao Carlos', 'joaocarlos', '$2a$10$DXFQP9lLyISn0XEKvaFVrO2wEVwBvmXnOQsmm4krdcq60lw7IuOp2');
insert into usuario (id, nome, login, senha) values (null, 'Maria Silva', 'mariasilva', '$2a$10$.4udYmV4xk8oaN4fuoX68e22NIhkMwvsB7LcBGAGKwoo.ieuggwhO');

insert into role(id, nome_role) values(null, 'ROLE_ADMIN');
insert into role(id, nome_role) values(null, 'ROLE_USER');

insert into usuarios_roles(usuario_id, role_id) values (1L, 1L);
insert into usuarios_roles(usuario_id, role_id) values (2L, 2L);

insert into cliente (id, nome, idade) values (null, 'Carlos Eduardo', 23);
insert into cliente (id, nome, idade) values (null, 'Roberto Silva', 28);
insert into cliente (id, nome, idade) values (null, 'Joaquim Silva', 55);

insert into carro (id, nome_modelo, ano) values (null, 'Uno Fiat', 2010);
insert into carro (id, nome_modelo, ano) values (null, 'Onix Chevrolet', 2015);
insert into carro (id, nome_modelo, ano) values (null, 'Gol Volkswagen', 2011);