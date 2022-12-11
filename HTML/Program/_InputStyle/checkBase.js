export default {
    id : function (index){
        const id = $(".inpdiv-inp")[index].value.toUpperCase();
        if(id.length === 10 && id.match("[A-Z](1|2)[0-9]{8}")){
            const chkid = "0123456789ABCDEFGHJKLMNPQRSTUVXYWZIO";
            // 首字字元的索引值
            var id_1 = chkid.indexOf(id.charAt(0));
            // 首字字元的加權值
            var total = parseInt(id_1 / 10) + (id_1 % 10) * 9;
            // total=total+其他字元的加權值
            for (var i = 1; i < 9; i++) total += chkid.indexOf(id.charAt(i)) * (9 - i);
            total += chkid.indexOf(id.charAt(9));
            // 結果
            if (total % 10 == 0) {
                return true;
            }
            else{
                $(".inpdiv-error")[index].innerText = "身分證錯誤"; //警告訊息
                return false;
            }
        }else{
            $(".inpdiv-error")[index].innerText = "格式錯誤"; //警告訊息
            return false;
        }
    },
    phone : function (index){
        const phone = $(".inpdiv-inp")[index].value;
        if(phone.length === 10 && phone.match("09[0-9]{8}")) return true;
        else{
            $(".inpdiv-error")[index].innerText = "格式錯誤"; //警告訊息
            return false;
        }
    }
}