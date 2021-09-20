/**ATENÇÃO!!!!!*/

/**ESTE ARQUIVO JAVASCRIPT FOI PROJETADO PARA TRATAR APENAS GRÁFICO DO GANTT*/




/*JSON PARA CARREGAR GRÁFICO DE GANTT*/
function ganttProjetos(){
      
    vetor_projetoGantt = [];
    xhrGetProjeto = new XMLHttpRequest();
    
    jsonProjetosGantt = '';
    xhrGetProjeto.open('GET', URLGETPROJETOS, true);
    xhrGetProjeto.onreadystatechange = function(){
        if(xhrGetProjeto.readyState == 4){
            if(xhrGetProjeto.status == 200){
                jsonProjetosGantt = (JSON.parse(xhrGetProjeto.responseText)); 

            }else if(xhrGetProjeto.status == 404){

            }
        }      
        carregaGantt(jsonProjetosGantt, null);
        
    }
    xhrGetProjeto.send();
    ganttTarefas();
}

function ganttTarefas(){
    vetor_tarefaGantt = [];
    xhrGetTarefa = new XMLHttpRequest();
    
    jsonTarefasGantt = '';
    xhrGetTarefa.open('GET', URLGETTAREFAS, true);
    xhrGetTarefa.onreadystatechange = function(){
        if(xhrGetTarefa.readyState == 4){
            if(xhrGetTarefa.status == 200){
                jsonTarefasGantt = (JSON.parse(xhrGetTarefa.responseText));  
                ganttDistribuicao();
                       
            }else if(xhrGetTarefa.status == 404){
            }
        }      
        carregaGantt(null, jsonTarefasGantt);
        
    }
    xhrGetTarefa.send();
    
   
}

function ganttDistribuicao(){
    xhrGanttDistribuicao = new XMLHttpRequest();

    xhrGanttDistribuicao.open('GET', URLGETDISTRIBUICAO, true);
    xhrGanttDistribuicao.onreadystatechange = function(){
        if(xhrGanttDistribuicao.readyState == 4){
            if(xhrGanttDistribuicao.status == 200){
                json_gantt_distribuicao = JSON.parse(xhrGanttDistribuicao.responseText);
                ganttPessoas();  
                select_distribuicao_gantt(json_gantt_distribuicao);
            }
        }
    }

    xhrGanttDistribuicao.send();

}

recebe_distribuicaoGantt = [];
function select_distribuicao_gantt(json_gantt_distribuicao){
    if(json_gantt_distribuicao != null){
        recebe_distribuicaoGantt = json_gantt_distribuicao;
    }
    
}


function ganttPessoas(){
    xhrGanttPessoas = new XMLHttpRequest();

    xhrGanttPessoas.open('GET', URLGETPESSOAS, true);
    xhrGanttPessoas.onreadystatechange = function(){
        if(xhrGanttPessoas.readyState == 4){
            if(xhrGanttPessoas.status == 200){
                json_gantt_pessoas = JSON.parse(xhrGanttPessoas.responseText);

                select_pessoas_gantt(json_gantt_pessoas);
            }
        }
    }

    xhrGanttPessoas.send();

}

recebe_pessoasGantt = [];
function select_pessoas_gantt(json_gantt_pessoas){
    if(json_gantt_pessoas != null){
        recebe_pessoasGantt = json_gantt_pessoas;
    }
}

function cores_tarefas(){
    document.getElementsByTagName('style').innerHTML = '';
       for(i=0;i<vetor_preparaProjetos.length;i++){
           
          linha = '.tcolor-'+vetor_preparaProjetos[i][0]+' .bar {fill: '+vetor_preparaProjetos[i][6]+'}';
           document.querySelector('style').innerHTML += linha;         
        }
}

recebe_projetoGantt = [];
recebe_tarefaGantt = []

function carregaGantt(jsonProjetosGantt, jsonTarefasGantt){
    

        vetor_gantt = [];

        if(jsonProjetosGantt != null){
            recebe_projetoGantt = jsonProjetosGantt;
        }
        if(jsonTarefasGantt != null){
            recebe_tarefaGantt = jsonTarefasGantt;
        }
        
        checked_project = [];
        for(i=0;i<recebe_projetoGantt.length;i++){
            
            if(document.getElementById("cb_prj"+recebe_projetoGantt[i]['prj_id']+"").checked){
                checked_project.push(recebe_projetoGantt[i]['prj_id']);
            }
        }
           
        vetor_preparaProjetos = [];
        nomeInterdependencia = '';

        if(recebe_projetoGantt != ''){
            if(recebe_tarefaGantt != ''){
                
       
        
        for(i=0; i<recebe_projetoGantt.length;i++){
            for(y=0;y<checked_project.length;y++){
                if(checked_project[y] == recebe_projetoGantt[i]['prj_id']){
          
            
            for(x=0;x<recebe_tarefaGantt.length;x++){
                if(recebe_tarefaGantt[x]['trf_id'] == recebe_tarefaGantt[x]['trf_interdependencia']){
                    nomeInterdependencia = recebe_tarefaGantt[x]['trf_name'];
                }

                if(recebe_tarefaGantt[x]['fk_prj_id'] == recebe_projetoGantt[i]['prj_id']){
                    
                    linha = [recebe_tarefaGantt[x]['trf_id'], recebe_tarefaGantt[x]['trf_name'],recebe_tarefaGantt[x]['trf_datainicial'], recebe_tarefaGantt[x]['trf_datafinal'], recebe_tarefaGantt[x]['trf_interdependencia'], recebe_tarefaGantt[x]['trf_progresso'], recebe_projetoGantt[i]['prj_color'] ];
                    vetor_preparaProjetos.push(linha);
                }
            }
        }
        }
    }
    
    if(vetor_preparaProjetos != ''){
        tasks = []; //CRIA VETOR PARA RECEBER JSON
    
        for(i = 0; i< vetor_preparaProjetos.length;i++){ //FAZ A VARREDURA NO VETOR PARA CRIAR JSON
            tasks.push({ //CARREGA O JSON COM AS INFORMAÇÕES NECESSÁRIAS PARA CARREGAR O GRÁFICO GANTT
                'id': 'Task'+vetor_preparaProjetos[i][0],
                'name': vetor_preparaProjetos[i][1],
                'start': vetor_preparaProjetos[i][2],
                'end': vetor_preparaProjetos[i][3],
                'dependencies': 'Task'+vetor_preparaProjetos[i][4],
                'progress': vetor_preparaProjetos[i][5],       
                'custom_class': 'tcolor-'+vetor_preparaProjetos[i][0]                     
            });

            
        }
        //console.log("TASKS: "+tasks+""); //TESTE DE INTEGRIDADE
         gantt = new Gantt('#gantt', tasks, {  
            on_click: function (task) {
                console.log(task);
                document.querySelector('style').innerHTML = '';
                
                cores_tarefas();
            },
            on_date_change: function(task, start, end) {
                console.log(recebe_tarefaGantt)
                console.log(task, start, end);
                const trf_id = parseInt(task.id.replace("Task",""))
                const tarefa = recebe_tarefaGantt.filter(_ => _.trf_id == trf_id)[0]
                tarefa.trf_datainicial = start.toISOString().split("T")[0]
                tarefa.trf_datafinal = end.toISOString().split("T")[0]
                putAtualizaTarefa(tarefa)
                
                
            },
            on_progress_change: function(task, progress) {
                console.log(task, progress);
            },
            on_view_change: function(mode) {
                console.log(mode);
            },
            custom_popup_html: function(task) {

                
                // the task object will contain the updated
                // dates and progress value
                
                //const end_date = task._end.format('MMM D');
                nome_pessoa_gantt = '';
                for(i=0;i<recebe_tarefaGantt.length;i++){
                    if(task.name ==  recebe_tarefaGantt[i]['trf_name']){
                        dt_final_tarefa = recebe_tarefaGantt[i]['trf_datafinal'];
                        cod_tarefa_gantt = recebe_tarefaGantt[i]['trf_id'];
                        for(x=0;x<recebe_distribuicaoGantt.length;x++){
                            if(recebe_distribuicaoGantt[x]['fk_trf_id'] == cod_tarefa_gantt){
                                cod_pessoa_gantt = recebe_distribuicaoGantt[x]['fk_pes_id'];
                                
                                for(y=0;y<recebe_pessoasGantt.length;y++){
                                    if(cod_pessoa_gantt == recebe_pessoasGantt[y]['pes_id']){
                                        nome_pessoa_gantt = recebe_pessoasGantt[y]['pes_nome'];
                                    }
                                }
                            }
                        }
                        
                    }
                }


                split_dt_final_tarefa = dt_final_tarefa.split('-');
                reverse_dt_final_tarefa = split_dt_final_tarefa.reverse();
                join_dt_final_tarefa = reverse_dt_final_tarefa.join('-');

                
                

                return `
                  <div class="details-container">
                    <label>${task.name}</label>
                    <p>Expected to finish by ${join_dt_final_tarefa}</p>
                    <p>${task.progress}% completed!</p>
                    <p>Pessoa: ${nome_pessoa_gantt} </p>
                  </div>
                `;
              }
        });

       
        cores_tarefas();
       
    }

    }
}

}
/*MUDANÇA DE PREÍODOS GANTT*/



// Quarter Day, Half Day, Day, Week, Month 


function periodo_dia(){

   // gantt = '';
    //gantt = new Gantt('#gantt', tasks);
    gantt.change_view_mode('Day'); // MUDANÇA DE PERÍODO PARA DIA
    linha_popup = '.popup-wrapper {display: none;';
    document.querySelector('style').innerHTML += linha_popup; 
    
}

function periodo_semana(){
    //gantt = '';
    //gantt = new Gantt('#gantt', tasks);
    gantt.change_view_mode('Week');// MUDANÇA DE PERÍODO PARA SEMANA
    linha_popup = '.popup-wrapper {display: none;';
    document.querySelector('style').innerHTML += linha_popup; 
}

function periodo_mes(){
    //gantt = '';
    //gantt = new Gantt('#gantt', tasks);
    gantt.change_view_mode('Month');// MUDANÇA DE PERÍODO PARA MÊS
    linha_popup = '.popup-wrapper {display: none;';
    document.querySelector('style').innerHTML += linha_popup; 
    
}

function periodo_ano(){
    //gantt = '';
    //gantt = new Gantt('#gantt', tasks);
    gantt.change_view_mode('Year');// MUDANÇA DE PERÍODO PARA ANO
    linha_popup = '.popup-wrapper {display: none;';
    document.querySelector('style').innerHTML += linha_popup; 
   
}



/*//////////////////////////////////////////////*/

