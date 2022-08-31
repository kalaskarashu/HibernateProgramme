package app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Query info=session.createQuery("select e.name,e.city from Employee e");
		List list=info.list();
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			Object ob[]=(Object[])itr.next();
			System.out.println(ob[0]+"      "+ob[1]);
		
		}

	}

}
