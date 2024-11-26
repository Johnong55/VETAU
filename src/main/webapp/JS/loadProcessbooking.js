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
const dataFind = JSON.parse(sessionStorage.getItem("findTrain"));
(dataFind.departureCity != null) ? input_startCity.value = localStorage.getItem("startCity")
    : input_startCity.value = "Thành phố/ Tỉnh xuất phát";

(dataFind.arrivalCity != null) ? input_endCity.value = localStorage.getItem("endCity")
    : input_endCity.value = "Thành phố/ Tỉnh đích đến";

(dataFind.departureDate != null) ? input_date.value = localStorage.getItem("date")
    : input_date.value = getCurrentDate();


const listTrain_Trip = document.querySelector("#booking-right-body");

console.log(listTrain_Trip);

function getTrainTrip(data) {
    fetch('/metroway/findtrain', {
        method: "POST",
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify(data)
    })
        .then(response => {
            if (!response.ok) console.log("LOI")
            return response.json()
        })
        .then(data => {
            console.log(data)
            for(let i = 0; i < data.length; i++ ) {
                listTrain_Trip.innerHTML += getTrainEL(data[i]);
            }
        })
        .catch(error => console.log(error))
}

if(!Object.values(dataFind).includes(null)) {
    getTrainTrip(dataFind)
}


const btn_search = document.querySelector(".search-btn");

btn_search.addEventListener('click', function () {
    const data = {
        departureCity: input_startCity.value,
        arrivalCity: input_endCity.value,
        departureDate: input_date.value
    }
    console.log(data)
    getTrainTrip(data)
})
