<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>BookingSuccess</title>
    <!--font chữ-->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
            rel="stylesheet"
    />
    <!--reset css-->
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
    />
    <!--icon-->
    <!--css-->
    <link rel="stylesheet" href="style/main.css" />
    <!--flatpickr-->
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css"
    />
    <style>
        .custom-input::-webkit-outer-spin-button,
        .custom-input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>
</head>
<body>

<div id="header-bookingProcess">
    <div id="header-bookingProcess-wrap">
        <div id="header-bookingProcess-left">
            <div id="logo">
                <div style="color: var(--primary-color)">IT-Faculty</div>
                <div>way</div>
            </div>
        </div>

        <div id="header-bookingProcess-right">
            <p id="My-booking">My Booking</p>
            <div class="avatar">
                <img style="width: 40px" src="imgs/user.png" alt="" />
                <div id="tmp"></div>
                <div class="user-menu">
                    <a class="item-user" href="">Thông tin cá nhân</a>
                    <a class="item-user" href="">Vé của tôi</a>
                    <a class="item-user" href="">Đăng xuất</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="content-booking-success">
    <div class="grap-info-user">
        <div class="content-info-user">
            <div class="item-info-user">
                <div class="info-user-imgs">
                    <img src="imgs/avatar.png" alt="" />
                    <img id="camera-info" src="imgs/camera.png" alt="" />
                </div>

                <div class="info-user-decs">
                    Cung cấp thông tin chính xác sẽ hỗ trợ bạn trong quá trình mua vé
                    hoặc khi cần xác thực vé
                </div>
            </div>

            <div class="item-info-user">
                <span>Họ và tên</span>
                <input class="input-info-user" type="text" />
            </div>

            <div class="item-info-user">
                <span>Số điện thoại</span>
                <div class="grap-input-info-user">
                    <select name="" id="" class="input-info-user hihi">
                        <option value="">+84</option>
                        <option value="">+60</option>
                        <option value="">+61</option>
                        <option value="">+66</option>
                        <option value="">+85</option>
                        <option value="">+80</option>
                    </select>
                    <input class="input-info-user hehe custom-input" type="number" />
                    <img src="" alt="" />
                </div>
            </div>

            <div class="item-info-user">
                <span>Email</span>
                <input class="input-info-user" type="email" />
            </div>

            <div class="item-info-user">
                <button class="btn_update-info">Cập nhật</button>
            </div>
        </div>
    </div>
</div>

<div id="footer">
    <div class="footer-wrap">
        <div class="footer-content">
            <div class="footer-logo">
                <p class="logo-text">IT-Faculty</p>
                <p style="color: var(--black-color)">way</p>
            </div>
            <div class="footer-desc">
                <p class="desc-title">Lên kế hoạch cho chuyến đi tiếp theo?</p>
                <p class="desc-detail">
                    Đăng ký nhận bản tin của chúng tôi. Nhận xu hướng và ưu đãi du
                    lịch mới nhất!
                </p>
            </div>
            <div class="footer-contact">
                <div class="footer-wrap-input">
                    <input
                            type="email"
                            class="input-email"
                            name="email"
                            placeholder="Nhập email của bạn"
                    />
                    <img class="icon-date" src="imgs/icon-send.png" alt="" />
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
                <img src="imgs/facebook-icon.png" alt="" class="item-icon" />
                <img src="imgs/ins-icon.png" alt="" class="item-icon" />
                <img src="imgs/twiter-icon.png" alt="" class="item-icon" />
            </div>
        </div>
    </div>
</div>

<script src="../JS/login.js"></script>
<script type="module" src="../JS/Validate.js"></script>
<script type="module" src="../JS/ValidateLogin.js"></script>
</body>
</html>
