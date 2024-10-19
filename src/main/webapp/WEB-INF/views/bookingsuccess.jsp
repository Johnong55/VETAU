
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookingSuccess</title>
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
                window.location.href = "processbooking.jsp";
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




	<div id="content-booking-success">
		<div id="content-booking-success-header">
			<div class="success-header-icon">
				<img src="imgs/icon-success.png" alt="">
			</div>
			<div class="success-header-text">Xin chúc mừng! Bạn đã đặt vé
				thành công</div>
			<div class="success-header-desc">Vui lòng mang theo vé in / vé
				điện tử, cùng với giấy tờ tùy thân có liên quan khi đi đến ga tàu</div>
		</div>

		<div id="content-booking-success-body">
			<div class="booking-success-body-left">


				<div class="lable-ticket lable-ticket-succees">
					<div class="ticket-title">Chi Tiết Vé</div>
					<div class="info-train-chair">
						<div class="name-train">12340 - SE1</div>
						<div class="name-chair">3A & 20</div>
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
					<div class="lable-ticket-total">
						<span> Tổng tiền </span> <span> 650.000 VND </span>
					</div>

				</div>

			</div>
			<div class="booking-success-body-right">
				<div class="success-body-right-icon">
					<img src="imgs/qr.png" alt="">
				</div>

				<div class="success-body-right-desc">
					<span>Quét mã để xem trên bất kỳ thiết bị nào</span>
				</div>

				<button class="success-btn success-btn-white">In vé</button>
				<button class="success-btn" onclick="BackPage()">Tiếp tục
					đặt vé</button>
				<button class="success-btn">Tải vé</button>

			</div>
		</div>

		<div id="booking-success-footer" style="justify-content: center;">
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
	<script src="JS/login.js"></script>

</body>
</html>
