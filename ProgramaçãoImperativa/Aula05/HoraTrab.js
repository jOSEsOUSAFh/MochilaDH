function horatrab(salario){
const total = salario / 160

console.log(total)
return `$ ${total.toFixed(2).replace(`.`,`,`)}`
}

console.log(horatrab(1800))