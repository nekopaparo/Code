//#region utf-8 string ⇄ byte[]
// encode
let utf8Encode = new TextEncoder();
let byte = utf8Encode.encode('我是帥哥'); // = byte[]
// decod
let decoder = new TextDecoder('utf-8')
let utf8Str = decoder.decode(byte);
//#endregion

//#region 事件
/* 事件簡述 https://www.fooish.com/javascript/dom/event.html
// 點擊
click	        滑鼠點擊物件時
dblclick	    滑鼠連點二下物件時
// 
change	        物件內容改變時
load	        網頁或圖片完成下載時
error	        當圖片或文件下載產生錯誤時
//
focus	        當物件被點擊或取得焦點時
blur	        物件失去焦點時
//
scroll	        當捲軸被拉動時
select	        當文字被選取時
resize	        當視窗或框架大小被改變時
submit	        當按下送出按紐時
// 按鍵
keydown	        按下鍵盤按鍵時
keypress	    壓住鍵盤按鍵時，會不停觸發
keyup	        放開鍵盤按鍵時
// 滑鼠
mousedown	    按下滑鼠按鍵時
mouseup	        放開滑鼠按鍵時
mouseover	    滑鼠進入
mousemove	    滑鼠移動
mouseout	    滑鼠離開
//
beforeunload	當使用者關閉 (或離開) 網頁之前
unload	        當使用者關閉 (或離開) 網頁之後
*/
let button = document.querySelector('body').appendChild(document.createElement('button'));
button.innerText = '按鈕';
function sayHi() {
    console.log('Hi');
}
// 新增
button.addEventListener('click', function (e) {
    console.log(e);
});
button.addEventListener('click', sayHi);
// 刪除
button.removeEventListener('click', sayHi);
// 全部刪除
function removeAllEventListener(element, type) {
    getEventListeners(element)[type].forEach(event => {
        element.removeEventListener(type, event.listener, event.useCapture);
    });
    return element;
}
// 新增全部刪除的方法
button.removeAllEventListener = function (type) {
    getEventListeners(this)[type].forEach(event => {
        this.removeEventListener(type, event.listener, event.useCapture);
    });
    return this;
}
button.removeAllEventListener('click');
/*
─ ─ ─ ─ ─ ─ ─ ─ ─
│A ─ ─ ─ ─ ─ ─ ─  |
| |B ─ ─ ─ ─ ─  | |
| | |C ─ ─ ─  | | |
| | | |  D  | | | |
| | |  ─ ─ ─  | | |
| |  ─ ─ ─ ─ ─  | |
|  ─ ─ ─ ─ ─ ─ ─  |
 ─ ─ ─ ─ ─ ─ ─ ─ ─
 */
// useCapture
button.addEventListener('click', sayHi, false); // Bubbling 由外而內 D -> C -> B -> A (預設)
button.addEventListener('click', sayHi, true);  // Capture  由內而外 A -> B -> C -> D
// Capture -> Bubbling B -> C -> D -> A
A.addEventListener('click', sayHi);
B.addEventListener('click', sayHi, true);
C.addEventListener('click', sayHi, true);
D.addEventListener('click', sayHi);
// 先進先觸發 D -> C1 -> C2 -> B -> A
A.addEventListener('click', sayHi);
B.addEventListener('click', sayHi);
C1.addEventListener('click', sayHi);
D.addEventListener('click', sayHi);
C2.addEventListener('click', sayHi);

/* 網頁載入完事件 */
window.onload = function ()
{
    console.log("First");
}
// 舊的也加入
window.onload = function (current) {
    if (current)
    {
        current();
    }
    console.log("Second");
} (window.onload);
//#endregion

//#region 字串 string
let str = 'Hello World';
// 指定字串是否存在
str.includes('Hello'); // true  
// 尋找，回傳第一個位置，無符合 = -1
str.indexOf('World');  // 6     
// 取代
str.replace('l', 'L');    // 'HeLlo World' 取代第一個符合的
str.replaceAll('l', 'L'); // 'HeLLo WorLd' 全部取代
// 切割 string -> array
str.split(' '); //  ['Hello', 'World']
// 擷取 (開始, 結束(不包含))
str.substring(1, 7); // 'ello W'
//#endregion

//#region 陣列 array | list
// js 陣列無固定大小 == list 可不同型別放在一起
let array = [2, '3', 0, 1, 4, document]
// 長度
array.length;       // 6
// 串聯 array -> string
array.join('_');    // '2_3_0_1_4_[object HTMLDocument]'
// 是否存在
array.includes(3);  // false
// 尋找，回傳第一個位置，無符合 = -1
array.indexOf('3'); // 1
// 新增，回傳新增完的長度
array.push('C');    // 7
// 刪除
array.shift();      // 2 | array = ['3', 0, 1, 4, document, 'C']   取出第一個
array.pop();        // 'C' | array = [2, '3', 0, 1, 4, document]   取出最後一個
array.splice(2, 3); // [0, 1, 4] | array = [2, '3', document, 'C'] 分割(開始, 分割數量)
// 回傳運算完的新陣列，不影響原本陣列
array.map((item) => {
    if (typeof(item) === 'number') return item;
    else return -1;
});                 // [2, -1, 0, 1, 4, -1]
// forEach
array.forEach(function (item, index) {
    console.log(`${index}: ${item}`);
});
for(let index = 0; index < array.length; ++index) {
    console.log(`${index}: ${array[index]}`);
}
// 排序
array.sort();           // [0, 1, 2, '3', 4, document]
// 自訂排序(倒序DESC)    
array.sort(function (x, y) {
    if (x > y) return -1;
    else if (x < y) return 1;
    else return 0;
});                     // [4, '3', 2, 1, 0, document]
// 反轉
array.reverse();        // [document, 0, 1, 2, '3', 4]
// 判斷是否為陣列
Array.isArray(array);   // true
//#endregion

//#region 字典 dictionary
let dic = {
    'cat': {
        'sex' : '♀',
        'year': 1
    },
    'number': [1,2,3,9,8,7]
}
// 取值
dic['cat'];     // = {sex: '♀', year: 1}
dic.cat.year;   // = 1
// 新增
dic['n1'] = 10;
dic.n2 = 20;
// 刪除
delete dic['n1'];
delete dic.n2;
// 取得key -> key array
Object.keys(dic); // = ['cat', 'number']
//#endregion

//#region 畫圖 canvas
let canvas = document.querySelector('body').appendChild(document.createElement('canvas'));
canvas.setAttribute('width', '500px');
canvas.setAttribute('height', '500px');
let ctx = canvas.getContext('2d');
// 圓形
ctx.beginPath();                        // 開始畫
ctx.arc(250, 250, 100, 0, 2*Math.PI);   // 圓形 (圓心x, 圓心y, 半徑, 起點, 終點)
ctx.fillStyle = 'green';                // 顏色
ctx.fill();                             // 填滿顏色
ctx.stroke();                           // 結束
// 矩形
ctx.beginPath();                    // 開始畫
ctx.strokeStyle = 'red';            // 線的顏色
ctx.fillStyle = 'yellow';           // 顏色
ctx.fillRect(0, 0, 500, 250);       // 填滿的矩形 (x, y, width, height)
ctx.strokeRect(10, 10, 100, 150);   // 矩形的邊框 (x, y, width, height)
//
ctx.rect(300, 150, 30, 30);         // 矩形 (x, y, width, height)
ctx.fillStyle = 'blueviolet';
ctx.fill();                         // 填滿顏色
//
ctx.clearRect(25, 25, 60, 60);      //  清空指定範圍 (x, y, width, height)
ctx.stroke();                       // 結束
// 畫線
ctx.beginPath();            // 開始畫
ctx.moveTo(20,20);          // 移動至 x20, y20
ctx.lineTo(20,100);         // 移動並畫線
ctx.lineTo(70,100);         // 移動並畫線
ctx.strokeStyle = "brown";  // 線的顏色
ctx.stroke();               // 結束
//#endregion