package section02.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteService {
	
	/* Stream(스트림)
	 * - 데이터가 이동하는통로 역할의 객체
	 * - 데이터의 흐름은 기본적으로 단방향
	 */
	
	/* [Byte 기반 스트림]
	 * - 1byte 단위로 데이터를 입/출력하는 스트림
	 * 
	 * - 최상위 클래스 : InputStream, OutputStream
	 * 
	 * - 입/출력 가능 데이터
	 * 문자열, 파일(이미지, 영상, 오디오, pdf 등 모든 파일)
	 * 
	 * * 단, 2byte 범위 문자열 이깨질 수 있고 좁은 통로(1byte)를
	 *   이용하다보니 속도가 상대적으로 느림
	 *  ************************************************************************
	 *  Stream 객체는 Java 프로그램이 종료 되어도 
	 *  외부 장치/파일/프로그램과의 연결이유지되기 떄문에
	 *  자동으로 사라지게 않는다
	 *  -> 프로그램 종료 전 Stream 객체의 메모리를 반환하는 close() 구문 필수
	 *  ************************************************************************* 
	 */
	
	/**
	 * 지정된 경로에
	 * 파일 생성 + 내용 출력(파일 기반 바이트 스트림 이용
	 */
	public void fileByteOutput() {
		FileOutputStream fos = null;
		
	
		try {
			// 폴더 경로, 파일명 지정
			String folderPath = "io_test/byte"; // 프로젝트폴더/io_test/byte
			String fileName = "바이트기반테스트.txt";
			
			// 폴더가 없으면 생성
			File folder = new File(folderPath);
			
			if(folder.exists() == false) {
				folder.mkdirs(); // 폴더 생성		
			}
			
			// 출력할 파일과 연결된 출력용 스트림 객체를 생성
			// -> 이 때, 해당 파일이 없으면 자동으로 생성된다
			fos= new FileOutputStream(folderPath + "/" + fileName);
															// io_test/byte/바이트기반테스트.txt
			
			// txt 파일에 출력할 내용 작성
			
			/* StringBuilder : String 불변성 문제를 해결하기 위한 객체 */
			StringBuilder builder = new StringBuilder();
			
			builder.append("Hello World!!\n");
			builder.append("안녕\n");
			builder.append("#%#$$#\n");
			builder.append("123456\n");
			
			//StringBuilder에 저장된 내용을 String으로 변경
			String content = builder.toString();
			
			/* 연결된 외부 txt파일로 content 내용을 출력*/
			
			// 방법 1) 1byte씩 끊어서 출력
//			for(int i=0; i<content.length(); i++) {
//				
//				char ch = content.charAt(i); // i번째 문자 1개 반환
//				
//				// 바이트 기반 스트림 -> 1바이트 범위만 출력 가능
//				// -> 0~255(바이트 범위) 사이 글자는 정상 출력
//				// 이후 글자(한글 등)은 모두 깨져서 출력
//				
//				fos.write(ch); //IOException 발생 가능성 있음
//				
//			}
			
			// 방법 2) String을 byte로 먼저 변환한 후 
			// 				 손실되는 데이터 없이 출력하기
			byte[] bytes = content.getBytes(); // String -> byte[] 형태로 얻어오기
			
			fos.write(bytes); // 손실되는 데이터 없이 모든 문자열(byte) 출력하기
			
			System.out.println("출력완료");
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null) { 
					fos.close(); // IOException 발생 가능성 있음
				}			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 보조 스트림 중 BufferedOutputStream을 이용해서
	 * 출력 속도 향상시키기
	 */
	
	public void bufferedFileByteOutput() {
		/* 버퍼(buffer)란?
		 * - 데이터가  모아져있는 메모리상의 임시 공간 == 장바구니
		 * -> 한번에 많은 양의 데이터를이동 시켜서 시간 효율을 
		 *    좋아지게 만듦
		 */
		
		/* 스트림 객체 참조 변수 선언 */
		FileOutputStream fos     = null; // 기반 스트림(단독 사용 O)
		BufferedOutputStream bos = null; // 보조 스트림(단독 사용 X)
		// -> 보조 스트림은 꼭 기반 스트림에 붙여서 사용
		
		try {
			/* 기반 스트림 생성 */
			fos = new FileOutputStream("io_test/byte/버퍼_바이트.txt");
			// -> 파일이 없으면 생성됨
			
			/* 보조 스트림 생성 */
			// 보조 스트림 생성 시 기반 스트림과 연결
			 bos = new BufferedOutputStream(fos);
			
			 // """ """ : 내부에 작성된 모양 그대로 문자열 생성<pre>
			 String content = """
I found the way to let you leave
I never really had it coming
I can't be in the sight of you
I want you to stay away from my heart

너희 집 앞으로 가고 있어
빨리 전화 받어
내가, 아파서 죽을 것 같거든?
너 못 보면, 내가 진짜 죽을 것 같애

전화 좀 받아줘 1분만
내 말 좀 들어줘 봐 잠깐만
죽을 것 같애서 난 숨도 못 쉬어
나 좀 살자 제발 한 번만
너의 집 앞에서 네 시간째
찢어지는 내 맘 넌 모른 채
웃고 있니 행복하니
모든 추억과 날 버린 채

아프고 숨이 막히는 침묵
어느새 내 눈물을 가려버린 빗물
머리에서 발끝까지 소름이 끼칠 듯
내 피가 솟구치는 기분
중독된 것처럼
하루종일 온통 고통스런
But she's gone
바라보는 너의 시선 그리워
That's why sing this song

제발 지옥 같은 여기서 날 꺼내줘
이게 꿈이라면 어서 날 깨워줘
모든 것이 다 거짓말이라고 해줘
내게 말해줘 말해줘 나 살 수 있게

I found the way to let you leave
I never really had it coming
I can't be in the sight of you
I want you to stay away from my heart

Every day and night
난 술에 만취
마음이 안심하는 것도 잠시
시간이 약이면 왜 낫질 않지
이럴 순 없어, 이건 사랑의 반칙
미안해, 난 참 욕심이 많아
수면제도 나를 돕지를 않아
밤낮이 바껴 니 생각마다
이리저리 돌아다녀 몸부림치나 봐

하늘이 내게 내린 벌인가
아님 그리 쉽게 나를 버릴까
억지로 누군가를 사랑하며 또 살아갈까
별들 사이를 누비고 내 맘을 노래로 채우고
Don't leave, let me freez
날 좀 도와줘, Help me please

제발 지옥 같은 여기서 날 꺼내줘
이게 꿈이라면 어서 날 깨워줘
모든 것이 다 거짓말이라고 해줘
내게 말해줘 말해줘 나 살 수 있게

I found the way to let you leave
I never really had it coming
I can't be in the sight of you
I want you to stay away from my heart

I don't want you to leave
나를 두고 가지 마
정말 끝이라고 내게 말하지 마
단 하루조차도 너 없인 살 수 없어
I want you back, want you back into my life

I found the way to let you leave
I never really had it coming
I can't be in the sight of you
I want you to stay away from my heart

구름처럼 사라진 꿈
불같던 사랑꾼
죽을 만큼 아픈
나도 너만큼 살길 바랄 뿐

구름처럼 사라진 꿈
불같던 사랑꾼
죽을 만큼 아픈
나도 너만큼 살길 바랄 뿐

하늘이 내게 내린 벌인가
아님 그리 쉽게 나를 버릴까
억지로 누군가를 사랑하며 또 살아갈까
별들 사이를 누비고 내 맘을 노래로 채우고
Don't leave, let me freez
날 좀 도와줘, Help me please

빈집이 되어버린 섬에 넌 날 가둬놨어
난 그 섬에 널 기다리고 있어
죽을 만큼 아프다고 해도
죽을 때까지 기다릴 거야
기다릴 거야 
			 		""";
					 
			 // 보조 스트림을 이용해서 출력
			 // -> 내용 출력 시 버퍼를 이용해서 한 번에 출력
			 // -> 
			 bos.write(content.getBytes());
			 System.out.println("출력 완료");
			 
		}catch(Exception e) { // 다형성 이용해서 모든 예외 처리
			e.printStackTrace();
		}finally {
			// 사용 완료된 스트림 객체 메모리 반환
			
			try {
				if(bos != null) bos.close();
				// 보조 스트림만 close하면
				// 연결된 기반 스트림도 같이 close 된다
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력(파일 읽어오기)
	 */
	
	public void fileByteInput() {
		
		FileInputStream fis = null;
		
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			int value = 0; // 읽어온 1byte를 저장할 임시 변수
			
			// 읽어온 내용 누적용 객체
			StringBuilder sb = new StringBuilder();
			
			while(true) { // 무한 반복
				// int fis.read()
				// - 파일로 부터 1바이트 읽어서 반환
				// - 호출 시 마다 다음 내용을 읽어옴
				// - 읽어올 내용이 없다면 -1 반환
				value = fis.read(); 
				
				
				if(value == -1) break; // 반복 종료
				
				sb.append((char)value); // 문자로 변환해서 누적
			}
			// 읽어온 값 출력
			System.out.println(sb.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 사용 완료된 스트림 객체 메모리 반환(close())
			try {
				if(fis != null) fis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력 2(한글 안깨지게 읽어오기)
	 */
	
	public void fileByteInput2() {
		FileInputStream fis = null;
		
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			// byte[] readAllBytes()
			// - 연결된 파일의 내용을 모두 byte로 변환하여 읽어오기
			// - byte[] 형태로 반환됨
			
			byte[] bytes =fis.readAllBytes();
			
			String content = new String(bytes); // byte[] String에 그대로 저장
			
			System.out.println(content);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 사용 완료된 스트림 객체 메모리 반환(close())
			try {
				if(fis != null) fis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 보조 스트림(BufferedInputStream)을 이용해서
	 * 효율적으로 파일 읽어오기
	 */
	
	public void bufferedFileByteInput() {
		FileInputStream fis = null; // 기반 스트림
		BufferedInputStream bis = null; // 보조 스트림
		
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			// 보조 스트림 생성
			bis = new BufferedInputStream(fis); // 기반 스트림 연결됨
			
			// 보조 스트림을 이용해서
			// 파일 내용 -> 바이트로 변환 -> 버퍼를 이용해 한번에 읽어옴 -> byte[]로 반환
			byte[] bytes = bis.readAllBytes();
			
			String content = new String(bytes); 
			
			System.out.println(content);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 사용 완료된 스트림 객체 메모리 반환(close())
			try {
				if(bis != null) bis.close();
				
				// 보조 스트림만 close해도 연결된 기반 스트림도 close
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// ------------------------------------------------------------------
	
	/** [파일 복사]
	 * <pre>
	 * - 복사할 파일의 경로를 입력 받아
	 * 	 같은 경로에 복사된 파일을 생성
	 * 
	 * - 입력받은 경로에 파일이 존재하지 않으면
	 * -> "파일이 존재하지 않습니다" 출력
	 * 
	 * - 존재하면
	 *  -> 같은 경로에 "파일명_copy.확장자" 이름으로 출력
	 *  
	 *   [실행 화면]
	 *   파일 경로 입력 : io_test/byte/노래가사.txt
	 *   복사 완료 : io_test/byte/노래가사_copy.txt
	 * </pre>
 	 * 
 	 * 
	 */
	public void fileCopy() {
		// 스캐너, 파일 입/출력 스트림, 보조 스트림 참조 변수 선언
		Scanner sc = null;						// 경로 입력용
		FileInputStream fis = null;  // 입력 기반
		FileOutputStream fos = null; // 출력 기반
		
		BufferedInputStream bis = null; // 입력 보조
		BufferedOutputStream bos = null; // 출력 보조
		
		try {
			 sc = new Scanner(System.in);
			 // 1) 파일 경로 입력 받기
			 System.out.print("파일 경로 입력 :"); 
			 String path = sc.nextLine();
			 
			 // 2) 입력받은 경로의 파일과 FileinputStream 연결하기
			 fis = new FileInputStream(path);
			 // -> path에 파일이 없다면 FileNotFoundException 발생 -> catch에서 처리
			 
			 // 3) 보조 입력용 스트림 생성
			 bis = new BufferedInputStream(fis);
			 
			 // 4) 연결된 파일을 byte[] 읽어오기
			 byte[] bytes = bis.readAllBytes(); // == 읽어온 파일
		
			 // 5) 입력 받은 경로 파일명에 _copy 붙이기
			 
			 StringBuilder sb = new StringBuilder();
			 sb.append(path); // 기존 경로 추가
			
			 // 뒤에서부터 검색하여 처음 찾은 "." 위치(index) 반환
			 int insertPoint = sb.lastIndexOf(".");
			 
			 // 찾은 "." 앞에 "_copy" 삽입하기
			 sb.insert(insertPoint, "_copy");
			 
			 // 복사본의 경로
			 String copyPath = sb.toString();
			 
			 // 6) 출력용 기반 스트림 객체 생성
			 fos = new FileOutputStream(copyPath);
			 
			 // 7) 출력용 보조 스트림 객체 생성
			 bos = new BufferedOutputStream(fos);
			 
			 // 8) 보조 스트림을 이용해서 출력하기
			 bos.write(bytes); // 읽어온 파일 출력하기
			 
			 System.out.println("복사 완료 : " + copyPath);
			 
		}catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			// 스트림 객체 메모리 반환
			try {
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				if(sc != null) sc.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
