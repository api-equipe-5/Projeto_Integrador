<html>
<head>
<meta charset="utf-8">
	<title>js2</title>
	<link rel="stylesheet" type="text/css" href="tabela2.css" >
	<script type="text/javascript" src="../jquery/jquery/jquery-1.12.3.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('table#horario tbody tr:odd').addClass('impar');
	
		//continuação para o exemplos2
		$('table#horario tbody tr:even').addClass('par');
		$('table#horario tbody tr').hover(
			function() {
				$(this).addClass('destacar');
			},
			function() {
				$(this).removeClass('destacar');
			});//fim do exemplos2
	});
	</script>
</head>
<body>
<table id="horario" >
<h1>Exemplo Tabela 2</h1>
<caption>Viação Alfa-Horários</caption>
<thead>
<tr id="horizontal">
<th>Destino</th>

<th scope="col">Saída</th>

<th scope="col">Chegada</th>
<th scope="col">Classe</th>

<th scope="col">Tarifa</th>

<th scope="col">Frequência</th>
</tr>
</thead>
<tbody>
	<td>Brusque</td>
	<td>06:45</td>
	<td>14:30</td>
	<td>Convecional</td>
	<td>R$80.00</td>
		<td>Diária</td>
</tbody>
<tbody>
	<td>Joinville</td>
	<td>12:30</td>
	<td>21:00</td>
	<td>Convecional</td>
	<td>R$100.00</td>
		<td>Sábado</td>
</tbody>
<tbody>
	<td>São Paulo</td>
	<td>19:00</td>
	<td>06:00</td>
	<td>Leito</td>
	<td>R$150.00</td>
		<td>Diária</td>
</tbody>
<tbody>
	<td>Porto União</td>
	<td>13:00</td>
	<td>18:00</td>
	<td>Convecional</td>
	<td>R$60.00</td>
		<td>Diária</td>
</tbody>
<tbody>
	<td>Caçador</td>
	<td>00:30</td>
	<td>23:00</td>
	<td>Exercutivo</td>
	<td>R$210.00</td>
		<td>Seg. e Dom</td>
</tbody>
<tbody>
	<td>Sorocaba</td>
	<td>21:15</td>
	<td>23:45</td>
	<td>Leito</td>
	<td>R$280.00</td>
		<td>Sábado</td>
</tbody>
<tbody>
	<td>Blumenau</td>
	<td>08:00</td>
	<td>16:00</td>
	<td>Convecional</td>
	<td>R$85.00</td>
		<td>Diária</td>
</tbody>
<tbody>
	<td>Itajai</td>
	<td>23:00</td>
	<td>06:00</td>
	<td>Executivo</td>
	<td>R$165.00</td>
		<td>Qua. e Sáb</td>
</tbody>
<tbody>
	<td>Lojes</td>
	<td>16:45</td>
	<td>19:30</td>
	<td>Executivo</td>
	<td>R$50.00</td>
		<td>Terça</td>
</tbody>
<tbody>
	<td>Urussanga</td>
	<td>14:30</td>
	<td>20:00</td>
	<td>Leito</td>
	<td>R$100.00</td>
		<td>Sábado</td>
</tbody>
<tbody>
	<td>Conoinhas</td>
	<td>19:30</td>
	<td>07:30</td>
	<td>Leito</td>
	<td>R$190.00</td>
		<td>Seg. a Sex</td>
</tbody>
<tbody>
	<td>S.Fco.Sul</td>
	<td>01:00</td>
	<td>07:00</td>
	<td>Convencional</td>
	<td>R$90.00</td>
		<td>Qua. a Sex</td>
</tbody>
<tbody>
	<td>Joaçaba</td>
	<td>06:30</td>
	<td>12:00</td>
	<td>Executivo</td>
	<td>R$70.00</td>
		<td>Seg. e Qua</td>
</tbody>
<tbody>
	<td>Jaraçua do Sul</td>
	<td>23:15</td>
	<td>06:45</td>
	<td>Leito</td>
	<td>R$250.00</td>
		<td>Sábado</td>
</tbody>
<tbody>
	<td>Xanxerê</td>
	<td>18:00</td>
	<td>22:00</td>
	<td>Executivo</td>
	<td>R$75.00</td>
		<td>Diária</td>
</tbody>
<tbody>
	<td>Chapecô</td>
	<td>13:00</td>
	<td>21:00</td>
	<td>Executivo</td>
	<td>R$105.00</td>
		<td>Qua. e Dom</td>
</tbody>
<tbody>
	<td>Xaxim</td>
	<td>07:00</td>
	<td>14:00</td>
	<td>Executivo</td>
	<td>R$165.00</td>
		<td>Dom</td>
</tbody>
<tfoot>
<tr>
	<td colspan="6" ><p align="center">Válida para o período de 02/10/2008 a 30/11/2008.</p>
	</td>
</tr>
</tfoot>
</html>