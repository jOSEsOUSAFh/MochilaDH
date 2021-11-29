const fs = require("fs"); // Importa o modulo nativo "fs" que ler um arquivo externo
const moment = require("moment") // Importa o modulo da pasta module. Não precisa do diretorio


let dados = fs.readFileSync(__dirname+'/dados.txt', 'utf-8'); // dirname completa o diretorio da pasta
let data = moment().format('MMM do YY')

console.log(data);

