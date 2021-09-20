var Timeline = function (endpoint) {

  if (!endpoint) {
    throw new Error('É preciso de um endpoint de salvamento de projeto para instanciar Timeline');
  }
  else if (!window.jQuery || !$().emulateTransitionEnd) {
    throw new Error('É preciso que o Bootstrap 4 (CSS e JS) e o JQuery esteja sendo importado');
  }

  function _getInitialModalHTML(projeto) {
    return `
      <div class="modal fade" id="modal-extra-${ projeto._id}" tabindex="-1" role="dialog" aria-labelledby="modal-label" aria-hidden="true">
        <div class="modal-dialog" role="document">
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
    `;
  }

  function _customPopupElement(projeto, inputsHTML) {

    let modalExtra = `#modal-extra-${projeto._id} `;

    $('#modal-label').text(projeto.titulo);

    $(modalExtra + '.modal-body').html(inputsHTML);

    if ([2, 4].indexOf(projeto.fase) != -1) {
      $(modalExtra + '.modal-footer').append(`
        <button type="button" class="btn btn-primary" data-send-changes>Enviar alterações</button>
      `);

      $('[data-send-changes]').click(function (e) {

        let newProject = { ...projeto };

        if (projeto.fase === 2) {

          let descCompleta = $('[data-descricao-completa]').val();
          let descTecnologias = $('[data-descricao-tecnologias]').val();
          let linkExterno2 = $('[data-link-externo-2]').val();

          if (descCompleta && descTecnologias) {

            newProject = {
              ...newProject,
              fase: 3,
              'descricao-completa': descCompleta,
              'descricao-tecnologias': descTecnologias,
              'link-externo-2': linkExterno2
            };

            $.post(endpoint, JSON.stringify(newProject))
              .done(() => location.reload());
          }
        }
        else if (projeto.fase === 4) {

          let horarioReuniao = $('[data-reuniao]').val().split('-');

          if (horarioReuniao) {

            newProject = {
              ...newProject,
              fase: 5,
              reuniao: {
                data: reuniaoData[0],
                horario: reuniaoData[1]
              }
            };

            $.post(endpoint, JSON.stringify(newProject))
              .done(() => location.reload());
          }
        }
      });
    }
    else if (projeto.fase == 5) {
      $('.modal-dialog').addClass('modal-xl');
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

    function _getCadastroCompletoHTML() {
      return `
        <form data-form-project-change>
          <div class="form-group">
            <label for="desc-completa">Descrição Completa:</label>
            <textarea data-descricao-completa class="form-control" id="desc-completa" rows="3">${projeto['descricao-completa']}</textarea>
          </div>
          <div class="form-group">
            <label for="desc-tecnologias">Descrição das Tecnologias:</label>
            <textarea data-descricao-tecnologias class="form-control" id="desc-tecnologias" rows="3">${projeto['descricao-tecnologias']}</textarea>
          </div>
          <div class="form-group">
            <label for="link-externo-2">Link externo 2:</label>
            <input data-link-externo-2 type="text" class="form-control" value="${projeto['link-externo-2']}" id="link-externo-2">
          </div>
        </form>`;
    }

    function _getReuniaoHTML() {
      return `
        <form data-form-project-change>
          <div class="form-group">
            <label for="data-reuniao">Escolha uma data para a reunião:</label>
            <select data-reuniao id="data-reuniao" class="form-control">
              ${
        projeto.reuniao['datas-possiveis'].map(dataHora =>
          `<option value="${dataHora.data}-${dataHora.hora}">${dataHora.data} - ${dataHora.hora}</option>`)
        }
            </select>
          </div>
        </form>
      `;
    }

    function _getEntregasHTML() {
      return `
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
                    <td>${ entrega['aluno-responsavel']}</td>
                    <td><a href="${ entrega['link-repositorio']}" target="_blank">${entrega['link-repositorio']}</a></td>
                    <td><a href="${ entrega['link-cloud']}" target="_blank">${entrega['link-cloud']}</a></td>
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
        2: _getCadastroCompletoHTML(),
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
        isWaitingForInput: false
      },
      {
        icon: _getIcon(''),
        title: 'Avaliação Inicial',
        isActive: projeto.fase > 1,
        isPending: projeto.fase == 1,
        isWaitingForInput: false
      },
      {
        icon: _getIcon(''),
        title: 'Cadastro Detalhado',
        isActive: projeto.fase > 2,
        isPending: false,
        isWaitingForInput: projeto.fase == 2 && (!projeto['descricao-completa'] || !projeto['descricao-tecnologias'])
      },
      {
        icon: _getIcon(''),
        title: 'Avaliação Detalhada',
        isActive: projeto.fase > 3,
        isPending: projeto.fase == 3,
        isWaitingForInput: false
      },
      {
        icon: _getIcon(''),
        title: 'Reunião',
        isActive: projeto.fase > 4,
        isPending: projeto.fase == 4 && !projeto.reuniao['datas-possiveis'].length,
        isWaitingForInput: projeto.fase == 4 && projeto.reuniao['datas-possiveis'].length
      },
      {
        icon: _getIcon(''),
        title: 'Entrega',
        isActive: projeto.fase == 5 && projeto.entregas.length,
        isPending: projeto.fase == 5 && !projeto.entregas.length,
        isWaitingForInput: false
      },
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
