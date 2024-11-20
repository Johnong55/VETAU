<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Admin</title>
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
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>

<body>
<div class="container-fluid">
    <div class="row" style="height: 100vh;">
        <div class="col-md-2 contain-left d-flex flex-column" id="menu-admin" style="overflow: hidden;">
            <div class="container-fluid mt-3">
                <span class="h1 text-primary font-weight-bold">IT-Faculty</span><span
                    class="h1 font-weight-normal">way</span>
            </div>

            <div class="row mt-5">
                <div class="col-md-3 ps-3">
                    <img src="../metroway/imgs/user.png" class="rounded-circle avatar-admin" alt="Admin">
                </div>
                <p class="col-md-9 h3 my-auto center-text">Đức Đẹp Trai</p>
            </div>

            <div class="row mt-5 ms-3 options-admin options-admin-item" data-value="train">
                <i class="col-md-2 bi bi-train-front fs-3"></i>
                <p class="h3 col-md-10 my-auto p-menu-admin">Tàu</p>
            </div>

            <div class="row mt-4 ms-3 options-admin options-admin-item" data-value="toa">
                <i class="col-md-2 bi bi-archive fs-3"></i>
                <p class="h3 col-md-10 my-auto p-menu-admin">Toa</p>
            </div>

            <div class="row mt-4 ms-3 options-admin options-admin-item" data-value="trip">
                <i class="col-md-2 bi bi-calendar3 fs-3"></i>
                <p class="h3 col-md-10 my-auto p-menu-admin">Chuyến tàu</p>
            </div>

            <div class="row mt-4 ms-3 options-admin options-admin-item" data-value="station">
                <i class="col-md-2 bi bi-house-door fs-3"></i>
                <p class="h3 col-md-10 my-auto p-menu-admin">Ga tàu</p>
            </div>

            <div class="row mt-4 ms-3 options-admin options-admin-item" data-value="city">
                <i class="col-md-2 bi bi-buildings fs-3"></i>
                <p class="h3 col-md-10 my-auto p-menu-admin">Thành phố</p>
            </div>

            <div class="row mt-4 ms-3 options-admin options-admin-item" data-value="customer">
                <i class="col-md-2 bi bi-people fs-3"></i>
                <p class="h3 col-md-10 my-auto p-menu-admin">Khách hàng</p>
            </div>

            <div class="row mt-4 ms-3 options-admin options-admin-item" data-value="ticket">
                <i class="col-md-2 bi bi-ticket-perforated fs-3"></i>
                <p class="h3 col-md-10 my-auto p-menu-admin">Vé</p>
            </div>



            <button type="button" class="btn btn-lg btn-primary mt-auto mb-5 ms-3 me-3 btn-logout">Đăng xuất</button>


        </div>




        <div class="col-md-10 contain-right">

            <div class="wrap-title">
                <p class="h1 text-secondary title-admin">Tàu</p>
            </div>

            <div class="input-group input-group-lg mb-3" style="margin-top: 50px !important;">
                    <span class="input-group-text">
                        Tìm kiếm
                    </span>
                <input type="text" class="form-control">
            </div>


            <div class="container wrap-table" style="width: 80% !important;">

            </div>

        </div>
    </div>
</div>
<script type="module" src="JS/menuAdmin.js"></script>
<script type="module" src="JS/renderAdmin.js"></script>
<script type="module" src="JS/actionAdmin.js"></script>
</body>

</html>