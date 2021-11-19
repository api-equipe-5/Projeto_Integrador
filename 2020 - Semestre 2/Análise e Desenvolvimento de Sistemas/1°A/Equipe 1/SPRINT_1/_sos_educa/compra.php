
<h1 align="center" class="h1">
<a href="index.php#compras" align='left'><img src="img/icon/home.svg" width="50px" height="50px"></a>
Carrinho de compras
</h1>
<?php 
session_start();
include("cabecalho.php");
if(@$_POST['compra']=="Finalizar Compra"){
 echo "<script>window.location.href='finalizarcompra.php?produtos=".$_POST['produtos']."&valortotal=".$_POST['valorfinal']."'</script>";
 die();
}


unset($_SESSION['quantidade'.@$_GET['nome']]);

include("conexao.php");

$query= mysqli_query($conexao,"select * from estoque");
while ($linha = mysqli_fetch_array($query)) {
	@$nomes =  $nomes."/".@$linha['nome_prod'];
}
$_SESSION['produtos']= $nomes;
if(@$_POST['atualizar']=="Atualizar"){
	$explode = explode("/", $_SESSION['produtos']);
			foreach ($explode as $key => $value) {
	@$quantidade = $_POST[$value];
	
	@$_SESSION['quantidade'.$value]=$quantidade;

			}
}else if(isset($_POST['comprar'])){
		$explode = explode("/", $_SESSION['produtos']);
		
			foreach ($explode as $key => $value) {
				$value = implode("",explode(" ",$value));
				
				@$_SESSION['quantidade'.$value]=@$_POST[$value]+$_SESSION['quantidade'.$value];
	

}


}
?>
<form action="compra.php" method="POST">
<table class='table table-striped'>

<tr>
	<th>Nome</th>
	<th>Preço unitário</th>
	<th>Excluir do carrinho</th>
<?php
$exp = explode("/", @$_SESSION['produtos']);
$valorfinal=0;
$produtos="";
foreach ($exp as $key => $value) {
	@$quantidade = $_POST[$value];
	@$qtd = $_SESSION['quantidade'.$value];
	$max = mysqli_fetch_array(mysqli_query($con,"select estoque from produtos where nome_prod='".$value."'"));

if(@$_SESSION['quantidade'.$value]>0){

		$total = $qtd * $max['valor'];
	
	echo "<h2><tr><td>$value</td><td><input type='number' class='form-control' max='".$max['quantidade']."' name='$value' width='50' value='".$qtd."'></td><td>R$".number_format($max['valor'],2,",",".")."</td><td>R$".number_format($total,2,",",".")."</td><td><a href='compra.php?nome=".$value."'><div class='glyphicon glyphicon-remove' aria-hidden='true'></div></a></td>";
	$valorfinal = $valorfinal+ $total;
	$produtos = $produtos."-".$value;
	@$qtdtotal = $qtdtotal+$_SESSION['quantidade'.$value];

	}
}
?>

<input type="hidden" name="valorfinal" value="<?php echo $valorfinal; ?>">
<input type="hidden" name="produtos" value="<?php echo $produtos; ?>">


<?php if(@$qtdtotal==0){

	 echo "<script>alert('carrinho vazio selecione alguns produtos'); window.location.href='index.php#compras';</script>";
?>

<?php } ?>
<tr><td><input class="btn btn-secondary" type="submit" name="atualizar" value="Atualizar"></td><td></td><td></td><th>Total:</th><td><?php echo "R$". number_format($valorfinal,2,",",".") ?> </td>

</table>
<input type='submit' class="btn btn-primary" name="compra" value="Finalizar Compra">
</form>