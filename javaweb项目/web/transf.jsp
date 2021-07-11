<%--
  Created by IntelliJ IDEA.
  User: wjx
  Date: 2021/4/20
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name=request.getParameter("uname");
    String flag=(String)session.getAttribute("flag");

    if(flag=="ok"){
        response.sendRedirect("succes.jsp");

    }else if(flag=="error"){
%>
<h1>登陆失败，将在3秒后跳转在登陆页面</h1></br>
<%   		response.setHeader("refresh","2;login.jsp");
}
%>