var Timeline = function (endpoint) {

  
  if (!endpoint) {
    throw new Error('É preciso de um endpoint de salvamento de projeto para instanciar Timeline');
  }
  else if (!window.jQuery || !$().emulateTransitionEnd) {
    throw new Error('É preciso que o Bootstrap 4 (CSS e JS) e o JQuery esteja sendo importado');
  }

  function _getInitialModalHTML(projeto) {
    return `
      <div class="modal fade" id="modal-extra-${ projeto._id}" tabindex="-1" role="dialog" aria-labelledby="modal-label" aria-hidden="true" data-focus-on="input:first">
        <div class="modal-dialog ${ projeto.fase == 5 ? 'modal-xl' : ''}" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="modal-label"></h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
          </div>
        </div>
      </div>
      <div class="modal fade" id="modalRecusa" tabindex="-1" role="dialog" aria-labelledby="modal-label" aria-hidden="true" data-focus-on="input:first">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="tituloRecusa">Recusar Projeto</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <form data-form-project-change>
                  <div class="modal-body">
                 	<label for="formGroupRecusa">Insira o motivo da recusa:</label>
        			<input type="text"  class="form-control" name="recusa" id="recusa">
                  </div>
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-danger"  data-dismiss="modal" recusar>Recusar</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                  </div>
                  </form>
                </div>
              </div>
            </div>
    `;
  }

  function _customPopupElement(projeto, inputsHTML) {

    let modalExtra = `#modal-extra-${projeto._id} `;

    $('#modal-label').text(projeto.titulo);

    $(modalExtra + '.modal-body').html(inputsHTML);
    
    $(document).on('show.bs.modal', '.modal', function () {
        var zIndex = 1040 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex);
        setTimeout(function() {
            $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
        }, 0);
    });

    if ([1, 3, 4].indexOf(projeto.fase) != -1) {
      $(modalExtra + '.modal-footer').append(`
      <div class="btn-group btn-group-toggle" data-toggle="buttons">
          <button type="button" class="btn btn-primary" aceitar-avaInit>Aceitar</button>
          <button type="button"  class="btn btn-danger" data-toggle="modal" href="#modalRecusa">Recusar</a>
      </div>
      `);

      $('[aceitar-avaInit]').click(function (e) {
          projeto.fase = projeto.fase+1;
          Fetch.post("/projeto/update", projeto).then(() => {
              console.log(projeto);
          });
      });
      
      $('[recusar]').click(function (e) {
          var rec = document.getElementById('recusa');
          projeto.status.negado = true;
          projeto.status.motivo = rec.value;
          Fetch.post("/projeto/update", projeto).then(() => {
            console.log(projeto);
          });
      });

    /*reunião */
        $("#insere-data").click(function () {   
          var data = $("#dataReuniao").val();
          var hora = $("#horaReuniao").val();
          var local = $("#localReuniao").val();
          var assunto = $("#assuntoReuniao").val();
          console.log(hora)
          alert("boa")
          console.log(projeto.reuniao)
          
          var professores = [];
          $.each($(".country-professor option:selected"), function(){            
            professores.push($(this).val());
          });
          projeto.reuniao = {"data":data,"horario":hora,"local":local, "assunto":assunto}
          projeto.responsavelProfessor = professores;
          projeto.fase = projeto.fase+1;
          Fetch.post("/projeto/update", projeto).then(() => {
            console.log(project)

          });
            
        });

    }
  }

  function insertTimeline(target, projeto) {

    function _getIcon(iconName) {
      return iconName;
    }

    function _getEventClass(fase) {

      var base = 'event-circle--';

      if (projeto.status.negado)
        return base + 'red';
      else if (fase.isActive)
        return base + 'green';
      else if (fase.isPending)
        return base + 'yellow';
      else if (fase.isWaitingForInput)
        return base + 'blue';
      else
        return '';
    }
    

    function _getAvalInicHTML() {
      return `
      <div>
        <h3>Titulo do Projeto</h3>
        <p data-titulo>${projeto.titulo}</p>
      </div>
      <div>
         <h3>Descrição Breve</h3>
         <p data-descricao-breve>${projeto['descricaoBreve']}</p>
      </div>
      
   `;
    }

    function _getCadastroCompletoHTML() {
      return `
        <form data-form-project-change>
          <div class="form-group">
            <label for="desc-completa">Descrição Completa:</label>
            <textarea data-descricao-completa class="form-control" id="desc-completa" rows="3">${projeto['descricaoCompleta']}</textarea>
          </div>
          <div class="form-group">
            <label for="desc-tecnologias">Descrição das Tecnologicas:</label>
            <textarea data-descricao-tecnologias class="form-control" id="desc-tecnologias" rows="3">${projeto['descricaoTecnologica']}</textarea>
          </div>
          <div class="form-group">
            <label for="link-externo-2">Link externo 2:</label>
            <input data-link-externo-2 type="text" class="form-control" value="${projeto['linkExterno2']}" id="link-externo-2">
          </div>
        </form>`;
    }

    function _getAvalDetalHTML() {
      return `
        <div>
            <h3>Titulo do Projeto</h3>
            <p data-titulo>${projeto.titulo}</p>
        </div>
        <div>
            <h3>Descrição Breve</h3>
            <p data-descricao-breve>${projeto['descricaoBreve']}</p>
        </div>
        <div>
            <h3>Descrição Completa</h3>
            <p data-descricao-completa>${projeto['descricaoCompleta']}</p>
        </div>
        <div>
            <h3>Descrição Tecnologias</h3>
            <p data-descricao-tecnologias>${projeto['descricaoTecnologica']}</p>
        </div>
        <div>
            <h3>Link Externo 1</h3>
            <a data-link-externo href="${projeto['linkExterno1']}">${projeto['linkExterno1']}</a>
        </div>
        <div>
            <h3>Link Externo 2</h3>
            <a data-link-externo-2 href="${projeto['linkExterno2']}">${projeto['linkExterno2']}</a>
        </div>
        

        `;
    }


    function _getReuniaoHTML() {
      return `
      <form data-form-project-change>
      <div class="form-group">
        <label for="formGroupInserirReunião">Insira data para reunião:</label>
        <input type="date"  class="form-control" name="date" id="dataReuniao">
        <label for="formGroupInserirReunião">Insira um horário para reunião:</label>
        <input type="time"  class="form-control" name="horario" id="horaReuniao">
        <label for="formGroupInserirReunião">Insira um local para reunião:</label>
        <input type="text"  class="form-control" name="local" id="localReuniao">
        <span class="validity"></span>
        <label for="formGroupInserirReunião">Insira um assunto a ser tratado</label>
        <input type="text"  class="form-control" name="assunto" id="assuntoReuniao">
        <br>
        
      </div>
        <script>
           $(".modal-footer").remove();
      
           	
           	var profs = [];
           	  $(document).ready(function () {
           	  		
                $.getJSON("/professor/all", function(data){
                  
                  $.each(data, function(i){
                      
                    profs.push("<option value="+this.email+">" + "Nome: " + this.nome + " | Email: " + this.email + "</option> ");
                  });	

                  $('#professor').append(profs);
				        });
				      });
			      </script>
              <select multiple class="form-control country-professor" id="professor">
              </select>
            </div>      
            <button type="button" class="btn btn-success" id="insere-data" name="insere-data">Inserir</button>
        </form>
     
      `;
    }
    function insertReuniao(){
      
    }
    function _getEntregasHTML() {
      return `
        ${projeto.fase == 6 ? '<span class="badge badge-success">Concluído</span>' : '<span class="badge badge-danger">Pendente</span>'}
        <h5>Reunião</h5>
        <h6>Data: ${projeto.reuniao.data}</h6>
        <h6>Horario: ${projeto.reuniao.horario}</h6>
        <h6>Local: ${projeto.reuniao.local}</h6>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Aluno Responsável</th>
              <th scope="col">Link repositório</th>
              <th scope="col">Link Cloud</th>
              <th scope="col">Comentários</th>
            </tr>
          </thead>
          <tbody>
            ${
        projeto.entregas.map((entrega, index) =>
          `
                  <tr>
                    <th scope="row">${ index + 1}</th>
                    <td>${ entrega['alunoResponsavel']}</td>
                    <td><a href="${ entrega['linkRepositorio']}" target="_blank">${entrega['linkRepositorio']}</a></td>
                    <td><a href="${ entrega['linkCloud']}" target="_blank">${entrega['linkCloud']}</a></td>
                    <td>${ entrega.comentario}</td>
                  </tr>
                `
        ).join('')
        }
          </tbody>
        </table>
      `;
    }

    function _getNegadoHTML() {
      return `
        <h5>Projeto negado:</h5>
        <p>${ projeto.status.motivo}</p>
      `;
    }

    function _setInputPopupStructure(modelo) {
      var modeloHTML = {
        1: _getAvalInicHTML(),
        2: _getCadastroCompletoHTML(),
        3: _getAvalDetalHTML(),
        4: _getReuniaoHTML(),
        5: _getEntregasHTML(),
        negado: _getNegadoHTML()
      }[modelo];

      _customPopupElement(projeto, modeloHTML);
    }

    $(document.body).prepend(_getInitialModalHTML(projeto));

    _setInputPopupStructure(projeto.status.negado ? 'negado' : projeto.fase);

    var fases = [
      {
        icon: _getIcon(''),
        title: 'Cadastro Inicial',
        isActive: true,
        isPending: false,
        isWaitingForInput: projeto.fase == 0
      },
      {
        icon: _getIcon(''),
        title: 'Avaliação Inicial',
        isActive: projeto.fase > 1,
        isPending: false,
        isWaitingForInput: projeto.fase == 1
      },
      {
        icon: _getIcon(''),
        title: 'Cadastro Detalhado',
        isActive: projeto.fase > 2,
        isPending: projeto.fase == 2,
        isWaitingForInput: false //projeto.fase == 2 && (!projeto['descricao-completa'] || !projeto['descricaoTecnologica'])
      },
      {
        icon: _getIcon(''),
        title: 'Avaliação Detalhada',
        isActive: projeto.fase > 3,
        isPending: false,
        isWaitingForInput: projeto.fase == 3
      },
      {
        icon: _getIcon(''),
        title: 'Reunião',
        isActive: projeto.fase > 4,
        isPending: projeto.fase == 4 ,
        isWaitingForInput: projeto.fase == 4 //projeto.fase == 4 && projeto.reuniao['datas-possiveis'].length
      }, 
      {
        icon: _getIcon(''),
        title: 'Entrega',
        isActive: projeto.fase >= 5,
        isPending: projeto.fase == 5 && !projeto.entregas.length,
        isWaitingForInput: false
      }
    ];

    target.innerHTML = `
      <div class="timeline fase-${ projeto.fase} ${projeto.status.negado ? 'negado' : ''}">
      ${
      fases.map((fase, index) => {
        let tag = 'div';
        let extraAttributes = '';
        if (fase.isWaitingForInput || (index === 5 && fase.isActive) || projeto.status.negado) {
          tag = 'a';
          extraAttributes = `
              href="#" 
              data-toggle="modal" 
              data-target="#modal-extra-${ projeto._id}"
              data-open-to-input`;
        }
        return `
            <${ tag} 
              class="timeline__event" 
              ${ extraAttributes}>
              <div class="event-circle ${ _getEventClass(fase)}">
                ${ fase.icon}
              </div>
              <label class="event-label">${ fase.title}</label>
            </${ tag}>`;
      }).join('')
      }
      </div>
    `;
  }

  return {
    insertTimeline
  };
};