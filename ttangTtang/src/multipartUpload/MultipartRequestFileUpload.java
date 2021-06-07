package multipartUpload;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MultipartRequestFileUpload {
	public boolean fileUpload(HttpServletRequest request){
		boolean b = false;
		try {
			//저장할 위치 설정
			String uploadDir = "C:/sou/000_tip/java/multipartRequestFileUpload";
			
			//multipartRequest객체 생성
			MultipartRequest multi = new MultipartRequest(
					request, //저장할 파일
					uploadDir, //저장할 위치
					5 * 1024 * 1024, //파일 최대 크
					"UTF-8", //파일 인코딩
					new DefaultFileRenamePolicy()); //중복 파일 처리 인터페이스
			
			//request에서  name이 image인 데이터를 저장하고, image가 null이 아닐경우 b는 true
			if(multi.getFilesystemName("image")!=null) b=true;
			
		} catch (Exception e) {
			System.out.println("multipartrequestfileupload err : " + e);
		}
		return b;
	}
}
