/**
 * 学生实验页面有关的js方法
 */
  //文件存放路径
var imgPath = 'http://211.69.197.95:8081/bigdataplatform/file/';
//student-experiment页面显示课程的实验
function showExperiments(){
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
					$(".m-learnChapterNormal").empty();
					$.each(exps, function(idx, exp){
						
						var titlebox = '<div><div class="titleBox j-titleBox f-cb f-pr" id="'+exp.experimentId+'" onclick="titleClick(this)">'
							+'<div class="f-icon cpicon j-down f-fl u-icon-caret-up" style=""></div>'
							+'<div class="f-icon cpicon j-up f-fl u-icon-caret-down" style="display: none;"></div>'
							+'<h3 class="j-titleName name f-fl f-thide">'+exp.experimentName+'</h3>'
							+'<div class="submitTime f-fl">截止时间：'+dateFormat(exp.experimentDeadline)+' 23:59</div>'
							+'<div class="score f-fl">成绩：<span class="expScore" id="'+exp.experimentId+'">100</span></div>'
							+'<button class="u-btn u-btn-default f-pa" id="'+exp.experimentId+'" onclick="submitButtonClick(this);" style="top:2px; right:0; height: 36px; font-size: 1.23em">提交作业</button></div>'
							+'<div class="exp-box" id="'+exp.experimentId+'" style="display:none;"><div class="exp-source exp-video f-pr"><div class="f-pr f-fl source-sign">'
							+'<span class="u-icon-video2" style="font-size: 20px;margin: -10px -10px; top:50px; left:50%;position: relative; "></span></div>'
							+'<div class="source-box"></div></div>'
							+'<div class="exp-source exp-pdf"><div class="f-pr f-fl source-sign">'
							+'<span class="icon-book" style="font-size: 20px;margin: -10px -10px; top:50px; left:50%;position: relative; "></span></div>'
							+'<div class="source-box"></div></div></div></div>';
						$(".m-learnChapterNormal").prepend(titlebox);
						showExperimentScore(exp.experimentId);
						showFiles(exp.experimentId);
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
//
function showFiles(experimentId){
	$.ajax({
		type : "POST",
		url : "/experiment/getFilesByExperiment",
		dataType : "json",
		data : {
			experimentId : experimentId,
			type : ""
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var files = msg.result;
				$(".source-box").empty();
				if(files != 'undefined' && files != '' && files.length > 0){
					
					$.each(files, function(idx, file){
						var box = '';
						if(file.fileType == "VIDEO"){
							box = '<div title="'+file.fileName+'" class="f-pr f-fl source-video" style="background-image:url('+imgPath+file.fileId+'.jpg);" id="'+file.fileId+'" onclick="videoClick(this)"><div class="video-play" style="">'
								+'<span class="u-icon-video" style="font-size: 40px;margin: -20px -20px; top:50%; left:50%;position: absolute; "></span></div></div>';
							$("div#"+experimentId).children(".exp-video").children(".source-box").prepend(box);
						}
						if(file.fileType == "PDF"){
							box = '<div title="'+file.fileName+'" class="f-pr f-fl source-pdf" style="background-image:url('+imgPath+file.fileId+'.jpg);" id="'+file.fileId+'" onclick="pdfClick(this)"><div class="pdf-view" style="">'
								+'<span class="u-icon-book" style="font-size: 40px;margin: -20px -20px; top:50%; left:50%;position: absolute; "></span></div></div>';
							$("div#"+experimentId).children(".exp-pdf").children(".source-box").prepend(box);
						}
						
					});
					
				}
			}else{
				$(".exp-box").empty();
			}
		},
		error : function(msg) {
			error(msg);
		}
	})
}

//显示学生实验的分数
function showExperimentScore(expId){
	$.ajax({
		type : "POST",
		url : "/experiment/getExperimentScore",
		dataType : "json",
		data : {
			experimentId : expId
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var score = msg.result;
				if(score != null && score != "undefined"){
					$("span#"+expId).text(score);
				}				
			}
			else{
				alert(msg.result);
			}
		},
		error : function(msg) {
			error(msg);
		}
	})
}
/**
 * 实验标题点击事件
 * @param e
 * @returns
 */
function titleClick(e){
    if ($(e).children(".u-icon-caret-up").css("display") == "none") {
        $(e).children(".u-icon-caret-up").css("display", "block");
        $(e).children(".u-icon-caret-down").css("display", "none");
        $(e).next(".exp-box").css("display", "block");
    } else {
        $(e).children(".u-icon-caret-up").css("display", "none");
        $(e).children(".u-icon-caret-down").css("display", "block");
        $(e).next(".exp-box").css("display", "none");
    }  
}
//视频点击事件
function videoClick(e){
	var id = $(e).attr("id");
	var name = $(e).attr("title");
	if(id == "" || name == "" || id == 'undefined' || name == 'undefined'){
		return;
	}
	setCookie("fileId", id);
	setCookie("fileName", name);
	baseAjax("student-experiment-video");
}
//pdf点击事件
function pdfClick(e){
	var id = $(e).attr("id");
	var name = $(e).attr("title");
	if(id == "" || name == "" || id == 'undefined' || name == 'undefined'){
		return;
	}
	setCookie("fileId", id);
	setCookie("fileName", name);
	baseAjax("student-experiment-pdf");
}
//提交作业按钮的点击事件
function submitButtonClick(e){
	var expid = $(e).attr("id");
	$(".m-mask").css("display", "block");
	$.ajax({
		type : "POST",
		url : "/experiment/getExperimentById",
		dataType : "json",
		data : {
			experimentId : expid
		},
		success : function(msg) {
			if (msg.status == "OK") {
				var exp = msg.result;
				if(exp != null || score != "undefined"){
					$(".require-info").attr("id", exp.experimentId);
					$(".submit-demand").text(exp.experimentSubmitdemand);
					$(".require-info").css("display", "block");
					$(".submit-box").css("display", "none");
				}				
			}
			else{
				alert(msg.result);
			}
		},
		error : function(msg) {
			error(msg);
		}
	})
}

//我知道了button点击事件
function iKnow() {
	$(".require-info").css("display","none");
	$(".submit-box").css("display","block");
    $(".submit-box").css("background-color","");       
}

function showHelp() {
    $(".require-info").css("display","block");
    $(".submit-box").css("background-color","rgba(255,255,255,0.7)");
}

function closeBox() {
    $(".m-mask").css("display","none");
}
//打开文件选择器
function openFile(e){
    $(e).nextAll("input").click();
}

//上传实验结果文件
$(".submit-exp-result").change(function () {
        fileList = $(this)[0].files;
        if (fileList.length == 0) {
            return;
        } else {
            for (i = 0; i < fileList.length; i++) {
                var file = fileList[i];
                var tempStr = file.name.split(".");
                var fileType = tempStr[tempStr.length - 1];
                if (fileType.search(/zip|java|xls|xlsx|txt/i) == -1) {
                    alert("不是指定格式文件！")
                    continue;
                }
                var content = '<span class="content">'+file.name+'</span>';
                $(this).next().append(content);
                //调用ajax方法发送请求
                uploadResult($(this).next().children(":last"), file, "exp-data");
            }
        }
});

//上传实验报告文件
$(".submit-exp-report").change(function () {
    fileList = $(this)[0].files;
    if (fileList.length == 0) {
        return;
    } else {
        for (i = 0; i < fileList.length; i++) {
            var file = fileList[i];
            var tempStr = file.name.split(".");
            var fileType = tempStr[tempStr.length - 1];
            if (fileType.search(/pdf/i) == -1) {
                alert("不是指定格式文件！")
                continue;
            }
            var content = '<span class="content">'+file.name+'</span>';
            $(this).next().append(content);
            uploadResult($(this).next().children(":last"), file, "exp-report");
        }
    }
});

/**
 * 上传文件
 * @param e 待上传文件的span元素
 * @param file 待上传的文件
 * @param type 文件类型 exp-report/exp-data
 * @returns
 */
function uploadResult(e, file, type){
	var url = "";
	if(type == "exp-report"){
		url = "/student/uploadExpReport";
	}else if(type == "exp-data"){
		url = "/student/uploadExpData";
	}
    var expid = $(".require-info").attr("id");
    var formData = new FormData();
    formData.append("uploadfile" , file);
    formData.append("experimentId" , expid);
	$.ajax({
		type : "POST",
		url : url,
        dataType:"json",
		processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        enctype:"multipart/form-data",
		data : formData,
		success : function(msg) {
			if (msg.status == "OK") {
				$(e).addClass("content-ok");			
			}
			else{
				alert(msg.result);
			}
		},
		error : function(msg) {
			console.log(msg);
		}
	})
	
}