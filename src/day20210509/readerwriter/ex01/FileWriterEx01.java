package day20210509.readerwriter.ex01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx01 {
	public static void main(String[] args) {
		
		try(FileWriter fw = 
			new FileWriter("src/day20210509/readerwriter/ex01/text.txt")){
			
			fw.write("안녕하세요 filewriter 로 작성하고 있어요");
			fw.write("\n");
			fw.write("두 번째 줄");
			
			System.out.println("작성완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


