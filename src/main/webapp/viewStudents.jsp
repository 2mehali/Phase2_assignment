<%@page import="com.LearnersAcademy.Students"%>
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
<a href="AddStudent.html">Add Student</a><br>
<a href="AssigningStudentToClass.jsp">Assign Student</a>

<h1>The Following Students are listed</h1>
<%
	SessionFactory sf  = HibernateUtil.buildSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Students> students = hibernateSession.createQuery("from Students").list();
%>
<table>
<tr>
<th>Name </th>
<th>Last Name </th>
<th>Assigned Class </th>
</tr>
	<%		
		for(Students student : students){
			out.print("<tr>");	
			out.print("<td>" + student.getName() + "</td>");
			out.print("<td>" + student.getFname() + "</td>");
			out.print("<td>" + getClassName(student) + "</td>");
			out.print("</tr>");	
		}
	%>
</table>

<%!
	public String getClassName(Students student){
	if (student.getClasses() == null){
		return "no class assigned";
	}
	else{
		return student.getClasses().getName();
	}
}

%>
</body>
</html>