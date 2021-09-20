function salvarproj() {

    let a = document.getElementById("id-nome-projeto").value;
    let b = document.getElementById("id-nome-cliente").value;
    let c = document.getElementById("id-inicio").value;
    let d = document.getElementById("id-prazo").value;
    let e = document.getElementById("id-tarefa").value;
    let f = document.getElementById("id-detalhes").value;

    let formulario = new Blob([a + ";<br>" + b + ";<br>" + c + ";<br>" + d + ";<br>" + e + ";<br>" + f],
        {
            type: "text/plain;charset=utf-8"
        })

    saveAs(formulario,"projeto_" + a + ".html");
}