package kr.co.ca;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Command[] com = {
				new InsertCommand(),
				new GetListCommand(),
				new GetMemberDTOByIdCommand(),
				new UpdateCommand(),
				new DeleteCommand()
		};
		System.out.println("메뉴를 선택하세요");
		String strMenu = "0-회원가입 1-전체조회 2-회원조회\n3-회원수정 4-삭제 5-종료";
		boolean isTrue = true;
		while(isTrue) {
			System.out.println(strMenu);
			int tempVal = 0, menu = 0;
			boolean excpt = true;
			while(excpt) {
				try {
					tempVal = sc.nextInt();
					sc.nextLine();
					excpt = false;
				} catch (InputMismatchException e) {
					sc.nextLine();
					System.out.println("문자가 입력 되었습니다.\n아래 메뉴에 있는 숫자를 입력 하세요.\n"+strMenu);
				}		
			}
			menu = tempVal;
			if (menu < com.length && menu >= 0) {
				com[menu].execute(sc);
			}else if(menu == com.length) {
				System.out.println("서비스가 종료 되었습니다.\n다시 시작하려면 F11을 눌러 주세요");
				isTrue = false;
			}else {
				System.out.println("메뉴에 있는 숫자를 선택하세요");
			}
		}
		sc.close();
	}
}
