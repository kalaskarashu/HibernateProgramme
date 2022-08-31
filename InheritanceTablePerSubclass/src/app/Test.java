package app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Cheque;
import model.CreditCard;


public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		CreditCard card=new CreditCard();
		card.setPayid(111);
		card.setPayamt(12500);
		card.setPaydate(new Date(2022,05,20));
		card.setCardno(1234);
		card.setCardtype("Master");
		Cheque cq=new Cheque();
		cq.setPayid(22);
		cq.setPayamt(3423.67);
		cq.setPaydate(new Date(2002,26,06));
		cq.setChequeno(4567);
		cq.setChequetype("Barrier");
		session.save(card);
		session.save(cq);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done");

	}

}
