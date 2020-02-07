package com.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.Command;
import com.naver.CommandAction;

public class MInsertCommand implements Command  {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		String email = request. getParameter("email");
		
		new MemberDAO().insert(new MemberDTO(id, name, pw, birth, email));
		
		return new CommandAction(true, "m_index.jsp");
	}

}
