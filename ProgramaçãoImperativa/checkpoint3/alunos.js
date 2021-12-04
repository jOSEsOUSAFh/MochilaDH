function Aluno(nome,qtdFaltas,notas){
    this.nome = nome;
    this.qtdFaltas = qtdFaltas;
    this.notas = notas;

}

Aluno.prototype.media = function(){
    let soma = 0 
    let qtdNotas = this.notas.length
    for(let i in this.notas){
        soma += this.notas[i]
    }
    return soma / qtdNotas

}

Aluno.prototype.faltas = function(){
        this.qtdFaltas
    return this.qtdFaltas++
}




listaDeAlunos = []
const Jose = new Aluno('José',2,[8,9,9,9]);
Jose.faltas();

const Almir = new Aluno('Almir',1,[10,3,4,3])
Almir.faltas();
listaDeAlunos.push(Jose);




module.exports = listaDeAlunos;

