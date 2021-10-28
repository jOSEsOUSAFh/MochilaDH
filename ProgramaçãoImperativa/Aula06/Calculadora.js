console.log ("-------------- Teste de Operações / Calculadora --------------")

const soma = (ValorA, ValorB) => ValorA + ValorB
console.log(`O valor da soma de 3 e 5 é ${soma(3,5)}`)

const subtração = (ValorA, ValorB) => ValorA - ValorB
console.log(`O valor da subtração de 3 e 5 é ${subtração(3,5)}`)

const multiplica = (ValorA, ValorB) => ValorA * ValorB
console.log(multiplica(3,5))

const Divisão = (ValorA, ValorB) => ValorA / ValorB
console.log(Divisão(3,5))

const Divpor0 = (ValorA) =>  0 / ValorA
console.log(Divpor0(3))

const quadradoDoNumero = ValorA => multiplica(ValorA,ValorA) * multiplica(ValorA,ValorA);
console.log(quadradoDoNumero(2))