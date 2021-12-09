const aluno ={
    nome :'',
    faltas: 0,
    notas: [],
    listaDeEstudantes: [],

ConstrutorAluno: function(nome,qtdFaltas,notas){
    this.nome = nome;
    this.qtdFaltas = qtdFaltas;
    this.notas = notas;

},

media : function(){
    let soma = 0 
    let qtdNotas = this.notas.length
    for(let i in this.notas){
        soma += this.notas[i]
    }
    return soma / qtdNotas

},

faltas : function(){
    this.qtdFaltas++
}

}

const teste =  new aluno.ConstrutorAluno('teste',1,[9,9,9,9])

// console.log(teste.media())

// module.exports = aluno