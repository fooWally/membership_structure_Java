package kr.co.ca;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UpdateCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("회원 정보 수정");
		System.out.println("수정할 회원의 ID를 입력하세요");
		String id = sc.nextLine();
		MemberDAO dao = new MemberDAO();
		MemberDTO someone = dao.selectById(id);
		String name=null;
		if (someone!=null) {
			System.out.println("새이름을 입력하세요.\n최대 영문 12자까지 가능");
			while(true) {
				name = sc.nextLine();
				int namelen = name.length(); 
				if (namelen > 12 || namelen == 0) {
					System.out.println("가능한 이름를 다시 입력하세요.\n최대 영문 12자까지 가능");
				}else {
					break;
					}
				}

		DepartmentDAO departDao = new DepartmentDAO();
		Map<String, String> mapSorted = departDao.getAllDepartments();
		Set<String> keys = mapSorted.keySet();
		System.out.println("다음 학과 코드 Did 중 하나를 입력하세요.");
		System.out.println(mapSorted);
		String departCode = null;
		while(true) {
			String tmpCode = sc.nextLine();
			if (!keys.contains(tmpCode)) {
				System.out.println("없는 학과입니다. 다시 입력하세요");
			}else {
				departCode = tmpCode;
				break;
			}
		}

		int age = 0;
		System.out.println("나이를 입력하세요.");
		while(true) {
			int tempAge = 0;
			boolean excpt = true;
			while(excpt) {
				try {
					tempAge = sc.nextInt();
					sc.nextLine();
					excpt = false;
				} catch (InputMismatchException e) {
					sc.nextLine();
					System.out.println("문자가 입력 되었습니다.\n0 보다 크거나 200미만 숫자를 입력 하세요.");
				} 
			}
			age = tempAge;		
			if (age <= 0 || age >= 200) {
				System.out.println("다시 나이를 입력하세요.\n입력 가능 나이는 0 보다 크거나 200미만 입니다.");
			}else {	break;}
		}

		MemberDTO dto = new MemberDTO(id, name, departCode, age);
		dao.update(dto);
		System.out.println("수정이 완료되었습니다.");
	}else {
		System.out.println("존재하지 않는 ID입니다. 처음부터 다시 시작하세요");
	}

}

}
