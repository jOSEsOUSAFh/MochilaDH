var documento = document.body;

console.log(documento);

// 1. Criar o elemento que desejos adicionar aoAcnoss DOM
var botao = document.createElement("button");

// 2. Criamos o texto que iremos adicionar ao elemento
var botaoTexto = document.createTextNode("Abrir alerta");

// 3. Adicionamos o texto ao elemento como um nó de texto
botao.appendChild(botaoTexto);

// 4. Adicionamos o elemento que contém um nó de texto no DOM
documento.appendChild(botao);

// 5. Adicionamos atributo(s) e valores ao elemento
// Neste exemplo adicionaremos uma url de destino
//botao.setAttribute("href", "https://www.google.com");

// 6. Podemos aproveitar e adicionar uma classe para estilizar o elemento
botao.classList.add("botao");

// Observações:

// -> documento.innerHTML = "<h1>Manipulando o DOM</h1>";

// 7. Define qual tarefa você deseja realizar

// Funções = Rotina
function criarUmAlerta() {
    alert("Você clicou aqui...");
}

var criarUmAlerta = function() {
    alert("Você clicou aqui...");
}

// Método = Acionar/Chamar
// criarUmAlerta();

// 8. Capturar um evento específico do elemento e executa a tarefa
botao.addEventListener("click", criarUmAlerta);

// ----

var botaoRedirecionarPara = document.querySelector("#enviarPara");

// Função anônima
botaoRedirecionarPara.addEventListener("click", function() {
    window.location.replace("https://www.google.com.br");
});

// Função anônima + arrow function
botaoRedirecionarPara.addEventListener("click", () => window.location.replace("https://www.google.com.br"));