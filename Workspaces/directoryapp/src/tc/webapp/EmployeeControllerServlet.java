package tc.webapp;

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

	
	private DbUtil employeeDbUtil;
	
	@Resource(name="jdbc/directory_app")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			employeeDbUtil = new DbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand) {
			case "LIST":
				listEmployees(request, response);
				break;
			case "LOAD":
				loadEmployee(request, response);
				break;
			case "SEARCH":
				searchEmployee(request, response);
				break;
			case "SEARCHTWO":
				searchEmployeeTwo(request, response);
				break;
			case "UPDATE":
				updateEmployee(request, response);
				break;
			case "DELETE":
				deleteEmployee(request,response);
				break;
			default:
				listEmployees(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			String theCommand = request.getParameter("command");
			
			switch(theCommand) {
			case "ADD":
				addEmployee(request, response);
				break;
			default:
				listEmployees(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}


	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theEmployeeId = request.getParameter("employeeId");
		
		employeeDbUtil.deleteEmployee(theEmployeeId);
		
		listEmployees(request, response);
		
	}


	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int id = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");

		Employee theEmployee = new Employee(id, firstName, lastName, email, phoneNumber, address, city, state, zipCode);
		employeeDbUtil.updateEmployee(theEmployee);
		listEmployees(request, response);
		
	}


	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theEmployeeId = request.getParameter("employeeId");
		Employee theEmployee = employeeDbUtil.getEmployee(theEmployeeId);
		request.setAttribute("the_employee", theEmployee);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/update-employee-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		
		Employee theEmployee = new Employee(firstName, lastName, email, phoneNumber, address, city, state, zipCode);
		
		employeeDbUtil.addEmployee(theEmployee);
		
		response.sendRedirect(request.getContextPath() + "/EmployeeControllerServlet?command=LIST");
	}
	
	private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
		String searchName = request.getParameter("searchName");
		List<Employee> employees = employeeDbUtil.searchEmployee(searchName);
		request.setAttribute("employee_list", employees);
		        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/directory.jsp");
		dispatcher.forward(request, response);
	}	
	
	private void searchEmployeeTwo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		String searchAddress = request.getParameter("searchAddress");
		List<Employee> employees = employeeDbUtil.searchAddress(searchAddress);
		request.setAttribute("employee_list", employees);
		        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/directory.jsp");
		dispatcher.forward(request, response);
	}	


	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Employee> employee = employeeDbUtil.getEmployees();
		request.setAttribute("employee_list", employee);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/directory.jsp");
		dispatcher.forward(request, response);
	}
}
