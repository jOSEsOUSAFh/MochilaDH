const Aluno = require('./alunos');


listaDeAlunos = []


const Jose = new Aluno('José',2,[8,9,9,9]);

const Almir = new Aluno('Almir',1,[10,10,10,3]);

const Sousa = new Aluno('Sousa',7,[10,3,4,3]);


listaDeAlunos.push(Jose,Almir,Sousa);   


module.exports = listaDeAlunos

