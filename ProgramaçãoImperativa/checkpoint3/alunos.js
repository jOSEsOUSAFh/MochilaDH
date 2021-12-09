
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




module.exports = Aluno;