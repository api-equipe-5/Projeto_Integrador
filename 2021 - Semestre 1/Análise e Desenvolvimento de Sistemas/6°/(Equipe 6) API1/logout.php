<?php
session_start();
//função logout - encerra a sessão do usuario
session_destroy();
header('Location: index.php');
exit();


