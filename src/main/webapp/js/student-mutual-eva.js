//文件存放路径
var path = ip+'reportSubmit/';

// student-mutual-eva页面显示实验的标题、文件标题
function showExp() {
	var expId = getCookie("expId");

	if (expId == null || expId == 'undefined') {
		return;
	}
	$
			.ajax({
				type : "POST",
				url : "/experiment/getExperimentById",
				dataType : "json",
				data : {
					experimentId : expId
				},
				success : function(msg) {
					if (msg.status == "OK") {
						var res = msg.result;

						if (res != 'undefined' && res != null) {
							$(".u-learn-moduletitle").empty();
							var bread = '<div class="j-breadcb f-fl"><div class="u-learnBCUI f-cb">'
									+ '<a href="javascript:;" class="f-fl f-fc3 f-f0 link" onclick="baseAjax('
									+ "'student-experiment'"
									+ ')">实验</a>'
									+ '<span class="f-icon f-fl icon u-icon-caret-right2"></span>'
									+ '<div class="f-fl j-exp"><div class="u-select">'
									+ '<div class="up j-up f-thide exp-up" id="'
									+ expId
									+ '">'
									+ res.experimentName
									+ '</div>'
									+ '<div class="down f-bg j-list exp-down" style="display: none;"></div></div></div>'
									+ '<span class="f-icon f-fl icon u-icon-caret-right2"></span></div></div>';
							$(".u-learn-moduletitle").append(bread);

						} else {

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

// 显示实验的文件
function showReports() {
	var expid = getCookie("expId");
	if (expid == null || expid == 'undefined') {
		return;
	}
	$
			.ajax({
				type : "POST",
				url : "/studentexp/getMutualEvalFiles",
				dataType : "json",
				data : {
					experimentId : expid
				},
				success : function(msg) {
					if (msg.status == "OK") {
						var files = msg.result;

						if (files != 'undefined' && files != null
								&& files.length > 0) {

							$(".file-down").empty();

							$
									.each(
											files,
											function(idx, file) {
												if (idx == 0) {
													var bread = '<div class="f-fl j-lesson"><div class="u-select">'
															+ '<div class="up j-up f-thide file-up" onclick="fileupClick(this)" id="'
															+ file
															+ '">实验报告1</div>'
															+ '<div class="down f-bg j-list file-down" style="display: none;"></div></div></div>'
															+ '<div class="f-fr">评分：<input type="text" class="form-control grade" onkeyup="gradeListenner(this)" style="width:50px;display:inline;">'
															+ '<button class="u-btn u-btn-primary"  id="'
															+ file
															+ '" onclick="submitClick(this)">提交</button></div>';
													$(".u-learnBCUI").append(bread);
													$(".j-unitctBox").attr("id", file);
													
														$(".unitctBox").empty();
														$(".unitctBox")
																.append(
																		"<a class='media'></a>");
														$(".media").attr("href",path
																				+ expid
																				+ "/"
																				+ file
																				+ ".pdf");
														$('a.media').media({
															width : 986,
															height : 800
														});
													
												}
												var list = '<div class="f-thide list" onclick="filedownClick(this)" title="实验报告'
														+ (idx + 1)
														+ '"'
														+ 'id="'
														+ file
														+ '">实验报告'
														+ (idx + 1)
														+ '</div>';
												$(".file-down").append(list);

											});
							$(".file-down").css("display", "none");

						} else {
							$(".u-learnBCUI").append('<div class="f-fr">互评已完成</div>');
							$(".file-down").css("display", "none");
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


// 文件标题栏点击事件
function fileupClick(e) {
	var expid = $(".exp-up").attr("id");

	if ($(e).next(".file-down").css("display") == "none") {
		// showReports(expid);
		$(e).next(".file-down").css("display", "block");
	} else {
		$(e).next(".file-down").css("display", "none");
	}

}

// 文件下拉列表点击事件
function filedownClick(e) {
	var fileId = $(e).attr("id");
	var name = $(e).text();
	var expid = getCookie("expId");
	$(e).parent(".file-up").attr("id", fileId);
	$(e).parent(".file-up").attr("title", name);
	$(e).parent(".file-up").val(name);
	$(".j-unitctBox").attr("id", fileId);
	console.log(fileId + name + expid)
	if (fileId != "undefined") {
		$(".media").attr("href", path + expid + "/" + fileId + ".pdf");
	}
	$(e).parent(".file-down").css("display", "none");
}

function gradeListenner(e) {
	console.log("keyup")
	$(e).val($(e).val().replace(/[^0-9]/g, ''));
	if ($(e).val() > 100) {
		$(e).val(100);
	}
	$(e).bind("paste", function() { // CTR+V事件处理
		console.log("paste")
		$(this).val($(this).val().replace(/[^0-9]/g, ''));
		if ($(this).val() > pageCount) {
			$(this).val(100);
		}
	})
}

//提交按钮点击事件
function submitClick(e) {
	var fileId = $(e).attr("id");
	var score = $(".grade").val();
	var expid = $(".exp-up").attr("id");
	$.ajax({
		type : "POST",
		url : "/studentexp/setEvalScore",
		dataType : "json",
		data : {
			experimentId : expid,
			studentId : fileId,
			score : score
		},
		success : function(msg) {
			if (msg.status == "OK") {
				showExp();
				showReports();
			} else {
				alert(msg.result);
			}
		},
		error : function(msg) {
			error(msg);
		}
	})
}