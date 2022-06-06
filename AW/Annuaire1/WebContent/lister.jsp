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
<%HashMap<Personne,Collection<Adresse>> listePersonnes = (HashMap<Personne,Collection<Adresse>>) request.getAttribute("listeTout");
for (Map.Entry<Personne,Collection<Adresse>> e : listePersonnes.entrySet()){
	Personne p = e.getKey();
	Collection<Adresse> adresses = e.getValue();
	String nom_prenom = p.getNom()+ " " + p.getPrenom();
	%>
	<p STYLE="padding:0 0 0 0px;"><%=nom_prenom %> <br>
	<% for (Adresse a : adresses){
		String rue_ville = " "+ a.getRue()+ " " + a.getVille();
	%>
	<p STYLE="padding:0 0 0 20px;"><%=rue_ville %> <br>
	<%} %>
<%} %>

<input type="hidden" name="op" value="lister">

<p STYLE="padding:0 0 0 0px;"> <a href="index.html">retour à l'index</a> <br>
</body>
</html>