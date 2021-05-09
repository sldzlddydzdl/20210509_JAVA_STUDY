package day20210509.tcp.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	// 사용자가 글자를 작성해서 보낼 수 있도록 구현.
	// 반복문을 이용해서 글자를 보낼수 있도록
	
	// 서버가 읽고 <- 클라이언트가 쓰고
	// 클라이언트가 읽고 <- 서버가 쓰고
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			
			System.out.println("접속 대기중....");
			
			Socket socket = serverSocket.accept();
			System.out.println("접속!");
			
			
			Thread thread1 = new Thread() {
				@Override
				public void run() {
					BufferedWriter bw;
					try {
						String str = "";
						System.out.print("클라이언트에게 보낼 메세지 : ");
						str = sc.next();
						bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
						bw.write(str);
						bw.newLine();
						bw.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			thread1.start();
			
			Thread thread2 = new Thread() {
				public void run() {
					BufferedReader br;
					try {
						String msg;
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						msg = br.readLine();
						System.out.println("클라이언트에게 받은 메세지 : " + msg);					
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			};
			
			thread2.start();
			
			System.out.println("서버종료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
