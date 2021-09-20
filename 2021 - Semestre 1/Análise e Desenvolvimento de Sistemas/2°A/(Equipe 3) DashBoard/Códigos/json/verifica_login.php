<?php
session_start();
if($_SESSION['nivel'] != "ok")  {
	header('Location: index.php');
	exit();
}