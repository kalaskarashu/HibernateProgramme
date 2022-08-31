package app;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUpdate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int i=sc.nextInt();
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Query info=session.createQuery("update Employee e set e.name=:p1 where e.id=:p2");
		info.setParameter("p1", "Ashutosh Kalaskar");
		info.setParameter("p2", i);
		int ir=info.executeUpdate();
		tx.commit();
		System.out.println(ir+" Updated");

	}

}
