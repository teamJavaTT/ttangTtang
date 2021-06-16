package file;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ImageServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		//파일이 저장되는 경로
		String path = "C:/dev/workspace/git/ttangTtang/ttangTtang/WebContent/file";

		int size = 1024 * 1024 * 10;//파일 용량 10M
		String file = "";//업로드 한 파일의 이름
		String originalFile = "";//이름이 변경되기 전 파일이름

		try {
			MultipartRequest multi = new MultipartRequest(req, path, size, "utf-8", new DefaultFileRenamePolicy());
			
			Enumeration<?> files = multi.getFileNames();
			String str = (String) files.nextElement();//파일 이름을 받아와 String으로 저장
			
			file = multi.getFilesystemName(str);//업로드 된 파일 이름 가져옴
			originalFile = multi.getOriginalFileName(str);//원래의 파일 이름 가져옴
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		res.setCharacterEncoding("UTF-8");
		java.io.PrintWriter pw = res.getWriter();
        pw.print(file);
    }
}

