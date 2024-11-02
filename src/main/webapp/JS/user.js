function getUserEL() {
    return `
        <div class="avatar">
            <img style="width: 40px" src="../imgs/user.png" alt="" />
            <div id="tmp"></div>
            <div class="user-menu">
              <a class="item-user" href="http://localhost:8080/informationalUser">Thông tin cá nhân</a>
              <a class="item-user" href="http://localhost:8080/myTicket">Vé của tôi</a>
              <a class="item-user" href="">Đăng xuất</a>
            </div>
        </div>
    `;
}

export function replaceButton() {
    const button = document.getElementById("login-signin");
    if (button) {
        button.remove();
        const newElement = getUserEL();

        const headerRight = document.getElementById("header-bookingProcess-right");
        headerRight.insertAdjacentHTML('beforeend', newElement);
    }
}
