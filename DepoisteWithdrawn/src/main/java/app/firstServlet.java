package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstServlet")
public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public firstServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String type=request.getParameter("action");
		double amt=Double.parseDouble(request.getParameter("amt"));
		ServletContext context=getServletContext();
		context.setAttribute("amt", "");
		context.setAttribute("action", "");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			PreparedStatement ps=con.prepareStatement("select * from bank where id=?");
			ps.setInt(1, 1);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				context.setAttribute("amt", amt);
				context.setAttribute("action", type);
				int i=rs.getInt(1);
				context.setAttribute("id", i);
				double bal=rs.getDouble(2);
				context.setAttribute("bal", bal);
				RequestDispatcher rd=request.getRequestDispatcher("secoundServlet");
				rd.include(request, response);
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
