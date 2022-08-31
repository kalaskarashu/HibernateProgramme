package app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Address;
import model.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Address add=new Address();
		add.setStreetno(123);
		add.setCity("Buldhana");
		add.setLandmark("Tulsi Nagar");
		Employee e1=new Employee();
		e1.setEmpid(45);
		e1.setEmpname("Ashutosh Kalaskar");
		e1.setAdd(add);
		session.save(e1);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done");

	}

}
