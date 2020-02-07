package com.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.MemberDAO;
import com.member.MemberDTO;
import com.naver.Command;
import com.naver.CommandAction;

public class MSearchIDnPWCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
//		System.out.println(name +";"+ email + ";" + birth);
		MemberDTO dto= new MemberDAO().searchIDnPW(name,  birth, email);
//		System.out.println("dto ="+dto);
		request.setAttribute("dto", dto);
		return new CommandAction(false, "m_searchResult.jsp");
	}

}
