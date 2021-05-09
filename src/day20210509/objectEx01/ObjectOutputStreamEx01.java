package day20210509.objectEx01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamEx01 {
	public static void main(String[] args) {
		File file = new File("src/day20210509/objectEx01/user");
		
		try(ObjectOutputStream out = new ObjectOutputStream(
			new FileOutputStream(file))){
			
			// 파일에 작성할 객체 생성
			User u1 = new User("가렌", 30, 180.5, "소환사협곡1");
			User u2 = new User("럭스", 20, 170.1, "소환사협곡2");
			
			// 파일에 객체를 쓰자
			out.writeObject(u1);
			out.writeObject(u2);
			out.flush();
			
			System.out.println("파일 작성 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
