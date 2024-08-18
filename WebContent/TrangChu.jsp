<%@page import="bo.giohangbo"%>
<%@page import="bean.khachhangbean"%>
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
<link rel="icon" href="assets/img/logo1.png">
<script src="https://kit.fontawesome.com/ba968237f2.js" crossorigin="anonymous"></script>
</head>
<body>
<%
	long slm=0;
	String diachi = "";
	String tenkh="";
	long makh = 0;
	khachhangbean kh= (khachhangbean)session.getAttribute("dn");
	if(session.getAttribute("dn") != null) {
		if(session.getAttribute("gh") != null) {
			giohangbo ghb= new giohangbo();
			ghb= (giohangbo)session.getAttribute("gh");
			slm= ghb.ds.size();
		}
		khachhangbean khb = (khachhangbean)session.getAttribute("dn");
		diachi = khb.getDiachi();
		tenkh= khb.getHoten();
		makh = khb.getMakh();
	}
	
%>
<div id="nav">
	<div class="ctheader">
		<header>
			<div class="header-leftmenu">
			<a href="MenuController"><img alt="" src="assets/img/logo.png" class="header-logo_img"> </a>
				<div class="header-leftmenu_input">
					<i class="fa-solid fa-magnifying-glass header-logo-icon"></i>
					<form action="MenuController"> 
							<input name="searchinput" placeholder="Giao nhanh 2h, Giảm thêm 20% Rau WinEco & Thịt MeatDeli" class="header-logo__input">
					</form>
				</div>
			</div>
			
			<div class="header-rightmenu">
				<div class="location-menu">
					<i class="fa-solid fa-location-dot location-icon"></i>
					<div class="location-des">
						<h1 class="location-des-top">Giao hàng</h1>
						<%if(session.getAttribute("dn")!= null){%>
							<p class="location-des-bot"><%=diachi %></p>
						<%} %>
						<%if(session.getAttribute("dn")== null){ %>
							<p class="location-des-bot">Địa chỉ</p>
						<%} %>
						
					</div>
				</div>
				<div class="cart-menu">
					<i class="fa-solid fa-cart-plus cart-icon"></i>
					<a href="htgioController" class="cart-title">Giỏ hàng (<%=slm %>) </a>
				</div>
				<div class="login-menu">
					<%if(session.getAttribute("dn")!=null){%>
						<span style="color: #fff;margin-left: 10px;"><%=tenkh %> </span>
						<div class="donhang">
							<center>
								<button class="donhang-btn"> 
									<a style="text-decoration: none;color: #000;font-size: 18px;" href="donhangController?makh=<%=makh%>">Đơn Hàng</a>
								</button>
								<form action="dangxuat.jsp" method="post">
									<button style="font-size: 18px;color: #000;font-weight: 400;margin: 0;" class="login-btn" name="buttonDangXuat">Đăng Xuất</button>
								</form>
							</center>
						</div>
					<%}%>
					<%if(session.getAttribute("dn")==null){%>
						<i class="fa-solid fa-user user-icon"></i>
						<form action="dangnhapController" method="post"><button class="login-btn" name="buttonDangNhap">Hội viên</button></form>
					<%}%>
					
					
				</div>
			</div>
		</header>
		
		<div class="nav-bar">
			<div class="nav-container">
				<div class="dropdown">
					<a class="btn btn-secondary dropdown-toggle drop-btn" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<i class="fa-solid fa-bars nav-menu"></i>
					  	Danh mục sản phẩm
					</a>
					
					<ul class="dropdown-menu">
						<%
						request.setCharacterEncoding("utf-8");
						response.setCharacterEncoding("utf-8");
							ArrayList<loaibean> dsloai= (ArrayList<loaibean>)request.getAttribute("dsloai");
							for(loaibean l: dsloai) {
						%>
							<li>
								<a class="dropdown-item sub-nav-hover" href="MenuController?ml=<%=l.getMaloai() %>"><%=l.getTenloai() %></a>
						<%} %>
							</li>
					</ul>
					<%ArrayList<sanphambean> dssanpham= (ArrayList<sanphambean>)request.getAttribute("dssanpham");
						if(dssanpham != null){
							int n= dssanpham.size();%>
							<div class="sub-nav-container" style="background-color: white; ">
								<ul class="sub-nav-list">
									<%for(int i=0; i<n; i++) {
										sanphambean sp= dssanpham.get(i); %>
										<li class="sub-nav-item"> 
											<a class="dropdown-item" href="MenuController?msp=<%=sp.getMasp()%>"><%=sp.getTensp() %></a>
										</li>
									<%} %>
								</ul>
							</div>
						<%}%>
				</div>
				<div class="nav-bar-noti">
					<div class="nav-bar-noti__news">
						<i class="fa-regular fa-envelope news-icon"></i>
						<a href="https://winmart.vn/tin-tuc" class="noti-text" style="margin: 0; text-decoration: none;">Tin tức VinMart</a>
					</div>
					<div class="nav-bar-noti__news">
						<i class="fa-solid fa-headphones news-icon"></i>
						<p class="noti-text">Tư vấn mua hàng</p>
						<div class="inner-wrap">
							<div style="padding: 1rem; display: flex; flex-direction: row; justify-content: space-between;">
								<p>Mua online:</p>
								<div style="color: blue; font-weight: bold;">
									<a href="tel:+842471066866" style="text-decoration: none; color: #000;">
										<div>024 71066866</div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="promotion">
	<div id="carouselExampleInterval" class="carousel slide promotion-slide" data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="10000">
				<img src="assets/img/slide1.png" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item" data-bs-interval="2000">
				<img src="assets/img/slide2.png" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="assets/img/slide3.jpg" class="d-block w-100" alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Next</span>
		</button>
	</div>
	
	<div class="nexttoslide">
		<img class="nexttoslide-img1" alt="" src="assets/img/nexttoslide.png">
		<img class="nexttoslide-img2" alt="" src="assets/img/nexttoslide2.png">
	</div>
</div>

<div class="product">
	<div class="product-header">
		<p style="font-size: 18px;font-weight: 600;">Hàng Hiệu Giảm Sốc</p>
		<p style="font-size: 13px;font-weight: bold;">
			Đặt hàng ngay, đơn hàng sẽ đến lúc 
			<span style="color: rgb(235, 31, 58);font-weight: bold;">08:00 - 10:00, Ngày mai</span>
		</p>
	</div>
	<table class="table">
					<%
					//Gởi lên và trả về kiểu dữ liệu tiếng việt
					request.setCharacterEncoding("utf-8");
					response.setCharacterEncoding("utf-8");
					
					ArrayList<hangbean> dshang= (ArrayList<hangbean>)request.getAttribute("dshang");
					int m= dshang.size();
					for(int i=0; i<m; i++) {
						hangbean s= dshang.get(i); %>
						<tr >
							<td class="contentPage">
								<div class="card" style="height:400px; width:216px;box-shadow: rgba(153, 153, 153, 0.6) 0px 0px 5px 0px;">
									<img style="width: 190px;height:190px;margin: 12.2px;" alt="" src="<%=s.getAnh() %>">
									<div class="card-body" style="padding-top: 0;width: 214px;height: 183px;">
										<p style="width:182px;height:62px;font-size: 14px;margin-bottom: 4px;" class="card-title"><%=s.getTenhang() %> </p> 
										<p style="font-size: 14px;margin-bottom: 8px;" class="">ĐVT: <%=s.getDVT() %> </p> 
										<p style="color: rgb(237, 28, 36); font-size: 16px;font-weight: bold;" class=""><%=s.getGia() %> đ</p> 
										<a class="cart-link" href="chitiethangController?mh=<%=s.getMahang()%>&th=<%=s.getTenhang()%>&gia=<%=s.getGia()%>&dvt=<%=s.getDVT() %>&sl=<%=s.getSoluong()%>&anh=<%=s.getAnh()%>">
											<p class="addcart">Thêm vào giỏ</p>
										</a>
									</div>
								</div>
							</td>
							<%i++; if(i<m){
								s=dshang.get(i); %>
								<td class="contentPage">
									<div class="card" style="height:400px; width:216px;box-shadow: rgba(153, 153, 153, 0.6) 0px 0px 5px 0px;">
										<img style="width: 190px;height:190px;margin: 12.2px;" alt="" src="<%=s.getAnh() %>">
										<div class="card-body" style="padding-top: 0;width: 214px;height: 183px;">
											<p style="width:182px;height:62px;font-size: 14px;margin-bottom: 4px;" class="card-title"><%=s.getTenhang() %> </p> 
											<p style="font-size: 14px;margin-bottom: 8px;" class="">ĐVT: <%=s.getDVT() %> </p> 
											<p style="color: rgb(237, 28, 36); font-size: 16px;font-weight: bold;" class=""><%=s.getGia() %> đ</p> 
											<a class="cart-link" href="chitiethangController?mh=<%=s.getMahang()%>&th=<%=s.getTenhang()%>&gia=<%=s.getGia()%>&dvt=<%=s.getDVT() %>&sl=<%=s.getSoluong()%>&anh=<%=s.getAnh()%>">
												<p class="addcart">Thêm vào giỏ</p>
											</a>
										</div>
									</div>
								</td>
							<%} %>
							<%i++; if(i<m){
								s=dshang.get(i); %>
								<td class="contentPage">
									<div class="card" style="height:400px; width:216px;box-shadow: rgba(153, 153, 153, 0.6) 0px 0px 5px 0px;">
										<img style="width: 190px;height:190px;margin: 12.2px;" alt="" src="<%=s.getAnh() %>">
										<div class="card-body" style="padding-top: 0;width: 214px;height: 183px;">
											<p style="width:182px;height:62px;font-size: 14px;margin-bottom: 4px;" class="card-title"><%=s.getTenhang() %> </p> 
											<p style="font-size: 14px;margin-bottom: 8px;" class="">ĐVT: <%=s.getDVT() %> </p> 
											<p style="color: rgb(237, 28, 36); font-size: 16px;font-weight: bold;" class=""><%=s.getGia() %> đ</p> 
											<a class="cart-link" href="chitiethangController?mh=<%=s.getMahang()%>&th=<%=s.getTenhang()%>&gia=<%=s.getGia()%>&dvt=<%=s.getDVT() %>&sl=<%=s.getSoluong()%>&anh=<%=s.getAnh()%>">
												<p class="addcart">Thêm vào giỏ</p>
											</a>
										</div>
									</div>
								</td>
							<%} %>
							<%i++; if(i<m){
								s=dshang.get(i); %>
								<td class="contentPage">
									<div class="card" style="height:400px; width:216px;box-shadow: rgba(153, 153, 153, 0.6) 0px 0px 5px 0px;">
										<img style="width: 190px;height:190px;margin: 12.2px;" alt="" src="<%=s.getAnh() %>">
										<div class="card-body" style="padding-top: 0;width: 214px;height: 183px;">
											<p style="width:182px;height:62px;font-size: 14px;margin-bottom: 4px;" class="card-title"><%=s.getTenhang() %> </p> 
											<p style="font-size: 14px;margin-bottom: 8px;" class="">ĐVT: <%=s.getDVT() %> </p> 
											<p style="color: rgb(237, 28, 36); font-size: 16px;font-weight: bold;" class=""><%=s.getGia() %> đ</p> 
											<a class="cart-link" href="chitiethangController?mh=<%=s.getMahang()%>&th=<%=s.getTenhang()%>&gia=<%=s.getGia()%>&dvt=<%=s.getDVT() %>&sl=<%=s.getSoluong()%>&anh=<%=s.getAnh()%>">
												<p class="addcart">Thêm vào giỏ</p>
											</a>
										</div>
									</div>
								</td>
							<%} %>
							<%i++; if(i<m){
								s=dshang.get(i); %>
								<td class="contentPage">
									<div class="card" style="height:400px; width:216px;box-shadow: rgba(153, 153, 153, 0.6) 0px 0px 5px 0px;">
										<img style="width: 190px;height:190px;margin: 12.2px;" alt="" src="<%=s.getAnh() %>">
										<div class="card-body" style="padding-top: 0;width: 214px;height: 183px;">
											<p style="width:182px;height:62px;font-size: 14px;margin-bottom: 4px;" class="card-title"><%=s.getTenhang() %> </p> 
											<p style="font-size: 14px;margin-bottom: 8px;" class="">ĐVT: <%=s.getDVT() %> </p> 
											<p style="color: rgb(237, 28, 36); font-size: 16px;font-weight: bold;" class=""><%=s.getGia() %> đ</p> 
											<a class="cart-link" href="chitiethangController?mh=<%=s.getMahang()%>&th=<%=s.getTenhang()%>&gia=<%=s.getGia()%>&dvt=<%=s.getDVT() %>&sl=<%=s.getSoluong()%>&anh=<%=s.getAnh()%>">
												<p class="addcart">Thêm vào giỏ</p>
											</a>
										</div>
									</div>
								</td>
							<%} %>
						</tr>
					<% }%>
				</table>
</div>

<footer>
	<div class="footer-top">
		<div class="footer-top-content">
			<div class="footer-top-items">
				<img alt="" src="assets/img/spat.png">
				<p class="about-us" style="margin-top: 8px;">Sản phẩm an toàn</p>
			</div>
			<div class="footer-top-items">
				<img alt="" src="assets/img/clck.png">
				<p class="about-us" style="margin-top: 8px;">Chất lượng cam kết</p>
			</div>
			<div class="footer-top-items">
				<img alt="" src="assets/img/dvvt.png">
				<p class="about-us" style="margin-top: 8px;">Dịch vụ an toàn</p>
			</div>
			<div class="footer-top-items">
				<img alt="" src="assets/img/ghn.png">
				<p class="about-us" style="margin-top: 8px;">Giao hàng nhanh</p>
			</div>
		</div>
	</div>
	
	<div class="footer-bottom">
		<div class="footer-bottom-content">
			<div class="wrap">
				<div class="w25">
					<img style="width: 150px; height: 68px;" alt="" src="assets/img/logo.png">
					<p class="footer-text">Công Ty Cổ Phần Dịch Vụ Thương Mại Tổng Hợp WinCommerce</p>
					<p class="footer-text">Mã số doanh nghiệp: 0104918404 Đăng ký lần đầu ngày 20 tháng 09 năm 2010, đăng ký thay đổi lần thứ 48, ngày 30 tháng 06 năm 2023</p>
					<a href="http://online.gov.vn/Home/WebDetails/10976?AspxAutoDetectCookieSupport=1">
						<img style="width: 123px; height: 47px;" alt="" src="assets/img/datb.png">
					</a>
				</div>
				
				<div class="w25">
					<p class="footer-title">Về chúng tôi</p>
					<div>
						<a class="footer-link" href="https://winmart.vn/info/about">Giới thiệu về WinMart</a>
						<a class="footer-link" href="https://winmart.vn/info/danh-sach-cua-hang">Danh sách cửa hàng</a>
						<a class="footer-link" href="https://winmart.vn/info/quan-ly-chat-luong">Quản lý chất lượng</a>
						<a class="footer-link" href="https://winmart.vn/info/privacy-policy">Chính sách bảo mật</a>
						<a class="footer-link" href="https://winmart.vn/info/transaction-policy">Điều khoản và điều kiện giao dịch</a>
					</div>
				</div>
				
				<div class="w25">
					<p class="footer-title">Hỗ trợ khách hàng</p>
					<div>
						<a class="footer-link" href="https://winmart.vn/info/customer-support">Trung tâm hỗ trợ khách hàng</a>
						<a class="footer-link" href="https://winmart.vn/info/delivery-policy">Chính sách giao hàng</a>
						<a class="footer-link" href="https://winmart.vn/info/payment-policy">Chính sách thanh toán</a>
						<a class="footer-link" href="https://winmart.vn/info/return-and-exchange-policy">Chính sách đổi trả</a>
						<a class="footer-link" href="https://winmart.vn/danh-gia-gop-y">Đánh giá góp ý</a>
						<a class="footer-link" href="https://winmart.vn/danh-sach-giai-thuong">Danh sách trúng thưởng</a>
					</div>
				</div>
				
				<div class="w25">
					<p class="footer-title">Chăm sóc khách hàng</p>
					<a class="footer-link" href="#">
						<span>Mua Online: 0247 1066866</span>
					</a>
					<a class="footer-link" href="#">
						<span>Email: cskh@winmart.masangroup.com</span>
					</a>
					<p style="margin-top: 16px;" class="footer-title">Kết nối với chúng tôi</p>
					<div class="d-flex">
						<a class="connect-icon" href="https://www.facebook.com/sieuthiwinmart">
							<i style="font-size: 26px;" class="fa-brands fa-facebook"></i>
						</a>
						<a class="connect-icon" href="https://www.youtube.com/channel/UCLo59yYY_gwbKHy67mZtNsQ/videos">
							<i style="font-size: 26px;color: rgb(237, 28, 36);" class="fa-brands fa-youtube"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
		<hr style="border: 1px solid rgba(255, 255, 255, 0.1);">
		<div class="footer-bottom-content">
			<div class="wrap">
				<div class="footer-address">
					<p class="address-title">Địa chỉ giao dịch Hà Nội:</p>
					<div class="address-des">
						<p>Công Ty Cổ Phần Dịch Vụ Thương Mại Tổng Hợp WinCommerce</p>
						<p>Tầng 6, Toà nhà trung tâm Quốc tế, số 17 Ngô Quyền, Phường Tràng Tiền, Quận Hoàn Kiếm, Thành Phố Hà Nội</p>
					</div>
				</div>
				
				<div class="footer-address">
					<p class="address-title">Trụ sở chính:</p>
					<div class="address-des">
						<p>Công Ty Cổ Phần Dịch Vụ Thương Mại Tổng Hợp WinCommerce</p>
						<p>Số 23 Lê Duẩn, Phường Bến Nghé, Quận 1, Thành phố Hồ Chí Minh, Việt Nam</p>
					</div>
				</div>
				
				<div class="footer-address">
					<p class="address-title">Địa chỉ giao dịch Tp.HCM:</p>
					<div class="address-des">
						<p>Công Ty Cổ Phần Dịch Vụ Thương Mại Tổng Hợp WinCommerce</p>
						<p>Tầng 12, Tòa nhà Mplaza SaiGon, số 39 Lê Duẩn, Phường Bến Nghé, Quận 1, TP Hồ Chí Minh, Việt Nam</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
</body>
</html>