<?php
session_start();
if(!$_SESSION['nivel'])  {
	header('Location: index.php');
	exit();
}