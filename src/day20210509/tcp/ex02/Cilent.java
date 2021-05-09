package day20210509.tcp.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cilent {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Socket socket = new Socket("127.0.0.1" , 1234);
			System.out.println("서버 접속 성공!");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
			String str = "";
			System.out.println("1 을 입력하면 종료!");
			while(str != "1") {
				String msg = br.readLine();
				System.out.println("서버로 부터 문자열을 받음 : " + msg);
				System.out.print("서버에 보낼 메시지 입력 : ");
				str = sc.next();
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			
			System.out.println("클라이언트 종료");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
