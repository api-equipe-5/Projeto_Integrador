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

    <div class="ml-5 mr-5" style="margin-top: 9rem">
        <h2>
            <a href="Conteudos" class='btn btn-outline-primary rounded-circle'><img class="rounded-circle" height="5%" src='imagens/back_arrow.png'></a>
            <?php
                $this->addContent();
                if($this->resp == ""){
                    echo "Novo Conteúdo";
                }else{
                    echo "<u>".$this->resp."</u>";
                }
            ?>
        </h2>
        <hr>
        <form method="post" enctype="multipart/form-data">
        <div class="form-group">

            <label for="name">Nome do conteúdo</label>
            <input type="text" class="form-control mb-4" id="name" name="name" placeholder="Nome do conteúdo">

            <label for="imgSelect">Escolha uma imagem para o conteúdo:</label>
            <input type="file" class="form-control-file mb-4" accept="image/*" id="imgSelect" name="file">
        
        

            <label for="formControlTextarea">Descrição</label>
            <textarea class="form-control" id="formControlTextarea" name="descrip" rows="4" placeholder="Descrição do conteúdo"></textarea>
        </div>

        <input type="hidden" name="content" value="<?php echo $_GET["i"];?>" />

        <button type="submit" class="btn btn-primary mr-2" name="upload" value="upload">Adicionar</button>
        <button type="reset" class="btn btn-primary">Limpar</button>
        </form>
    </div>
    
    
</body>
</html>