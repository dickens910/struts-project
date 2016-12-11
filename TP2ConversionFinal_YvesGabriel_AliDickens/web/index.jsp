<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="not #session['connecte']">
<jsp:forward page="login.jsp"></jsp:forward>
</s:if>
<html>
<head>
    <title>MoneyConvertor</title>
</head>
<h5> Bienvenu <%  out.println(session.getAttribute("username"));  %></h5>
<body>
<h3>MoneyConvertor index page</h3>

<s:include value="menu.jsp"></s:include>	

