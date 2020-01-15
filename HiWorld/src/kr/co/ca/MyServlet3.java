package kr.co.ca;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet3
 */
public class MyServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] hb = request.getParameterValues("hb"); //notice the name of parameter "hb"

		ArrayList<String> hbkor = new ArrayList<String>();
		for (int i = 0; i < hb.length; i++) {
			 hbkor.add(toKor(hb[i]));
		}
		
		
		// Instead of text, write something else e.g test, your browser starts downloading html code   
		response.setContentType("text/html; charset=EUC-KR"); //server responds in korean to user
		PrintWriter out = response.getWriter(); //NEVER close "out"
		out.print("<html>");
		out.print("<body>");
		
		for (int i = 0; i < hbkor.size(); i++) {
			out.print(hbkor.get(i));
			out.print("<br>");
		}
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
