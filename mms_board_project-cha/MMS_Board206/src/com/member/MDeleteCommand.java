package com.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.Command;
import com.naver.CommandAction;

public class MDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String sPw = request.getParameter("pw");
		
		int pw = -1;
		if(sPw!=null) {pw=Integer.parseInt(sPw);}
		
		new MemberDAO().delete(id, pw);
		
		return new CommandAction(true, "m_index.jsp");
	}

}
