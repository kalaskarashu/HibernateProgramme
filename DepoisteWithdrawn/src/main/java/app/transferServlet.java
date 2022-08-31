package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;

@WebServlet("/transferServlet")
public class transferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public transferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		double amt=Double.parseDouble(request.getParameter("amt"));
		int id=Integer.parseInt(request.getParameter("amt"));
		ServletContext context=getServletContext();
		context.setAttribute("transamt", "");
		context.setAttribute("transid", "");
		int id1=(Integer)context.getAttribute("id");
		double bal1=(Double)context.getAttribute("bal");
		Account a1=new Account();
		a1.setAmount(bal1);
		a1.setWithdrawn(amt);
		double bal2=a1.getAmount();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			PreparedStatement ps=con.prepareStatement("update bank set amount=? where id=?");
			ps.setDouble(1, bal2);
			ps.setInt(2, id1);
			int i=ps.executeUpdate();
			if(i==1)
			{
				context.setAttribute("transamt", amt);
				context.setAttribute("transid", id);
				RequestDispatcher rd=request.getRequestDispatcher("tranferServlet1");
				rd.include(request, response);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
