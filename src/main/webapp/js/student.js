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
showStudentPhoto();
showstudentInfo();
showstudentCourses();

//显示学生头像
function showStudentPhoto(){
    
    $.ajax({type: "post",        //使用post方法访问后台
        dataType: "text",         //返回text格式的数据，(这里存在疑问，Java部分是response输出流，这里应该指定什么样的数据类型）
        url: "",    //要访问的后台地址，这里是servlet的地址
//        data:{"filePath":filePath},   //要发送的数据
        success: function(data){//data为返回的数据，在这里做数据绑定
        	$(".u-ui-img.img").attr("src", "data:image/gif;base64," + data);
        	}
    });
}
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
				$(".courses_number").text("课程 "+courses.length);
				$(".course-panel-body-wrapper").empty();
				var cookie_courseId = "courseId" ;
				$.each(courses, function(idx, course){
					
					wrapper = '<div class="course-card-wrapper"><div class="box"><a href="course-base.html?href=announce" onclick="setCookie('+cookie_courseId+','+course.courseId+');" target="_blank" class="ga-click">'
						+'<div class="img"><img src="http://img1.ph.126.net/1JJdFGKDIKqvVeS7i9XJrQ==/6630083702792788774.jpg" alt="'+course.courseName+'"></div>'
						+'<div class="body"><div class="common-info-wrapper common-info-wrapper-fix-height">'
						+'<div class="title"><div class="text"><span class="text">'+course.courseName+'</span></div></div>'
						+'<div class="school"><a target="_blank" href="#">华中科技大学</a></div></div>'
						+'<div class="personal-info"><div class="course-status">'+dateFormat(course.courseBegintime)+'开始</div></div>'
						+'</div></a></div></div>';
					$(".course-panel-body-wrapper").append(wrapper);
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