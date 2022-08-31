package app;

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
		//Employee emp=new Employee(13,"Abhay","Sagwaon",1850.78);
		
		Transaction tx =session.beginTransaction();
		Employee emp=(Employee)session.load(Employee.class,11);
		tx.commit();
		System.out.println(emp);
		session.close();
		factory.close();
		

	}

}
