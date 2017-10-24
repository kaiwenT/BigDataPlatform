/**
 * Created by Jack on 2017/10/24.
 */
//监听输入框  确保信息均为0~100的数字
$("input").keyup(function () {
    //           console.log("turnPageNum keyup")
    $(this).val($(this).val().replace(/[^0-9]/g, ''));
    if ($(this).val() > 100) {
        $(this).val(100);
    }
}).bind("paste", function () {  //CTR+V事件处理
    $(this).val($(this).val().replace(/[^0-9]/g, ''));
    if ($(this).val() > pageCount) {
        $(this).val(100);
    }
})

//保存成绩占比情况
function submit() {
    var regular_grade = 0;
    var exp_grade = 0;
    var final_exam_grade = 0;
    var check_grade = 0;
    var regular_work = 0;
    var exp_report = 0;
    var exp_result = 0;
    if ($(".regular-grade").val() != "") {
        regular_grade = parseInt($(".regular-grade").val());
    }
    if ($(".exp-grade").val() != "") {
        exp_grade = parseInt($(".exp-grade").val());
    }
    if ($(".final-exam-grade").val() != "") {
        final_exam_grade = parseInt($(".final-exam-grade").val());
    }
    if ($(".check-grade").val() != "") {
        check_grade = parseInt($(".check-grade").val());
    }
    if ($(".regular-work").val() != "") {
        regular_work = parseInt($(".regular-work").val());
    }
    if ($(".exp-report").val() != "") {
        exp_report = parseInt($(".exp-report").val());
    }
    if ($(".exp-result").val() != "") {
        exp_result = parseInt($(".exp-result").val());
    }
    if (regular_grade + exp_grade + final_exam_grade != 100) {
        alert("最终成绩的组成部分占比和不为100！");
        return false;
    }
    if (check_grade + regular_work != 100) {
        alert("平时成绩的组成部分占比和不为100！");
        return false;
    }
    if (exp_report + exp_result != 100) {
        alert("实验成绩的组成部分占比和不为100！");
        return false;
    }

    //ajax提交
}