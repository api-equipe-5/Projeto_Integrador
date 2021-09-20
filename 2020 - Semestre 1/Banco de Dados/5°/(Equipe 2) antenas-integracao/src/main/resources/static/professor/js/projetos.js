$(document).ready(function () {
      let projects;
    
/* Informações do Usuário Professor */

      Fetch.get(`/professor/byID`).then(professor => {
        userData(professor)

       /* <> Rotas de inicialização dos objetos */
        Fetch.get(`/projeto/byprofessor/${professor.email}`).then(projetos => {
          insertMyProjects(projetos);
        });
         /* </> Rotas de inicialização dos objetos */
      });


     
      
      

      /* <> Funções */
      
      /* listagem de projetos do professor */
      function insertMyProjects(projecs) {
      
        let tbody = $('[data-myProjects-table-body]');
    
        projecs.forEach(project => {
          let project_id = project._id;
          let tr2 = $.parseHTML(`<tr data-project-item="${ project._id }> 
            <th scope="row">${ project.titulo }</th>
                <td>${ project.titulo }</td>
                <td>${ project['descricaoBreve'] }</td>
                <td>Nome da Empresa</td>
                <td id="td-key">${project['chave'] != null ? project['chave'] : '<input type="text" class="form-control" id="keyAlId-'+project_id+'" name="key_al" placeholder="Inserir Chave">'}<td>
                <td id="td-alkey-${project_id}"></td>
                <td id="td-alunos-${project_id}"></td>
            </tr>
          `);
   
          tbody.append(tr2);

          /*Gerando Chave de Acesso do Aluno td-alkey */
          let generateKey = $.parseHTML(`<button type="button" class="btn btn-primary">
              Gerar Chave
          </button>
          </li>`);

          let removeKey = $.parseHTML(`<button type="button" class="btn btn-danger">
              Remover Chave
          </button>
          </li>`);

          if(project['chave'] == null){
            let $generateKey = $(generateKey);
            $generateKey.click(function(e){
              e.preventDefault();
              var myKey = $('#keyAlId-'+project_id).val();
            
              if (confirm('Deseja realmente alterar o chave dos alunos ?')) {
                project.chave = myKey;
                Fetch.post("/projeto/update", project).then(() => {
                  console.log(project)
                });
              }
            });
  
            $('#td-alkey-'+project_id).append(generateKey);
            /* </ >Gerando Chave de Acesso do Aluno td-alkey </ >*/
          }
          else{
            let $removeKey = $(removeKey);
            $removeKey.click(function(e){
              e.preventDefault();
              if (confirm('Deseja realmente alterar o chave dos alunos ?')) {
                project.chave= null;
                Fetch.post("/projeto/update", project).then(() => {
                  console.log(project)
                });
              }
            });
  
            $('#td-alkey-'+project_id).append(removeKey);
           
          }
         

          /*Gerenciar alunos presentes td-alunos*/
          let AlPresentes = $.parseHTML(`
          <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modal-alunos-presentes">
             Alunos Presentes
          </button>
          </li>`);

          let $AlPresentes = $(AlPresentes);

          $AlPresentes.click(function(e){
            e.preventDefault();
            _AlunosPresentes(project);
          });

          $('#td-alunos-'+project_id).append(AlPresentes);
          /*</ >Gerenciar alunos presentes td-alunos</ >*/
        });
      }


function userData(user){
      /* <> Logou do Usuário */
      let navPROF = $('[data-user]');
      let logout = $.parseHTML(`
      <li><i class="fa fa-sign-out" aria-hidden="true"></i> 
      <button type="button" class="btn btn-danger">Logout</button></li>`);

      let $logout = $(logout);
      $logout.click(function(e) {
          e.preventDefault();
          if (confirm('Realmente deseja Sair ?')) {
            $.get("/logout").fail( e => console.log(e));
            location.replace('/');
          }
      });

      /* Alterar Senha */
      let updateSenha = $.parseHTML(`
      <li><i class="fa fa-sign-out" aria-hidden="true"></i>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-update-senha">
          Alterar Senha
      </button>
      </li>`);

      let $updateSenha = $(updateSenha);
      $updateSenha.click(function(e){
        e.preventDefault();
        _formUpdateSenha(user);
      });
      /* </> Alterar Senha */

      /* </> Logou do Usuário */

      /* Pupula Usuário Data */
      let data = $.parseHTML(`
      <li>${user.nome}</li>
      <li>Professor</li>`);
      /* </> Pupula Usuário Data */
    
      navPROF.append(data);
      navPROF.append(updateSenha);
      navPROF.append(logout);
      $("li").addClass("list-inline-item");
  }

/* </> Funções */

  
});




function _AlunosPresentes(project){

  let form_alunos =  $.parseHTML(`
    <div class="modal fade" id="modal-alunos-presentes" tabindex="-1" role="dialog" aria-labelledby="modal-alunos-presentes" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Alunos do Projeto</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body" >
          <div id="alunos" class="container"><br>
          <table class="table">
              <thead class="thead-dark">
                  <tr>
                      <td scope="col">Email</td>
                      <td></td>
                  </tr>
              </thead>
              <tbody id="tabela-alunos" td_body_aluno>

              </tbody>
          </table>
      </div>
        </div>
        <div class="modal-footer" >
        
        </div>
    </div>
  </div>`);
  /* Evento insere modal no HTML */
  $(document.body).prepend(form_alunos);
  /* Evento Remove modal do HTML */
  $('.close').click(function(e){
    e.preventDefault();
    $("#modal-update-senha").remove();
    $(".modal-backdrop ").remove();
  });


  project.alunos.forEach(aluno => {
    let remover = project.alunos.indexOf(aluno)
    let td =  $.parseHTML(`<tr data-alunos-item="${aluno}> 
            <th scope="row">${aluno}</th>
                <td>${aluno}</td>
                <td btn-remove-al-${remover}></td>
            </tr>
          `);

    let btn_remove = $.parseHTML(`<button type="button" class="btn btn-danger">Remover</button>`);
    let $btn_remove = $(btn_remove);
    $btn_remove.click(function(e){
       project.alunos.splice(remover, 1);
        $.post("/updateProjetoProfessor", JSON.stringify({'_id':project._id, 'alunos': project.alunos}), "json");
        $(this).closest('tr').remove();
    });

    $('[td_body_aluno]').append(td);
    $('[btn-remove-al-'+remover+']').append(btn_remove);
  });
}


function fechaPopupSemDono(event) {
  event.preventDefault();
  document.getElementById('modal_semdono').style.display='none';    
}


function _formUpdateSenha(user){

  let form_senha =  `
    <div class="modal fade" id="modal-update-senha" tabindex="-1" role="dialog" aria-labelledby="modal-update-senha" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Alteração de Senha</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
       Senha: <input class="form-control"  type="password" id="senha-antiga" name="senha-antiga" placeholder="Senha Atual" style="max-width:350px" required>
       Nova Senha: </label><input class="form-control" type="password" id="senha-nova1" name="senha-nova1" placeholder="Nova Senha" style="max-width:350px" required>
       Nova Senha Novamente: </label><input class="form-control" type="password" id="senha-nova2" name="senha-nova2" placeholder="Nova Senha" style="max-width:350px" required>
        </div>
        <div class="modal-footer" >
          <button type="submit" class="btn btn-primary alterarSenha" id="alterarSenha">Salvar mudanças</button>
          <div id="modal-footer-password"></div>
          </div>
      </div>
    </div>
  </div>`;

  /* Evento insere modal no HTML */
  $(document.body).prepend(form_senha);
  /* Evento Remove modal do HTML */
  $('.close').click(function(e){
    e.preventDefault();
    $("#modal-update-senha").remove();
    $(".modal-backdrop ").remove();
  });
  /* Evento submita a senha nova */
  $('#alterarSenha').click(function(e){
    e.preventDefault();
    $("#modal-footer-password").html('');
    var senhaAntiga = $("#senha-antiga").val();
    var senha1 = $("#senha-nova1").val();
    var senha2 = $("#senha-nova2").val();
    
  if(senha1 === senha2 && senha1 != null && senha2 != null){
      user.senha = senha1;
      Fetch.post("/professor/pub/save", user).then(() => {
        $('#modal-footer-password').append($.parseHTML(`<div class="alert alert-success" role="alert">
        Senha alterada com sucesso</div>`));
        window.location.reload();
      });
    }else{
      $('#modal-footer-password').append($.parseHTML(`<div class="alert alert-danger" role="alert">
      Senha de nova ou senha de confirmação inválidas ou não correspondentes.</div>`));
    }
  });
}

