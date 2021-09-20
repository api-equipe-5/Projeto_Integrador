(function() {

  let token = localStorage.getItem('token');
  let projects;
  let empresario;

  if (!token) {
    location.replace('/');
  }
  else {
    $.post("/is-auth", JSON.stringify({ token }), 'json')
        .done(function(userInfo){
          empresario = JSON.parse(userInfo);
          $('[data-empresario-nome]').text(` | ${ empresario.nome }`);

          $.get('/buscaprojetoporempresario', empresario.email)
              .done(function(projetos){
                projects = JSON.parse(projetos);
                insertProjectsOnTable(projects);
              });
        })
        .fail(function () {
          localStorage.removeItem('token');
          location.replace('/');
        });
  }

  let timeline = new Timeline('/atualizaProjeto');

  let maisInfoModal = $('#modal-mais-info');

  let defaultModel = {
    titulo: '',
    'descricao-breve': '',
    'descricao-completa': '',
    'descricao-tecnologias': '',
    'link-externo-1': '',
    'link-externo-2': '',
    fase: 0,
    reuniao: {
      data: '',
      horario: '',
      local: '',
      'datas-possiveis': []
    },
    status: {
      negado: false,
      motivo: ''
    },
    entregas: [],
    alunos: [],
    'responsavel-cadi': '',
    'responsavel-professor': [],
    'responsavel-empresario': ''
  };

  function insertProjectsOnTable(projecs) {
    
    let tbody = $('[data-projects-table-body]');

    projecs.forEach(project => {
      let tr = $.parseHTML(`
        <tr data-project-item="${ project._id }">
          <th scope="row">${ project.titulo }</th>
          <td data-timeline-show></td>
          <td>
            <a href="#" data-toggle="modal" data-target="#modal-mais-info">Mais informações</a>
          </td>
        </tr>
      `);

      let $tr = $(tr);

      $tr.click(function(e) {
        
        e.preventDefault();

        maisInfoModal.find('#modal-label').text(project.titulo);

        let pegaElemento = id => $(maisInfoModal.find(`#${id}`));

        let elements = [
          {
            element: pegaElemento('info-descricao-breve'),
            key: 'descricao-breve'
          },          
          {
            element: pegaElemento('info-descricao-completa'),
            key: 'descricao-completa'
          },
          {
            element: pegaElemento('info-descricao-tecnologias'),
            key: 'descricao-tecnologias'
          },
          {
            element: pegaElemento('info-links-externos'),
            key: '',
            excessao: true
          },
          {
            element: pegaElemento('info-link-externo-1'),
            key: 'link-externo-1'
          },
          {
            element: pegaElemento('info-link-externo-2'),
            key: 'link-externo-2'
          },
          {
            element: pegaElemento('info-responsavel-cadi'),
            key: 'responsavel-cadi'
          },
          {
            element: pegaElemento('info-professores-responsaveis'),
            key: 'responsavel-professor',
            excessao: true
          },
          {
            element: pegaElemento('info-reuniao'),
            key: 'reuniao',
            excessao: true
          },
          {
            element: pegaElemento('info-entregas'),
            key: 'entregas',
            excessao: true
          },
          {
            element: pegaElemento('info-negado'),
            key: 'status',
            excessao: true
          }
        ];

        elements.forEach(item => {

          let contentElement = item.element.find('[data-text-content]');

          if (item.key.indexOf('link-externo') != -1) {
            contentElement.attr('href', project[item.key]);
          }

          if (item.key && !item.excessao) {
            if (!project[item.key]) {
              item.element.addClass('d-none');
              return;
            }
            else {
              contentElement.text(project[item.key]);
            }
          }
          else if (!item.key) {
            if (!project['link-externo-1'] && !project['link-externo-2']) {
              item.element.addClass('d-none');
              return;
            }
          }
          else if (item.key === 'status') {
            if (!project.status.negado) {
              item.element.addClass('d-none');
              return;
            }
            else {
              contentElement.text(project.status.motivo);
            }
          }
          else if (item.key === 'reuniao') {
            let reuniao = project.reuniao;
            
            if (!reuniao.data && !reuniao.horario && !reuniao.local) {
              item.element.addClass('d-none');
              return;
            }
            else {
              contentElement.text(`${reuniao.data} - ${reuniao.horario} - ${reuniao.local}`);
            }
          }
          else if (item.key === 'entregas' || item.key ==='responsavel-professor') {
            
            if (!project[item.key].length) {
              item.element.addClass('d-none');
              return;
            }
            else {
              project[item.key].forEach(x => {
                contentElement.append($.parseHTML(`<li>${x}</li>`));
              });
            }
          }
        });
      });

      timeline.insertTimeline($tr.find('[data-timeline-show]').get(0), project);

      tbody.append(tr);
    });
  }

  $('[data-publish-project]').click(function(e) {
    
    let formNewProject = $('[data-form-new-project]');
    let inputsData = formNewProject.serializeArray();
    let project = {
      ...defaultModel,
      fase: 1,
      'responsavel-empresario': empresario.email
    };

    inputsData.forEach(input => {
      project[input.name] = input.value; 
    });

    $.ajax({
      type: "POST",
      url: '/cadastroprojeto',
      data: JSON.stringify(project),
      success: function() {
        location.reload();
      },
      dataType: 'json'
    });
  });

  $('[data-empresario-logout]').click(function(e){

    e.preventDefault();

    localStorage.removeItem('token');
    location.replace('/');
  })
})();