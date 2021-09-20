<?php 
 session_start();
 $nome = $_GET['nome'];

 if ($nome == 'a'){
    $_SESSION['nmaterial'] = 'Ingles';
 }
 else if ($nome == 'b'){
    $_SESSION['nmaterial'] = 'Matematica';
 }
 else if($nome == 'c'){
    $_SESSION['nmaterial'] = 'Hardware';
 }
 else if($nome == 'd'){
    $_SESSION['nmaterial'] = 'AOC';
 }
 else if($nome == 'e'){
    $_SESSION['nmaterial'] = 'Portugues';
 }
 else if($nome == 'f'){
    $_SESSION['nmaterial'] = 'Programacao';
 }
 echo $_SESSION['nmaterial'];
                
?>