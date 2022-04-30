<%@page import="com.LearnersAcademy.Subjects"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.LearnersAcademy.Classes"%>
<%@page import="java.util.List"%>
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
<a href="dashboard.html">Back to Main Menu</a><br>
<a href="AddClass.html">Add Class</a><br>
<a href="AssigningSubToClass.jsp">Assign Subject to Class</a><br>

<h1>The Following Classes are listed</h1>
<%
	SessionFactory sf  = HibernateUtil.buildSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Classes> classes = hibernateSession.createQuery("from Classes").list();
%>
<table>
<tr>
<th>Class Name </th>
<th>Subject Name</th>
</tr>	
	<%		
		for(Classes clas : classes){
			out.print("<tr>");	
			out.print("<td>" + clas.getName() + "</td>");
						
			StringBuffer buf = new StringBuffer();
			boolean first = true;
			for (Subjects subject : clas.getSubjects()){
				if(first== true){
					buf.append("<td>" + subject.getName() + "</td>");
					buf.append("</tr>");
					first = false;
				}else{
					buf.append("<tr><td></td>");
					buf.append("<td>" + subject.getName() + "</td>");
					buf.append("</tr>");
				}
				
			}
			out.print(buf.toString());
		}
	%>
</table>
</body>
</html>