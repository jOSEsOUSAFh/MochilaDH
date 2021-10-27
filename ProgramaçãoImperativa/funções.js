//função declarada

function DarOi(){
    console.log("Olá MUNDO")
}

DarOi();

// funções expressa

let somar = function(){
    console.log(2+3)
};

somar();

// aerofunction

const exibir = () => {
    const total = soma(5, 10);
    console.log(total);
}

const soma = (valorA, valorB) => valorA + valorB;

const objeto = {
    nome: 'Rodrigo',
    sobrenome: 'Sarri',
    nomeCompleto: function() {
        return `Nome completo: ${this.nome} ${this.sobrenome}`
    }
}

exibir();