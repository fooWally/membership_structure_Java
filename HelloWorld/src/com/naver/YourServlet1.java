package com.naver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YourServlet1
 */
public class YourServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YourServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("euc-kr"); doesn;t work -> get to server.xml in Servers folder and
//		include URIEncoding="euc-kr" in line 65.
		String name = request.getParameter("name");
		name = toKor(name);
		String sAge = request.getParameter("age");
		int age = -1;
		if(sAge !=null) {
			age = Integer.parseInt(sAge);
		}
		System.out.println(name);
		System.out.println(age);
	
	}

	//클라이언트에서 서버에 get방식으로 한글 보낼때 한글 처리하는 방법
	private String toKor(String msg) {
		try {
			return new String(msg.getBytes("8859_1"),"euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
