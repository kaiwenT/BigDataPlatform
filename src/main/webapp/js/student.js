/**
 * 学生页面有关的js方法
 */
//学生信息展示
function showstudentInfo(){	
	//从cookie读取用户信息
	var studentId = getCookie("studentId");
//	if(studentId == null){
//		window.location.href="";
//	}
	$.ajax({
		type:"GET",
		url:"/student/getPersonalInfo",
		dataType:"json",
		data:{
			studentId : "M201676099"
		},
		success : function(msg){
			if(msg.status == "OK"){
				var stu = msg.result;		
				
				$("#stu-id").text(stu.studentId);
				$("#stu-name").text(stu.studentName);
				$("#f-name").text(stu.studentFaculty);
				
			}else{
				alert(msg.result);
			}
		},
		error : function(msg){
			alert(msg.result);
		},
	})
}

showstudentInfo();