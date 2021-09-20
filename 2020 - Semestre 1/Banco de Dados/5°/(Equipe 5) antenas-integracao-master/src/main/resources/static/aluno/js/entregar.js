let emails = [];
function addStudentToList() {
    var emailWrited = document.getElementById("insertEmailEntrega");
    var email = document.getElementById("insertEmailEntrega").value;
    emails.push(email);
    var table = document.getElementById("myTable");
    var row = table.insertRow(table.length);
    var cell1 = row.insertCell(table.length);
    var cell2 = row.insertCell(table.length);
    cell1.innerHTML = emailWrited.value;
    cell2.innerHTML = "<a href='#' onclick='excluir(" + row.rowIndex + ")'>x</a>";
    document.getElementById("insertEmailEntrega").value = '';
}
function excluir(data) {
    var table = document.getElementById("myTable");
    table.deleteRow(data);
}
function entregar() {

    let chaveProjeto = document.getElementById("chaveProjeto").value

    const retornaBack = val => {
        let email = sessionStorage.getItem("sess_email_aluno");
        let linkRep = document.getElementById('Link-cadastro').value;
        let linkCloud = document.getElementById('Link-cloud').value;
        let coment = document.getElementById('desc-cadastro').value;
        let nowBackEndData = JSON.parse(val);
        let alunos = [];
        let temp = document.getElementById('myTable');

        for (i = 1; i < temp.rows.length ; i++) {
            let aluno = temp.rows[i].firstElementChild.outerText;
            alunos.push(aluno);
        }
        let entrega = {
            "aluno-responsavel": email,
            "alunos": alunos,
            "link-repositorio": linkRep,
            "link-cloud": linkCloud,
            "comentario": coment
        }
        nowBackEndData[0].entregas.push(entrega);

        const callbackSubmit = (data) => {
            window.location.href = 'principal.html';
        };
        
        $.post("/add-projeto", JSON.stringify(nowBackEndData[0]), callbackSubmit);
    }

    $.get("/searchaluno/" + chaveProjeto, retornaBack);
    alert("Entrega realizada!");

}

