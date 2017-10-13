/**
 * 工具包
 */
//日期对象转换为年月日格式
function dateFormat(jsondate) {
	var date = new Date(jsondate.time);
    return date.getFullYear()+"年"+(1 + date.getMonth())+"月"+date.getDate()+"日";
    
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
//    console.log(document.cookie);
    var arr =document.cookie.match(new RegExp("(^|)"+key+"=([^;]*)(;|$)"));
    if(arr !=null) 
        return unescape(arr[2]); 
    return null;
}