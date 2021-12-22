const carros = document.querySelectorAll(".Carro");
const todoStatus = document.querySelectorAll(".Status");
let draggableCarro = null;

carros.forEach((Carro)=>{
    Carro.addEventListener("dragstart", dragStart)
    Carro.addEventListener("dragend", dragEnd) 
});

function dragStart(){
    draggableCarro = this
    // draggableCarro.classList.add('dragging')
    setTimeout(()=>{
        this.style.display = "none"
    }, 0);
    
};

function dragEnd(){
    draggableCarro = null;
    setTimeout(()=>{
        this.style.display = "block"
    }, 0);
    // console.log('dragEnd')
};

todoStatus.forEach((Status)=>{
    Status.addEventListener("dragover", dragOver);
    Status.addEventListener("dragenter", dragEnter);
    Status.addEventListener("dragleave", dragLeave);
    Status.addEventListener("drop", dragDrop);
});



function dragOver(e){
    e.preventDefault();
    // console.log("dragOver")
};

function dragEnter(){
    this.style.border = "none"
    // console.log("dragEnter")
};

function dragLeave(){
    this.style.border = "none"
    // console.log("dragLeave")
};

function dragDrop(){
    this.style.border = "none"
    this.appendChild(draggableCarro)
    // console.log("dragDrop")
}

function getDragElement(Status, y){
 const draggableElements =  [...Status.querySelectorAll('Carro:not(.Carro)')]

 draggableElements.reduce()
}


// Modal

const btns = document.querySelectorAll("[data-target-modal]");
const fecharModal = document.querySelectorAll(".btnFecharModal");
const overlay = document.querySelectorAll("overlay")

btns.forEach((btn)=>{
    btn.addEventListener("click", ()=>{
        document.querySelector(btn.dataset.targetModal).classList.add("active");
        // overlay.classList.add("active")
    });
});

fecharModal.forEach((btn)=>{
    btn.addEventListener("click", ()=>{
        const modal = btn.closest(".modal");
        modal.classList.remove("active");
        // overlay.classList.remove("active");
    });
});

window.onclick = (event) =>{
    if (event.target == overlay){
        const modals = document.querySelectorAll(".modal");
        modals.forEach((modaL)=> modaL.classList.remove("active"));
        // overlay.classList.remove("active");
    }
};

// criar processo 


const addProcesso = document.getElementById("addProcesso");

addProcesso.addEventListener("click", criarProcesso);

function criarProcesso(){
    const addProcesso = document.createElement("div");
    const input_val = document.getElementById("usuario").value;
    const txt = document.createTextNode(input_val);
    document.getElementById("usuario").value = "";

    addProcesso.appendChild(txt);
    addProcesso.classList.add("Carro");
    addProcesso.setAttribute("draggable", "true");


    const span = document.createElement("span");
    const spanTxt = document.createTextNode("\u00D7");
    span.classList.add("fechar");
    span.appendChild(spanTxt);

    addProcesso.appendChild(span)

    noStatus.appendChild(addProcesso)

    // formCarros.classList.remove("active")

    span.addEventListener("click", ()=>{
    span.parentElement.style.display = "none"
    });


    addProcesso.addEventListener("dragstart", dragStart)
    addProcesso.addEventListener("dragend", dragEnd) 


    console.log(addProcesso)
}

const fecharBtns = document.querySelectorAll(".fechar");



// fecharBtns.forEach((btn)=>{
//     btn.addEventListener("click", ()=>{
//         btn.parentElement.style.display = "none"
//     });
// });