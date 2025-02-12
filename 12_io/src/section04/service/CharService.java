package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharService {

	/* [문자 기반 스트림]
	 * 
	 * - 2byte 문자(char) 단위로 입/출력하는 스트림
	 * 
	 * - 문자만 작성된 파일(txt, bin 등), 채팅, JSON,웹 요청(주소)/ 응답(HTML)
	 * 
	 * - 문자 기반 스트림 최상위 인터페이스 : Reader(입력) , Writer(출력)
	 */
	
	/** 문자 기반 스트림을 이용한 파일 출력 */
	
	public void fileOutput1() {
		FileWriter fw = null;
		 
		try {
			String content = """
			[다비치 - 거북이]
거북아 그 속도론 멀리 못 도망가
게다가 그길은 더 멀고 험하잖아
상처가 아물고 다 나으면 떠나가
진심이야 그럼 그 때 보내 줄 테니까
숨지마 차라리 내 맘을 훔치지마
거짓말 느리고 느린 너의 걸음마
내 가슴 깊이 하는 말
내게로 와요

마음을 둘 곳도 없고 더 갈 곳도 없는
슬픈 거북이 한 마리
상처가 많아 너 혼자서
매일 외롭게 숨는 거니
너를 지킬 수 없고 더 사랑도 없는
내 가슴 아픈 이야기
조금 늦어도 좋아
한 걸음 한 걸음 천천히

하루만 더 지나면 괜찮아질거야
자꾸만 주문처럼 외우는 혼잣말
거북아 널 볼 때면 내 모습 같아
눈물 나 미친 듯이 계속 흘러나와

새싹이 나겠지 꽃이 보이겠지
내 눈물의 사랑은 씨앗을 꼭 품겠지
내 가슴 깊이 하는 말
내게로 와요

마음을 둘 곳도 없고 더 갈 곳도 없는
슬픈 거북이 한 마리
상처가 많아 너 혼자서
매일 외롭게 숨는 거니
너를 지킬 수 없고 더 사랑도 없는
내 가슴 아픈 이야기
조금 늦어도 좋아
한걸음한걸음 천천히
나보다 느린 네 발걸음에 맞춰 걸으며
더 이상 너 혼자 울지 않도록
you're always be my
always be my love

마음을 둘 곳도 없고 더 갈 곳도 없는
슬픈 거북이 한 마리(제발 날 떠나지마)
상처가 많아 너 혼자서
매일 외롭게 숨는 거니
너를 지킬 수 없고 더 사랑도 없는
내 가슴 아픈 이야기
조금 늦어도 좋아
한걸음 한 걸음 천천히
					""";
			// 폴더가 없을 경우 생성
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "다비치 - 거북이.txt");
			
			// 문자 기반 스트림을 이용해서 출력하기
			fw.write(content); // String, char[] 출력을 위한 기능이 제공됨
			
			// 스트림에 남은 데이터를 밀어냄
			fw.flush(); // close() 시 자동 수행됨
			System.out.println("출력 완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null)fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 문자 기반 스트림 + 보조 스트림을 이용한 파일 출력 */
	
	public void fileOutput2() {
		FileWriter fw = null;
		BufferedWriter bw = null; // 버퍼를 이용한 보조 스트림 
		try {
			String content = """
			[다비치 - 거북이]
거북아 그 속도론 멀리 못 도망가
게다가 그길은 더 멀고 험하잖아
상처가 아물고 다 나으면 떠나가
진심이야 그럼 그 때 보내 줄 테니까
숨지마 차라리 내 맘을 훔치지마
거짓말 느리고 느린 너의 걸음마
내 가슴 깊이 하는 말
내게로 와요

마음을 둘 곳도 없고 더 갈 곳도 없는
슬픈 거북이 한 마리
상처가 많아 너 혼자서
매일 외롭게 숨는 거니
너를 지킬 수 없고 더 사랑도 없는
내 가슴 아픈 이야기
조금 늦어도 좋아
한 걸음 한 걸음 천천히

하루만 더 지나면 괜찮아질거야
자꾸만 주문처럼 외우는 혼잣말
거북아 널 볼 때면 내 모습 같아
눈물 나 미친 듯이 계속 흘러나와

새싹이 나겠지 꽃이 보이겠지
내 눈물의 사랑은 씨앗을 꼭 품겠지
내 가슴 깊이 하는 말
내게로 와요

마음을 둘 곳도 없고 더 갈 곳도 없는
슬픈 거북이 한 마리
상처가 많아 너 혼자서
매일 외롭게 숨는 거니
너를 지킬 수 없고 더 사랑도 없는
내 가슴 아픈 이야기
조금 늦어도 좋아
한걸음한걸음 천천히
나보다 느린 네 발걸음에 맞춰 걸으며
더 이상 너 혼자 울지 않도록
you're always be my
always be my love

마음을 둘 곳도 없고 더 갈 곳도 없는
슬픈 거북이 한 마리(제발 날 떠나지마)
상처가 많아 너 혼자서
매일 외롭게 숨는 거니
너를 지킬 수 없고 더 사랑도 없는
내 가슴 아픈 이야기
조금 늦어도 좋아
한걸음 한 걸음 천천히
					""";
			// 폴더가 없을 경우 생성
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 스트림 객체 생성
			fw = new FileWriter(folder + "/" + "다비치 - 거북이_buffer.txt");
			
			// 보조 스트림 객체 생성
			bw = new BufferedWriter(fw);
			
			// 문자 기반 스트림을 이용해서 출력하기
			bw.write(content); // String, char[] 출력을 위한 기능이 제공됨
			
			// 스트림에 남은 데이터를 밀어냄
			bw.flush(); // close() 시 자동 수행됨
			System.out.println("출력 완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null)bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 문자 기반 입력 스트림 + 보조 스트림 읽어오기
	 */
	public void fileInput() {
		
		/* [try- with - resource]
		 * - 자바 7버전에서 추가된 기능
		 * - finally에서 작성하던 close 처리 구문을
		 * 자동으로 수행하도록 만드는 구문
		 */
		
		String path = "io_test/char/다비치 - 거북이.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			// 보조 스트림을 이용해서 파일 내용 읽어오기
			StringBuilder sb = new StringBuilder(); // 읽어온 내용 누적
			String temp = null; //임시 변수
			
			while(true) {
			temp = br.readLine(); // 한 줄씩 읽어오기
			
			if(temp == null) break; // 읽어온 내용이 없으면 반복 종료
			sb.append(temp);
			sb.append("\n"); // 엔터 추가
			}
			System.out.println("읽어오기 성공");
			System.out.println(sb.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		// finally에서 close 하던 구문생략 가능
	}
	
	// Scanner 대신 스트림을 이용한 문자열 입력 받기
	// -> Scanner가 편리하긴 한데 매우 느림
	// 키보드 입력 -> 바이트(2진수) 코드 입력 -> 문자 변화
	
	public void keyboardinput() {
		
		// System.in : 기본 장치(키보드)와 연결된 InputStream 반환
		// InputStreamReader : 바이트 스트림 -> 문자 스트림 반환
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			// Reader(문자기반)                       바이트 기반
		
			System.out.println("문자열 입력1 : ");
			String input1 = br.readLine(); // 입력된 한줄 읽어오기

			System.out.println("문자열 입력2 : ");
			String input2 = br.readLine(); // 입력된 한줄 읽어오기
			System.out.println("input1 : "+ input1);
			System.out.println("input2 : "+ input2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
