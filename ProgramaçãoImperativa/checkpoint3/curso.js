const Aluno = require('./alunos');
const listaDeAlunos = require('./listaDeEstudantes'); 



const Curso = { 
    nomeDoCurso: 'DigitalHouse',
    notaAprovacao: 6,
    faltasMax: 3,
    listaDeAlunos: listaDeAlunos,
    adcAlunos: function(Aluno){
        const listaDeEstudantes = this.listaDeAlunos;
        const todosMatriculados = []; 
        listaDeEstudantes.forEach(function(veteranos){
            todosMatriculados.push(veteranos)
        }
        );
        todosMatriculados.push(Aluno)
        this.listaDeAlunos = todosMatriculados;
        return todosMatriculados;
    },
    AprovadoNaMateria: function(Aluno){
        if (Aluno.media() >= this.notaAprovacao && Aluno.qtdFaltas < this.faltasMax) {
                return "Aprovado"
        }else if (
            (Aluno.media() >= this.notaAprovacao * 1.1) && Aluno.qtdFaltas === this.faltasMax ) {
            return "Aprovado"
        } else{
            return "Reprovado"
        }
    },

    listaAprovados: function(){
        const estudantes = this.listaDeAlunos
        const listaAprovados = []
        estudantes.forEach(function(alunos){if(Curso.AprovadoNaMateria(alunos) == 'Aprovado'){
        listaAprovados.push(Curso.AprovadoNaMateria(alunos))}
        })
        return listaAprovados
    }
}



module.exports = Curso