
// 1. Seleção do formulário
var formulario = document.getElementById('formularioDeCadastro');

// 2. Selação do campo
var campoTelefone = document.getElementById('telefone');

// 3. Captura o evento de envio do formulário e disparar a rotina

formulario.addEventListener('submit', function() {
    
    var valorDoCampoTelefoneSemTratamento = campoTelefone.value;

    // \s = espaços
    // \D = para números
    var valorDoCampoTelefoneSemEspacos = valorDoCampoTelefoneSemTratamento
    .replace(/\s/g, '');

    var valorDoCampoTelefoneSemCaracteres = valorDoCampoTelefoneSemEspacos
    .replace(/\D/g, '');

    var textoMinusculo = valorDoCampoTelefoneSemTratamento.toLowerCase();
    var textoMaiusculo = valorDoCampoTelefoneSemTratamento.toUpperCase();

    // 3.1. Capturando os dados do formulário
    // alert(`Valor sem tratamento: ${valorDoCampoTelefoneSemTratamento}`);
    alert(`Valor tratamento: ${valorDoCampoTelefoneSemTratamento}`);

    alert(`Valor tratado ${valorDoCampoTelefoneSemCaracteres}`);

});