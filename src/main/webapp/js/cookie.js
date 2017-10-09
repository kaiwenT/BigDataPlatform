/**
 * 存取cookie方法
 */
function setCookie(key, value) {
    var Days = 1; // 此 cookie 将被保存 1 天
    var exp　= new Date();
    exp.setTime(exp.getTime() +Days*24*60*60*1000);
    document.cookie = key +"="+ escape (value) + ";expires=" + exp.toGMTString();
}

function getCookie(key) {
//    console.log(document.cookie);
    var arr =document.cookie.match(new RegExp("(^|)"+key+"=([^;]*)(;|$)"));
    if(arr !=null) 
        return unescape(arr[2]); 
    return null;
}