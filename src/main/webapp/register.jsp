<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <script type="text/javascript">
        function checkusername() {
            //获取用户名
            var  input=document.getElementById("input");
            var username=input.value;
            //通过Ajax把用户名传入后台
            //创建异步请求对象  xhr
            var xhr;
            if (window.ActiveXObject){
                xhr=new ActiveXObject("Microsoft.XMLHTTP");  //IE系
            } else {
                xhr=new  XMLHttpRequest(); //非IE系
            }
            //打开异步请求
            xhr.open("GET","${pageContext.request.contextPath}/user/register?name="+username);
            //发送异步请求
            xhr.send(null);
            //监听响应
            xhr.onreadystatechange=function () {
                //响应正确完成
                if (xhr.readyState==4&&xhr.status==200){
                    var  messages=  xhr.responseText;
                    alert(messages)
                    var  span=document.getElementById("span");
                    span.innerHTML=messages;
                }
            }
        }
    </script>
</head>
<body>
<form action="" method="post" enctype="application/x-www-form-urlencoded">
    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">
        <tr>
            <td valign="middle" align="right">
                username:
            </td>
            <td valign="middle" align="left">
                <input type="text"   id="input" onblur="checkusername()"/><span id="span"></span><br/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                age:
            </td>
            <td valign="middle" align="left">
                <input type="password" class="inputgri"  />
            </td>
        </tr>
    </table>
    <p>
        <input type="submit" class="button" value="Submit &raquo;" />
    </p>
</form>
</body>
</html>