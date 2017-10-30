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
//ajax
    //根据查询到的平时作业数量生成
    var regularWork = '<th>平时作业1</th>'+
        '<th>平时作业2</th>'+
        '<th>平时作业3</th>';
    //由查询到的内容生成  <tr><td><td></tr>
    var studentGrade='';
    //最后的表格
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
}
//实验成绩加载
function expGradeShow() {
    $(".grade-body").empty();
    $(".grade-body").css("overflow-x","scroll");
    //ajax
    //根据查询到的平时作业数量生成
    var regularWork = '<th>实验报告</th>'+
        '<th>实验结果</th>'+
        '<th>实验成绩</th>';
    //由查询到的内容生成  <tr><td><td></tr>
    var studentGrade='';
    //最后的表格
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
}
//总成绩加载
function totalGradeShow() {
    $(".grade-body").empty();
    $(".grade-body").css("overflow","hidden");
    //ajax
    //由查询到的内容生成  <tr><td><td></tr>
    var studentGrade='';
    //最后的表格
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
}

function closeBox() {
    $(".m-mask").css("display","none");
}
//提交平时考勤成绩
$(".submit-exp-result").onchange(function () {
    //获取文件
    var file = $(".submit-exp-result")[0].files[0];
})

function importFile() {
    $(".m-mask").css("display","block");
}