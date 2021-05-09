package day20210509.objectEx02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputStreamEx01 {
	public static void main(String[] args) {
		
		try(ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("src/day20210509/objectEx02/userlist"))){
			
			List<User> userlist = new ArrayList<>(); 
			userlist = (List<User>) in.readObject();
			
			int sum  = 0;
			for(User u : userlist) {
				sum += u.getAge();
			}
			
			System.out.println(sum);
			
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
