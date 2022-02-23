var identificarUsuario = prompt("Olá, digite seu nome completo")
// a variavel recebe um prompt que pergunta o nome do usuario!



if (identificarUsuario == "") {
  var confirmNome = confirm("É obrigatorio preencher seu nome! Deseja continuar?") 
  // Se a variavel identificarUsuario estiver vazia, abrirar um confirm
    if (confirmNome === true) {
        var identificarUsuario = prompt("Olá, digite seu nome completo")
    }
    // Se o confirm for true, abri novamente o prompt perguntando o nome do usuario
  }

  while (identificarUsuario == "") {
    var confirmNome = confirm("É obrigatorio preencher seu nome! Deseja continuar?")
    var identificarUsuario = prompt("Olá, digite seu nome completo")
} // Enquanto identificarUsuario estiver vazia, abrirar o confirm e o prompt




    if (identificarUsuario != "") {
        var numeroDoUsuario = prompt("Informe seu numero do telefone!")
    } // Se identificarUsuario receber um valor, abrirar outro prompt perguntando o numero
    
    if(numeroDoUsuario == "") {
        var numeroDoUsuario = prompt("É obrigatorio informar o numero do telefone!")
    } //Se numeroDoUsuario estiver vazio, abrirar novamente um prompt

    while (numeroDoUsuario == "") {
        var confirmNumero = confirm("É obrigatorio preencher seu numero! Deseja continuar?")
        if (confirmNumero == true) {
            var numeroDoUsuario = prompt("É obrigatorio informar o numero do telefone!")
        }// Enquanto numeroDoUsuario estiver vazio abrirar o confirm e o prompt
        
    }


    if ((numeroDoUsuario  != "" && identificarUsuario != "")){
        var tellWpp = confirm("O numero é WhatsApp?")
    } // Se receber valores nos dois prompts, perguntarar se o numero é wts

    if ((numeroDoUsuario  != "" && identificarUsuario != "")) {
        var msg = alert(`Muito obrigado ${identificarUsuario}, um de nossos consultores entrará em contato contigo através do número ${numeroDoUsuario}`)
        console.log(`Nome:${identificarUsuario} Telefone:${numeroDoUsuario} WhatsApp:${tellWpp}`)
    } // Se os prompts receberem valores após o confirm aparecerar um alert !

