<%@page import="model.Cheque"%>
<%@page import="model.CreditCard"%>
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
int cardid=Integer.parseInt( request.getParameter("cardid"));
int chequeid=Integer.parseInt( request.getParameter("chequeid"));
double amt=Double.parseDouble( request.getParameter("amt"));
//Date  date=Date.parseDate(request.getParameter("date"));
int cardno=Integer.parseInt(request.getParameter("cardno"));
String  cardtype=request.getParameter("cardty");
int chequeno=Integer.parseInt(request.getParameter("chequeno"));
String chequety=request.getParameter("chequety");
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory factory=cfg.buildSessionFactory();
Session sess=factory.openSession();
Transaction tx=sess.beginTransaction();
CreditCard card=new CreditCard();
card.setPayId(cardid);
card.setPayAmt(amt);
card.setCardtype(cardtype);
card.setCardNo(cardno);
Cheque ch=new Cheque();
ch.setPayId(chequeid);
ch.setPayAmt(amt);
ch.setChequeType(chequety);
ch.setChequeNo(chequeno);

sess.save(card);
sess.save(ch);
tx.commit();
sess.close();
factory.close();
out.print("Done");






%>
</body>
</html>