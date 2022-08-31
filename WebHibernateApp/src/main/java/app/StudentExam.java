package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

@WebServlet("/StudentExam")
public class StudentExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public StudentExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		String name = request.getParameter("uname");
		String div = request.getParameter("div");
		double marks = Double.parseDouble(request.getParameter("marks"));
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Student s1 = new Student();
		s1.setRollno(rollno);
		s1.setName(name);
		s1.setDiv(div);
		s1.setMarks(marks);
		Transaction tx = sess.beginTransaction();
		sess.save(s1);
		tx.commit();
		sess.close();
		factory.close();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("Done");
		
		
		
	}

}
