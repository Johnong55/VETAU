<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>cc</title>
    <!--font chữ-->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet" />
    <!--reset css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
    <!--icon-->
    <!--css-->
    <link rel="stylesheet" href="style/main.css" />
    <!--flatpickr-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css" />
    <style>
        .custom-input::-webkit-outer-spin-button,
        .custom-input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>
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
                    <a class="item-user" href="http://localhost:8080/informationalUser">Thông tin cá nhân</a>
                    <a class="item-user" href="http://localhost:8080/myTicket">Vé của tôi</a>
                    <a class="item-user" href="">Đăng xuất</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="content-booking-success">
    <div class="wrap-myTicket">
        <div class="myTicket-header">
            Vé đã mua
        </div>
        <div class="myTicket-body">
            <div class="myTicket-status">
                <h1 class="status">Sắp chạy</h1>
                <h1 class="status">Đã chạy</h1>
            </div>
            <div class="myTicket-tickets">
                <div class="lable-ticket" style="margin-left: 0; width: 100%;">
                    <div class="info-ticket-chair">
                        <div class="name-train">Tên chuyến tàu</div>
                        <div class="name-chair" id="listChair"></div>
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
                </div>
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
                    <input type="email" class="input-email" name="email" placeholder="Nhập email của bạn" />
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
<script type="module" src="../JS/intro.js"></script>
<script type="module" src="../JS/Cookie.js"></script>
<script type="module" src="../JS/user.js"></script>
<script type="module" src="../JS/login.js"></script>
<script type="module" src="../JS/Validate.js"></script>
<script type="module" src="../JS/ValidateLogin.js"></script>

<script>
    const status = document.querySelectorAll(".status");
    status.forEach(tmp => {
        tmp.addEventListener("click", function () {
            status.forEach(tmp1 => {
                tmp1.classList.remove("status-choosed");
                tmp1.classList.remove("text-black");
            });
            tmp.classList.add("status-choosed");
            tmp.classList.add("text-black");
        });
    });

</script>
</body>

</html>