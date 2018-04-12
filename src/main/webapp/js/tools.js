/**
 * 工具包
 */
//文件服务器ip
var ip = 'http://211.69.197.168:8081/bigdataplatform/'

// 日期对象转换为年月日格式
function dateFormat(jsondate) {
	var date = new Date(jsondate.time);
    return date.getFullYear()+"年"+(1 + date.getMonth())+"月"+date.getDate()+"日";
    
}
var _complete = function(n){
	return (n>9) ? n : '0' + n;
}
// 日期对象转换为yyyy-MM-dd HH:mm:ss格式
function dateFormat1(jsondate) {
	var d = new Date(jsondate.time);
	
	 var year = d.getFullYear();
	 var month = _complete(d.getMonth()+1);
	 var day = _complete(d.getDate());
	 var hours = _complete(d.getHours());
	 var minutes = _complete(d.getMinutes());
	 var second = _complete(d.getSeconds());
	 var result = 'yyyy-MM-dd HH:mm:ss';
	 result = result.replace('yyyy', year);
	 result = result.replace('MM', month);
	 result = result.replace('dd', day);
	 result = result.replace('HH', hours);
	 result = result.replace('mm', minutes);
	 result = result.replace('ss', second);
	 return result;

}
	
/**
 * 存cookie方法
 */
function setCookie(key, value) {
    var Days = 1; // 此 cookie 将被保存 1 天
    var exp　= new Date();
    exp.setTime(exp.getTime() +Days*24*60*60*1000);
    document.cookie = key +"="+ escape (value) + ";expires=" + exp.toGMTString();
}
/**
 * 取cookie方法
 */
function getCookie(key) {
// console.log(document.cookie);
    var arr =document.cookie.match(new RegExp("(^|)"+key+"=([^;]*)(;|$)"));
    if(arr !=null) 
        return unescape(arr[2]); 
    return null;
}

// ajax请求失败时，提示错误信息
function showErrorMsg(msg){
	alert(eval('(' + msg.responseText + ')').result);
}
// ajax请求失败时，提示错误信息
function error(msg){
	alert(eval('(' + msg.responseText + ')').result);
}