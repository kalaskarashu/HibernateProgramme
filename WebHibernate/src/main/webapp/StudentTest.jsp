<%@page import="org.hibernate.Transaction"%>
<%@page import="model.Student"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session ses = factory.openSession();
	String no = request.getParameter("rollno");
	 int i=Integer.parseInt(no); 
	String name = request.getParameter("uname");
	String div = request.getParameter("div");
	double marks=Double.parseDouble(request.getParameter("marks"));
	Student s1 = new Student( name, marks, div,i);
	Transaction tx=ses.beginTransaction();
	ses.save(s1);
	tx.commit();
	ses.close();
	factory.close();
	out.print("Done");
	%>
</body>
</html>