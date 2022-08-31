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

public class Projection_parameter {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		Projection p1=Projections.property("name");
		Projection p2=Projections.property("id");
		ProjectionList plist=Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
		criteria.setProjection(plist);
		List listemp=criteria.list();

		for(int i=0; i<listemp.size();i++)
		{
			Object ob[]=(Object[])listemp.get(i);
			System.out.println("Name "+ob[0]+" Id "+ob[1]);
		}

	}

}
