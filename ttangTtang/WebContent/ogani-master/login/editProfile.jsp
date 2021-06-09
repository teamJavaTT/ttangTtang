<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="css/joinmain.css">


	<!-- header -->
	<div id="header">
		<a href="#"><img src="" alt=""></a>
	</div>


	<!-- wrapper -->
	<div id="wrapper">

		<!-- content-->
		<div id="content">

			<!-- ID -->
			<div>
				<h3 class="join_title">
					<label for="id">아이디</label>
				</h3>
				<span class="box int_id"> <input type="text" id="id"
					class="int" maxlength="20" disabled>

				</span> <span class="error_next_box"></span>
			</div>

			<!-- OLDPW -->
			<div>
				<h3 class="join_title">
					<label for="oldpw">현재 비밀번호</label>
				</h3>
				<span class="box int_pass"> <input type="text" id="pswd1"
					class="int" maxlength="20"> <span id="alertTxt">비밀번호를 확인하세요</span>
				</span> <span class="error_next_box"></span>
			</div>
					
			<!-- NEWPW -->
			<div>
				<h3 class="join_title">
					<label for="newpw">새 비밀번호</label>
				</h3>
				<span class="box int_pass"> <input type="text" id="pswd1"
					class="int" maxlength="20"> <span id="alertTxt">사용불가</span>
					<img src="../login/images/m_icon_pass.png" id="pswd1_img1"
					class="pswdImg">
				</span> <span class="error_next_box"></span>
			</div>
			<!-- NEWPW2 -->
			<div>
				<h3 class="join_title">
					<label for="newpw2">새 비밀번호 확인</label>
				</h3>
				<span class="box int_pass_check"> <input type="text"
					id="pswd2" class="int" maxlength="20"> <img
					src="../login/images/m_icon_check_disable.png" id="pswd2_img1"
					class="pswdImg">
				</span> <span class="error_next_box"></span>
			</div>

			<!-- NAME -->
			<div>
				<h3 class="join_title">
					<label for="name">이름</label>
				</h3>
				<span class="box int_name"> <input type="text" id="name"
					class="int" maxlength="20">
				</span> <span class="error_next_box"></span>
			</div>

			<!-- BIRTH -->
			<div>
				<h3 class="join_title">
					<label for="yy">생년월일</label>
				</h3>

				<div id="bir_wrap">
					<!-- BIRTH_YY -->
					<div id="bir_yy">
						<span class="box"> <input type="text" id="yy" class="int"
							maxlength="4" placeholder="년(4자)" disabled>
						</span>
					</div>

					<!-- BIRTH_MM -->
					<div id="bir_mm">
						<span class="box"> <input type="text" id="mm" class="int"
							maxlength="2" placeholder="월" disabled>
						</span>
					</div>

					<!-- BIRTH_DD -->
					<div id="bir_dd">
						<span class="box"> <input type="text" id="dd" class="int"
							maxlength="2" placeholder="일" disabled>
						</span>
					</div>

				</div>
				<span class="error_next_box"></span>
			</div>

			<!-- GENDER -->
			<div>
				<h3 class="join_title">
					<label for="gender">성별</label>
				</h3>
				<span class="box gender_code">  
				<input type="text" id="sex" class="int" maxlength="20" disabled>
				</span> <span class="error_next_box">필수 정보입니다.</span>
			</div>


			  <!-- EMAIL -->
                <div>
                    <h3 class="join_title"><label for="email">본인확인 이메일<span class="optional">(선택사항)</span></label></h3>
                    <span class="box int_email">
                        <input type="text" id="email" class="int" maxlength="100" placeholder="선택입력">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>
                
                
			<!-- MOBILE -->
			<div>
				<h3 class="join_title">
					<label for="phoneNo">휴대전화</label>
				</h3>
				<span class="box int_mobile"> <input type="tel" id="mobile"
					class="int" maxlength="16" placeholder="전화번호 입력">
				</span> <span class="error_next_box"></span>
			</div>


			<!-- JOIN BTN-->
			<div class="btn_area">
				<button type="button" id="btnJoin">
					<span>정보 수정 완료</span>
				</button>
			</div>

		</div>
		<!-- content-->
	</div>
	<!-- wrapper -->
	
<script src="js/joinmain.js"></script>
						
	<%@ include file="../include/footer.jsp" %>

				
			





			
