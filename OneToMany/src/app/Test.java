package app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.PhoneNumber;
import model.User;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		PhoneNumber ph1=new PhoneNumber(121234345l, 3456745678l);
		PhoneNumber ph2=new PhoneNumber(896782637l, 2356565774l);
		
		List<PhoneNumber> plist=new ArrayList<>();
		plist.add(ph2);
		plist.add(ph1);
		User u1=new User("Ashutosh",plist);
		session.save(u1);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done");
	}

}
