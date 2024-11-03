import {replaceUser} from "./user.js";

document.getElementById('header-bookingProcess-right').addEventListener('click', function(event) {
    // Kiểm tra nếu phần tử nhấn vào là nút có class "dynamic-button"
    if (event.target && event.target.id === "logout-btn") {
        replaceUser();
        document.cookie = "identify=; path=/; max-age=0; secure";
    }
});