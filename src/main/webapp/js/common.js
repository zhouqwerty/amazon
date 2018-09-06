//初始化根路径
var basePath = "";
function initBasePath() {
    var curRequestPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var ipAndPort = curRequestPath.indexOf(pathName);
    var localhostPath = curRequestPath.substring(0,ipAndPort);
    var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    basePath = localhostPath + projectName;
}
initBasePath();
//post方式发送json数据的ajax请求
function callApi(url, data, callback, callErrorBack) {
    var obj = {};
    obj.time = new Date().getTime();
    obj.data = data;
    $.ajax({
        type: 'post',
        url: basePath+url,
        cache: false,
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        beforeSend: function (request) {
            request.setRequestHeader("GaeaToken", sessionStorage.getItem("GaeaToken"));
        },
        success: function (data) {
            if(!data.success){
                console.log("-----------------------error happened-----------------------------")
            }
            callback(data.data);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (callErrorBack instanceof Function) {
                callErrorBack();
            }
            console.log('!!!error:' + errorThrown);
        }
    });
}

function getParamsFromUrl(Url) {
    let params={};
    Url.replace(/[?&]+([^=&]+)=([^&]*)/gi, (m,key,value) =>{params[key] = decodeURI(value);});
    return params;
}

CommonValue={
    SUCCESS:'1',
    FAIL:'0',
    UNLOGIN:'unLogin'
}

/*事件总线*/
let temp=new Vue({
    data:{
        demo:8
    }
});

/*Array.prototype.containsStr=function(e){
    var r=new RegExp(','+e+',');
    return (r.test(','+this.join(this.S)+','));
};*/
