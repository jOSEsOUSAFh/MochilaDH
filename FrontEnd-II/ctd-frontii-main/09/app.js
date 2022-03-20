
const abrirSideBar = () => {
    document.getElementById('sideBar').classList.toggle('l-sidebar--open')
} // função para abrir o "sidebar"

const fecharSideBar = ()=>{
    document.getElementById('sideBar').classList.toggle('l-sidebar--open')
}



const dbCsideBar = () => {
    document.getElementById('sideBar').classList.toggle('l-sidebar--open')
} // função para abrir o "sidebar" com duplo click


document.body.addEventListener('mousemove', function(e){// seleciona todo o body, e quando o evento mover do mouse for percebido, executa a função anonima
   // a função:
    var balao = document.createElement("nav") // cria uma section
    balaoTexto = document.createTextNode("Bem vindo") // cria um texto
    balao.appendChild(balaoTexto) // adiciona o texto na section
    balao.classList.add('balao') // adiciona uma class na section
    balao.id = 'texto' // adiciona um id
    document.body.appendChild(balao) // adiciona a section ao html
    document.getElementById('texto').style.left = e.offsetX + 'px';
    document.getElementById('texto').style.top = e.offsetY + 'px';
    // faz a section seguir o mouse
}) 


document.getElementById('sobremim').addEventListener('mouseout', function(){
    document.getElementById('texto').innerText = "Bem vindo"
}) // Seleciona um elemento com um ID. Qd esse elemento percebe o evento OVER do mouse, executa a função anonima
//A função seleciona um elemento pelo id e insere um texto nele

document.getElementById('sobremim').addEventListener('mouseover', function(){
    document.getElementById('texto').innerText = "Sobre mim"
}) // Seleciona um elemento com um ID. Qd esse elemento percebe o evento OVER do mouse, executa a função anonima
//A função seleciona um elemento pelo id e insere um texto nele

document.getElementById('contatos').addEventListener('mouseover', function(){
    document.getElementById('texto').innerText = "Contatos"
})// Seleciona um elemento com um ID. Qd esse elemento percebe o evento OVER do mouse, executa a função anonima
//A função seleciona um elemento pelo id e insere um texto nele

document.body.addEventListener("keydown", function(evento) { 
    if (evento.code == 'Space') {
        document.getElementById('sideBar').classList.toggle('l-sidebar--open')
    }
    // Quando o evendo do teclado é percebido e ele é igual a SPACE(Tecla spaço) seleciona um elemento pelo id
    // e adiciona uma class nele
});



document.body.addEventListener('dblclick', dbCsideBar)
// Seleciona um elemento que qd perceber um evento vai executar a função



document.getElementById('btnSidebar').addEventListener('click', abrirSideBar)
// Seleciona um elemento que qd perceber um evento vai executar a função

document.getElementById('fecharSide').addEventListener('click', fecharSideBar)