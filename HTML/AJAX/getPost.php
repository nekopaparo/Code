<?php
    $name = $_POST['name'];
?>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GetPost</title>
</head>
<body>
    <p>
        <?php 
            echo $name;
            echo "會";
            echo $_POST['do'];
        ?>
    </p>
</body>
</html>