function salvartar() {

    let a = document.getElementById("id-nome-tarefa").value;
    let b = document.getElementById("id-nome-projet").value;
    let c = document.getElementById("id-inicio-tarefa").value;
    let d = document.getElementById("id-prazo-tarefa").value;
    let e = document.getElementById("id-dev").value;
    let f = document.getElementById("id-detalhe").value;

    let formulario = new Blob([a + ";<br>" + b + ";<br>" + c + ";<br>" + d + ";<br>" + e + ";<br>" + f],
        {
            type: "text/plain;charset=utf-8"
        })

    saveAs(formulario,"tarefa_" + a + ".html");
}
