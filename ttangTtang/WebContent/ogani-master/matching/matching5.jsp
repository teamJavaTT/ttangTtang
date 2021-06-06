<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="utf-8">
<meta name="viewport" content="text/html; charset=utf-8">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="custom.css">

<title>채팅창</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>


	<%
		//userID를 초기화 해주고 session에서 userID값을 가져옵니다. 만약에 null이 아니라면 userID에서 가져온 userID값을 넣어줍니다.
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	%>
	<!-- 부트스트랩을 이용하여 메뉴를 만들어 주도록한다. -->
	<nav class="navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle cooapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="matching4.jsp">채팅창</a>

		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="../index.jsp">메인</a>
			</ul>
			<% // userID가 null이면 로그인이 되지않는 경우
					if(userID == null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expand="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="../login/login.jsp">로그인</a>
						<li><a href="../login/join.jsp">회원가입</a>
					</ul></li>
			</ul>
			<% // userID가 null이 아닐 경우 로그인이 되었다는 것.
					} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expand="false">회원가입<span class="caret"></span></a></li>
			</ul>
			<% 
				}
			%>
		</div>
	</nav>
	<div class="container bootstrap snippet">
		<div class="row">
			<div class="col-xs-12">
				<div class="portlet portlet-default">
					<div class="portlet-heading">
						<div class="portlet-title">
							<h4>
								<i class="fa fa-circle text-green"></i>실시간 채팅창
							</h4>
						</div>
						<div class="clearfix"></div>
					</div>

					<div id="chat" class="panel-collapse collapse in">

						<div id="chatList" class="portlet-body chat-widget" style="">
						</div>

						<div class="potlet-footer">
							<div class="row">
								<div class="formgroup col-xs-4">
									<input style="height: 40px;" type="text" id="chatName"
										class="form-control" placeholder="이름" maxlength="8">

								</div>
							</div>
							<div class="row" style="height: 90px;">
								<div class="form-grop col-xs-10">
									<textarea style="height: 80px;" id="chatContent"
										class="form-control" placeholder="메시지를 입력하세요." maxlength="100"></textarea>
								</div>
								<div class="form-grop col-xs-2">
									<button type="button" class="btn btn-default pull-right"
										onclick="submitFunction();">전송</button>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="alert alert-success" id="succesMessage"
		style="display: none;">
		<strong>메시지 전송에 성공하였습니다.</strong>
	</div>
	<div class="alert alert-danger" id="dangerMessage"
		style="display: none;">
		<strong>이름과 내용을 모두 입력해 주세요.</strong>
	</div>
	<div class="alert alert-warning" id="warningMessage"
		style="display: none;">
		<strong>데이터베이스 오류가 발생하였습니다.</strong>
	</div>
	<%
			// 서버로부터 내용을 받아왔는지 확인.
	String messageContent = null;
	if(session.getAttribute("messageContent") != null){
		messageContent = (String) session.getAttribute("messageContent");
	}
	String messageType = null;
	if(session.getAttribute("messageType") != null){
		messageType = (String) session.getAttribute("messageType");
	}
	if(messageContent != null) {
		
	%>
	<!-- 모달창 -->
	<div class="model fade" id="messageModel" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="vertical-alignment-helper">
			<div class="modal-dialog vertical-align-center">
				<div
					class="modal-content <%if (messageType.equals("오류 메시지"))out.println("panel-warning"); 
				else out.println("panel-success");%>">

					<div class="modal-header panel-heading">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times</span>
							<!-- bootstrap sr-only: 화면상에 출력하지 않음 -->
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">
							<%=messageType%>
						</h4>
					</div>
					<div class="modal-body">
						<%=messageContent%>
					</div>
					<div class="modal-footer">
						<!-- data-dissmiss="modal" 자바스크립트에 의해 닫기 역활을 하는 속성-->
						<button type="button" class="btn btn-primary"
							data-dissmiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#messageModal').modal("show");
	</script>
	<%
			session.removeAttribute("messageContent");
			session.removeAttribute("messageType");
	}
	%>

	<div id="containar"></div>











</body>