<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
<!--
#menu li {display : inline; padding : 5px; border : solid 1px blue; margin : 1px; background-color : #339;}
ul a {text-decoration:none;color : white;}
a:hover {color : red;}
-->
</style>
<s:actionmessage/>
<s:if test="#session['connecte']">
<ul id="menu">
    <li>
        <s:url id="url" action="ListMoney" />
        <s:a href="%{url}">Liste des Taux</s:a>
    </li>
    <li>
        <s:url id="url" action="Logout" />
        <s:a href="%{url}">Logout</s:a>
    </li>
</ul>
</s:if>
<s:else>
<ul>
    <li>
        <s:url id="url" action="Login" />
        <s:a href="%{url}">Login</s:a>
    </li>
</ul>
</s:else>
