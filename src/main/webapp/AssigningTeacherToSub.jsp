<%@page import="com.LearnersAcademy.Subjects"%>
<%@page import="com.LearnersAcademy.Teachers"%>
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

<h2>Assign a Teacher to a Subject</h2>
<%
	SessionFactory sf  = HibernateUtil.buildSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Teachers> teachers = hibernateSession.createQuery("from Teachers").list();
	List<Subjects> subjects = hibernateSession.createQuery("from Subjects").list();
%>

<form action="assignTeacher" method="post">
<table>
<tr>
<th>Teacher Name </th>
<th>Subject Name </th>
</tr>
<tr>
<td>
<select name="name">
<%
	for (Teachers teacher : teachers){
	out.print("<option>" + teacher.getName() + " " + teacher.getLname());
	out.print("</option>");
	}
%>
</select>
</td>

<td>
<select name="subject">
<%
	for (Subjects subject : subjects){
	out.print("<option>" + subject.getName());
	out.print("</option>");
	}
%>
</select>
</td>
</tr>
</table>
<input type="submit" value="Submit">
</form>
</body>
</html>