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

@WebServlet("/secoundServlet")
public class secoundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public secoundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();
		double amt=(Double)context.getAttribute("amt");
		out.println("Amount you Entered"+amt);
		out.print("<br>");
		int id=(Integer)context.getAttribute("id");
		out.println("Id:"+id);
		out.print("<br>");
		String  action=(String)context.getAttribute("action");
		out.println("Action:"+action);
		out.print("<br>");
		
		
		Account a1=new Account();
		double bal=(Double)context.getAttribute("bal");
		out.print("Previous Sql Balance:"+bal);
		out.print("<br>");
		a1.setAmount(bal);
		
		if(action.equals("Deposite"))
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
				a1.setDeposite(amt);
				double amount=a1.getAmount();
				PreparedStatement ps=con.prepareStatement("update bank set amount=? where id=?");
				ps.setDouble(1, amount);
				ps.setInt(2, id);
				int ui=ps.executeUpdate();
				if(ui==1)
				{
					out.print("Success");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(action.equals("Withdrawn"))
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
				a1.setWithdrawn(amt);
				double amount=a1.getAmount();
				PreparedStatement ps=con.prepareStatement("update bank set amount=? where id=?");
				ps.setDouble(1, amount);
				ps.setInt(2, id);
				int ui=ps.executeUpdate();
				if(ui==1)
				{
					out.print("Success");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.print("<br>");out.print("<br>");
		out.print("<a href='thirdServlet'>ViewBalance</a>");
		out.print("<br>");out.print("<br>");
		out.print("<a href='transfer.html'>Tranfer</a>");
	}


}
