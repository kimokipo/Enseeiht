<%@ page language="java" import="pack.*, java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action= "Controler" method="get">
<center>
<% Collection<Campagne> lc = (Collection<Campagne>) request.getAttribute("listercampagnes");
String lien = (String)request.getAttribute("lien");%>

  
<h1> Campagnes : </h1> <br>
<%if (lc != null){
	for(Campagne c : lc){
     String nomc = c.getNom()+" "+ c.getContexte()+" "+ c.getObjectif();
     int idc = c.getId();
%>
<input type="radio" name = "idcampagne" value="<%=idc %>" >
<%=nomc %> <br>
 <%} %>
<input type="submit" name="op_releve" value="confirmer">
 <%}else {
	 Campagne c = (Campagne) request.getAttribute("campagne");
 	 String nomc = c.getNom()+" "+ c.getContexte()+" "+ c.getObjectif();%>
 <%=nomc %>
 <% }%>
      </table>
     
<input type="hidden" name="op" value="relevecampagne">

<% Integer nl = (Integer) request.getAttribute("nl");
Integer nc = (Integer) request.getAttribute("nc");
Integer ns = (Integer) request.getAttribute("ns");
if (nl != null){%>
	<table border="1" width="80%">
	 <tr> <th>Nombre de likes</th><th>Nombre de comments</th><th>Nombre de shares</th></tr>
	 <tr><td><%=nl %></td><td><%=nc %></td><td><%=ns %></td></tr>
      </table>
<%} %>
			
<br><a href=<%=lien %>>Retour au Menu</a>
</center>
</form>


</body>
</html>