/*教师首页的js代码*/

showTeacherInfo();
getCourseByTeacherId();

//显示教师的个人信息
function showTeacherInfo() {
	$.ajax({
		type:"GET",
		url:"/teacher/CurrentTeacher",
		dataType:"json",
		success:function(msg){
			if(msg.status == "OK")
			{
				var teacher = msg.result;
				$("#teacher-name").text(teacher.teacherName);
				$("#telephone").text(teacher.teacherPhone);
			}
			else{
				alert(msg.result);
			}	
		},
		error: function(msg){
			alert(msg.result);
		}
	
	})
}
//显示教师所教授的课程
function getCourseByTeacherId() {
	
	$.ajax({
		type:"GET",
		url:"/teacherCourse/getCourseByTeacher",
		dataType:"json",
		success:function(msg){
			if(msg.status == "OK")
			{
				//显示课程
				var courses = msg.result;
				if(courses.length == 0){
					return;
				}
				$(".course_number").text("课程"+courses.length);
				$(".course-panel-body-wrapper").empty();
				var cookie_courseId = "courseId" ;
				$.each(courses, function(idx, course){
					c = '<div class="course-card-wrapper"><div class="box"><a href="teacher-course-base.html?href=teacher-course-introduce" onclick="setCookie('+cookie_courseId+','+course.courseId+');" target="_blank" class="ga-click">'
						+'<div class="img"><img src="http://img1.ph.126.net/1JJdFGKDIKqvVeS7i9XJrQ==/6630083702792788774.jpg" alt="'+course.courseName+'"></div>'
						+'<div class="body">'
						+'<div class="common-info-wrapper common-info-wrapper-fix-height">'
						+'<div class="title"><div class="text"><span class="text">'+course.courseName+'</span></div></div>'
						+'<div class="school"><a target="_blank" href="#">华中科技大学</a></div>'
						+'</div>'
						+'<div class="personal-info"><div class="course-status">'+dateFormat(course.courseBegintime)+'开始</div></div>'
						+'</div>'
						+'</a></div></div>';
					$(".course-panel-body-wrapper").append(c);
				});
				
			}
			else{
				alert(msg.result);
			}	
		},
		error: function(msg){
			alert(msg.result);
		}
	
	})
	
}