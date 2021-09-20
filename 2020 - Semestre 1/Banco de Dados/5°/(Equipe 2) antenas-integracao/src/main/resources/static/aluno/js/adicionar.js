$(document).ready(function () {

	document.getElementById('cadastro').style.display = 'none';

	//let email = sessionStorage.getItem("sess_email_aluno");
	let tela = document.querySelector('#tabela-projetos');
	let telaemail = document.getElementById('bodyemail');
	let rota = "/projeto/bychave/"
	let retorno = {}

	/* Pegando os dados do aluno logado */
	Fetch.get(`/aluno/byID`).then(aluno => {
		
		console.log(aluno)
		Fetch.get(`/projeto/byaluno/${aluno.email}`).then(projects => {
			
			$('#botao-add').click(function () {

				let codigoProjeto = $("#codigo-projetoLabel").val();
				Fetch.get(`${rota+codigoProjeto}`).then(projeto => {
					
					projeto.alunos.push(aluno.email)
			
					Fetch.post("/projeto/update", projeto).then(() => {
					  		console.log(projeto);
					});
				});
		
			});
			if(projects != null){
				projects.forEach(project => {
					let tr = $.parseHTML(`<tr>
							<th>${project['chave']}</th>
							<th>${project['titulo']}</th>
							<th>${project['fase']}</th>	
							<th><button onclick="abrePopupEntregar(event,chave='${project['chave']}')">Entregar</button></th>			 
						</tr>`);
					$('#tpjr').append(tr);
				});
			}
		});


		$('#entregarProjeto').click(function(){
				var chave = $('#chaveProjeto').val();
				let alunos = [];
				let temp = document.getElementById('myTable');
				for (i = 1; i < temp.rows.length ; i++) {
					let aluno = temp.rows[i].firstElementChild.outerText;
					alunos.push(aluno);
				}
				let entrega = {
					"alunoResponsavel": $('#Link-cadastro').val(),
					"alunos": alunos,
					"linkRepositorio": $('#Link-cadastro').val(),
					"linkCloud": $('#Link-cloud').val(),
					"comentario": $('#desc-cadastro').val()
				}
				Fetch.get(`/projeto/bychave/${chave}`).then(projeto => {
					projeto.entregas.push(entrega);
					console.log(projeto)
					Fetch.post("/projeto/update", projeto).then(() => {
						alert("Entrega realizada!");
					});
				});	
				
		})

	});


	

	function abrePopupLogin(event) {
		event.preventDefault();
		document.getElementById('login').style.display = 'block';
	}

	function fechaPopupLogin(event) {
		event.preventDefault();
		document.getElementById('login').style.display = 'none';
	}
	
	$('[data-aluno-logout]').click(function(e){
		e.preventDefault();
		if (confirm('Realmente deseja Sair ?')) {
		  $.get("/logout").fail( e => console.log(e));
		  location.replace('/');
		}
	  })

});	