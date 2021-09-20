<div class="card mb-md-5 mr-md-auto" style="width: 18rem">
  <img class="card-img-top w-100 h-auto rounded-sm" src="imagens/<?php echo $img;?>" alt="Card image cap" />
  <div class="card-body">
    <h4 class="card-title"><?php echo $name;?></h4>
    <p class="card-text"><?php echo $descrip;?></p>
    <a href="List_Item?i=<?php echo $name;?>" class="btn btn-outline-primary btn-block"><b>Ver Conteúdo</b></a>
  </div>
</div>

<!--
<div class="form-row align-items-center">
    <div class="col-auto">
        <h2><php echo $name;?></h2>    
        <img class="figure figure-caption" src="imagens/<php echo $img;?>" width="150px"> 
    </div>
    
    <input type="hidden" value="show" name="item">

    <div class="col-auto">
        <button class="btn btn-outline-primary mb-2" type="submit" value="Cart" name="cart"><b>Adicionar ao Carrinho</b></button>
    </div>
</div>
-->