/**
 * Created by Jack on 2017/11/1.
 */
function closeBox() {
    $(".m-mask").css("display","none");
}
function importFile() {
    $(".m-mask").css("display","block");
}

function submit(e) {
    var file = e.files[0];
    var tempStr = file.name.split(".");
    var fileType = tempStr[tempStr.length-1];
    if(fileType.search(/xls|xlsx/i)==-1){
        alert("不是excel文件！")
        return false;
    }
    //ajax  上传文件
    console.log(file.name);
}