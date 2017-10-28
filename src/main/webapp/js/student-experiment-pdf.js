//文件存放路径
var path = 'http://211.69.197.95:8081/bigdataplatform/file/';

//Student-experiment-pdf页面显示实验的标题、文件标题
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
							+'<div class="up j-up f-thide exp-up" onclick="expupClick(this)" id="'+exp.experimentId+'">'+exp.experimentName+'</div>'
							+'<div class="down f-bg j-list exp-down" style="display: none;"></div></div></div>'
							+'<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
							+'<div class="f-fl j-lesson"><div class="u-select">'
							+'<div class="up j-up f-thide file-up" onclick="fileupClick(this)" id="'+fileId+'">'+fileName+'</div>'
							+'<div class="down f-bg j-list file-down" style="display: none;"></div></div></div></div></div>';
					$(".u-learn-moduletitle").append(bread);
					$(".j-unitctBox").attr("id", fileId);
					if(fileId != ""){
						$(".unitctBox").empty();
						$(".unitctBox").append("<a class='media'></a>");
						$(".media").attr("href", path+fileId+".pdf");
						$('a.media').media({width:986, height:800});
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

//显示实验标题下拉栏
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
					$(".exp-down").empty();
					$.each(exps, function(idx, exp){
						
						var list = '<div class="f-thide list" onclick="expdownClick(this)" title="'+exp.experimentName+'"'
							+'id="'+exp.experimentId+'">'+exp.experimentName+'</div>';
						$(".exp-down").append(list);
						
					});
					$(".exp-down").css("display","block");
					
				}else{
					$(".exp-down").css("display","none");
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
			type : "PDF"
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var files = msg.result;
				
				if(files != 'undefined' && files != '' && files.length > 0){
					$(".file-down").empty();
					$.each(files, function(idx, file){
						
						var list = '<div class="f-thide list" onclick="filedownClick(this)" title="'+file.fileName+'"'
							+'id="'+file.fileId+'">'+file.fileName+'</div>';
						$(".file-down").append(list);
						
					});
					$(".file-down").css("display","block");
					
				}else{
					$(".file-down").css("display","none");
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
//实验title点击事件
function expupClick(e) {
	if($(".exp-down").css("display")=="none"){
		showExps();
	}else{
		$(".exp-down").css("display","none");
	}    
}
//下拉栏实验标题点击事件
function expdownClick(e){
	$(".exp-down").css("display","none");
	
	$(".exp-up").attr("id", $(e).attr("id"));
	$(".exp-up").text($(e).text());
	$(".file-up").attr("id", "select");
	$(".file-up").text("请选择文档");	
	$(".file-down").css("display", "none");
}
//文件标题栏点击事件
function fileupClick(e){
	var expid = $(".exp-up").attr("id");
	console.log(expid);
	if($(e).next(".file-down").css("display")=="none"){
		showFiles(expid);
	}else{
		$(e).next(".file-down").css("display","none");
	} 
	
}

//文件下拉列表点击事件
function filedownClick(e){
	setCookie("fileId", $(e).attr("id"));
	showTitle();
}