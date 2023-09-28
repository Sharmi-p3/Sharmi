package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDbUtil {
private DataSource dataSource;
	
	public EmployeeDbUtil(DataSource theDataSource) {
		dataSource=theDataSource;
	}
	
	public List<Employee> getEmployees() throws Exception{
		
		List<Employee> employees=new ArrayList<Employee>();
		
		Connection myConn=null;
	    Statement myStmt=null;
	    ResultSet myRs=null;
	    
	    try {
	    	myConn=dataSource.getConnection();
	    	
	    	
	    	String sql="select * from employee order by first_name";
	    	myStmt=myConn.createStatement();
	    	
	    	myRs=myStmt.executeQuery(sql);
	    	
	    	while(myRs.next()) {
	    		int id=myRs.getInt("id");
	    		String firstName=myRs.getString("first_name");
	    		String lastName=myRs.getString("last_name");
	    		String email=myRs.getString("email");
	    		
	    		
	    		Employee tempEmployee=new Employee(id,firstName,lastName,email);
	    		
	    		employees.add(tempEmployee);
	    	}
	    	
	    	
	    	
			return employees;

	    }
	    finally {
	    	close(myConn,myStmt,myRs);
	    	
	    }
	    
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
	 try {
		if(myRs!=null) {
			myRs.close();
		}
		if(myStmt!=null) {
			myStmt.close();
		}
		
		
		
		if(myConn!=null) {
			myConn.close();
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}

	public void add(Employee theEmployee) throws SQLException {
            Connection myConn=null;
            PreparedStatement myStmt=null;
            
            
            try {
            	myConn=dataSource.getConnection();
            	
            	
            	String sql="insert into employee" +"(first_name,last_name,email)"+"values(?,?,?)";
            	
            	myStmt=myConn.prepareStatement(sql);
            	
            	myStmt.setString(1, theEmployee.getFirstName());
            	myStmt.setString(2, theEmployee.getLastName());
            	myStmt.setString(3, theEmployee.getEmail());
            	
            	myStmt.execute();

            }
            finally {
            	close(myConn,myStmt,null);
            	
            }
            
            
	}
	public Employee getEmployee(String theEmployeeId) throws Exception {

		Employee theEmployee=null;
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs =null;
		int employeeId;
		
		try {
			
			employeeId=Integer.parseInt(theEmployeeId);
			
			myConn=dataSource.getConnection();
			
			String sql="select * from employee where id=?";
			
			myStmt=myConn.prepareStatement(sql);
			
			myStmt.setInt(1, employeeId);
			
			myRs=myStmt.executeQuery();
			
			if(myRs.next()) {
				String Firstname=myRs.getString("first_name");
				String Lastname=myRs.getString("last_name");
				String Email=myRs.getString("email");
				
				theEmployee=new Employee(employeeId,Firstname,Lastname,Email);
			}
			else {
				return null;
			}
			
		    return theEmployee;
		}
		finally {
			
			close(myConn,myStmt,null);
			
		}
	}

	public void updateEmployee(Employee theEmployee) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		try {
			myConn=dataSource.getConnection();
			
			String sql="update employee "+"set first_name=?,last_name=?,email=?"+" where id=?";
			
			myStmt=myConn.prepareStatement(sql);
			
			
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2,theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setInt(4, theEmployee.getId());
			
			myStmt.execute();
			
		    
		}
		finally {
			close(myConn,myStmt,null);
			
		}
		
	}

	public void deleteEmployee(String theEmployeeId) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
			
			int employeeId=Integer.parseInt(theEmployeeId);
			myConn=dataSource.getConnection();
			
			String sql="delete from employee where id=?";
			
			myStmt=myConn.prepareStatement(sql);
			
			myStmt.setInt(1, employeeId);
			
			myStmt.execute();
			
		}
		finally {
			close(myConn,myStmt,null);
			
		}
		
	}


}
