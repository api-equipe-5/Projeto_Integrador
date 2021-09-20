<div class="card mb-md-5 mr-md-auto" style="width: 18rem">
  <div class="card-body">
    <h4 class="card-title"><?php echo $name;?></h4>
    <p class="card-text"><?php echo $descrip;?></p>

    <a href="Item?i=<?php echo $name;?>" class="btn btn-outline-primary" aria-describedby="response"><b>Ver Item</b></a>
    
    <a href="?i=<?php echo $_GET["i"];?>&con=add,<?php echo $name;?>" class="btn btn-outline-success <?php echo $cancel;?>">
      <b>R$ <?php echo $value;?></b>
      <img class="figure figure-caption rounded" src="imagens/carrinho.png" width="20px">
    </a>

    <small class="form-text text-muted" id="response"><?php if(isset($_GET["con"]) && substr($_GET["con"],4) == $name){echo $resp;}?></small>
  </div>
</div>