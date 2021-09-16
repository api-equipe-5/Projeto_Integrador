var selectedRow = null //não entendi

function onFormSubmit(){
    var formData = readFormData() 
        if (selectedRow==null)
            insertNewRecord(formData)
        else
            updateRecord(formData)
    resetform()

 
}

function readFormData(){

    var formData={}

    formData["nomeCompleto"] = document.getElementById("nomeCompleto").value
    formData["cep"] = document.getElementById("cep").value
    formData["salario"] = document.getElementById("salario").value
    formData["cidade"] = document.getElementById("cidade").value
    
    return formData



}

function insertNewRecord(data){
    
    var table = document.getElementById("employeeList").getElementsByTagName("tbody")[0]
    var newRow = table.insertRow(table.length)
    
    cell1 = newRow.insertCell(0); //metodo do javacrip para colocar celula
    cell1.innerHTML = data.nomeCompleto //row a linha inteira

    cell2 = newRow.insertCell(1)
    cell2.innerHTML = data.cep

    cell2 = newRow.insertCell(2)
    cell2.innerHTML = data.salario

    cell3 = newRow.insertCell(3)
    cell3.innerHTML = data.cidade

    cell4 = newRow.insertCell(4)
    cell4.innerHTML = `<a onClick = "onEdit(this)"> Editar </a> 
                        <a onClick = "onDelete(this)"> Excluir </a>`
    
}

function resetform(){
    window.document.getElementById("nomeCompleto").value = "" // Limpar o campo
    window.document.getElementById("cep").value = "" // Limpar o campo
    window.document.getElementById("salario").value = "" // Limpar o campo
    window.document.getElementById("cidade").value = "" // Limpar o campo
    selectedRow = null
} 

function onEdit(td){

    selectedRow = td.parentElement.parentElement 
    window.document.getElementById("nomeCompleto").value = selectedRow.cells[0].innerHTML
    document.getElementById("cep").value = selectedRow.cells[1].innerHTML
    document.getElementById("salario").value = selectedRow.cells[2].innerHTML
    document.getElementById("cidade").value = selectedRow.cells[3].innerHTML
}

function updateRecord(formData){
    selectedRow.cells[0].innerHTML=formData.nomeCompleto
    selectedRow.cells[1].innerHTML=formData.cep
    selectedRow.cells[2].innerHTML=formData.salario
    selectedRow.cells[3].innerHTML=formData.cidade

}

function onDelete(td){
    if(confirm("Você tem certeza que deseja deletar o registro?")){
        row=td.parentElement.parentElement
        document.getElementById("employeeList").deleteRow(row.rowIndex)
        resetform()
    }     
}