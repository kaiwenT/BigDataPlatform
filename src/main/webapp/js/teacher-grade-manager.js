/**
 * Created by Jack on 2017/10/25.
 */
$("select.grade-show-type").change(function () {
    var type = $(this).val();
    switch (type){
        case "1": {
            regularGradeShow();
            break;
        }
        case "2": {
            expGradeShow();
            break;
        }
        case "3": {
            totalGradeShow();
            break;
        }
        default :break;
    }
})
//平时成绩加载
function regularGradeShow() {
    $(".grade-body").empty();
    $(".grade-body").css("overflow","hidden");
    var courseId = getCookie("courseId");
    //根据查询到的平时作业数量生成
    $.ajax({
    	type:"POST",
		url:"/StudentScore/ShowUsualScore",
		data:
		{	courseId:courseId, 
		},
		datatype:"json",
		success:function(msg){
			 var regularWork="";
			 var studentGrade="";
			if(msg.status=="OK"){
				var list = msg.result;
				//转化为int
				console.log(msg.result);
				var num = parseInt(list[0]["tasknum"]);
				for(i =0; i <num;i++){
					regularWork +="<th>平时作业"+(i+1)+"</th>";
				}
				console.log(list);
				$.each(list,function(idx,map){
					studentGrade +="<tr><td>"+map["studentId"]+"</td>";
					studentGrade +="<td>"+map["studentname"]+"</td>";
					studentGrade +="<td>"+map["attendenceScore"]+"</td>";
					for(var key in map){
						if(key != "tasknum" && key != "studentname" && key != "studentId" && key != "attendenceScore" && key != "finalUsualScore")
						studentGrade +="<td>"+map[key]+"</td>";
					}
					studentGrade +="<td>"+map["finalUsualScore"]+"</td></tr>";
				})
				
				var content='<table >'+
		        '<tr>'+
		        '<th width="125px;">学号</th>'+
		        '<th width="90px">姓名</th>'+
		        '<th>考勤成绩</th>'+
		        regularWork+
		        '<th>平时成绩（总）</th>'+
		    '</tr>'+
		        studentGrade+
		    '</table>';
		    $(".grade-body").append(content);
			}else{
				alert(msg.result);
			}
    	},
    	error:function(msg){
			alert(msg.result);
		},
    })
}

//实验成绩加载
function expGradeShow() {
    $(".grade-body").empty();
    $(".grade-body").css("overflow-x","scroll");
    var courseId = getCookie("courseId");
    $.ajax({
    	type:"POST",
		url:"/StudentScore/ShowExpScore",
		data:
		{	courseId:courseId, 
		},
		datatype:"json",
		success:function(msg){
			 var regularWork="";
			 var studentGrade="";
			 if(msg.status=="OK"){
				var list = msg.result;
				var num = list[0].explist.length;
				for(i =0; i < num; i++){
					regularWork +="<th>"+list[0].explist[i].expName+"(数据)</th>";
					regularWork +="<th>"+list[0].explist[i].expName+"(报告)</th>";
					regularWork +="<th>"+list[0].explist[i].expName+"(总)</th>";
				}
				$.each(list,function(idx,expQuery){
					console.log(expQuery);
					studentGrade +="<tr><td>"+expQuery.studentId+"</td>";
					studentGrade +="<td>"+expQuery.studentName+"</td>";
					for(i =0; i < num; i++)
					{
						studentGrade +="<td>"+expQuery.explist[i].resultsScore+"</td>";
						studentGrade +="<td>"+expQuery.explist[i].reportScore+"</td>";
						studentGrade +="<td>"+expQuery.explist[i].finalScore+"</td>";
						
					}
					studentGrade +="<td>"+expQuery.finalScore+"</td></tr>";
				})
				var content='<table >'+
		        '<tr>'+
		        '<th width="125px;">学号</th>'+
		        '<th width="90px">姓名</th>'+
		        regularWork+
		        '<th>实验成绩（总）</th>'+
  		        '</tr>'+
		        studentGrade+
		    '</table>';
		    $(".grade-body").append(content);
			}else{
				alert(msg.result);
			}
    	},
    	error:function(msg){
			alert(msg.result);
		},
    })
}


//总成绩加载
function totalGradeShow() {
    $(".grade-body").empty();
    $(".grade-body").css("overflow","hidden");
    var courseId = getCookie("courseId");
    //根据查询到的平时作业数量生成
    $.ajax({
    	type:"POST",
		url:"/StudentScore/ShowfinalScore",
		data:
		{	courseId:courseId, 
		},
		datatype:"json",
		success:function(msg){
			if(msg.status=="OK"){
				var studentGrade="";
				var list = msg.result;
				$.each(list,function(idx,map){
					studentGrade +="<tr><td>"+map["studentId"]+"</td>";
					studentGrade +="<td>"+map["studentname"]+"</td>";
					studentGrade +="<td>"+map["usualGrades"]+"</td>";
					studentGrade +="<td>"+map["exp_finalScore"]+"</td>";
					studentGrade +="<td>"+map["test_results"]+"</td>";
					studentGrade +="<td>"+map["finalScore"]+"</td></tr>";
				})
				var content='<table >'+
		        '<tr>'+
		        '<th width="125px;">学号</th>'+
		        '<th width="90px">姓名</th>'+
		        '<th>平时成绩</th>'+
		        '<th>实验成绩</th>'+
		        '<th>最终考试成绩</th>'+
		        '<th>总成绩</th>'+
		        '</tr>'+
		        studentGrade+
		        '</table>';
		    $(".grade-body").append(content);
			}else{
				alert(msg.result);
			}
    	},
		error:function(msg){
			alert(msg.result);
		},
    })
}
//发布成绩
function publish(){
    var courseId = getCookie("courseId");
    //根据查询到的平时作业数量生成
    $.ajax({
    	type:"POST",
		url:"/StudentScore/CalculateScore",
		data:
		{	courseId:courseId, 
		},
		datatype:"json",
		success:function(msg){
			if(msg.status=="OK"){
				alert(msg.result);
			}else{
				alert(msg.result);
			}
    	},
		error:function(msg){
			alert(msg.result);
		},
    })
}

//平时成绩下载
function download(){
	$(function() {
		var courseId = getCookie("courseId");
		var form = $('<form method="POST" action="/StudentScore/DownloadScore">');
		form.append($('<input type="hidden" name="courseId" value="' + courseId + '"/>'));
		$('body').append(form);
		form.submit(); // 自动提交
	});
}


function closeBox() {
    $(".m-mask").css("display","none");
}
//提交平时考勤成绩
function submit(e) {
    var file = e.files[0];
    var tempStr = file.name.split(".");
    var fileType = tempStr[tempStr.length-1];
    if(fileType.search(/xls|xlsx/i)==-1){
        alert("不是excel文件！")
        return false;
    }
    var formData = new FormData();
    formData.append("formData" , file);
	var courseId = getCookie("courseId");
    formData.append("courseId" , courseId);
    $.ajax({
        type: "POST",
        url: "/teacher/importUsualAndTestScore",       
        dataType:"json",
        processData : false,//必须false才会自动加上正确的Content-Type
        contentType : false ,
        enctype:"multipart/form-data",
        data: formData,
        success : function(msg) {
            if (msg.status == "OK") {
            	$(".m-mask").css("display","none");
                alert("上传成功！");
            } else {
            	 alert(msg.result);
            }
        },
        error : function() {
            alert("上传文件失败请重新上传！");
        }
    })
    console.log(file.name);
}


function importFile() {
    $(".m-mask").css("display","block");
}

$(".grade-body").hover(function(event) {	
	var gdWidth = $(".grade-body").width();
	var tabWidth = $(".grade-body").find("table").width();
	var max = tabWidth-gdWidth;
	$(".grade-body").bind('mousewheel',function(event, delta){
		var length = $(".grade-body").scrollLeft();
		console.log("scroll")
		console.log(length);
		length -= delta*(70);
		console.log(delta);
		console.log(length);
		console.log("scroll----------")
		if(length<0){
			length = 0;
		}else if(length >max){
			length = max;
		}		
		$(".grade-body").stop().animate({scrollLeft:length},100);
	});
})

