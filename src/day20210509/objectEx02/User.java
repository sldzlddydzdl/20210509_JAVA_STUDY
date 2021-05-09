package day20210509.objectEx02;

import java.io.Serializable;

// 객체를 파일또는 전송하기 위한 스트림
// 전부다 바이트로 나눠 지게됨

// java.io.NotSerializableException 에러가 나므로
// implements Serializable을 해줘야한다 사용할 클래스에 
public class User implements Serializable{
/**
	 * 
	 */
	// 클래스의 아이디가 생긴거다.
	private static final long serialVersionUID = 3396401537076574096L;
	
	
//	직렬화 Serializable
//	객체가 가진 데이터를 순차적인 데이터로 변환하는 것
	private String name;
	private int age;
	private double height;
	private String address;
	
	public User(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}	

	public User(String name, int age, double height, String address) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", height=" + height + ", address=" + address + "]";
	}


	
}
