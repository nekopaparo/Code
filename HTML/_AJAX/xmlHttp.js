var xmlHTTP;
if(window.ActiveXObject)
{
    xmlHTTP = new ActiveXObject("Microsoft.XMLHTTP");
}
else if(window.XMLHttpRequest) 
{
    xmlHTTP = new XMLHttpRequest(); // 主要跑這個
}

var url = ".";

xmlHTTP.open("GET", url, true); // GET | POST
xmlHTTP.responseType = 'json'; // 指定json格式
xmlHTTP.send("$id=10"); // 可放想要傳送的value

// 讀取完觸發(state = 4)
xmlHTTP.onload = function(){
    // do something
}

//state change 改變時觸發
xmlHTTP.onreadystatechange = function () {
    /*
        0: request not initialized
            已經產生一個 XMLHttpRequest 但是還沒有連接你要的資料
        1: server connection established
            用了 open 但資料還沒傳送過去
        2: request received
            偵測到用了 send
        3: processing request
            loding 抓取中
        4: request finished and response is ready
            撈到資料了
    */
    if (xmlHTTP.readyState == 4) {
        // do something
    }
}