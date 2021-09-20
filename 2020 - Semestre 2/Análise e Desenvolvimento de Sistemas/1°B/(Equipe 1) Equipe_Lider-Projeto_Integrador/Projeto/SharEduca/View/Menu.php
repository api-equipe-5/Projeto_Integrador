<html>
<body>
    <div class="d-flex flex-column flex-md-row-reverse align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm fixed-top">
        <a class="btn btn-outline-primary" href="Logon"><?php echo $this->acc_status;?></a>
        
        <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-light mark" href="#">Página Inicial</a>
            <a class="p-2 text-dark" href="Empresa">Empresa</a>
            <a class="p-2 text-dark" href="Conteudos">Conteúdos</a>
            <a class="p-2 text-dark" href="Contato">Contato</a>
            <a class="btn p-1" href="Carrinho">
                <img class="figure figure-caption" src="imagens/carrinho.png" width="30px">
            </a>
        </nav>
    </div>

    <img class="img w-25 mt-5 mx-auto d-block" src="imagens/logo.jpeg"/>
    
    <?php
        #print_r($this->user);
    ?>

    <div class="ml-5 mr-5 mb-5" style="margin-top: 8rem;">
        <hr>
        <?php $data = $this->carousel();?>
        
        <div id="carouselIndicators" class="carousel slide w-75 h-75 mx-auto" data-ride="carousel">
            <ol class="carousel-indicators">
            <?php
                for($x=0;$x<$data["count"];$x++){
                    echo "<li data-target='#carouselIndicators' data-slide-to='<? echo $x;?>' class='active'></li>";
                }
            ?>
            </ol>
            <div class="carousel-inner">
                <?php
                    for($x=0;$x<$data["count"];$x++){
                        $var = "<div class='carousel-item";
                        if($x<1){
                            $var = $var." active'>";
                        }else{
                            $var = $var."'>";
                        }
                        $var = $var."<img class='d-block w-100 h-100 rounded' src='imagens/".$data["img"][$x]."' alt='Slide-$x'>
                                <div class='carousel-caption d-none d-md-block ml-md-5 mr-md-5 bg-dark text-light rounded-pill'>
                                    <h5>".$data["name"][$x]."</h5>
                                    <p>".$data["descrip"][$x]."</p>
                                </div>
                            </div>"
                        ;
                        echo $var;
                    }
                ?>
                
            </div>
            <a class="carousel-control-prev" href="#carouselIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <hr>

    </div>
</body>
</html>