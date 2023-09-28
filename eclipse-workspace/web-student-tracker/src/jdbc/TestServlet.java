package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Define datasource
	@Resource(name="jdbc/web_tracker")
	private DataSource datasource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    PrintWriter out=response.getWriter();
	    response.setCharacterEncoding("text/plain");
	
	    
	    Connection myConn=null;
	    java.sql.Statement myStmt=null;
	    ResultSet myRs=null;
	    
	    try {
	    	myConn=datasource.getConnection();
	    	
	    	String sql="select*from employee";
	    	myStmt=myConn.createStatement();
	    	
	    	
	    	myRs=myStmt.executeQuery(sql);
	    	
	    	
	    	while(myRs.next()) {
	    		int Id=myRs.getInt("id");
	    		out.println(Id);
	    	}
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	
	
	
	}

}
