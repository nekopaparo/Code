/*
<div class="inpdiv-home">
    <input class="inpdiv-inp" type="text" autocomplete="off"> <!--取消輸入記錄-->
    <div class="inpdiv-div">legend</div>
    <div class="inpdiv-error"></div>
</div>
*/
//need use jQuery
$(document).ready(function(){
    $(".inpdiv-inp").focus(function(){
        $(".inpdiv-div")[$(".inpdiv-inp").index(this)].classList.add("inpdiv-point");
    });
    $(".inpdiv-inp").blur(function(){
        const indexs = $(".inpdiv-inp").index(this);
        $(".inpdiv-error")[indexs].innerText =""; //清空訊息
        if(!this.value) $(".inpdiv-div")[indexs].classList.remove("inpdiv-point");
        else inpdivInpCheck(this, indexs);
    });
});
import ck from "./checkBase.js"
//檢查
function inpdivInpCheck(inp, index){
    var result;
    switch(index){
        case 0:
            result = ck.id(index);
            break;
        case 1:
            result = ck.phone(index);
            break;
    }
    if(!result){
        inp.select();
        inp.focus();
    }
}