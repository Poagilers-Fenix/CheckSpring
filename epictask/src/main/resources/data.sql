CREATE TABLE task (
id bigint PRIMARY KEY auto_increment,
title varchar(200),
description TEXT,
points int
);


INSERT INTO task (title, description, points) VALUES
('Criar banco de dados',
'Criar um banco de dados na nuvem com Oracle',
200);

INSERT INTO task (title, description, points) VALUES
('Protótipo','Criação de protótipo de alta fidelidade', 100);
INSERT INTO task (title, description, points) VALUES
('API REST','Publicação de API com endpoints da aplicação', 150);



CREATE TABLE User (
id bigint PRIMARY KEY auto_increment,
name varchar(40),
email varchar(50),
pass varchar(20),
score int
);

INSERT INTO User (name, email, pass, score) VALUES
('Lari', 'lari@gmail.com', '12345', 0);

INSERT INTO User (name, email, pass, score) VALUES
('Gi', 'gi@gmail.com', '12345', 0);

INSERT INTO User (name, email, pass, score) VALUES
('Kaue', 'kaue@gmail.com', '12345', 100);

INSERT INTO User (name, email, pass, score) VALUES
('Dan', 'dan@gmail.com', '12345', 300);

INSERT INTO User (name, email, pass, score) VALUES
('Henrique', 'henrique@gmail.com', '12345', 100);

INSERT INTO User (name, email, pass, score) VALUES
('eric', 'eric@gmail.com', '12345', 150);







