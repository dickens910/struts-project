<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="not #session['connecte']">
<jsp:forward page="login.jsp"></jsp:forward>
</s:if>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src ></script>
    <title>MyCurrencys</title>
</head>

<body>
<h3>My Currency Convertor</h3>
<s:include value="menu.jsp"></s:include>	
<h4>Liste des Taux</h4>
<h5> Bienvenu   <%  out.println(session.getAttribute("username")); %></h5>
<div>
    Montant :<input type="number" id="moneyToConvert">
    <table border="1" cellspacing="0">
         <tr>
             <th>Monnaie</th>
             <th>Valeur</th>
         </tr>
    <s:iterator value="moneyList">
         <tr>
             <td><s:property value="monnaie" /></td>
             <td><s:property value="valeur" /></td>
             <td>  
                  <button value=<s:property value="valeur" />>Convertir</button>
             </td>
         </tr>
    </s:iterator>
    </table>
</div>    
<p id = "convert"></p>
<p>Money Converted <input type="text" name="user"></p>
</body>
</html>
<script> </script>
<script>    //cette function convertit le montant 
$(document).ready(function(){
    $("button").click(function(){
        var moneyToConvert = $("#moneyToConvert").val();
        if (moneyToConvert > 0 ){
            var tauxMonnaie = $(this).val() ;
             parseFloat(tauxMonnaie);
            var moneyConvert = moneyToConvert * tauxMonnaie;
            $("input:text").val(moneyConvert);
            $("#convert").html(moneyConvert);
        }
        else alert("le montant à voncerti doit ^etre superieur a [0]");
    });
});
</script>
</head>
<body>



