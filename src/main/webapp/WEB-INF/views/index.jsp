<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>HomePage</title>
	<!--font chữ-->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link
			href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
			rel="stylesheet">
	<!--reset css-->
	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<!--icon-->
	<!--css-->
	<link rel="stylesheet" href="../metroway/style/main.css">
	<link rel="stylesheet"
		  href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">

</head>
<body>
<div id="content">
	<div id="content-left">
		<div id="logo">
			<div class="--primary-color">IT-Faculty</div>
			<div>way</div>
		</div>
		<div id="introduce">
			<div id="introduce-header">Xin chào</div>
			<p id="introduce-title">Trải nghiệm đặt vé một cách dễ dàng nào!</p>
			<p id="introduce-desc">Đặt vé tàu là quá trình lựa chọn và mua
				vé tàu trực tuyến. Đây là một quá trình dễ dàng nhưng chúng tôi ở
				đây để làm cho nó tốt hơn và đơn giản hơn nhiều.</p>
		</div>
		<div id="search-box">
			<div id="search-input">
				<div class="wrap-input">
					<label>
						<select class="input-info" name="train-station-province" id="start-city">
							<option value="" disabled selected>Chọn tỉnh/thành phố đi</option>
							<option value="Hà Nội">Hà Nội</option>
							<option value="Hải Phòng">Hải Phòng</option>
							<option value="Nam Định">Nam Định</option>
							<option value="Ninh Bình">Ninh Bình</option>
							<option value="Thanh Hóa">Thanh Hóa</option>
							<option value="Nghệ An">Nghệ An</option>
							<option value="Vinh">Vinh</option>
							<option value="Hà Tĩnh">Hà Tĩnh</option>
							<option value="Quảng Bình">Quảng Bình</option>
							<option value="Quảng Trị">Quảng Trị</option>
							<option value="Thừa Thiên Huế">Thừa Thiên Huế</option>
							<option value="Đà Nẵng">Đà Nẵng</option>
							<option value="Quảng Nam">Quảng Nam</option>
							<option value="Quảng Ngãi">Quảng Ngãi</option>
							<option value="Bình Định">Bình Định</option>
							<option value="Phú Yên">Phú Yên</option>
							<option value="Khánh Hòa">Khánh Hòa</option>
							<option value="Ninh Thuận">Ninh Thuận</option>
							<option value="Bình Thuận">Bình Thuận</option>
							<option value="Đồng Nai">Đồng Nai</option>
							<option value="Bình Dương">Bình Dương</option>
							<option value="Sài Gòn">Sài Gòn</option>
						</select>
					</label>
				</div>
				<div class="wrap-input">
					<label>
						<select class="input-info" name="train-station-province" id="end-city">
							<option value="" disabled selected>Chọn tỉnh/thành phố đến</option>
							<option value="Hà Nội">Hà Nội</option>
							<option value="Hải Phòng">Hải Phòng</option>
							<option value="Nam Định">Nam Định</option>
							<option value="Ninh Bình">Ninh Bình</option>
							<option value="Thanh Hóa">Thanh Hóa</option>
							<option value="Nghệ An">Nghệ An</option>
							<option value="Vinh">Vinh</option>
							<option value="Hà Tĩnh">Hà Tĩnh</option>
							<option value="Quảng Bình">Quảng Bình</option>
							<option value="Quảng Trị">Quảng Trị</option>
							<option value="Thừa Thiên Huế">Thừa Thiên Huế</option>
							<option value="Đà Nẵng">Đà Nẵng</option>
							<option value="Quảng Nam">Quảng Nam</option>
							<option value="Quảng Ngãi">Quảng Ngãi</option>
							<option value="Bình Định">Bình Định</option>
							<option value="Phú Yên">Phú Yên</option>
							<option value="Khánh Hòa">Khánh Hòa</option>
							<option value="Ninh Thuận">Ninh Thuận</option>
							<option value="Bình Thuận">Bình Thuận</option>
							<option value="Đồng Nai">Đồng Nai</option>
							<option value="Bình Dương">Bình Dương</option>
							<option value="Sài Gòn">Sài Gòn</option>
						</select>
					</label>
				</div>
				<div class="wrap-input">
					<input type="date" class="input-info" id="date-input" name="date">
					<img class="icon-date" src="imgs/icon-date.png" alt="">
				</div>
			</div>
			<div class="wrap-btn">
				<button class="search-btn" id="btn-findtrain">Tìm kiếm chuyến tàu</button>
			</div>
		</div>
	</div>

	<div id="content-right"></div>
</div>

<div id="footer">
	<div class="footer-wrap">
		<div class="footer-content">
			<div class="footer-logo">
				<p class="logo-text">IT-Faculty</p>
				<p class="logo-text --black-color">way</p>
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
<script src="../metroway/JS/findtrain.js"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script>
	function getCurrentDate() {
		const today = new Date(); // Khởi tạo đối tượng Date với ngày giờ hiện tại
		const year = today.getFullYear(); // Lấy năm hiện tại
		const month = String(today.getMonth() + 1).padStart(2, '0'); // Lấy tháng hiện tại và thêm '0' nếu cần
		const day = String(today.getDate()).padStart(2, '0'); // Lấy ngày hiện tại và thêm '0' nếu cần
		console.log(year, month, day);
		return year + "-" + month + "-" + day; // Trả về chuỗi theo định dạng YYYY-MM-DD
	}
	flatpickr("#date-input", {
		dateFormat: "Y-m-d",
		defaultDate: getCurrentDate()
	});
</script>
</body>
</html>
