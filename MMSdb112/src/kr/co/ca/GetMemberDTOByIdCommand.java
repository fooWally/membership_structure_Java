package kr.co.ca;

import java.util.Scanner;

public class GetMemberDTOByIdCommand implements Command {

	@Override
	public void execute(Scanner sc) {

		MemberDAO dao = new MemberDAO();
		System.out.println("조회할 ID를 입력하세요");
		while(true) {
			String id = sc.nextLine();
			MemberDTO dto = dao.selectById(id);
			if (dto!= null) {
				System.out.println(dto);
				break;
			}else {
				System.out.println("존재하지 않는 회원입니다.\n다시 ID를 입력하세요.");
			}
		}
	}
}
