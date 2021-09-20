/* Máscaras ER */
function mascara(o, f) {
	v_obj = o
	v_fun = f
	setTimeout("execmascara()", 1)
}
function execmascara() {
	v_obj.value = v_fun(v_obj.value)
}
function mcpf(v) {
	v = v.replace(/\D/g, ""); //Remove tudo o que não é dígito
	v = v.replace(/(\d{3})?(\d{3})?(\d{3})?(\d{2})/, "$1.$2.$3-$4"); //Coloca barra depois do segundo número
	return v;
}

function id(el) {
	return document.getElementById(el);
}

function converteParaImagem() {
	document.getElementById("img").src = "data:image/png;base64," + "${curso.imagem}"
}
