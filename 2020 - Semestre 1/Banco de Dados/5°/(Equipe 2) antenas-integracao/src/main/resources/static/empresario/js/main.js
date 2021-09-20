(function() {

  let timeline = new Timeline('/projeto/update');

  let maisInfoModal = $('#modal-mais-info');

  Fetch.get(`/empresario/byID`).then(empresario => {
    Fetch.get(`/projeto/byempresario/${empresario.email}`).then(projetos => {
      projetos.forEach(projeto => {
  
            let tr = $.parseHTML(`
            <tr data-project-item="${ projeto._id }">
              <th scope="row">${ projeto.titulo }</th>
              <td data-timeline-show></td>
              <td>
                <a href="#" data-toggle="modal" data-target="#modal-mais-info">Mais informações</a>
              </td>
            </tr>
          `);

         let $tr = $(tr);

         $tr.click(function(e) {
        
          e.preventDefault();
  
          maisInfoModal.find('#modal-label').text(projeto.titulo);
  
          let pegaElemento = id => $(maisInfoModal.find(`#${id}`));
  
          let elements = [
            {
              element: pegaElemento('info-descricao-breve'),
              key: 'descricaoBreve'
            },          
            {
              element: pegaElemento('info-descricao-completa'),
              key: 'descricaoCompleta'
            },
            {
              element: pegaElemento('info-descricao-tecnologias'),
              key: 'descricaoTecnologica'
            },
            {
              element: pegaElemento('info-links-externos'),
              key: '',
              excessao: true
            },
            {
              element: pegaElemento('info-link-externo-1'),
              key: 'linkExterno1'
            },
            {
              element: pegaElemento('info-link-externo-2'),
              key: 'linkExterno2'
            },
            {
              element: pegaElemento('info-responsavel-cadi'),
              key: 'responsavelCadi'
            },
            {
              element: pegaElemento('info-professores-responsaveis'),
              key: 'responsavelProfessor',
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
          console.log(elements);
          elements.forEach(item => {
  
            let contentElement = item.element.find('[data-text-content]');
  
            if (item.key.indexOf('linkExterno') != -1) {
              contentElement.attr('href', projeto[item.key]);
            }
  
            if (item.key && !item.excessao) {
              if (!projeto[item.key]) {
                item.element.addClass('d-none');
                return;
              }
              else {
                contentElement.text(projeto[item.key]);
              }
            }
            else if (!item.key) {
              if (!projeto['linkExterno1'] && !projeto['linkExterno2']) {
                item.element.addClass('d-none');
                return;
              }
            }
            else if (item.key === 'status') {
              if (!projeto.status.negado) {
                item.element.addClass('d-none');
                return;
              }
              else {
                contentElement.text(projeto.status.motivo);
              }
            }
            else if (item.key === 'reuniao') {
              let reuniao = projeto.reuniao;
              
              if (!reuniao.data && !reuniao.horario && !reuniao.local) {
                item.element.addClass('d-none');
                return;
              }
              else {
                contentElement.text(`${reuniao.data} - ${reuniao.horario} - ${reuniao.local}`);
              }
            }
            else if (item.key === 'entregas' || item.key ==='responsavelProfessor') {
              
              if (!projeto[item.key].length || projeto[item.key].length === null) {
                item.element.addClass('d-none');
                return;
              }
              else {
                projeto[item.key].forEach(x => {
                  contentElement.append($.parseHTML(`<li>${x}</li>`));
                });
              }
            }
          });
        });


         timeline.insertTimeline($tr.find('[data-timeline-show]').get(0), projeto);

        $('[data-projects-table-body]').append(tr);
      });
    });



  
  
  let defaultModel = {
    titulo: '',
    'descricaoBreve': '',
    'descricaoCompleta': '',
    'descricaoTecnologica': '',
    'linkExterno1': '',
    'linkExterno2': '',
    fase: 0,
    status: {
      negado: false,
      motivo: ''
    },
    'responsavelEmpresario': '',
    'responsavelCadi': '',
    reuniao:{
      data:'',
      horario:'',
      local:'',
      datasPossiveis:['']
    }
  };


  $('[data-publish-project]').click(function(e) {
    
    let formNewProject = $('[data-form-new-project]');
    let inputsData = formNewProject.serializeArray();
    let projeto = {
      ...defaultModel,
      fase: 1,
      'responsavelEmpresario': empresario.email
    };


    inputsData.forEach(input => {
      projeto[input.name] = input.value; 
    });

    Fetch.post("/projeto/save", projeto).then(() => {
      console.log(projeto)
      /*const $form = document.getElementById("formulario");
      $form.reset();
      carregarTarefas();*/
    });

    // $.ajax({
    //   type: "POST",
    //   url: '/projeto/save',
    //   data: JSON.stringify(projeto),
    //   success: function() {
    //     location.reload();
    //   },
    //   dataType: 'json'
    // });
  });

  $('[data-empresario-logout]').click(function(e){
    e.preventDefault();
    if (confirm('Realmente deseja Sair ?')) {
      $.get("/logout").fail( e => console.log(e));
      location.replace('/');
    }
  })

});
})();