/**
 * Created by Jack on 2017/10/16.
 */


//标题点击时间 实现展开功能
function titleClick(e) {
    if ($(e).children(".u-icon-caret-up").css("display") == "none") {
        $(e).children(".u-icon-caret-up").css("display", "block");
        $(e).children(".u-icon-caret-down").css("display", "none");
        $(e).next(".lessonBox").css("display", "block");
    } else {
        $(e).children(".u-icon-caret-up").css("display", "none");
        $(e).children(".u-icon-caret-down").css("display", "block");
        $(e).next(".lessonBox").css("display", "none");
    }
} 

//添加章信息
function addTitle(e) {
    var content = '<div>' +
        '<div class="titleBox j-titleBox f-cb" onclick="titleClick(this)">' +
        '<div class="f-icon cpicon j-down f-fl u-icon-caret-up" style=""></div>' +
        '<div class="f-icon cpicon j-up f-fl u-icon-caret-down" style="display: none;"></div>' +
        '<input class="j-titleName name f-fl f-thide" id="" value="" placeholder="请输入章名" onclick="stopBubble()">' +
        '<div class="j-typebox f-cb f-fr" onclick="stopBubble()">' +
        '<div class="f-icon lsicon f-fl " title="编辑" style="display: none;" onclick="editInfo(this)">' +
        '<span class="u-icon-edit"></span>' +
        '</div>' +
        '<div class="f-icon lsicon f-fl" title="保存" onclick="storeChapterInfo(this)">' +
        '<span class="u-icon-check"></span>' +
        '</div>' +
        '<div class="f-icon lsicon f-fl " title="删除" onclick="delTitle(this)">' +
        '<span class="u-icon-close"></span>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '<div class="lessonBox j-lessoBox" style="">' +
        '<div>            ' +
        '<div class="u-learnLesson normal f-cb" style="padding: 0">' +
        '<div class="f-icon lesson-content-plus" style="width: 50px;height: 50px; margin: 0 -25px;   left:50%" onclick="addContent(this)">' +
        '<span class="u-icon-plus"' +
        'style=" font-size: 40px;margin: -20px -20px; position: absolute; top:50%; left:50%"></span>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>';
    $(e).before(content);
}
//添加节信息
function addContent(e) {
	var chapterId = $(e).parents(".lessonBox").prev().children("input.name").attr("id");
	if(chapterId==null||chapterId==""){
		alert("请先添加章信息！");
		return false;
	}
    var content = '<div class="u-learnLesson normal f-cb">' +
        ' <div class="j-icon icon f-pa icon-1"></div>' +
        ' <input class="j-name name f-fl f-thide" id="" value="" placeholder="请输入节名" onclick="stopBubble()">' +
        ' <div class="j-typebox f-cb f-fr" onclick="stopBubble()">' +
        '<div class="f-icon lsicon f-fl learned" title="教学视频上传">' +
        ' <span class="u-icon-video2" onclick="videoControl(this)"></span>' +
        ' </div>' +
        '  <div class="f-icon lsicon f-fl " title="教学文档上传（PDF）">' +
        '<span class="u-icon-doc" onclick="pdfControl(this)"></span>' +
        ' </div>' +
        '<div class="f-icon lsicon f-fl " title="编辑" style="display: none;" onclick="editInfo(this)">' +
        '<span class="u-icon-edit"></span>' +
        '</div>' +
        '<div class="f-icon lsicon f-fl" title="保存" onclick="storeSectionInfo(this)">' +
        '<span class="u-icon-check"></span>' +
        '</div>' +
        '<div class="f-icon lsicon f-fl " title="删除" onclick="delContent(this)">' +
        ' <span class="u-icon-close"></span>' +
        ' </div>' +
        ' </div>' +
        '</div>'+
        '<div class="u-learnLesson video f-cb" style="height:50px;padding: 0; display: none;">'+
        '<div class="f-pr f-fl" style="height: 100%;width: 40px;">'+
        '<span class="u-icon-video2"'+
    'style="font-size: 20px;margin: 0 -10px; top:15px; left:50%;position: relative; "></span>'+
        '</div>'+
        '<div class="f-pr f-fl u-source" style="border: 0" title="添加视频">'+
        '<div class="f-pa u-source-add" onclick="addVideo(this)">'+
        '<span class="f-pa u-icon-plus"></span>'+
        '</div>'+
        '<input type="file" multiple="multiple" style="width: 0px;height: 0px;display: none">'+
        '</div>'+
        '</div>'+
        '<div class="u-learnLesson pdf f-cb" style="height:50px;padding: 0; display: none;">'+
        '<div class="f-pr f-fl" style="height: 100%;width: 40px;">'+
        '<span class="u-icon-book"'+
    'style="font-size: 20px;margin: 0 -10px; top:15px; left:50%;position: relative; "></span>'+
        '</div>'+
        '<div class="f-pr f-fl u-source" style="border: 0" title="添加pdf">'+
        '<div class="f-pa u-source-add" onclick="addPdf(this)">'+
        '<span class="f-pa u-icon-plus"></span>'+
        '</div>'+
        '<input type="file" multiple="multiple" style="width: 0px;height: 0px;display: none">'+
        '</div>'+
        '</div>';
    $(e).parent(".u-learnLesson").before(content);
}
//显示章信息
function showChapters(){
	var courseId = getCookie("courseId");
	if(courseId == null || courseId == 'undefined'){
		var add='<div class="f-icon lesson-title-plus" style="width: 70px;height: 70px;" onclick="addTitle(this)">'+
				'<span class="u-icon-plus" style=" font-size: 60px;margin: -30px -30px; position: absolute; top:50%; left:50%"></span>'+
				'</div>';
		$(".m-learnChapterNormal").append(add);
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
					$.each(chapters, function(idx, chapter){
						 var titlebox = '<div>' +
					        '<div class="titleBox j-titleBox f-cb" id="'+chapter.chapterId+'" onclick="titleClick(this)">' +
					        '<div class="f-icon cpicon j-down f-fl u-icon-caret-up" style=""></div>' +
					        '<div class="f-icon cpicon j-up f-fl u-icon-caret-down" style="display: none;"></div>' +
					        '<input class="j-titleName name f-fl f-thide" disabled="disabled" id="'+chapter.chapterId+'" value="'+chapter.chapterName+'" placeholder="请输入章名" onclick="stopBubble()">' +
					        '<div class="j-typebox f-cb f-fr" onclick="stopBubble()">' +
					        '<div class="f-icon lsicon f-fl " title="编辑" onclick="editInfo(this)">' +
					        '<span class="u-icon-edit"></span>' +
					        '</div>' +
					        '<div class="f-icon lsicon f-fl" title="保存" style="display: none;" onclick="storeChapterInfo(this)">' +
					        '<span class="u-icon-check"></span>' +
					        '</div>' +
					        '<div class="f-icon lsicon f-fl " title="删除" onclick="delTitle(this)">' +
					        '<span class="u-icon-close"></span>' +
					        '</div>' +
					        '</div>' +
					        '</div>' +
					        '<div class="lessonBox j-lessoBox" style="">' +
					        '<div>            ' +
					        '<div class="u-learnLesson normal f-cb" style="padding: 0">' +
					        '<div class="f-icon lesson-content-plus" style="width: 50px;height: 50px; margin: 0 -25px;   left:50%" onclick="addContent(this)">' +
					        '<span class="u-icon-plus"' +
					        'style=" font-size: 40px;margin: -20px -20px; position: absolute; top:50%; left:50%"></span>' +
					        '</div>' +
					        '</div>' +
					        '</div>' +
					        '</div>';
						$(".m-learnChapterNormal").prepend(titlebox);
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
//显示节信息
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
				if(sections != null && sections != 'undefined' && sections != '' && sections.length > 0){
//					$(".m-learnChapterNormal").empty();
					var sectionshtml = '';
					$.each(sections, function(idx, section){
						var lessonbox = '<div class="u-learnLesson normal f-cb">' +
					        ' <div class="j-icon icon f-pa icon-1"></div>' +
					        ' <input class="j-name name f-fl f-thide" disabled="disabled" id="'+section.sectionid+'" value="'+section.sectionname+'" placeholder="请输入节名" onclick="stopBubble()">' +
					        ' <div class="j-typebox f-cb f-fr" onclick="stopBubble()">' +
					        '<div class="f-icon lsicon f-fl learned" title="教学视频上传">' +
					        ' <span class="u-icon-video2" onclick="videoControl(this)"></span>' +
					        ' </div>' +
					        '  <div class="f-icon lsicon f-fl " title="教学文档上传（PDF）">' +
					        '<span class="u-icon-doc" onclick="pdfControl(this)"></span>' +
					        ' </div>' +
					        '<div class="f-icon lsicon f-fl " title="编辑" onclick="editInfo(this)">' +
					        '<span class="u-icon-edit"></span>' +
					        '</div>' +
					        '<div class="f-icon lsicon f-fl" title="保存" style="display: none;" onclick="storeSectionInfo(this)">' +
					        '<span class="u-icon-check"></span>' +
					        '</div>' +
					        '<div class="f-icon lsicon f-fl " title="删除" onclick="delContent(this)">' +
					        ' <span class="u-icon-close"></span>' +
					        ' </div>' +
					        ' </div>' +
					        '</div>'+
					        '<div class="u-learnLesson video f-cb" style="height:50px;padding: 0; display: none;">'+
					        '<div class="f-pr f-fl" style="height: 100%;width: 40px;">'+
					        '<span class="u-icon-video2"'+
					    'style="font-size: 20px;margin: 0 -10px; top:15px; left:50%;position: relative; "></span>'+
					        '</div>'+
					        '<div class="f-pr f-fl u-source" style="border: 0" title="添加视频">'+
					        '<div class="f-pa u-source-add" onclick="addVideo(this)">'+
					        '<span class="f-pa u-icon-plus"></span>'+
					        '</div>'+
					        '<input type="file" multiple="multiple" style="width: 0px;height: 0px;display: none">'+
					        '</div>'+
					        '</div>'+
					        '<div class="u-learnLesson pdf f-cb" style="height:50px;padding: 0; display: none;">'+
					        '<div class="f-pr f-fl" style="height: 100%;width: 40px;">'+
					        '<span class="u-icon-book"'+
					    'style="font-size: 20px;margin: 0 -10px; top:15px; left:50%;position: relative; "></span>'+
					        '</div>'+
					        '<div class="f-pr f-fl u-source" style="border: 0" title="添加pdf">'+
					        '<div class="f-pa u-source-add" onclick="addPdf(this)">'+
					        '<span class="f-pa u-icon-plus"></span>'+
					        '</div>'+
					        '<input type="file" multiple="multiple" style="width: 0px;height: 0px;display: none">'+
					        '</div>'+
					        '</div>';						
						sectionshtml += lessonbox;
					});
					$(".titleBox#"+chapterId).next(".lessonBox").children().prepend(sectionshtml);
					$(".lessonBox").css("display","none");
				}else{
					console.log('第'+chapterId+'章没有小节');
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

//编辑章节信息
function editInfo(e) {
    $(e).parent().prev("input.name").removeAttr("disabled");
    $(e).css("display", "none");
    $(e).next("div").css("display", "block");
    $(e).parent().prev("input.name").focus();
}

//添加或者是修改章信息
function storeChapterInfo(e) {
    $(e).parent().prev("input.name").attr("disabled", "disabled");
    $(e).css("display", "none");
    $(e).prev("div").css("display", "block");
    
    var id = $(e).parent().prev("input.name").attr("id");
    var courseId = getCookie("courseId");
    var chapterContent=$(e).parent().prev("input").val();
    if(id==null || id=="") //如果ID不存在，则插入
	{
    	$.ajax({
        	type:"POST",
    		url:"/teacherCourse/AddChatper",
    		data:
    		{	courseId:courseId, 
    			courseName:chapterContent
    		},
    		datatype:"json",
    		success:function(msg){
    			if(msg.status=="OK"){
    				$(e).parent().prev("input.name").attr("id", msg.result.chapterId);
    				alert("添加成功！");
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
    		url:"/teacherCourse/UpdateChatper",
    		data:
    		{	chapterId:id, 
    			courseId:courseId, 
    			chapterName:chapterContent
    		},
    		datatype:"json",
    		success:function(msg){
    			if(msg.status=="OK"){
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

//删除章
function delTitle(e) {
    var status = confirm("是否确定删除该章所有信息？");
    if (status == true) {
    	var chapterId = $(e).parent().prev("input.name").attr("id");
    	var courseId = getCookie("courseId");
    	$.ajax({
        	type:"POST",
    		url:"/teacherCourse/DeleteChapter",
    		data:
    		{	chapterId:chapterId, 
    			courseId:courseId, 
    		},
    		datatype:"json",
    		success:function(msg){
    			if(msg.status=="OK"){
    				$(e).parents("div.titleBox").parent("div").remove();
    				alert("删除成功！");
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
//添加或者是修改节信息
function storeSectionInfo(e)
{
	    $(e).parent().prev("input.name").attr("disabled", "disabled");
	    $(e).css("display", "none");
	    $(e).prev("div").css("display", "block");
	    //需要章id和节的名字
	    var id = $(e).parent().prev("input.name").attr("id");  //当前节
	    var chapterId = $(e).parents("div.lessonBox").prev(".titleBox").children("input.name").attr("id");
	    var sectionName=$(e).parent().prev("input").val();
	    if(id==null || id=="") //如果ID不存在，则插入
		{
	    	$.ajax({
	        	type:"POST",
	    		url:"/teacherCourse/AddSection",
	    		data:
	    		{	chapterId:chapterId, 
	    			sectionName:sectionName,
	    		},
	    		datatype:"json",
	    		success:function(msg){
	    			if(msg.status=="OK"){
	    				$(e).parent().prev("input.name").attr("id", msg.result.sectionid);
	    				alert("添加成功！");
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
	    		url:"/teacherCourse/UpdateSection",
	    		data:
	    		{	sectionId:id, 
	    			sectionName:sectionName
	    		},
	    		datatype:"json",
	    		success:function(msg){
	    			if(msg.status=="OK"){
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

//删除节
function delContent(e) {
    var status = confirm("是否确定删除该节信息？");
    if (status == true) 
    {
    	var sectionId = $(e).parent().prev("input.name").attr("id");
    	if(sectionId == null || sectionId=="")
		{
    		$(e).parents("div.u-learnLesson").next(".video").remove();
    		$(e).parents("div.u-learnLesson").next(".pdf").remove();
    		$(e).parents("div.u-learnLesson").remove();
		}
    	else
		{
    		$.ajax({
            	type:"POST",
        		url:"/teacherCourse/DeleteSection",
        		data:
        		{	sectionId:sectionId, 
        		},
        		datatype:"json",
        		success:function(msg){
        			if(msg.status=="OK"){
        				$(e).parents("div.u-learnLesson").next(".video").remove();
        	    		$(e).parents("div.u-learnLesson").next(".pdf").remove();
        	    		$(e).parents("div.u-learnLesson").remove();
        				alert("删除成功！");
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
}


//阻止事件冒泡
function stopBubble(e) {
    window.event ? window.event.cancelBubble = true : e.stopPropagation();
}


//u-source的鼠标悬浮事件，未上传的文件悬浮时出现上传按钮，已上传的文件悬浮时出现close按钮
function uSHover(e) {
    if ($(e).hasClass("u-source-ok")) {
        $(e).children(".u-source-close").css("display", "block");
    } else {
        $(e).children(".u-source-upload").stop(false, true);
        $(e).children(".u-source-upload").slideDown(200);
    }
}

//u-source的鼠标离开事件，未上传的文件鼠标离开时上传按钮消失，已上传的文件鼠标离开时close按钮消失
function uSBlur(e) {
    if ($(e).hasClass("u-source-ok")) {
        $(e).children(".u-source-close").css("display", "none");
    } else {
        $(e).children(".u-source-upload").stop(false, true);
        $(e).children(".u-source-upload").slideUp(200);
    }
}

//video上传管理页面展示
function videoControl(e) {
    if ($(e).parent(".lsicon").hasClass("show")) {
        $(e).parents(".u-learnLesson").next(".video").css("display", "none");
        $(e).parent(".lsicon").removeClass("show");
    } else {
        $(e).parents(".u-learnLesson").next(".video").css("display", "block");
        $(e).parent(".lsicon").addClass("show");
        ShowVideo(e);
    }
}

//pdf上传管理页面展示
function pdfControl(e) {
    if ($(e).parent(".lsicon").hasClass("show")) {
        $(e).parents(".u-learnLesson").next().next(".pdf").css("display", "none");
        $(e).parent(".lsicon").removeClass("show");
    } else {
        $(e).parents(".u-learnLesson").next().next(".pdf").css("display", "block");
        $(e).parent(".lsicon").addClass("show");
        ShowPDF(e);
    }
}

function ShowPDF(e)
{
	$(e).parents(".u-learnLesson").nextAll("div.pdf").children(".u-source-ok").remove();
    var courseId = getCookie("courseId");
    var chapterId = $(e).parents(".lessonBox").prev().children("input.name").attr("id");
	var sectionId = $(e).parents(".u-learnLesson").children("input.name").attr("id");
	$.ajax({
    	type:"POST",
		url:"/teacherCourse/showPDF",
		data:
		{	courseId:courseId,
			chapterId:chapterId,
			sectionId:sectionId
		},
		datatype:"json",
		success:function(msg){
			if(msg.status=="OK"){
				var files = msg.result;
				if(files.length == 0)
				{
					return;
				}
				$.each(files, function(idx, file){
					var content = '<div class="f-pr f-fl u-source u-source-ok" id = "'+file.fileId+'"title="' + file.fileName + '" onmousemove="uSHover(this)"' +
	                'onmouseleave="uSBlur(this)">' +
	                '<div class="f-pa u-source-upload" style="display:none;" data-path="" onclick="uploadVideo(this)">' +
	                '<span class="icon-upload-alt"></span>' +
	                '</div>' +
	                '<div class="f-pa u-source-close" style="display:none;" onclick="delPdf(this)">' +
	                '<span class="u-icon-close"></span>' +
	                '</div>' +
	                '</div>';
					 $(e).parents(".u-learnLesson").next().next().children(':last').before(content);
				});
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

function ShowVideo(e)
{
	$(e).parents(".u-learnLesson").nextAll("div.video").children(".u-source-ok").remove();
    var courseId = getCookie("courseId");
    var chapterId = $(e).parents(".lessonBox").prev().children("input.name").attr("id");
	var sectionId = $(e).parents(".u-learnLesson").children("input.name").attr("id");
	$.ajax({
    	type:"POST",
		url:"/teacherCourse/showViedo",
		data:
		{	courseId:courseId,
			chapterId:chapterId,
			sectionId:sectionId
		},
		datatype:"json",
		success:function(msg){
			if(msg.status=="OK"){
				var files = msg.result;
				if(files.length == 0)
				{
					return;
				}
				$.each(files, function(idx, file){
					var content = '<div class="f-pr f-fl u-source u-source-ok" id="'+file.fileId+'"title="' + file.fileName + '" onmousemove="uSHover(this)"' +
	                'onmouseleave="uSBlur(this)">' +
	                '<div class="f-pa u-source-upload" style="display:none;" data-path="" onclick="uploadVideo(this)">' +
	                '<span class="icon-upload-alt"></span>' +
	                '</div>' +
	                '<div class="f-pa u-source-close" style="display:none;" onclick="delVideo(this)">' +
	                '<span class="u-icon-close"></span>' +
	                '</div>' +
	                '</div>';
					 $(e).parents(".u-learnLesson").next().children(':last').before(content);
				});
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
                var content = '<div class="f-pr f-fl u-source" title="' + file.name + '" onmousemove="uSHover(this)"' +
                    'onmouseleave="uSBlur(this)">' +
                    '<div class="f-pa u-source-upload" data-path="'+file+'" onclick="uploadVideo(this)">' +
                    '<span class="icon-upload-alt"></span>' +
                    '</div>' +
                    '<div class="f-pa u-source-close" style="display:none;" onclick="delVideo(this)">' +
                    '<span class="u-icon-close"></span>' +
                    '</div>' +
                    '</div>';
                $(e).parents(".u-source").before(content);
                uploadVideo1($(e).parents(".u-source").prev(".u-source"),file);
            }
        }
    });
}

//视频异步上传
function uploadVideo1(e,file) {
    var formData = new FormData();
    formData.append("formData" , file);
    var courseId = getCookie("courseId");
    var chapterId = $(e).parents(".lessonBox").prev().children("input.name").attr("id");
    var sectionId = $(e).parents(".u-learnLesson").prev().children("input").attr("id");
    formData.append("chapterId" , chapterId);
    formData.append("sectionId" , sectionId);
    formData.append("courseId" , courseId);
    $.ajax({
        type: "POST",
        url: "/teacherCourse/UploadVideo",
        dataType:"json",
        processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        enctype:"multipart/form-data",
        data: formData,
        success : function(msg) {
            if (msg.status == "OK") {
                e.addClass("u-source-ok");
                e.children(".u-source-upload").css("display","none");
                alert(msg.result);
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
                var content = '<div class="f-pr f-fl u-source" title="' + file.name + '" onmousemove="uSHover(this)"' +
                    'onmouseleave="uSBlur(this)">' +
                    '<div class="f-pa u-source-upload" data-path="'+file+'" onclick="uploadPdf(this)">' +
                    '<span class="icon-upload-alt"></span>' +
                    '</div>' +
                    '<div class="f-pa u-source-close" style="display:none;" onclick="delPdf(this)">' +
                    '<span class="u-icon-close"></span>' +
                    '</div>' +
                    '</div>';
                $(e).parents(".u-source").before(content);
                uploadPdf1($(e).parents(".u-source").prev(".u-source"),file);
            }
        }
    });
}

//pdf文档异步上传
function uploadPdf1(e,file) {
    var formData = new FormData();
    formData.append("formData" , file);
	var courseId = getCookie("courseId");
    var chapterId = $(e).parents(".lessonBox").prev().children("input.name").attr("id");
    var sectionId = $(e).parents(".u-learnLesson").prev().prev().children("input").attr("id");
    formData.append("chapterId" , chapterId);
    formData.append("sectionId" , sectionId);
    formData.append("courseId" , courseId);
    $.ajax({
        type: "POST",
        url: "/teacherCourse/UploadPDF",       
        dataType:"json",
        processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        enctype:"multipart/form-data",
        data: formData,
        success : function(msg) {
            if (msg.status == "OK") {
                e.addClass("u-source-ok");
                e.children(".u-source-upload").css("display","none");
                alert(msg.result);
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
    	var courseId = getCookie("courseId");
        var sectionId = $(e).parents(".u-learnLesson").prev().children("input").attr("id");
        var videoId = $(e).parents(".u-source-ok").attr("id");
        $.ajax({
            type: "POST",
            url: "/teacherCourse/DeleteVideo",       
            dataType:"json",
            data: {
            	courseId:courseId,
            	sectionId:sectionId,
            	videoId:videoId,
            },
            success : function(msg) {
                if (msg.status == "OK") {
                	$(e).parent(".u-source").remove();
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
    	console.log("111111111");
    	var courseId = getCookie("courseId");
        var sectionId = $(e).parents(".u-learnLesson").prev().prev().children("input").attr("id");
        var pdfId = $(e).parents(".u-source-ok").attr("id");
        console.log(sectionId);
        console.log(pdfId);
        $.ajax({
            type: "POST",
            url: "/teacherCourse/DeletePDF",       
            dataType:"json",
            data: {
            	courseId:courseId,
            	sectionId:sectionId,
            	pdfId:pdfId,
            },
            success : function(msg) {
                if (msg.status == "OK") {
                	console.log("sss");
                	$(e).parent(".u-source").remove();
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
