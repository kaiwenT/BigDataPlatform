/**
 * Created by Jack on 2017/10/18.
 */
  //文件存放路径
var imgPath = 'http://211.69.197.95:8081/bigdataplatform/file/';
//标题点击事件 实现展开功能
function titleClick(e) {
    if ($(e).children(".u-icon-caret-up").css("display") == "none") {
        $(e).children(".u-icon-caret-up").css("display", "block");
        $(e).children(".u-icon-caret-down").css("display", "none");
        $(e).nextAll(".expBox").css("display", "block");
    } else {
        $(e).children(".u-icon-caret-up").css("display", "none");
        $(e).children(".u-icon-caret-down").css("display", "block");
        $(e).nextAll(".expBox").css("display", "none");
    }
}
//日期选择器
function showTime(e){
    jeDate({
        dateCell:"#"+$(e).attr("id"),
        format:"YYYY-MM-DD hh:mm:ss",
        isTime:true,
        minDate:"2016-01-01 00:00:00",
        trigger: "click"
    })
    stopBubble()
}
//显示所有实验中的文件
function showFiles(experimentId)
{
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
				$(".source-box").children(".u-source-ok").remove();
				if(files != 'undefined' && files != '' && files.length > 0){
					$.each(files, function(idx, file){
						var box = '';
						if(file.fileType == "VIDEO"){
							var content = '<div class="f-pr f-fl source-video source-ok" title="' + file.fileName + '" style="background-image:url('+imgPath+file.fileId+'.jpg);" id="'+file.fileId+'" onmousemove="uSHover(this)"' +
		                    'onmouseleave="uSBlur(this)">' +
		                    '<div class="f-pa u-source-close" onclick="delVideo(this)">' +
		                    '<span class="u-icon-close"></span>' +
		                    '</div>' +
		                    '</div>';
							$("div#"+experimentId).find(".source-video-add").parent().before(content);
						}
						if(file.fileType == "PDF"){
							var content = '<div class="f-pr f-fl source-pdf source-ok" title="' + file.fileName + '" style="background-image:url('+imgPath+file.fileId+'.jpg);" id="'+file.fileId+'" onmousemove="uSHover(this)"' +
		                    'onmouseleave="uSBlur(this)">' +
		                    '<div class="f-pa u-source-close" onclick="delPdf(this)">' +
		                    '<span class="u-icon-close"></span>' +
		                    '</div>' +
		                    '</div>';
							$("div#"+experimentId).find(".source-pdf-add").parent().before(content);
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
//显示所有实验
function showExperiment()
{
	var courseId = getCookie("courseId");
	if(courseId == null || courseId == 'undefined'){
		alert("登录信息已过期，请重新登录！");
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
				console.log(exps);
				if(exps != 'undefined' && exps != '' && exps.length > 0){
					$.each(exps, function(idx, exp){
						var submit=exp.experimentSubmitdemand;
						 var content = '<div>'+
					        '<div class="titleBox j-titleBox f-cb" id="'+exp.experimentId+'" onclick="titleClick(this)">'+
					        '<div class="f-icon cpicon j-down f-fl u-icon-caret-up" style="display: none;"></div>'+
					        '<div class="f-icon cpicon j-up f-fl u-icon-caret-down" style=""></div>'+
					        '<input class="j-titleName name f-fl f-thide" disabled value="'+exp.experimentName+'"'+
					    'placeholder="请输入章名" style="width: 30%;" onclick="stopBubble()">'+
					        '<input class="j-titleName" id="end-time'+exp.experimentId+'" style="width: 155px;display: inline-block"  readonly onclick="stopBubble()" value="'+new Date(exp.experimentDeadline.time).format('yyyy-MM-dd hh:mm:ss')+'" placeholder="请选择时间">'+
					        '<div class="j-typebox f-cb f-fr" onclick="stopBubble()">'+
					        '<div class="f-icon lsicon f-fl " title="编辑" onclick="editInfo(this)">'+
					        '<span class="u-icon-edit"></span>'+
					        '</div>'+
					        '<div class="f-icon lsicon f-fl" title="保存" style="display: none;" onclick="storeInfo(this)">'+
					        '<span class="u-icon-check"></span>'+
					        '</div>'+
					        '<div class="f-icon lsicon f-fl " title="删除" onclick="delTitle(this)">'+
					        '<span class="u-icon-close"></span>'+
					        '</div>'+
					        '</div>'+
					        '</div>'+
					        '<div class="expBox" id="'+exp.experimentId+'" style="">'+
					        '<div class="exp-source exp-info f-pr" style="">'+
					        '<textarea class="source-info" onchange="autoSubmitTextarea(this)" placeholder="请输入实验提交要求">'+submit+'</textarea>'+
					        '</div>'+
					        '</div>'+
					        '<div class="expBox" id="'+exp.experimentId+'" style="">'+
					        '<div class="exp-source exp-video f-pr" style="">'+
					        '<div class="f-pr f-fl source-sign">'+
					        '<span class="u-icon-video2"'+
					    'style="font-size: 20px;margin: -10px -10px; top:50px; left:50%;position: relative; "></span>'+
					        '</div>'+
					        '<div class="source-box">  '+
					        '<div class="f-pr f-fl source-video" style="border: 1px" title="添加实验视屏">'+
					        '<div class="f-pa source-video-add" onclick="addVideo(this)">'+
					        '<span class="f-pa u-icon-plus" style="font-size: 40px;margin: -20px -20px; top:50%; left:50%;"></span>'+
					        '</div>'+
					        '<input type="file" multiple="multiple" style="width: 0px;height: 0px;display: none">'+
					        '</div>'+
					        '</div>'+
					        '</div>'+
					        '</div>'+
					        '<div class="expBox" id="'+exp.experimentId+'" style="">'+
					        '<div class="exp-source exp-pdf f-pr" style="">'+
					        '<div class="f-pr f-fl source-sign">'+
					        '<span class="icon-book"'+
					    'style="font-size: 20px;margin: -10px -10px; top:50px; left:50%;position: relative; "></span>'+
					        '</div>'+
					        '<div class="source-box">  '+
					        '<div class="f-pr f-fl source-pdf" style="border: 1px" title="添加实验文档">'+
					        '<div class="f-pa source-pdf-add" onclick="addPdf(this)">'+
					        '<span class="f-pa u-icon-plus" style="font-size: 40px;margin: -20px -20px; top:50%; left:50%;"></span>'+
					        '</div>'+
					        '<input type="file" multiple="multiple" style="width: 0px;height: 0px;display: none">'+
					        '</div>'+
					        '</div>'+
					        '</div>'+
					        '</div>'+
					        '</div>';
						$(".m-learnChapterNormal").prepend(content);
						showFiles(exp.experimentId);
					});
					var add='<div class="f-icon lesson-title-plus" style="width: 70px;height: 70px;" onclick="addTitle(this)">'+
					'<span class="u-icon-plus" style=" font-size: 60px;margin: -30px -30px; position: absolute; top:50%; left:50%"></span>'+
					'</div>';
					$(".m-learnChapterNormal").append(add);
					 $(".titleBox").children(".u-icon-caret-up").css("display","block");
			         $(".titleBox").children(".u-icon-caret-down").css("display","none");
					
				}else{
					var add='<div class="f-icon lesson-title-plus" style="width: 70px;height: 70px;" onclick="addTitle(this)">'+
					'<span class="u-icon-plus" style=" font-size: 60px;margin: -30px -30px; position: absolute; top:50%; left:50%"></span>'+
					'</div>';
					$(".m-learnChapterNormal").append(add);
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

//添加实验信息
function addTitle(e) {
	if($("#end-time").length > 0){
		alert("请先完成上一个实验的内容！");
		return;
	}
    var content = '<div>'+
        '<div class="titleBox j-titleBox f-cb" id="" onclick="titleClick(this)">'+
        '<div class="f-icon cpicon j-down f-fl u-icon-caret-up" style=""></div>'+
        '<div class="f-icon cpicon j-up f-fl u-icon-caret-down" style="display: none;"></div>'+
        '<input class="j-titleName name f-fl f-thide" value=""'+
    'placeholder="请输入章名" style="width: 30%;" onclick="stopBubble()">'+
        '<input class="j-titleName" id="end-time" style="width: 155px;display: inline-block"  readonly onclick="showTime(this)" value="" placeholder="请选择时间">'+
        '<div class="j-typebox f-cb f-fr" onclick="stopBubble()">'+
        '<div class="f-icon lsicon f-fl " title="编辑" style="display: none;"  onclick="editInfo(this)">'+
        '<span class="u-icon-edit"></span>'+
        '</div>'+
        '<div class="f-icon lsicon f-fl" title="保存"  onclick="storeInfo(this)">'+
        '<span class="u-icon-check"></span>'+
        '</div>'+
        '<div class="f-icon lsicon f-fl " title="删除" onclick="delTitle(this)">'+
        '<span class="u-icon-close"></span>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '<div class="expBox" style="">'+
        '<div class="exp-source exp-info f-pr" style="">'+
        '<textarea class="source-info" onchange="autoSubmitTextarea(this)" placeholder="请输入实验提交要求"></textarea>'+
        '</div>'+
        '</div>'+
        '<div class="expBox" style="">'+
        '<div class="exp-source exp-video f-pr" style="">'+
        '<div class="f-pr f-fl source-sign">'+
        '<span class="u-icon-video2"'+
    'style="font-size: 20px;margin: -10px -10px; top:50px; left:50%;position: relative; "></span>'+
        '</div>'+
        '<div class="source-box">  '+
        '<div class="f-pr f-fl source-video addvideo" style="border: 1px" title="添加实验视屏">'+
        '<div class="f-pa source-video-add" onclick="addVideo(this)">'+
        '<span class="f-pa u-icon-plus" style="font-size: 40px;margin: -20px -20px; top:50%; left:50%;"></span>'+
        '</div>'+
        '<input type="file" multiple="multiple" style="width: 0px;height: 0px;display: none">'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '<div class="expBox" style="">'+
        '<div class="exp-source exp-pdf f-pr" style="">'+
        '<div class="f-pr f-fl source-sign">'+
        '<span class="icon-book"'+
    'style="font-size: 20px;margin: -10px -10px; top:50px; left:50%;position: relative; "></span>'+
        '</div>'+
        '<div class="source-box">  '+
        '<div class="f-pr f-fl source-pdf addpdf" style="border: 1px" title="添加实验文档">'+
        '<div class="f-pa source-pdf-add" onclick="addPdf(this)">'+
        '<span class="f-pa u-icon-plus" style="font-size: 40px;margin: -20px -20px; top:50%; left:50%;"></span>'+
        '</div>'+
        '<input type="file" multiple="multiple" style="width: 0px;height: 0px;display: none">'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>';
    $(e).before(content);
}


//编辑章节信息
function editInfo(e) {
    $(e).parent().prevAll("input.name").removeAttr("disabled");
    $(e).css("display", "none");
    $(e).next("div").css("display", "block");
    $(e).parent().prevAll("input.name").focus();
    $(e).parent().prevAll("input.name").next().attr("onclick","showTime(this)");
}
//增加实验
function storeInfo(e) {
    //上传数据，更新实验信息
    var experimentId = $(e).parents(".titleBox").attr("id");
    var courseId = getCookie("courseId");
    var exptitle=$(e).parent().prev().prev("input").val();
    var expdeadline=$(e).parent().prev("input").val();
    if(exptitle==""||expdeadline=="")
	{
    	alert("实验名称或截至时间为空！");
    	return;
	}
    if(experimentId==null || experimentId=="") //如果ID不存在，则插入
	{
    	$.ajax({
        	type:"POST",
    		url:"/experiment/AddExperiment",
    		data:
    		{	courseId:courseId, 
    			exptitle:exptitle,
    			expdeadline:expdeadline
    		},
    		datatype:"json",
    		success:function(msg){
    			if(msg.status=="OK"){
    				$(e).parent().prevAll("input.name").attr("disabled", "disabled");
    				$(e).parent().prevAll("input.name").next().attr("onclick","stopBubble()");
    				$(e).parent().prev("input.name").attr("id", msg.result.experimentId);
    			    $("#jedatebox").css("display","none");
    				$(e).css("display", "none");
    				$(e).prev("div").css("display", "block");		
    				$(".m-learnChapterNormal").empty();
    				 showExperiment();
    			}
    			else{
    				alert(msg.result);
    			}	
    		},
    		error:function(msg){
    			alert(msg.result);
    		},
        })
	}
    else{
    	$.ajax({
        	type:"POST",
    		url:"/experiment/UpdateExperiment",
    		data:
    		{	experimentId:experimentId, 
    			courseId:courseId, 
    			exptitle:exptitle,
    			expdeadline:expdeadline
    		},
    		datatype:"json",
    		success:function(msg){
    			if(msg.status=="OK"){
    				$(e).parent().prevAll("input.name").attr("disabled", "disabled");
    				$(e).parent().prevAll("input#end-time").attr("onclick","stopBubble()");
    				$("#jedatebox").css("display","none");
      				$(e).css("display", "none");
      				$(e).prev("div").css("display", "block");
    				alert("修改成功！");
    			}
    			else{
    				alert(msg.result);
    			}	
    		},
    		error:function(msg){
    			alert(msg.result);
    		},
        })
    	
    }

}

//删除实验
function delTitle(e) {
    var status = confirm("是否确定删除该章所有信息？");
    if (status == true) {
      
        var courseId = getCookie("courseId");
        var experimentId = $(e).parents(".titleBox").attr("id");
        $.ajax({
            type: "POST",
            url: "/experiment/DeleteExperiment",       
            dataType:"json",
            data: {
            	experimentId:experimentId,
            	courseId:courseId,
            },
            success : function(msg) {
                if (msg.status == "OK") {
                	 $(e).parents("div.titleBox").parent("div").remove();
                	 alert(msg.result);
                } else {
                	 alert(msg.result);
                }  
            },
            error : function() {
                alert("删除失败！");
            }
        })
    }
}



//阻止事件冒泡
function stopBubble(e) {
    window.event ? window.event.cancelBubble = true : e.stopPropagation();
}


//u-source的鼠标悬浮事件，未上传的文件悬浮时出现上传按钮，已上传的文件悬浮时出现close按钮
function uSHover(e) {
    if ($(e).hasClass("u-source-ok")) {
        $(e).children(".u-source-close").css("display", "block");
    }
}

//u-source的鼠标离开事件，未上传的文件鼠标离开时上传按钮消失，已上传的文件鼠标离开时close按钮消失
function uSBlur(e) {
    if ($(e).hasClass("u-source-ok")) {
        $(e).children(".u-source-close").css("display", "none");
    }
}

//监听实验要求，超过10s没有keyup提交实验要求
var autoSb = null;
function autoSubmitTextarea(e){
    if(autoSb != null)
        clearTimeout(autoSb);
        autoSb = setTimeout(function(){
    	var experimentId = $(e).parents(".expBox").attr("id");
    	var submitDemand = $(e).val().replace(/\n|\r\n/g,"<br>");
    	$.ajax({
        	type:"POST",
    		url:"/experiment/UpdateExpSubmitDemand",
    		data:
    		{	experimentId:experimentId, 
    			submitDemand:submitDemand,
    		},
    		datatype:"json",
    		success:function(msg){
    			if(msg.status=="OK"){
    				$(".m-learnChapterNormal").empty();
   				 	showExperiment();
    			}
    			else{
    				alert(msg.result);
    			}	
    		},
    		error:function(msg){
    			alert(msg.result);
    		},
        })
        var date = new Date();
       },1000);
}


//在本地添加视频文件准备上传
function addVideo(e,event) {
    window.event ? window.event.cancelBubble = true : event.stopPropagation();
    $(e).next("input").click();
    $(e).next("input").off("change");
    $(e).next("input").change(function () {
        fileList = $(e).next("input")[0].files;
        alert("文件数：" + fileList.length + "第一个文件名：" + fileList[0].name + "文件" + fileList[0]);
        if (fileList.length == 0) {
            return;
        } else {
            for (i = 0; i < fileList.length; i++) {
                var file = fileList[i];
                var tempStr = file.name.split(".");
                var fileType = tempStr[tempStr.length-1];
                alert(fileType.search(/mp4|mpeg|mpeg4|ogg/i))
                if(fileType.search(/mp4|mpeg|mpeg4|ogg/i)==-1){
                    alert("不是视频文件！")
                    continue;
                }

                var content = '<div class="f-pr f-fl source-video" title="' + file.name + '" onmousemove="uSHover(this)"' +
                    'onmouseleave="uSBlur(this)">' +
                    '<div class="f-pa u-source-upload" data-path="'+file+'" onclick="uploadVideo(this)">' +
                    '<span class="icon-upload-alt"></span>' +
                    '</div>' +
                    '<div class="f-pa u-source-close" style="display:none;" onclick="delVideo(this)">' +
                    '<span class="u-icon-close"></span>' +
                    '</div>' +
                    '</div>';
                $(e).parents(".source-video").before(content);
                uploadVideo1($(e).parents(".source-video").prev(".source-video"),file);
            }
        }
    });
}

//视频异步上传
function uploadVideo1(e,file) {
	var formData = new FormData();
    formData.append("formData" , file);
    var experimentId = e.parents(".expBox").attr("id");
    var type="VIDEO";
    formData.append("experimentId" , experimentId);
    formData.append("type" , type);
    $.ajax({
        type: "POST",
        url: "/experiment/UploadFile",
        dataType:"json",
        data: formData,　　//这里上传的数据使用了formData 对象
        processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        enctype:"multipart/form-data",
        success : function(msg) {
            if (msg.status == "OK") {
                e.addClass("source-ok");
                e.children(".u-source-upload").css("display","none");
                e.children(".u-source-close").css("display","block");
                e.css("background-image","url("+imgPath+msg.result+".jgp)");
                alert("上传成功！");
            } else {
            	 alert(msg.result);
            }
        },
        error : function() {
            alert("上传文件失败请重新上传！");
        }
    })
}

//在本地添加pdf文件准备上传
function addPdf(e,event) {
    window.event ? window.event.cancelBubble = true : event.stopPropagation();
    $(e).next("input").click();
    $(e).next("input").off("change");
    $(e).next("input").change(function () {
        fileList = $(e).next("input")[0].files;
        alert("文件数：" + fileList.length + "第一个文件名：" + fileList[0].name + "文件" + fileList[0]);
        if (fileList.length == 0) {
            return;
        } else {
            for (i = 0; i < fileList.length; i++) {
                var file = fileList[i];
                var tempStr = file.name.split(".");
                var fileType = tempStr[tempStr.length-1];
                if(fileType.search(/pdf/i)==-1){
                    alert("不是pdf文件！")
                    continue;
                }
                var content = '<div class="f-pr f-fl source-pdf" title="' + file.name + '" onmousemove="uSHover(this)"' +
                    'onmouseleave="uSBlur(this)">' +
                    '<div class="f-pa u-source-upload" data-path="'+file+'" onclick="uploadPdf(this)">' +
                    '<span class="icon-upload-alt"></span>' +
                    '</div>' +
                    '<div class="f-pa u-source-close" style="display:none;" onclick="delPdf(this)">' +
                    '<span class="u-icon-close"></span>' +
                    '</div>' +
                    '</div>';
                $(e).parents(".source-pdf").before(content);
                uploadPdf1($(e).parents(".source-pdf").prev(".source-pdf"),file);
            }
        }
    });
}

//视频异步上传
function uploadPdf1(e,file) {
    var formData = new FormData();
    formData.append("formData" , file);
    var experimentId = e.parents(".expBox").attr("id");
    var type="PDF";
    formData.append("experimentId" , experimentId);
    formData.append("type" , type);
    $.ajax({
        type: "POST",
        url: "/experiment/UploadFile",
        dataType:"json",
        data: formData,　　//这里上传的数据使用了formData 对象
        processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        enctype:"multipart/form-data",
        success : function(msg) {
            if (msg.status == "OK") {
                e.addClass("source-ok");
                e.children(".u-source-upload").css("display","none");
                e.children(".u-source-close").css("display","block");
                e.css("background-image","url("+imgPath+msg.result+".jpg)");
                alert("上传成功！");
            } else {
            	 alert(msg.result);
            }
        },
        error : function() {
            alert("上传文件失败请重新上传！");
        }
    })
}


//video删除
function delVideo(e) {
    var flag = confirm("是否删除该视频？");
    if (flag) {
    	 var experimentId = $(e).parents(".expBox").attr("id");
         var fileId = $(e).parents(".source-video").attr("id");
         $.ajax({
             type: "POST",
             url: "/experiment/DeleteFile",       
             dataType:"json",
             data: {
             	experimentId:experimentId,
             	fileId:fileId,
             },
             success : function(msg) {
                 if (msg.status == "OK") {
                 	$(e).parent(".source-video").remove();
                 	 alert(msg.result);
                 } else {
                 	 alert(msg.result);
                 }  
             },
             error : function() {
                 alert("删除失败！");
             }
         })
    }
}

//pdf删除
function delPdf(e) {
    var flag = confirm("是否删除该Pdf？");
    if (flag) {
        var experimentId = $(e).parents(".expBox").attr("id");
        var fileId = $(e).parents(".source-pdf").attr("id");
        $.ajax({
            type: "POST",
            url: "/experiment/DeleteFile",       
            dataType:"json",
            data: {
            	experimentId:experimentId,
            	fileId:fileId,
            },
            success : function(msg) {
                if (msg.status == "OK") {
                	$(e).parent(".source-pdf").remove();
                	alert(msg.result);
                } else {
                	 alert(msg.result);
                }  
            },
            error : function() {
                alert("删除失败！");
            }
        })
    }
}
