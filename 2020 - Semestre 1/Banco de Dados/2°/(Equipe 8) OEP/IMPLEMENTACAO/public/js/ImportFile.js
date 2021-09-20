function importFile() {

    let a = document.getElementById("file");

    let formulario = new Blob(a,
        {
            type: "text/plain;charset=utf-8"
        })

    saveAs(formulario,"Arquivo importado.html");
}

