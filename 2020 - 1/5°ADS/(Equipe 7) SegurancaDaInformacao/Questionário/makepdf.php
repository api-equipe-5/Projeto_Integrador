<?php

require_once __DIR__ . '/vendor/autoload.php';
//controlador 
$cname = $_POST['cname'];
$clname = $_POST['clname'];

//operador
$opname = $_POST['opname'];
$oplname = $_POST['oplname'];

//encarregado
$ename = $_POST['ename'];
$elname = $_POST['elname'];
$etel = $_POST['etel'];
$esite = $_POST['esite'];

//dados pessoais 
$pdados = $_POST['pdados'];
$pjust = $_POST['pjust'];

//dados pessoais sensiveis
$psdados = $_POST['psdados'];
$psjust = $_POST['psjust'];

//dados anonimos
$andados = $_POST['andados'];

//dados de menores
$dmenor = $_POST['dmenor'];


//msg
$empmsg = $_POST['empmsg'];


$mpdf = new \Mpdf\Mpdf();

//criar pdf
$data = '';

//adicionando as info

$data .= '<h1>Questionário</h1>' . '<br />';
$data .= '<h2>Agentes de Tratamento</h2>';
//controlador 
$data .= '<h3>Controlador</h3>';
$data .= '<strong>Nome: </strong>' . $cname . '<br />';
$data .= '<strong>Sobrenome: </strong>' . $clname . '<br />';

//operador
$data .= '<h3>Operador</h3>';
$data .= '<strong>Nome: </strong>' . $opname . '<br />';
$data .= '<strong>Sobrenome: </strong>' . $oplname . '<br />';

//encarregado
$data .= '<h3>Encarregado</h3>';
$data .= '<strong>Nome: </strong>' . $ename . '<br />';
$data .= '<strong>Sobrenome: </strong>' . $elname . '<br />';
$data .= '<strong>Contato: </strong>' . $etel . '<br />';
$data .= '<strong>Site: </strong>' . $esite . '<br />';


//dados pessoais 
$data .= '<h2>Dados Pessoais</h2>';
$data .= '<strong>Dados: </strong>' . $pdados . '<br />';
$data .= '<strong>Justificativa: </strong>' . $pjust . '<br />';


//dados pessoais sensiveis
$data .= '<h2>Dados Pessoais Sensiveis</h2>';
$data .= '<strong>Dados: </strong>' . $psdados . '<br />';
$data .= '<strong>Justificativa: </strong>' . $psjust . '<br />';

//dados anonimos
$data .= '<h2>Dados Anonimizados</h2>';
$data .= '<strong>Dados Anonimizados: </strong>' . $andados . '<br />';

//dados de menores

if($dmenor)
{
$data .= "<br /><h2> Dados de Menores </h2> <br />" . $dmenor;
}

//boas praticas
if($empmsg)
{
$data .= "<br /><h2> Boas Práticas da Empresa </h2> <br />" . $empmsg;
}



//escrever no pdf 
$mpdf -> WriteHTML($data);

//saida
$mpdf -> output('myfile.pdf', 'D');