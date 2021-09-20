<?php
define('HOST', 'sql102.epizy.com');
define('USUARIO', 'epiz_26915201');
define('SENHA', 'YwQ5pfjia0');
define('DB', 'epiz_26915201_banco');

$conexao = mysqli_connect(HOST, USUARIO, SENHA, DB) or die ('Não foi possível conectar');