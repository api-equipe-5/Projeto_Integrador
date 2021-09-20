<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar com java</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
<!-- listor participantes -->
<span id="conteudo"></span>
<script>
        $(document).ready(function () {
            $.post('projetos.php', function(retorna){
                $("conteudo").html(retorna);
            });
        });
</script>

</body>

</html>