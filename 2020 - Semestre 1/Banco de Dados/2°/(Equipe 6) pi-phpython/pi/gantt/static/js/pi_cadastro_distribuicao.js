/**ATENÇÃO!!!!!*/

/**ESTE ARQUIVO JAVASCRIPT FOI PROJETADO PARA TRATAR APENAS CADASTRO DE DISTRIBUICAO DE PESSOAS 
 * EM PROJETOS
*/



/*DISTRIBUIÇÃO DE PESSOAS AOS PROJETOS*///////////////////////////////

/*GET AND POST - API*////////////////////////////////////////////////////////////////////

////INÍCIO DATALIST////////////////////////////////////////////


function dt_projetos_distribuicao(){

    xhr_dt_getProjetos = new XMLHttpRequest();
    xhr_dt_getProjetos.open('GET', URLGETPROJETOS, true);

    xhr_dt_getProjetos.onreadystatechange = function(){
        if(xhr_dt_getProjetos.readyState == 4){
            if(xhr_dt_getProjetos.status == 200){
                json_dt_getProjetos = JSON.parse(xhr_dt_getProjetos.responseText);
              
                document.getElementById('selecionaProjeto_distribuicao').innerHTML = '';
                document.getElementById('selecionaProjeto_distribuicao').innerHTML = '<option></option>';
                for(i=0;i<json_dt_getProjetos.length;i++){
                    linha = '<option>'+json_dt_getProjetos[i]['prj_nome']+'</option>';
                    document.getElementById('selecionaProjeto_distribuicao').innerHTML += linha;
                }
                
                select_tb_projeto(json_dt_getProjetos);

            }
        }
    }
    xhr_dt_getProjetos.send();

}


recebe_tb_projeto = [];
function select_tb_projeto(json_dt_getProjetos){

    if(json_dt_getProjetos != null){
        recebe_tb_projeto = json_dt_getProjetos;
    }

}

function dt_tarefas_distribuicao(){

    hr_dt_getTarefas = new XMLHttpRequest();
    hr_dt_getTarefas.open('GET', URLGETTAREFAS, true);

    hr_dt_getTarefas.onreadystatechange = function(){
        if(hr_dt_getTarefas.readyState == 4){
            if(hr_dt_getTarefas.status == 200){
                json_dt_getTarefas = JSON.parse(hr_dt_getTarefas.responseText);
               
                nome_projeto = document.getElementById('selecionaProjeto_distribuicao').value;
                
                document.getElementById('listaTarefa').innerHTML = '';
                document.getElementById('listaTarefa').innerHTML = '<option></option>';
                for(i=0;i<json_dt_getTarefas.length;i++){
                    for(x=0;x<recebe_tb_projeto.length;x++){
                        if(recebe_tb_projeto[x]['prj_nome'] == nome_projeto){
                            cod_projeto = recebe_tb_projeto[x]['prj_id'];
                            if(json_dt_getTarefas[i]['fk_prj_id'] == cod_projeto){
                            linha = '<option>'+json_dt_getTarefas[i]['trf_name']+'</option>';
                            document.getElementById('listaTarefa').innerHTML += linha;
                        }
                    }
                    }
                }
                select_tb_tarefas(json_dt_getTarefas);
                
            }
        }
    }
    hr_dt_getTarefas.send();
}

recebe_tb_tarefas = [];
function select_tb_tarefas(json_dt_getTarefas){

    if(json_dt_getTarefas != null){
        recebe_tb_tarefas = json_dt_getTarefas;
    }

}

function dt_pessoas_distribuicao(){
    hr_dt_getPessoas = new XMLHttpRequest();
    hr_dt_getPessoas.open('GET', URLGETPESSOAS, true);

    hr_dt_getPessoas.onreadystatechange = function(){
        if(hr_dt_getPessoas.readyState == 4){
            if(hr_dt_getPessoas.status == 200){
                json_dt_getPessoas = JSON.parse(hr_dt_getPessoas.responseText);
               
                document.getElementById('listaPessoa').innerHTML = '';
                document.getElementById('listaPessoa').innerHTML = '<option></option>';
                for(i=0;i<json_dt_getPessoas.length;i++){
                    linha = '<option>'+json_dt_getPessoas[i]['pes_nome']+'</option>';
                    document.getElementById('listaPessoa').innerHTML += linha;
                }

                select_tb_pessoas(json_dt_getPessoas);
            
            }
        }
    }
    hr_dt_getPessoas.send();
}
recebe_tb_pessoas = [];
function select_tb_pessoas(json_dt_getPessoas){

    if(json_dt_getPessoas != null){
        recebe_tb_pessoas = json_dt_getPessoas;
    }
}


//// FIM DATALIST////////////////////////////////////////////

function getDistribuicao(){
   codDistribuicao = document.getElementById('codDistribuicao').value;
    if(codDistribuicao == "undefined"){
        document.getElementById("codDistribuicao").value = 0;
        limparCamposCadasDistribuicao();
        desabilitaAvancoCodDistribuicao();
        desabilitaBtnAtualizarDistribuicao();
        desabilitaBtnCancelarDistribuicao();
        desabilitaBtnGravaDistribuicao();
        desabilitaBtnExcluirDistribuicao();
        desabilitaCamposDistribuicao();
        desabilitaRecuoCodDistribuicao();

    }else{
        xhrGetDistribuicao = new XMLHttpRequest();
    
        xhrGetDistribuicao.open('GET', URLGETDISTRIBUICAO+codDistribuicao+'/', true);
            vetor_distribuicao = [];
            xhrGetDistribuicao.onreadystatechange = function(){
                if(xhrGetDistribuicao.readyState == 4){
                    if(xhrGetDistribuicao.status == 200){
                        cod_projeto = '';  
                        json_distribuicao = JSON.parse(xhrGetDistribuicao.responseText);
                        
                        

                        for(i=0;i<recebe_tb_pessoas.length;i++){
                            if(recebe_tb_pessoas[i]['pes_id'] == json_distribuicao['fk_pes_id']){
                                document.getElementById('listaPessoa').innerHTML = '';
                                document.getElementById('listaPessoa').innerHTML += '<option>'+recebe_tb_pessoas[i]['pes_nome']+'</option>';
                            }
                        }

                        
                        for(i=0;i<recebe_tb_tarefas.length;i++){
                            if(recebe_tb_tarefas[i]['trf_id'] == json_distribuicao['fk_trf_id']){
                                document.getElementById('listaTarefa').innerHTML = '';
                                document.getElementById('listaTarefa').innerHTML += '<option>'+recebe_tb_tarefas[i]['trf_name']+'</option>';
                                cod_projeto = recebe_tb_tarefas[i]['fk_prj_id'];
                            }
                        }

                        for(i=0;i<recebe_tb_projeto.length;i++){
                            if(recebe_tb_projeto[i]['prj_id'] == cod_projeto){
                                document.getElementById('selecionaProjeto_distribuicao').innerHTML = '';
                                document.getElementById('selecionaProjeto_distribuicao').innerHTML += '<option>'+recebe_tb_projeto[i]['prj_nome']+'</option>';
                            }
                        }
                        

                        carregaTabelaDistribuicao();
                        
                        
                        
                    }else if(xhrGetDistribuicao.status == 404){}

                    
                }
                
             
                
            }
            xhrGetDistribuicao.send();
    
    }
}

function postDistribuicao(){
   codPesTrf = document.getElementById('codDistribuicao').value;
   nome_tarefa = '';
   nome_pessoa = '';
   nome_tarefa = document.getElementById('listaTarefa').value;
   nome_pessoa = document.getElementById('listaPessoa').value;
  
   if(nome_tarefa == '' || nome_pessoa == ''){
    alert("Todos os campos devem ser preenchidos!!");
    }else{
   
   for(i=0;i<recebe_tb_tarefas.length;i++){
        if(nome_tarefa == recebe_tb_tarefas[i]['trf_name']){
            cod_tarefa = recebe_tb_tarefas[i]['trf_id'];
        }
   }

   for(i=0;i<recebe_tb_pessoas.length;i++){
    if(nome_pessoa == recebe_tb_pessoas[i]['pes_nome']){
        cod_pessoa = recebe_tb_pessoas[i]['pes_id'];
        }
    }
   

   
  
    xhrPostDistribuicao = new XMLHttpRequest();
    xhrPostDistribuicao.open("POST", URLGETDISTRIBUICAO, true);
    xhrPostDistribuicao.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrPostDistribuicao.setRequestHeader("X-CSRFToken", csrftoken)
    xhrPostDistribuicao.setRequestHeader("withCredentials", 'True');

    xhrPostDistribuicao.onload = function(){
        if(xhrPostDistribuicao.readyState == 4){
            if(xhrPostDistribuicao.status == 201){
                
                getDistribuicao();
                
                if((json.length+1) > 1){
                    habilitaRecuoCodDistribuicao();
                }
                
                desabilitaCamposDistribuicao();
                habilitaBtnNovaDistribuicao();
                desabilitaBtnGravaDistribuicao();
                desabilitaBtnCancelarDistribuicao();
                
                habilitaBtnExcluirDistribuicao();
                habilitaBtnAtualizarDistribuicao();   
               
            }else if(xhrPostDistribuicao.status == 400){
                limparCamposCadasDistribuicao();
                habilitaCamposDistribuicao();
                habilitaBtnGravarDistribuicao();
                habilitaBtnCancelarDistribuicao();
                desabilitaBtnExcluirDistribuicao();
                
                alert("Pessoa já inclusa nesta tarefa!");
                
            }
        }
    

    }
    xhrPostDistribuicao.send(JSON.stringify({
         'pes_trf_id': codPesTrf,
         'fk_pes_id': cod_pessoa,
         'fk_trf_id': cod_tarefa       
        }));

        
       
    }       
       
}

function putDistribuicao(){
    if(document.getElementById("selecionaProjeto_distribuicao").disabled == true){
        habilitaCamposDistribuicao();
        mudaBotao =  document.getElementById("btn_atualizarCadasDistribuicao");
        mudaBotao.style.backgroundColor = "green";
        dt_projetos_distribuicao();
        limparCamposCadasDistribuicao();

    }else{
        codPesTrf = document.getElementById('codDistribuicao').value;
        nome_tarefa = document.getElementById('listaTarefa').value;
        nome_pessoa = document.getElementById('listaPessoa').value;
        if(nome_tarefa == '' || nome_pessoa == ''){
            alert("Todos os campos devem ser preenchidos!!");
            }else{
        
        for(i=0;i<recebe_tb_tarefas.length;i++){
            if(nome_tarefa == recebe_tb_tarefas[i]['trf_name']){
                cod_tarefa = recebe_tb_tarefas[i]['trf_id'];
            }
       }
    
       for(i=0;i<recebe_tb_pessoas.length;i++){
        if(nome_pessoa == recebe_tb_pessoas[i]['pes_nome']){
            cod_pessoa = recebe_tb_pessoas[i]['pes_id'];
            }
        }
            
        xhrPutDistribuicao = new XMLHttpRequest();
    
        xhrPutDistribuicao.open("PUT", URLGETDISTRIBUICAO+codDistribuicao+'/', true);
        xhrPutDistribuicao.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhrPutDistribuicao.setRequestHeader("X-CSRFToken", csrftoken);
        xhrPutDistribuicao.setRequestHeader("withCredentials", 'True');
        xhrPutDistribuicao.onload = function(){
            if(xhrPutDistribuicao.readyState == 4){
                if(xhrPutDistribuicao.status == 200){
                    
                    getDistribuicao();
               }
            }
     }
        xhrPutDistribuicao.send(JSON.stringify({
            'pes_trf_id': codPesTrf,
            'fk_pes_id':  cod_pessoa,
            'fk_trf_id': cod_tarefa 
        }));

        mudaBotao =  document.getElementById("btn_atualizarCadasDistribuicao");
        mudaBotao.style.backgroundColor = "#698FEB";
        
        desabilitaCamposDistribuicao();
            }
    }

    
}

function deleteDistribuicao(){
    
    codPesTrf = document.getElementById('codDistribuicao').value;

    xhrDeleteDistribuicao = new XMLHttpRequest();
    xhrDeleteDistribuicao.open("DELETE", URLGETDISTRIBUICAO+codPesTrf, true);
    xhrDeleteDistribuicao.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrDeleteDistribuicao.setRequestHeader("X-CSRFToken", csrftoken);
    xhrDeleteDistribuicao.setRequestHeader("withCredentials", 'True');
    xhrDeleteDistribuicao.onreadystatechange = function(){
        if(xhrDeleteDistribuicao.readyState == 4){
            if(xhrDeleteDistribuicao.status == 204){
                carregaTabelaDistribuicao();
            }
        }
    }
    xhrDeleteDistribuicao.send(); 
    recuarCodDistribuicao(codPesTrf);
}
///////////////////////FINISH: GET - POST - PUT - DELETE //////////////////////////////////////////////////////////





/*CADASTRO DE DISTRIBUICAO DE PESSOAS EM TAREFAS*/////////////////////////////

function clicaDistribuicao(){
    document.getElementById("menu_superior").classList.remove("show");
    dialogCadastro = document.getElementById("distribuiPessoas");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();

    dt_projetos_distribuicao();
    dt_tarefas_distribuicao();
    dt_pessoas_distribuicao();

    xhrAbreDistribuicao = new XMLHttpRequest();
    xhrAbreDistribuicao.open('GET', URLGETDISTRIBUICAO, true);
    xhrAbreDistribuicao.onreadystatechange = function(){
        
        maiorvalor = 0;
        if(xhrAbreDistribuicao.readyState == 4){
            if(xhrAbreDistribuicao.status == 200){
                json = (JSON.parse(xhrAbreDistribuicao.responseText));

                for(i = 0; i<json.length;i++){
                   if(json[i]['pes_trf_id'] > maiorvalor ){
                        maiorvalor = json[i]['pes_trf_id'];
                    }              
                }
                if(maiorvalor == 0){
                    document.getElementById("codDistribuicao").value = 0;
                    limparCamposCadasDistribuicao();
                    desabilitaAvancoCodDistribuicao();
                    desabilitaBtnAtualizarDistribuicao();
                    desabilitaBtnCancelarDistribuicao();
                    desabilitaBtnGravaDistribuicao();
                    desabilitaBtnExcluirDistribuicao();
                    habilitaBtnNovaDistribuicao();
                    desabilitaCamposDistribuicao();
                    desabilitaRecuoCodDistribuicao();
                }else{
                    if(json.length == 1){
                        desabilitaAvancoCodDistribuicao();
                        desabilitaRecuoCodDistribuicao();
                    }else{
                        habilitaRecuoCodDistribuicao();
                    }
                    document.getElementById('codDistribuicao').value = maiorvalor;
                    getDistribuicao();
                    
                }

            }else if(xhrAbreDistribuicao.status == 404){}

            
        }
        
    }
    xhrAbreDistribuicao.send();
    
    
   
    desabilitaBtnCancelarDistribuicao();
    habilitaBtnNovaDistribuicao();
    desabilitaBtnGravaDistribuicao();
    desabilitaAvancoCodDistribuicao();
    carregaTabelaDistribuicao();
}

function novaDistribuicao(){
    
    codDistribuicao = parseInt(document.getElementById("codDistribuicao").value);
    
    if(codDistribuicao == 0){
        codDistribuicao = 1;
        document.getElementById("codDistribuicao").value = codDistribuicao;
        habilitaCamposDistribuicao();
    habilitaBtnCancelarDistribuicao();
    desabilitaBtnNovaDistribuicao();
    habilitaBtnGravarDistribuicao();
    desabilitaAvancoCodDistribuicao();
    desabilitaRecuoCodDistribuicao();
    limparCamposCadasDistribuicao();
    desabilitaBtnExcluirDistribuicao();
    desabilitaBtnAtualizarDistribuicao();
    }else{
    vetor_distribuicao = [];
    xhrNovaDistribuicao = new XMLHttpRequest();
    xhrNovaDistribuicao.open('GET', URLGETDISTRIBUICAO, true);
    
    xhrNovaDistribuicao.onreadystatechange = function(){     
        if(xhrNovaDistribuicao.readyState == 4){
            
            if(xhrNovaDistribuicao.status == 200){
                json = (JSON.parse(xhrNovaDistribuicao.responseText));  
                for(i = 0;i<json.length;i++){
                    vetor_distribuicao.push(json[i]['pes_trf_id']);
                    
                }
                vetor_distribuicao.reverse();
                
                codDistribuicao = vetor_distribuicao[0] + 1;
              }
        }
        document.getElementById("codDistribuicao").value = codDistribuicao;
    }
    xhrNovaDistribuicao.send();
}

dt_projetos_distribuicao();

habilitaCamposDistribuicao();
habilitaBtnCancelarDistribuicao();
desabilitaBtnNovaDistribuicao();
habilitaBtnGravarDistribuicao();
desabilitaAvancoCodDistribuicao();
desabilitaRecuoCodDistribuicao();
limparCamposCadasDistribuicao();
desabilitaBtnExcluirDistribuicao();
desabilitaBtnAtualizarDistribuicao();



}

function cancelarCadasDistribuicao(){
    codDistribuicao = parseInt(document.getElementById("codDistribuicao").value);
    document.getElementById("codDistribuicao").value = codDistribuicao - 1;
    
    desabilitaCamposDistribuicao();
    limparCamposCadasDistribuicao();   
    desabilitaBtnGravaDistribuicao();
    desabilitaBtnCancelarDistribuicao();
    habilitaRecuoCodDistribuicao();
    getDistribuicao();
    habilitaBtnNovaDistribuicao();
    habilitaBtnExcluirDistribuicao();
    habilitaBtnAtualizarDistribuicao();

   
   
}

function recuarCodDistribuicao(codAnterior){
    codDistribuicao = parseInt(document.getElementById("codDistribuicao").value);
    
    vetor_distribuicao = [];
    xhrRecuarCodDistribuicao = new XMLHttpRequest();
    xhrRecuarCodDistribuicao.open('GET', URLGETDISTRIBUICAO, true);
    xhrRecuarCodDistribuicao.onreadystatechange = function(){     
        if(xhrRecuarCodDistribuicao.readyState == 4){
            if(xhrRecuarCodDistribuicao.status == 200){
                json = (JSON.parse(xhrRecuarCodDistribuicao.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_distribuicao.push(json[i]['pes_trf_id']);
                    
                }
                 
                 menorvalor = vetor_distribuicao[0];
                 for(i=0;i<vetor_distribuicao.length;i++){

                    if(codDistribuicao == vetor_distribuicao[i]){
                        codDistribuicao = vetor_distribuicao[i-1];
                 }
                }
                document.getElementById("codDistribuicao").value = codDistribuicao;   
               
                if(codDistribuicao == menorvalor){
                    desabilitaRecuoCodDistribuicao();
                    
                }

                
               

                if(vetor_distribuicao.length > 1){
                    
                    habilitaAvancoCodDistribuicao();
                }
               
               //AÇÃO ABAIXO EM CONJUNTO COM O DELETE
                ///codAnterior vindo da function DELETE
                vetor_distribuicao.reverse();
                if(codAnterior != undefined){
                    if(codAnterior == vetor_distribuicao[0] && vetor_distribuicao.length == 1){

                        document.getElementById('codDistribuicao').value = 0;
                    }else{
                        
                        if(codAnterior == menorvalor){
                        
                            document.getElementById('codDistribuicao').value = vetor_distribuicao[0];
                            desabilitaAvancoCodDistribuicao();
                            
                            if(vetor_distribuicao.length > 2){
                                habilitaRecuoCodDistribuicao();
                            }
                            
                        }else{
                         for(i=0;i<vetor_distribuicao.length;i++){
                            if(codAnterior == vetor_distribuicao[0]){
                                vetor_distribuicao.splice(i,1);
                                
                                if(codDistribuicao == vetor_distribuicao[0]){
                                    desabilitaAvancoCodDistribuicao();
                                }                               
                            }   
                        }
                    }
                    }
                    
                }
            
                if(document.getElementById('codDistribuicao').value == 0){
                    limparCamposCadasDistribuicao();
                    desabilitaCamposDistribuicao();
                }else{
                    getDistribuicao();
                }
                
                
            }else if(xhrRecuarCodDistribuicao.status == 404){ }
        
            }
            
            
        }  
    

        xhrRecuarCodDistribuicao.send();
       
        

}

function avancarCodDistribuicao(){
    codDistribuicao = parseInt(document.getElementById("codDistribuicao").value);
    vetor_distribuicao = [];
    xhrAvancarDistribuicao = new XMLHttpRequest();
    xhrAvancarDistribuicao.open('GET', URLGETDISTRIBUICAO, true);
    xhrAvancarDistribuicao.onreadystatechange = function(){     
        if(xhrAvancarDistribuicao.readyState == 4){
            if(xhrAvancarDistribuicao.status == 200){
                json = (JSON.parse(xhrAvancarDistribuicao.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_distribuicao.push(json[i]['pes_trf_id']);
                    
                }
                
                vetor_distribuicao.reverse();
                 maiorvalor = 0;
                 for(i=0;i<vetor_distribuicao.length;i++){
                    
                    if(codDistribuicao == vetor_distribuicao[i]){
                        codDistribuicao = vetor_distribuicao[i-1];
                 }
                 if(vetor_distribuicao[i] > maiorvalor){
                    maiorvalor = vetor_distribuicao[i]; 
                }    

                }
                   
                document.getElementById("codDistribuicao").value = codDistribuicao;   
                
                if(codDistribuicao == maiorvalor){
                    desabilitaAvancoCodDistribuicao();
                }

                habilitaRecuoCodDistribuicao();
                getDistribuicao();
                }else if(xhrAvancarDistribuicao.status == 404){}
            }
        }
    
        
        xhrAvancarDistribuicao.send();
}



function desabilitaRecuoCodDistribuicao(){
        document.getElementById("codAnteriorDistribuicao").disabled = true;
      mudaBotao =  document.getElementById("codAnteriorDistribuicao");
        mudaBotao.style.backgroundColor = "gray";    
}

function desabilitaAvancoCodDistribuicao(){
  document.getElementById("codPosteriorDistribuicao").disabled = true;

       mudaBotao =  document.getElementById("codPosteriorDistribuicao");
        mudaBotao.style.backgroundColor = "gray";

}

function habilitaRecuoCodDistribuicao(){
    
    document.getElementById("codAnteriorDistribuicao").disabled = false;
    mudaBotao =  document.getElementById("codAnteriorDistribuicao");
    mudaBotao.style.backgroundColor = "#698FEB";
     

}

function habilitaAvancoCodDistribuicao(){
  document.getElementById("codPosteriorDistribuicao").disabled = false;
    mudaBotao =  document.getElementById("codPosteriorDistribuicao");
    mudaBotao.style.backgroundColor = "#698FEB";
}

function fecharCadastroDistribuicao(){
    dialogCadastro.close();
    limparCamposCadasDistribuicao();
    mudaBotao =  document.getElementById("btn_atualizarCadasDistribuicao");
    mudaBotao.style.backgroundColor = "#698FEB";
    

}

function habilitaBtnCancelarDistribuicao(){
    document.getElementById("btn_cancelarCadasDistribuicao").disabled = false;
    mudaBotao =  document.getElementById("btn_cancelarCadasDistribuicao");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnCancelarDistribuicao(){
    document.getElementById("btn_cancelarCadasDistribuicao").disabled = true;
     if(document.getElementById("btn_cancelarCadasDistribuicao").disabled = true){
       mudaBotao =  document.getElementById("btn_cancelarCadasDistribuicao");
        mudaBotao.style.backgroundColor = "gray";
}
}

function habilitaCamposDistribuicao(){
     document.getElementById("selecionaProjeto_distribuicao").disabled = false;
    document.getElementById("listaTarefa").disabled = false;   
    document.getElementById("listaPessoa").disabled = false;
}

function desabilitaCamposDistribuicao(){
    
    document.getElementById("selecionaProjeto_distribuicao").disabled = true;
    document.getElementById("listaTarefa").disabled = true;   
    document.getElementById("listaPessoa").disabled = true;
}

function habilitaBtnNovaDistribuicao(){
     document.getElementById("btn_novadistribuicao").disabled = false;
    mudaBotao =  document.getElementById("btn_novadistribuicao");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnNovaDistribuicao(){
    document.getElementById("btn_novadistribuicao").disabled = true;
    if(document.getElementById("btn_novadistribuicao").disabled = true){
       mudaBotao =  document.getElementById("btn_novadistribuicao");
        mudaBotao.style.backgroundColor = "gray";
    }
}

function desabilitaBtnGravaDistribuicao(){
    document.getElementById("btn_salvardistribuicao").disabled = true;
    if(document.getElementById("btn_salvardistribuicao").disabled = true){
       mudaBotao =  document.getElementById("btn_salvardistribuicao");
        mudaBotao.style.backgroundColor = "gray";
    }
}

function habilitaBtnGravarDistribuicao(){
    document.getElementById("btn_salvardistribuicao").disabled = false;
    mudaBotao =  document.getElementById("btn_salvardistribuicao");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function limparCamposCadasDistribuicao(){
    document.getElementById("selecionaProjeto_distribuicao").value = '';
    document.getElementById("listaTarefa").value = ''; 
    document.getElementById("listaPessoa").value = '';
   
    
   
}

function habilitaBtnAtualizarDistribuicao(){
        document.getElementById("btn_atualizarCadasDistribuicao").disabled = false;
     mudaBotao =  document.getElementById("btn_atualizarCadasDistribuicao");
     mudaBotao.style.backgroundColor = "#698FEB";
 }

 function desabilitaBtnAtualizarDistribuicao(){
    document.getElementById("btn_atualizarCadasDistribuicao").disabled = true;
 mudaBotao =  document.getElementById("btn_atualizarCadasDistribuicao");
 mudaBotao.style.backgroundColor = "gray";
}

 function desabilitaBtnExcluirDistribuicao(){
    document.getElementById("btn_excluirCadasDistribuicao").disabled = true;
    mudaBotao =  document.getElementById("btn_excluirCadasDistribuicao");
    mudaBotao.style.backgroundColor = "gray";
}

function habilitaBtnExcluirDistribuicao(){
    document.getElementById("btn_excluirCadasDistribuicao").disabled = false;
    mudaBotao =  document.getElementById("btn_excluirCadasDistribuicao");
        mudaBotao.style.backgroundColor = "#698FEB";
}




function carregaTabelaDistribuicao(){

    nomePessoa = '';
    nomeTarefa = '';
    nomeProjeto = '';
    codProjeto = '';
    corProjeto = '';
    vetor_tabela_distribuicao = [];
    codDistribuicao = parseInt(document.getElementById("codDistribuicao").value);
    vetor_tabelaDistribuicao = [];
    preparaVetor = [];
    xhrTabelaDistribuicao = new XMLHttpRequest();
    xhrTabelaDistribuicao.open('GET', URLGETDISTRIBUICAO, true);
    xhrTabelaDistribuicao.onreadystatechange = function(){     
        if(xhrTabelaDistribuicao.readyState == 4){
            if(xhrTabelaDistribuicao.status == 200){
                json_tabela_distribuicao = (JSON.parse(xhrTabelaDistribuicao.responseText));                 
                for(i = 0; i< json_tabela_distribuicao.length;i++){
                    for(x = 0; x < recebe_tb_pessoas.length;x++){
                        if(json_tabela_distribuicao[i]['fk_pes_id'] == recebe_tb_pessoas[x]['pes_id']){
                            nomePessoa = recebe_tb_pessoas[x]['pes_nome'];        
                        }
                    }
                    for(x = 0; x < recebe_tb_tarefas.length;x++){
                        if(json_tabela_distribuicao[i]['fk_trf_id'] == recebe_tb_tarefas[x]['trf_id']){
                            nomeTarefa = recebe_tb_tarefas[x]['trf_name']; 
                            codProjeto = recebe_tb_tarefas[x]['fk_prj_id'];
                            
                            for(z = 0; z< recebe_tb_projeto.length;z++){
                                
                                if(codProjeto == recebe_tb_projeto[z]['prj_id']){
                                    corProjeto = recebe_tb_projeto[z]['prj_color'];
                                    nomeProjeto = recebe_tb_projeto[z]['prj_nome'];
                                   
                                }
                            }
                            
                        }
                    }
                    preparaVetor = [nomePessoa,nomeTarefa, nomeProjeto, corProjeto];
                    vetor_tabela_distribuicao.push(preparaVetor);
                    
                }
                
                for(i = 0;i<vetor_tabela_distribuicao.length;i++){
                    linhaTabelaDistribuicao = ["<tr><td>"+vetor_tabela_distribuicao[i][0]+"</td><td>"+vetor_tabela_distribuicao[i][1]+"</td><td>"+vetor_tabela_distribuicao[i][2]+"</td><td bgcolor="+vetor_tabela_distribuicao[i][3]+"></td></tr>"];
                    vetor_tabelaDistribuicao.push(linhaTabelaDistribuicao);                  
                }
            }else if(xhrTabelaDistribuicao.status == 404){}
            }    
        document.getElementById("corpoTabelaDistribuicao").innerHTML = '';
    for(i = 0; i < vetor_tabelaDistribuicao.length;i++){
         document.getElementById("corpoTabelaDistribuicao").innerHTML += vetor_tabelaDistribuicao[i];
    }   
}
xhrTabelaDistribuicao.send();
}

/*///////////////////////////////////////*/


