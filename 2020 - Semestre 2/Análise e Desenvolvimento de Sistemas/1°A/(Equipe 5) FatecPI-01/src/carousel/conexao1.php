<?php
define('HOST','127.0.0.1');
define('USUARIO','root');
define('SENHA','');
define('BD','bd_pi01');

$conexao1 = mysqli_connect (HOST,USUARIO,SENHA,bd_pi01) or die ('Could not connect');