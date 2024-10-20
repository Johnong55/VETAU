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

if(localStorage.getItem("startCity") !=null) {
    input_startCity.value = localStorage.getItem("startCity")
} else {
    input_startCity.value = "Thành phố/ Tỉnh xuất phát";
}
if(localStorage.getItem("endCity") != null) {
    input_endCity.value = localStorage.getItem("endCity");
} else {
    input_endCity.value = "Thành phố/ Tỉnh đích đến";
}
if(localStorage.getItem("date") !=null) {
    input_date.value = localStorage.getItem("date");
} else {
    input_date.value = getCurrentDate();
}