//文件存放路径
var path = 'http://211.69.197.95:8081/bigdataplatform/courseVideo/';
//Student-courseware-video页面显示课程的章 ,节标题
function showChapterTitle(){
	var sectionId = getCookie("sectionId");
	
	if(sectionId == null || sectionId == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getChapterBySection",
		dataType : "json",
		data : {
			sectionId : sectionId
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var res = msg.result;
				//res[5] 数组存放 章id，章标题，PDF路径，视频路径，节标题
				
				if(res != 'undefined' && res != '' && res.length > 2){
					$(".u-learn-moduletitle").empty();
					var bread = '<div class="j-breadcb f-fl"><div class="u-learnBCUI f-cb">'
							+'<a href="javascript:;" class="f-fl f-fc3 f-f0 link" onclick="baseAjax('+"'student-courseware'"+')">课件</a>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-chapter"><div class="u-select">'
							+'<div class="up j-up f-thide chapterup" onclick="chapterupClick(this)" id="'+res[0]+'">'+res[1]+'</div>'
							+'<div class="down f-bg j-list chapterdown" style="display: none;"></div></div></div>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-lesson"><div class="u-select">'
							+'<div class="up j-up f-thide sectionup" onclick="sectionupClick(this)" id="'+sectionId+'">'+res[4]+'</div>'
							+'<div class="down f-bg j-list sectiondown" style="display: none;"></div></div></div></div></div>';
					$(".u-learn-moduletitle").prepend(bread);
					$(".j-unitctBox").attr("id", sectionId);
					if(res[2] != "" && sectionId != ""){
						$(".unitctBox").empty();
						$(".unitctBox").append('<div class="ux-video-player" onclick="pp()">'
		                        +'<video controls preload="metadata" autoplay>'
		                        +'<source class="video" src="" type="video/mp4" id=""></video></div>');
						$(".video").attr("src", res[3]+"/"+sectionId+".mp4");
						
					}
				}else{
					
					$(".empty").css("display", "inline");
					$(".u-learn-moduletitle").css("display", "none");
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

//
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
					$(".chapterdown").empty();
					$.each(chapters, function(idx, chapter){
						
						var list = '<div class="f-thide list" onclick="chapterdownClick(this)" title="'+chapter.chapterName+'"'
							+'id="'+chapter.chapterId+'">'+chapter.chapterName+'</div>';
						$(".chapterdown").prepend(list);
						
					});
					$(".chapterdown").css("display","block");
					
				}else{
					$(".chapterdown").css("display","none");
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

//显示节
function showSections(chapterid){
	if(chapterid == null || chapterid == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getSectionsByChapter",
		dataType : "json",
		data : {
			chapterId : chapterid
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var sections = msg.result;
				
				if(sections != 'undefined' && sections != '' && sections.length > 0){
					$(".sectiondown").empty();
					$.each(sections, function(idx, section){
						
						var list = '<div class="f-thide list" onclick="sectiondownClick(this)" title="'+section.sectionname+'"'
							+'id="'+section.sectionid+'">'+section.sectionname+'</div>';
						$(".sectiondown").prepend(list);
						
					});
					$(".sectiondown").css("display","block");
					
				}else{
					$(".sectiondown").css("display","none");
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

$('a.media').media({width:986, height:800});
//章title点击事件
function chapterupClick(e) {
	if($(".chapterdown").css("display")=="none"){
		showChapters();
	}else{
		$(".chapterdown").css("display","none");
	}    
}
//下拉栏章标题点击事件
function chapterdownClick(e){
	$(".chapterdown").css("display","none");
	
	$(".chapterup").attr("id", $(e).attr("id"));
	$(".chapterup").text($(e).text());
	$(".sectionup").attr("id", "select");
	$(".sectionup").text("请选择节");
	
	$(".sectiondown").css("display", "none");
}
//节标题栏点击事件
function sectionupClick(e){
	var chapterid = $(".chapterup").attr("id");
	console.log(chapterid);
	if($(e).next(".sectiondown").css("display")=="none"){
		showSections(chapterid);
	}else{
		$(e).next(".sectiondown").css("display","none");
	} 
	
}

//节下拉列表点击事件
function sectiondownClick(e){
	setCookie("sectionId", $(e).attr("id"));
	showChapterTitle();
}