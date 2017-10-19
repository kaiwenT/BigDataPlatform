/**
 * 课程页面有关的js方法
 */

//course-base页面左侧显示课程封面图片
function showCoursePhoto(){
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
}

//Student-courseware页面显示课程的章
function showChapters(){
	var courseId = $(".course-image").attr("id");
	
	if(courseId == null || courseId == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getChaptersByCourse",
		dataType : "json",
		data : {
			courseId : courseId
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var chapters = msg.result;
				
				if(chapters != 'undefined' && chapters != '' && chapters.length > 0){
					$(".m-learnChapterNormal").empty();
					$.each(chapters, function(idx, chapter){
						
						var titlebox = '<div><div class="titleBox j-titleBox f-cb" id="'+chapter.chapterId+'" onclick="chapterClick(this)">'
							+'<div class="f-icon cpicon j-down f-fl u-icon-caret-up" style=""></div>'
							+'<div class="f-icon cpicon j-up f-fl u-icon-caret-down" style=""></div>'
							+'<h3 class="j-titleName name f-fl f-thide">'+chapter.chapterName+'</h3></div></div>';
						$(".m-learnChapterNormal").append(titlebox);
						showSections(chapter.chapterId);
					});
					 $(".titleBox").children(".u-icon-caret-up").css("display","none");
			         $(".titleBox").children(".u-icon-caret-down").css("display","block");
					
				}else{
					
					$(".empty").css("display", "inline");
					$(".m-learnChapterNormal").css("display", "none");
				}
			} else {
				alert(msg.result);
			}
		},
		error : function(msg) {
			error(msg);
		}
	})
}

function showSections(chapterId){	
	if(chapterId == null || chapterId == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getSectionsByChapter",
		dataType : "json",
		data : {
			chapterId : chapterId
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var sections = msg.result;
				console.log(chapterId + sections.length)
				if(sections != 'undefined' && sections != '' && sections.length > 0){
//					$(".m-learnChapterNormal").empty();
					var sectionshtml = '';
					$.each(sections, function(idx, section){
						console.log(chapterId+section.sectionname)
						var lessonbox = '<div class="lessonBox j-lessoBox" id="'+section.sectionid+'">'
				            +'<div class="u-learnLesson normal f-cb" id="">'
				            +'<div class="j-icon icon f-pa icon-2"></div>'
				            +'<h4 class="j-name name f-fl f-thide">'+section.sectionname+'</h4>'
				            +'<div class="j-typebox f-cb f-fr">'
				            +'<div><div class="f-icon lsicon f-fl learned" data-cid="1003495671" title="视频：'+section.sectionname+'" id="auto-id-1508033115800" onclick="baseAjax("'+'student-courseware-details'+'")">'
				            +'<span class="u-icon-video2"></span></div>'
				            +'<div class="f-icon lsicon f-fl " data-cid="1003495672" title="课件：'+section.sectionname+'" id="auto-id-1508033115802">'
				            +'<span class="u-icon-text"></span></div>'
				            +'</div></div></div></div>';						
						sectionshtml += lessonbox;
					});
					$(".titleBox#"+chapterId).after(sectionshtml);
					$(".lessonBox").css("display","none");
				}else{
					console.log('第'+chapterId+'章没有小节');
//					$(".empty").css("display", "inline");
//					$(".m-learnChapterNormal").css("display", "none");
				}
			} else {
				alert(msg.result);
			}
		},
		error : function(msg) {
			error(msg);
		}
	})
}

function chapterClick(e){
	if($(e).children(".u-icon-caret-up").css("display")=="none"){
        $(e).children(".u-icon-caret-up").css("display","block");
        $(e).children(".u-icon-caret-down").css("display","none");
        $(e).nextAll(".lessonBox").css("display","block");
    }else{
        $(e).children(".u-icon-caret-up").css("display","none");
        $(e).children(".u-icon-caret-down").css("display","block");
        $(e).nextAll(".lessonBox").css("display","none");
    }
}