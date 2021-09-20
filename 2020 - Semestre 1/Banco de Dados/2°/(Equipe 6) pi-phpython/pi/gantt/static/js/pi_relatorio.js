/**ATENÇÃO!!!!!*/

/**ESTE ARQUIVO JAVASCRIPT FOI PROJETADO PARA TRATAR APENAS O RELATÓRIO*/


/**TELA INICIAL - RELATÓRIO */
function clicaRelatorio(){
    document.getElementById("menu_superior").classList.remove("show");
    dialogCadastro = document.getElementById("abreRelatorio");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();

    carregaProjetos();
}

function fecharRelatorio(){
    dialogCadastro.close();
    document.getElementById("projetos_dashboard").innerHTML = '';
    projetos_selecionados_id = [];
}

function carregaProjetos(){
    xhrGetProjetos = new XMLHttpRequest();

    xhrGetProjetos.open('GET', URLGETPROJETOS, true);

    xhrGetProjetos.onreadystatechange = function(){
        if(xhrGetProjetos.readyState == 4){
            if(xhrGetProjetos.status == 200){

                json_projetos_cadastrados = JSON.parse(xhrGetProjetos.responseText);
                document.getElementById("projetos_cadastrados").innerHTML = '';
                for(i = 0; i< json_projetos_cadastrados.length;i++){

                    linha = "<button id='projeto_id"+json_projetos_cadastrados[i]['prj_id']+"' class='btn_shadow4_2' draggable=true ondragstart='return dragStart(event)' ondragend='return dragEnd(event)' style='background-color:"+json_projetos_cadastrados[i]['prj_color']+"'>"+json_projetos_cadastrados[i]['prj_nome']+"</button>";
                    document.getElementById("projetos_cadastrados").innerHTML += linha;
                }

            }
        }
    }
    xhrGetProjetos.send();
}

function dragStart(ev) {
    ev.dataTransfer.setData("ID",ev.target.getAttribute('id'));
}
function dragOver(ev) { 
    return false;
}
projetos_selecionados_id = [];
function dragDrop(acao) {
    projetoSelecionado = acao.dataTransfer.getData("ID");
    acao.target.appendChild(document.getElementById(projetoSelecionado));
    

    if(acao.target.getAttribute('id') != 'projetos_dashboard'){
        

        for(i=0;i<projetos_selecionados_id.length;i++){
            if(projetoSelecionado == projetos_selecionados_id[i]){
                projetos_selecionados_id.splice([i], 1);
        }
        }
        
    }else if(acao.target.getAttribute('id') == 'projetos_dashboard'){
        projetos_selecionados_id.push(projetoSelecionado);
    }
    
    
}
function dragEnd(acao) {
    acao.dataTransfer.clearData("ID");
    return true;

    
}
/**/////////////////////////////////////////////////////////// */

/**TELA DASHBOARD */



function gerarDashboard(){
   
    projetos_dashboard = [];
    for(i=0;i<projetos_selecionados_id.length;i++){
        proj_dashboard = document.getElementById('projetos_dashboard').querySelector('#'+projetos_selecionados_id[i]+'').innerText;
        if(proj_dashboard != null){
            projetos_dashboard.push(proj_dashboard);
        }
    }

    dialogCadastro = document.getElementById("abreDashboard");
    dialogPolyfill.registerDialog(dialogCadastro);
    dialogCadastro.showModal();

    getProjetosDashboard();
    getTarefasDashboard();
    getPessoasDashboard();
    getPessoasDistTarefas();
    getPessoasDistrHabilidades();
    getHabilidades();
    dadosDashboard();

    
    /*for(i=0;i<projetos_dashboard.length;i++){


    }*/


}
function fecharDashboard(){
    dialogCadastro.close();
    dialogCadastro = document.getElementById("abreRelatorio");
    dialogPolyfill.registerDialog(dialogCadastro);
   
}


/**ÁREA DE PROJECAO DO DASHBOARD */

function getProjetosDashboard(){
    xhrGetProjetos = new XMLHttpRequest();

    xhrGetProjetos.open('GET', URLGETPROJETOS, true);

    xhrGetProjetos.onreadystatechange = function(){
        if(xhrGetProjetos.readyState == 4){
            if(xhrGetProjetos.status == 200){
                json_get_projetos = JSON.parse(xhrGetProjetos.responseText);

                dadosDashboard(json_get_projetos ,null, null);

            }
        }
    }
    xhrGetProjetos.send();
}

function getTarefasDashboard(){
    xhrGetTarefas = new XMLHttpRequest();

    xhrGetTarefas.open('GET', URLGETTAREFAS, true);

    xhrGetTarefas.onreadystatechange = function(){
        if(xhrGetTarefas.readyState == 4){
            if(xhrGetTarefas.status == 200){
                json_get_tarefas = JSON.parse(xhrGetTarefas.responseText);

                dadosDashboard(null , json_get_tarefas, null);
            }
        }
    }
    xhrGetTarefas.send();

}

function getPessoasDashboard(){
    xhrGetPessoas = new XMLHttpRequest();

    xhrGetPessoas.open('GET', URLGETPESSOAS, true);

    xhrGetPessoas.onreadystatechange = function(){
        if(xhrGetPessoas.readyState == 4){
            if(xhrGetPessoas.status == 200){
                json_get_pessoas = JSON.parse(xhrGetPessoas.responseText);

                dadosDashboard(null , null, json_get_pessoas);
                
            }
        }
    }
    xhrGetPessoas.send();
}

function getPessoasDistTarefas(){
    xhrGetPessoasDistTarefas = new XMLHttpRequest();

    xhrGetPessoasDistTarefas.open('GET', URLGETDISTRIBUICAO, true);

    xhrGetPessoasDistTarefas.onreadystatechange = function(){
        if(xhrGetPessoasDistTarefas.readyState == 4){
            if(xhrGetPessoasDistTarefas.status == 200){
                json_get_pessoas_distr_tarefas = JSON.parse(xhrGetPessoasDistTarefas.responseText);

                dadosDashboard(null , null, null, json_get_pessoas_distr_tarefas);
                
            }
        }
    }
    xhrGetPessoasDistTarefas.send();
}

function getPessoasDistrHabilidades(){
    xhrGetPessoasHabilidades = new XMLHttpRequest();

    xhrGetPessoasHabilidades.open('GET', URLGETDISTRHABILIDADES, true);

    xhrGetPessoasHabilidades.onreadystatechange = function(){
        if(xhrGetPessoasHabilidades.readyState == 4){
            if(xhrGetPessoasHabilidades.status == 200){
                json_get_pessoas_distr_habilidades = JSON.parse(xhrGetPessoasHabilidades.responseText);

                dadosDashboard(null , null, null, null, json_get_pessoas_distr_habilidades);
                
            }
        }
    }
    xhrGetPessoasHabilidades.send();
}

function getHabilidades(){
    xhrGetHabilidades = new XMLHttpRequest();

    xhrGetHabilidades.open('GET', URLGETHABILIDADES, true);

    xhrGetHabilidades.onreadystatechange = function(){
        if(xhrGetHabilidades.readyState == 4){
            if(xhrGetHabilidades.status == 200){
                json_get_habilidades = JSON.parse(xhrGetHabilidades.responseText);

                dadosDashboard(null , null, null, null, null, json_get_habilidades);
                
            }
        }
    }
    xhrGetHabilidades.send();
}

recebe_dados_projetos = [];
recebe_dados_tarefas = [];
recebe_dados_pessoas = [];
recebe_dados_pessoas_distr_tarefas = [];
recebe_dados_pessoas_distr_habilidades = [];
recebe_dados_habilidades = [];

function dadosDashboard(json_get_projetos, json_get_tarefas, json_get_pessoas, json_get_pessoas_distr_tarefas, json_get_pessoas_distr_habilidades, json_get_habilidades){

    if(json_get_projetos != null){
        recebe_dados_projetos = json_get_projetos;
    }
    if(json_get_tarefas != null){
        recebe_dados_tarefas = json_get_tarefas;
    }

    if(json_get_pessoas != null){
        recebe_dados_pessoas = json_get_pessoas;
    }

    if(json_get_pessoas_distr_tarefas != null){
        recebe_dados_pessoas_distr_tarefas = json_get_pessoas_distr_tarefas;
    }

    if(json_get_pessoas_distr_habilidades != null){
        recebe_dados_pessoas_distr_habilidades = json_get_pessoas_distr_habilidades;
    }

    if(json_get_habilidades != null){
        recebe_dados_habilidades = json_get_habilidades;
    }

   
    document.getElementById('dashboard_projetos').innerHTML = '';
    //console.log("Projetos Dashboard"+projetos_dashboard+"");
    for(y=0; y<projetos_dashboard.length;y++){
        
    for(i=0; i<recebe_dados_projetos.length;i++){
        
        if(projetos_dashboard[y] == recebe_dados_projetos[i]['prj_nome']){

                /**CRIAR DIV PROJETO - GERAL */
                linha_div_projeto = "<div id='prj"+recebe_dados_projetos[i]['prj_id']+"' class='view_projeto' style='border-color:"+recebe_dados_projetos[i]['prj_color']+"'></div>";
                document.getElementById('dashboard_projetos').innerHTML +=  linha_div_projeto;
                
                /**CRIAR DIV PROJETO - NOME PROJETO E DADOS */
                linha_nome_projeto = "<div id='div_cor_projeto' style='background-color:"+recebe_dados_projetos[i]['prj_color']+"'></div><label class='class_nome_projeto'>"+recebe_dados_projetos[i]['prj_nome']+"</label>";
                document.getElementById('prj'+recebe_dados_projetos[i]['prj_id']+'').innerHTML += linha_nome_projeto;
                
                linha_dados_projeto = "<div style='background-color: #DFEAED' id='dados_projeto"+recebe_dados_projetos[i]['prj_id']+"' class='class_dados_projeto'>|<br>------><label id='lb_dados_projeto"+recebe_dados_projetos[i]['prj_id']+"'>DADOS PROJETO --> Progresso: "+recebe_dados_projetos[i]['prj_progresso']+"% - Data Início: "+recebe_dados_projetos[i]['prj_datainicio']+" - Prazo Entrega: "+recebe_dados_projetos[i]['prj_prazoentrega']+" - Horas Desenvolvimento: "+recebe_dados_projetos[i]['prj_hrs_dev']+" - Custo Projeto: "+recebe_dados_projetos[i]['prj_cost']+"</label></div>";
                document.getElementById('prj'+recebe_dados_projetos[i]['prj_id']+'').innerHTML += linha_dados_projeto;

                for(x=0; x<recebe_dados_tarefas.length;x++){

                    if(recebe_dados_tarefas[x]['fk_prj_id'] == recebe_dados_projetos[i]['prj_id']){
                    
                        /**CRIAR DIV TAREFA - NOME TAREFA E DADOS */
                        linha_div_tarefas = "<div style='background-color: #DFEAED' id='dados_tarefa"+recebe_dados_projetos[i]['prj_id']+"_"+recebe_dados_tarefas[x]['trf_id']+"' class='class_dados_tarefa'></div>"
                        document.getElementById('prj'+recebe_dados_projetos[i]['prj_id']+'').innerHTML += linha_div_tarefas;

                        linha_dados_tarefa = "<label>|</label><br><label>------></label><label id='lb_dados_tarefa"+recebe_dados_projetos[i]['prj_id']+"_"+recebe_dados_tarefas[x]['trf_id']+"'>NOME TAREFA: <strong>"+recebe_dados_tarefas[x]['trf_name']+"</strong>  --> Progresso: "+recebe_dados_tarefas[x]['trf_name']+" - Interdependência: "+recebe_dados_tarefas[x]['trf_interdependencia']+" - Data Início: "+recebe_dados_tarefas[x]['trf_datainicial']+" - Data final: "+recebe_dados_tarefas[x]['trf_datafinal']+" - Entregável: "+recebe_dados_tarefas[x]['trf_entregavel']+"</label>";
                        document.getElementById("dados_tarefa"+recebe_dados_projetos[i]['prj_id']+"_"+recebe_dados_tarefas[x]['trf_id']+"").innerHTML += linha_dados_tarefa;

                    for(w=0;w<recebe_dados_pessoas_distr_tarefas.length;w++){

                        if(recebe_dados_tarefas[x]['trf_id'] == recebe_dados_pessoas_distr_tarefas[w]['fk_trf_id']){
                        for(z=0;z<recebe_dados_pessoas.length;z++){
                            if(recebe_dados_pessoas_distr_tarefas[w]['fk_pes_id'] == recebe_dados_pessoas[z]['pes_id']){
                                habilidades = '';
                                
                                for(j=0;j<recebe_dados_pessoas_distr_habilidades.length;j++){
                                    if(recebe_dados_pessoas[z]['pes_id'] == recebe_dados_pessoas_distr_habilidades[j]['fk_pes_id']){
                                        
                                        for(h=0;h<recebe_dados_habilidades.length;h++){
                                            if(recebe_dados_pessoas_distr_habilidades[j]['fk_hab_id'] == recebe_dados_habilidades[h]['hab_id']){
                                                
                                                habilidades = habilidades + " - " + recebe_dados_habilidades[h]['hab_nome'];

                                            }
                                        }
                                    }
                                }
                                
                                /**CRIAR DIV PESSOA - NOME PESSOA E DADOS */
                                linha_div_pessoas = "<div style='background-color: #DFEAED' id='dados_pessoa"+recebe_dados_projetos[i]['prj_id']+"_"+recebe_dados_tarefas[x]['trf_id']+"_"+recebe_dados_pessoas[z]['pes_id']+"' class='class_dados_pessoa'></div>";
                                document.getElementById("dados_tarefa"+recebe_dados_projetos[i]['prj_id']+"_"+recebe_dados_tarefas[x]['trf_id']+"").innerHTML += linha_div_pessoas;

                                linha_dados_pessoa = "|<br>------><label id='lb_dados_pessoa"+recebe_dados_projetos[i]['prj_id']+"_"+recebe_dados_tarefas[x]['trf_id']+"_"+recebe_dados_pessoas[z]['pes_id']+"'>PESSOA ATRIBUÍDA: --> <strong>"+recebe_dados_pessoas[z]['pes_nome']+"</strong> - Habilidade: "+habilidades+" </label>";
                                document.getElementById("dados_pessoa"+recebe_dados_projetos[i]['prj_id']+"_"+recebe_dados_tarefas[x]['trf_id']+"_"+recebe_dados_pessoas[z]['pes_id']+"").innerHTML += linha_dados_pessoa;

                            }

                        }
                    }
                    }
                }
            }
        }
    }
    }


}