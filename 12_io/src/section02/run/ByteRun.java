package section02.run;

import section02.service.ByteService;

public class ByteRun {
	public static void main(String[] args) {
		ByteService service = new ByteService();
		//service.fileByteOutput();
		//service.bufferedFileByteOutput();
//		service.fileByteInput(); // 한글 깨짐
		//service.fileByteInput2(); // 한글 안깨짐
//		service.bufferedFileByteInput(); // 버퍼 파일 입력
		service.fileCopy();
	}
}

