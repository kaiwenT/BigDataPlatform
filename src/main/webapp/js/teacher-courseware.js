/**
 * Created by Jack on 2017/10/16.
 */
function addContent(e) {
    var content = '<div class="u-learnLesson normal f-cb">'+
        ' <div class="j-icon icon f-pa icon-1"></div>'+
        ' <input class="j-name name f-fl f-thide" value="" placeholder="请输入节名">'+
        ' <div class="j-typebox f-cb f-fr">'+
        ' <div>'+
        '<div class="f-icon lsicon f-fl learned" title="教学视频上传">'+
        ' <span class="u-icon-video2"></span>'+
        ' <input type="file" class="upload">'+
        ' </div>'+
        '  <div class="f-icon lsicon f-fl " title="教学文档上传（PDF）">'+
        '<span class="u-icon-doc"></span>'+
        ' <input type="file" class="upload">'+
        ' </div>'+
        '<div class="f-icon lsicon f-fl " title="删除">'+
        ' <span class="u-icon-close"></span>'+
        ' </div>'+
        '</div>'+
        ' </div>'+
        '</div>'
    $(e).parent(".u-learnLesson").before(content);
}
function addTitle(e) {
    var content = '<div>'+
        '<div class="titleBox j-titleBox f-cb">'+
        '<div class="f-icon cpicon j-down f-fl u-icon-caret-up" style=""></div>'+
        '<div class="f-icon cpicon j-up f-fl u-icon-caret-down" style="display: none;"></div>'+
        '<input class="j-titleName name f-fl f-thide" value="" placeholder="请输入章名">'+
        '<div class="j-typebox f-cb f-fr">'+
        '<div class="f-icon lsicon f-fl " title="删除">'+
        '<span class="u-icon-close"></span>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '<div class="lessonBox j-lessoBox" style="">'+
        '<div>            '+
        '<div class="u-learnLesson normal f-cb" style="padding: 0">'+
        '<div class="f-icon lesson-content-plus" style="width: 50px;height: 50px; margin: 0 -25px;   left:50%" onclick="addContent(this)">'+
        '<span class="u-icon-plus"'+
        'style=" font-size: 40px;margin: -20px -20px; position: absolute; top:50%; left:50%"></span>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>';
    $(e).before(content);
}