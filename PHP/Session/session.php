<?php
    session_start(); // 啟動session功能
    
    // session_id
    echo "session_id = ".session_id()."<br>";
    if (isset($_SESSION['use'])) {
        $_SESSION['use']++;
    }else {
        $_SESSION['use'] = 1;
    }
    echo "這個session_id使用次數 : ".$_SESSION['use']."<br>";

    // https://stackoverflow.com/questions/3003145/how-to-get-the-client-ip-address-in-php
    // IP位置 *客戶端可以將所有 HTTP 標頭資訊自行修改*
    if (!empty($_SERVER['HTTP_CLIENT_IP'])) // 不可靠
    {   $ip = "[HTTP_CLIENT_IP]".$_SERVER['HTTP_CLIENT_IP']; } 
    elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) // 不可靠
    {   $ip = "[HTTP_X_FORWARDED_FOR]".$_SERVER['HTTP_X_FORWARDED_FOR']; }
    else 
    {   $ip = "[REMOTE_ADDR]".$_SERVER['REMOTE_ADDR'];   } // 相對可靠
    echo "IP = $ip<br>";
    if (isset($_SESSION['user']['ip'])){
        echo "上次使用者的IP : ".$_SESSION['user']['ip']."<br>";
    }
    $_SESSION['user']['ip'] = $ip;

    // 時間紀錄
    if (isset($_SESSION['user']['time'])) {
        $timeFormat = $_SESSION['user']['time'] -> format ("Y-m-d H:i:s");
        echo "上次使用的時間 : ".$timeFormat."<br>";
    } else {}
    $_SESSION['user']['time'] = new DateTime('NOW');

    //unset($_SESSION['user']['time']); // 指定刪除變數
    //session_unset(); // 清除session中所有變數
?>