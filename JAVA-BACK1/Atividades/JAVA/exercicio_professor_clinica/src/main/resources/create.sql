
create table IF NOT EXISTS enderecos(id int auto_increment primary key,rua varchar(255),numero varchar (255),bairro varchar (255),cidade varchar (255));
create table IF NOT EXISTS pacientes(id int auto_increment primary key,nome varchar(255),sobrenome varchar (255),cpf varchar (255),data TIMESTAMP WITHOUT TIME ZONE,domicilio_id int);
create table IF NOT EXISTS dentistas(id int auto_increment primary key,nome varchar(255),sobrenome varchar (255),matricula int);
