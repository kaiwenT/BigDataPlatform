/**
 * Created by Jack on 2017/10/18.
 */
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

//添加实验信息
function addTitle(e) {
    var content = '<div>'+
        '<div class="titleBox j-titleBox f-cb" onclick="titleClick(this)">'+
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
        '<textarea class="source-info" placeholder="请输入实验提交要求"></textarea>'+
        '</div>'+
        '</div>'+
        '<div class="expBox" style="">'+
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
        '<div class="expBox" style="">'+
        '<div class="exp-source exp-pdf f-pr" style="">'+
        '<div class="f-pr f-fl source-sign">'+
        '<span class="icon-book"'+
    'style="font-size: 20px;margin: -10px -10px; top:50px; left:50%;position: relative; "></span>'+
        '</div>'+
        '<div class="source-box">  '+
        '<div class="f-pr f-fl source-pdf" style="border: 1px" title="添加实验文档">'+
        '<div class="f-pa source-video-add" onclick="addPdf(this)">'+
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

//提交章信息（包含节信息）
function submitLesson(e) {

}

//编辑章节信息
function editInfo(e) {
    $(e).parent().prevAll("input.name").removeAttr("disabled");
    $(e).css("display", "none");
    $(e).next("div").css("display", "block");
    $(e).parent().prevAll("input.name").focus();
    $(e).parent().prevAll("input#end-time").attr("onclick","showTime(this)");
}

function storeInfo(e) {
    $(e).parent().prevAll("input.name").attr("disabled", "disabled");
    $(e).parent().prevAll("input#end-time").attr("onclick","stopBubble()");
    $("#jedatebox").css("display","none");
    $(e).css("display", "none");
    $(e).prev("div").css("display", "block");
    //上传数据，更新章节信息

}

//删除章
function delTitle(e) {
    var status = confirm("是否确定删除该章所有信息？");
    if (status == true) {
        $(e).parents("div.titleBox").parent("div").remove();
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
        var date = new Date();
        console.log(date.getSeconds());
    },5000);
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
                e.addClass("source-ok");
                e.children(".u-source-upload").css("display","none");
            } else {

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
                e.addClass("source-ok");
                e.children(".u-source-upload").css("display","none");
            } else {

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
