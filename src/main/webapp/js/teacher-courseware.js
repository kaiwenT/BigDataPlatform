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

//添加节信息
function addContent(e) {
    var content = '<div class="u-learnLesson normal f-cb">' +
        ' <div class="j-icon icon f-pa icon-1"></div>' +
        ' <input class="j-name name f-fl f-thide" value="" placeholder="请输入节名" onclick="stopBubble()">' +
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
        '<div class="f-icon lsicon f-fl" title="保存" onclick="storeInfo(this)">' +
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
        '<div class="f-pr f-fl u-source" style="border: 0" title="添加视屏">'+
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
        '</div>'
    $(e).parent(".u-learnLesson").before(content);
}
//添加章信息
function addTitle(e) {
    var content = '<div>' +
        '<div class="titleBox j-titleBox f-cb" onclick="titleClick(this)">' +
        '<div class="f-icon cpicon j-down f-fl u-icon-caret-up" style=""></div>' +
        '<div class="f-icon cpicon j-up f-fl u-icon-caret-down" style="display: none;"></div>' +
        '<input class="j-titleName name f-fl f-thide" value="" placeholder="请输入章名" onclick="stopBubble()">' +
        '<div class="j-typebox f-cb f-fr" onclick="stopBubble()">' +
        '<div class="f-icon lsicon f-fl " title="编辑" style="display: none;" onclick="editInfo(this)">' +
        '<span class="u-icon-edit"></span>' +
        '</div>' +
        '<div class="f-icon lsicon f-fl" title="保存" onclick="storeInfo(this)">' +
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


//编辑章节信息
function editInfo(e) {
    $(e).parent().prev("input.name").removeAttr("disabled");
    $(e).css("display", "none");
    $(e).next("div").css("display", "block");
    $(e).parent().prev("input.name").focus();
}

//保存章节信息
function storeInfo(e) {
    $(e).parent().prev("input.name").attr("disabled", "disabled");
    $(e).css("display", "none");
    $(e).prev("div").css("display", "block");
    //上传数据，更新章节信息
    var courseId = getCookie("courseId");
    var chapterContent = $("#chapterContent").val();
    alert(chapterContent);
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

//删除章
function delTitle(e) {
    var status = confirm("是否确定删除该章所有信息？");
    if (status == true) {
        $(e).parents("div.titleBox").parent("div").remove();
    }
}
//删除节
function delContent(e) {
    var status = confirm("是否确定删除该节信息？");
    if (status == true) {
        $(e).parents("div.u-learnLesson").remove();
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
        $(e).parents(".u-learnLesson").nextAll(".video").css("display", "none");
        $(e).parent(".lsicon").removeClass("show");
    } else {
        $(e).parents(".u-learnLesson").nextAll(".video").css("display", "block");
        $(e).parent(".lsicon").addClass("show");
    }
}

//pdf上传管理页面展示
function pdfControl(e) {
    if ($(e).parent(".lsicon").hasClass("show")) {
        $(e).parents(".u-learnLesson").nextAll(".pdf").css("display", "none");
        $(e).parent(".lsicon").removeClass("show");
    } else {
        $(e).parents(".u-learnLesson").nextAll(".pdf").css("display", "block");
        $(e).parent(".lsicon").addClass("show");
    }
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
    formData.append("file" , file);
    $.ajax({
        type: "POST",
        url: "#",
        data: formData ,　　//这里上传的数据使用了formData 对象
        processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        success : function(msg) {
            if (msg.status == "OK") {
                e.addClass("u-source-ok");
                e.children(".u-source-upload").css("display","none");
            } else {

            }
        },
        error : function() {
            alert("上传文件失败请重新上传！");
        }
    })
}

//在本地添加视频文件准备上传
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
                uploadVideo1($(e).parents(".u-source").prev(".u-source"),file);
            }
        }
    });
}

//视频异步上传
function uploadPdf1(e,file) {
    var formData = new FormData();
    formData.append("file" , file);
    $.ajax({
        type: "POST",
        url: "#",
        data: formData ,　　//这里上传的数据使用了formData 对象
        processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        success : function(msg) {
            if (msg.status == "OK") {
                e.addClass("u-source-ok");
                e.children(".u-source-upload").css("display","none");
            } else {

            }
        },
        error : function() {
            alert("上传文件失败请重新上传！");
        }
    })
}

//点击上传按钮上传video
function uploadVideo(e) {

}

//点击上传按钮上传pdf
function uploadPdf(e) {

}

//video删除
function delVideo(e) {
    var flag = confirm("是否删除该视频？");
    if (flag) {
        $(e).parent(".u-source").remove();
        //删除该Video
    }
}

//pdf删除
function delPdf(e) {
    var flag = confirm("是否删除该Pdf？");
    if (flag) {
        $(e).parent(".u-source").remove();
        //删除该Pdf
    }
}
