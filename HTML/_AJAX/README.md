```js
xmlHTTP.open("GET", url, true); // GET | POST
```
#### true(預設值) 非同步
+ 使用非同步的設定時，我們的程式碼不會等到資料回傳回來，就會開始執行後續程式碼
在第三步的xhr.onload會做更詳細的解釋

#### false 同步
+ 會等資料回傳(接收)完畢，才繼續往下跑

```js
xmlHTTP.status
```
+ 200：資料正確回傳

+ 404：資料讀取錯誤

#### jQ
```js
$.ajax({
    url: "./weatherforecast",
    type: "GET",
    dataType: "json",
    data: { a: 123 }, // 傳甚麼資料過去 Object、String、Array
  cache: false, //暫存(cache)在本地，以減少對伺服器的呼叫
    async: false, // true/false 同步/非同步
    contentType: "application/json;charset=utf-8",
    success: function (returnData) {
        console.log(returnData);
    },
    error: function (xhr, ajaxOptions, thrownError) {
        console.log(xhr.status);
        console.log(thrownError);
    }
});
```