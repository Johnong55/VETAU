import {replaceUser} from "./user.js";

document.getElementById('header-bookingProcess-right').addEventListener('click', function(event) {

    if (event.target && event.target.id === "logout-btn") {
        replaceUser();
        document.cookie = "identify=; path=/; max-age=0; secure";
    }
});