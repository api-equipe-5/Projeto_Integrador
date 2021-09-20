<?php
define('HOST','127.0.0.1');
define('USUARIO','root');
define('SENHA','');
define('BD','bd_pi01');

$conexao = mysqli_connect(HOST,USUARIO,SENHA,BD) or die ('Could not connect');