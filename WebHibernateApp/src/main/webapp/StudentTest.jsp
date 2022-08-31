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
	int rollno = Integer.parseInt(request.getParameter("rollno"));
	String act=request.getParameter("act");
	String name = request.getParameter("uname");
	String div = request.getParameter("div");
	double marks = Double.parseDouble(request.getParameter("marks"));
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session sess = factory.openSession();
	if(act.equals("Insert"))
	{
		Student s1 = new Student();
		s1.setRollno(rollno);
		s1.setName(name);
		s1.setDiv(div);
		s1.setMarks(marks);
		Transaction tx = sess.beginTransaction();
		sess.save(s1);
		tx.commit();
		sess.close();
		factory.close();
		out.print("Insert Done");
	}
	else if(act.equals("Delete"))
	{
	Student s1 = new Student();
	s1.setRollno(rollno);
	//s1.setName(name);
	//s1.setDiv(div);
	//s1.setMarks(marks);
	Transaction tx = sess.beginTransaction();
	sess.delete(s1);
	tx.commit();
	sess.close();
	factory.close();
	out.print("Delete Done");	
	}
	else if(act.equals("Update"))
	{
	Student s1 = new Student();
	s1.setRollno(rollno);
	s1.setName(name);
	s1.setDiv(div);
	s1.setMarks(marks);
	Transaction tx = sess.beginTransaction();
	sess.update(s1);
	tx.commit();
	sess.close();
	factory.close();
	out.print("Update Done");	
	}
	else if(act.equals("Show"))
	{
	Transaction tx = sess.beginTransaction();
	Student s1=(Student)sess.load(Student.class,rollno);
	tx.commit();
	out.print(s1);	
	sess.close();
	factory.close();
	}
	%>
	
</body>
</html>