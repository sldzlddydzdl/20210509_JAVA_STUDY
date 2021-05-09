package day20210509.readerwriter.ex01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderEx01 {

	public static void main(String[] args) {
		try(FileReader fr = 
				new FileReader("src/day20210509/readerwriter/ex01/text.txt")){
			
			char[] buf = new char[1024];
			int num = -1;
			while((num = fr.read(buf, 0, buf.length) )!= -1 ) {
				System.out.println(buf);
			}
					
//			while((num = fr.read()) != -1) {
//				System.out.println((char)num);
//			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
