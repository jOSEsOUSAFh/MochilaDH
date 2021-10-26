CREATE DATABASE LivrariaABC;
USE LivrariaABC;  # Criou o BD e o selecionou 

CREATE TABLE telefones (
telefoneid INT NOT NULL PRIMARY KEY,
telefone VARCHAR(100),
codAssoc INT

);

CREATE TABLE associados (
codid INT NOT NULL PRIMARY KEY,
rg CHAR(7),
nome VARCHAR(50),
sobrenome VARCHAR(50),
endereço VARCHAR(100)
);

ALTER TABLE telefones ADD CONSTRAINT fk_assoc
FOREIGN KEY (codAssoc) REFERENCES associados(codid);

CREATE TABLE emprestimos (
codigo INT NOT NULL PRIMARY KEY,
codAssoc INT, 
datas DATE,
prazo_dev DATE,
data_dev DATE,

FOREIGN KEY (codAssoc) REFERENCES associados(codid)
);

CREATE TABLE emprestimo_exemplares(
codigo INT NOT NULL PRIMARY KEY,
cod_emprestimo INT,
cod_exemplar INT,

FOREIGN KEY (cod_emprestimo) REFERENCES emprestimos(codigo) 
);

CREATE TABLE AUTORES (
codigo INT NOT NULL PRIMARY KEY,
nome VARCHAR(100),
sobrenome VARCHAR(100)
);

CREATE TABLE EDITORAS (
codigo INT NOT NULL PRIMARY KEY,
razao_social VARCHAR(100),
telefone VARCHAR(100)
);

CREATE TABLE livros (
codigo INT NOT NULL PRIMARY KEY,
cod_ISBN VARCHAR(13),
titulo VARCHAR(200),
ano_criacao DATE,
cod_autor INT,
ano_publi DATE,
cod_editora INT, 

FOREIGN KEY (cod_autor) REFERENCES autores(codigo),
FOREIGN KEY (cod_editora) REFERENCES editoras(codigo) # Criou uma tabela com duas FK
);

CREATE TABLE exemplares(
codigo INT NOT NULL PRIMARY KEY,
cod_livro INT,
sinistro CHAR(1),

FOREIGN KEY (cod_livro) REFERENCES livros(codigo)
);

ALTER TABLE emprestimo_exemplares ADD CONSTRAINT FK_cod_ex
FOREIGN KEY (cod_exemplar) REFERENCES exemplares(CODIGO); #adc FK em uma tabela já existente


INSERT INTO editoras (codigo, razao_social, telefone)
VALUES (3, "INFANTIL", "71997200967"); # inseriu dados na tabela editoras

INSERT INTO autores (codigo, nome, sobrenome)
VALUES (3, "SOUSA", "71997200967"); # inseriu dados na tabela autores

INSERT INTO livros (codigo, cod_ISBN, titulo, ano_criacao, cod_autor, ano_publi, cod_editora)
VALUES (343, "OIE4I9H", "CREPUSCOLO", "10/09/1", 2, "2002/09/12", 2); # Inseriu dados na tabela livros

UPDATE livros SET titulo = "Crepusculo" WHERE codigo = 343; # Modificou o nome para Crepusculo onde o codigo é 343

DELETE FROM autores WHERE codigo = 3; # Deleta o autor com codigo = 3

SELECT * FROM livros; #Seleciona a tabela livros








