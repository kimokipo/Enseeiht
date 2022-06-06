<%@ page language="java" import="pack.*, java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campagnes</title>
</head>
<body>

<form action= "Controler" method="get">
<center>
<% Collection<Campagne> lc = (Collection<Campagne>) request.getAttribute("listerCampagnes");
String lien = "userConnect.html";
%>
 <% for(Campagne c : lc){
	 String info = "-  "+c.getNom() + "\n debut " + c.getDateDebut()
	 + "\n fin " + c.getDateFin() +"\n Objectif " + c.getObjectif() +"\n Contexte " + c.getContexte();
	 
%>  
     <%=info%> <br>
      
     <%} %>
     

<input type="hidden" name="op" value="lister">
 <a href=lien>Retour au Menu</a> 
</center>
</form>

</body>
</html>