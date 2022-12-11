$("#ID").off('change');                 // 刪除事件
$("#ID").on("change", function () {});  // 加入事件

// <input id="ID" type="number" max="99">
$('#ID').attr('max', totalPage); // 修改標籤內的值
document.getElementById('ID').max = 2;