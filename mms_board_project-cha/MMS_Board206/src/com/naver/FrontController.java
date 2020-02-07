package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BDeleteCommand;
import com.board.BInsertCommand;
import com.board.BInsertUICommand;
import com.board.BListCommand;
import com.board.BReadCommand;
import com.board.BReplyCommand;
import com.board.BReplyUICommand;
import com.board.BUpdateCommand;
import com.board.BUpdateUICommand;
import com.member.MListCommand;
import com.member.MLoginCommand;
import com.member.MLoginUICommand;
import com.member.MLogoutCommand;
import com.member.MSearchIDnPWCommand;
import com.member.MUpdateCommand;
import com.member.MUpdateUICommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String what = uri.substring(cPath.length());
		
		Command com = null;
		
		if(what.equalsIgnoreCase("/blist.do")) {
			com = new BListCommand();
		}else if (what.equalsIgnoreCase("/bread.do")) {
			com = new BReadCommand();
		}else if (what.equalsIgnoreCase("/binsert.do")) {
			com = new BInsertCommand();
		}else if (what.equalsIgnoreCase("/binsertui.do")) {
			com = new BInsertUICommand();
		}else if(what.equalsIgnoreCase("/bupdateui.do")) {
			com = new BUpdateUICommand();
		}else if(what.equalsIgnoreCase("/bupdate.do")) {
			com = new BUpdateCommand();
		}else if(what.equalsIgnoreCase("/breply.do")) {
			com = new BReplyCommand();
		}else if(what.equalsIgnoreCase("/breplyui.do")) {
			com = new BReplyUICommand();
		}else if(what.equalsIgnoreCase("/mlogin.do")){
			com = new MLoginCommand();
		}else if(what.equalsIgnoreCase("/mloginui.do")){
			com = new MLoginUICommand();
		}else if(what.equalsIgnoreCase("/mlogout.do")){
			com = new MLogoutCommand();
		}else if (what.equalsIgnoreCase("/msearchid.do")) {
			com = new MSearchIDnPWCommand();
		}else if (what.equalsIgnoreCase("/mupdateui.do")) {
			com = new MUpdateUICommand();
		}else if (what.equalsIgnoreCase("/mupdate.do")) {
			com = new MUpdateCommand();
		}else if(what.equalsIgnoreCase("/mlist.do")) {
			com = new MListCommand();
		}
		
		
		if(com != null) {
			CommandAction action = com.execute(request, response);
			
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
