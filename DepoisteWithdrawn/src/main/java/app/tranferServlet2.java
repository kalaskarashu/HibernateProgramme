package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;

@WebServlet("/tranferServlet2")
public class tranferServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public tranferServlet2() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();
		double amt=(double) context.getAttribute("secondbal");
		double amt2=(double) context.getAttribute("transamt");
		int id=(Integer) context.getAttribute("transid");
		Account a1=new Account();
		a1.setAmount(amt);
		a1.setDeposite(amt2);
		double a=a1.getAmount();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			PreparedStatement ps=con.prepareStatement("update bank set amount=? where id=?");
			ps.setDouble(1, a);
			ps.setInt(2, id);
			int i=ps.executeUpdate();
			if(i==1)
			{
				out.print("amt transfer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
