var imgURL = null;
var imgWidth = 0; //圖片寬度
var imgMove = null; //圖片移動
window.onload = function() {
    //預覽圖片
    imgInput.addEventListener('change', function(){
        imgURL = null;
        const [file] = imgInput.files;
        if (file){
            imgView.src = URL.createObjectURL(file);
        }
    });
    //讀取完圖片後
    imgView.addEventListener('load', function(){
        if(imgURL == null) imgURL = imgView.src; //儲存原始圖片
        imgView.style.width = "auto";
        imgWidth = imgView.width; //儲存原始圖片寬度
        imgView.style.width = imgWidth * imgSizeRange.value + "px"; //調成目前放大倍率
    });
    //在瀏覽圖中按下滑鼠
    imgView.addEventListener('mousedown', function(e){
        if(imgMove == null){
            //初始滑鼠位置
            const mouseX = e.pageX;
            const mouseY = e.pageY;
            //初始圖片位置
            const imgX = imgView.offsetLeft;
            const imgY = imgView.offsetTop;
            //滑鼠移動時
            imgCropper.addEventListener('mousemove', imgMove = function(e){
                //圖片移動(= imgXY + (startMouseXY - nowMouseXY))
                imgView.style.left = imgX + e.pageX - mouseX + 'px';
                imgView.style.top = imgY + e.pageY - mouseY + 'px';
            });
        }
    });
    //在網頁中滑鼠放開
    document.addEventListener('mouseup', function(){
        if(imgMove != null){
            imgCropper.removeEventListener('mousemove', imgMove);
            imgMove = null;
        }
    });
    //當range輸入時，調整圖片大小(只調整寬度)
    imgSizeRange.addEventListener('input', function(){
        imgView.style.width = imgWidth * this.value + "px";
    });
    //切割
    const imgRange = document.getElementById("img-cute-range");
    const outputsize = 300; //還需要改img-cute-range大小
    imgRange.style.width = outputsize + "px";
    imgRange.style.height = outputsize + "px";
    imgCropperResult.addEventListener("click", function(){
        if (canvas.getContext){
            const imgSize = imgSizeRange.value;
            canvas.width = outputsize; //無作用
            canvas.height = outputsize; //無作用
            var ctx = canvas.getContext("2d");
            var x = (imgRange.offsetLeft - imgView.offsetLeft ) / imgSize;
            var y = (imgRange.offsetTop - imgView.offsetTop) / imgSize;
            var w = outputsize / imgSize;
            var h = outputsize / imgSize;
            ctx.drawImage(imgView, x, y, w, h, 0, 0, outputsize, outputsize); // (img, imgX,imgY,imgW,imgH , canvaX,canvaY,canvaW,canvaH)
            //圈外空白
            ctx.arc(outputsize/2,outputsize/2 , outputsize/2, 0, 2*Math.PI); // (x,y,r,star,end)
            ctx.fillStyle = 'white';
            ctx.rect(outputsize, 0, -outputsize, outputsize);
            ctx.fill();
            /*切好的傳給 hidden input (還未後端測試過),必須先去掉開頭的「data:image/jpeg;base64, 」，剩下的才是base64編碼後的照片) https://www.cc.ntu.edu.tw/chinese/epaper/0052/20200320_5208.html
            document.getElementsByName('imgCuteServer').value = canvas.toDataURL();//base64編碼字串
            alert(document.getElementsByName('imgCuteServer').value);
            */
            //觀看結果用
            newImg.src = canvas.toDataURL(); 
        }
        else{
            alert("您的瀏覽器不支援 canvas 元素，無法切割!!!");
        }
    });
};