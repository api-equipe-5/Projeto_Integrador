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
            <a class="btn p-1" href="Carrinho">
                <img class="figure figure-caption" src="imagens/carrinho.png" width="30px">
            </a>
        </nav>
        <a class="btn btn-outline-primary active" href="#"><?php echo $this->acc_status;?></a>
    </div>

    <div class="ml-5 mr-5 mb-5" style="margin-top: 6rem">

        <?php $this->logon();?>
        
        <form method="post" enctype="multipart/form-data">
            <div class="card m-2 w-50 mx-auto">
                <div class="card-header">
                    Entrar
                </div>
                <div class="card-body">
                    <label for="username" class="mb-0"><h5>Nome ou Email</h5></label>
                    <input type="text" class="form-control border-dark mb-4" id="username" name="user">

                    <label for="pass" class="mb-0"><h5>Senha</h5></label>
                    <input type="password" class="form-control border-dark mb-4" id="pass" name="senha">

                    <button type="submit" class="btn btn-primary mt-4" aria-describedby="response" name="submit_logon">Entrar</button>
                    <a class="btn btn-outline-primary mt-4" href="Login">Criar conta</a>
                    <small id="response" class="form-text text-muted"><?php echo $this->resp;?></small>
                </div>
            </div>
        </form>
    </div>
</body>
</html>