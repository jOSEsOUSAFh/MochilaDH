const Aluno = require('./alunos');
const Curso = require('./curso');
const curso = require('./curso');

const Cruz = new Aluno('Cruz',2,[10,10,10,10]);
// Cruz.faltas();
curso.adcAlunos(Cruz)

const listaDeAlunos = curso.listaDeAlunos
console.log(`---------------------------${Curso.nomeDoCurso}--------------------------------------------`)
listaDeAlunos.forEach((alunos) => {
    console.log(`Certified Tech Developer`)
    console.log(`Nome: ${alunos.nome}`)
    console.log(`Média: ${alunos.media()}`)
    console.log(`Quantidade de falta: ${alunos.faltas()}`)
    console.log(`Status: ${curso.AprovadoNaMateria(alunos)}`)
    console.log("---------------------------------------------------------------------------------------")

});

