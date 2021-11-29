let objetoLiteral = {
    nome: "José",
    pais: "Brasil"
} // Objeto literal

let dadosConvertidos = JSON.stringify(objetoLiteral); // Converte o objeto em formato JSON

console.log(objetoLiteral)
console.log(dadosConvertidos)


let dadosNovamenteConcertidos =JSON.parse(dadosConvertidos) // Converte o JSON em objeto literal

console.log(dadosNovamenteConcertidos)