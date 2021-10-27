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

// Arrowfunction


const soma = (valorA, valorB) => valorA + valorB;
console.log(soma(4,5))


const idadedog = (idadeD) => idadeD * 7;

console.log(idadedog(3))


const sayHello = nome => `Seja bem vindo ${nome}`

console.log(sayHello('José'))

