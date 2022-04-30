<%@page import="com.LearnersAcademy.Classes"%>
<%@page import="com.LearnersAcademy.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="com.LearnersAcademy.Students"%>
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

<h1>Assign a Student to a Class</h1>
<%
	SessionFactory sf  = HibernateUtil.buildSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Students> students = hibernateSession.createQuery("from Students").list();
	List<Classes> classes = hibernateSession.createQuery("from Classes").list();
%>
<form action="assignStudent" method="post">
<table>
<tr>
<th>Student Name </th>
<th>Class Name </th>
</tr>
<tr>
<td>
<select name="name">
<%
	for (Students student : students){
	out.print("<option>" + student.getName() + " " + student.getFname());
	out.print("</option>");
	}
%>
</select>
</td>

<td>
<select name="class">
<%
	for (Classes clas : classes){
	out.print("<option>" + clas.getName());
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