export function getUserEL() {
    return `
        <div class="avatar">
            <img style="width: 40px" src="../imgs/user.png" alt="" />
            <div id="tmp"></div>
            <div class="user-menu">
              <a class="item-user" href="">Thông tin cá nhân</a>
              <a class="item-user" href="">Vé của tôi</a>
              <a class="item-user" href="">Đăng xuất</a>
            </div>
        </div>
    `;
}