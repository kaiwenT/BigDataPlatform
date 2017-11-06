/**
 * Created by Jack on 2017/11/1.
 */
showStudent();
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
                $(".m-mask").css("display","none");
                showStudent();
            } else {
            	 alert(msg.result);
            }
        },
        error : function() {
            alert("上传文件失败请重新上传！");
        }
    })
}
//显示学生名单
function showStudent() {
    $(".grade-body").empty();  
    $(".grade-body").css("overflow","hidden");
    var courseId = getCookie("courseId");
    //根据查询到的平时作业数量生成
    $.ajax({
    	type:"POST",
		url:"/teacher/ShowStudent",
		data:
		{	courseId:courseId, 
		},
		datatype:"json",
		success:function(msg){
			if(msg.status=="OK"){
				var student="";
				var list = msg.result;
				$.each(list,function(idx,s){
					student +="<tr><td>"+s.studentId+"</td>";
					student +="<td>"+s.studentName+"</td>";
					student +="<td>"+s.studentFaculty+"</td>";
					student +="<td>"+s.groupId+"</td>";
					student +="<td><a >删除</a></td>";
				})
				var content='<table >'+
		        '<tr>'+
		        '<th>学号</th>'+
		        '<th>姓名</th>'+
		        '<th>学院</th>'+
		        '<th>组号</th>'+
		        '<th>操作</th>'+
		        '</tr>'+
		        student+
		        '</table>';
		    $(".grade-body").append(content);
			}else{
				alert(msg.result);
			}
    	},
		error:function(msg){
			alert(msg.result);
		},
    })
}