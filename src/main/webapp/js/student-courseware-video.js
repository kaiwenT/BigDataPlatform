
//Student-courseware-pdf页面显示课程的章 ,节标题
function showTitle(){
	var fileId = getCookie("fileId");
	
	if(fileId == null || fileId == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getexpBySection",
		dataType : "json",
		data : {
			fileId : fileId
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
							+'<div class="f-fl j-exp"><div class="u-select">'
							+'<div class="up j-up f-thide expup" onclick="expupClick(this)" id="'+res[0]+'">'+res[1]+'</div>'
							+'<div class="down f-bg j-list expdown" style="display: none;"></div></div></div>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-lesson"><div class="u-select">'
							+'<div class="up j-up f-thide fileup" onclick="fileupClick(this)" id="'+fileId+'">'+res[4]+'</div>'
							+'<div class="down f-bg j-list filedown" style="display: none;"></div></div></div></div></div>';
					$(".u-learn-moduletitle").append(bread);
					$(".j-unitctBox").attr("id", fileId);
					if(res[2] != "" && fileId != ""){
						$(".unitctBox").empty();
						$(".unitctBox").append('<div class="ux-video-player" onclick="pp()">'
		                        +'<video controls preload="metadata" autoplay>'
		                        +'<source class="video" src="" type="video/mp4" id=""></video></div>');
						$(".video").attr("src", res[3]+"/"+fileId+".mp4");
						
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
function showexps(){
var courseId = $(".course-image").attr("id");
	
	if(courseId == null || courseId == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getexpsByCourse",
		dataType : "json",
		data : {
			courseId : courseId
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var exps = msg.result;
				
				if(exps != 'undefined' && exps != '' && exps.length > 0){
					$(".expdown").empty();
					$.each(exps, function(idx, exp){
						
						var list = '<div class="f-thide list" onclick="expdownClick(this)" title="'+exp.expName+'"'
							+'id="'+exp.expId+'">'+exp.expName+'</div>';
						$(".expdown").append(list);
						
					});
					$(".expdown").css("display","block");
					
				}else{
					$(".expdown").css("display","none");
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
function showSections(expid){
	if(expid == null || expid == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/course/getSectionsByexp",
		dataType : "json",
		data : {
			expId : expid
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var files = msg.result;
				
				if(files != 'undefined' && files != '' && files.length > 0){
					$(".filedown").empty();
					$.each(files, function(idx, file){
						
						var list = '<div class="f-thide list" onclick="filedownClick(this)" title="'+file.fileName+'"'
							+'id="'+file.fileId+'">'+file.fileName+'</div>';
						$(".filedown").append(list);
						
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
function expupClick(e) {
	if($(".expdown").css("display")=="none"){
		showexps();
	}else{
		$(".expdown").css("display","none");
	}    
}
//下拉栏章标题点击事件
function expdownClick(e){
	$(".expdown").css("display","none");
	
	$(".expup").attr("id", $(e).attr("id"));
	$(".expup").text($(e).text());
	$(".fileup").attr("id", "select");
	$(".fileup").text("请选择节");
	
	$(".filedown").css("display", "none");
}
//节标题栏点击事件
function fileupClick(e){
	var expid = $(".expup").attr("id");
	console.log(expid);
	if($(e).next(".filedown").css("display")=="none"){
		showSections(expid);
	}else{
		$(e).next(".filedown").css("display","none");
	} 
	
}

//节下拉列表点击事件
function filedownClick(e){
	setCookie("fileId", $(e).attr("id"));
	showTitle();
}