/**
 * 课程页面有关的js方法
 */

//显示课程封面图片
$(function(){
	var courseId = getCookie("courseId");
	if(courseId != null && courseId != 'undefined'){
		$(".course-image").attr("id",courseId);
	}
	$.ajax({
		type : "POST",
		url : "/course/getCourseById",
		dataType : "json",
		data : {
			courseId : courseId
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var course = msg.result;
				if(course.coursePicturepath != 'undefined' && course.coursePicturepath != ''){
					$(".course-image").attr("src", course.coursePicturepath);
				}
				if(course.courseName != 'undefined' && course.courseName != ''){
					$(".course-image").attr("alt", course.courseName);
				}
			} else {
				alert(msg.result);
			}
		},
		error : function(msg) {
			error(msg);
		}
	})
});