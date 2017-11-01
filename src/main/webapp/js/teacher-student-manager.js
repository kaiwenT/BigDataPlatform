/**
 * Created by Jack on 2017/11/1.
 */
function closeBox() {
    $(".m-mask").css("display","none");
}
function importFile() {
    $(".m-mask").css("display","block");
}
//上传学生名单
function submit(e) {
    var file = e.files[0];
    var tempStr = file.name.split(".");
    var fileType = tempStr[tempStr.length-1];
    if(fileType.search(/xls|xlsx/i)==-1){
        alert("不是excel文件！")
        return false;
    }
    var formData = new FormData();
    formData.append("formData" , file);
	var courseId = getCookie("courseId");
    formData.append("courseId" , courseId);
    $.ajax({
        type: "POST",
        url: "/teacher/importStudent",       
        dataType:"json",
        processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        enctype:"multipart/form-data",
        data: formData,
        success : function(msg) {
            if (msg.status == "OK") {
                alert("上传成功！");
                //显示学生名单
            } else {
            	 alert(msg.result);
            }
        },
        error : function() {
            alert("上传文件失败请重新上传！");
        }
    })
}