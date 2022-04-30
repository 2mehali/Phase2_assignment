<%@page import="com.LearnersAcademy.Subjects"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.LearnersAcademy.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="dashboard.html">Main Menu</a><br>
<a href="AddSubject.html">Add Subject</a><br>

<h1>The Following Subjects are listed</h1>
<%
	SessionFactory sf  = HibernateUtil.buildSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Subjects> subjects = hibernateSession.createQuery("from Subjects").list();
%>
<table>
<tr>
<th>Subject Name </th>
</tr>
	<%		
		for(Subjects subject : subjects){
			out.print("<tr>");	
			out.print("<td>" + subject.getName() + "</td>");
			out.print("</tr>");	
		}
	%>
</table>



</body>
</html>