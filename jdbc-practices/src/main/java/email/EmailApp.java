package email;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailApp {
	private static Scanner scanner = new Scanner(System.in);
			
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.print("(l)ist (d)elete (i)nsert (q)uit > ");
			String command = scanner.nextLine();
			
			if("l".equals(command)) {
				doList();
			} else if("d".equals(command)) {
				doDelete();
			} else if("i".equals(command)) {
				doInsert();
			} else if("q".equals(command)) {
				break;
			}
		}
		
		if(scanner != null) {
			scanner.close();
		}
	}

	private static void doList() {
        List<EmailVo> list = new EmailDao().findAll();

        for(EmailVo vo : list) {
            System.out.println(vo);
        }
	}

	private static void doDelete() {
        System.out.print("삭제할 id입력: ");
        Long deleteId = scanner.nextLong();

        new EmailDao().delete(deleteId);
        doList();
	}

	private static void doInsert() {
		System.out.print("성: ");
		String firstName = scanner.nextLine();

		System.out.print("이름: ");
		String lastName = scanner.nextLine();
		
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		
		EmailVo vo = new EmailVo();
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		
		new EmailDao().insert(vo);
		
		doList();
	}
	
}