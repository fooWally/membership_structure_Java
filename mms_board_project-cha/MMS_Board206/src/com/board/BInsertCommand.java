package com.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.Command;
import com.naver.CommandAction;

public class BInsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		for (int i = 0; i < 100; i++) {
//			BoardDAO dao = new BoardDAO();
//			dao.insert(new BoardDTO(-1, "author"+i, "title"+i, "content"+i, null, 0, -1, 0, 0, 0, 0)); 
//		}

		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO dao = new BoardDAO();
		dao.insert(new BoardDTO(-1, author,title, content, null, 0, -1, 0, 0, 0, 0)); 
		
		return new CommandAction(true, "blist.do");
	}

}
