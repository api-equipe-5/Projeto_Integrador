<?php 
 session_start();
 $nome = $_GET['nome'];

 if ($nome == 'a'){
    $_SESSION['materia'] = '1';
 }
 else if ($nome == 'b'){
    $_SESSION['materia'] = '2';
 }
 else if($nome == 'c'){
    $_SESSION['materia'] = '3';
 }
 else if($nome == 'd'){
    $_SESSION['materia'] = '4';
 }
 else if($nome == 'e'){
    $_SESSION['materia'] = '5';
 }
 else if($nome == 'f'){
    $_SESSION['materia'] = '6';
 }
 echo $_SESSION['materia'];
                
?>