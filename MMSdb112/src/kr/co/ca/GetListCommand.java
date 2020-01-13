package kr.co.ca;

import java.util.ArrayList;
import java.util.Scanner;

public class GetListCommand implements Command {

	
	@Override
	public void execute(Scanner sc) {
		
			System.out.println("DB에 있는 모든 회원 정보를 불러옵니다.");
			
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.select();
			
			for(int i = 0; i < list.size(); i ++) {
				MemberDTO dto = list.get(i);
				System.out.println(dto);
			}

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("DB에 있는 모든 회원 정보를 불러옵니다.");
//				
//				MemberDAO dao = new MemberDAO();
//				ArrayList<MemberDTO> list = dao.select();
//				
//				for(int i = 0; i < list.size(); i ++) {
//					MemberDTO dto = list.get(i);
//					System.out.println(dto);
//				}
//			}
//		}).start();

	}

}
