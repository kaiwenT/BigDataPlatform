//文件存放路径
var path = 'http://211.69.197.95:8081/bigdataplatform/file/';

//Student-experiment-video页面显示实验的标题、文件标题
function showTitle(){
	var fileId = getCookie("fileId");
	var fileName = getCookie("fileName");
	
	if(fileId == null || fileId == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/experiment/getExperimentByFile",
		dataType : "json",
		data : {
			fileId : fileId
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var exp = msg.result;
				
				
				if(exp != 'undefined' && exp != ''){
					$(".u-learn-moduletitle").empty();
					var bread = '<div class="j-breadcb f-fl"><div class="u-learnBCUI f-cb">'
							+'<a href="javascript:;" class="f-fl f-fc3 f-f0 link" onclick="baseAjax('+"'student-experiment'"+')">实验</a>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-exp"><div class="u-select">'
							+'<div class="up j-up f-thide expup" onclick="expupClick(this)" id="'+exp.experimentId+'">'+exp.experimentName+'</div>'
							+'<div class="down f-bg j-list expdown" style="display: none;"></div></div></div>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-lesson"><div class="u-select">'
							+'<div class="up j-up f-thide fileup" onclick="fileupClick(this)" id="'+fileId+'">'+fileName+'</div>'
							+'<div class="down f-bg j-list filedown" style="display: none;"></div></div></div></div></div>';
					$(".u-learn-moduletitle").append(bread);
					$(".j-unitctBox").attr("id", fileId);
					if(fileId != ""){
						$(".unitctBox").empty();
						$(".unitctBox").append('<div class="ux-video-player" onclick="pp()">'
		                        +'<video controls preload="metadata" autoplay>'
		                        +'<source class="video" src="" type="video/mp4" id=""></video></div>');
						$(".video").attr("src", path+fileId+".mp4");
						
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

//显示所有实验
function showExps(){
var courseId = $(".course-image").attr("id");
	
	if(courseId == null || courseId == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/experiment/getExperimentsByCourse",
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
						
						var list = '<div class="f-thide list" onclick="expdownClick(this)" title="'+exp.experimentName+'"'
							+'id="'+exp.experimentId+'">'+exp.experimentName+'</div>';
						$(".expdown").prepend(list);
						
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

//显示实验的文件
function showFiles(expid){
	if(expid == null || expid == 'undefined'){
		return;
	}
	$.ajax({
		type : "POST",
		url : "/experiment/getFilesByExperiment",
		dataType : "json",
		data : {
			experimentId : expid,
			type : "VIDEO"
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

//实验title点击事件
function expupClick(e) {
	if($(".expdown").css("display")=="none"){
		showExps();
	}else{
		$(".expdown").css("display","none");
	}    
}
//下拉栏实验标题点击事件
function expdownClick(e){
	$(".expdown").css("display","none");
	
	$(".expup").attr("id", $(e).attr("id"));
	$(".expup").text($(e).text());
	$(".fileup").attr("id", "select");
	$(".fileup").text("请选择视频");
	
	$(".filedown").css("display", "none");
}
//文件标题栏点击事件
function fileupClick(e){
	var expid = $(".expup").attr("id");
	console.log(expid);
	if($(e).next(".filedown").css("display")=="none"){
		showFiles(expid);
	}else{
		$(e).next(".filedown").css("display","none");
	} 
	
}

//文件下拉列表点击事件
function filedownClick(e){
	setCookie("fileId", $(e).attr("id"));
	setCookie("fileName", $(e).attr("title"));
	showTitle();
}