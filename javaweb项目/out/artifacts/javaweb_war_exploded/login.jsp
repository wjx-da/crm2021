<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: wjx
  Date: 2021/4/20
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
    <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
</head>
<body>
<%
    String uname="";
    String upwd="";
    Cookie[] c=request.getCookies();
    if(c!=null){
        for (int i=0;i<c.length;i++){
            if(URLDecoder.decode(c[i].getName(),"utf-8").equals("万家欣")&&c[i].getValue()!=null){
                uname= URLDecoder.decode(c[i].getName(),"utf-8");
                upwd=c[i].getValue();
            }
        }
    }else{
        uname="";
        upwd="";
    }
%>
<form action=ControlServlet method="post">
    姓名<input type="text" name="uname" value="<%=uname %>" ><br/>
    密码<input type="password" name="upwd" value="<%=upwd %>"><br/>
    记住密码<input type="checkbox" name="sign" checked="checked"/><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>