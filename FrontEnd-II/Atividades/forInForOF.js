var pessoa = {
    nome: "José",
    idade: "24"
}

for(let infor in pessoa){
console.log(infor, pessoa[infor])
} // para objetos


var artistas = ['jose', 'maria','joao','paulo']

for (let artista of artistas) {
    console.log(`Nome:${artista}`)
} // para arrays
