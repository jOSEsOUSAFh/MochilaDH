function tempoPrato(prato){
    if(prato == "Pipoca"){
     return 10
    }if(prato == "Macarrão"){
        return 8
    }if(prato == "Carne"){
        return 15
    }if(prato == "Feijão"){
        return 12
    }if(prato == "Brigadeiro"){
        return 8
    }else{ 
        return 0
    }
} 


function microondas(prato,tempo){
    if((prato == "Pipoca" 
    || prato == "Macarrão" 
    || prato == "Carne"
    || prato == "Feijão"
    || prato == "Brigadeiro" ) 
    && (tempo >= tempoPrato(prato)
        && tempo < tempoPrato(prato) * 2)){
        return "O prato está pronto"
    }else if ((
        prato == "Pipoca" 
    || prato == "Macarrão"
    || prato == "Carne"
    || prato == "Feijão"
    || prato == "Brigadeiro") && (tempo >= tempoPrato(prato) * 2) && (tempo<= tempoPrato(prato) * 3)) {
        return "O prato queimou"
    } else if((prato == "Pipoca" 
    || prato == "Macarrão"
    || prato == "Carne"
    || prato == "Feijão"
    || prato == "Brigadeiro") &&(tempo >= tempoPrato(prato) * 3) ) {
     return   "Kabummmmm"
    }else if((prato == "Pipoca" 
    || prato == "Macarrão"
    || prato == "Carne"
    || prato == "Feijão"
    || prato == "Brigadeiro") && tempo < tempoPrato(prato)){
        return "Tempo Insuficiente"
    }else{
        return "Prato inexistente"

    }

}
console.log("Prato pronto, bom apetite!!")


 //console.log(microondas("Feijão",15))
// O prato precisa ser enserido em string!!!!