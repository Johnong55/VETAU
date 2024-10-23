<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment</title>
<!--font chữ-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<!--reset css-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<!--icon-->
<!--css-->
<link rel="stylesheet" href="style/main.css">
<!--flatpickr-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
</head>
<body>
	<script>
		function BackPage() {
			window.location.href = "/reviewbooking";
		}
	</script>

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


	<div class="content-payment">
		<h1 class="content-payment-header">
			Thanh toán <span id="price-title" style="color: rgba(255, 96, 96, 1);">650.00 VND</span> để xác nhận đặt vé
		</h1>

		<div class="content-payment-body">
			<div class="payment-body-left">
				<div class="lable-ticket" style="margin-left: 0; width: 100%;">
					<div class="ticket-title">Chi Tiết Vé</div>
					<div class="info-train-chair">
						<div class="name-train">12340 - SE1</div>
						<div class="name-chair" id="NameChair">20-3A</div>
					</div>

					<div class="lable-time_line time-ticket">
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

					<div class="lable-customer-info">
						<div class="ticket-title">Khách Hàng</div>
						<div class="lable-customer-info-content">
							<div class="customer-info-content-item"
								style="color: var(--black-color);">Tên: Trần Đăng Minh Đức</div>
							<div class="customer-info-content-item">Tuổi: 20</div>
							<div class="customer-info-content-item">Giới tính: Nam</div>
						</div>
					</div>
					<div class="lable-ticket-contact">
						<div class="lable-ticket-contact-left">Vé điện tử sẽ được
							gửi qua Email:</div>

						<div class="lable-ticket-contact-right">
							minhduc07042004@gmail.com</div>
					</div>
				</div>

				<div class="option-payment">
					<div class="option-payment-header">Chọn phương thức thanh
						toán</div>

					<div class="option-payment-wrap">
						<div class="option-payment-item" id ="vnpay">

							<div class="payment-item-left">
								<img src="imgs/icon-vnpay.png" alt="" class="payment-item-icon">

								<div class="payment-item-text">
									<p class="payment-item-text-header">VNPAY</p>
									<p class="payment-item-text-desc">Thanh toán tức thì với
										VNPAY</p>
								</div>
							</div>
							<div class="payment-item-right">
								<img src="imgs/icon-payment.png" alt=""
									class="payment-item-icon-right">
							</div>
						</div>
					</div>
				</div>



			</div>
			<div class="payment-body-right">
				<div class="wrap-bill">
					<div class="bill-title">Chi Tiết Hóa Đơn</div>

					<div class="bill-content">
						<div class="bill-content-item">
							<div class="bill-content-item-left">Giá vé</div>
							<div class="bill-content-item-right">200.000 VND</div>
						</div>
						<div class="bill-content-item">
							<div class="bill-content-item-left">Số lượng</div>
							<div class="bill-content-item-right">3</div>
						</div>
						<div class="bill-content-item">
							<div class="bill-content-item-left">Thuế hàng hóa và dịch
								vụ</div>
							<div class="bill-content-item-right">50.000 VND</div>
						</div>
					</div>
					<div class="bill-total">
						<div class="bill-total-left">Tổng thanh toán</div>
						<div class="bill-total-right">650.000 VND</div>
					</div>
				</div>

				<button class="login-btn login-btn--back cancel-ticket"
					onclick="BackPage()">Quay lại</button>

			</div>

		</div>

		<div id="content-reviewbooking-footer">
			<span class="review-footer-text">Chính sách hủy bỏ</span> <span
				class="review-footer-text">Điều khoản & Điều kiện</span> <span
				class="review-footer-text">Bảo hiểm du lịch</span>
		</div>
	</div>



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
							<div class="auth-form__group form-field">
								<input type="text" class="auth-form__input" id="email-signup"
									   placeholder="Nhập email">
								<small></small>
							</div>
							<div class="auth-form__group form-field">
								<input type="password" class="auth-form__input" id="password-signup"
									   placeholder="Nhập mật khẩu">
								<small></small>
							</div>
							<div class="auth-form__group form-field">
								<input type="password" class="auth-form__input" id="confirm-password-signup"
									   placeholder="Nhập lại mật khẩu">
								<small></small>
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
							<button class="login-btn" id="sign-up-btn">ĐĂNG KÍ</button>
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
							<div class="auth-form__group form-field">
								<input type="text" class="auth-form__input" id="email-login"
									   placeholder="Nhập email">
								<small></small>
							</div>
							<div class="auth-form__group form-field">
								<input type="password" class="auth-form__input" id="password-login"
									   placeholder="Nhập mật khẩu">
								<small></small>
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
							<button class="login-btn" id="login-button">ĐĂNG NHẬP</button>
							<button class="login-btn login-btn--back" onclick="Back()">TRỞ
								LẠI</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="JS/login.js"></script>
	<script type="module" src="../JS/Validate.js"></script>
	<script type="module" src="../JS/ValidateLogin.js"></script>
	<script src="JS/VnPayAPI.js"></script>
</body>
</html>
