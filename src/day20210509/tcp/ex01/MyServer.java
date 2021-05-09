package day20210509.tcp.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		//Socket은 전화기 하나와 같다.
		
		// 외부에서 접속하기를 기다려주는 역할
		try {
			// 서버소캣을 생성
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println("서버 소캣 생성");
			// 접속을 기다린다
			System.out.println("접속 대기중...");
			// 접속 대기
			// 접속대기중 접속이 생기면 상대방과 연결된 socket 객체를 반환해준다.
		    Socket socket = serverSocket.accept();
			System.out.println("접속!!");
			
		    //상대방과 연결된 인풋스트림, 아웃풋스트림을 가져온다. 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			bw.write("서버에 접속 되었다 !!");
			bw.newLine();
			bw.flush();
			System.out.println("클라이언트에게 메시지를 보냈음.");
			String msg = br.readLine();
			System.out.println("클라이언트에게 받은 메시지 : " + msg);
			
			System.out.println("서버종료");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
