let processo = {
    placa: "aaa0000",
    pedido: 14667673,
    produto: "kcl",
    dizerOproduto: function(){
        return `Meu produto é ${this.produto}`
    }
}

console.log(processo)
console.log(processo.pedido) 
console.log(processo.dizerOproduto())

// Function Construtora 

function Processo (vPlaca,vPedido,vProduto) {
this.placa = vPlaca;
this.pedido = vPedido;
this.produto = vProduto;
}

console.log(new Processo("AAA1111","12487644","Can"))