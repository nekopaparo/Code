#### xmlHTTP
```js
var xmlHTTP = window.XMLHttpRequest? new XMLHttpRequest()
               : window.ActiveXObject? new ActiveXObject('Microsoft.XMLHTTP') 
                : undefined;
xmlHTTP.open('POST', './getPost.php', true); // GET | POST
// 當 async = false 時，xmlHTTP.responseType不能修改，不然會跳錯誤
xmlHTTP.responseType = 'text'; // 'text', 'json', 'blob', 'document'
xmlHTTP.setRequestHeader('Content-type', 'application/x-www-form-urlencoded'); // 'application/json;charset=utf-8'
//state change 改變時觸發
xmlHTTP.onreadystatechange = function () {
    switch(xmlHTTP.readyState) {
        case 0: // request not initialized
            // 已經產生一個 XMLHttpRequest 但是還沒有連接你要的資料
        case 1: // server connection established
            // 用了 open 但資料還沒傳送過去
        case 2: // request received
            // 偵測到用了 send
        case 3: // processing request
            // loding 抓取中
        case 4: // request finished and response is ready
            // 撈到資料了
    }
}
// 載入完成觸發
xmlHTTP.onload = function () {
    if (xmlHTTP.status === 200) {
        document.write(xmlHTTP.response);
    }
}
// 載入錯誤觸發
xmlHTTP.onerror = function (event) {
    console.log(event);
}
xmlHTTP.send('name=小貓'); // 可放想要傳送的value
```
```js
xmlHTTP.open(method, url, async, user, password); 
```
#### async -> true(預設值) 非同步
+ 使用非同步的設定時，我們的程式碼不會等到資料回傳回來，就會開始執行後續程式碼。

#### async -> false 同步
+ 會等資料回傳(接收)完畢，才繼續往下跑。

```js
xmlHTTP.status
```
+ 200：資料正確回傳

+ 404：資料讀取錯誤

#### JQuery ajax
```js
// Documentation: https://api.jquery.com/jquery.ajax/
$.ajax({
    url: './data.json',
    type: 'GET', // 'GET', 'POST'
    dataType: 'json', // 'text', 'json', 'html', 'xml', 'script', 'jsonp'
    data: { key: value }, // 傳甚麼資料過去 Object、String、Array
    cache: false, //暫存(cache)在本地，以減少對伺服器的呼叫
    async: false, // true/false 同步/非同步
    contentType: 'application/json; charset=utf-8', // 'application/x-www-form-urlencoded; charset=UTF-8'
    success: function (returnData) {
        console.log(returnData);
    },
    error: function (xhr, ajaxOptions, thrownError) {
        console.log(xhr.status);
        console.log(thrownError);
    }
});
```