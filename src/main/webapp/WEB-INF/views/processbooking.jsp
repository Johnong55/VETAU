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
	<script>
		window.addEventListener('load', function() {
			let openTabs = parseInt(localStorage.getItem('openTabs')) || 0;
			localStorage.setItem('openTabs', (openTabs + 1).toString());
			console.log(openTabs+1);
		});
		window.addEventListener("unload", function() {
			let openTabs = parseInt(localStorage.getItem('openTabs'));

			if (openTabs === 1) {
				localStorage.removeItem("listChairHold");
				localStorage.removeItem("openTabs");
			} else {
				localStorage.setItem('openTabs', (openTabs - 1).toString());
			}
		});
		window.addEventListener("pageshow", function(event) {
			if (event.persisted) {
				window.location.reload();
			}
		});

	</script>

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
			</div>

			<div id="booking-right-body">



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
								<input type="text" class="auth-form__input" id="username-login"
									placeholder="Nhập tên đăng nhập">
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
	<script type="module" src="../metroway/JS/intro.js"></script>
	<script type="module" src="../metroway/JS/Cookie.js"></script>
	<script type="module" src="../metroway/JS/user.js"></script>
	<script type="module" src="../metroway/JS/login.js"></script>
	<script type="module" src="../metroway/JS/Validate.js"></script>
	<script type="module" src="../metroway/JS/ValidateLogin.js"></script>
	<script type="module" src="../metroway/JS/user.js"></script>
	<script type="module" src="../metroway/JS/loadProcessbooking.js"></script>
	<script type="module" src="../metroway/JS/renderChair.js"></script>
	<script type="module" src="../metroway/JS/renderTrain.js"></script>
	<script type="module" src="../metroway/JS/ConfirmBook.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
	<script>

         	flatpickr("#date-input", {
            dateFormat: "Y-m-d"
            });
        </script>

	<script>
		setTimeout(function() {
			const script = document.createElement('script');

			script.type = "module";

			script.src = '../metroway/JS/ChooseChair.js';

			document.body.appendChild(script);

			console.log('ChooseChair has been added after 0.5 seconds');
		}, 500);
		setTimeout(function() {
			const script = document.createElement('script');

			script.type = "module";

			script.src="../metroway/JS/logout.js";

			document.body.appendChild(script);

			console.log('logout has been added after 0.5 seconds');
		}, 500);
	</script>
</body>
</html>
