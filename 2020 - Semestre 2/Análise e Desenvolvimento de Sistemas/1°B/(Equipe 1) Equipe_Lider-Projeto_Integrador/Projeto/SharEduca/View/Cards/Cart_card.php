<div class='row mb-4'>
    <div class='col pl-3 pt-2 pb-2 w-50 bg-info rounded'>
        <h2>Título: <?php echo $var["nome"]; ?></h2>
        <h5 class='mr-md-3'>R$ <?php echo str_replace(".",",",$var["valor"])." / ".$var["tamanho"]; ?></h5>
        <hr>
        <h4><?php echo $var["descrip"] ?></h4>
    </div>
    <div class='col-sm-auto pt-1 '>
        <div class='row-cols-1 m-1'>
            <a class='btn btn-outline-primary' href='Item?i=<?php echo $var["nome"]; ?>'>Ver Item</a>
        </div>    
        <div class='row-cols-1 m-1'>
            <a class='btn btn-outline-danger' href='?con=remove,<?php echo $var["nome"]; ?>'>Remover</a>
        </div>
    </div>
</div>