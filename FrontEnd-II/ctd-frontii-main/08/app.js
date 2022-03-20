
// Seleção do elemento
var documento = document.body;
var item = document.querySelector("#elemento");

// 1. Eventos do mouse...

// 1.1. Click
item.addEventListener("click", function(evento) {
    // item.innerText = "Click";
    evento.target.innerText = "Click";
});

// 1.2. Doble click
item.addEventListener("dblclick", function(evento) {
    // item.innerText = "Duplo Click";
    evento.target.innerText = "Duplo Click";
});

// 1.3. Mouse over
item.addEventListener("mouseover", function(evento) {
    evento.target.style.backgroundColor = "black";
});

// 1.4. Mouse out
function mudarCorDeFundo(evento) {
    evento.target.style.backgroundColor = "orangered";
}

item.addEventListener("mouseout", mudarCorDeFundo);

// ---------------------------------------------------

// 2. Eventos do teclado...

// 2.1. Key Down - É pressionada
documento.addEventListener("keydown", function(evento) {
    item.innerText = "Key Down";
    console.log(evento.code);
});

// 2.2. Key Press - Está pressionada...
documento.addEventListener("keypress", function(evento) {
    item.innerText = "Key Press";
    console.log(evento.code);
});

// 2.1. Key Up...
documento.addEventListener("keyup", function(evento) {
    item.innerText = "Key Up";
    console.log(evento.code);
});
