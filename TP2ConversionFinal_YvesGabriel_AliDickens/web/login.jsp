<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>login</title>
</head>

<body>
<h3>MoneyConvertor login.jsp</h3>
<ul>
    <li>
        <s:url id="url" action="connexion/Login">
            <s:param name="request_locale">en</s:param>
        </s:url>
        <s:a href="%{url}">English</s:a>
    </li>
    <li>
        <s:url id="url" action="connexion/Login">
            <s:param name="request_locale">fr</s:param>
        </s:url>
        <s:a href="%{url}">Français</s:a>
    </li>
</ul>

<s:text name="Form.login.title" />
<s:form action="connexion/Login">
 	  <s:textfield name="username" label="%{getText('username')}" required="true" key="userId"/>
 	  <s:textfield name="password" label="%{getText('password')}" required="true" key="password"/>
  	  <s:submit value="Log in"/>   	  
</s:form>	
    <li>
        <s:url id="url" action="Register" />
        <s:a href="%{url}"><s:text name="Form.registration.title">REGISTRATION</s:text></s:a>
    </li>
</body>
</html>
