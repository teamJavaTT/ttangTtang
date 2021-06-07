package multipartPreview;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class MultipartPreview {
	//미리보기 파일 삽입
	public String insertPreviewImg(HttpServletRequest request){
		String imageName = "noImage.jsp";
		try {
			//파일 저장 경로
//			ServletContext context = "D:/dev/workspace/git/ttangTtang/ttangTtang/WebContent/ogani-master/product/preview";
			String fileDir =  "D:/dev/workspace/git/ttangTtang/ttangTtang/WebContent/ogani-master/product/preview";

			//파일 저장
			MultipartRequest multi = new MultipartRequest(
					request,  //객체
					fileDir,  //저장경로 
					5 * 1024 * 1024,  //파일 최대 크기
					"UTF-8"   //파일 인코딩
			);
			
			//이미지가 있을 경우, 리턴값 설정
			if(multi.getFilesystemName("image")!=null)
				//저장된 미리보기 파일명 출력
				imageName = multi.getFilesystemName("image");
			
		} catch (Exception e) {
			System.out.println("previewImage err : " + e);
		} 
		return imageName;
	}
	
	//미리보기 파일 삭제
	public void deletePreviewImg(HttpServletRequest request){
		//파일 경로
		ServletContext context = request.getSession().getServletContext();
		String fileDir = context.getRealPath("preview");
		
		//preview 폴더 내용은 유지할 필요가 없기 때문에 상시로 비워줌
		File file = new File(fileDir);
		if(file.isDirectory()){
			for(File f:file.listFiles()){
				f.delete();
			}
		}
	}
}
