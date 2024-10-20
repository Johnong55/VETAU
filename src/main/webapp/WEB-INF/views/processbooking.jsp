<%@page import="java.io.Console"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProcessBooking</title>
<!--font chữ-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<!--reset css-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<!--css-->
<link rel="stylesheet" href="style/main.css">
<!--flatpickr-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">

</head>
<body>
	<!--header -->
	<div id="header-bookingProcess">
		<div id="header-bookingProcess-wrap">
			<div id="header-bookingProcess-left">
				<div id="logo">
					<div style="color: var(--primary-color);">IT-Faculty</div>
					<div>way</div>
				</div>
			</div>
			<div id="header-bookingProcess-right">
				<p id="My-booking">My Booking</p>
				<button id="login-signin" onclick="Login()">Đăng nhập /
					Đăng kí</button>
			</div>
		</div>
	</div>
	<!--content -->

	<div id="content-booking">
		<div id="content-booking-left">
			<h1 class="booking-content-header">Kết Quả Tìm Kiếm</h1>

			<div id="input-booking-wrap">
				<div class="wrap-input input-bookingProcess">
					<input class="input-info"
						id="start-city" placeholder="Thành phố/ Tỉnh xuất phát">
				</div>

				<div class="wrap-input input-bookingProcess">
					<input class="input-info"
						id="end-city" placeholder="Thành phố/ Tỉnh đích đến">
				</div>
				<div class="wrap-input input-bookingProcess">
					<input type="date" class="input-info"
						id="date-input" name="date"> <img class="icon-date"
						src="imgs/icon-date.png" alt="">
				</div>
			</div>

			<div class="wrap-btn" style="width: 100%;">
				<button class="search-btn">Tìm kiếm chuyến tàu</button>
			</div>

			<div class="content-left-ads">
				<img class="ads-img" src="imgs/ads_1.jpg" alt="">
				<div class="ads-text">
					Lên kế hoạch cho kỳ nghỉ của bạn <img class="icon-ads"
						src="imgs/icon-ads.png" alt="">
				</div>
			</div>

			<div class="content-left-ads">
				<img class="ads-img" src="imgs/ads_2.jpg" alt="">
				<div class="ads-text">
					Gói du lịch tàu hỏa <img class="icon-ads" src="imgs/icon-ads.png"
						alt="">
				</div>
			</div>

			<p class="text-desc">Hãy trải nghiệm dịch vụ đặt vé trực tuyến
				của chúng tôi, nơi bạn có thể chọn hành trình mong muốn chỉ với vài
				cú click. Tiết kiệm thời gian, không cần xếp hàng chờ đợi, đặt vé
				ngay bây giờ và nhận ưu đãi hấp dẫn!</p>

		</div>

		<div id="content-booking-right">
			<div id="booking-right-header">
				<h1 class="booking-content-header"
					style="color: var(--black-color);">Các Chuyến Tàu</h1>
				<p class="text-desc" style="margin: 26px 0 0 30px;">5 chuyến tàu
				</p>
			</div>

			<div id="booking-right-body">

				<%
                        for (int i = 0; i < 10; i++) {
                    %>


				<div class="wrap-lable">
					<div class="booking-label">
						<div class="label-title">
							<p style="margin-bottom: 6px;">12340 - SE1</p>
						</div>

						<div class="lable-info-bonus">
							<div class="lable-info-bonus-left">
								<p>Các ga đi qua:</p>
								<div class="info-bonus-left-result">Huế, Vinh, Thanh Hóa,
									Ninh Bình</div>
							</div>

							<div class="lable-info-bonus-right">
								<p>Xem chi tiết thời gian</p>
							</div>
						</div>

						<div class="lable-time_line">
							<div class="wrap-time time-start">
								<p class="day">Ngày 14/9</p>

								<p class="hour">11:25 pm</p>

								<p class="location">Đà Nẵng</p>
							</div>

							<div class="time-illustration">
								<p class="hour-illus">25 giờ</p>
							</div>

							<div class="wrap-time time-end">
								<p class="day">Ngày 15/9</p>

								<p class="hour">12:25 pm</p>

								<p class="location">Hà Nội</p>
							</div>
						</div>

						<div class="wrap-options">
							<div class="option option-3A">
								<div class="content">
									<div class="option-left">
										<p>Toa</p>
										<p>Giá</p>
									</div>

									<div class="option-right">
										<p>3A</p>
										<p>200.000 VND</p>
									</div>
								</div>
							</div>

							<div class="option option-2A">
								<div class="content">
									<div class="option-left">
										<p>Toa</p>
										<p>Giá</p>
									</div>

									<div class="option-right">
										<p>2A</p>
										<p>400.000 VND</p>
									</div>
								</div>
							</div>

							<div class="option option-1A">
								<div class="content">
									<div class="option-left">
										<p>Toa</p>
										<p>Giá</p>
									</div>

									<div class="option-right">
										<p>1A</p>
										<p>600.000 VND</p>
									</div>
								</div>
							</div>

							<div class="option">
								<div class="sold-out">
									<p>Hết vé</p>
								</div>
							</div>

						</div>

					</div>
				</div>



				<%
                        }
                    %>

			</div>
		</div>
	</div>
	<!--footer -->
	<div id="footer">
		<div class="footer-wrap">
			<div class="footer-content">
				<div class="footer-logo">
					<p class="logo-text">IT-Faculty</p>
					<p style="color: var(--black-color);">way</p>
				</div>
				<div class="footer-desc">
					<p class="desc-title">Lên kế hoạch cho chuyến đi tiếp theo?</p>
					<p class="desc-detail">Đăng ký nhận bản tin của chúng tôi. Nhận
						xu hướng và ưu đãi du lịch mới nhất!</p>
				</div>
				<div class="footer-contact">
					<div class="footer-wrap-input">
						<input type="email" class="input-email" name="email"
							placeholder="Nhập email của bạn"> <img class="icon-date"
							src="imgs/icon-send.png" alt="">
					</div>
				</div>
			</div>
			<div class="footer-about">
				<div class="list-info">
					<div class="item-info">Thông tin thêm</div>
					<div class="item-info">Điện thoại</div>
					<div class="item-info">Chính sách</div>
					<div class="item-info">Điều khoản</div>
					<div class="item-info">Tuyển dụng</div>
					<div class="item-info">Dịch vụ</div>
				</div>
				<div class="list-icon">
					<img src="imgs/facebook-icon.png" alt="" class="item-icon"> <img
						src="imgs/ins-icon.png" alt="" class="item-icon"> <img
						src="imgs/twiter-icon.png" alt="" class="item-icon">
				</div>
			</div>
		</div>
	</div>


	<!--chọn ghế trong toa-->

	<div class="form-option-3A">
		<div class="modal">
			<div class="modal__overlay"></div>
			<div class="modal__body body-option-3A">
				<div class="auth-form-option auth-form-option-3A ">
					<div class="auth-form-option-container">
						<div class="option-header">
							<h1>Toa: 3A</h1>
						</div>

						<div class="option-body"
							style="background-color: rgba(208, 255, 200, 1);">
							<div class="option-body-left">

								<%
                                        for(int k = 0; k <=16 ; k +=4) {
                                            %>

								<div class="option-chair-column">
									<%
                                                    for(int i = 1; i <=4; i++) {
                                                %>
									<div class="option-chair-item">
										<div class="item-backrest"></div>
										<%  String name = (i + k) + "-3A";%>
										<div class="item-square" id="<%=name%>" data-value="available" data-status="available">
											<%=i+k%>
										</div>
									</div>
									<%
                                                }
                                                %>
								</div>
								<%
                                        }
                                    %>

							</div>

							<div class="option-body-mid">
								<div class="mid-item"></div>

								<div class="mid-item"></div>
							</div>

							<div class="option-body-right">

								<%
                                        for(int k = 20; k <=36 ; k +=4) {
                                            %>

								<div class="option-chair-column">
									<%
                                                    for(int i = 1; i <=4; i++) {
                                                %>
									<div class="option-chair-item">
										<div class="item-backrest"></div>
										<%  String name = (i + k) + "-3A";%>
										<div class="item-square" id="<%=name%>" data-value="available" data-status="available">
											<%=i+k%>
										</div>
									</div>
									<%
                                                }
                                                %>
								</div>
								<%
                                        }
                                    %>

							</div>
						</div>

						<div class="option-desc">
							<div class="option-desc-item">
								<div class="option-chair-item">
									<div class="item-backrest"></div>

									<div class="item-square color-chair-soldout"
										style="cursor: default;"></div>
								</div>
								<span>Đã có người chọn</span>
							</div>

							<div class="option-desc-item">
								<div class="option-chair-item">
									<div class="item-backrest"></div>

									<div class="item-square color-chair-hold"
										style="cursor: default;"></div>
								</div>
								<span>Bạn đang chọn</span>
							</div>
						</div>

						<div class="option-status">
							<p class="text-status">Đã chọn: 0</p>
						</div>

						<div class="box-btn">
							<button class="login-btn confirmbook">Tiếp tục</button>
							<button class="login-btn login-btn--back"
								onclick="ExitOption_3A()">Trở lại</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="form-option-2A">
		<div class="modal">
			<div class="modal__overlay"></div>
			<div class="modal__body body-option-2A">
				<div class="auth-form-option auth-form-option-3A ">
					<div class="auth-form-option-container">
						<div class="option-header">
							<h1>Toa: 3A</h1>
						</div>

						<div class="option-body"
							style="background-color: rgba(255, 233, 200, 1);">
							<div class="option-body-left">

								<%
                                        for(int k = 0; k <=16 ; k +=4) {
                                            %>

								<div class="option-chair-column">
									<%
                                                    for(int i = 1; i <=4; i++) {
                                                %>
									<div class="option-chair-item">
										<div class="item-backrest"></div>
										<%  String name = (i + k) + "-2A";%>
										<div class="item-square" id="<%=name%>" data-value="available" data-status="available">
											<%=i+k%>
										</div>
									</div>
									<%
                                                }
                                                %>
								</div>
								<%
                                        }
                                    %>

							</div>

							<div class="option-body-mid">
								<div class="mid-item"></div>

								<div class="mid-item"></div>
							</div>

							<div class="option-body-right">

								<%
                                        for(int k = 20; k <=36 ; k +=4) {
                                            %>

								<div class="option-chair-column">
									<%
                                                    for(int i = 1; i <=4; i++) {
                                                %>
									<div class="option-chair-item">
										<div class="item-backrest"></div>
										<%  String name = (i + k) + "-2A";%>
										<div class="item-square" id="<%=name%>" data-value="available" data-status="available">
											<%=i+k%>
										</div>
									</div>
									<%
                                                }
                                                %>
								</div>
								<%
                                        }
                                    %>

							</div>
						</div>

						<div class="option-desc">
							<div class="option-desc-item">
								<div class="option-chair-item">
									<div class="item-backrest"></div>

									<div class="item-square color-chair-soldout"
										style="cursor: default;"></div>
								</div>
								<span>Đã có người chọn</span>
							</div>

							<div class="option-desc-item">
								<div class="option-chair-item">
									<div class="item-backrest"></div>

									<div class="item-square color-chair-hold"
										style="cursor: default;"></div>
								</div>
								<span>Bạn đang chọn</span>
							</div>
						</div>

						<div class="option-status">
							<p class="text-status">Đã chọn: 0</p>
						</div>

						<div class="box-btn">
							<button class="login-btn confirmbook">Tiếp tục</button>
							<button class="login-btn login-btn--back"
								onclick="ExitOption_2A()">Trở lại</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="form-option-1A">
		<div class="modal">
			<div class="modal__overlay"></div>
			<div class="modal__body body-option-1A">
				<div class="auth-form-option auth-form-option-3A ">
					<div class="auth-form-option-container">
						<div class="option-header">
							<h1>Toa: 3A</h1>
						</div>

						<div class="option-body"
							style="background-color: rgba(255, 205, 205, 1);">
							<div class="option-body-left">

								<%
                                        for(int k = 0; k <=16 ; k +=4) {
                                            %>

								<div class="option-chair-column">
									<%
                                                    for(int i = 1; i <=4; i++) {
                                                %>
									<div class="option-chair-item">
										<div class="item-backrest"></div>
										<%  String name = (i + k) + "-1A";%>
										<div class="item-square" id="<%=name%>" data-value="available" data-status="available">
											<%=i+k%>
										</div>
									</div>
									<%
                                                }
                                                %>
								</div>
								<%
                                        }
                                    %>

							</div>

							<div class="option-body-mid">
								<div class="mid-item"></div>

								<div class="mid-item"></div>
							</div>

							<div class="option-body-right">

								<%
                                        for(int k = 20; k <=36 ; k +=4) {
                                            %>

								<div class="option-chair-column">
									<%
                                                    for(int i = 1; i <=4; i++) {
                                                %>
									<div class="option-chair-item">
										<div class="item-backrest"></div>
										<%  String name = (i + k) + "-1A";%>
										<div class="item-square" id="<%=name%>" data-value="available" data-status="available">
											<%=i+k%>
										</div>
									</div>
									<%
                                                }
                                                %>
								</div>
								<%
                                        }
                                    %>

							</div>
						</div>

						<div class="option-desc">
							<div class="option-desc-item">
								<div class="option-chair-item">
									<div class="item-backrest"></div>

									<div class="item-square color-chair-soldout"
										style="cursor: default;"></div>
								</div>
								<span>Đã có người chọn</span>
							</div>

							<div class="option-desc-item">
								<div class="option-chair-item">
									<div class="item-backrest"></div>

									<div class="item-square color-chair-hold"
										style="cursor: default;"></div>
								</div>
								<span>Bạn đang chọn</span>
							</div>
						</div>

						<div class="option-status">
							<p id="text-status">Đã chọn: 0</p>
						</div>

						<div class="box-btn">
							<button class="login-btn confirmbook">Tiếp tục</button>
							<button class="login-btn login-btn--back"
								onclick="ExitOption_1A()">Trở lại</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!--đăng nhập đăng kí-->
	<div class="form-signIn">
		<div class="modal">
			<div class="modal__overlay"></div>
			<div class="modal__body body-signIn">
				<!-- dang ki form -->
				<div class="auth-form auth-form-signIn">
					<div class="auth-form__container">
						<div class="auth-form__header">
							<h3 class="auth-form__heading">Đăng kí</h3>
							<span class="auth-form__switch-btn" onclick="Login()">Đăng
								nhập</span>
						</div>
						<div class="auth-form__form">
							<div class="auth-form__group">
								<input type="text" class="auth-form__input"
									placeholder="Nhập email">
							</div>
							<div class="auth-form__group">
								<input type="password" class="auth-form__input"
									placeholder="Nhập mật khẩu">
							</div>
							<div class="auth-form__group">
								<input type="password" class="auth-form__input"
									placeholder="Nhập lại mật khẩu">
							</div>
						</div>
						<div class="auth-form__aside">
							<p class="auth-form__policy-text">
								<span>Bằng việc đăng kí, bạn đã đồng ý với Shoppee về</span> <span
									style="color: var(--primary-color);">Điều khoản và dịch
									vụ</span> <span>&</span> <span style="color: var(--primary-color);">Chính
									sách bảo mật</span>
							</p>
						</div>
						<div class="box-btn">
							<button class="login-btn">ĐĂNG KÍ</button>
							<button class="login-btn login-btn--back" onclick="Back()">TRỞ
								LẠI</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="form-login">
		<div class="modal">
			<div class="modal__overlay"></div>
			<div class="modal__body body-login">
				<!-- dang nhap form -->
				<div class="auth-form auth-form-login">
					<div class="auth-form__container">
						<div class="auth-form__header">
							<h3 class="auth-form__heading">Đăng nhập</h3>
							<span class="auth-form__switch-btn" onclick="SignIn()">
								Đăng kí </span>
						</div>
						<div class="auth-form__form">
							<div class="auth-form__group">
								<input type="text" class="auth-form__input"
									placeholder="Nhập email">
							</div>
							<div class="auth-form__group">
								<input type="password" class="auth-form__input"
									placeholder="Nhập mật khẩu">
							</div>
						</div>
						<div class="auth-form__aside">
							<div class="auth-form__help">
								<a href=""
									class="auth-form__help-link auth-form__help-link--forgot">
									Quên mật khẩu </a> <span href=""
									class="auth-form__help-link--separate">|</span> <a href=""
									class="auth-form__help-link"> Cần trợ giúp? </a>
							</div>
						</div>
						<div class="box-btn">
							<button class="login-btn">ĐĂNG NHẬP</button>
							<button class="login-btn login-btn--back" onclick="Back()">TRỞ
								LẠI</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="../JS/login.js"></script>
	<script src="../JS/ChooseChair.js"></script>
	<script src="../JS/loadProcessbooking.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
	<script>

         	flatpickr("#date-input", {
            dateFormat: "Y-m-d"
            });
        </script>
	<script src="../JS/ConfirmBook.js"></script>
</body>
</html>
