
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
        limparCampo()
        CloseModal()
    });
});


const setLocalStorage = (dbElement) => localStorage.setItem("STATUS1", JSON.stringify(dbElement))
const getLocalStorage = () => JSON.parse(localStorage.getItem("STATUS1")) ?? []

const setLocalStorage2 = (dbElement2) => localStorage.setItem("STATUS2", JSON.stringify(dbElement2))
const getLocalStorage2 = () => JSON.parse(localStorage.getItem("STATUS2")) ?? []





// CRUD 
const readElement = () => getLocalStorage()
const readElement2 = () => getLocalStorage2()

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
    location.reload()
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
            location.reload()
        }else{
            updadeElement(index,elemento)
            CloseModal()
            limparCampo()
            updadeTabela()
            location.reload()
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
const status = document.getElementsByClassName('.Carro').parentNode
document.querySelector('#Status1').addEventListener('click', editDelet)
document.querySelector('#Status2').addEventListener('click', editDelet)
document.querySelector('#Status3').addEventListener('click', editDelet)
document.querySelector('#Status4').addEventListener('click', editDelet)



const fecharBtns = document.querySelectorAll(".fechar");


// sortable

// $( "#Status2 " ).sortable({
//     receive: function( index, elemento ) {
//      const  dbElement = getLocalStorage() // essa const precisa receber o item que veio de outra coluna
//     dbElement[index] = elemento
//     setLocalStorage2(dbElement)
//     updadeTabela()
//     }
//   });
 




$(function() {
    $( "#Status1, #Status2, #Status3, #Status4" ).sortable({
       connectWith: "#Status1, #Status2, #Status3, #Status4",
       opacity: 0.5,
       revert: true
    });
 });

//  $(function() {
//     $( "#Status1, #Status2, #Status3, #Status4" ).sortable({
//        connectWith: "#Status1, #Status2, #Status3, #Status4",
//        remove: function() {
//         const index = 1 // essa const precisa retornar o item que foi arrastado para outra coluna
//         const dbElement = readElement()
//         dbElement.splice(index,1)
//         setLocalStorage(dbElement)
//         updadeTabela()
//            console.log("removed")
//        }
//     });
    
//  });

 updadeTabela()

