/* Máscaras ER */
function mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}
function execmascara(){
    v_obj.value=v_fun(v_obj.value)
}

function mdate(v){
    v=v.replace(/\D/g,""); //Remove tudo o que não é dígito
    v=v.replace(/(\d{2})?(\d{2})?(\d{4})/,"$1/$2/$3"); //Coloca barra depois do segundo número
    
    return v;
}

function id( el ){
	return document.getElementById( el );
}
