    let produtos = ["camisa" , "calça", "meia", "bermuda"];
    
    console.log(produtos)
    console.log(produtos.length) // Retorna o comprimento do array

    let separadosPorTraco = produtos.join("-") // Retorna o array separado por oq tiver entre parenteses

    console.log(separadosPorTraco)

    let ultimaCor = produtos.pop() // Retorna a ultima cor e a retira do array
    console.log(produtos)
    console.log(ultimaCor) 

    produtos.push("Cueca") // Adiciona na ultima posição
    console.log(produtos)

    let primeiraCor =  produtos.shift() // Elimina o primeiro elemento do array e retorna o produto eliminado 
    console.log(produtos)
    console.log(primeiraCor)

    produtos.unshift("Chapeu") // Adc um elemento no inicio do arrei
    console.log(produtos)