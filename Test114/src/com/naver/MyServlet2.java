package com.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/ms2") 
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
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	   ServletContext application = getServletContext(); //application:내부객체중 하나
//	   InputStream in = application.getResourceAsStream("/WEB-INF/show.txt");//stream 만들어 show.txt으로 부터 가져오기
//	   InputStreamReader isr = new InputStreamReader(in); // txt 와 byte stream 연결
//	   BufferedReader br = new BufferedReader(isr); //
//	   
//	   response.setContentType("text/html;charset = euc-kr");
//	   PrintWriter out = response.getWriter();
//	   
//	   out.print("<html><body>");
//	   while (true) {
//		   String msg = br.readLine();
//		   if(msg==null) {
//			   break;
//		   }
//		   out.print(msg);
//		   out.print("<br>");
//	}
//	   System.out.println(br);
//	   out.print("</body></html>");
//	   br.close();
//	   isr.close(); //InputStream in 은 닫지 말기
//	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   ServletContext application = getServletContext(); //application:내부객체중 하나
		   InputStream in = application.getResourceAsStream("/WEB-INF/show.txt");//stream 만들어 show.txt으로 부터 가져오기
		   InputStreamReader isr = null; // txt 와 byte stream 연결
		   BufferedReader br = null; 
		   
		   try {
			   isr = new InputStreamReader(in); 
			   br = new BufferedReader(isr); 
			   
			   response.setContentType("text/html;charset = euc-kr");
			   PrintWriter out = response.getWriter();
			   
			   out.print("<html><body>");
			   while (true) {
				   String msg = br.readLine();
				   if(msg==null) {
					   break;
				   }
				   out.print(msg+"<br>");
			}
			   System.out.println(br);
			   out.print("</body></html>");

		} catch (Exception e) {
			
		}finally{
		   try {
			   if (br!=null) {br.close();} //InputStream in 은 닫지 말기
			   if (isr!=null) {isr.close();}
		} catch (Exception e) {
			e.printStackTrace();
		} 
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
