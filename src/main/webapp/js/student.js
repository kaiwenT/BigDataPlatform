/**
 * 学生首页有关的js方法
 */
//学生首页个人信息展示
function showstudentInfo(){	
	
	$.ajax({
		type:"GET",
		url:"/student/getPersonalInfo",
		dataType:"json",		
		success : function(msg){
			if(msg.status == "OK"){
				var stu = msg.result;		
				
				$("#stu-id").text(stu.studentId);
				$("#stu-name").text(stu.studentName);
				$("#f-name").text(stu.studentFaculty);
				
				if(stu.studentPicturepath != 'undefined' && stu.studentPicturepath != '')
					$(".user-head-img").attr("src",stu.studentPicturepath);
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
showstudentCourses();


//学生所选课程信息展示
function showstudentCourses(){
	$.ajax({
		type:"POST",
		url:"/studentcourse/getCourseByStudent",
		dataType:"json",
		
		success : function(msg){
			if(msg.status == "OK"){
				var courses = msg.result;
				if(courses == 'undefined' || courses.length == 0){
					return;
				}
				$(".courses_number").text("课程 "+courses.length);
				$(".course-panel-body-wrapper").empty();
				var cookie_courseId = "'courseId'" ;
				$.each(courses, function(idx, course){
					
					wrapper = '<div class="course-card-wrapper"><div class="box"><a href="course-base.html?href=course-introduce" onclick="setCookie('+cookie_courseId+','+"'"+course.courseId+"'"+');" target="_blank" class="ga-click">'
						+'<div class="img"><img class="image" src="../img/course-img.jpg" id="'+course.courseId+'" alt="'+course.courseName+'"></div>'
						+'<div class="body"><div class="common-info-wrapper common-info-wrapper-fix-height">'
						+'<div class="title"><div class="text"><span class="text">'+course.courseName+'</span></div></div>'
						+'<div class="school"><a target="_blank" href="#">华中科技大学</a></div></div>'
						+'<div class="personal-info"><div class="course-status">'+dateFormat(course.courseBegintime)+'开始</div></div>'
						+'</div></a></div></div>';
					$(".course-panel-body-wrapper").append(wrapper);
					if(course.coursePicturepath != 'undefined' && course.coursePicturepath != '')
						$("#"+course.courseId).attr("src",course.coursePicturepath);				
				});
			}else{
				$(".course-panel-body-wrapper").empty();
			}
		},
		error : function(msg){
			alert(msg.result);
		},
	})
}

//学生退出登录，返回登录界面
function studentLogout(){	
	
	$.ajax({
		type:"GET",
		url:"/student/logout",
		dataType:"json",		
		success : function(msg){
			if(msg.status == "OK"){
				window.location.href = 'index.html';
			}else{
				alert(msg.result);
			}
		},
		error : function(msg){
			alert(msg);
		},
	})
}