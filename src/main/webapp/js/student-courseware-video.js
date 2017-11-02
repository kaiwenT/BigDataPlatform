//文件存放路径
var videoPath = 'http://211.69.197.95:8081/bigdataplatform/courseVideo/';
//Student-courseware-video页面显示课程的章 ,节标题
function showChapterTitle(){
	var sectionId = getCookie("sectionId");
	var fId = getCookie("videoId");
	
	if(sectionId == null || sectionId == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getChapterBySection",
		dataType : "json",
		data : {
			sectionId : sectionId,
			fileId : fId,
			type : "VIDEO"
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var res = msg.result;
				
				if(res != 'undefined' && res != null){
					$(".u-learn-moduletitle").empty();
					var bread = '<div class="j-breadcb f-fl"><div class="u-learnBCUI f-cb">'
							+'<a href="javascript:;" class="f-fl f-fc3 f-f0 link" onclick="baseAjax('+"'student-courseware'"+')">课件</a>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-chapter"><div class="u-select">'
							+'<div class="up j-up f-thide chapterup" onclick="chapterupClick(this)" id="'+res.chapterId+'">'+res.chapterName+'</div>'
							+'<div class="down f-bg j-list chapterdown" style="display: none;"></div></div></div>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-lesson"><div class="u-select">'
							+'<div class="up j-up f-thide sectionup" onclick="sectionupClick(this)" id="'+res.sectionId+'">'+res.sectionName+'</div>'
							+'<div class="down f-bg j-list sectiondown" style="display: none;"></div></div></div>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-lesson"><div class="u-select">'
							+'<div class="up j-up f-thide fileup" onclick="fileupClick(this)" id="'+res.fileId+'">'+res.fileName+'</div>'
							+'<div class="down f-bg j-list filedown" style="display: none;"></div></div></div>'
							+'</div></div>';
					$(".u-learn-moduletitle").prepend(bread);
					$(".j-unitctBox").attr("id", res.fileId);
					if(res.fileId != "undefined" && res.fileId != null){
						$(".unitctBox").empty();
						$(".unitctBox").append('<div class="ux-video-player" onclick="pp()">'
		                        +'<video controls preload="metadata" autoplay>'
		                        +'<source class="video" src="" type="video/mp4" id=""></video></div>');
						$(".video").attr("src", videoPath+res.courseId+"/"+res.chapterId+"/"+sectionId+"/"+res.fileId+".mp4");
						$(".video").attr("id", res.fileId);
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

//显示章
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
//显示MP4文件
function showVideos(sectionid){
	if(sectionid == null || sectionid == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getFilesBySection",
		dataType : "json",
		data : {
			sectionId : sectionid,
			type : "VIDEO"
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var files = msg.result;
				
				if(files != 'undefined' && files != null && files.length > 0){
					$(".filedown").empty();
					$.each(files, function(idx, file){
						
						var list = '<div class="f-thide list" onclick="filedownClick(this)" title="'+file.fileName+'"'
							+'id="'+file.fileId+'">'+file.fileName+'</div>';
						$(".filedown").prepend(list);
						
					});
					$(".filedown").css("display","block");
					
				}else{
					$(".filedown").css("display","none");
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
	
	if($(e).next(".sectiondown").css("display")=="none"){
		showSections(chapterid);
	}else{
		$(e).next(".sectiondown").css("display","none");
	} 
	
}


//节下拉列表点击事件
function sectiondownClick(e){
	$(".sectiondown").css("display","none");
	
	$(".sectionup").attr("id", $(e).attr("id"));
	$(".sectionup").text($(e).text());
	$(".fileup").attr("id", "select");
	$(".fileup").text("请选择文件");
	
	$(".sectiondown").css("display", "none");
}

//文件标题栏点击事件
function fileupClick(e){
	var sectionid = $(".sectionup").attr("id");
	
	if($(e).next(".filedown").css("display")=="none"){
		showVideos(sectionid);
	}else{
		$(e).next(".filedown").css("display","none");
	} 
	
}

//文件下拉列表点击事件
function filedownClick(e){
	setCookie("videoId", $(e).attr("id"));
	var sectionid = $(".sectionup").attr("id");
	setCookie("sectionId",sectionid);
	showChapterTitle();
}
