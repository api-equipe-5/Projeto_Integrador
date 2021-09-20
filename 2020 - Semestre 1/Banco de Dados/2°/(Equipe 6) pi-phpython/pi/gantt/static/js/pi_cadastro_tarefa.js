/**ATENÇÃO!!!!!*/

/**ESTE ARQUIVO JAVASCRIPT FOI PROJETADO PARA TRATAR APENAS CADASTRO DE TAREFA */


/**CADASTRO DE TAREFAS *//////////////////////////////////////////////////////////////////

/*GET AND POST - API*////////////////////////////////////////////////////////////////////

////DATALIST

function carregaDatalistProjetos(){

    xhrCarregaDatalistProjeto = new XMLHttpRequest();
    xhrCarregaDatalistProjeto.open("GET", URLGETPROJETOS, true);
    xhrCarregaDatalistProjeto.onreadystatechange = function(){
        if(xhrCarregaDatalistProjeto.readyState == 4){
            if(xhrCarregaDatalistProjeto.status == 200){
            
            json_datalist_projetos = JSON.parse(xhrCarregaDatalistProjeto.responseText);
            
            
            document.getElementById("listaProjetos").innerHTML = '';
            linhaOption = "<option></option>"
            document.getElementById("listaProjetos").innerHTML += linhaOption;

            for(i=0;i<json_datalist_projetos.length;i++){
                linhaOption = "<option>"+json_datalist_projetos[i]['prj_nome']+"</option>"
                document.getElementById("listaProjetos").innerHTML += linhaOption;
            }

            selectDadosProjetos(json_datalist_projetos);

            }else if(xhrCarregaDatalistProjeto.status == 404){}
        }
}
xhrCarregaDatalistProjeto.send();
}

recebe_dados_projetos = [];
function selectDadosProjetos(json_datalist_projetos){
    if(json_datalist_projetos != null){
        recebe_dados_projetos = json_datalist_projetos;
    }
}


function carregaDatalistInterdependencia(){

    cod_projeto_datalist = '';
    xhrCarregaDatalistInterdependencia = new XMLHttpRequest();
    xhrCarregaDatalistInterdependencia.open("GET", URLGETTAREFAS, true);
    xhrCarregaDatalistInterdependencia.onreadystatechange = function(){
        if(xhrCarregaDatalistInterdependencia.readyState == 4){
            if(xhrCarregaDatalistInterdependencia.status == 200){
            json_datalist_interdependencia = JSON.parse(xhrCarregaDatalistInterdependencia.responseText);
            nomeprojetodatalist = document.getElementById("listaProjetos").value;
            for(i=0;i<recebe_dados_projetos.length;i++){
                if(nomeprojetodatalist == recebe_dados_projetos[i]['prj_nome']){
                    cod_projeto_datalist = recebe_dados_projetos[i]['prj_id'];
                }
            }

            document.getElementById("listaInterdependencia").innerHTML = '';
            linhaOption = "<option></option>"
            document.getElementById("listaInterdependencia").innerHTML += linhaOption;
            
                for(i=0;i<json_datalist_interdependencia.length;i++){
                    
                    if(cod_projeto_datalist == json_datalist_interdependencia[i]['fk_prj_id']){
                        
                    linhaOption = "<option>"+json_datalist_interdependencia[i]['trf_name']+"</option>"
                    document.getElementById("listaInterdependencia").innerHTML += linhaOption;
                    }
                }
            }else if(xhrCarregaDatalistInterdependencia.status == 404){}
        }
}
xhrCarregaDatalistInterdependencia.send();

}
///////////



function getNomeProjeto(){
    
    xhrGetProjeto = new XMLHttpRequest();
    xhrGetProjeto.open('GET', URLGETPROJETOS, true);
    
    xhrGetProjeto.onreadystatechange = function(){
        if(xhrGetProjeto.readyState == 4){
            if(xhrGetProjeto.status == 200){
                json = JSON.parse(xhrGetProjeto.responseText);
               /*  
                id_prj = document.getElementById("id_prj").innerHTML;
                for(i =0; i<json.length;i++){
                    if(id_prj == json[i]['prj_id']){
                        document.getElementById("selecionaProjeto").value = json[i]['prj_nome'];
                             
                    }
                }*/
                getAllProjects(); 
            }else if(xhrGetProjeto.status == 404){}
        }      
    }
    xhrGetProjeto.send();
    
}

function getAllTasks(){
    codTarefa = document.getElementById("codTarefa").value;
    
    
    xhrGetTarefa = new XMLHttpRequest();
    
    xhrGetTarefa.open('GET', URLGETTAREFAS, true);
    
    xhrGetTarefa.onreadystatechange = function(){
        if(xhrGetTarefa.readyState == 4){
            if(xhrGetTarefa.status == 200){
                vetor_tarefa = JSON.parse(xhrGetTarefa.responseText); 
                select_dados_tarefas(vetor_tarefa);
            }else if(xhrGetTarefa.status == 404){

            }
        }  
        vetorTrfCadastrados(null,vetor_tarefa)    
    }
    xhrGetTarefa.send();
}

recebe_dados_tarefas = [];
function select_dados_tarefas(vetor_tarefa){

    if(vetor_tarefa != null){
        recebe_dados_tarefas = vetor_tarefa;
    }
   

}

function getTarefa(){
    codTarefa = document.getElementById("codTarefa").value;
    
    if(codTarefa == "undefined"){
        document.getElementById("codTarefa").value = 0;
        limparCamposCadasTarefa();
        desabilitaAvancoCodTarefa();
        desabilitaBtnAtualizarTarefa();
        desabilitaBtnCancelarTarefa();
        desabilitaBtnGravaTarefa();
        desabilitaBtnExcluirTarefa();
        desabilitaCamposTarefa();
        desabilitaRecuoCodTarefa();

    }else{
        xhrGetTarefa = new XMLHttpRequest();
    
        xhrGetTarefa.open('GET', URLGETTAREFAS+codTarefa, true);
        
        
            xhrGetTarefa.onreadystatechange = function(){
                if(xhrGetTarefa.readyState == 4){
                    if(xhrGetTarefa.status == 200){
                        
                        json_get_tarefa = JSON.parse(xhrGetTarefa.responseText);
                        
                       
                        nome_tarefa_interdependencia = '';
                        nome_projeto_interdependencia = '';
                        for(i=0;i<recebe_dados_tarefas.length;i++){
                            if(json_get_tarefa['trf_interdependencia'] == recebe_dados_tarefas[i]['trf_id']){
                                
                                nome_tarefa_interdependencia = recebe_dados_tarefas[i]['trf_name'];
                                
                            }
                        }
                        

                        for(i=0;i<recebe_dados_projetos.length;i++){
                            if(json_get_tarefa['fk_prj_id'] == recebe_dados_projetos[i]['prj_id']){
                                nome_projeto_interdependencia = recebe_dados_projetos[i]['prj_nome'];
                            }
                        }

                        
                        document.getElementById('listaInterdependencia').value = nome_tarefa_interdependencia;
                        document.getElementById("nomeTarefa").value = json_get_tarefa['trf_name']; 
                        document.getElementById("dt_inicioTarefa").value = json_get_tarefa['trf_datainicial'];
                        document.getElementById("dt_finalTarefa").value = json_get_tarefa['trf_datafinal'];
                        document.getElementById("dt_prazoTarefa").value = json_get_tarefa['trf_prazo'];
                        document.getElementById("entregavel").checked =  json_get_tarefa['trf_entregavel'];
                        document.getElementById("listaProjetos").value = nome_projeto_interdependencia;
                        
                        
                        document.getElementById("progressotarefa").value = json_get_tarefa['trf_progresso'];
                        
                       
                        

                        getNomeProjeto();
                        getAllTasks();

                        
                    }else if(xhrGetTarefa.status == 404){}

                    
                }
                
             
                
            }
            xhrGetTarefa.send();
    
    }
}

function postTarefa(){

    cod_interdependencia_datalist = '';
    cod_Tarefa_datalist = '';
   
    nome_projeto_datalist = document.getElementById("listaProjetos").value;
    nome_interdependencia_datalist = document.getElementById("listaInterdependencia").value;
    codTarefa = document.getElementById("codTarefa").value;
    nomeTarefa =  document.getElementById("nomeTarefa").value;
    dt_inicioTarefa =  document.getElementById("dt_inicioTarefa").value;
    dt_finalTarefa = document.getElementById("dt_finalTarefa").value;
    dt_prazoTarefa = document.getElementById("dt_prazoTarefa").value;
    entregavel = document.getElementById("entregavel").checked;
    progressotarefa = document.getElementById("progressotarefa").value;

    if(nome_projeto_datalist == '' || nomeTarefa == '' || dt_inicioTarefa == '' || dt_finalTarefa == '' || dt_prazoTarefa == '' || progressotarefa == '' ){

        alert("Todos os campos devem ser preenchidos!!");
    }else{

            for(i=0;i<recebe_dados_projetos.length;i++){
                if(nome_projeto_datalist == recebe_dados_projetos[i]['prj_nome']){
                    cod_Tarefa_datalist = recebe_dados_projetos[i]['prj_id'];
                }
            }

            cod_interdependencia_datalist = 0;
            for(i=0;i<recebe_dados_tarefas.length;i++){
                 if(nome_interdependencia_datalist == recebe_dados_tarefas[i]['trf_name']){
                        cod_interdependencia_datalist = recebe_dados_tarefas[i]['trf_id'];
                }else if(nome_interdependencia_datalist == ''){
                    cod_interdependencia_datalist = 0;
                }
            }
            
            xhrPostTarefa = new XMLHttpRequest();
            xhrPostTarefa.open("POST", URLGETTAREFAS, true);
            xhrPostTarefa.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhrPostTarefa.setRequestHeader("X-CSRFToken", csrftoken);
            xhrPostTarefa.setRequestHeader("withCredentials", 'True');

            xhrPostTarefa.onreadystatechange = function(){
                if(xhrPostTarefa.readyState == 4){
                    if(xhrPostTarefa.status == 201){
                        
                        getTarefa();

                        if((json.length+1) > 1){
                            habilitaRecuoCodTarefa();
                        }
                        
                    }
                }
            

            }
            xhrPostTarefa.send(JSON.stringify({
                "trf_id": codTarefa,
                "trf_name": nomeTarefa,
                "trf_datainicial": dt_inicioTarefa,
                "trf_datafinal": dt_finalTarefa,
                "trf_prazo": dt_prazoTarefa,
                "trf_interdependencia": cod_interdependencia_datalist,
                "trf_entregavel": entregavel,
                "trf_progresso": progressotarefa,
                "fk_prj_id": cod_Tarefa_datalist
                }));
                
                desabilitaCamposTarefa();
                habilitaBtnNovaTarefa();
                desabilitaBtnGravaTarefa();
                desabilitaBtnCancelarTarefa();
               
                habilitaBtnExcluirTarefa();
                habilitaBtnAtualizarTarefa();
                getProjeto();
            }
}

function putTarefa(){

    if(document.getElementById("nomeTarefa").readOnly == true){
        habilitaCamposTarefa();
        
        mudaBotao =  document.getElementById("btn_atualizarCadasTarefa");
        mudaBotao.style.backgroundColor = "green";
        carregaDatalistInterdependencia();

    }else{

        cod_interdependencia_datalist = '';
        cod_Tarefa_datalist = '';
    
        nome_projeto_datalist = document.getElementById("listaProjetos").value;
        nome_interdependencia_datalist = document.getElementById("listaInterdependencia").value;
        codTarefa = document.getElementById("codTarefa").value;
        nomeTarefa =  document.getElementById("nomeTarefa").value;
        dt_inicioTarefa =  document.getElementById("dt_inicioTarefa").value;
        dt_finalTarefa = document.getElementById("dt_finalTarefa").value;
        dt_prazoTarefa = document.getElementById("dt_prazoTarefa").value;
        entregavel = document.getElementById("entregavel").checked;
        progressotarefa = document.getElementById("progressotarefa").value;

        if(nome_projeto_datalist == '' || nomeTarefa == '' || dt_inicioTarefa == '' || dt_finalTarefa == '' || dt_prazoTarefa == '' || progressotarefa == '' ){

            alert("Todos os campos devem ser preenchidos!!");
        }else{
        
   
            for(i=0;i<recebe_dados_projetos.length;i++){
                if(nome_projeto_datalist == recebe_dados_projetos[i]['prj_nome']){
                    cod_Tarefa_datalist = recebe_dados_projetos[i]['prj_id'];
                }
            }

            for(i=0;i<recebe_dados_tarefas.length;i++){
                if(nome_interdependencia_datalist == recebe_dados_tarefas[i]['trf_name']){
                        cod_interdependencia_datalist = recebe_dados_tarefas[i]['trf_id'];
                }else if(nome_interdependencia_datalist == ''){

                    cod_interdependencia_datalist = 0;
                }
            }
            

            xhrPutTarefa = new XMLHttpRequest();
        
            xhrPutTarefa.open("PUT", URLGETTAREFAS+codTarefa+'/', true);
            xhrPutTarefa.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhrPutTarefa.setRequestHeader("X-CSRFToken", csrftoken);
            xhrPutTarefa.setRequestHeader("withCredentials", 'True');
            xhrPutTarefa.onload = function(){
                if(xhrPutTarefa.readyState == 4){
                    if(xhrPutTarefa.status == 200){
                        
                        getTarefa();
                        
                        
                    }
                }
            

            }   
            xhrPutTarefa.send(JSON.stringify({
                "trf_id": codTarefa,
                "trf_name": nomeTarefa,
                "trf_datainicial": dt_inicioTarefa,
                "trf_datafinal": dt_finalTarefa,
                "trf_prazo": dt_prazoTarefa,
                "trf_interdependencia": cod_interdependencia_datalist,
                "trf_entregavel": entregavel,
                "trf_progresso": progressotarefa,
                "fk_prj_id": cod_Tarefa_datalist
            }));

            mudaBotao =  document.getElementById("btn_atualizarCadasTarefa");
            mudaBotao.style.backgroundColor = "#698FEB";
            
            desabilitaCamposTarefa();
        

            }
        }
            
}

// dsajidasdiasdias
function putAtualizaTarefa(tarefa){
    xhrPutTarefa = new XMLHttpRequest();
        
    xhrPutTarefa.open("PUT", URLGETTAREFAS+tarefa.trf_id+'/', true);
    xhrPutTarefa.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrPutTarefa.setRequestHeader("X-CSRFToken", csrftoken);
    xhrPutTarefa.setRequestHeader("withCredentials", 'True');
    xhrPutTarefa.send(JSON.stringify(tarefa));
}



// dasjiasjidsajidsaijd




function deleteTarefa(){
    
    codTarefa = document.getElementById("codTarefa").value;

    xhrDeleteTarefa = new XMLHttpRequest();
    xhrDeleteTarefa.open("DELETE", URLGETTAREFAS+codTarefa, true);
    xhrDeleteTarefa.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrDeleteTarefa.setRequestHeader("X-CSRFToken", csrftoken);
    xhrDeleteTarefa.setRequestHeader("withCredentials", 'True');
    xhrDeleteTarefa.onreadystatechange = function () {
        if(xhrDeleteTarefa.readyState == 4){
            if(xhrDeleteTarefa.status == 204){
                
                         
            }
        }
        
    }
    xhrDeleteTarefa.send(); 
    recuarCodTarefa(codTarefa);  
    
    
            
    
}
///////////////////////FINISH: GET - POST - PUT - DELETE //////////////////////////////////////////////////////////

vetor_tarefa = [];

function clicaTarefa(){
    document.getElementById("menu_superior").classList.remove("show");
    dialogCadastro = document.getElementById("abreCadastroTarefa");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();
    xhrAbreTarefa = new XMLHttpRequest();
    xhrAbreTarefa.open('GET', URLGETTAREFAS, true);
    
    xhrAbreTarefa.onreadystatechange = function(){
        
        maiorvalor = 0;
        if(xhrAbreTarefa.readyState == 4){
            if(xhrAbreTarefa.status == 200){
                json = (JSON.parse(xhrAbreTarefa.responseText));

                for(i = 0; i<json.length;i++){
                   if(json[i]['trf_id'] > maiorvalor ){
                        maiorvalor = json[i]['trf_id'];
                    }              
                }
                if(maiorvalor == 0){
                    document.getElementById("codTarefa").value = 0;
                    limparCamposCadasTarefa();
                    desabilitaAvancoCodTarefa();
                    desabilitaBtnAtualizarTarefa();
                    desabilitaBtnCancelarTarefa();
                    desabilitaBtnGravaTarefa();
                    desabilitaBtnExcluirTarefa();
                    habilitaBtnNovaTarefa();
                    desabilitaCamposTarefa();
                    desabilitaRecuoCodTarefa();
                }else{
                    if(json.length == 1){
                        desabilitaAvancoCodTarefa();
                        desabilitaRecuoCodTarefa();
                    }else{
                        habilitaRecuoCodTarefa();
                    }
                    document.getElementById('codTarefa').value = maiorvalor;
                    
                    getTarefa();
                    
                   
                }

            }else if(xhrAbreTarefa.status == 404){}

            
        }
        
    }
    
    xhrAbreTarefa.send();
    desabilitaBtnCancelarTarefa();
    habilitaBtnNovaTarefa();
    desabilitaBtnGravaTarefa();
    desabilitaAvancoCodTarefa();
    carregaDatalistProjetos();
    
    
}

function novaTarefa(){
    
    codTarefa = parseInt(document.getElementById("codTarefa").value);
    
    if(codTarefa == 0){
        codTarefa = 1;
        document.getElementById("codTarefa").value = codTarefa;
        habilitaCamposTarefa();
        habilitaBtnCancelarTarefa();
        desabilitaBtnNovaTarefa();
        habilitaBtnGravarTarefa();
        desabilitaAvancoCodTarefa();
        desabilitaRecuoCodTarefa();
        limparCamposCadasTarefa();
        desabilitaBtnExcluirTarefa();
        desabilitaBtnAtualizarTarefa();
    
    }else{
    vetor_tarefa = [];
    xhrNovaTarefa = new XMLHttpRequest();
    xhrNovaTarefa.open('GET', URLGETTAREFAS, true);
    
    xhrNovaTarefa.onreadystatechange = function(){     
        if(xhrNovaTarefa.readyState == 4){
            
            if(xhrNovaTarefa.status == 200){
                json = (JSON.parse(xhrNovaTarefa.responseText));
                
                for(i = 0;i<json.length;i++){
                    vetor_tarefa.push(json[i]['trf_id']);
                    
                }
                vetor_tarefa.reverse();
                codTarefa = vetor_tarefa[0] + 1;
              }
        }
        document.getElementById("codTarefa").value = codTarefa;
    }
    xhrNovaTarefa.send();
    
}

habilitaCamposTarefa();
habilitaBtnCancelarTarefa();
desabilitaBtnNovaTarefa();
habilitaBtnGravarTarefa();
desabilitaAvancoCodTarefa();
desabilitaRecuoCodTarefa();
limparCamposCadasTarefa();
desabilitaBtnExcluirTarefa();
desabilitaBtnAtualizarTarefa();

}

function cancelarCadasTarefa(){
    codTarefa = parseInt(document.getElementById("codTarefa").value);
    document.getElementById("codTarefa").value = codTarefa - 1;
    
    desabilitaCamposTarefa();
    
    desabilitaBtnGravaTarefa();
    desabilitaBtnCancelarTarefa();
    habilitaRecuoCodTarefa();
    getTarefa();
    habilitaBtnNovaTarefa();
    habilitaBtnExcluirTarefa();
    habilitaBtnAtualizarTarefa();
   
}

function recuarCodTarefa(codAnterior){
    codTarefa = parseInt(document.getElementById("codTarefa").value);
    
    vetor_tarefa = [];
    xhrRecuarCod = new XMLHttpRequest();
    xhrRecuarCod.open('GET', URLGETTAREFAS, true);
    xhrRecuarCod.onreadystatechange = function(){     
        if(xhrRecuarCod.readyState == 4){
            if(xhrRecuarCod.status == 200){
                json = (JSON.parse(xhrRecuarCod.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_tarefa.push(json[i]['trf_id']);
                    
                }
                 
                 menorvalor = vetor_tarefa[0];
                 for(i=0;i<vetor_tarefa.length;i++){

                    if(codTarefa == vetor_tarefa[i]){
                    codTarefa = vetor_tarefa[i-1];
                 }
                 

                }
                document.getElementById("codTarefa").value = codTarefa;   
          
                if(codTarefa == menorvalor){
                    desabilitaRecuoCodTarefa();
                    
                }

                if(vetor_tarefa.length > 1){
                    habilitaAvancoCodTarefa();
                }

               
               
               //AÇÃO ABAIXO EM CONJUNTO COM O DELETE
                ///codAnterior vindo da function DELETE
                vetor_tarefa.reverse();
                if(codAnterior != undefined){
                    if(codAnterior == vetor_tarefa[0] && vetor_tarefa.length == 1){

                        document.getElementById('codTarefa').value = 0;
                    }else{
                        
                        if(codAnterior == menorvalor){
                        
                            document.getElementById('codTarefa').value = vetor_tarefa[0];
                            desabilitaAvancoCodTarefa();
                            
                            if(vetor_tarefa.length > 2){
                                habilitaRecuoCodTarefa();
                            }
                            
                        }else{
                         for(i=0;i<vetor_tarefa.length;i++){
                            if(codAnterior == vetor_tarefa[0]){
                                vetor_tarefa.splice(i,1);
                                
                                if(codTarefa == vetor_tarefa[0]){
                                    desabilitaAvancoCodTarefa();
                                }                               
                            }   
                        }
                    }
                    }
                    
                }
            
                if(document.getElementById('codTarefa').value == 0){
                    limparCamposCadasTarefa();
                    desabilitaCamposTarefa();
                    
                }else{
                    getTarefa();
                }
                
                
            }else if(xhrRecuarCod.status == 404){ }
        
            }
            
            
        }  
    
    

        xhrRecuarCod.send();
        

}

function avancarCodTarefa(){
    codTarefa = parseInt(document.getElementById("codTarefa").value);
    vetor_tarefa = [];
    xhrAvancarTarefa = new XMLHttpRequest();
    xhrAvancarTarefa.open('GET', URLGETTAREFAS, true);
    xhrAvancarTarefa.onreadystatechange = function(){     
        if(xhrAvancarTarefa.readyState == 4){
            if(xhrAvancarTarefa.status == 200){
                json = (JSON.parse(xhrAvancarTarefa.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_tarefa.push(json[i]['trf_id']);
                    
                }
                
                vetor_tarefa.reverse();
                 maiorvalor = 0;
                 for(i=0;i<vetor_tarefa.length;i++){
                    
                    if(codTarefa == vetor_tarefa[i]){
                    codTarefa = vetor_tarefa[i-1];
                 }
                 if(vetor_tarefa[i] > maiorvalor){
                    maiorvalor = vetor_tarefa[i]; 
                }    

                }
                   
                      document.getElementById("codTarefa").value = codTarefa;   
                if(codTarefa == maiorvalor){
                    desabilitaAvancoCodTarefa();
                }
                habilitaRecuoCodTarefa();
                getTarefa();
                }else if(xhrAvancarTarefa.status == 404){}
            }
        }
    
        
        xhrAvancarTarefa.send();
}



function desabilitaRecuoCodTarefa(){
        document.getElementById("codAnteriorCadasTarefa").disabled = true;
     if(document.getElementById("codAnteriorCadasTarefa").disabled = true){
       mudaBotao =  document.getElementById("codAnteriorCadasTarefa");
        mudaBotao.style.backgroundColor = "gray";
}
    
}

function desabilitaAvancoCodTarefa(){
  document.getElementById("codPosteriorCadasTarefa").disabled = true;
     if(document.getElementById("codPosteriorCadasTarefa").disabled = true){
       mudaBotao =  document.getElementById("codPosteriorCadasTarefa");
        mudaBotao.style.backgroundColor = "gray";
}
}

function habilitaRecuoCodTarefa(){
   
   if(document.getElementById("codTarefa").value > 1){ document.getElementById("codAnteriorCadasTarefa").disabled = false;
    mudaBotao =  document.getElementById("codAnteriorCadasTarefa");
    mudaBotao.style.backgroundColor = "#698FEB";
     
}
}

function habilitaAvancoCodTarefa(){
  document.getElementById("codPosteriorCadasTarefa").disabled = false;
    mudaBotao =  document.getElementById("codPosteriorCadasTarefa");
    mudaBotao.style.backgroundColor = "#698FEB";
}

function fecharCadastroTarefa(){
    dialogCadastro.close();
    limparCamposCadasTarefa();
}

function habilitaBtnCancelarTarefa(){
    document.getElementById("btn_cancelarCadasTarefa").disabled = false;
    mudaBotao =  document.getElementById("btn_cancelarCadasTarefa");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnCancelarTarefa(){
    document.getElementById("btn_cancelarCadasTarefa").disabled = true;
     if(document.getElementById("btn_cancelarCadasTarefa").disabled = true){
       mudaBotao =  document.getElementById("btn_cancelarCadasTarefa");
        mudaBotao.style.backgroundColor = "gray";
}
}

function habilitaCamposTarefa(){
    document.getElementById("listaProjetos").disabled = false;
    document.getElementById("listaInterdependencia").disabled = false;   
    document.getElementById("nomeTarefa").readOnly = false;
    document.getElementById("dt_inicioTarefa").readOnly = false;
    document.getElementById("dt_finalTarefa").readOnly = false;
    document.getElementById("dt_prazoTarefa").readOnly = false;
    document.getElementById("entregavel").disabled = false;
    document.getElementById("progressotarefa").disabled = false;

}

function desabilitaCamposTarefa(){
    limparCamposCadasTarefa();
    document.getElementById("listaProjetos").disabled = true; 
    document.getElementById("listaInterdependencia").disabled = true; 
    document.getElementById("nomeTarefa").readOnly = true;
    document.getElementById("dt_inicioTarefa").readOnly = true;
    document.getElementById("dt_finalTarefa").readOnly = true;
    document.getElementById("dt_prazoTarefa").readOnly = true;
    document.getElementById("entregavel").disabled = true;  
    document.getElementById("progressotarefa").disabled = true;
    
}

function habilitaBtnNovaTarefa(){
     document.getElementById("btn_novatarefa").disabled = false;
    mudaBotao =  document.getElementById("btn_novatarefa");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnNovaTarefa(){
    document.getElementById("btn_novatarefa").disabled = true;
    if(document.getElementById("btn_novatarefa").disabled = true){
       mudaBotao =  document.getElementById("btn_novatarefa");
        mudaBotao.style.backgroundColor = "gray";
    }
}

function desabilitaBtnGravaTarefa(){
    document.getElementById("btn_salvartarefa").disabled = true;
    if(document.getElementById("btn_salvartarefa").disabled = true){
       mudaBotao =  document.getElementById("btn_salvartarefa");
        mudaBotao.style.backgroundColor = "gray";
    }
}

function habilitaBtnGravarTarefa(){
    document.getElementById("btn_salvartarefa").disabled = false;
    mudaBotao =  document.getElementById("btn_salvartarefa");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function limparCamposCadasTarefa(){
    document.getElementById("listaProjetos").value = '';
    document.getElementById("listaInterdependencia").value = '';
    document.getElementById("nomeTarefa").value = '';
    document.getElementById("dt_inicioTarefa").value = '';
     document.getElementById("dt_finalTarefa").value = '';
    document.getElementById("dt_prazoTarefa").value = '';
    document.getElementById("progressotarefa").value = 0;
    
   
}

function desabilitaBtnAtualizarTarefa(){
    document.getElementById("btn_atualizarCadasTarefa").disabled = true;
 
   mudaBotao =  document.getElementById("btn_atualizarCadasTarefa");
    mudaBotao.style.backgroundColor = "gray";
}

function habilitaBtnAtualizarTarefa(){
        document.getElementById("btn_atualizarCadasTarefa").disabled = false;
     mudaBotao =  document.getElementById("btn_atualizarCadasTarefa");
     mudaBotao.style.backgroundColor = "#698FEB";
 }

 function desabilitaBtnExcluirTarefa(){
    document.getElementById("btn_excluirCadasTarefa").disabled = true;
    mudaBotao =  document.getElementById("btn_excluirCadasTarefa");
    mudaBotao.style.backgroundColor = "gray";
}

function habilitaBtnExcluirTarefa(){
    document.getElementById("btn_excluirCadasTarefa").disabled = false;
    mudaBotao =  document.getElementById("btn_excluirCadasTarefa");
        mudaBotao.style.backgroundColor = "#698FEB";
}

/*///////////////////////////////////////*/
