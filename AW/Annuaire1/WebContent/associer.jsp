<%@ page language="java" import="pack.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action= "Serv" method="get">
Choisir la personne: <br>
<%Collection<Personne> listePersonnes = (Collection<Personne>) request.getAttribute("listePersonnes");
for (Personne p : listePersonnes){
	int idPer = p.getId();
	String nom_prenom = p.getNom()+ " " + p.getPrenom();
	%>
<input type="radio" name="idPer" value = "<%=idPer%>"> <%=nom_prenom %><br/>
<% }%>

Choisir l'adresse: <br>
<%Collection<Adresse> listeAdresses = (Collection<Adresse>) request.getAttribute("listeAdresses");
for (Adresse p : listeAdresses){
	int idAdr = p.getId();
	String rue_ville = p.getRue()+ " " + p.getVille();
	%>
<input type="radio" name="idAdr" value = "<%=idAdr%>"> <%=rue_ville %><br/>
<% }%>


<input type="submit" name= "confirmer" value="OK">
<input type="hidden" name="op" value="associer">

<a href="index.html">retour à l'index</a> <br>


</body>
</html>