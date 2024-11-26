const infoOrder = JSON.parse(sessionStorage.getItem("infoOrder"));
const trainNameEL = document.querySelector(".name-train");
trainNameEL.innerHTML = infoOrder.trainName;
console.log(infoOrder)

document.querySelector(".day-start").innerHTML = infoOrder.dateStart;
document.querySelector(".hour-start").innerHTML = infoOrder.timeStart;
document.querySelector(".location-start").innerHTML = infoOrder.startCity;

document.querySelector(".day-end").innerHTML = infoOrder.dateEnd;
document.querySelector(".hour-end").innerHTML = infoOrder.timeEnd;
document.querySelector(".location-end").innerHTML = infoOrder.endCity;

document.querySelector(".hour-illus").innerHTML = infoOrder.duration;

document.querySelector(".name-chair").innerHTML = sessionStorage.getItem("nameChairs");
console.log(sessionStorage.getItem("nameChairs"))


const chairHold = JSON.parse(sessionStorage.getItem("chairhold"));
document.querySelector(".numofticket").innerHTML = Object.keys(chairHold).length.toString();
const priceTicketEL = document.querySelector(".priceofTicket");
let tmp1 = parseInt(priceTicketEL.innerText.replace(/\D/g, ''))*Object.keys(chairHold).length + 50000;
console.log(chairHold)
sessionStorage.setItem("amount", tmp1.toString());

document.querySelector(".bill-total-right").innerHTML = tmp1.toLocaleString('vi-VN') + " VND";

document.querySelector("#price-title").innerHTML = tmp1.toLocaleString('vi-VN') + " VND";

const user = JSON.parse(sessionStorage.getItem("userInfo"));
console.log(user);

document.querySelector(".name-user").innerHTML = "Tên: " + user.name;
document.querySelector(".age-user").innerHTML = "Tuổi: " + user.age;
document.querySelector(".gender-user").innerHTML = "Giới tính: " + user.gender;
document.querySelector(".email-user").innerHTML = user.email;

