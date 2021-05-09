package day20210509.objectEx01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx01 {
	public static void main(String[] args) {
		// 파일에 작성된 객체를 읽어오자
		File file = new File("src/day20210509/objectEx01/user");
		
		try(ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(file))){
			
			User u1 = (User)in.readObject();
			User u2 = (User)in.readObject();
			
			System.out.println(u1);
			System.out.println(u2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
