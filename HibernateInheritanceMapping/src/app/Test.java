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
		card.setPayId(111);
		card.setPayAmt(12500);
		card.setDate(new Date(2022,05,20));
		card.setCardNo(1234);
		card.setCardtype("Master");
		Cheque cq=new Cheque();
		cq.setPayId(222);
		cq.setPayAmt(12500);
		cq.setDate(new Date(2021,15,02));
		cq.setChequeNo(5678);
		cq.setChequeType("Barrier");
		session.save(card);
		session.save(cq);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done");

	}

}
