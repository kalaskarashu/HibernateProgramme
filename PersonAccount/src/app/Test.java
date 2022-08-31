package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Account;
import model.Person;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Account a1=new Account();
		Person p1=new Person();
		p1.setId(12);
		p1.setName("Ashutosh Kalaskar");
		p1.setCity("Buldhana");
		p1.setAge(24);
		p1.setBname("SBI");
		p1.setAmount(12599);
		p1.setDebit(10.70);
		session.save(p1);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done");

	}

}
