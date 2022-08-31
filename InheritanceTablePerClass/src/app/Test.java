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
		card.setPayId(11);
		card.setPayAmt(12900.67);
		card.setDate(new Date(2022,15,01));
		card.setCardNo(1234);
		card.setCardtype("Visa");
		Cheque ch=new Cheque();
		ch.setPayId(12);
		ch.setPayAmt(34500.23);
		ch.setDate(new Date(2021,23,05));
		ch.setChequeNo(5656);
		ch.setChequeType("Barrier");
		session.save(card);
		session.save(ch);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done");

	}

}
