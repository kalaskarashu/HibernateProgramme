package app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import model.Employee;

public class AggregatesValue {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		Projection p1=Projections.rowCount();
		Projection p2=Projections.sum("id");
		//Projections.max(null);
		//Projections.min(null);
		ProjectionList plist=Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
	criteria.setProjection(plist);
	List list=criteria.list();
	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		System.out.println("Count "+object[0]+" Sum:"+object[1]);
		
	}

	}

}
