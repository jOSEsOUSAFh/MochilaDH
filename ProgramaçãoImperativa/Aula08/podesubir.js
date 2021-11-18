const podesubir = (altura,vaiAcompanhado) => {
    let podesubir = false

    if(altura<= 2.0 && altura >=1.20){
        podesubir = "Pode subir"
    }if(altura>=1.20 && vaiAcompanhado){
        podesubir = "Vai acompanhado"
    }else{
        podesubir = 'não pode subir'
    } return podesubir
}


console.log(podesubir(1.50))