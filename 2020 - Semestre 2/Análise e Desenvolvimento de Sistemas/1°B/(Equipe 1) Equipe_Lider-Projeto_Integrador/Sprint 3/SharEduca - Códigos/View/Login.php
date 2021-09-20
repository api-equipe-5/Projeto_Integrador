<html>
<body>
    
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm fixed-top">
        <div class="my-0 mr-md-auto font-weight-normal">
            <img class="card-img-overlay" style="border-radius: 35px;" src="imagens/logo.jpeg" width="150px">
        </div>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="Menu">Página Inicial</a>
            <a class="p-2 text-dark" href="Empresa">Empresa</a>
            <a class="p-2 text-dark" href="Conteudos">Conteúdos</a>
            <a class="p-2 text-dark" href="Contato">Contato</a>
            <a class="p-2" href="Carrinho">
                <img class="figure figure-caption" src="imagens/carrinho.png" width="30px">
            </a>
        </nav>
        <a class="btn btn-outline-primary" href="Logon"><?php echo $this->acc_status;?></a>
    </div>

    <?php $this->login();?>
    
    <div class="ml-5 mr-5 mb-5" style="margin-top: 6rem">
        <form action="Menu" method="post" enctype="multipart/form-data">
            <div class="card mt-0 w-50 mx-auto border-dark">
                
                <div class="card-header">
                    Cadastrar
                </div>

                <div class="card-body">
                    <label for="username" class="mb-0"><h5>Nome</h5></label>
                    <input type="text" class="form-control border-dark mb-4" id="username" name="nome">

                    <label for="email" class="mb-0"><h5>Email</h5></label>
                    <input type="email" class="form-control border-dark mb-4" id="email" name="email">

                    <label for="pass" class="mb-0"><h5>Senha</h5></label>
                    <input type="password" class="form-control border-dark mb-4" id="pass" name="senha">

                    <label for="multSelect" class="mb-0"><h5>Como você ficou sabendo a respeito do <cite title="SharEduca">SharEduca</cite>? <small class="font-italic">(Opcional)</small></h5></label>
                    <select multiple class="form-control border-dark" id="multSelect" name="mult">
                        <option>Mecanismo de Busca</option>
                        <option>Redes Sociais</option>
                        <option>Soube por meio de um amigo</option>
                    </select>

                    <button type="submit" class="btn btn-primary mt-4" name="submit_login">Entrar</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>