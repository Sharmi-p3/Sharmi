package jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmployeeControllerServlet
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name="jdbc/web_tracker")
	private DataSource dataSource;

	private EmployeeDbUtil employeeDbUtil;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	
	try {
		 employeeDbUtil = new EmployeeDbUtil(dataSource);
		
	}
	catch(Exception e) {
	       throw new ServletException(e);
	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String theCommand=request.getParameter("command");
			
			if(theCommand==null) {
				theCommand="LIST";
				
			}
			
			switch(theCommand) {
			
			case "LIST":
				   listEmployees(request,response);
				   break;
				   
			case "ADD":
				 addEmployee(request,response);
				 break;
			case "LOAD":
				loadEmployee(request,response);
				break;
			case "UPDATE":
				updateEmployee(request,response);
				break;
			case "DELETE":
				deleteEmployee(request,response);
				break;
			default:
				listEmployees(request,response);
				

				
			
			}
		
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theEmployeeId=request.getParameter("employeeId");
		
		employeeDbUtil.deleteEmployee(theEmployeeId);
		
		listEmployees(request,response);

		
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("employeeId"));
		String firstName=request.getParameter("firstName");
		String lastName =request.getParameter("lastName");
		String email=request.getParameter("email");
		
		
		Employee theEmployee=new Employee(id,firstName,lastName,email);
		
		
		employeeDbUtil.updateEmployee(theEmployee);
		
		listEmployees(request,response);
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theEmployeeId=request.getParameter("employeeId");
		
		Employee theEmployee=employeeDbUtil.getEmployee(theEmployeeId);
		
		request.setAttribute("THE_EMPLOYEE", theEmployee);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/update-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String FirstName=request.getParameter("firstName");
		String LastName=request.getParameter("lastName");
		String Email=request.getParameter("email");
		
		Employee theEmployee=new Employee(FirstName, LastName, Email);
		
		
		employeeDbUtil.add(theEmployee);
		
		listEmployees(request,response);
		
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Employee> employees = employeeDbUtil.getEmployees();
		request.setAttribute("EMPLOYEE_LIST", employees);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
		
		
		
	}


}
