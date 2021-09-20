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
            <a class="p-2 text-light mark" href="#">Contato</a>
            <a class="btn p-1" href="Carrinho">
                <img class="figure figure-caption" src="imagens/carrinho.png" width="30px">
            </a>
        </nav>
        <a class="btn btn-outline-primary" href="Logon"><?php echo $this->acc_status;?></a>
    </div>
 
    <div class="ml-5 mr-5 mb-5" style="margin-top: 8rem">
        <h2>Contato</h2>
        <hr>

        <?php
            $response = $this->message();
        ?>

        <form class="needs-validation" method="post">
        <div class="form-group">
            <div class="container">

                <div class="row pt-3 pr-3 pl-3 pb-1 border-bottom border-secondary">
                    <h5>
                        Entre em contato conosco para informar algum problema, dar sugestões 
                        ou fazer uma reclamação.
                    </h5>
                </div>

                <div class="row bg-light">

                    <div class="col pt-2">
                        <label for="title"><h4>Título</h4></label>
                        <input type="text" class="form-control mb-4" id="title" name="title" placeholder="Dê um título para a sua mensagem" required>
                        
                        <label for="email"><h4>E-mail</h4></label>
                        <input type="email" class="form-control mb-4" id="email" name="email" placeholder="Seu email" required>

                        <button type="submit" class="btn btn-secondary rounded-pill mr-2" name="submit" value="submit" aria-describedby="response">Enviar</button>
                        <button type="reset" class="btn btn-outline-primary rounded-pill">Limpar</button>

                        <small class="form-text text-muted mt-1 ml-2" id="response">
                            <?php echo $response;?>
                        </small>
                    </div>
                

                    <div class="col pt-2">
                        <label for="content"><h4>Mensagem</h4></label>
                        <textarea class="form-control mb-4" id="content" name="content" rows="10" placeholder="Escreva sua mensagem" required></textarea>
                    </div>
                    
                </div>
                
            </div>
            

            

        </div>
        </form>
    </div>
</body>
</html>