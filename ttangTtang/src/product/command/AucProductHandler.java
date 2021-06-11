package product.command;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import auth.model.Category;
import auth.service.MainService;
import mvc.command.CommandHandler;
import product.service.AucProRequest;
import product.service.ProductService;

public class AucProductHandler implements CommandHandler {
	private ProductService ProductService = new ProductService();
	private MainService mainService = new MainService();
	
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/product/aucProductWrite.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
	      List<Category> category = mainService.getCategory();
	      req.setAttribute("category", category);
	      return FORM_VIEW;
   }
	//미리보기 파일 삽입
		public String insertPreviewImg(HttpServletRequest request){
			String imageName = "noImage.jsp";
			try {
				//파일 저장 경로
				ServletContext context = request.getSession().getServletContext();
				String fileDir = context.getRealPath("/ttangTtang/ogani-master/product/preview");

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
		

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
	AucProRequest aucReq= new AucProRequest();
	aucReq.setProduct_name(req.getParameter("product_name"));
	aucReq.setProduct_name(req.getParameter("category"));
	aucReq.setMax_price(req.getParameter("max_price"));
	aucReq.setMin_price(req.getParameter("min_price"));
	aucReq.setDescription(req.getParameter("description"));
	aucReq.setImageface(req.getParameter("imageface"));
	

	return FORM_VIEW;
		
	}
	//상품 수정,상품 삭제 
	
}