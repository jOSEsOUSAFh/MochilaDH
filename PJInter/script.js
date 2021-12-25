// const carros = document.querySelectorAll(".Carro");
// const todoStatus = document.querySelectorAll(".Status");
// let draggableCarro = null;

// carros.forEach((Carro)=>{
//     Carro.addEventListener("dragstart", dragStart)
//     Carro.addEventListener("dragend", dragEnd) 
// });

// function dragStart(){
//     draggableCarro = this
//     // draggableCarro.classList.add('dragging')
//     setTimeout(()=>{
//         this.style.display = "none"
//     }, 0);
    
// };

// function dragEnd(){
//     draggableCarro = null;
//     setTimeout(()=>{
//         this.style.display = "block"
//     }, 0);
//     // console.log('dragEnd')
// };

// todoStatus.forEach((Status)=>{
//     Status.addEventListener("dragover", dragOver);
//     Status.addEventListener("dragenter", dragEnter);
//     Status.addEventListener("dragleave", dragLeave);
//     Status.addEventListener("drop", dragDrop);
// });



// function dragOver(sobre){
//     sobre.preventDefault();
//     // console.log("dragOver")
// };

// function dragEnter(){
//     this.style.border = "none"
//     // console.log("dragEnter")
// };

// function dragLeave(){
//     this.style.border = "none"
//     // console.log("dragLeave")
// };

// function dragDrop(){
//     this.style.border = "none"
//     this.appendChild(draggableCarro)
//     // console.log("dragDrop")
// }



// Modal

const btns = document.querySelectorAll("[data-target-modal]");
const fecharModal = document.querySelectorAll(".btnFecharModal");

btns.forEach((btn)=>{
    btn.addEventListener("click", ()=>{
        document.querySelector(btn.dataset.targetModal).classList.add("active");
    });
});

fecharModal.forEach((btn)=>{
    btn.addEventListener("click", ()=>{
        const modal = btn.closest(".modal");
        modal.classList.remove("active");
        limparCampo()
    });
});


const elementTemp = {
    Placa : 'AAA0002',
    Material: "KCL2",
    Quantidade: 50,
    OrdemProd: 2
}

const getLocalStorage = () => JSON.parse(localStorage.getItem("ID")) ?? []
const setLocalStorage = (dbElement) => localStorage.setItem("ID", JSON.stringify(dbElement))
// CRUD 

const readElement = () => getLocalStorage()

const createElement = (elemento)=>{
   const dbElement =  getLocalStorage()
   dbElement.push (elemento)
   setLocalStorage(dbElement)
};



const updadeElement = (index, elemento)=> {
    const  dbElement = readElement()
    dbElement[index] = elemento
    setLocalStorage(dbElement)
}

const deleteElement = (index) =>{
    const dbElement = readElement()
    dbElement.splice(index,1)
    setLocalStorage(dbElement)
}

const valido = () =>{
    return document.getElementById('form').reportValidity()
}


// interação

const salvarElemento = () =>{
    if(valido()){
        const elemento = {
            Placa : document.getElementById('placa').value,
            Material: document.getElementById('material').value,
            Quantidade: document.getElementById('quantidade').value,
            OrdemProd: document.getElementById('ordem').value
        }
        const index = document.getElementById('placa').dataset.index
        if(index == 'new'){
            createElement(elemento)
            CloseModal()
            limparCampo()
            updadeTabela()
        }else{
            updadeElement(index,elemento)
            CloseModal()
            limparCampo()
            updadeTabela()
            
        }


    } 
}
document.getElementById('salvar').addEventListener('click', salvarElemento)

const CloseModal = ()=>{
    const modals = document.querySelectorAll('.modal')
        modals.forEach(modal => modal.classList.remove('active'))
}

const OpenModal = ()=>{
    const modals = document.querySelectorAll('.modal')
        modals.forEach(modal => modal.classList.add('active'))
}

const limparCampo = ()=>{
    const campos = document.querySelectorAll('.modal-field')
    campos.forEach(campo => campo.value = "")
}


// criar elemento no html

const limparTabela = () =>{
    const tabelas = document.querySelectorAll('#Status1 .Carro')
    tabelas.forEach(tabela=> tabela.parentNode.removeChild(tabela))
}

const updadeTabela = () =>{
    const dbElement = readElement()
    limparTabela()
    dbElement.forEach(createCarro)
}


const createCarro = (Carro, index) =>{
    const newCarro = document.createElement('div')
    newCarro.innerHTML = `
    <div class="Carro">
    <h1 class="h1Drag">${Carro.Placa}</h1>
    <ul>
     <li>${Carro.Material}</li>
     <li>${Carro.Quantidade}</li>
     <li>${Carro.OrdemProd}</li>
    </ul>
    <button class="button green" id="edit-${index}">Editar</button>
    <button  class="button green" id="delete-${index}">\u00D7</button>
     </div>
     `
     document.querySelector('#Status1').appendChild(newCarro)
     
}

updadeTabela()


const editarCampos = (Carro) =>{
    document.getElementById('placa').value = Carro.Placa
    document.getElementById('material').value = Carro.Material
    document.getElementById('quantidade').value = Carro.Quantidade
    document.getElementById('ordem').value = Carro.OrdemProd
    document.getElementById('placa').dataset.index = Carro.index
}

const editCarro = (index) =>{
    const carro = readElement()[index]
    carro.index = index
    editarCampos(carro)
    OpenModal()
}

const editDelet = (event) =>{
    if(event.target.type == 'submit'){
        const [action, index] = event.target.id.split('-')

        if(action == 'edit'){
            editCarro(index)
        }else{
            deleteElement(index)
            updadeTabela()
        }
    }
}

document.querySelector('#Status1').addEventListener('click', editDelet)
// document.querySelector('#Status2').addEventListener('click', editDelet)
// document.querySelector('#Status3').addEventListener('click', editDelet)
// document.querySelector('#Status4').addEventListener('click', editDelet)






const fecharBtns = document.querySelectorAll(".fechar");

$(function() {
    $( "#Status1, #Status2, #Status3, #Status4" ).sortable({
       connectWith: "#Status1, #Status2, #Status3, #Status4"
    });
    $( "#Status1, #Status2, #Status3,#Status4").sortable({
       connectWith: "#Status1,#Status2, #Status3,#Status4",
       dropOnEmpty: false
    });
 });

 