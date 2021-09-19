<?php
session_start();
require('banco.php');

if (isset($_POST['botao'])) {
    copy($_FILES['json']['tmp_name'], 'json/' . $_FILES['json']['name']);
    $data = file_get_contents('json/' . $_FILES['json']['name']);
    $json = json_decode($data);

    if ($_FILES['json']['name'] == "jira.json") {

        foreach ($json as $json) {
            $stmt = $conn->prepare('insert into json(status,user,user_last,email,avatar,amountHours,startedAt,project,cardDescription) values(:status,:user,:user_last,:email,:avatar,:amountHours,:startedAt,:project,:cardDescription)');
            $stmt->bindValue('status', $json->status);
            $stmt->bindValue('user', $json->user->first_name);
            $stmt->bindValue('user_last', $json->user->last_name);
            $stmt->bindValue('email', $json->user->email);
            $stmt->bindValue('avatar', $json->user->avatar);
            $stmt->bindValue('amountHours', $json->amountHours);
            $stmt->bindValue('startedAt', $json->startedAt);
            $stmt->bindValue('project', $json->project);
            $stmt->bindValue('cardDescription', $json->cardDescription);
            $stmt->execute();
        }
    } else {

        foreach ($json as $json) {
            $stmt = $conn->prepare('insert into json(status,user,user_last,email,avatar,amountHours,startedAt,project,cardDescription) values(:status,:user,:user_last,:email,:avatar,:amountHours,:startedAt,:project,:cardDescription)');
            $stmt->bindValue('status', $json->status);
            $stmt->bindValue('user', $json->user->userName);
            $stmt->bindValue('user_last', $json->user->userLastName);
            $stmt->bindValue('email', $json->user->userEmail);
            $stmt->bindValue('avatar', $json->user->avatar);
            $stmt->bindValue('amountHours', $json->hours);
            $stmt->bindValue('startedAt', $json->startedAt);
            $stmt->bindValue('project', $json->project);
            $stmt->bindValue('cardDescription', $json->cardDescription);
            $stmt->execute();
        }
    }
}
?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>json</title>

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

<body style="cursor: auto;">

    <form method="POST" enctype="multipart/form-data">
        <input type="file" name="json">
        <input type="submit" value="import" name="botao">
    </form>

</body>

</html>