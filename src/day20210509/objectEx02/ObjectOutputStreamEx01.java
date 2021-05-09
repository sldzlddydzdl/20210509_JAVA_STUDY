package day20210509.objectEx02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamEx01 {
	public static void main(String[] args) {
		// 한개의 객체를 쓰고.
		// 묶어서 처리하는 것도 가능
		// list 에 담아서도 파일에 작성이 가능하다. 
		
		List<User> userlist = new ArrayList<>();
		userlist.add(new User("가렌",30, 180.5, "소환사협곡 탑"));
		userlist.add(new User("럭스",20, 170.1, "소환사협곡 미드"));
		userlist.add(new User("베인",22, 160.3, "소환사협곡 봇"));
		
		try(ObjectOutputStream out = new ObjectOutputStream(
			new FileOutputStream("src/day20210509/objectEx02/userlist"))){
			
			out.writeObject(userlist);
			out.flush();
			
			System.out.println("파일작성완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

//ObjectInputStreamEx01 클래스 만들어서
//파일에 작성된 객체를 읽어와서
//user 의 나이의 총합을 출력