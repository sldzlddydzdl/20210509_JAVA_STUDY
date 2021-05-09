package day20210509.readerwriter.ex02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileCopy {
	public static void main(String[] args) {
		// package day20210509.readerwriter.ex01; 패키지 안에 있는
		// FileWriterEx01.java파일을
		// 읽어서 화면에 출력하고
		// 현재패키지에 복사하시오
		
		try(FileReader fr = new FileReader("src/day20210509/readerwriter/ex01/FileWriterEx01.java")){
			
			char[] buf = new char[1024];
			int num = -1;
			while((num = fr.read(buf, 0, buf.length)) != -1) {
				System.out.println(buf);
				try(FileWriter fw = new FileWriter("src/day20210509/readerwriter/ex02/copy.txt")){
					
						fw.write(buf);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			System.out.println("작성완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
