package app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import model.Employee;

public class Asc_order {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory =cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("name"));
		List list=criteria.list();
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			Employee e=(Employee)itr.next();
			System.out.println(e);
		}
		System.out.println("-----------------------------------DSE-------------------------------");
		Criteria criteriaDse=session.createCriteria(Employee.class);
		criteriaDse.addOrder(Order.desc("name"));
		List dlist=criteriaDse.list();
		Iterator itrd=dlist.iterator();
		while(itrd.hasNext())
		{
			Employee e1=(Employee)itrd.next();
			System.out.println(e1);
		}

	}

}
