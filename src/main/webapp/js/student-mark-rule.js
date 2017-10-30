  //student-mark-rule.html 课程评分标准页面显示
function showCourseScale() {
	var courseId = $(".course-image").attr("id");
	if (courseId == null || courseId == 'undefined') {
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getCourseScale",
		dataType : "json",
		data : {
			courseId : courseId
		},
		success : function(msg) {
			if(msg.status == 'OK'){
				var s = msg.result;
				$(".regular-grade").val(100 * s.attendanceRate);
				$(".exp-grade").val(100 * s.experimentRate);
				$(".final-exam-grade").val(100 - 100 * s.attendanceRate - 100 * s.experimentRate);
				$(".check-grade").val(100 - 100 * s.exerciseRate);
				$(".regular-work").val(100 * s.exerciseRate);
				$(".exp-report").val(100 * s.expReportRate);
				$(".exp-result").val(100 - 100 * s.expReportRate);
			}
		},
		error : function(msg) {
			error(msg);
		}
	})
}

showCourseScale();
