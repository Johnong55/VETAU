function getUserEL() {
    return `
        <div class="avatar" id="user-avatar">
            <img style="width: 40px" src="../metroway/imgs/user.png" alt="" />
            <div id="tmp"></div>
            <div class="user-menu">
              <a class="item-user" href="http://localhost:8080/metroway/informationalUser">Thông tin cá nhân</a>
              <a class="item-user" href="http://localhost:8080/metroway/myTicket">Vé của tôi</a>
              <a class="item-user" id="logout-btn" >Đăng xuất</a>
            </div>
        </div>
    `;
}
function getBtn() {
    return `
    <button id="login-signin" onclick="Login()">Đăng nhập / Đăng kí</button>
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
export function replaceUser() {
    const user = document.getElementById("user-avatar");
    if (user) {
        user.remove();
        const newElement = getBtn();

        const headerRight = document.getElementById("header-bookingProcess-right");
        headerRight.insertAdjacentHTML('beforeend', newElement);
    }
}