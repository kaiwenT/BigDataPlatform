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
		url:"/studentcourse/getCouresByStudent",
		dataType:"json",
		
		success : function(msg){
			if(msg.status == "OK"){
				var courses = msg.result;
				if(courses == 'undefined' || courses.length == 0){
					return;
				}
				$(".courses_number").append("&nbsp;"+courses.length);
				
				$.each(courses, function(idx, course){
					
					wrapper = '<div class="course-card-wrapper"><div class="box"><a href="#" target="_blank" class="ga-click">'
						+'<div class="img"><img src="http://img1.ph.126.net/1JJdFGKDIKqvVeS7i9XJrQ==/6630083702792788774.jpg" alt="'+course.courseName+'"></div>'
						+'<div class="body"><div class="common-info-wrapper common-info-wrapper-fix-height">'
						+'<div class="title"><div class="text"><span class="text">'+course.courseName+'</span></div></div>'
						+'<div class="school"><a target="_blank" href="/university/NWU">华中科技大学</a></div></div>'
						+'<div class="personal-info"><div class="course-status">'+dateFormat(course.courseBegintime)+'开始</div></div>'
						+'</div></a></div></div>';
					$(".course-panel-body-wrapper").append(wrapper);
				});
			}else{
				$(".course-panel-body-wrapper").html("");
			}
		},
		error : function(msg){
			alert(msg.result);
		},
	})
}