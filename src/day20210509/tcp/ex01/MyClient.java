package day20210509.tcp.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		// 클라이언트가 접속할 서버주소와 포트번호를 넣고 소켓객체를 생성.
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("서버에 접속 성공!");
			
			// 인풋 아웃풋을 가져온다
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String msg = br.readLine();
			System.out.println("서버로 부터 문자열을 받음 : " + msg);
			
			bw.write("안녕 서버야 나는 클라이언트야");
			bw.newLine();
			bw.flush();
			
			System.out.println("클라이언트 종료");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(br != null) br.close();
					if(bw != null) bw.close();
					if(socket != null) socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

