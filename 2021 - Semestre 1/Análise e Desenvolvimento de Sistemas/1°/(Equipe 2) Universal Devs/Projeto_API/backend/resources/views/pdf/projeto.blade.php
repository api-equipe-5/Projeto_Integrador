<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>

<body>
    <div style="max-width: 800px; margin: 0 auto; display: block">
        <h1 style="text-align: center">{{ $projeto->nome }}</h1>
        <p style="text-align: justify; max-width: 600px; margin: 0 auto;">
            {{$projeto->descricao}}
        </p>
        
    </div>
</body>

</html>