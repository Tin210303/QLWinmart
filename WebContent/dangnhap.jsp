<%@page import="bo.giohangbo"%>
<%@page import="bean.hangbean"%>
<%@page import="bean.sanphambean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Siêu thị WinMart - Tươi ngon thượng hạng!</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/main.css">
<link rel="icon" href="assets/img/logo.png">
<script src="https://kit.fontawesome.com/ba968237f2.js" crossorigin="anonymous"></script>
</head>
<body style="background-color: #f0f8ff;background-repeat: no-repeat;background-position: center 110px;background-size: 100%;">

<div style="height: 100%; width: 420px; background: #fff; margin: auto; text-align: center; padding: 40px;">
	<div style="margin-top: 40px;display: flex; flex-direction: row; justify-content: space-between; align-items: center;">
		<a href="MenuController">
			<i style="font-size: 20px;color: rgb(51, 51, 51);" class="fa-solid fa-arrow-left"></i>
		</a>
		<a href="MenuController"> 
			<img style="height: 42px;" alt="" src="assets/img/logo1.png">
		</a>
		<a href="MenuController">
			<i style="font-size: 20px;color: rgb(51, 51, 51);" class="fa-solid fa-house"></i>
		</a>
	</div>
	<%if(session.getAttribute("dangky")== null){ %>
	<p style="margin: 40px 0;">Đăng Nhập</p>
	<form action="dangnhapController" method="post">
		        <%if(session.getAttribute("countDangNhap")!=null) {%>
					<%if((int)session.getAttribute("countDangNhap")>=(int)3) { %>
						<input class="form-control form__input" type="text" name="txtun" placeholder="Tên Đăng Nhập"> <br>
						<input style="margin-top: 30px;" class="form-control form__input" type="password" name="txtpass" placeholder="Mật Khẩu"> <br>
						<p class="text-danger"><%=(request.getAttribute("kt")!=null)?request.getAttribute("kt"):"" %> </p>
						<div style="display: flex;align-items: center;justify-content: space-between;">
							<img src="simpleCaptcha.jpg" />
							<input style="height: 30px;width: 120px;" class="form-control form__input" type="text" name="answer" /><br>
						</div>
						<p class="text-danger"><%=(request.getAttribute("ktcc")!=null)?request.getAttribute("ktcc"):"" %> </p>
					<%} else {%>
							<input class="form-control form__input" type="text" name="txtun" placeholder="Tên Đăng Nhập"> <br>
							<input style="margin-top: 30px;" class="form-control form__input" type="password" name="txtpass" placeholder="Mật Khẩu"> <br>
							<p class="text-danger"><%=(request.getAttribute("kt")!=null)?request.getAttribute("kt"):"" %> </p>
					<%} %>
				<%} else { %>
					<input class="form-control form__input" type="text" name="txtun" placeholder="Tên Đăng Nhập"> <br>
					<input style="margin-top: 30px;" class="form-control form__input" type="password" name="txtpass" placeholder="Mật Khẩu"> <br>
					<p class="text-danger"><%=(request.getAttribute("kt")!=null)?request.getAttribute("kt"):"" %> </p>
					
				<%} %>
		      	<div style="padding: 0px 0 165px 0;">
		        	<button type="submit" name="btnlogin" class="btn__test">Đăng Nhập</button>
		        	<div class="d-flex" style="margin-top: 40px;justify-content: space-between; align-items: center;">
			        	<hr style="width:130px;border: 1px solid #000;">
			        	<div style="font-weight: 400;font-size: 13px;">Hoặc</div>
			        	<hr style="width:130px;border: 1px solid #000;">
		        	</div>
		        	<button type="submit"  name="btndangky" class="btn__test1">Đăng Ký</button>
		      	</div>
	</form>
	<%} %>
	<%if(session.getAttribute("dangky")!= null){ %>
	<p style="margin: 40px 0;">Đăng Ký Hội Viên</p>
	 <form action="dangnhapController" method="post">
	        	<input class="form-control form__input" type="text" name="txtht" placeholder="Họ và Tên:" required> <br>
	        	<input style="margin-top: 30px;" class="form-control form__input" type="text" name="txtdc" placeholder="Địa chỉ:" required> <br>
	        	<input style="margin-top: 30px;" class="form-control form__input" type="number" name="txtsdt" placeholder="Số điện thoại:" required> <br>
	        	<input style="margin-top: 30px;" class="form-control form__input" type="email" name="txtemail" placeholder="Email:" required> <br>
				<input style="margin-top: 30px;" class="form-control form__input" type="text" name="txtundk" placeholder="Tên đăng nhập:" required> <br>
				<input style="margin-top: 30px;" class="form-control form__input" type="password" name="txtpassdk" placeholder="Mật khẩu:" required> <br>
				<input style="margin-top: 30px;" class="form-control form__input" type="password" name="txtpassrepeat" placeholder="Nhập Lại Mật khẩu:" required> <br>
				<p class="text-danger"><%=(session.getAttribute("tt")!=null)?session.getAttribute("tt"):"" %> </p>
				<p class="text-danger"><%=(session.getAttribute("tk")!=null)?session.getAttribute("tk"):"" %> </p>
		      	<div class="modal-footer">
		        	<button type="submit" name="btnxacnhandangky" class="btn__test">Đăng ký</button>
		      	</div>
		      	<div class="d-flex" style="margin-top: 40px;justify-content: space-between; align-items: center;">
		        	<hr style="width:130px;border: 1px solid #000;">
		        	<div style="font-weight: 400;font-size: 13px;">Hoặc</div>
		        	<hr style="width:130px;border: 1px solid #000;">
	        	</div>
	</form>
	<form action="dangnhapController"><button type="submit" name="btnbackdn" class="btn__test1">Đăng Nhập</button></form>
	
	<%} %>
</div>

</body>
</html>