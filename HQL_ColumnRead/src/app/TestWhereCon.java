package app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestWhereCon {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the id");
	int i=sc.nextInt();
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	Query info=session.createQuery("select e.name,e.city from Employee e where e.id=:pid");
	info.setParameter("pid", i);
	List  list=info.list();
	Iterator itr=list.iterator();
	while(itr.hasNext())
	{
//		System.out.println(itr.next());
		Object obj[]=(Object[])itr.next();
		System.out.println(obj[0]+"  "+obj[1]);
	}
	
}
}
