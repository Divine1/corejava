package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MysqlDao;

/**
 * Servlet implementation class WorkController
 */
@WebServlet("/work")
public class WorkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init controller");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy controller");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service controller");
		
		 /*response.setContentType( "text/html" );
		 response.sendRedirect( "example.jsp?foo=bar" );
		 String fooParameter = request.getParameter( "foo" );*/
		
		/*request.setAttribute("MyData", data);
		RequestDispatcher rd = request.getRequestDispatcher("page.jsp");
		rd.forward(request, response);
		
		<%String name=(String)request.getAttribute("name");
		out.print("your name"+name);%>
		<%= request.getAttribute("myname") %>.
		*/
		
		MysqlDao dao = new MysqlDao();
		String name = "infosys";
		request.setAttribute("name", name);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/work.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget controller");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost controller");
		doGet(request, response);
	}

}
