package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee emp=new Employee();
		emp.setId(22);
		emp.setName("Ankush padmane");
		emp.setCity("sagwaon");
		emp.setSalary(3459.90);
		session.save(emp);
		//Employee emp=(Employee)session.get(Employee.class,12);
		//System.out.println(emp);
		System.out.println("Done");
		tx.commit();
		session.close();
		factory.close();
	}

}
