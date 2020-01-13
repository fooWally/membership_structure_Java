package kr.co.ca;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {

		System.out.println("ID를 입력하세요.");
		String id = null;
		while(true) {
			id = sc.nextLine();
			int idlen = id.length(); 
			if (idlen>6 || idlen == 0) {
				System.out.println("가능한 ID를 다시 입력하세요.\n최대 영문 6자까지 가능");
			}else {break;}
		}

		MemberDAO dao = new MemberDAO();
		while(true) {
			MemberDTO someone = dao.selectById(id);
			if (someone!= null) {
				System.out.println("중복된 ID입니다. 다른 ID를 입력 하세요");
				id = sc.nextLine();
			}else {	break;}
		}

		System.out.println("이름을 입력하세요.\n최대 영문 12자까지 가능");
		String name = null;
		while(true) {
			name = sc.nextLine();
			int	namelen = name.length(); 
			if (namelen > 12 || namelen == 0) {
				System.out.println("가능한 이름를 다시 입력하세요.\n최대 영문 12자까지 가능");
			}else {	break;}
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

		System.out.println("나이를 입력하세요.");
		int age = 0;
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
					System.out.println("문자가 입력 되었습니다.\n0 보다 크거나 200 미만 숫자를 입력 하세요.");
				} 
			}
			age = tempAge;		
			if (age <= 0 || age >= 200) {
				System.out.println("다시 나이를 입력하세요.\n입력 가능 나이는 0 보다 크거나 200미만 입니다.");
			}else {	break;}

		}
		MemberDTO dto = new MemberDTO(id, name, departCode, age);
		dao.insert(dto);
		System.out.println("회원으로 가입 되었습니다");
	}
}



