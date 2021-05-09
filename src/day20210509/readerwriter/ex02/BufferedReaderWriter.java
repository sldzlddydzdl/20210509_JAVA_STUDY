package day20210509.readerwriter.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderWriter {
	public static void main(String[] args) {
		
		// BufferedReader 는 read 기능을 좀더 편하게 해주는 아이
		// InputStreamReader 는 byte단위로 읽는 아이를 문자단위로 읽는 아이로 변경
		try(BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("src/day20210509/readerwriter/ex01/FileWriterEx01.java"), "utf-8"));
			BufferedWriter bw = new BufferedWriter(
				new FileWriter("src/day20210509/readerwriter/FileWriterEx01.java"))){
			
			String str = null;
			while((str = br.readLine()) != null) {
				System.out.println(str);
				bw.write(str);
				bw.newLine(); // 개행문자를 추가
			}
			bw.flush();
			System.out.println("파일 작성완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
