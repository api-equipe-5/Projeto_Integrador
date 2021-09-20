<html>
<body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm fixed-top">
        <div class="my-0 mr-md-auto font-weight-normal">
            <img class="card-img-overlay" src="imagens/logo.jpeg" width="150px">
        </div>
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="Menu">Página Inicial</a>
            <a class="p-2 text-dark" href="Empresa">Empresa</a>
            <a class="p-2 text-dark" href="Conteudos">Conteúdos</a>
            <a class="p-2 text-dark" href="Contato">Contato</a>
            <a class="btn btn-outline-secondary p-1" style="background-color: #8e9194;" href="#">
                <img class="figure figure-caption" src="imagens/carrinho.png" width="30px">
            </a>
        </nav>
        <a class="btn btn-outline-primary" href="Logon"><?php echo $this->acc_status;?></a>
    </div>
    
    <?php 
        $data = $this->showCart();
        $total = 0.0;
        if(is_array($data) && !empty($data[0])){
            foreach($data as $var){
                $total += $var["valor"];
            }
            $cancel = null;
            $this->payment($data,$total);

        }else{
            $cancel = "disabled";
        }
        $total = number_format($total,2,",",".");
    ?>
    
    <div class="ml-5 mr-5 mb-5" style="margin-top: 8rem">
        
        <div class="d-flex flex-column flex-md-row align-items-center">
            <div class="my-0 mr-md-auto">
                <h1>Carrinho<h1>
            </div>

            <p class="p-1 m-1 mr-md-0 bg-info text-dark rounded"><strong>Total: <i>R$ <?php echo $total;?></i></strong></p>

            <div class="my-2 my-md-0 mr-md-3 ml-3">
                <a class="btn btn-outline-secondary <?php echo $cancel;?>" href="?con=clear">Limpar Carrinho</a>
                <button class="btn btn-outline-success" <?php echo $cancel;?> data-toggle="modal" data-target=".demo-popup">Comprar</button>
            </div>
        </div>

        <hr>
        <div class="container p-4 w-75">
        <?php
        if(is_array($data)){
            foreach($data as $var){
                require dirname(__DIR__)."/View/Cards/Cart_card.php";
            }
        }else{
            echo "<h3 class='text-dark justify-content-center bg-warning rounded p-2 w-50 mx-auto text-center'>".$data."</h3>";
        }
        ?>
        </div>
    </div>
</body>
</html>