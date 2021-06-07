<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="multipartPreview" class="multipartPreview.MultipartPreview"/>
<%
	//미리보기 폴더 비우기
	multipartPreview.deletePreviewImg(request);
	//미리보기 폴더에 이미지 업로드
	String imageName = multipartPreview.insertPreviewImg(request);
	//업로드된 이미지 파일명 출력
	out.println(imageName);

%>


<!-- D:\dev\workspace\jsp\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\ttangTtang\preview -->