/**ATENÇÃO!!!!!*/

/**ESTE ARQUIVO JAVASCRIPT FOI PROJETADO PARA TRATAR APENAS CADASTRO DE PESSOAS E HABILIDADES*/


/////////////////**CADASTRO DE HABILIDADES*/////////////////////////////////////////////

function cadastrarHabilidades(){
    dialogCadastro = document.getElementById("abreCadastroHabilidades");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();
}

function fecharCadastroHabilidade(){
    dialogCadastro.close();
    dialogCadastro = document.getElementById("abreCadastroPessoas");
    dialogPolyfill.registerDialog(dialogCadastro);
    //limparCamposCadasHabilidade();
}

function mostrarHabilidades(){
    dialogCadastro = document.getElementById("habilidades_cadastradas");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();

    getHabilidade();
    
}

function fecharListaHabilidades(){
    dialogCadastro.close();
    dialogCadastro = document.getElementById("abreCadastroHabilidades");
    dialogPolyfill.registerDialog(dialogCadastro);
    
}

function getHabilidade(){
    xhrGetHabilidade = new XMLHttpRequest();
    xhrGetHabilidade.open('GET', URLGETHABILIDADES, true);
    xhrGetHabilidade.onreadystatechange = function(){
        if(xhrGetHabilidade.readyState == 4){
            if(xhrGetHabilidade.status == 200){
                 
               json_habilidades = (JSON.parse(xhrGetHabilidade.responseText));
               document.getElementById("lista_habilidades_cadastradas").innerHTML = '';
               for(i=0;i<json_habilidades.length;i++){

                    linha = "<label class='class_habilidades' id='habilidade"+json_habilidades[i]['hab_id']+"'>"+json_habilidades[i]['hab_nome']+" <button id='btn_delHab"+json_habilidades[i]['hab_id']+"' onclick='deleteHabilidade(this.id)'>X</button> </label>";
                   document.getElementById("lista_habilidades_cadastradas").innerHTML += linha;
                   
               }
            
            }else if(xhrGetHabilidade.status == 404){

            }
        }      
    }
    xhrGetHabilidade.send();
}

function gravarHabilidade(){

    nome_habilidade = document.getElementById("nome_habilidade").value;

    if(nome_habilidade == ""){

        
       alert("Campo nome habilidade deve ser preenchido!");


    }else{

    xhrPostHabilidade = new XMLHttpRequest();
    xhrPostHabilidade.open("POST", URLGETHABILIDADES, true);
    xhrPostHabilidade.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrPostHabilidade.setRequestHeader("X-CSRFToken", csrftoken);
    xhrPostHabilidade.setRequestHeader("withCredentials", 'True');    
    xhrPostHabilidade.onload = function(){
        if(xhrPostHabilidade.readyState == 4){
            if(xhrPostHabilidade.status == 201){
                getHabilidade();
                alert("Habilidade cadastrada com sucesso!!");
            }
        }
    }

    xhrPostHabilidade.send(JSON.stringify({
        'hab_nome': nome_habilidade
    }));
    }
    document.getElementById("nome_habilidade").value = '';
}


function deleteHabilidade(btn_id_hab){
    
    novo_id = btn_id_hab.substr(10);

    

    xhrDeleteHabilidade = new XMLHttpRequest();
    xhrDeleteHabilidade.open('DELETE', URLGETHABILIDADES+novo_id, true);
    xhrDeleteHabilidade.onreadystatechange = function(){
        if(xhrDeleteHabilidade.readyState == 4){
            if(xhrDeleteHabilidade.status == 204){
                getHabilidade();
            }
        }
    }
    xhrDeleteHabilidade.send();

}

/**///////////////////////////////////////////////////////////////////////////////////*/

/////////////////**INCLUSAO DE HABILIDADES*/////////////////////////////////////////////

function incluirHabilidades(){
    dialogCadastro = document.getElementById("abreInclusaoHabilidades");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();
    selectPessoas();
    selectHabilidades();
}

function fecharInclusaoHabilidade(){
    dialogCadastro.close();
    dialogCadastro = document.getElementById("abreCadastroPessoas");
    dialogPolyfill.registerDialog(dialogCadastro);
    //limparCamposCadasHabilidade();
}

function selectPessoas(){
    xhrSelectPessoas = new XMLHttpRequest();
    xhrSelectPessoas.open('GET', URLGETPESSOAS, true);
    xhrSelectPessoas.onreadystatechange = function(){
        if(xhrSelectPessoas.readyState == 4){
            if(xhrSelectPessoas.status == 200){
                json_select_pessoas = JSON.parse(xhrSelectPessoas.responseText);

                document.getElementById("nome_pessoa").innerHTML = '';
                document.getElementById("nome_pessoa_1").innerHTML = '';
                linhaOption = "<option></option>"
                document.getElementById("nome_pessoa").innerHTML += linhaOption;
                document.getElementById("nome_pessoa_1").innerHTML += linhaOption;

                for(i=0;i<json_select_pessoas.length;i++){
                    linhaOption = "<option>"+json_select_pessoas[i]['pes_nome']+"</option>"
                    document.getElementById("nome_pessoa").innerHTML += linhaOption;

                    document.getElementById("nome_pessoa_1").innerHTML += linhaOption;
                }

                selec_pessoas_habilidades(json_select_pessoas, null);
            }
        }
    }
    xhrSelectPessoas.send();
}

function selectHabilidades(){
    xhrSelectHabilidades = new XMLHttpRequest();
    xhrSelectHabilidades.open('GET', URLGETHABILIDADES, true);
    xhrSelectHabilidades.onreadystatechange = function(){
        if(xhrSelectHabilidades.readyState == 4){
            if(xhrSelectHabilidades.status == 200){
                json_select_habilidades = JSON.parse(xhrSelectHabilidades.responseText);
                document.getElementById("seleciona_nome_habilidade").innerHTML = '';
                linhaOption = "<option></option>"
                    document.getElementById("seleciona_nome_habilidade").innerHTML += linhaOption;
                for(i=0;i<json_select_habilidades.length;i++){
                    linhaOption = "<option>"+json_select_habilidades[i]['hab_nome']+"</option>"
                    document.getElementById("seleciona_nome_habilidade").innerHTML += linhaOption;
                }

                selec_pessoas_habilidades(null, json_select_habilidades);
            }
        }
    }
    xhrSelectHabilidades.send();
}

function get_pessoas_habilidades(){
    
    nome_pessoa = document.getElementById("nome_pessoa_1").value;

    if(nome_pessoa == ''){
        document.getElementById('nome_pessoa_1').value = '';
    document.getElementById("lista_pessoas_habilidades").innerHTML = '';
    }else{
    for(i=0;i<recebe_select_pessoas.length;i++){
        if(nome_pessoa == recebe_select_pessoas[i]['pes_nome']){
            cod_pessoa = recebe_select_pessoas[i]['pes_id']
        }
    }
    xhrGetPessoasHabilidades= new XMLHttpRequest();
    xhrGetPessoasHabilidades.open('GET', URLGETDISTRHABILIDADES, true);
    xhrGetPessoasHabilidades.onreadystatechange = function(){
        if(xhrGetPessoasHabilidades.readyState == 4){
            if(xhrGetPessoasHabilidades.status == 200){
                 
               json_pessoas_habilidades = (JSON.parse(xhrGetPessoasHabilidades.responseText));
               document.getElementById("lista_pessoas_habilidades").innerHTML = '';
               for(i=0;i<json_pessoas_habilidades.length;i++){
                    if(cod_pessoa == json_pessoas_habilidades[i]['fk_pes_id']){

                        for(x = 0;x<recebe_select_habilidades.length;x++){
                            if(recebe_select_habilidades[x]['hab_id'] == json_pessoas_habilidades[i]['fk_hab_id']){
                        linha = "<label class='class_habilidades' id='pessoa_habilidade"+json_pessoas_habilidades[i]['pes_hab_id']+"'>"+recebe_select_habilidades[x]['hab_nome']+"<button id='btn_delHab"+json_pessoas_habilidades[i]['pes_hab_id']+"' onclick='deletePessoaHabilidade(this.id)'>X</button> </label>";
                        document.getElementById("lista_pessoas_habilidades").innerHTML += linha;
                            }
                        }
                    }
                }
            
            }else if(xhrGetPessoasHabilidades.status == 404){

            }
        }      
    }
    xhrGetPessoasHabilidades.send();
}
}

recebe_select_pessoas = [];
recebe_select_habilidades = [];
function selec_pessoas_habilidades(json_select_pessoas, json_select_habilidades){

    if(json_select_pessoas != null){
        recebe_select_pessoas = json_select_pessoas;
    }

    if(json_select_habilidades != null){
        recebe_select_habilidades = json_select_habilidades;
    }
}

function gravarPessoaHabilidade(){
   

    nome_Pessoa = document.getElementById('nome_pessoa').value;
    nome_Habilidade = document.getElementById('seleciona_nome_habilidade').value;

    
    if(nome_Pessoa == ""){
        alert("Por favor, selecione uma opção para Pessoa.");

    }else if(nome_Habilidade == ""){
        alert("Por favor, selecione uma opção para Habilidade.");
    }else{

    for(i=0;i<recebe_select_pessoas.length;i++){

        if(nome_Pessoa == recebe_select_pessoas[i]['pes_nome']){
            cod_pessoa = recebe_select_pessoas[i]['pes_id'];
        }
    }

    for(i=0;i<recebe_select_habilidades.length;i++){

         if(nome_Habilidade == recebe_select_habilidades[i]['hab_nome']){
            cod_habilidade = recebe_select_habilidades[i]['hab_id'];
        }
    }

    xhrGravarPessoaHabilidade = new XMLHttpRequest();
    xhrGravarPessoaHabilidade.open('POST', URLGETDISTRHABILIDADES, true);
    xhrGravarPessoaHabilidade.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrGravarPessoaHabilidade.setRequestHeader("X-CSRFToken", csrftoken);
    xhrGravarPessoaHabilidade.setRequestHeader("withCredentials", 'True');   
    xhrGravarPessoaHabilidade.onreadystatechange = function(){
        if(xhrGravarPessoaHabilidade.readyState == 4){
            if(xhrGravarPessoaHabilidade.status == 201){
                alert("Cadastro efetuado com sucesso!!");
                
            }else if(xhrGravarPessoaHabilidade.status == 400){
                alert("Pessoa já possui habilidade.");
            }
        }
    }
    xhrGravarPessoaHabilidade.send(JSON.stringify({
        'fk_pes_id': cod_pessoa,
        'fk_hab_id': cod_habilidade
    }));

    document.getElementById('nome_pessoa').value = '';
    document.getElementById('seleciona_nome_habilidade').value = '';
    }
}

function deletePessoaHabilidade(btn_id_pes_hab){
  
    novo_id = btn_id_pes_hab.substr(10);

    

    xhrDeletePessoaHabilidade = new XMLHttpRequest();
    xhrDeletePessoaHabilidade.open('DELETE', URLGETDISTRHABILIDADES+novo_id, true);
    xhrDeletePessoaHabilidade.onreadystatechange = function(){
        if(xhrDeletePessoaHabilidade.readyState == 4){
            if(xhrDeletePessoaHabilidade.status == 204){
                get_pessoas_habilidades();
            }
        }
    }
    xhrDeletePessoaHabilidade.send();

}


function mostrarPessoasHabilidades(){
    dialogCadastro = document.getElementById("cadastrados_pes_hab");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();
   
}

function fecharPessoasHabilidades(){
    dialogCadastro.close();
    dialogCadastro = document.getElementById("abreInclusaoHabilidades");
    dialogPolyfill.registerDialog(dialogCadastro);

    document.getElementById('nome_pessoa_1').value = '';
    document.getElementById("lista_pessoas_habilidades").innerHTML = '';
    document.getElementById('nome_pessoa').value = '';
    document.getElementById('seleciona_nome_habilidade').value = '';
    
}

/**///////////////////////////////////////////////////////////////////////////////////*/


/*CADASTRO DE PESSOAS*///////////////////////////////

/*GET AND POST - API*////////////////////////////////////////////////////////////////////


function preencheCamposCadasPessoa(json){
    document.getElementById("nomePessoa").value = json.pes_nome; 
    document.getElementById("contato").value = json.pes_contato;
    document.getElementById("salario").value = json.pes_salario;
    document.getElementById("faltas").value = json.pes_faltas;
    document.getElementById("horas_disponiveis").value = json.pes_hrs_disponivel;

}



function getPessoa(){
    codPessoa = document.getElementById("codPessoa").value;
    
    

    if(codPessoa == "undefined"){
        document.getElementById("codPessoa").value = 0;
        limparCamposCadasPessoa();
        desabilitaAvancoCodPessoa();
        desabilitaBtnAtualizarPessoa();
        desabilitaBtnCancelarPessoa();
        desabilitaBtnGravaPessoa();
        desabilitaBtnExcluirPessoa();
        desabilitaCamposPessoa();
        desabilitaRecuoCodPessoa();

    }else{
    xhrGetPessoa = new XMLHttpRequest();
    xhrGetPessoa.open('GET', URLGETPESSOAS+codPessoa, true);
   
    xhrGetPessoa.onreadystatechange = function(){
        if(xhrGetPessoa.readyState == 4){
            if(xhrGetPessoa.status == 200){
                preencheCamposCadasPessoa(JSON.parse(xhrGetPessoa.responseText));     
                
                
                


            
            }else if(xhrGetPessoa.status == 404){

            }
        }
        
    }
    xhrGetPessoa.send();
    
   }
}


function postPessoa(){
    codPessoa = document.getElementById("codPessoa").value;
    nomePessoa = document.getElementById("nomePessoa").value;
    contato = document.getElementById("contato").value;
    salario = document.getElementById("salario").value;
    faltas = document.getElementById("faltas").value;
    horas_disponiveis = document.getElementById("horas_disponiveis").value;

    if(nomePessoa == '' || contato == '' || salario == '' || faltas == '' || horas_disponiveis == '' ){
        alert("Todos os campos devem ser preenchidos!!");
    }else{
    xhrPostPessoa = new XMLHttpRequest();
    xhrPostPessoa.open("POST", URLGETPESSOAS, true);
    xhrPostPessoa.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrPostPessoa.setRequestHeader("X-CSRFToken", csrftoken);
    xhrPostPessoa.setRequestHeader("withCredentials", 'True');    
    xhrPostPessoa.onreadystatechange = function(){
        if(xhrPostPessoa.readyState == 4){
            if(xhrPostPessoa.status == 201){
                getPessoa();
                
                
                if((json.length+1) > 1){
                    habilitaRecuoCodPessoa();
                }
            }
        }
    }

    xhrPostPessoa.send(JSON.stringify({
        'pes_id': codPessoa,
        'pes_nome': nomePessoa, 
        'pes_contato': contato,
        'pes_salario': salario,
        'pes_faltas': faltas,
        'pes_hrs_disponivel': horas_disponiveis
    }));

    
    desabilitaCamposPessoa();
    habilitaBtnNovaPessoa();
    desabilitaBtnGravaPessoa();
    desabilitaBtnCancelarPessoa();
    
    carregaTabelaPessoa();
    habilitaBtnExcluirPessoa();
    habilitaBtnAtualizarPessoa();
}
}

function putPessoa(){
    if(document.getElementById("nomePessoa").readOnly == true){
        habilitaCamposPessoa();
        mudaBotao =  document.getElementById("btn_atualizarCadasPessoa");
        mudaBotao.style.backgroundColor = "green";

    }else{
        codPessoa = document.getElementById("codPessoa").value;
    
        nomePessoa = document.getElementById("nomePessoa").value;
        contato = document.getElementById("contato").value;
        salario = document.getElementById("salario").value;
        faltas = document.getElementById("faltas").value;
        horas_disponiveis = document.getElementById("horas_disponiveis").value;
        if(nomePessoa == '' || contato == '' || salario == '' || faltas == '' || horas_disponiveis == '' ){
            alert("Todos os campos devem ser preenchidos!!");
        }else{
            xhrPutPessoa = new XMLHttpRequest();
        
            xhrPutPessoa.open("PUT", URLGETPESSOAS+codPessoa+'/', true);
            xhrPutPessoa.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhrPutPessoa.setRequestHeader("X-CSRFToken", csrftoken);
            xhrPutPessoa.setRequestHeader("withCredentials", 'True');
            xhrPutPessoa.onload = function(){
                if(xhrPutPessoa.readyState == 4){
                    if(xhrPutPessoa.status == 200){    
                        getPessoa();
                        carregaTabelaPessoa();
                        
                    }
                }
            

            }

            xhrPutPessoa.send(JSON.stringify({
                'pes_id': codPessoa,
                'pes_nome': nomePessoa, 
                'pes_contato': contato,
                'pes_salario': salario,
                'pes_faltas': faltas,
                'pes_hrs_disponivel': horas_disponiveis
            }));

            
            mudaBotao =  document.getElementById("btn_atualizarCadasPessoa");
            mudaBotao.style.backgroundColor = "#698FEB";
        
            desabilitaCamposPessoa();
            
        }
    }
}

function deletePessoa(){
   
    codPessoa = document.getElementById("codPessoa").value;
    xhrDeletePessoa = new XMLHttpRequest();
    xhrDeletePessoa.open("DELETE", URLGETPESSOAS+codPessoa, true);
    xhrDeletePessoa.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrDeletePessoa.setRequestHeader("X-CSRFToken", csrftoken);
    xhrDeletePessoa.setRequestHeader("withCredentials", 'True');
    xhrDeletePessoa.onreadystatechange = function () {
        if(xhrDeletePessoa.readyState == 4){
            if(xhrDeletePessoa.status == 204){
                carregaTabelaPessoa();          
            }
        }  
    }
    xhrDeletePessoa.send();
    recuarCodPessoa(codPessoa);   

}



 
///////////////////////FINISH: GET - POST - PUT - DELETE //////////////////////////////////////////////////////////
function clicaPessoas(){
    document.getElementById("menu_superior").classList.remove("show");   
    codPessoaAtual = 0;
    dialogCadastro = document.getElementById("abreCadastroPessoas");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();
 
   
    
    xhrAbrePessoa = new XMLHttpRequest();
    xhrAbrePessoa.open('GET', URLGETPESSOAS, true);
    xhrAbrePessoa.setRequestHeader("X-CSRFToken", csrftoken);
    xhrAbrePessoa.setRequestHeader("withCredentials", 'True');
    xhrAbrePessoa.onreadystatechange = function(){
        
        maiorvalor = 0;
        if(xhrAbrePessoa.readyState == 4){
            if(xhrAbrePessoa.status == 200){
                json = (JSON.parse(xhrAbrePessoa.responseText));

                for(i = 0; i<json.length;i++){
                   if(json[i]['pes_id'] > maiorvalor ){
                        maiorvalor = json[i]['pes_id'];
                    }     
                    
                }
                
                if(maiorvalor == 0){
                    document.getElementById("codPessoa").value = 0;
                    limparCamposCadasPessoa();
                    desabilitaAvancoCodPessoa();
                    desabilitaBtnAtualizarPessoa();
                    desabilitaBtnCancelarPessoa();
                    desabilitaBtnGravaPessoa();
                    desabilitaBtnExcluirPessoa();
                    habilitaBtnNovaPessoa();
                    desabilitaCamposPessoa();
                    desabilitaRecuoCodPessoa();
                }else{
                    if(json.length == 1){
                        desabilitaAvancoCodPessoa();
                        desabilitaRecuoCodPessoa();
                    }else{
                        habilitaRecuoCodPessoa();
                    }
                    document.getElementById('codPessoa').value = maiorvalor;
                    getPessoa();
                }              
            }else if(xhrAbrePessoa.status == 404){}    
        }    
    }  
    xhrAbrePessoa.send();
    desabilitaBtnCancelarPessoa();
    habilitaBtnNovaPessoa();
    desabilitaBtnGravaPessoa();
    desabilitaAvancoCodPessoa();
    carregaTabelaPessoa();
  
}

function novaPessoa(){
    codPessoa = parseInt(document.getElementById("codPessoa").value);
    if(codPessoa == 0){
        codPessoa = 1;
        document.getElementById("codPessoa").value = codPessoa;
        habilitaCamposPessoa();
    habilitaBtnCancelarPessoa();
    desabilitaBtnNovaPessoa();
    habilitaBtnGravarPessoa();
    desabilitaAvancoCodPessoa();
    desabilitaRecuoCodPessoa();
    limparCamposCadasPessoa();
    desabilitaBtnExcluirPessoa();
    desabilitaBtnAtualizarPessoa();
    }else{
    
     
    vetor_pessoa = [];
    xhrNovaPessoa = new XMLHttpRequest();
    xhrNovaPessoa.open('GET', URLGETPESSOAS, true);
    xhrNovaPessoa.onreadystatechange = function(){     
        if(xhrNovaPessoa.readyState == 4){
            if(xhrNovaPessoa.status == 200){
                json = (JSON.parse(xhrNovaPessoa.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_pessoa.push(json[i]['pes_id']);
                    
                }
                vetor_pessoa.reverse();
                codPessoa = vetor_pessoa[0] + 1;
              }
        }
        document.getElementById("codPessoa").value = codPessoa;
    }
    xhrNovaPessoa.send();
    }
    
    
    habilitaCamposPessoa();
    habilitaBtnCancelarPessoa();
    desabilitaBtnNovaPessoa();
    habilitaBtnGravarPessoa();
    desabilitaAvancoCodPessoa();
    desabilitaRecuoCodPessoa();
    limparCamposCadasPessoa();
    desabilitaBtnExcluirPessoa();
    desabilitaBtnAtualizarPessoa();
    
}

function cancelarCadasPessoa(){
    codPessoa = parseInt(document.getElementById("codPessoa").value);
    document.getElementById("codPessoa").value = codPessoa - 1;
    
    desabilitaCamposPessoa();
    
    desabilitaBtnGravaPessoa();
    desabilitaBtnCancelarPessoa();
    habilitaRecuoCodPessoa();
    getPessoa();
    habilitaBtnNovaPessoa();
    habilitaBtnExcluirPessoa();
    habilitaBtnAtualizarPessoa();
}

function recuarCodPessoa(codAnterior){ 
 
    
    codPessoa = parseInt(document.getElementById("codPessoa").value);
    vetor_pessoa = [];
    xhrRecuarCod = new XMLHttpRequest();
    xhrRecuarCod.open('GET', URLGETPESSOAS, true);
    xhrRecuarCod.onreadystatechange = function(){     
        if(xhrRecuarCod.readyState == 4){
            if(xhrRecuarCod.status == 200){
                json = (JSON.parse(xhrRecuarCod.responseText));

                for(i = 0;i<json.length;i++){
                    vetor_pessoa.push(json[i]['pes_id']);
                    
                }
                 menorvalor = vetor_pessoa[0];
                 for(i=0;i<vetor_pessoa.length;i++){

                    if(codPessoa == vetor_pessoa[i]){
                    codPessoa = vetor_pessoa[i-1];
                    }              
                }
                   
                   
                document.getElementById("codPessoa").value = codPessoa; 
                      
                
                
                if(codPessoa == menorvalor){
                    desabilitaRecuoCodPessoa();
                    
                }

                
               

                if(vetor_pessoa.length > 1){
                    
                    habilitaAvancoCodPessoa();
                }
               
               //AÇÃO ABAIXO EM CONJUNTO COM O DELETE
                ///codAnterior vindo da function DELETE
                vetor_pessoa.reverse();
                if(codAnterior != undefined){
                    if(codAnterior == vetor_pessoa[0] && vetor_pessoa.length == 1){

                        document.getElementById('codPessoa').value = 0;
                    }else{
                        
                        if(codAnterior == menorvalor){
                        
                            document.getElementById('codPessoa').value = vetor_pessoa[0];
                            desabilitaAvancoCodPessoa();
                            
                            if(vetor_pessoa.length > 2){
                                habilitaRecuoCodPessoa();
                            }
                            
                        }else{
                         for(i=0;i<vetor_pessoa.length;i++){
                            if(codAnterior == vetor_pessoa[0]){
                                vetor_pessoa.splice(i,1);
                                if(codPessoa == vetor_pessoa[0]){
                                    desabilitaAvancoCodPessoa();
                                }                               
                            }   
                        }
                    }
                    }
                    
                }
            
                if(document.getElementById('codPessoa').value == 0){
                    limparCamposCadasPessoa();
                    desabilitaCamposPessoa();
                }else{
                    getPessoa();
                }
                
                
            }else if(xhrRecuarCod.status == 404){ }
        
            }
            
            
        }  
    

        xhrRecuarCod.send();
       
}

function avancarCodPessoa(){ 
    
    
    codPessoa = parseInt(document.getElementById("codPessoa").value);
    vetor_pessoa = [];
    xhrAvancarPessoa = new XMLHttpRequest();
    xhrAvancarPessoa.open('GET', URLGETPESSOAS, true);
    xhrAvancarPessoa.onreadystatechange = function(){     
        if(xhrAvancarPessoa.readyState == 4){
            if(xhrAvancarPessoa.status == 200){
                json = (JSON.parse(xhrAvancarPessoa.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_pessoa.push(json[i]['pes_id']);
                    
                }
                
                vetor_pessoa.reverse();
                 maiorvalor = 0;
                 for(i=0;i<vetor_pessoa.length;i++){
                    
                    if(codPessoa == vetor_pessoa[i]){
                    codPessoa = vetor_pessoa[i-1];
                 }
                 if(vetor_pessoa[i] > maiorvalor){
                    maiorvalor = vetor_pessoa[i]; 
                }    

                }
                   
                document.getElementById("codPessoa").value = codPessoa;
                
                
                if(codPessoa == maiorvalor){
                    desabilitaAvancoCodPessoa();
                }

                habilitaRecuoCodPessoa();
                getPessoa();
                }else if(xhrAvancarPessoa.status == 404){ }
            }
        }
    

        xhrAvancarPessoa.send();

}


function desabilitaBtnAtualizarPessoa(){
    document.getElementById("btn_atualizarCadasPessoa").disabled = true;
   mudaBotao =  document.getElementById("btn_atualizarCadasPessoa");
    mudaBotao.style.backgroundColor = "gray";


}

function habilitaBtnAtualizarPessoa(){
   
 
        document.getElementById("btn_atualizarCadasPessoa").disabled = false;
     mudaBotao =  document.getElementById("btn_atualizarCadasPessoa");
     mudaBotao.style.backgroundColor = "#698FEB";
      
 
 }


function desabilitaRecuoCodPessoa(){
        document.getElementById("codAnteriorCadasPessoa").disabled = true;
       mudaBotao =  document.getElementById("codAnteriorCadasPessoa");
        mudaBotao.style.backgroundColor = "gray";
}

function desabilitaAvancoCodPessoa(){
  document.getElementById("codPosteriorCadasPessoa").disabled = true;
     if(document.getElementById("codPosteriorCadasPessoa").disabled = true){
       mudaBotao =  document.getElementById("codPosteriorCadasPessoa");
        mudaBotao.style.backgroundColor = "gray";
}
}

function habilitaRecuoCodPessoa(){
     
    document.getElementById("codAnteriorCadasPessoa").disabled = false;
    mudaBotao =  document.getElementById("codAnteriorCadasPessoa");
    mudaBotao.style.backgroundColor = "#698FEB";
     
}

function habilitaAvancoCodPessoa(){
  document.getElementById("codPosteriorCadasPessoa").disabled = false;
    mudaBotao =  document.getElementById("codPosteriorCadasPessoa");
    mudaBotao.style.backgroundColor = "#698FEB";
}

function fecharCadastroPessoa(){
    dialogCadastro.close();
    limparCamposCadasPessoa();
}

function habilitaBtnCancelarPessoa(){
    document.getElementById("btn_cancelarCadasPessoa").disabled = false;
    mudaBotao =  document.getElementById("btn_cancelarCadasPessoa");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnCancelarPessoa(){
    document.getElementById("btn_cancelarCadasPessoa").disabled = true;
        mudaBotao =  document.getElementById("btn_cancelarCadasPessoa");
        mudaBotao.style.backgroundColor = "gray";

}

function habilitaCamposPessoa(){
     document.getElementById("nomePessoa").readOnly = false;
    document.getElementById("contato").readOnly = false;
    document.getElementById("salario").readOnly = false;
    document.getElementById("faltas").readOnly = false;
    document.getElementById("horas_disponiveis").readOnly = false;
    
  
}

function desabilitaCamposPessoa(){
    limparCamposCadasPessoa();
    document.getElementById("nomePessoa").readOnly = true;
    document.getElementById("contato").readOnly = true;
    document.getElementById("salario").readOnly = true;
    document.getElementById("faltas").readOnly = true;
    document.getElementById("horas_disponiveis").readOnly = true;
    
    
}

function habilitaBtnNovaPessoa(){
     document.getElementById("btn_novapessoa").disabled = false;
    mudaBotao =  document.getElementById("btn_novapessoa");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnNovaPessoa(){
    document.getElementById("btn_novapessoa").disabled = true;

       mudaBotao =  document.getElementById("btn_novapessoa");
        mudaBotao.style.backgroundColor = "gray";

}


function desabilitaBtnExcluirPessoa(){
    document.getElementById("btn_excluirCadasPessoa").disabled = true;
    mudaBotao =  document.getElementById("btn_excluirCadasPessoa");
     mudaBotao.style.backgroundColor = "gray";
}

function habilitaBtnExcluirPessoa(){
    document.getElementById("btn_excluirCadasPessoa").disabled = false;
    mudaBotao =  document.getElementById("btn_excluirCadasPessoa");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnGravaPessoa(){
  
    document.getElementById("btn_salvarpessoa").disabled = true;
    
       mudaBotao =  document.getElementById("btn_salvarpessoa");
        mudaBotao.style.backgroundColor = "gray";
   
}

function habilitaBtnGravarPessoa(){
    document.getElementById("btn_salvarpessoa").disabled = false;
    mudaBotao =  document.getElementById("btn_salvarpessoa");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function limparCamposCadasPessoa(){
    document.getElementById("nomePessoa").value = '';
    document.getElementById("contato").value = '';
    document.getElementById("salario").value = '';
    document.getElementById("faltas").value = '';
    document.getElementById("horas_disponiveis").value = '';

    
}

function fecharCadastroPessoa(){
    dialogCadastro.close();
    limparCamposCadasPessoa();
}


function carregaTabelaPessoa(){
   
    
    codPessoa = parseInt(document.getElementById("codPessoa").value);
    vetor_TabelaCadasPessoa = [];
    xhrTabelaPessoa = new XMLHttpRequest();
    xhrTabelaPessoa.open('GET', URLGETPESSOAS, true);
    
    xhrTabelaPessoa.onreadystatechange = function(){     
        if(xhrTabelaPessoa.readyState == 4){
            if(xhrTabelaPessoa.status == 200){
                json = (JSON.parse(xhrTabelaPessoa.responseText));
                for(i = 0;i<json.length;i++){

                    linhaTabelaPessoas = "<tr><td>"+json[i]['pes_id']+"</td><td>"+json[i]['pes_nome']+"</td><td>"+json[i]['pes_contato']+"</td></tr>";
    
                    vetor_TabelaCadasPessoa.push(linhaTabelaPessoas);
                }
             

            }
           
        }
        
        document.getElementById("corpoTabelaPessoas").innerHTML = '';
    
    for(i = 0; i < vetor_TabelaCadasPessoa.length;i++){
         document.getElementById("corpoTabelaPessoas").innerHTML += vetor_TabelaCadasPessoa[i];
        
    }    
    }

    xhrTabelaPessoa.send();
        
}

/*/////////////////////////////////////////////////*/
