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
<% Collection<Post> lc = (Collection<Post>) request.getAttribute("listerposts");
String lien = (String)request.getAttribute("lien");
%><table border="1" width="80%">
	 <tr> <th>Titre</th><th>Url</th><th>Contenu</th></tr>

 <% for(Post p : lc){%>
	 <tr><td><%=p.getTitre() %></td><td><%=p.getUrl()%></td><td><%=p.getContenu() %></td></tr>
   
     <%} %>
      </table>
     

<input type="hidden" name="op" value="listerPosts">
 <br><a href=<%=lien %>>Retour au Menu</a></br> 
</center>
</form>
</body>
</html>