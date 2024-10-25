import {getTrainEL} from "./renderTrain.js";


const input_startCity = document.querySelector("#start-city");
const input_endCity = document.querySelector("#end-city");
const input_date = document.querySelector("#date-input");

function getCurrentDate() {
    const today = new Date(); // Khởi tạo đối tượng Date với ngày giờ hiện tại
    const year = today.getFullYear(); // Lấy năm hiện tại
    const month = String(today.getMonth() + 1).padStart(2, '0'); // Lấy tháng hiện tại và thêm '0' nếu cần
    const day = String(today.getDate()).padStart(2, '0'); // Lấy ngày hiện tại và thêm '0' nếu cần
    console.log(year, month, day);
    return year + "-" + month + "-" + day; // Trả về chuỗi theo định dạng YYYY-MM-DD
}

(localStorage.getItem("startCity") !=null) ? input_startCity.value = localStorage.getItem("startCity")
    : input_startCity.value = "Thành phố/ Tỉnh xuất phát";

(localStorage.getItem("endCity") != null) ? input_endCity.value = localStorage.getItem("endCity")
    : input_endCity.value = "Thành phố/ Tỉnh đích đến";

(localStorage.getItem("date") !=null) ? input_date.value = localStorage.getItem("date")
    : input_date.value = getCurrentDate();

const listTrain_Trip = document.querySelector("#booking-right-body");

console.log(listTrain_Trip);



for(let i = 0; i < 10; i++ ) {
    listTrain_Trip.innerHTML += getTrainEL(123,"1a2b3c");
}