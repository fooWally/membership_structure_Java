package kr.co.ca;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hometown= request.getParameter("hometown"); //notice the name of parameter "hometown"
		hometown= toKor(hometown);
		
		// Instead of text, write something else e.g test, your browser starts downloading html code   
		response.setContentType("text/html; charset=EUC-KR"); //server responds in korean to user
		PrintWriter out = response.getWriter(); //NEVER close "out"
		
		out.print("<html>");
		out.print("<body>");
		out.print(hometown);
		out.print("</body>");
		out.print("</html>");
	}
	
	private String toKor(String msg) {
		try {
			return new String(msg.getBytes("8859_1"),"euc-kr");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
