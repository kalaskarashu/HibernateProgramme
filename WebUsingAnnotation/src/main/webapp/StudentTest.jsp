<%@page import="model.Student"%>
<%@page import="org.hibernate.Transaction"%>
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
	int rollno = Integer.parseInt(request.getParameter("rollno"));
	String name = request.getParameter("uname");
	String division = request.getParameter("div");
	double marks = Double.parseDouble(request.getParameter("marks"));
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session sess = factory.openSession();
	Transaction tx = sess.beginTransaction();
	Student s1 = new Student();
	s1.setRollno(rollno);
	s1.setName(name);
	s1.setDivision(division);
	s1.setMarks(marks);
	sess.save(s1);
	tx.commit();
	sess.close();
	factory.close();
	out.print("Done");
	%>
</body>
</html>