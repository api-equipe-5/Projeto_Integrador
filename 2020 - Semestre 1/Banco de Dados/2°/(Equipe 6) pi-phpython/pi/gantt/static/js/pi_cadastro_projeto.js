/**ATENÇÃO!!!!!*/

/**ESTE ARQUIVO JAVASCRIPT FOI PROJETADO PARA TRATAR APENAS CADASTRO DE PROJETO */

/**AS FUNCTIONS PARA ADIÇÃO DE BOTÕES NO MENU LATERAL ESQUERDO SE ENCONTRAM NESTE ARQUIVO JS */

/*CADASTRO DE PROJETOS*//////////////////////////////////////////////////////////////////

/*GET AND POST - API*////////////////////////////////////////////////////////////////////
vetor_prjcadastrados = [];
vetor_trfcadastrados = [];


function preencheCamposCadasProjeto(json){
    
    document.getElementById("nomeProjeto").value = json.prj_nome; 
    document.getElementById("escopo").value = json.prj_escopo;
    document.getElementById("dt_inicioProjeto").value = json.prj_datainicio;
    document.getElementById("dt_prazoProjeto").value = json.prj_prazoentrega;
    document.getElementById("corProjeto").value = json.prj_color;
    document.getElementById("progressoprojeto").value = json.prj_progresso; 
    document.getElementById("custo").value = json.prj_cost;
    document.getElementById("horas_desenvolvimento").value = json.prj_hrs_dev; 


}

function getAllProjects(){
    
    
    
    xhrGetProjeto = new XMLHttpRequest();
    
    json = '';
    xhrGetProjeto.open('GET', URLGETPROJETOS, true);
    
    xhrGetProjeto.onreadystatechange = function(){
        if(xhrGetProjeto.readyState == 4){
            if(xhrGetProjeto.status == 200){
                json = (JSON.parse(xhrGetProjeto.responseText));
            }else if(xhrGetProjeto.status == 404){

            }
        }      
        add_prj_menu_esquerdo(json);
    }
    xhrGetProjeto.send();
}

function getProjeto(){
    codProjeto = document.getElementById("codProjeto").value;
    

    if(codProjeto == "undefined"){
        document.getElementById("codProjeto").value = 0;
        limparCamposCadasProjeto();
        desabilitaAvancoCodProjeto();
        desabilitaBtnAtualizarProjeto();
        desabilitaBtnCancelarProjeto();
        desabilitaBtnGravaProjeto();
        desabilitaBtnExcluirProjeto();
        desabilitaCamposProjeto();
        desabilitaRecuoCodProjeto();

    }else{
    
    
    xhrGetProjeto = new XMLHttpRequest();
    
    xhrGetProjeto.open('GET', URLGETPROJETOS+codProjeto, true);
    xhrGetProjeto.onreadystatechange = function(){
        if(xhrGetProjeto.readyState == 4){
            if(xhrGetProjeto.status == 200){
                preencheCamposCadasProjeto(JSON.parse(xhrGetProjeto.responseText));     
                getAllProjects();
                
            }else if(xhrGetProjeto.status == 404){

            }
        }      
        
    }
    xhrGetProjeto.send();

   
    }
}


function postProjeto(){
    codProjeto = document.getElementById("codProjeto").value;
    nomeProjeto = document.getElementById("nomeProjeto").value;
    escopo = document.getElementById("escopo").value;
    dt_inicio = document.getElementById("dt_inicioProjeto").value;
    dt_prazo = document.getElementById("dt_prazoProjeto").value;
    cor = document.getElementById("corProjeto").value;
    progressoprojeto = document.getElementById("progressoprojeto").value;
    custo = document.getElementById("custo").value;
    horas_desen = document.getElementById("horas_desenvolvimento").value;
    
    if(nomeProjeto == '' || escopo == '' || dt_inicio == '' || dt_prazo == '' || custo == '' || horas_desen == '' ){
        alert("Todos os campos devem ser preenchidos!!");
    }else{

    xhrPostProjeto = new XMLHttpRequest();
    
    xhrPostProjeto.open("POST", URLGETPROJETOS, true);
    xhrPostProjeto.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrPostProjeto.setRequestHeader("X-CSRFToken", csrftoken);
    xhrPostProjeto.setRequestHeader("withCredentials", 'True');
    xhrPostProjeto.onreadystatechange = function(){
        if(xhrPostProjeto.readyState == 4){
            if(xhrPostProjeto.status == 201){
                
                getProjeto();
                carregaTabelaProjeto();
                
                
                if((json.length+1) > 1){
                    habilitaRecuoCodProjeto();
                }
                
            }
        }
    

    }
    xhrPostProjeto.send(JSON.stringify({
         'prj_id': codProjeto,
         'prj_nome': nomeProjeto, 
         'prj_escopo': escopo, 
         'prj_datainicio': dt_inicio,
         'prj_prazoentrega': dt_prazo,
         'prj_color': cor,
         "prj_cost": custo,
         "prj_hrs_dev": horas_desen,
         "prj_progresso": progressoprojeto
        }));
    
    
        desabilitaCamposProjeto();
        habilitaBtnNovoProjeto();
        desabilitaBtnGravaProjeto();
        desabilitaBtnCancelarProjeto();
        
        habilitaBtnExcluirProjeto();
        habilitaBtnAtualizarProjeto();
    }
}

function putProjeto(){
    if(document.getElementById("nomeProjeto").readOnly == true){
        habilitaCamposProjeto();
        mudaBotao =  document.getElementById("btn_atualizarCadasProjeto");
        mudaBotao.style.backgroundColor = "green";

    }else{
        codProjeto = document.getElementById("codProjeto").value;
    
    nomeProjeto = document.getElementById("nomeProjeto").value;
    escopo = document.getElementById("escopo").value;
    dt_inicio = document.getElementById("dt_inicioProjeto").value;
    dt_prazo = document.getElementById("dt_prazoProjeto").value;
    cor = document.getElementById("corProjeto").value;
    progressoprojeto = document.getElementById("progressoprojeto").value;
    
    custo = document.getElementById("custo").value;
    horas_desen = document.getElementById("horas_desenvolvimento").value;
    
    if(nomeProjeto == '' || escopo == '' || dt_inicio == '' || dt_prazo == '' || custo == '' || horas_desen == '' ){
        alert("Todos os campos devem ser preenchidos!!");
    }else{

    xhrPutProjeto = new XMLHttpRequest();
   
    xhrPutProjeto.open("PUT", URLGETPROJETOS+codProjeto+'/', true);
    xhrPutProjeto.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrPutProjeto.setRequestHeader("X-CSRFToken", csrftoken);
    xhrPutProjeto.setRequestHeader("withCredentials", 'True');
    xhrPutProjeto.onload = function(){
        if(xhrPutProjeto.readyState == 4){
            if(xhrPutProjeto.status == 200){
                
                getProjeto();
                carregaTabelaProjeto();
                
                
            }
        }
    

    }   
    xhrPutProjeto.send(JSON.stringify({
        'prj_id': codProjeto,
        'prj_nome': nomeProjeto, 
        'prj_escopo': escopo, 
        'prj_datainicio': dt_inicio,
        'prj_prazoentrega': dt_prazo,
        'prj_color': cor,
        "prj_cost": custo,
        "prj_hrs_dev": horas_desen,
        "prj_progresso": progressoprojeto
       }));

    mudaBotao =  document.getElementById("btn_atualizarCadasProjeto");
    mudaBotao.style.backgroundColor = "#698FEB";
    
    desabilitaCamposProjeto();
    
    }

}
}

function deleteProjeto(){
    codProjeto = document.getElementById("codProjeto").value;
    

    xhrDeleteProjeto = new XMLHttpRequest();
    xhrDeleteProjeto.open("DELETE", URLGETPROJETOS+codProjeto, true);
    xhrDeleteProjeto.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhrDeleteProjeto.setRequestHeader("X-CSRFToken", csrftoken)
    xhrDeleteProjeto.setRequestHeader("withCredentials", 'True');
    xhrDeleteProjeto.onreadystatechange = function () {
        if(xhrDeleteProjeto.readyState == 4){
            if(xhrDeleteProjeto.status == 204){
               
               
                carregaTabelaProjeto();
                
                         
            }
        }
        
    }

    xhrDeleteProjeto.send();
    recuarCodProjeto(codProjeto);
    
     
      
}
///////////////////////FINISH: GET - POST - PUT - DELETE //////////////////////////////////////////////////////////


function clicaProjeto(){
    document.getElementById("menu_superior").classList.remove("show");
    dialogCadastro = document.getElementById("abreCadastroProjeto");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();
    
    xhrAbreProjeto = new XMLHttpRequest();
    xhrAbreProjeto.open('GET', URLGETPROJETOS, true);
    xhrAbreProjeto.onreadystatechange = function(){
        
        maiorvalor = 0;
        if(xhrAbreProjeto.readyState == 4){
            if(xhrAbreProjeto.status == 200){
                json_projetos = (JSON.parse(xhrAbreProjeto.responseText));

                for(i = 0; i<json_projetos.length;i++){
                   if(json_projetos[i]['prj_id'] > maiorvalor ){
                        maiorvalor = json_projetos[i]['prj_id'];
                    }              
                }
                
                if(maiorvalor == 0){
                    document.getElementById("codProjeto").value = 0;
                    limparCamposCadasProjeto();
                    desabilitaAvancoCodProjeto();
                    desabilitaBtnAtualizarProjeto();
                    desabilitaBtnCancelarProjeto();
                    desabilitaBtnGravaProjeto();
                    desabilitaBtnExcluirProjeto();
                    habilitaBtnNovoProjeto();
                    desabilitaCamposProjeto();
                    desabilitaRecuoCodProjeto();
                }else{
                    if(json_projetos.length == 1){
                        desabilitaAvancoCodProjeto();
                        desabilitaRecuoCodProjeto();
                    }else{
                        habilitaRecuoCodProjeto();
                    }
                    document.getElementById('codProjeto').value = maiorvalor;
                    getProjeto();
                }

            }else if(xhrAbreProjeto.status == 404){}            
        }    
    }
    xhrAbreProjeto.send();
 
    desabilitaBtnCancelarProjeto();
    habilitaBtnNovoProjeto();
    desabilitaBtnGravaProjeto();
    desabilitaAvancoCodProjeto();
    carregaTabelaProjeto();
}

function novoProjeto(){
    codProjeto = parseInt(document.getElementById("codProjeto").value);
    if(codProjeto == 0){
        codProjeto = 1;
        document.getElementById("codProjeto").value = codProjeto;
        habilitaCamposProjeto();
        habilitaBtnCancelarProjeto();
        desabilitaBtnNovoProjeto();
        habilitaBtnGravarProjeto();
        desabilitaAvancoCodProjeto();
        desabilitaRecuoCodProjeto();
        limparCamposCadasProjeto();
        desabilitaBtnExcluirProjeto();
        desabilitaBtnAtualizarProjeto();
    }else{
    
     
    vetor_projeto = [];
    xhrNovoProjeto = new XMLHttpRequest();
    xhrNovoProjeto.open('GET', URLGETPROJETOS, true);
    xhrNovoProjeto.onreadystatechange = function(){     
        if(xhrNovoProjeto.readyState == 4){
            if(xhrNovoProjeto.status == 200){
                json = (JSON.parse(xhrNovoProjeto.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_projeto.push(json[i]['prj_id']);
                    
                }
                vetor_projeto.reverse();
                codProjeto = vetor_projeto[0] + 1;
              }
        }
        document.getElementById("codProjeto").value = codProjeto;
    }

    xhrNovoProjeto.send();
    }
  
    
    habilitaCamposProjeto();
    habilitaBtnCancelarProjeto();
    desabilitaBtnNovoProjeto();
    habilitaBtnGravarProjeto();
    desabilitaAvancoCodProjeto();
    desabilitaRecuoCodProjeto();
    limparCamposCadasProjeto();
    desabilitaBtnExcluirProjeto();
    desabilitaBtnAtualizarProjeto();
    
        
        
}


function cancelarCadasProjeto(){
    codProjeto = parseInt(document.getElementById("codProjeto").value);
    document.getElementById("codProjeto").value = codProjeto - 1;
    getProjeto();
    desabilitaCamposProjeto();
    
    desabilitaBtnGravaProjeto();
    desabilitaBtnCancelarProjeto();
    habilitaRecuoCodProjeto();
    
    habilitaBtnNovoProjeto();
    habilitaBtnExcluirProjeto();
    habilitaBtnAtualizarProjeto();
}

function recuarCodProjeto(codAnterior){
    
    codProjeto = parseInt(document.getElementById("codProjeto").value);
    vetor_projeto = [];
    xhrRecuarCod = new XMLHttpRequest();
    xhrRecuarCod.open('GET', URLGETPROJETOS, true);
    xhrRecuarCod.onreadystatechange = function(){     
        if(xhrRecuarCod.readyState == 4){
            if(xhrRecuarCod.status == 200){
                json = (JSON.parse(xhrRecuarCod.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_projeto.push(json[i]['prj_id']);
                    
                }
                 
                    menorvalor = vetor_projeto[0];
                    for(i=0;i<vetor_projeto.length;i++){

                        if(codProjeto == vetor_projeto[i]){
                        codProjeto = vetor_projeto[i-1];
                    }
                }
                  
                document.getElementById("codProjeto").value = codProjeto;   
                
                if(codProjeto == menorvalor){
                    desabilitaRecuoCodProjeto();
                    
                }

                if(vetor_projeto.length > 1){
                    habilitaAvancoCodProjeto();
                }

              
               
               //AÇÃO ABAIXO EM CONJUNTO COM O DELETE
                ///codAnterior vindo da function DELETE
                vetor_projeto.reverse();
                if(codAnterior != undefined){
                    if(codAnterior == vetor_projeto[0] && vetor_projeto.length == 1){

                        document.getElementById('codProjeto').value = 0;
                    }else{
                        
                        if(codAnterior == menorvalor){
                        
                            document.getElementById('codProjeto').value = vetor_projeto[0];
                            desabilitaAvancoCodProjeto();
                            
                            if(vetor_projeto.length > 2){
                                habilitaRecuoCodProjeto();
                            }
                            
                        }else{
                        
                         for(i=0;i<vetor_projeto.length;i++){
                            if(codAnterior == vetor_projeto[0]){
                                vetor_projeto.splice(i,1);
                                
                                if(codProjeto == vetor_projeto[0]){
                                    desabilitaAvancoCodProjeto();
                                }                               
                            }   
                        }
                    }
                    }
                    
                }
            
                if(document.getElementById('codProjeto').value == 0){
                    limparCamposCadasProjeto();
                    desabilitaCamposProjeto();
                    getAllProjects();
                }else{
                    getProjeto();
                }
                
                
            }else if(xhrRecuarCod.status == 404){ }
        
            }
            
            
        }  
    

        xhrRecuarCod.send();
       
}

function avancarCodProjeto(){
    codProjeto = parseInt(document.getElementById("codProjeto").value);
    vetor_projeto = [];
    xhrAvancarProjeto = new XMLHttpRequest();
    xhrAvancarProjeto.open('GET', URLGETPROJETOS, true);
    xhrAvancarProjeto.onreadystatechange = function(){     
        if(xhrAvancarProjeto.readyState == 4){
            if(xhrAvancarProjeto.status == 200){
                json = (JSON.parse(xhrAvancarProjeto.responseText));
                for(i = 0;i<json.length;i++){
                    vetor_projeto.push(json[i]['prj_id']);
                    
                }
                
                vetor_projeto.reverse();
                 maiorvalor = 0;
                 for(i=0;i<vetor_projeto.length;i++){
                    
                    if(codProjeto == vetor_projeto[i]){
                    codProjeto = vetor_projeto[i-1];
                 }
                 if(vetor_projeto[i] > maiorvalor){
                    maiorvalor = vetor_projeto[i]; 
                }    

                }
                   
                document.getElementById("codProjeto").value = codProjeto;   
                
                if(codProjeto == maiorvalor){
                    desabilitaAvancoCodProjeto();
                }
                
                habilitaRecuoCodProjeto();
                getProjeto();
                }else if(xhrAvancarProjeto.status == 404){ }
            
            }
        }
    
        
        xhrAvancarProjeto.send();

}

function desabilitaBtnAtualizarProjeto(){
    document.getElementById("btn_atualizarCadasProjeto").disabled = true;
 
   mudaBotao =  document.getElementById("btn_atualizarCadasProjeto");
    mudaBotao.style.backgroundColor = "gray";
}

function habilitaBtnAtualizarProjeto(){
        document.getElementById("btn_atualizarCadasProjeto").disabled = false;
     mudaBotao =  document.getElementById("btn_atualizarCadasProjeto");
     mudaBotao.style.backgroundColor = "#698FEB";
      
 
 }


function desabilitaRecuoCodProjeto(){
        document.getElementById("codAnteriorCadasProjeto").disabled = true;
     
       mudaBotao =  document.getElementById("codAnteriorCadasProjeto");
        mudaBotao.style.backgroundColor = "gray";
 }

function desabilitaAvancoCodProjeto(){
  document.getElementById("codPosteriorCadasProjeto").disabled = true;
     
       mudaBotao =  document.getElementById("codPosteriorCadasProjeto");
        mudaBotao.style.backgroundColor = "gray";

}

function habilitaRecuoCodProjeto(){
   
    document.getElementById("codAnteriorCadasProjeto").disabled = false;
    mudaBotao =  document.getElementById("codAnteriorCadasProjeto");
    mudaBotao.style.backgroundColor = "#698FEB";
     

}

function habilitaAvancoCodProjeto(){
  document.getElementById("codPosteriorCadasProjeto").disabled = false;
    mudaBotao =  document.getElementById("codPosteriorCadasProjeto");
    mudaBotao.style.backgroundColor = "#698FEB";
}

function fecharCadastroProjeto(){
    dialogCadastro.close();
    limparCamposCadasProjeto();
}

function habilitaBtnCancelarProjeto(){
    document.getElementById("btn_cancelarCadasProjeto").disabled = false;
    mudaBotao =  document.getElementById("btn_cancelarCadasProjeto");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnCancelarProjeto(){
    document.getElementById("btn_cancelarCadasProjeto").disabled = true;
     if(document.getElementById("btn_cancelarCadasProjeto").disabled = true){
       mudaBotao =  document.getElementById("btn_cancelarCadasProjeto");
        mudaBotao.style.backgroundColor = "gray";
}
}

function habilitaCamposProjeto(){
     document.getElementById("nomeProjeto").readOnly = false;
    document.getElementById("escopo").readOnly = false;
    document.getElementById("dt_inicioProjeto").readOnly = false;
    document.getElementById("dt_prazoProjeto").readOnly = false;
    
    document.getElementById("corProjeto").disabled = false;
    progressoprojeto = document.getElementById("progressoprojeto").disabled = false;
    custo = document.getElementById("custo").readOnly = false;
    horas_desen = document.getElementById("horas_desenvolvimento").readOnly = false;
    
    
}

function desabilitaCamposProjeto(){
    limparCamposCadasProjeto();
    document.getElementById("nomeProjeto").readOnly = true;
    document.getElementById("escopo").readOnly = true;
    document.getElementById("dt_inicioProjeto").readOnly = true;
    document.getElementById("dt_prazoProjeto").readOnly = true;  
    document.getElementById("corProjeto").disabled = true;
    progressoprojeto = document.getElementById("progressoprojeto").disabled = true;
    custo = document.getElementById("custo").readOnly = true;
    horas_desen = document.getElementById("horas_desenvolvimento").readOnly = true;
    
}

function habilitaBtnNovoProjeto(){
     document.getElementById("btn_novoprojeto").disabled = false;
    mudaBotao =  document.getElementById("btn_novoprojeto");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnNovoProjeto(){
    document.getElementById("btn_novoprojeto").disabled = true;
    if(document.getElementById("btn_novoprojeto").disabled = true){
       mudaBotao =  document.getElementById("btn_novoprojeto");
        mudaBotao.style.backgroundColor = "gray";
    }
}

function desabilitaBtnExcluirProjeto(){
    document.getElementById("btn_excluirCadasProjeto").disabled = true;
    mudaBotao =  document.getElementById("btn_excluirCadasProjeto");
     mudaBotao.style.backgroundColor = "gray";
}

function habilitaBtnExcluirProjeto(){
    document.getElementById("btn_excluirCadasProjeto").disabled = false;
    mudaBotao =  document.getElementById("btn_excluirCadasProjeto");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function desabilitaBtnGravaProjeto(){
    document.getElementById("btn_salvarprojeto").disabled = true;
    if(document.getElementById("btn_salvarprojeto").disabled = true){
       mudaBotao =  document.getElementById("btn_salvarprojeto");
        mudaBotao.style.backgroundColor = "gray";
    }
}

function habilitaBtnGravarProjeto(){
    document.getElementById("btn_salvarprojeto").disabled = false;
    mudaBotao =  document.getElementById("btn_salvarprojeto");
        mudaBotao.style.backgroundColor = "#698FEB";
}

function limparCamposCadasProjeto(){
    document.getElementById("nomeProjeto").value = '';
    document.getElementById("escopo").value = '';
    document.getElementById("dt_prazoProjeto").value = '';
    document.getElementById("dt_inicioProjeto").value = '';
    
   mudaCor = document.getElementById("corProjeto");
    cor = "#000000";
    
    mudaCor.value = cor.value;

    progressoprojeto = document.getElementById("progressoprojeto").value = 0;
    custo = document.getElementById("custo").value = '';
    horas_desen = document.getElementById("horas_desenvolvimento").value = '';
}



function add_prj_menu_esquerdo(jsonprj){
    document.getElementById("prj_cadastrados").innerHTML = ''; 
    vetor_prjcadastrados = [];
    
    for(i = 0;i<json.length;i++){

        /*CARREGA VETOR PARA CADASTRAR PROJETO NO MENU LATERAL ESQUERDO */
        add_btn_prj_menu_esquerdo = [json[i]['prj_id'],"<div class='div_shadow' style='background-color:"+json[i]['prj_color']+"'><input id='cb_prj"+json[i]['prj_id']+"' type='checkbox' ><button id='btn_prj"+json[i]['prj_id']+"' onClick='expandeTrf(this.id);dadosProjeto(this.id);'class='btn_shadow0' style='background-color:"+json[i]['prj_color']+"'>"+json[i]['prj_nome']+"</button></div> "]; //CRIA VALOR PARA ADICIONAR NA DIV "prj_cadastrados"
        vetor_prjcadastrados.push(add_btn_prj_menu_esquerdo);//ADICIONA LINHA PARA CRIAÇÃO DO BTN DE PROJETO
        ///////////////////
    }
        /*ENVIA PROJETO AO MENU LATERAL ESQUERDO*/
        document.getElementById("prj_cadastrados").innerHTML = ''; //ZERA DIV PARA NOVOS BUTTONS
    for(i = 0; i<vetor_prjcadastrados.length;i++){ // VARREDURA DO VETOR CRIADO COM OS INSERTS PARA A DIV
        document.getElementById("prj_cadastrados").innerHTML +=  vetor_prjcadastrados[i][1];//ADICIONA OS INSERTS NA DIV 
            
        novaDivTrf = document.createElement("div");//CRIA NOVA DIV PARA RECEBER TAREFAS CORRESPONDENTES AO PROJETO CRIADO
            
        novaDivTrf.id = "trf_cadastradas_prj"+vetor_prjcadastrados[i][0]+"";//NOME DA DIV PARA RECEBER AS TAREFAS
        
        document.getElementById("prj_cadastrados").appendChild(novaDivTrf);//ADICIONA A DIV ABAIXO DO PROJETO CRIADO
        //////////////////////////////////    
    }
        
                  
    vetorTrfCadastrados(json, null); 

}

function carregaTabelaProjeto(){


    codProjeto = parseInt(document.getElementById("codProjeto").value);
    vetor_tabelaProjeto = [];
    xhrTabelaProjeto = new XMLHttpRequest();
    xhrTabelaProjeto.open('GET', URLGETPROJETOS, true);
    xhrTabelaProjeto.onreadystatechange = function(){     
        if(xhrTabelaProjeto.readyState == 4){
            if(xhrTabelaProjeto.status == 200){
                json = (JSON.parse(xhrTabelaProjeto.responseText));
                         
                for(i = 0;i<json.length;i++){
                    linhaTabelaProjeto = ["<tr><td>"+json[i]['prj_id']+"</td><td>"+json[i]['prj_nome']+"</td><td>"+json[i]['prj_datainicio']+"</td><td>"+json[i]['prj_prazoentrega']+"</td><td bgcolor="+json[i]['prj_color']+"></td></tr>"];
                    vetor_tabelaProjeto.push(linhaTabelaProjeto);                  
                }
            }else if(xhrTabelaProjeto.status == 404){}
            
            }    
        document.getElementById("corpoTabelaProjeto").innerHTML = '';
        
    for(i = 0; i < vetor_tabelaProjeto.length;i++){
         document.getElementById("corpoTabelaProjeto").innerHTML += vetor_tabelaProjeto[i];
    }   
}
    xhrTabelaProjeto.send();
}
/*EXPANDE TAREFAS MENU CENTRAL ESQUERDO*/

recebe_vetorprojeto = [];
recebe_vetortarefa = [];
///FUNÇÃO ATRIBUÍDA PARA O BTN GRAVAR TAREFA
function vetorTrfCadastrados(vetor_projeto, vetor_tarefa){
    vetor_trfcadastrados = [];
    if(vetor_projeto != null){
        recebe_vetorprojeto = vetor_projeto;
    }
    if(vetor_tarefa != null){
        recebe_vetortarefa = vetor_tarefa;
    }

if(recebe_vetorprojeto != '' && recebe_vetortarefa != ''){
  for(i=0;i<recebe_vetorprojeto.length;i++){//VARREDURA NOS PROJETOS CADASTRADOS
       recebeCodPrj = recebe_vetorprojeto[i]['prj_id'];  //SELECIONA O CODIGO DO PROJETO    
       for(x=0; x<recebe_vetortarefa.length;x++){ //VARREDURA NAS TAREFAS CADASTRADAS
            if(recebeCodPrj == recebe_vetortarefa[x]['fk_prj_id']){//VALIDA O CODIGO DO PROJETO DO CADASTRO DE PROJETO AO CODIGO DO PROJETO NO CADASTRO DE TAREFA E CRIA UM VETOR PARA INSERIR NA DIV CRIADA.
                
               codTrf = recebe_vetortarefa[x]['trf_id']; //CODIGO DA TAREFA - TABELA TAREFA
              
               recebeNomeTrf = recebe_vetortarefa[x]['trf_name']; //NOME DA TAREFA - TABELA TAREFA            
               corProjeto = recebe_vetorprojeto[i]['prj_color']; //COR DO PROJETO - TABELA PROJETO                   
               add_btn_trf_menu_esquerdo = [recebeCodPrj,"<button id='btn_trf"+codTrf+"' onClick='dadosTarefa(this.id)' class='btn_shadow3' style='border-color:"+corProjeto+"'>"+recebeNomeTrf+"</button>"]; // CRIA LINHA PARA NOVOS BOTÕES DE TAREFAS, ABAIXO DO PROJETO CORRESPONDENTE
               
               vetor_trfcadastrados.push(add_btn_trf_menu_esquerdo);//ADICIONA NO VETOR AS TAREFAS CADASTRADAS E SEUS RESPECTIVOS BOTÕES, COM O ID DO PROJETO NO ÍNDICE 0                  
           }        
       }    
   }
   //console.log(vetor_trfcadastrados);//VERIFICA INTEGRIDADE DO VETOR  
}
}
///FUNÇÃO ATRIBUÍDA PARA O BTN PROJETO NO MENU LATERAL ESQUERDO

function expandeTrf(nomeBtn){
    
    divideBtn = nomeBtn.substr(7);//REMOVE E DEIXA APENAS O NÚMERO DE IDENTIFICAÇÃO DO BOTÃO DE CADA TAREFA "btn_trf'num exemplo'"
   
    selecionaDiv = document.getElementById('trf_cadastradas_prj'+divideBtn+'').textContent;//SELECIONA A DIV DE CADA PROJETO E VERIFICA SE TEM CONTEÚDO DENTRO
    if(selecionaDiv == ''){//CASO NÃO TENHA CONTEÚDO
       
        for(i=0;i<vetor_trfcadastrados.length;i++){//FAZ VARREDURA NOS BOTÕES DAS TAREFAS
       
        
        if(divideBtn == vetor_trfcadastrados[i][0]){ //CASO O NÚMERO DE IDENTIFICAÇÃO DO BTN DA TAREFA SEJA IGUAL AO ID DE CADA PROJETO, É ADICIONADO O BOTÃO NA DIV CORRESPONDENTE
            
            document.getElementById('trf_cadastradas_prj'+divideBtn+'').innerHTML += vetor_trfcadastrados[i][1];//ADICIONA OS BOTÕES DAS TAREFAS NAS DIV'S DOS PROJETOS CORRESPONDENTES
        }    
        }
   }else{
       document.getElementById('trf_cadastradas_prj'+divideBtn+'').remove() //CASO TENHA CONTEÚDO NA DIV, ELE É ELIMINADO. ISSO FOI FEITO PARA CRIAR O RECUO.
       add_prj_menu_esquerdo();//ADICIONA NOVAMENTE A DIV DO PROJETO
       getAllProjects();
   }





}
/*///////////////////////////////////////////////////////////////////////////////////////*/
