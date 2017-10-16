/**
 * 登录有关的js方法
 */
//登录
$(function(){
	$(".login-btn").click(function(){
		var role = $('input:radio[name="role"]:checked').val();
		if(role == '教师'){
			teacherLogin();
		}
		if(role == '学生'){
			studentLogin();
		}
	});
})
//学生登录
function studentLogin(){	
	var user = $(".u-account").val();
	var pwd = $(".u-pwd").val();
	
	$.ajax({
		type:"POST",
		url:"/student/login",
		dataType:"json",
		data:{
			studentId : user,
			password : pwd
		},
		success : function(msg){
			if(msg.status == "OK"){
				window.location.href = "student-home.html";
			}else{
				alert(msg.result);
			}
		},
		error : function(msg){
			showErrorMsg(msg);
		},
	})
}
//教师登录
function teacherLogin(){	
	var user = $(".u-account").val();
	var pwd = $(".u-pwd").val();
	
	$.ajax({
		type:"POST",
		url:"/teacher/Teacherlogin",
		dataType:"json",
		data:{
			teacherId : user,
			teacherPwd : pwd
		},
		success : function(msg){
			if(msg.status == "OK"){
				window.location.href = "teacher-home.html";
			}else{
				alert(msg.result);
			}
		},
		error : function(msg){
			showErrorMsg(msg);
		},
	})
}
