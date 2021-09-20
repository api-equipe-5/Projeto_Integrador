//criar token para login

(function() {
	let token = localStorage.getItem('token');
	let projetosAluno;
	let aluno; 
	
	
	if (!token) {
	    location.replace('/');
	  }
	else {
	    $.post("/aluno", JSON.stringify({ token }), 'json')
	        .done(function(userInfo){
	        aluno = JSON.parse(userInfo);
	        $('[email]').text(` | ${ aluno.email }`);
	
	        $.get('/dono', aluno.email)
	        	.done(function(projetos){
	                projetosAluno = JSON.parse(projetos);
	                insertProjectsOnTable(projetosAluno);
	              });
	        })
	        .fail(function () {
	         localStorage.removeItem('token');
	         location.replace('/');
	        });
	 }
}