
function getRootPath(){
    //��ȡ��ǰ��ַ���磺 http://localhost:8088/test/test.jsp
    var curPath=window.document.location.href;
    //��ȡ������ַ֮���Ŀ¼���磺 test/test.jsp
    var pathName=window.document.location.pathname;
    var pos=curPath.indexOf(pathName);
    //��ȡ������ַ���磺 http://localhost:8088
    var localhostPaht=curPath.substring(0,pos);
    //��ȡ��"/"����Ŀ�����磺/test
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

window.location.href = getRootPath()+'/error';