<?php
session_start();
require('banco.php');
include("conexao.php");
require('verifica_login.php');
?>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>CPU | Projetos</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet" />

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet" />


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="jquery/jquery-3.4.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="jquery/jquery-ui.js"></script>
    <script src="jquery/jquery-ui.mim.js"></script>
    <script src="jquery/jquery.js"></script>
    <style>
        #draggable {
            background-color: black;
            cursor: pointer;
        }

        .ui-widget-content {
            background: none;
        }
    </style>
</head>

<body style="cursor: auto;" onload="car();">

    <div class="wrapper">
        <div class="sidebar" data-color="purple" data-image="assets/img/sidebar-5.jpg">

            <div class="sidebar-wrapper">
                <div class="logo">
                    <a class="simple-text">
                        EQUIPE CPU
                    </a>
                </div>

                <ul class="nav">
                    <li>
                        <a href="painel.php">
                            <i class="pe-7s-graph"></i>
                            <p>Painel</p>
                        </a>
                    </li>
                    <li>
                        <a href="usuario.php">
                            <i class="pe-7s-user"></i>
                            <p>Usuários</p>
                        </a>
                    </li>
                    <li>
                        <a href="empresa.php">
                            <i class="pe-7s-home"></i>
                            <p>Empresas</p>
                        </a>
                    </li>
                    <li class="active">
                        <a href="projeto.php">
                            <i class="pe-7s-display1"></i>
                            <p>Projetos</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="main-panel">
            <nav class="navbar navbar-default navbar-fixed ">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Projetos</a>
                    </div>
                    <div class="collapse navbar-collapse">

                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="logout.php">
                                    <p>Sair</p>
                                </a>
                            </li>
                            <li class="separator hidden-lg"></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="container theme-showcase" role="main">

                <div id="lista">
                    <div class="form-row" style="margin-top: 20px;">
                        <div class="form-group col-md-9">
                            <input id="pesquisa" class="form-control" type="text" placeholder="Pesquise o nome da empresa" oninput="car()">
                            <input id="pesquisa2" class="form-control" type="text" placeholder="Pesquise o nome do responsável" oninput="car()">
                        </div>
                        <div class="form-group col-md-3" style="margin-bottom: 40px">
                            <div class="form-check" style="width: 50%; text-align:center; float:left">
                                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="opcao1" checked>
                                <label class="form-check-label" for="exampleRadios1">
                                    Finalizado
                                </label>
                            </div>
                            <div class="form-check" style="width: 50%; text-align:center; float:right">
                                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="opcao2">
                                <label class="form-check-label" for="exampleRadios2">
                                    Em andamento
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <table id="tabela" class="table">
                                <thead>
                                    <tr>
                                        <th>Empresa</th>
                                        <th>Responsável</th>
                                        <th>Descrição</th>
                                        <th><button type="submit" class="btn btn-success" onclick="abrirAdicionar()">Adicionar</button></th>
                                    </tr>
                                </thead>

                                <tbody>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>

                <form id="form" class="needs-validation" style="display: none; margin-top:50px;">

                    <div class="form-group">
                        <input type="text" class="form-control" id="projeto_id" name="projeto_id" readonly>
                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <input type="text" class="form-control" id="status" name="status">
                    </div>
                    <div class="form-group col-md-12">
                        <div class="form-check" style="width: 50%; text-align:center; float:left">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="finalizado">
                            <label class="form-check-label" for="exampleRadios1">
                                Finalizado
                            </label>
                        </div>
                        <div class="form-check" style="width: 50%; text-align:center; float:right">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="andamento">
                            <label class="form-check-label" for="exampleRadios2">
                                Em andamento
                            </label>
                        </div>
                    </div>
                    <script>
                        document.getElementById("finalizado").onclick = function() {
                            document.getElementById("amountHours").readOnly = false;
                        }

                        document.getElementById("andamento").onclick = function() {
                            document.getElementById("amountHours").readOnly = true;
                            document.getElementById("amountHours").value = "";
                        }
                    </script>
                    <div class="form-group">
                        <label for="amountHours">Tempo do projeto</label>
                        <input type="text" class="form-control" id="amountHours" name="amountHours">
                    </div>
                    <div class="form-group">
                        <label for="startedAt">Data de inicio</label>
                        <input type="text" class="form-control" id="startedAt" name="startedAt">
                    </div>
                    <div class="form-group">
                        <label for="cardDescription">Descrição</label>
                        <input type="text" class="form-control" id="cardDescription" name="cardDescription">
                    </div>
                    <button type="submit" class="btn btn-success" style="float:left" onclick="editar()">Alterar</button>
                    <button type="submit" class="btn btn-danger" style="float:left; margin-left: 20px;" onclick="apagar()">Apagar</button>
                    <button type="submit" class="btn btn-primary" style="float:right" onclick="voltar()">Voltar</button>
                </form>

                <script>
                    jQuery(function($) {
                        $(':radio').change(function() {
                            car();
                        });
                    });

                    function car() {
                        var itens = '',
                            url = "projetoPesquisa.php?";

                        $.ajax({
                            url: url,
                            cache: false,
                            dataType: "json",
                            success: function(retorno) {
                                if (retorno[0].erro) {
                                    alert("ERRO");
                                } else {
                                    pesquisa = document.getElementById("pesquisa").value;
                                    pesquisa3 = document.getElementById("pesquisa2").value;

                                    for (var i = 0; i < retorno.length; i++) {

                                        if (document.getElementById('exampleRadios1').checked) {
                                            if (retorno[i].amountHours == null) {
                                                continue;
                                            }

                                        } else if (document.getElementById('exampleRadios2').checked) {
                                            if (retorno[i].amountHours != null) {
                                                continue;
                                            }
                                        }

                                        nome = retorno[i].project;

                                        if (pesquisa.length >= 1) {
                                            if (pesquisa.toUpperCase().charAt(0) != nome.toUpperCase().charAt(1)) {
                                                continue;
                                            }
                                        }
                                        if (pesquisa.length >= 2) {
                                            if (pesquisa.toUpperCase().charAt(1) != nome.toUpperCase().charAt(2)) {
                                                continue;
                                            }

                                        }
                                        if (pesquisa.length >= 3) {
                                            if (pesquisa.toUpperCase().charAt(2) != nome.toUpperCase().charAt(3)) {
                                                continue;
                                            }

                                        }
                                        if (pesquisa.length >= 4) {
                                            if (pesquisa.toUpperCase().charAt(3) != nome.toUpperCase().charAt(4)) {
                                                continue;
                                            }

                                        }
                                        if (pesquisa.length >= 5) {
                                            if (pesquisa.toUpperCase().charAt(4) != nome.toUpperCase().charAt(5)) {
                                                continue;
                                            }

                                        }
                                        if (pesquisa.length >= 6) {
                                            if (pesquisa.toUpperCase().charAt(5) != nome.toUpperCase().charAt(6)) {
                                                continue;
                                            }

                                        }
                                        if (pesquisa.length >= 7) {
                                            if (pesquisa.toUpperCase().charAt(6) != nome.toUpperCase().charAt(7)) {
                                                continue;
                                            }

                                        }

                                        resp = retorno[i].user;

                                        if (pesquisa3.length >= 1) {
                                            if (pesquisa3.toUpperCase().charAt(0) != resp.toUpperCase().charAt(0)) {
                                                continue;
                                            }
                                        }
                                        if (pesquisa3.length >= 2) {
                                            if (pesquisa3.toUpperCase().charAt(1) != resp.toUpperCase().charAt(1)) {
                                                continue;
                                            }

                                        }
                                        if (pesquisa3.length >= 3) {
                                            if (pesquisa3.toUpperCase().charAt(2) != resp.toUpperCase().charAt(2)) {
                                                continue;
                                            }

                                        }
                                        if (pesquisa3.length >= 4) {
                                            if (pesquisa3.toUpperCase().charAt(3) != resp.toUpperCase().charAt(3)) {
                                                continue;
                                            }

                                        }
                                        if (pesquisa3.length >= 5) {
                                            if (pesquisa3.toUpperCase().charAt(4) != resp.toUpperCase().charAt(4)) {
                                                continue;
                                            }

                                        }

                                        itens += "<tr>";
                                        itens += "<td>" + retorno[i].project + "</td>";
                                        itens += "<td>" + retorno[i].user + " " + retorno[i].user_last + "</td>";
                                        itens += "<td>" + retorno[i].cardDescription + "</td>";
                                        itens += "<td>" + '<button id="' + retorno[i].id + '" type="button" class="btn btn-xs btn-primary" onclick="abrir(this.id)">Exibir</button>' + "</td>";
                                        itens += "</tr>";
                                    }
                                    $('#tabela tbody').html(itens);
                                }
                            }

                        });
                    }

                    function abrir(id) {
                        $.ajax({
                            url: "projetoExibir.php?id=" + id,
                            cache: false,
                            dataType: "json",
                            success: function(retorno) {
                                if (retorno[0].erro) {
                                    alert("ERRO");
                                } else {
                                    document.getElementById('form').style.display = "block";
                                    document.getElementById('lista').style.display = "none";
                                    document.getElementById('projeto_id').value = retorno[0].id;
                                    document.getElementById('status').value = retorno[0].status;
                                    if (retorno[0].amountHours == null) {
                                        document.getElementById('amountHours').value = "";
                                        document.getElementById("andamento").checked = true;
                                        document.getElementById("amountHours").readOnly = true;

                                    } else {
                                        document.getElementById("finalizado").checked = true;
                                        document.getElementById('amountHours').value = retorno[0].amountHours;
                                    }

                                    document.getElementById('startedAt').value = retorno[0].startedAt;
                                    document.getElementById('cardDescription').value = retorno[0].cardDescription;

                                }

                            }

                        });
                    }

                    function editar() {
                        id = document.getElementById('projeto_id').value;
                        status = document.getElementById('status').value;
                        amountHours = document.getElementById('amountHours').value;
                        startedAt = document.getElementById('startedAt').value;
                        cardDescription = document.getElementById('cardDescription').value;

                        $.ajax({
                            url: "projetoEditar.php?id=" + id + "&status=" + status + "&amountHours=" + amountHours + "&startedAt=" + startedAt + "&cardDescription=" + cardDescription,
                            success: function(retorno) {
                                if (retorno[0].erro) {
                                    alert("ERRO");
                                } else {
                                    alert(retorno);
                                }
                            }
                        });
                    }

                    function voltar() {
                        document.getElementById('form').style.display = "none";
                        document.getElementById('form2').style.display = "none";
                        document.getElementById('lista').style.display = "block";
                    }

                    function apagar() {
                        id = document.getElementById('projeto_id').value;
                        $.ajax({
                            url: "projetoApagar.php?id=" + id,
                            success: function(retorno) {
                                if (retorno[0].erro) {
                                    alert("ERRO");
                                } else {
                                    alert(retorno);
                                }
                            }
                        });
                    }
                </script>

                <form id="form2" class="needs-validation" style="display: none; margin-top:50px;" novalidate>

                    <div class="form-group">
                        <input type="text" class="form-control" id="adcprojeto_id" name="adcprojeto_id" readonly>
                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <input type="text" class="form-control" id="adcstatus" name="adcstatus">
                    </div>
                    <div class="form-group col-md-12">
                        <div class="form-check" style="width: 50%; text-align:center; float:left">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="adcfinalizado">
                            <label class="form-check-label" for="exampleRadios1">
                                Finalizado
                            </label>
                        </div>
                        <div class="form-check" style="width: 50%; text-align:center; float:right">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="adcandamento">
                            <label class="form-check-label" for="exampleRadios2">
                                Em andamento
                            </label>
                        </div>
                    </div>
                    <script>
                        document.getElementById("adcfinalizado").onclick = function() {
                            document.getElementById("adcamountHours").readOnly = false;
                        }

                        document.getElementById("adcandamento").onclick = function() {
                            document.getElementById("adcamountHours").readOnly = true;
                            document.getElementById("adcamountHours").value = "";
                        }
                    </script>
                    <div class="form-group">
                        <label for="adcamountHours">Tempo do projeto</label>
                        <input type="text" class="form-control" id="adcamountHours" name="adcamountHours">
                    </div>
                    <div class="form-group">
                        <label for="adcstartedAt">Data de inicio</label>
                        <input type="text" class="form-control" id="adcstartedAt" name="adcstartedAt">
                    </div>
                    <div class="form-group">
                        <label for="adccardDescription">Descrição</label>
                        <input type="text" class="form-control" id="adccardDescription" name="adccardDescription">
                    </div>
                    <div class="form-group">
                        <label for="adcempresaselec">Empresa</label>
                        <select class="form-control" id="adcempresaselec">
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="adcresponsavelselec">Responsável</label>
                        <select class="form-control" id="adcresponsavelselec" oninput="pesquisaDados()">
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="status">Email</label>
                        <input type="text" class="form-control" id="adcemail" name="adcemail" readonly>
                    </div>

                    <div class="form-group">
                    <a href="" id='adcimagem' target="_blank"> Imagem aqui</a>

                    </div>

                    
                    <button type="submit" class="btn btn-success" style="float:left" id="adcadicionar" onclick="adicionar()">Adicionar</button>
                    <button type="submit" class="btn btn-primary" style="float:right" onclick="voltar()">Voltar</button>
                </form>

                <script>
                    function abrirAdicionar() {
                        document.getElementById('form2').style.display = "block";
                        document.getElementById('lista').style.display = "none";

                        var itens = '',
                            url = "empresaPesquisa.php?";

                        $.ajax({
                            url: url,
                            cache: false,
                            dataType: "json",
                            success: function(retorno) {
                                if (retorno[0].erro) {
                                    alert("ERRO");
                                } else {

                                    retorno = retorno.filter(function(a) {
                                        return !this[JSON.stringify(a)] && (this[JSON.stringify(a)] = true);
                                    }, Object.create(null))

                                    for (var i = 0; i < retorno.length; i++) {
                                        itens += "<option>" + retorno[i].project + "</option>";
                                    }
                                    $('#adcempresaselec').html(itens);
                                }
                            }

                        });

                        var itens2 = '',
                            url2 = "responsavelPesquisa.php?";

                        $.ajax({
                            url: url2,
                            cache: false,
                            dataType: "json",
                            success: function(retorno2) {
                                if (retorno2[0].erro) {
                                    alert("ERRO");
                                } else {

                                    retorno2 = retorno2.filter(function(a) {
                                        return !this[JSON.stringify(a)] && (this[JSON.stringify(a)] = true);
                                    }, Object.create(null))

                                    for (var i = 0; i < retorno2.length; i++) {
                                        itens2 += "<option>" + retorno2[i].user + ' ' + retorno2[i].user_last + "</option>";
                                    }
                                    $('#adcresponsavelselec').html(itens2);
                                }
                            }

                        });

                    }

                    function adicionar() {
                        status = document.getElementById('adcstatus').value;
                        amountHours = document.getElementById('adcamountHours').value;
                        startedAt = document.getElementById('adcstartedAt').value;
                        cardDescription = document.getElementById('adccardDescription').value;
                        project = document.getElementById('adcempresaselec').value;
                        user = document.getElementById('adcresponsavelselec').value;
                        email = document.getElementById('adcemail').value;
                        avatar = document.getElementById('adcimagem').href;

                        $.ajax({
                            url: "projetoAdicionar.php?status=" + status + "&amountHours=" + amountHours + "&startedAt=" + startedAt + "&cardDescription=" + cardDescription + "&project=" + project + "&user=" + user + "&email=" + email + "&avatar=" + avatar,
                            success: function(retorno) {
                                if (retorno[0].erro) {
                                    alert("ERRO");
                                } else {
                                    alert(retorno);
                                }
                            }
                        });
                    }

                    function pesquisaDados() {

                        document.getElementById("adcemail").value = "";

                        nome = document.getElementById("adcresponsavelselec").value;

                        $.ajax({
                            url: "responsavelDados.php?nome=" + nome,
                            cache: false,
                            dataType: "json",
                            success: function(retorno) {
                                if (retorno[0].erro) {
                                    alert("ERRO");
                                } else {
                                    document.getElementById("adcemail").value = retorno[0].email;


                                    document.getElementById("adcimagem").href = retorno[0].avatar;

                                }
                            }

                        });
                    }
                </script>
            </div>
        </div>

    </div>


</body>

<!--   Core JS Files   -->
<script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>


</html>