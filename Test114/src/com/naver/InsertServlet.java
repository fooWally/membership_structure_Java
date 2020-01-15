package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = getInitParameter("user");
		String password = getInitParameter("password");
		System.out.println(user);
		System.out.println(password);
		//data from context parameter
		
		
		ServletContext ctx = getServletContext();
		String driver = ctx.getInitParameter("driver");
		System.out.println(driver);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");//
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		
		int age = -1;
		if(sAge!=null) {
			age= Integer.parseInt(sAge);
		}
		//send data to server through dao
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		
		
		response.setContentType("text/html;charset=euc-kr"); // data from server to browser for korean
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print(id);
		out.print("<br>");
		out.print(name);
		out.print("<br>");
		out.print(age);
		out.print("</body></html>");
		
		
		
		
		
		
		
		
	
	
	}

}
